package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class CLSUUID {
   private static String _clsId;
   private static final AtomicLong _sequenceNumber = new AtomicLong(0L);

   public CLSUUID(IdManager var1) {
      byte[] var2 = new byte[10];
      this.populateTime(var2);
      this.populateSequenceNumber(var2);
      this.populatePID(var2);
      String var3 = CommonUtils.sha1(var1.getAppInstallIdentifier());
      String var4 = CommonUtils.hexify(var2);
      _clsId = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{var4.substring(0, 12), var4.substring(12, 16), var4.subSequence(16, 20), var3.substring(0, 12)}).toUpperCase(Locale.US);
   }

   private static byte[] convertLongToFourByteBuffer(long var0) {
      ByteBuffer var2 = ByteBuffer.allocate(4);
      var2.putInt((int)var0);
      var2.order(ByteOrder.BIG_ENDIAN);
      var2.position(0);
      return var2.array();
   }

   private static byte[] convertLongToTwoByteBuffer(long var0) {
      ByteBuffer var2 = ByteBuffer.allocate(2);
      var2.putShort((short)((int)var0));
      var2.order(ByteOrder.BIG_ENDIAN);
      var2.position(0);
      return var2.array();
   }

   private void populatePID(byte[] var1) {
      byte[] var2 = convertLongToTwoByteBuffer((long)Integer.valueOf(Process.myPid()).shortValue());
      var1[8] = var2[0];
      var1[9] = var2[1];
   }

   private void populateSequenceNumber(byte[] var1) {
      byte[] var2 = convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
      var1[6] = var2[0];
      var1[7] = var2[1];
   }

   private void populateTime(byte[] var1) {
      long var2 = (new Date()).getTime();
      byte[] var4 = convertLongToFourByteBuffer(var2 / 1000L);
      var1[0] = var4[0];
      var1[1] = var4[1];
      var1[2] = var4[2];
      var1[3] = var4[3];
      var4 = convertLongToTwoByteBuffer(var2 % 1000L);
      var1[4] = var4[0];
      var1[5] = var4[1];
   }

   public String toString() {
      return _clsId;
   }
}
