package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentActionRef;
import com.google.android.gms.games.appcontent.AppContentAnnotationRef;
import com.google.android.gms.games.appcontent.AppContentConditionRef;
import com.google.android.gms.games.appcontent.AppContentTupleRef;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

public final class AppContentUtils {
   public static ArrayList a(DataHolder var0, ArrayList var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      a(var0, 1, var2, "action_id", var3, new AppContentUtils.AppContentRunner() {
         public void b(ArrayList var1, int var2) {
            var4.add(new AppContentActionRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   private static void a(DataHolder var0, int var1, String var2, String var3, int var4, AppContentUtils.AppContentRunner var5, ArrayList var6) {
      DataHolder var7 = (DataHolder)var6.get(var1);
      String var8 = var0.c(var2, var4, var0.au(var4));
      if(!TextUtils.isEmpty(var8)) {
         var4 = var7.getCount();
         String[] var9 = var8.split(",");

         for(var1 = 0; var1 < var4; ++var1) {
            var2 = var7.c(var3, var1, var7.au(var1));
            if(!TextUtils.isEmpty(var2) && la.b(var9, var2)) {
               var5.b(var6, var1);
            }
         }
      }

   }

   public static ArrayList b(DataHolder var0, ArrayList var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      a(var0, 2, var2, "annotation_id", var3, new AppContentUtils.AppContentRunner() {
         public void b(ArrayList var1, int var2) {
            var4.add(new AppContentAnnotationRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   public static ArrayList c(DataHolder var0, ArrayList var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      a(var0, 4, var2, "condition_id", var3, new AppContentUtils.AppContentRunner() {
         public void b(ArrayList var1, int var2) {
            var4.add(new AppContentConditionRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   public static Bundle d(DataHolder var0, ArrayList var1, String var2, int var3) {
      final Bundle var4 = new Bundle();
      a(var0, 3, var2, "tuple_id", var3, new AppContentUtils.AppContentRunner() {
         // $FF: synthetic field
         final DataHolder Yc;

         {
            this.Yc = var1;
         }

         public void b(ArrayList var1, int var2) {
            AppContentTupleRef var3 = new AppContentTupleRef(this.Yc, var2);
            var4.putString(var3.getName(), var3.getValue());
         }
      }, var1);
      return var4;
   }

   private interface AppContentRunner {
      void b(ArrayList var1, int var2);
   }
}
