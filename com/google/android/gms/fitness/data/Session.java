package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.a;
import com.google.android.gms.fitness.data.p;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
   public static final Creator CREATOR = new p();
   public static final String EXTRA_SESSION = "vnd.google.fitness.session";
   public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
   private final int CK;
   private final long LW;
   private final long TO;
   private final int TZ;
   private final String UN;
   private final String UO;
   private final a Um;
   private final String mName;

   Session(int var1, long var2, long var4, String var6, String var7, String var8, int var9, a var10) {
      this.CK = var1;
      this.LW = var2;
      this.TO = var4;
      this.mName = var6;
      this.UN = var7;
      this.UO = var8;
      this.TZ = var9;
      this.Um = var10;
   }

   private Session(Session.Builder var1) {
      this.CK = 2;
      this.LW = var1.LW;
      this.TO = var1.TO;
      this.mName = var1.mName;
      this.UN = var1.UN;
      this.UO = var1.UO;
      this.TZ = var1.TZ;
      this.Um = var1.Um;
   }

   // $FF: synthetic method
   Session(Session.Builder var1, Object var2) {
      this(var1);
   }

   private boolean a(Session var1) {
      return this.LW == var1.LW && this.TO == var1.TO && jv.equal(this.mName, var1.mName) && jv.equal(this.UN, var1.UN) && jv.equal(this.UO, var1.UO) && jv.equal(this.Um, var1.Um) && this.TZ == var1.TZ;
   }

   public static Session extract(Intent var0) {
      return var0 == null?null:(Session)com.google.android.gms.common.internal.safeparcel.c.a(var0, "vnd.google.fitness.session", CREATOR);
   }

   public static String getMimeType(String var0) {
      return "vnd.google.fitness.session/" + var0;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof Session && this.a((Session)var1);
   }

   public String getActivity() {
      return FitnessActivities.getName(this.TZ);
   }

   public String getAppPackageName() {
      return this.Um == null?null:this.Um.getPackageName();
   }

   public String getDescription() {
      return this.UO;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.TO, TimeUnit.MILLISECONDS);
   }

   public String getIdentifier() {
      return this.UN;
   }

   public String getName() {
      return this.mName;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.LW, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Long.valueOf(this.LW), Long.valueOf(this.TO), this.UN});
   }

   public boolean isOngoing() {
      return this.TO == 0L;
   }

   public int jm() {
      return this.TZ;
   }

   public long jo() {
      return this.LW;
   }

   public long jp() {
      return this.TO;
   }

   public a jx() {
      return this.Um;
   }

   public String toString() {
      return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("name", this.mName).a("identifier", this.UN).a("description", this.UO).a("activity", Integer.valueOf(this.TZ)).a("application", this.Um).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      p.a(this, var1, var2);
   }

   public static class Builder {
      private long LW = 0L;
      private long TO = 0L;
      private int TZ = 4;
      private String UN;
      private String UO;
      private a Um;
      private String mName = null;

      public Session build() {
         boolean var2 = false;
         boolean var1;
         if(this.LW > 0L) {
            var1 = true;
         } else {
            var1 = false;
         }

         label24: {
            jx.a(var1, "Start time should be specified.");
            if(this.TO != 0L) {
               var1 = var2;
               if(this.TO <= this.LW) {
                  break label24;
               }
            }

            var1 = true;
         }

         jx.a(var1, "End time should be later than start time.");
         if(this.UN == null) {
            StringBuilder var4 = new StringBuilder();
            String var3;
            if(this.mName == null) {
               var3 = "";
            } else {
               var3 = this.mName;
            }

            this.UN = var4.append(var3).append(this.LW).toString();
         }

         return new Session(this, null);
      }

      public Session.Builder cV(int var1) {
         this.TZ = var1;
         return this;
      }

      public Session.Builder setActivity(String var1) {
         return this.cV(FitnessActivities.bs(var1));
      }

      public Session.Builder setDescription(String var1) {
         boolean var2;
         if(var1.length() <= 1000) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Session description cannot exceed %d characters", new Object[]{Integer.valueOf(1000)});
         this.UO = var1;
         return this;
      }

      public Session.Builder setEndTime(long var1, TimeUnit var3) {
         boolean var4;
         if(var1 >= 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.a(var4, "End time should be positive.");
         this.TO = var3.toMillis(var1);
         return this;
      }

      public Session.Builder setIdentifier(String var1) {
         boolean var2;
         if(var1 != null && TextUtils.getTrimmedLength(var1) > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.L(var2);
         this.UN = var1;
         return this;
      }

      public Session.Builder setName(String var1) {
         boolean var2;
         if(var1.length() <= 100) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Session name cannot exceed %d characters", new Object[]{Integer.valueOf(100)});
         this.mName = var1;
         return this;
      }

      public Session.Builder setStartTime(long var1, TimeUnit var3) {
         boolean var4;
         if(var1 > 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.a(var4, "Start time should be positive.");
         this.LW = var3.toMillis(var1);
         return this;
      }
   }
}
