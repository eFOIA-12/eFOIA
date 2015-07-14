package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.crashlytics.android.core.ByteString;
import com.crashlytics.android.core.CodedOutputStream;
import com.crashlytics.android.core.LogFileManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class SessionDataWriter {
   private static final String SIGNAL_DEFAULT = "0";
   private static final ByteString SIGNAL_DEFAULT_BYTE_STRING = ByteString.copyFromUtf8("0");
   private final Context context;
   private StackTraceElement[] exceptionStack;
   private final int maxChainedExceptionsDepth = 8;
   private final ByteString optionalBuildIdBytes;
   private final ByteString packageNameBytes;
   private RunningAppProcessInfo runningAppProcessInfo;
   private List stacks;
   private Thread[] threads;

   public SessionDataWriter(Context var1, String var2, String var3) {
      this.context = var1;
      this.packageNameBytes = ByteString.copyFromUtf8(var3);
      ByteString var4;
      if(var2 == null) {
         var4 = null;
      } else {
         var4 = ByteString.copyFromUtf8(var2.replace("-", ""));
      }

      this.optionalBuildIdBytes = var4;
   }

   private int getBinaryImageSize() {
      int var2 = 0 + CodedOutputStream.computeUInt64Size(1, 0L) + CodedOutputStream.computeUInt64Size(2, 0L) + CodedOutputStream.computeBytesSize(3, this.packageNameBytes);
      int var1 = var2;
      if(this.optionalBuildIdBytes != null) {
         var1 = var2 + CodedOutputStream.computeBytesSize(4, this.optionalBuildIdBytes);
      }

      return var1;
   }

   private int getDeviceIdentifierSize(IdManager.DeviceIdentifierType var1, String var2) {
      return CodedOutputStream.computeEnumSize(1, var1.protobufIndex) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(var2));
   }

   private int getEventAppCustomAttributeSize(String var1, String var2) {
      int var3 = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(var1));
      var1 = var2;
      if(var2 == null) {
         var1 = "";
      }

      return var3 + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(var1));
   }

   private int getEventAppExecutionExceptionSize(Throwable var1, int var2) {
      int var4 = 0 + CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(var1.getClass().getName()));
      String var7 = var1.getLocalizedMessage();
      int var3 = var4;
      if(var7 != null) {
         var3 = var4 + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(var7));
      }

      StackTraceElement[] var8 = var1.getStackTrace();
      int var5 = var8.length;

      for(var4 = 0; var4 < var5; ++var4) {
         int var6 = this.getFrameSize(var8[var4], true);
         var3 += CodedOutputStream.computeTagSize(4) + CodedOutputStream.computeRawVarint32Size(var6) + var6;
      }

      var1 = var1.getCause();
      var4 = var3;
      if(var1 != null) {
         if(var2 >= this.maxChainedExceptionsDepth) {
            for(var2 = 0; var1 != null; ++var2) {
               var1 = var1.getCause();
            }

            return var3 + CodedOutputStream.computeUInt32Size(7, var2);
         }

         var2 = this.getEventAppExecutionExceptionSize(var1, var2 + 1);
         var4 = var3 + CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(var2) + var2;
      }

      return var4;
   }

   private int getEventAppExecutionSignalSize() {
      return 0 + CodedOutputStream.computeBytesSize(1, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeBytesSize(2, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeUInt64Size(3, 0L);
   }

   private int getEventAppExecutionSize(Thread var1, Throwable var2) {
      int var3 = this.getThreadSize(var1, this.exceptionStack, 4, true);
      var3 = 0 + CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(var3) + var3;
      int var5 = this.threads.length;

      int var4;
      int var6;
      for(var4 = 0; var4 < var5; ++var4) {
         var6 = this.getThreadSize(this.threads[var4], (StackTraceElement[])this.stacks.get(var4), 0, false);
         var3 += CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(var6) + var6;
      }

      var4 = this.getEventAppExecutionExceptionSize(var2, 1);
      var5 = CodedOutputStream.computeTagSize(2);
      var6 = CodedOutputStream.computeRawVarint32Size(var4);
      int var7 = this.getEventAppExecutionSignalSize();
      int var8 = CodedOutputStream.computeTagSize(3);
      int var9 = CodedOutputStream.computeRawVarint32Size(var7);
      int var10 = this.getBinaryImageSize();
      return var3 + var5 + var6 + var4 + var8 + var9 + var7 + CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(var10) + var10;
   }

   private int getEventAppSize(Thread var1, Throwable var2, int var3, Map var4) {
      int var5 = this.getEventAppExecutionSize(var1, var2);
      int var6 = 0 + CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(var5) + var5;
      var5 = var6;
      if(var4 != null) {
         Iterator var8 = var4.entrySet().iterator();

         while(true) {
            var5 = var6;
            if(!var8.hasNext()) {
               break;
            }

            Entry var9 = (Entry)var8.next();
            var5 = this.getEventAppCustomAttributeSize((String)var9.getKey(), (String)var9.getValue());
            var6 += CodedOutputStream.computeTagSize(2) + CodedOutputStream.computeRawVarint32Size(var5) + var5;
         }
      }

      var6 = var5;
      if(this.runningAppProcessInfo != null) {
         boolean var7;
         if(this.runningAppProcessInfo.importance != 100) {
            var7 = true;
         } else {
            var7 = false;
         }

         var6 = var5 + CodedOutputStream.computeBoolSize(3, var7);
      }

      return var6 + CodedOutputStream.computeUInt32Size(4, var3);
   }

   private int getEventDeviceSize(float var1, int var2, boolean var3, int var4, long var5, long var7) {
      return 0 + CodedOutputStream.computeFloatSize(1, var1) + CodedOutputStream.computeSInt32Size(2, var2) + CodedOutputStream.computeBoolSize(3, var3) + CodedOutputStream.computeUInt32Size(4, var4) + CodedOutputStream.computeUInt64Size(5, var5) + CodedOutputStream.computeUInt64Size(6, var7);
   }

   private int getEventLogSize(ByteString var1) {
      return CodedOutputStream.computeBytesSize(1, var1);
   }

   private int getFrameSize(StackTraceElement var1, boolean var2) {
      byte var5 = 2;
      int var3;
      if(var1.isNativeMethod()) {
         var3 = 0 + CodedOutputStream.computeUInt64Size(1, (long)Math.max(var1.getLineNumber(), 0));
      } else {
         var3 = 0 + CodedOutputStream.computeUInt64Size(1, 0L);
      }

      int var4 = var3 + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(var1.getClassName() + "." + var1.getMethodName()));
      var3 = var4;
      if(var1.getFileName() != null) {
         var3 = var4 + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(var1.getFileName()));
      }

      var4 = var3;
      if(!var1.isNativeMethod()) {
         var4 = var3;
         if(var1.getLineNumber() > 0) {
            var4 = var3 + CodedOutputStream.computeUInt64Size(4, (long)var1.getLineNumber());
         }
      }

      byte var6;
      if(var2) {
         var6 = var5;
      } else {
         var6 = 0;
      }

      return var4 + CodedOutputStream.computeUInt32Size(5, var6);
   }

   private int getSessionAppOrgSize() {
      return 0 + CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8((new ApiKey()).getValue(this.context)));
   }

   private int getSessionAppSize(ByteString var1, ByteString var2, ByteString var3, ByteString var4, int var5) {
      int var6 = CodedOutputStream.computeBytesSize(1, var1);
      int var7 = CodedOutputStream.computeBytesSize(2, var2);
      int var8 = CodedOutputStream.computeBytesSize(3, var3);
      int var9 = this.getSessionAppOrgSize();
      return 0 + var6 + var7 + var8 + CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(var9) + var9 + CodedOutputStream.computeBytesSize(6, var4) + CodedOutputStream.computeEnumSize(10, var5);
   }

   private int getSessionDeviceSize(int var1, ByteString var2, ByteString var3, int var4, long var5, long var7, boolean var9, Map var10, int var11, ByteString var12, ByteString var13) {
      int var14 = CodedOutputStream.computeBytesSize(1, var2);
      int var15 = CodedOutputStream.computeEnumSize(3, var1);
      if(var3 == null) {
         var1 = 0;
      } else {
         var1 = CodedOutputStream.computeBytesSize(4, var3);
      }

      var1 = 0 + var14 + var15 + var1 + CodedOutputStream.computeUInt32Size(5, var4) + CodedOutputStream.computeUInt64Size(6, var5) + CodedOutputStream.computeUInt64Size(7, var7) + CodedOutputStream.computeBoolSize(10, var9);
      var4 = var1;
      if(var10 != null) {
         Iterator var16 = var10.entrySet().iterator();

         while(true) {
            var4 = var1;
            if(!var16.hasNext()) {
               break;
            }

            Entry var17 = (Entry)var16.next();
            var4 = this.getDeviceIdentifierSize((IdManager.DeviceIdentifierType)var17.getKey(), (String)var17.getValue());
            var1 += CodedOutputStream.computeTagSize(11) + CodedOutputStream.computeRawVarint32Size(var4) + var4;
         }
      }

      var14 = CodedOutputStream.computeUInt32Size(12, var11);
      if(var12 == null) {
         var1 = 0;
      } else {
         var1 = CodedOutputStream.computeBytesSize(13, var12);
      }

      if(var13 == null) {
         var11 = 0;
      } else {
         var11 = CodedOutputStream.computeBytesSize(14, var13);
      }

      return var4 + var14 + var1 + var11;
   }

   private int getSessionEventSize(Thread var1, Throwable var2, String var3, long var4, Map var6, float var7, int var8, boolean var9, int var10, long var11, long var13, ByteString var15) {
      int var16 = CodedOutputStream.computeUInt64Size(1, var4);
      int var17 = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(var3));
      int var18 = this.getEventAppSize(var1, var2, var10, var6);
      int var19 = CodedOutputStream.computeTagSize(3);
      int var20 = CodedOutputStream.computeRawVarint32Size(var18);
      var8 = this.getEventDeviceSize(var7, var8, var9, var10, var11, var13);
      var10 = 0 + var16 + var17 + var19 + var20 + var18 + CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(var8) + var8;
      var8 = var10;
      if(var15 != null) {
         var8 = this.getEventLogSize(var15);
         var8 = var10 + CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(var8) + var8;
      }

      return var8;
   }

   private int getSessionOSSize(ByteString var1, ByteString var2, boolean var3) {
      return 0 + CodedOutputStream.computeEnumSize(1, 3) + CodedOutputStream.computeBytesSize(2, var1) + CodedOutputStream.computeBytesSize(3, var2) + CodedOutputStream.computeBoolSize(4, var3);
   }

   private int getThreadSize(Thread var1, StackTraceElement[] var2, int var3, boolean var4) {
      int var5 = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(var1.getName())) + CodedOutputStream.computeUInt32Size(2, var3);
      int var6 = var2.length;

      for(var3 = 0; var3 < var6; ++var3) {
         int var7 = this.getFrameSize(var2[var3], var4);
         var5 += CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(var7) + var7;
      }

      return var5;
   }

   private ByteString stringToByteString(String var1) {
      return var1 == null?null:ByteString.copyFromUtf8(var1);
   }

   private void writeFrame(CodedOutputStream var1, int var2, StackTraceElement var3, boolean var4) throws Exception {
      byte var5 = 4;
      var1.writeTag(var2, 2);
      var1.writeRawVarint32(this.getFrameSize(var3, var4));
      if(var3.isNativeMethod()) {
         var1.writeUInt64(1, (long)Math.max(var3.getLineNumber(), 0));
      } else {
         var1.writeUInt64(1, 0L);
      }

      var1.writeBytes(2, ByteString.copyFromUtf8(var3.getClassName() + "." + var3.getMethodName()));
      if(var3.getFileName() != null) {
         var1.writeBytes(3, ByteString.copyFromUtf8(var3.getFileName()));
      }

      if(!var3.isNativeMethod() && var3.getLineNumber() > 0) {
         var1.writeUInt64(4, (long)var3.getLineNumber());
      }

      byte var6;
      if(var4) {
         var6 = var5;
      } else {
         var6 = 0;
      }

      var1.writeUInt32(5, var6);
   }

   private void writeSessionEventApp(CodedOutputStream var1, Thread var2, Throwable var3, int var4, Map var5) throws Exception {
      var1.writeTag(3, 2);
      var1.writeRawVarint32(this.getEventAppSize(var2, var3, var4, var5));
      this.writeSessionEventAppExecution(var1, var2, var3);
      if(var5 != null && !var5.isEmpty()) {
         this.writeSessionEventAppCustomAttributes(var1, var5);
      }

      if(this.runningAppProcessInfo != null) {
         boolean var6;
         if(this.runningAppProcessInfo.importance != 100) {
            var6 = true;
         } else {
            var6 = false;
         }

         var1.writeBool(3, var6);
      }

      var1.writeUInt32(4, var4);
   }

   private void writeSessionEventAppCustomAttributes(CodedOutputStream var1, Map var2) throws Exception {
      String var6;
      for(Iterator var4 = var2.entrySet().iterator(); var4.hasNext(); var1.writeBytes(2, ByteString.copyFromUtf8(var6))) {
         Entry var5 = (Entry)var4.next();
         var1.writeTag(2, 2);
         var1.writeRawVarint32(this.getEventAppCustomAttributeSize((String)var5.getKey(), (String)var5.getValue()));
         var1.writeBytes(1, ByteString.copyFromUtf8((String)var5.getKey()));
         String var3 = (String)var5.getValue();
         var6 = var3;
         if(var3 == null) {
            var6 = "";
         }
      }

   }

   private void writeSessionEventAppExecution(CodedOutputStream var1, Thread var2, Throwable var3) throws Exception {
      var1.writeTag(1, 2);
      var1.writeRawVarint32(this.getEventAppExecutionSize(var2, var3));
      this.writeThread(var1, var2, this.exceptionStack, 4, true);
      int var5 = this.threads.length;

      for(int var4 = 0; var4 < var5; ++var4) {
         this.writeThread(var1, this.threads[var4], (StackTraceElement[])this.stacks.get(var4), 0, false);
      }

      this.writeSessionEventAppExecutionException(var1, var3, 1, 2);
      var1.writeTag(3, 2);
      var1.writeRawVarint32(this.getEventAppExecutionSignalSize());
      var1.writeBytes(1, SIGNAL_DEFAULT_BYTE_STRING);
      var1.writeBytes(2, SIGNAL_DEFAULT_BYTE_STRING);
      var1.writeUInt64(3, 0L);
      var1.writeTag(4, 2);
      var1.writeRawVarint32(this.getBinaryImageSize());
      var1.writeUInt64(1, 0L);
      var1.writeUInt64(2, 0L);
      var1.writeBytes(3, this.packageNameBytes);
      if(this.optionalBuildIdBytes != null) {
         var1.writeBytes(4, this.optionalBuildIdBytes);
      }

   }

   private void writeSessionEventAppExecutionException(CodedOutputStream var1, Throwable var2, int var3, int var4) throws Exception {
      var1.writeTag(var4, 2);
      var1.writeRawVarint32(this.getEventAppExecutionExceptionSize(var2, 1));
      var1.writeBytes(1, ByteString.copyFromUtf8(var2.getClass().getName()));
      String var6 = var2.getLocalizedMessage();
      if(var6 != null) {
         var1.writeBytes(3, ByteString.copyFromUtf8(var6));
      }

      StackTraceElement[] var7 = var2.getStackTrace();
      int var5 = var7.length;

      for(var4 = 0; var4 < var5; ++var4) {
         this.writeFrame(var1, 4, var7[var4], true);
      }

      var2 = var2.getCause();
      if(var2 != null) {
         if(var3 >= this.maxChainedExceptionsDepth) {
            for(var3 = 0; var2 != null; ++var3) {
               var2 = var2.getCause();
            }

            var1.writeUInt32(7, var3);
            return;
         }

         this.writeSessionEventAppExecutionException(var1, var2, var3 + 1, 6);
      }

   }

   private void writeSessionEventDevice(CodedOutputStream var1, float var2, int var3, boolean var4, int var5, long var6, long var8) throws Exception {
      var1.writeTag(5, 2);
      var1.writeRawVarint32(this.getEventDeviceSize(var2, var3, var4, var5, var6, var8));
      var1.writeFloat(1, var2);
      var1.writeSInt32(2, var3);
      var1.writeBool(3, var4);
      var1.writeUInt32(4, var5);
      var1.writeUInt64(5, var6);
      var1.writeUInt64(6, var8);
   }

   private void writeSessionEventLog(CodedOutputStream var1, ByteString var2) throws Exception {
      if(var2 != null) {
         var1.writeTag(6, 2);
         var1.writeRawVarint32(this.getEventLogSize(var2));
         var1.writeBytes(1, var2);
      }

   }

   private void writeThread(CodedOutputStream var1, Thread var2, StackTraceElement[] var3, int var4, boolean var5) throws Exception {
      var1.writeTag(1, 2);
      var1.writeRawVarint32(this.getThreadSize(var2, var3, var4, var5));
      var1.writeBytes(1, ByteString.copyFromUtf8(var2.getName()));
      var1.writeUInt32(2, var4);
      int var6 = var3.length;

      for(var4 = 0; var4 < var6; ++var4) {
         this.writeFrame(var1, 3, var3[var4], var5);
      }

   }

   public void writeBeginSession(CodedOutputStream var1, String var2, String var3, long var4) throws Exception {
      var1.writeBytes(1, ByteString.copyFromUtf8(var3));
      var1.writeBytes(2, ByteString.copyFromUtf8(var2));
      var1.writeUInt64(3, var4);
   }

   public void writeSessionApp(CodedOutputStream var1, String var2, String var3, String var4, String var5, int var6) throws Exception {
      ByteString var7 = ByteString.copyFromUtf8(var2);
      ByteString var8 = ByteString.copyFromUtf8(var3);
      ByteString var9 = ByteString.copyFromUtf8(var4);
      ByteString var10 = ByteString.copyFromUtf8(var5);
      var1.writeTag(7, 2);
      var1.writeRawVarint32(this.getSessionAppSize(var7, var8, var9, var10, var6));
      var1.writeBytes(1, var7);
      var1.writeBytes(2, var8);
      var1.writeBytes(3, var9);
      var1.writeTag(5, 2);
      var1.writeRawVarint32(this.getSessionAppOrgSize());
      var1.writeString(1, (new ApiKey()).getValue(this.context));
      var1.writeBytes(6, var10);
      var1.writeEnum(10, var6);
   }

   public void writeSessionDevice(CodedOutputStream var1, String var2, int var3, String var4, int var5, long var6, long var8, boolean var10, Map var11, int var12, String var13, String var14) throws Exception {
      ByteString var16 = ByteString.copyFromUtf8(var2);
      ByteString var15 = this.stringToByteString(var4);
      ByteString var18 = this.stringToByteString(var14);
      ByteString var20 = this.stringToByteString(var13);
      var1.writeTag(9, 2);
      var1.writeRawVarint32(this.getSessionDeviceSize(var3, var16, var15, var5, var6, var8, var10, var11, var12, var20, var18));
      var1.writeBytes(1, var16);
      var1.writeEnum(3, var3);
      var1.writeBytes(4, var15);
      var1.writeUInt32(5, var5);
      var1.writeUInt64(6, var6);
      var1.writeUInt64(7, var8);
      var1.writeBool(10, var10);
      Iterator var17 = var11.entrySet().iterator();

      while(var17.hasNext()) {
         Entry var19 = (Entry)var17.next();
         var1.writeTag(11, 2);
         var1.writeRawVarint32(this.getDeviceIdentifierSize((IdManager.DeviceIdentifierType)var19.getKey(), (String)var19.getValue()));
         var1.writeEnum(1, ((IdManager.DeviceIdentifierType)var19.getKey()).protobufIndex);
         var1.writeBytes(2, ByteString.copyFromUtf8((String)var19.getValue()));
      }

      var1.writeUInt32(12, var12);
      if(var20 != null) {
         var1.writeBytes(13, var20);
      }

      if(var18 != null) {
         var1.writeBytes(14, var18);
      }

   }

   public void writeSessionEvent(CodedOutputStream var1, long var2, Thread var4, Throwable var5, String var6, Thread[] var7, float var8, int var9, boolean var10, int var11, long var12, long var14, RunningAppProcessInfo var16, List var17, StackTraceElement[] var18, LogFileManager var19, Map var20) throws Exception {
      this.runningAppProcessInfo = var16;
      this.stacks = var17;
      this.exceptionStack = var18;
      this.threads = var7;
      ByteString var21 = var19.getByteStringForLog();
      if(var21 == null) {
         Fabric.getLogger().d("Fabric", "No log data to include with this event.");
      }

      var19.closeLogFile();
      var1.writeTag(10, 2);
      var1.writeRawVarint32(this.getSessionEventSize(var4, var5, var6, var2, var20, var8, var9, var10, var11, var12, var14, var21));
      var1.writeUInt64(1, var2);
      var1.writeBytes(2, ByteString.copyFromUtf8(var6));
      this.writeSessionEventApp(var1, var4, var5, var11, var20);
      this.writeSessionEventDevice(var1, var8, var9, var10, var11, var12, var14);
      this.writeSessionEventLog(var1, var21);
   }

   public void writeSessionOS(CodedOutputStream var1, boolean var2) throws Exception {
      ByteString var3 = ByteString.copyFromUtf8(VERSION.RELEASE);
      ByteString var4 = ByteString.copyFromUtf8(VERSION.CODENAME);
      var1.writeTag(8, 2);
      var1.writeRawVarint32(this.getSessionOSSize(var3, var4, var2));
      var1.writeEnum(1, 3);
      var1.writeBytes(2, var3);
      var1.writeBytes(3, var4);
      var1.writeBool(4, var2);
   }

   public void writeSessionUser(CodedOutputStream var1, String var2, String var3, String var4) throws Exception {
      String var7 = var2;
      if(var2 == null) {
         var7 = "";
      }

      ByteString var9 = ByteString.copyFromUtf8(var7);
      ByteString var10 = this.stringToByteString(var3);
      ByteString var8 = this.stringToByteString(var4);
      int var6 = 0 + CodedOutputStream.computeBytesSize(1, var9);
      int var5 = var6;
      if(var3 != null) {
         var5 = var6 + CodedOutputStream.computeBytesSize(2, var10);
      }

      var6 = var5;
      if(var4 != null) {
         var6 = var5 + CodedOutputStream.computeBytesSize(3, var8);
      }

      var1.writeTag(6, 2);
      var1.writeRawVarint32(var6);
      var1.writeBytes(1, var9);
      if(var3 != null) {
         var1.writeBytes(2, var10);
      }

      if(var4 != null) {
         var1.writeBytes(3, var8);
      }

   }
}
