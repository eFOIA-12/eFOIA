package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class a implements MetadataField {
   private final String QY;
   private final Set QZ;
   private final Set Ra;
   private final int Rb;

   protected a(String var1, int var2) {
      this.QY = (String)jx.b((Object)var1, "fieldName");
      this.QZ = Collections.singleton(var1);
      this.Ra = Collections.emptySet();
      this.Rb = var2;
   }

   protected a(String var1, Collection var2, Collection var3, int var4) {
      this.QY = (String)jx.b((Object)var1, "fieldName");
      this.QZ = Collections.unmodifiableSet(new HashSet(var2));
      this.Ra = Collections.unmodifiableSet(new HashSet(var3));
      this.Rb = var4;
   }

   public final Object a(DataHolder var1, int var2, int var3) {
      return this.b(var1, var2, var3)?this.c(var1, var2, var3):null;
   }

   protected abstract void a(Bundle var1, Object var2);

   public final void a(DataHolder var1, MetadataBundle var2, int var3, int var4) {
      jx.b((Object)var1, "dataHolder");
      jx.b((Object)var2, "bundle");
      var2.b(this, this.a(var1, var3, var4));
   }

   public final void a(Object var1, Bundle var2) {
      jx.b((Object)var2, "bundle");
      if(var1 == null) {
         var2.putString(this.getName(), (String)null);
      } else {
         this.a(var2, var1);
      }
   }

   protected boolean b(DataHolder var1, int var2, int var3) {
      Iterator var4 = this.QZ.iterator();

      do {
         if(!var4.hasNext()) {
            return true;
         }
      } while(!var1.h((String)var4.next(), var2, var3));

      return false;
   }

   protected abstract Object c(DataHolder var1, int var2, int var3);

   public final String getName() {
      return this.QY;
   }

   public final Object h(Bundle var1) {
      jx.b((Object)var1, "bundle");
      return var1.get(this.getName()) != null?this.i(var1):null;
   }

   protected abstract Object i(Bundle var1);

   public String toString() {
      return this.QY;
   }
}
