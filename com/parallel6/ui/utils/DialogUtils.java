package com.parallel6.ui.utils;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class DialogUtils {
   public static void showDialog(Context var0, String var1, OnClickListener var2, OnClickListener var3) {
      (new Builder(var0)).setTitle(var1).setPositiveButton("Yes", var2).setNegativeButton("No", var3).create().show();
   }
}
