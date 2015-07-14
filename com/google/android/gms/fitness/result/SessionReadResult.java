package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import com.google.android.gms.fitness.result.f;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
   public static final Creator CREATOR = new f();
   private final int CK;
   private final Status Eb;
   private final List VI;
   private final List Wv;

   SessionReadResult(int var1, List var2, List var3, Status var4) {
      this.CK = var1;
      this.VI = var2;
      this.Wv = Collections.unmodifiableList(var3);
      this.Eb = var4;
   }

   public SessionReadResult(List var1, List var2, Status var3) {
      this.CK = 3;
      this.VI = var1;
      this.Wv = Collections.unmodifiableList(var2);
      this.Eb = var3;
   }

   public static SessionReadResult G(Status var0) {
      return new SessionReadResult(new ArrayList(), new ArrayList(), var0);
   }

   private boolean b(SessionReadResult var1) {
      return this.Eb.equals(var1.Eb) && jv.equal(this.VI, var1.VI) && jv.equal(this.Wv, var1.Wv);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionReadResult && this.b((SessionReadResult)var1);
   }

   public List getDataSet(Session var1) {
      jx.b(this.VI.contains(var1), "Attempting to read data for session %s which was not returned", new Object[]{var1});
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.Wv.iterator();

      while(var3.hasNext()) {
         q var4 = (q)var3.next();
         if(jv.equal(var1, var4.getSession())) {
            var2.add(var4.jH());
         }
      }

      return var2;
   }

   public List getDataSet(Session var1, DataType var2) {
      jx.b(this.VI.contains(var1), "Attempting to read data for session %s which was not returned", new Object[]{var1});
      ArrayList var3 = new ArrayList();
      Iterator var4 = this.Wv.iterator();

      while(var4.hasNext()) {
         q var5 = (q)var4.next();
         if(jv.equal(var1, var5.getSession()) && var2.equals(var5.jH().getDataType())) {
            var3.add(var5.jH());
         }
      }

      return var3;
   }

   public List getSessions() {
      return this.VI;
   }

   public Status getStatus() {
      return this.Eb;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Eb, this.VI, this.Wv});
   }

   public List kv() {
      return this.Wv;
   }

   public String toString() {
      return jv.h(this).a("status", this.Eb).a("sessions", this.VI).a("sessionDataSets", this.Wv).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
