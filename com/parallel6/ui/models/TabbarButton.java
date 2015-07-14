package com.parallel6.ui.models;

import android.view.View.OnClickListener;

public class TabbarButton {
   private int buttonId;
   private OnClickListener buttonListener;
   private int buttonResource;

   public TabbarButton(int var1, int var2, OnClickListener var3) {
      this.buttonId = var1;
      this.buttonResource = var2;
      this.buttonListener = var3;
   }

   public int getButtonId() {
      return this.buttonId;
   }

   public OnClickListener getButtonListener() {
      return this.buttonListener;
   }

   public int getButtonResource() {
      return this.buttonResource;
   }

   public void setButtonId(int var1) {
      this.buttonId = var1;
   }

   public void setButtonListener(OnClickListener var1) {
      this.buttonListener = var1;
   }

   public void setButtonResource(int var1) {
      this.buttonResource = var1;
   }
}
