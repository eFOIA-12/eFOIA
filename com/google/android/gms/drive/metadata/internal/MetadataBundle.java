package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.drive.metadata.internal.h;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
   public static final Creator CREATOR = new h();
   final int CK;
   final Bundle Ri;

   MetadataBundle(int var1, Bundle var2) {
      this.CK = var1;
      this.Ri = (Bundle)jx.i(var2);
      this.Ri.setClassLoader(this.getClass().getClassLoader());
      ArrayList var5 = new ArrayList();
      Iterator var3 = this.Ri.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         if(e.bm(var4) == null) {
            var5.add(var4);
            w.o("MetadataBundle", "Ignored unknown metadata field in bundle: " + var4);
         }
      }

      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         String var7 = (String)var6.next();
         this.Ri.remove(var7);
      }

   }

   private MetadataBundle(Bundle var1) {
      this(1, var1);
   }

   public static MetadataBundle a(MetadataField var0, Object var1) {
      MetadataBundle var2 = iZ();
      var2.b(var0, var1);
      return var2;
   }

   public static MetadataBundle a(MetadataBundle var0) {
      return new MetadataBundle(new Bundle(var0.Ri));
   }

   public static MetadataBundle iZ() {
      return new MetadataBundle(new Bundle());
   }

   public Object a(MetadataField var1) {
      return var1.h(this.Ri);
   }

   public void b(MetadataField var1, Object var2) {
      if(e.bm(var1.getName()) == null) {
         throw new IllegalArgumentException("Unregistered field: " + var1.getName());
      } else {
         var1.a(var2, this.Ri);
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof MetadataBundle)) {
         return false;
      } else {
         MetadataBundle var4 = (MetadataBundle)var1;
         Set var2 = this.Ri.keySet();
         if(!var2.equals(var4.Ri.keySet())) {
            return false;
         } else {
            Iterator var5 = var2.iterator();

            String var3;
            do {
               if(!var5.hasNext()) {
                  return true;
               }

               var3 = (String)var5.next();
            } while(jv.equal(this.Ri.get(var3), var4.Ri.get(var3)));

            return false;
         }
      }
   }

   public int hashCode() {
      Iterator var2 = this.Ri.keySet().iterator();

      int var1;
      String var3;
      for(var1 = 1; var2.hasNext(); var1 = this.Ri.get(var3).hashCode() + var1 * 31) {
         var3 = (String)var2.next();
      }

      return var1;
   }

   public Set ja() {
      HashSet var1 = new HashSet();
      Iterator var2 = this.Ri.keySet().iterator();

      while(var2.hasNext()) {
         var1.add(e.bm((String)var2.next()));
      }

      return var1;
   }

   public void setContext(Context var1) {
      com.google.android.gms.common.data.a var2 = (com.google.android.gms.common.data.a)this.a(ln.RI);
      if(var2 != null) {
         var2.a(var1.getCacheDir());
      }

   }

   public String toString() {
      return "MetadataBundle [values=" + this.Ri + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }
}
