package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.t;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
   public static final Creator CREATOR = new t();
   private final int CK;
   private final long LW;
   private final long TO;
   private final List TY;
   private final List VH;
   private final boolean VR;
   private final String Wj;
   private boolean Wk;
   private final List Wl;
   private final String vZ;

   SessionReadRequest(int var1, String var2, String var3, long var4, long var6, List var8, List var9, boolean var10, boolean var11, List var12) {
      this.CK = var1;
      this.Wj = var2;
      this.vZ = var3;
      this.LW = var4;
      this.TO = var6;
      this.TY = Collections.unmodifiableList(var8);
      this.VH = Collections.unmodifiableList(var9);
      this.Wk = var10;
      this.VR = var11;
      this.Wl = var12;
   }

   private SessionReadRequest(SessionReadRequest.Builder var1) {
      this.CK = 3;
      this.Wj = var1.Wj;
      this.vZ = var1.vZ;
      this.LW = var1.LW;
      this.TO = var1.TO;
      this.TY = Collections.unmodifiableList(var1.TY);
      this.VH = Collections.unmodifiableList(var1.VH);
      this.Wk = var1.Wk;
      this.VR = var1.VR;
      this.Wl = Collections.unmodifiableList(var1.Wl);
   }

   // $FF: synthetic method
   SessionReadRequest(SessionReadRequest.Builder var1, Object var2) {
      this(var1);
   }

   private boolean a(SessionReadRequest var1) {
      return jv.equal(this.Wj, var1.Wj) && this.vZ.equals(var1.vZ) && this.LW == var1.LW && this.TO == var1.TO && jv.equal(this.TY, var1.TY) && jv.equal(this.VH, var1.VH) && this.Wk == var1.Wk && this.Wl.equals(var1.Wl) && this.VR == var1.VR;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionReadRequest && this.a((SessionReadRequest)var1);
   }

   public List getDataSources() {
      return this.VH;
   }

   public List getDataTypes() {
      return this.TY;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.TO, TimeUnit.MILLISECONDS);
   }

   public List getExcludedPackages() {
      return this.Wl;
   }

   public String getSessionId() {
      return this.vZ;
   }

   public String getSessionName() {
      return this.Wj;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.LW, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Wj, this.vZ, Long.valueOf(this.LW), Long.valueOf(this.TO)});
   }

   public boolean includeSessionsFromAllApps() {
      return this.Wk;
   }

   public boolean jV() {
      return this.VR;
   }

   public long jo() {
      return this.LW;
   }

   public long jp() {
      return this.TO;
   }

   public boolean kj() {
      return this.Wk;
   }

   public String toString() {
      return jv.h(this).a("sessionName", this.Wj).a("sessionId", this.vZ).a("startTimeMillis", Long.valueOf(this.LW)).a("endTimeMillis", Long.valueOf(this.TO)).a("dataTypes", this.TY).a("dataSources", this.VH).a("sessionsFromAllApps", Boolean.valueOf(this.Wk)).a("excludedPackages", this.Wl).a("useServer", Boolean.valueOf(this.VR)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      t.a(this, var1, var2);
   }

   public static class Builder {
      private long LW = 0L;
      private long TO = 0L;
      private List TY = new ArrayList();
      private List VH = new ArrayList();
      private boolean VR = false;
      private String Wj;
      private boolean Wk = false;
      private List Wl = new ArrayList();
      private String vZ;

      public SessionReadRequest build() {
         boolean var1;
         if(this.LW > 0L) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.b(var1, "Invalid start time: %s", new Object[]{Long.valueOf(this.LW)});
         if(this.TO > 0L && this.TO > this.LW) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.b(var1, "Invalid end time: %s", new Object[]{Long.valueOf(this.TO)});
         return new SessionReadRequest(this, null);
      }

      public SessionReadRequest.Builder enableServerQueries() {
         this.VR = true;
         return this;
      }

      public SessionReadRequest.Builder excludePackage(String var1) {
         jx.b((Object)var1, "Attempting to use a null package name");
         if(!this.Wl.contains(var1)) {
            this.Wl.add(var1);
         }

         return this;
      }

      public SessionReadRequest.Builder read(DataSource var1) {
         jx.b((Object)var1, "Attempting to add a null data source");
         if(!this.VH.contains(var1)) {
            this.VH.add(var1);
         }

         return this;
      }

      public SessionReadRequest.Builder read(DataType var1) {
         jx.b((Object)var1, "Attempting to use a null data type");
         if(!this.TY.contains(var1)) {
            this.TY.add(var1);
         }

         return this;
      }

      public SessionReadRequest.Builder readSessionsFromAllApps() {
         this.Wk = true;
         return this;
      }

      public SessionReadRequest.Builder setSessionId(String var1) {
         this.vZ = var1;
         return this;
      }

      public SessionReadRequest.Builder setSessionName(String var1) {
         this.Wj = var1;
         return this;
      }

      public SessionReadRequest.Builder setTimeInterval(long var1, long var3, TimeUnit var5) {
         this.LW = var5.toMillis(var1);
         this.TO = var5.toMillis(var3);
         return this;
      }
   }
}
