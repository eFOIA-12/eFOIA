package com.crashlytics.android.core;

import com.crashlytics.android.core.ByteString;
import com.crashlytics.android.core.CodedOutputStream;
import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import java.io.IOException;

class NativeCrashWriter {
   private static final SignalData DEFAULT_SIGNAL = new SignalData("", "", 0L);
   private static final NativeCrashWriter.BinaryImageMessage[] EMPTY_BINARY_IMAGE_MESSAGES = new NativeCrashWriter.BinaryImageMessage[0];
   private static final NativeCrashWriter.ProtobufMessage[] EMPTY_CHILDREN = new NativeCrashWriter.ProtobufMessage[0];
   private static final NativeCrashWriter.CustomAttributeMessage[] EMPTY_CUSTOM_ATTRIBUTE_MESSAGES = new NativeCrashWriter.CustomAttributeMessage[0];
   private static final NativeCrashWriter.FrameMessage[] EMPTY_FRAME_MESSAGES = new NativeCrashWriter.FrameMessage[0];
   private static final NativeCrashWriter.ThreadMessage[] EMPTY_THREAD_MESSAGES = new NativeCrashWriter.ThreadMessage[0];
   static final String NDK_CRASH_TYPE = "ndk-crash";

   private static NativeCrashWriter.RepeatedMessage createBinaryImagesMessage(BinaryImageData[] var0) {
      NativeCrashWriter.BinaryImageMessage[] var2;
      if(var0 != null) {
         var2 = new NativeCrashWriter.BinaryImageMessage[var0.length];
      } else {
         var2 = EMPTY_BINARY_IMAGE_MESSAGES;
      }

      for(int var1 = 0; var1 < var2.length; ++var1) {
         var2[var1] = new NativeCrashWriter.BinaryImageMessage(var0[var1]);
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   private static NativeCrashWriter.RepeatedMessage createCustomAttributesMessage(CustomAttributeData[] var0) {
      NativeCrashWriter.CustomAttributeMessage[] var2;
      if(var0 != null) {
         var2 = new NativeCrashWriter.CustomAttributeMessage[var0.length];
      } else {
         var2 = EMPTY_CUSTOM_ATTRIBUTE_MESSAGES;
      }

      for(int var1 = 0; var1 < var2.length; ++var1) {
         var2[var1] = new NativeCrashWriter.CustomAttributeMessage(var0[var1]);
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   private static NativeCrashWriter.DeviceMessage createDeviceMessage(DeviceData var0) {
      return new NativeCrashWriter.DeviceMessage((float)var0.batteryCapacity / 100.0F, var0.batteryVelocity, var0.proximity, var0.orientation, var0.totalPhysicalMemory - var0.availablePhysicalMemory, var0.totalInternalStorage - var0.availableInternalStorage);
   }

   private static NativeCrashWriter.RepeatedMessage createFramesMessage(ThreadData.FrameData[] var0) {
      NativeCrashWriter.FrameMessage[] var2;
      if(var0 != null) {
         var2 = new NativeCrashWriter.FrameMessage[var0.length];
      } else {
         var2 = EMPTY_FRAME_MESSAGES;
      }

      for(int var1 = 0; var1 < var2.length; ++var1) {
         var2[var1] = new NativeCrashWriter.FrameMessage(var0[var1]);
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   private static NativeCrashWriter.RepeatedMessage createThreadsMessage(ThreadData[] var0) {
      NativeCrashWriter.ThreadMessage[] var2;
      if(var0 != null) {
         var2 = new NativeCrashWriter.ThreadMessage[var0.length];
      } else {
         var2 = EMPTY_THREAD_MESSAGES;
      }

      for(int var1 = 0; var1 < var2.length; ++var1) {
         ThreadData var3 = var0[var1];
         var2[var1] = new NativeCrashWriter.ThreadMessage(var3, createFramesMessage(var3.frames));
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   private static NativeCrashWriter.EventMessage readCrashEventData(SessionEventData var0) throws IOException {
      SignalData var1;
      if(var0.signal != null) {
         var1 = var0.signal;
      } else {
         var1 = DEFAULT_SIGNAL;
      }

      NativeCrashWriter.ApplicationMessage var3 = new NativeCrashWriter.ApplicationMessage(new NativeCrashWriter.ExecutionMessage(new NativeCrashWriter.SignalMessage(var1), createThreadsMessage(var0.threads), createBinaryImagesMessage(var0.binaryImages)), createCustomAttributesMessage(var0.customAttributes));
      NativeCrashWriter.DeviceMessage var2 = createDeviceMessage(var0.deviceData);
      return new NativeCrashWriter.EventMessage(var0.timestamp, "ndk-crash", var3, var2);
   }

   public static void writeNativeCrash(SessionEventData var0, CodedOutputStream var1) throws IOException {
      readCrashEventData(var0).write(var1);
   }

   private static final class ApplicationMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 3;

      public ApplicationMessage(NativeCrashWriter.ExecutionMessage var1, NativeCrashWriter.RepeatedMessage var2) {
         super(3, new NativeCrashWriter.ProtobufMessage[]{var1, var2});
      }
   }

   private static final class BinaryImageMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 4;
      private final long baseAddr;
      private final String filePath;
      private final long imageSize;
      private final String uuid;

      public BinaryImageMessage(BinaryImageData var1) {
         super(4, new NativeCrashWriter.ProtobufMessage[0]);
         this.baseAddr = var1.baseAddress;
         this.imageSize = var1.size;
         this.filePath = var1.path;
         this.uuid = var1.id;
      }

      public int getPropertiesSize() {
         int var1 = CodedOutputStream.computeUInt64Size(1, this.baseAddr);
         int var2 = CodedOutputStream.computeUInt64Size(2, this.imageSize);
         return CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(this.filePath)) + var1 + var2 + CodedOutputStream.computeBytesSize(4, ByteString.copyFromUtf8(this.uuid));
      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
         var1.writeUInt64(1, this.baseAddr);
         var1.writeUInt64(2, this.imageSize);
         var1.writeBytes(3, ByteString.copyFromUtf8(this.filePath));
         var1.writeBytes(4, ByteString.copyFromUtf8(this.uuid));
      }
   }

   private static final class CustomAttributeMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 2;
      private final String key;
      private final String value;

      public CustomAttributeMessage(CustomAttributeData var1) {
         super(2, new NativeCrashWriter.ProtobufMessage[0]);
         this.key = var1.key;
         this.value = var1.value;
      }

      public int getPropertiesSize() {
         int var1 = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.key));
         String var2;
         if(this.value == null) {
            var2 = "";
         } else {
            var2 = this.value;
         }

         return var1 + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(var2));
      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
         var1.writeBytes(1, ByteString.copyFromUtf8(this.key));
         String var2;
         if(this.value == null) {
            var2 = "";
         } else {
            var2 = this.value;
         }

         var1.writeBytes(2, ByteString.copyFromUtf8(var2));
      }
   }

   private static final class DeviceMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 5;
      private final float batteryLevel;
      private final int batteryVelocity;
      private final long diskUsed;
      private final int orientation;
      private final boolean proximityOn;
      private final long ramUsed;

      public DeviceMessage(float var1, int var2, boolean var3, int var4, long var5, long var7) {
         super(5, new NativeCrashWriter.ProtobufMessage[0]);
         this.batteryLevel = var1;
         this.batteryVelocity = var2;
         this.proximityOn = var3;
         this.orientation = var4;
         this.ramUsed = var5;
         this.diskUsed = var7;
      }

      public int getPropertiesSize() {
         return 0 + CodedOutputStream.computeFloatSize(1, this.batteryLevel) + CodedOutputStream.computeSInt32Size(2, this.batteryVelocity) + CodedOutputStream.computeBoolSize(3, this.proximityOn) + CodedOutputStream.computeUInt32Size(4, this.orientation) + CodedOutputStream.computeUInt64Size(5, this.ramUsed) + CodedOutputStream.computeUInt64Size(6, this.diskUsed);
      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
         var1.writeFloat(1, this.batteryLevel);
         var1.writeSInt32(2, this.batteryVelocity);
         var1.writeBool(3, this.proximityOn);
         var1.writeUInt32(4, this.orientation);
         var1.writeUInt64(5, this.ramUsed);
         var1.writeUInt64(6, this.diskUsed);
      }
   }

