package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class b extends c.a {
   private Fragment TG;

   private b(Fragment var1) {
      this.TG = var1;
   }

   public static b a(Fragment var0) {
      return var0 != null?new b(var0):null;
   }

   public void d(d var1) {
      View var2 = (View)e.f(var1);
      this.TG.registerForContextMenu(var2);
   }

   public void e(d var1) {
      View var2 = (View)e.f(var1);
      this.TG.unregisterForContextMenu(var2);
   }

   public Bundle getArguments() {
      return this.TG.getArguments();
   }

   public int getId() {
      return this.TG.getId();
   }

   public boolean getRetainInstance() {
      return this.TG.getRetainInstance();
   }

   public String getTag() {
      return this.TG.getTag();
   }

   public int getTargetRequestCode() {
      return this.TG.getTargetRequestCode();
   }

   public boolean getUserVisibleHint() {
      return this.TG.getUserVisibleHint();
   }

   public d getView() {
      return e.k(this.TG.getView());
   }

   public boolean isAdded() {
      return this.TG.isAdded();
   }

   public boolean isDetached() {
      return this.TG.isDetached();
   }

   public boolean isHidden() {
      return this.TG.isHidden();
   }

   public boolean isInLayout() {
      return this.TG.isInLayout();
   }

   public boolean isRemoving() {
      return this.TG.isRemoving();
   }

   public boolean isResumed() {
      return this.TG.isResumed();
   }

   public boolean isVisible() {
      return this.TG.isVisible();
   }

   public d jf() {
      return e.k(this.TG.getActivity());
   }

   public c jg() {
      return a(this.TG.getParentFragment());
   }

   public d jh() {
      return e.k(this.TG.getResources());
   }

   public c ji() {
      return a(this.TG.getTargetFragment());
   }

   public void setHasOptionsMenu(boolean var1) {
      this.TG.setHasOptionsMenu(var1);
   }

   public void setMenuVisibility(boolean var1) {
      this.TG.setMenuVisibility(var1);
   }

   public void setRetainInstance(boolean var1) {
      this.TG.setRetainInstance(var1);
   }

   public void setUserVisibleHint(boolean var1) {
      this.TG.setUserVisibleHint(var1);
   }

   public void startActivity(Intent var1) {
      this.TG.startActivity(var1);
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.TG.startActivityForResult(var1, var2);
   }
}
