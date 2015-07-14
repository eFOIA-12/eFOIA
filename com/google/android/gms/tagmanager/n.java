package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.bh;

class n implements ContainerHolder {
   private Status Eb;
   private final Looper JF;
   private boolean Pf;
   private Container aqu;
   private Container aqv;
   private n.b aqw;
   private n.a aqx;
   private TagManager aqy;

   public n(Status var1) {
      this.Eb = var1;
      this.JF = null;
   }

   public n(TagManager var1, Looper var2, Container var3, n.a var4) {
      this.aqy = var1;
      if(var2 == null) {
         var2 = Looper.getMainLooper();
      }

      this.JF = var2;
      this.aqu = var3;
      this.aqx = var4;
      this.Eb = Status.Kw;
      var1.a(this);
   }

   private void pm() {
      if(this.aqw != null) {
         this.aqw.cu(this.aqv.pj());
      }

   }

   public void a(Container param1) {
      // $FF: Couldn't be decompiled
   }

   public void cr(String param1) {
      // $FF: Couldn't be decompiled
   }

   void ct(String var1) {
      if(this.Pf) {
         bh.T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      } else {
         this.aqx.ct(var1);
      }
   }

   public Container getContainer() {
      Container var1 = null;
      synchronized(this){}

      try {
         if(this.Pf) {
            bh.T("ContainerHolder is released.");
         } else {
            if(this.aqv != null) {
               this.aqu = this.aqv;
               this.aqv = null;
            }

            var1 = this.aqu;
         }
      } finally {
         ;
      }

      return var1;
   }

   String getContainerId() {
      if(this.Pf) {
         bh.T("getContainerId called on a released ContainerHolder.");
         return "";
      } else {
         return this.aqu.getContainerId();
      }
   }

   public Status getStatus() {
      return this.Eb;
   }

   String pl() {
      if(this.Pf) {
         bh.T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
         return "";
      } else {
         return this.aqx.pl();
      }
   }

   public void refresh() {
      synchronized(this){}

      try {
         if(this.Pf) {
            bh.T("Refreshing a released ContainerHolder.");
         } else {
            this.aqx.pn();
         }
      } finally {
         ;
      }

   }

   public void release() {
      synchronized(this){}

      try {
         if(this.Pf) {
            bh.T("Releasing a released ContainerHolder.");
         } else {
            this.Pf = true;
            this.aqy.b(this);
            this.aqu.release();
            this.aqu = null;
            this.aqv = null;
            this.aqx = null;
            this.aqw = null;
         }
      } finally {
         ;
      }

   }

   public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener param1) {
      // $FF: Couldn't be decompiled
   }

   public interface a {
      void ct(String var1);

      String pl();

      void pn();
   }

   private class b extends Handler {
      private final ContainerHolder.ContainerAvailableListener aqz;

      public b(ContainerHolder.ContainerAvailableListener var2, Looper var3) {
         super(var3);
         this.aqz = var2;
      }

      public void cu(String var1) {
         this.sendMessage(this.obtainMessage(1, var1));
      }

      protected void cv(String var1) {
         this.aqz.onContainerAvailable(n.this, var1);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            this.cv((String)var1.obj);
            return;
         default:
            bh.T("Don\'t know how to handle this message.");
         }
      }
   }
}
