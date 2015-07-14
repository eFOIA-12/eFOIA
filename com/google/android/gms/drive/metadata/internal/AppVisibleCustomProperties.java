package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable {
   public static final Creator CREATOR = new a();
   public static final AppVisibleCustomProperties Rd = (new AppVisibleCustomProperties.a()).iW();
   final int CK;
   final List Re;

   AppVisibleCustomProperties(int var1, Collection var2) {
      this.CK = var1;
      jx.i(var2);
      this.Re = new ArrayList(var2);
   }

   private AppVisibleCustomProperties(Collection var1) {
      this(1, var1);
   }

   // $FF: synthetic method
   AppVisibleCustomProperties(Collection var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public Map iV() {
      HashMap var1 = new HashMap(this.Re.size());
      Iterator var2 = this.Re.iterator();

      while(var2.hasNext()) {
         CustomProperty var3 = (CustomProperty)var2.next();
         var1.put(var3.iX(), var3.getValue());
      }

      return Collections.unmodifiableMap(var1);
   }

   public Iterator iterator() {
      return this.Re.iterator();
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }

   public static class a {
      private final Map Rf = new HashMap();

      public AppVisibleCustomProperties.a a(CustomPropertyKey var1, String var2) {
         jx.b((Object)var1, "key");
         this.Rf.put(var1, new CustomProperty(var1, var2));
         return this;
      }

      public AppVisibleCustomProperties iW() {
         return new AppVisibleCustomProperties(this.Rf.values(), null);
      }
   }
}
