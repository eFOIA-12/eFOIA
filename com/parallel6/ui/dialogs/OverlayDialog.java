package com.parallel6.ui.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public class OverlayDialog extends DialogFragment {
   private int imageResource;

   public void dismissDialog() {
      this.dismiss();
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 == null) {
         var1 = this.getArguments();
      }

      if(var1 != null) {
         this.imageResource = var1.getInt("extras_dialog_image", 0);
      }

   }

   public Dialog onCreateDialog(Bundle var1) {
      RelativeLayout var3 = new RelativeLayout(this.getActivity());
      var3.setLayoutParams(new LayoutParams(-1, -1));
      var3.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            OverlayDialog.this.dismissDialog();
         }
      });
      Dialog var2 = new Dialog(this.getActivity());
      var2.requestWindowFeature(1);
      var2.setContentView(var3);
      var2.getWindow().setBackgroundDrawableResource(this.imageResource);
      var2.getWindow().setFlags(1024, 1024);
      var2.getWindow().setLayout(-1, -1);
      return var2;
   }
}
