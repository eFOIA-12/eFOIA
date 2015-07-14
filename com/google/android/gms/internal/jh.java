package com.google.android.gms.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;

public class jh implements OnClickListener {
   private final Fragment Mx;
   private final int My;
   private final Intent mIntent;
   private final Activity nB;

   public jh(Activity var1, Intent var2, int var3) {
      this.nB = var1;
      this.Mx = null;
      this.mIntent = var2;
      this.My = var3;
   }

   public jh(Fragment var1, Intent var2, int var3) {
      this.nB = null;
      this.Mx = var1;
      this.mIntent = var2;
      this.My = var3;
   }

   public void onClick(DialogInterface param1, int param2) {
      // $FF: Couldn't be decompiled
   }
}
