package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class h extends c.a {
   private Fragment Mx;

   private h(Fragment var1) {
      this.Mx = var1;
   }

   public static h a(Fragment var0) {
      return var0 != null?new h(var0):null;
   }

   public void d(d var1) {
      View var2 = (View)e.f(var1);
      this.Mx.registerForContextMenu(var2);
   }

   public void e(d var1) {
      View var2 = (View)e.f(var1);
      this.Mx.unregisterForContextMenu(var2);
   }

   public Bundle getArguments() {
      return this.Mx.getArguments();
   }

   public int getId() {
      return this.Mx.getId();
   }

   public boolean getRetainInstance() {
      return this.Mx.getRetainInstance();
   }

   public String getTag() {
      return this.Mx.getTag();
   }

   public int getTargetRequestCode() {
      return this.Mx.getTargetRequestCode();
   }

   public boolean getUserVisibleHint() {
      return this.Mx.getUserVisibleHint();
   }

   public d getView() {
      return e.k(this.Mx.getView());
   }

   public boolean isAdded() {
      return this.Mx.isAdded();
   }

   public boolean isDetached() {
      return this.Mx.isDetached();
   }

   public boolean isHidden() {
      return this.Mx.isHidden();
   }

   public boolean isInLayout() {
      return this.Mx.isInLayout();
   }

   public boolean isRemoving() {
      return this.Mx.isRemoving();
   }

   public boolean isResumed() {
      return this.Mx.isResumed();
   }

   public boolean isVisible() {
      return this.Mx.isVisible();
   }

   public d jf() {
      return e.k(this.Mx.getActivity());
   }

   public c jg() {
      return a(this.Mx.getParentFragment());
   }

   public d jh() {
      return e.k(this.Mx.getResources());
   }

   public c ji() {
      return a(this.Mx.getTargetFragment());
   }

   public void setHasOptionsMenu(boolean var1) {
      this.Mx.setHasOptionsMenu(var1);
   }

   public void setMenuVisibility(boolean var1) {
      this.Mx.setMenuVisibility(var1);
   }

   public void setRetainInstance(boolean var1) {
      this.Mx.setRetainInstance(var1);
   }

   public void setUserVisibleHint(boolean var1) {
      this.Mx.setUserVisibleHint(var1);
   }

   public void startActivity(Intent var1) {
      this.Mx.startActivity(var1);
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.Mx.startActivityForResult(var1, var2);
   }
}
