package com.google.android.gms.tagmanager;

class dh extends Number implements Comparable {
   private double atZ;
   private long aua;
   private boolean aub;

   private dh(double var1) {
      this.atZ = var1;
      this.aub = false;
   }

   private dh(long var1) {
      this.aua = var1;
      this.aub = true;
   }

   public static dh a(Double var0) {
      return new dh(var0.doubleValue());
   }

   public static dh cY(String var0) throws NumberFormatException {
      dh var1;
      try {
         var1 = new dh(Long.parseLong(var0));
         return var1;
      } catch (NumberFormatException var3) {
         try {
            var1 = new dh(Double.parseDouble(var0));
            return var1;
         } catch (NumberFormatException var2) {
            throw new NumberFormatException(var0 + " is not a valid TypedNumber");
         }
      }
   }

   public static dh z(long var0) {
      return new dh(var0);
   }

   public int a(dh var1) {
      return this.qR() && var1.qR()?(new Long(this.aua)).compareTo(Long.valueOf(var1.aua)):Double.compare(this.doubleValue(), var1.doubleValue());
   }

   public byte byteValue() {
      return (byte)((int)this.longValue());
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((dh)var1);
   }

   public double doubleValue() {
      return this.qR()?(double)this.aua:this.atZ;
   }

   public boolean equals(Object var1) {
      return var1 instanceof dh && this.a((dh)var1) == 0;
   }

   public float floatValue() {
      return (float)this.doubleValue();
   }

   public int hashCode() {
      return (new Long(this.longValue())).hashCode();
   }

   public int intValue() {
      return this.qT();
   }

   public long longValue() {
      return this.qS();
   }

   public boolean qQ() {
      return !this.qR();
   }

   public boolean qR() {
      return this.aub;
   }

   public long qS() {
      return this.qR()?this.aua:(long)this.atZ;
   }

   public int qT() {
      return (int)this.longValue();
   }

   public short qU() {
      return (short)((int)this.longValue());
   }

   public short shortValue() {
      return this.qU();
   }

   public String toString() {
      return this.qR()?Long.toString(this.aua):Double.toString(this.atZ);
   }
}
