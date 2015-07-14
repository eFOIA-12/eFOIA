package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.result.g;
import com.google.android.gms.internal.jv;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
   public static final Creator CREATOR = new g();
   private final int CK;
   private final Status Eb;
   private final List VI;

   SessionStopResult(int var1, Status var2, List var3) {
      this.CK = var1;
      this.Eb = var2;
      this.VI = Collections.unmodifiableList(var3);
   }

   public SessionStopResult(Status var1, List var2) {
      this.CK = 3;
      this.Eb = var1;
      this.VI = Collections.unmodifiableList(var2);
   }

   public static SessionStopResult H(Status var0) {
      return new SessionStopResult(var0, Collections.emptyList());
   }

   private boolean b(SessionStopResult var1) {
      return this.Eb.equals(var1.Eb) && jv.equal(this.VI, var1.VI);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionStopResult && this.b((SessionStopResult)var1);
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
      return jv.hashCode(new Object[]{this.Eb, this.VI});
   }

   public String toString() {
      return jv.h(this).a("status", this.Eb).a("sessions", this.VI).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      g.a(this, var1, var2);
   }
}
