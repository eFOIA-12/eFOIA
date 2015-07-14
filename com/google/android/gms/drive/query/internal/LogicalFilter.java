package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.f;
import com.google.android.gms.drive.query.internal.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
   public static final Creator CREATOR = new i();
   final int CK;
   private List Sc;
   final Operator Sh;
   final List Su;

   LogicalFilter(int var1, Operator var2, List var3) {
      this.CK = var1;
      this.Sh = var2;
      this.Su = var3;
   }

   public LogicalFilter(Operator var1, Filter var2, Filter... var3) {
      this.CK = 1;
      this.Sh = var1;
      this.Su = new ArrayList(var3.length + 1);
      this.Su.add(new FilterHolder(var2));
      this.Sc = new ArrayList(var3.length + 1);
      this.Sc.add(var2);
      int var5 = var3.length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Filter var6 = var3[var4];
         this.Su.add(new FilterHolder(var6));
         this.Sc.add(var6);
      }

   }

   public LogicalFilter(Operator var1, Iterable var2) {
      this.CK = 1;
      this.Sh = var1;
      this.Sc = new ArrayList();
      this.Su = new ArrayList();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Filter var4 = (Filter)var3.next();
         this.Sc.add(var4);
         this.Su.add(new FilterHolder(var4));
      }

   }

   public Object a(f var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.Su.iterator();

      while(var3.hasNext()) {
         var2.add(((FilterHolder)var3.next()).getFilter().a(var1));
      }

      return var1.b((Operator)this.Sh, (List)var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      i.a(this, var1, var2);
   }
}
