package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.f;
import java.util.Iterator;
import java.util.List;

public class c implements f {
   public String a(com.google.android.gms.drive.metadata.b var1, Object var2) {
      return String.format("contains(%s,%s)", new Object[]{var1.getName(), var2});
   }

   public String a(Operator var1, MetadataField var2, Object var3) {
      return String.format("cmp(%s,%s,%s)", new Object[]{var1.getTag(), var2.getName(), var3});
   }

   public String a(Operator var1, List var2) {
      StringBuilder var3 = new StringBuilder(var1.getTag() + "(");
      Iterator var6 = var2.iterator();

      for(String var5 = ""; var6.hasNext(); var5 = ",") {
         String var4 = (String)var6.next();
         var3.append(var5);
         var3.append(var4);
      }

      return var3.append(")").toString();
   }

   // $FF: synthetic method
   public Object b(com.google.android.gms.drive.metadata.b var1, Object var2) {
      return this.a(var1, var2);
   }

   // $FF: synthetic method
   public Object b(Operator var1, MetadataField var2, Object var3) {
      return this.a(var1, var2, var3);
   }

   // $FF: synthetic method
   public Object b(Operator var1, List var2) {
      return this.a(var1, var2);
   }

   public String bq(String var1) {
      return String.format("not(%s)", new Object[]{var1});
   }

   public String c(MetadataField var1) {
      return String.format("fieldOnly(%s)", new Object[]{var1.getName()});
   }

   public String c(MetadataField var1, Object var2) {
      return String.format("has(%s,%s)", new Object[]{var1.getName(), var2});
   }

   // $FF: synthetic method
   public Object d(MetadataField var1) {
      return this.c(var1);
   }

   // $FF: synthetic method
   public Object d(MetadataField var1, Object var2) {
      return this.c(var1, var2);
   }

   // $FF: synthetic method
   public Object j(Object var1) {
      return this.bq((String)var1);
   }

   public String jc() {
      return "all()";
   }

   // $FF: synthetic method
   public Object jd() {
      return this.jc();
   }
}
