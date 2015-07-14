package com.parallel6.ui.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import com.parallel6.ui.interfaces.FragmentState;

public class FragmentUtils {
   public static void addFragment(FragmentTransaction var0, int var1, FragmentState var2) {
      var0.add(var1, (Fragment)var2);
   }

   public static void addFragment(FragmentActivity var0, int var1, FragmentState var2) {
      addFragment(var0, var1, var2, false);
   }

   public static void addFragment(FragmentActivity var0, int var1, FragmentState var2, boolean var3) {
      FragmentTransaction var4 = var0.getFragmentManager().beginTransaction();
      if(var3) {
         var4.addToBackStack((String)null);
         var4.add(var1, (Fragment)var2);
      } else {
         var4.replace(var1, (Fragment)var2);
      }

      var4.commit();
   }

   public static void endTransaction(FragmentTransaction var0) {
      var0.commit();
   }

   public static FragmentTransaction initTransaction(Activity var0) {
      return initTransaction(var0, false);
   }

   public static FragmentTransaction initTransaction(Activity var0, boolean var1) {
      FragmentTransaction var2 = var0.getFragmentManager().beginTransaction();
      if(var1) {
         var2.addToBackStack((String)null);
      }

      return var2;
   }

   public static void popFragment(FragmentTransaction var0, FragmentState var1) {
      var0.remove((Fragment)var1);
   }

   public static void pushFragment(FragmentTransaction var0, int var1, FragmentState var2) {
      var0.replace(var1, (Fragment)var2);
   }

   public static void removeFragment(FragmentActivity var0, Fragment var1) {
      FragmentTransaction var2 = var0.getFragmentManager().beginTransaction();
      var2.remove(var1);
      var2.commit();
   }
}
