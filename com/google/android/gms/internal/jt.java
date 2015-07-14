package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.js;

public interface jt extends IInterface {
   void a(js var1, int var2) throws RemoteException;

   void a(js var1, int var2, String var3) throws RemoteException;

   void a(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void a(js var1, int var2, String var3, IBinder var4, Bundle var5) throws RemoteException;

   void a(js var1, int var2, String var3, String var4) throws RemoteException;

   void a(js var1, int var2, String var3, String var4, String var5, String[] var6) throws RemoteException;

   void a(js var1, int var2, String var3, String var4, String[] var5) throws RemoteException;

   void a(js var1, int var2, String var3, String var4, String[] var5, Bundle var6) throws RemoteException;

   void a(js var1, int var2, String var3, String var4, String[] var5, String var6, Bundle var7) throws RemoteException;

   void a(js var1, int var2, String var3, String var4, String[] var5, String var6, IBinder var7, String var8, Bundle var9) throws RemoteException;

   void a(js var1, int var2, String var3, String[] var4, String var5, Bundle var6) throws RemoteException;

   void a(js var1, jj var2) throws RemoteException;

   void b(js var1, int var2, String var3) throws RemoteException;

   void b(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void b(js var1, int var2, String var3, String var4, String[] var5) throws RemoteException;

   void c(js var1, int var2, String var3) throws RemoteException;

   void c(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void d(js var1, int var2, String var3) throws RemoteException;

   void d(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void e(js var1, int var2, String var3) throws RemoteException;

   void e(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void f(js var1, int var2, String var3) throws RemoteException;

   void f(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void g(js var1, int var2, String var3) throws RemoteException;

   void g(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void h(js var1, int var2, String var3) throws RemoteException;

   void h(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void i(js var1, int var2, String var3) throws RemoteException;

   void i(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void j(js var1, int var2, String var3) throws RemoteException;

   void j(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void k(js var1, int var2, String var3) throws RemoteException;

   void k(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void l(js var1, int var2, String var3) throws RemoteException;

   void l(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void m(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void n(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void o(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void p(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void q(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void r(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void s(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   void t(js var1, int var2, String var3, Bundle var4) throws RemoteException;

   public abstract static class a extends Binder implements jt {
      public static jt Q(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (jt)(var1 != null && var1 instanceof jt?(jt)var1:new jt.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         js var6 = null;
         String var7 = null;
         String[] var8 = null;
         String var9 = null;
         IBinder var10 = null;
         String var11 = null;
         Object var12 = null;
         Object var13 = null;
         Object var14 = null;
         Object var15 = null;
         Object var16 = null;
         Object var17 = null;
         Object var18 = null;
         Object var19 = null;
         Object var20 = null;
         Object var21 = null;
         Object var22 = null;
         Object var23 = null;
         Object var24 = null;
         Object var25 = null;
         Bundle var5 = null;
         Bundle var26;
         String var28;
         String var29;
         js var32;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var32 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var28 = var2.readString();
            var7 = var2.readString();
            var8 = var2.createStringArray();
            var9 = var2.readString();
            if(var2.readInt() != 0) {
               var26 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var26 = null;
            }

            this.a(var32, var1, var28, var7, var8, var9, var26);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.a(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.a(js.a.P(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            js var33 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var29 = var2.readString();
            var5 = var6;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.b(var33, var1, var29, var5);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var29 = var2.readString();
            var5 = var7;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.c(var6, var1, var29, var5);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = var8;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.d(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = var9;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.e(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var32 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var28 = var2.readString();
            var7 = var2.readString();
            var8 = var2.createStringArray();
            var9 = var2.readString();
            var10 = var2.readStrongBinder();
            var11 = var2.readString();
            if(var2.readInt() != 0) {
               var26 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var26 = null;
            }

            this.a(var32, var1, var28, var7, var8, var9, var10, var11, var26);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.a(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = var10;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.f(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = var11;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.g(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var12;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.h(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var13;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.i(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var14;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.j(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var15;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.k(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var16;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.l(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var17;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.m(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var32 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var28 = var2.readString();
            IBinder var31 = var2.readStrongBinder();
            if(var2.readInt() != 0) {
               var26 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var26 = null;
            }

            this.a(var32, var1, var28, var31, var26);
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var32 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var28 = var2.readString();
            String[] var30 = var2.createStringArray();
            var29 = var2.readString();
            if(var2.readInt() != 0) {
               var26 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var26 = null;
            }

            this.a(var32, var1, var28, var30, var29, var26);
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.b(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.c(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var18;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.n(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.d(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var19;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.o(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.e(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var20;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.p(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.b(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var32 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var28 = var2.readString();
            var7 = var2.readString();
            var8 = var2.createStringArray();
            if(var2.readInt() != 0) {
               var26 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var26 = null;
            }

            this.a(var32, var1, var28, var7, var8, var26);
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.f(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.g(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.a(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.a(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.h(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.i(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var21;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.q(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 38:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var22;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.r(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.j(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var23;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.s(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.k(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 43:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            var1 = var2.readInt();
            var7 = var2.readString();
            var5 = (Bundle)var24;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.t(var6, var1, var7, var5);
            var3.writeNoException();
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.l(js.a.P(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            var6 = js.a.P(var2.readStrongBinder());
            jj var27 = (jj)var25;
            if(var2.readInt() != 0) {
               var27 = (jj)jj.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var27);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements jt {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(js param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, String param4, String param5, String[] param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, String param4, String[] param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, String param4, String[] param5, Bundle param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, String param4, String[] param5, String param6, Bundle param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, String param4, String[] param5, String param6, IBinder param7, String param8, Bundle param9) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, int param2, String param3, String[] param4, String param5, Bundle param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(js param1, jj param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(js param1, int param2, String param3, String param4, String[] param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void g(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void g(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void h(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void h(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void i(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void i(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void j(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void j(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void k(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void k(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void l(js param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void l(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void m(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void n(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void o(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void p(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void q(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void r(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void s(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void t(js param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