   private static final class EventMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 10;
      private final String crashType;
      private final long time;

      public EventMessage(long var1, String var3, NativeCrashWriter.ApplicationMessage var4, NativeCrashWriter.DeviceMessage var5) {
         super(10, new NativeCrashWriter.ProtobufMessage[]{var4, var5});
         this.time = var1;
         this.crashType = var3;
      }

      public int getPropertiesSize() {
         return CodedOutputStream.computeUInt64Size(1, this.time) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.crashType));
      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
         var1.writeUInt64(1, this.time);
         var1.writeBytes(2, ByteString.copyFromUtf8(this.crashType));
      }
   }

   private static final class ExecutionMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 1;

      public ExecutionMessage(NativeCrashWriter.SignalMessage var1, NativeCrashWriter.RepeatedMessage var2, NativeCrashWriter.RepeatedMessage var3) {
         super(1, new NativeCrashWriter.ProtobufMessage[]{var2, var1, var3});
      }
   }

   private static final class FrameMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 3;
      private final long address;
      private final String file;
      private final int importance;
      private final long offset;
      private final String symbol;

      public FrameMessage(ThreadData.FrameData var1) {
         super(3, new NativeCrashWriter.ProtobufMessage[0]);
         this.address = var1.address;
         this.symbol = var1.symbol;
         this.file = var1.file;
         this.offset = var1.offset;
         this.importance = var1.importance;
      }

      public int getPropertiesSize() {
         return CodedOutputStream.computeUInt64Size(1, this.address) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.symbol)) + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(this.file)) + CodedOutputStream.computeUInt64Size(4, this.offset) + CodedOutputStream.computeUInt32Size(5, this.importance);
      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
         var1.writeUInt64(1, this.address);
         var1.writeBytes(2, ByteString.copyFromUtf8(this.symbol));
         var1.writeBytes(3, ByteString.copyFromUtf8(this.file));
         var1.writeUInt64(4, this.offset);
         var1.writeUInt32(5, this.importance);
      }
   }

   private abstract static class ProtobufMessage {
      private final NativeCrashWriter.ProtobufMessage[] children;
      private final int tag;

      public ProtobufMessage(int var1, NativeCrashWriter.ProtobufMessage... var2) {
         this.tag = var1;
         if(var2 == null) {
            var2 = NativeCrashWriter.EMPTY_CHILDREN;
         }

         this.children = var2;
      }

      public int getPropertiesSize() {
         return 0;
      }

      public int getSize() {
         int var1 = this.getSizeNoTag();
         return var1 + CodedOutputStream.computeRawVarint32Size(var1) + CodedOutputStream.computeTagSize(this.tag);
      }

      public int getSizeNoTag() {
         int var2 = this.getPropertiesSize();
         NativeCrashWriter.ProtobufMessage[] var4 = this.children;
         int var3 = var4.length;

         for(int var1 = 0; var1 < var3; ++var1) {
            var2 += var4[var1].getSize();
         }

         return var2;
      }

      public void write(CodedOutputStream var1) throws IOException {
         var1.writeTag(this.tag, 2);
         var1.writeRawVarint32(this.getSizeNoTag());
         this.writeProperties(var1);
         NativeCrashWriter.ProtobufMessage[] var4 = this.children;
         int var3 = var4.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            var4[var2].write(var1);
         }

      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
      }
   }

   private static final class RepeatedMessage extends NativeCrashWriter.ProtobufMessage {
      private final NativeCrashWriter.ProtobufMessage[] messages;

      public RepeatedMessage(NativeCrashWriter.ProtobufMessage... var1) {
         super(0, new NativeCrashWriter.ProtobufMessage[0]);
         this.messages = var1;
      }

      public int getSize() {
         int var2 = 0;
         NativeCrashWriter.ProtobufMessage[] var4 = this.messages;
         int var3 = var4.length;

         for(int var1 = 0; var1 < var3; ++var1) {
            var2 += var4[var1].getSize();
         }

         return var2;
      }

      public void write(CodedOutputStream var1) throws IOException {
         NativeCrashWriter.ProtobufMessage[] var4 = this.messages;
         int var3 = var4.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            var4[var2].write(var1);
         }

      }
   }

   private static final class SignalMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 3;
      private final long sigAddr;
      private final String sigCode;
      private final String sigName;

      public SignalMessage(SignalData var1) {
         super(3, new NativeCrashWriter.ProtobufMessage[0]);
         this.sigName = var1.name;
         this.sigCode = var1.code;
         this.sigAddr = var1.faultAddress;
      }

      public int getPropertiesSize() {
         return CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.sigName)) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.sigCode)) + CodedOutputStream.computeUInt64Size(3, this.sigAddr);
      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
         var1.writeBytes(1, ByteString.copyFromUtf8(this.sigName));
         var1.writeBytes(2, ByteString.copyFromUtf8(this.sigCode));
         var1.writeUInt64(3, this.sigAddr);
      }
   }

   private static final class ThreadMessage extends NativeCrashWriter.ProtobufMessage {
      private static final int PROTOBUF_TAG = 1;
      private final int importance;
      private final String name;

      public ThreadMessage(ThreadData var1, NativeCrashWriter.RepeatedMessage var2) {
         super(1, new NativeCrashWriter.ProtobufMessage[]{var2});
         this.name = var1.name;
         this.importance = var1.importance;
      }

      private boolean hasName() {
         return this.name != null && this.name.length() > 0;
      }

      public int getPropertiesSize() {
         int var1;
         if(this.hasName()) {
            var1 = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.name));
         } else {
            var1 = 0;
         }

         return CodedOutputStream.computeUInt32Size(2, this.importance) + var1;
      }

      public void writeProperties(CodedOutputStream var1) throws IOException {
         if(this.hasName()) {
            var1.writeBytes(1, ByteString.copyFromUtf8(this.name));
         }

         var1.writeUInt32(2, this.importance);
      }
   }
}
