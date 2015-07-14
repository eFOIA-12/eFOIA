package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.b;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice implements SafeParcelable {
   public static final Creator CREATOR = new b();
   private final int CK;
   private String FG;
   String FH;
   private Inet4Address FI;
   private String FJ;
   private String FK;
   private String FL;
   private int FM;
   private List FN;
   private int FO;
   private int FP;

   private CastDevice() {
      this(3, (String)null, (String)null, (String)null, (String)null, (String)null, -1, new ArrayList(), 0, -1);
   }

   CastDevice(int var1, String var2, String var3, String var4, String var5, String var6, int var7, List var8, int var9, int var10) {
      this.CK = var1;
      this.FG = var2;
      this.FH = var3;
      if(this.FH != null) {
         try {
            InetAddress var12 = InetAddress.getByName(this.FH);
            if(var12 instanceof Inet4Address) {
               this.FI = (Inet4Address)var12;
            }
         } catch (UnknownHostException var11) {
            this.FI = null;
         }
      }

      this.FJ = var4;
      this.FK = var5;
      this.FL = var6;
      this.FM = var7;
      this.FN = var8;
      this.FO = var9;
      this.FP = var10;
   }

   public static CastDevice getFromBundle(Bundle var0) {
      if(var0 == null) {
         return null;
      } else {
         var0.setClassLoader(CastDevice.class.getClassLoader());
         return (CastDevice)var0.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof CastDevice)) {
            return false;
         }

         CastDevice var2 = (CastDevice)var1;
         if(this.getDeviceId() == null) {
            if(var2.getDeviceId() != null) {
               return false;
            }
         } else if(!in.a(this.FG, var2.FG) || !in.a(this.FI, var2.FI) || !in.a(this.FK, var2.FK) || !in.a(this.FJ, var2.FJ) || !in.a(this.FL, var2.FL) || this.FM != var2.FM || !in.a(this.FN, var2.FN) || this.FO != var2.FO || this.FP != var2.FP) {
            return false;
         }
      }

      return true;
   }

   public int getCapabilities() {
      return this.FO;
   }

   public String getDeviceId() {
      return this.FG;
   }

   public String getDeviceVersion() {
      return this.FL;
   }

   public String getFriendlyName() {
      return this.FJ;
   }

   public WebImage getIcon(int var1, int var2) {
      WebImage var5 = null;
      if(this.FN.isEmpty()) {
         return null;
      } else if(var1 > 0 && var2 > 0) {
         Iterator var8 = this.FN.iterator();
         WebImage var6 = null;

         while(var8.hasNext()) {
            WebImage var7 = (WebImage)var8.next();
            int var3 = var7.getWidth();
            int var4 = var7.getHeight();
            if(var3 >= var1 && var4 >= var2) {
               if(var6 == null || var6.getWidth() > var3 && var6.getHeight() > var4) {
                  var6 = var7;
               }
            } else if(var3 < var1 && var4 < var2 && (var5 == null || var5.getWidth() < var3 && var5.getHeight() < var4)) {
               var5 = var7;
            }
         }

         if(var6 == null) {
            if(var5 != null) {
               var6 = var5;
            } else {
               var6 = (WebImage)this.FN.get(0);
            }
         }

         return var6;
      } else {
         return (WebImage)this.FN.get(0);
      }
   }

   public List getIcons() {
      return Collections.unmodifiableList(this.FN);
   }

   public Inet4Address getIpAddress() {
      return this.FI;
   }

   public String getModelName() {
      return this.FK;
   }

   public int getServicePort() {
      return this.FM;
   }

   public int getStatus() {
      return this.FP;
   }

   int getVersionCode() {
      return this.CK;
   }

   public boolean hasIcons() {
      return !this.FN.isEmpty();
   }

   public int hashCode() {
      return this.FG == null?0:this.FG.hashCode();
   }

   public boolean isOnLocalNetwork() {
      return !this.FG.startsWith("__cast_nearby__");
   }

   public boolean isSameDevice(CastDevice var1) {
      if(var1 != null) {
         if(this.getDeviceId() != null) {
            return in.a(this.getDeviceId(), var1.getDeviceId());
         }

         if(var1.getDeviceId() == null) {
            return true;
         }
      }

      return false;
   }

   public void putInBundle(Bundle var1) {
      if(var1 != null) {
         var1.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
      }
   }

   public String toString() {
      return String.format("\"%s\" (%s)", new Object[]{this.FJ, this.FG});
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
