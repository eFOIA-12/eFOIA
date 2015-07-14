package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jd;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jq;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.lm;
import com.google.android.gms.internal.pf;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.a;
import com.google.android.gms.plus.internal.d;
import com.google.android.gms.plus.internal.h;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class e extends jl {
   private Person anG;
   private final h anH;

   public e(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, h var5) {
      super(var1, var2, var3, var4, var5.oz());
      this.anH = var5;
   }

   public jr a(BaseImplementation.b var1, int var2, String var3) {
      this.dS();
      e.e var5 = new e.e(var1);

      try {
         jr var6 = ((d)this.hw()).a(var5, 1, var2, -1, var3);
         return var6;
      } catch (RemoteException var4) {
         var5.a(DataHolder.av(8), (String)null);
         return null;
      }
   }

   protected void a(int var1, IBinder var2, Bundle var3) {
      if(var1 == 0 && var3 != null && var3.containsKey("loaded_person")) {
         this.anG = pi.i(var3.getByteArray("loaded_person"));
      }

      super.a(var1, var2, var3);
   }

   public void a(BaseImplementation.b var1, int var2, String var3, Uri var4, String var5, String var6) {
      this.dS();
      e.b var8;
      if(var1 != null) {
         var8 = new e.b(var1);
      } else {
         var8 = null;
      }

      try {
         ((d)this.hw()).a(var8, var2, var3, var4, var5, var6);
      } catch (RemoteException var7) {
         var8.a(DataHolder.av(8), (String)null, (String)null);
      }
   }

   public void a(BaseImplementation.b var1, Moment var2) {
      this.dS();
      e.a var4;
      if(var1 != null) {
         var4 = new e.a(var1);
      } else {
         var4 = null;
      }

      try {
         ky var5 = ky.a((pf)var2);
         ((d)this.hw()).a(var4, (ky)var5);
      } catch (RemoteException var3) {
         if(var4 == null) {
            throw new IllegalStateException(var3);
         } else {
            var4.aA(new Status(8, (String)null, (PendingIntent)null));
         }
      }
   }

   public void a(BaseImplementation.b var1, Collection var2) {
      this.dS();
      e.e var4 = new e.e(var1);

      try {
         ((d)this.hw()).a(var4, (List)(new ArrayList(var2)));
      } catch (RemoteException var3) {
         var4.a(DataHolder.av(8), (String)null);
      }
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      Bundle var3 = this.anH.oH();
      var3.putStringArray("request_visible_actions", this.anH.oA());
      var3.putString("auth_package", this.anH.oC());
      var1.a(var2, (new jj(2)).aX(this.anH.oD()).a((jq)jd.aT(this.anH.getAccountName())).a(lm.d(this.hv())).e(var3));
   }

   protected String bK() {
      return "com.google.android.gms.plus.service.START";
   }

   protected String bL() {
      return "com.google.android.gms.plus.internal.IPlusService";
   }

   protected d bN(IBinder var1) {
      return d.a.bM(var1);
   }

   public boolean cj(String var1) {
      return Arrays.asList(this.hv()).contains(var1);
   }

   public void clearDefaultAccount() {
      this.dS();

      try {
         this.anG = null;
         ((d)this.hw()).clearDefaultAccount();
      } catch (RemoteException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public void d(BaseImplementation.b var1, String[] var2) {
      this.a((BaseImplementation.b)var1, (Collection)Arrays.asList(var2));
   }

   public String getAccountName() {
      this.dS();

      try {
         String var1 = ((d)this.hw()).getAccountName();
         return var1;
      } catch (RemoteException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public Person getCurrentPerson() {
      this.dS();
      return this.anG;
   }

   public void j(BaseImplementation.b var1) {
      this.a(var1, 20, (String)null, (Uri)null, (String)null, "me");
   }

   public void k(BaseImplementation.b var1) {
      this.dS();
      e.e var4 = new e.e(var1);

      try {
         ((d)this.hw()).a(var4, 2, 1, -1, (String)null);
      } catch (RemoteException var3) {
         var4.a(DataHolder.av(8), (String)null);
      }
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.bN(var1);
   }

   public void l(BaseImplementation.b var1) {
      this.dS();
      this.clearDefaultAccount();
      e.g var4 = new e.g(var1);

      try {
         ((d)this.hw()).b(var4);
      } catch (RemoteException var3) {
         var4.h(8, (Bundle)null);
      }
   }

   public jr q(BaseImplementation.b var1, String var2) {
      return this.a(var1, 0, var2);
   }

   public void removeMoment(String var1) {
      this.dS();

      try {
         ((d)this.hw()).removeMoment(var1);
      } catch (RemoteException var2) {
         throw new IllegalStateException(var2);
      }
   }

   final class a extends a {
      private final BaseImplementation.b anI;

      public a(BaseImplementation.b var2) {
         this.anI = var2;
      }

      public void aA(Status var1) {
         e.this.a(e.this.new d(this.anI, var1));
      }
   }

   final class b extends a {
      private final BaseImplementation.b anI;

      public b(BaseImplementation.b var2) {
         this.anI = var2;
      }

      public void a(DataHolder var1, String var2, String var3) {
         PendingIntent var4;
         if(var1.gV() != null) {
            var4 = (PendingIntent)var1.gV().getParcelable("pendingIntent");
         } else {
            var4 = null;
         }

         Status var5 = new Status(var1.getStatusCode(), (String)null, var4);
         if(!var5.isSuccess() && var1 != null) {
            if(!var1.isClosed()) {
               var1.close();
            }

            var1 = null;
         }

         e.this.a(e.this.new c(this.anI, var5, var1, var2, var3));
      }
   }

   final class c extends jl.d implements Moments.LoadMomentsResult {
      private final Status Eb;
      private final String OB;
      private final String anK;
      private MomentBuffer anL;

      public c(BaseImplementation.b var2, Status var3, DataHolder var4, String var5, String var6) {
         super();
         this.Eb = var3;
         this.OB = var5;
         this.anK = var6;
      }

      protected void a(BaseImplementation.b var1, DataHolder var2) {
         MomentBuffer var3;
         if(var2 != null) {
            var3 = new MomentBuffer(var2);
         } else {
            var3 = null;
         }

         this.anL = var3;
         var1.b(this);
      }

      // $FF: synthetic method
      protected void b(Object var1, DataHolder var2) {
         this.a((BaseImplementation.b)var1, var2);
      }

      public MomentBuffer getMomentBuffer() {
         return this.anL;
      }

      public String getNextPageToken() {
         return this.OB;
      }

      public Status getStatus() {
         return this.Eb;
      }

      public String getUpdated() {
         return this.anK;
      }

      public void release() {
         if(this.anL != null) {
            this.anL.close();
         }

      }
   }

   final class d extends jl.b {
      private final Status Eb;

      public d(BaseImplementation.b var2, Status var3) {
         super();
         this.Eb = var3;
      }

      // $FF: synthetic method
      protected void g(Object var1) {
         this.m((BaseImplementation.b)var1);
      }

      protected void hx() {
      }

      protected void m(BaseImplementation.b var1) {
         if(var1 != null) {
            var1.b(this.Eb);
         }

      }
   }

   final class e extends a {
      private final BaseImplementation.b anI;

      public e(BaseImplementation.b var2) {
         this.anI = var2;
      }

      public void a(DataHolder var1, String var2) {
         PendingIntent var3;
         if(var1.gV() != null) {
            var3 = (PendingIntent)var1.gV().getParcelable("pendingIntent");
         } else {
            var3 = null;
         }

         Status var4 = new Status(var1.getStatusCode(), (String)null, var3);
         if(!var4.isSuccess() && var1 != null) {
            if(!var1.isClosed()) {
               var1.close();
            }

            var1 = null;
         }

         e.this.a(e.this.new f(this.anI, var4, var1, var2));
      }
   }

   final class f extends jl.d implements People.LoadPeopleResult {
      private final Status Eb;
      private final String OB;
      private PersonBuffer anM;

      public f(BaseImplementation.b var2, Status var3, DataHolder var4, String var5) {
         super();
         this.Eb = var3;
         this.OB = var5;
      }

      protected void a(BaseImplementation.b var1, DataHolder var2) {
         PersonBuffer var3;
         if(var2 != null) {
            var3 = new PersonBuffer(var2);
         } else {
            var3 = null;
         }

         this.anM = var3;
         var1.b(this);
      }

      // $FF: synthetic method
      protected void b(Object var1, DataHolder var2) {
         this.a((BaseImplementation.b)var1, var2);
      }

      public String getNextPageToken() {
         return this.OB;
      }

      public PersonBuffer getPersonBuffer() {
         return this.anM;
      }

      public Status getStatus() {
         return this.Eb;
      }

      public void release() {
         if(this.anM != null) {
            this.anM.close();
         }

      }
   }

   final class g extends a {
      private final BaseImplementation.b anI;

      public g(BaseImplementation.b var2) {
         this.anI = var2;
      }

      public void h(int var1, Bundle var2) {
         PendingIntent var3;
         if(var2 != null) {
            var3 = (PendingIntent)var2.getParcelable("pendingIntent");
         } else {
            var3 = null;
         }

         Status var4 = new Status(var1, (String)null, var3);
         e.this.a(e.this.new h(this.anI, var4));
      }
   }

   final class h extends jl.b {
      private final Status Eb;

      public h(BaseImplementation.b var2, Status var3) {
         super();
         this.Eb = var3;
      }

      // $FF: synthetic method
      protected void g(Object var1) {
         this.m((BaseImplementation.b)var1);
      }

      protected void hx() {
      }

      protected void m(BaseImplementation.b var1) {
         e.this.disconnect();
         if(var1 != null) {
            var1.b(this.Eb);
         }

      }
   }
}
