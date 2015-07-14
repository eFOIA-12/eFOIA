package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.d;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
   public static final Creator CREATOR = new d();
   private final int CK;
   private final long LW;
   private final long TO;
   private final List TY;
   private final List VH;
   private final List VI;
   private final boolean VJ;
   private final boolean VK;

   DataDeleteRequest(int var1, long var2, long var4, List var6, List var7, List var8, boolean var9, boolean var10) {
      this.CK = var1;
      this.LW = var2;
      this.TO = var4;
      this.VH = Collections.unmodifiableList(var6);
      this.TY = Collections.unmodifiableList(var7);
      this.VI = var8;
      this.VJ = var9;
      this.VK = var10;
   }

   private DataDeleteRequest(DataDeleteRequest.Builder var1) {
      this.CK = 1;
      this.LW = var1.LW;
      this.TO = var1.TO;
      this.VH = Collections.unmodifiableList(var1.VH);
      this.TY = Collections.unmodifiableList(var1.TY);
      this.VI = Collections.unmodifiableList(var1.VI);
      this.VJ = var1.VJ;
      this.VK = var1.VK;
   }

   // $FF: synthetic method
   DataDeleteRequest(DataDeleteRequest.Builder var1, Object var2) {
      this(var1);
   }

   private boolean a(DataDeleteRequest var1) {
      return this.LW == var1.LW && this.TO == var1.TO && jv.equal(this.VH, var1.VH) && jv.equal(this.TY, var1.TY) && jv.equal(this.VI, var1.VI) && this.VJ == var1.VJ && this.VK == var1.VK;
   }

   public boolean deleteAllData() {
      return this.VJ;
   }

   public boolean deleteAllSessions() {
      return this.VK;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataDeleteRequest && this.a((DataDeleteRequest)var1);
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

   public List getSessions() {
      return this.VI;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.LW, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Long.valueOf(this.LW), Long.valueOf(this.TO)});
   }

   public boolean jR() {
      return this.VJ;
   }

   public boolean jS() {
      return this.VK;
   }

   public long jo() {
      return this.LW;
   }

   public long jp() {
      return this.TO;
   }

   public String toString() {
      return jv.h(this).a("startTimeMillis", Long.valueOf(this.LW)).a("endTimeMillis", Long.valueOf(this.TO)).a("dataSources", this.VH).a("dateTypes", this.TY).a("sessions", this.VI).a("deleteAllData", Boolean.valueOf(this.VJ)).a("deleteAllSessions", Boolean.valueOf(this.VK)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }

   public static class Builder {
      private long LW;
      private long TO;
      private List TY = new ArrayList();
      private List VH = new ArrayList();
      private List VI = new ArrayList();
      private boolean VJ = false;
      private boolean VK = false;

      private void jT() {
         boolean var1;
         Session var3;
         if(!this.VI.isEmpty()) {
            for(Iterator var2 = this.VI.iterator(); var2.hasNext(); jx.a(var1, "Session %s is outside the time interval [%d, %d]", new Object[]{var3, Long.valueOf(this.LW), Long.valueOf(this.TO)})) {
               var3 = (Session)var2.next();
               if(var3.getStartTime(TimeUnit.MILLISECONDS) >= this.LW && var3.getEndTime(TimeUnit.MILLISECONDS) <= this.TO) {
                  var1 = true;
               } else {
                  var1 = false;
               }
            }
         }

      }

      public DataDeleteRequest.Builder addDataSource(DataSource var1) {
         boolean var3 = true;
         boolean var2;
         if(!this.VJ) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "All data is already marked for deletion");
         if(var1 != null) {
            var2 = var3;
         } else {
            var2 = false;
         }

         jx.b(var2, "Must specify a valid data source");
         if(!this.VH.contains(var1)) {
            this.VH.add(var1);
         }

         return this;
      }

      public DataDeleteRequest.Builder addDataType(DataType var1) {
         boolean var3 = true;
         boolean var2;
         if(!this.VJ) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "All data is already marked for deletion");
         if(var1 != null) {
            var2 = var3;
         } else {
            var2 = false;
         }

         jx.b(var2, "Must specify a valid data type");
         if(!this.TY.contains(var1)) {
            this.TY.add(var1);
         }

         return this;
      }

      public DataDeleteRequest.Builder addSession(Session var1) {
         boolean var3 = true;
         boolean var2;
         if(!this.VK) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "All sessions already marked for deletion");
         if(var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Must specify a valid session");
         if(var1.getEndTime(TimeUnit.MILLISECONDS) > 0L) {
            var2 = var3;
         } else {
            var2 = false;
         }

         jx.b(var2, "Must specify a session that has already ended");
         this.VI.add(var1);
         return this;
      }

      public DataDeleteRequest build() {
         boolean var4 = false;
         boolean var3;
         if(this.LW > 0L && this.TO > this.LW) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.a(var3, "Must specify a valid time interval");
         boolean var1;
         if(!this.VJ && this.VH.isEmpty() && this.TY.isEmpty()) {
            var1 = false;
         } else {
            var1 = true;
         }

         boolean var2;
         if(!this.VK && this.VI.isEmpty()) {
            var2 = false;
         } else {
            var2 = true;
         }

         label24: {
            if(!var1) {
               var3 = var4;
               if(!var2) {
                  break label24;
               }
            }

            var3 = true;
         }

         jx.a(var3, "No data or session marked for deletion");
         this.jT();
         return new DataDeleteRequest(this, null);
      }

      public DataDeleteRequest.Builder deleteAllData() {
         boolean var1;
         if(this.TY.isEmpty() && this.VH.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.b(var1, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", new Object[]{this.VH, this.TY});
         this.VJ = true;
         return this;
      }

      public DataDeleteRequest.Builder deleteAllSessions() {
         jx.b(this.VI.isEmpty(), "Specific sessions already added for deletion: %s", new Object[]{this.VI});
         this.VK = true;
         return this;
      }

      public DataDeleteRequest.Builder setTimeInterval(long var1, long var3, TimeUnit var5) {
         boolean var6;
         if(var1 > 0L) {
            var6 = true;
         } else {
            var6 = false;
         }

         jx.b(var6, "Invalid start time :%d", new Object[]{Long.valueOf(var1)});
         if(var3 > var1) {
            var6 = true;
         } else {
            var6 = false;
         }

         jx.b(var6, "Invalid end time :%d", new Object[]{Long.valueOf(var3)});
         this.LW = var5.toMillis(var1);
         this.TO = var5.toMillis(var3);
         return this;
      }
   }
}
