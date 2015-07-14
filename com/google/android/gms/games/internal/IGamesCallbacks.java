package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public interface IGamesCallbacks extends IInterface {
   void A(DataHolder var1) throws RemoteException;

   void B(DataHolder var1) throws RemoteException;

   void C(DataHolder var1) throws RemoteException;

   void D(DataHolder var1) throws RemoteException;

   void E(DataHolder var1) throws RemoteException;

   void F(DataHolder var1) throws RemoteException;

   void G(DataHolder var1) throws RemoteException;

   void H(DataHolder var1) throws RemoteException;

   void I(DataHolder var1) throws RemoteException;

   void J(DataHolder var1) throws RemoteException;

   void K(DataHolder var1) throws RemoteException;

   void L(DataHolder var1) throws RemoteException;

   void M(DataHolder var1) throws RemoteException;

   void N(DataHolder var1) throws RemoteException;

   void O(DataHolder var1) throws RemoteException;

   void P(DataHolder var1) throws RemoteException;

   void Q(DataHolder var1) throws RemoteException;

   void a(int var1, String var2, boolean var3) throws RemoteException;

   void a(DataHolder var1, DataHolder var2) throws RemoteException;

   void a(DataHolder var1, Contents var2) throws RemoteException;

   void a(DataHolder var1, String var2, Contents var3, Contents var4, Contents var5) throws RemoteException;

   void a(DataHolder var1, String[] var2) throws RemoteException;

   void a(DataHolder[] var1) throws RemoteException;

   void b(int var1, int var2, String var3) throws RemoteException;

   void b(int var1, Bundle var2) throws RemoteException;

   void b(DataHolder var1, String[] var2) throws RemoteException;

   void c(int var1, Bundle var2) throws RemoteException;

   void c(DataHolder var1) throws RemoteException;

   void c(DataHolder var1, String[] var2) throws RemoteException;

   void d(int var1, Bundle var2) throws RemoteException;

   void d(DataHolder var1) throws RemoteException;

   void d(DataHolder var1, String[] var2) throws RemoteException;

   void dO(int var1) throws RemoteException;

   void dP(int var1) throws RemoteException;

   void dQ(int var1) throws RemoteException;

   void e(int var1, Bundle var2) throws RemoteException;

   void e(DataHolder var1) throws RemoteException;

   void e(DataHolder var1, String[] var2) throws RemoteException;

   void f(int var1, Bundle var2) throws RemoteException;

   void f(int var1, String var2) throws RemoteException;

   void f(DataHolder var1) throws RemoteException;

   void f(DataHolder var1, String[] var2) throws RemoteException;

   void fK() throws RemoteException;

   void g(int var1, String var2) throws RemoteException;

   void g(DataHolder var1) throws RemoteException;

   void h(int var1, String var2) throws RemoteException;

   void h(DataHolder var1) throws RemoteException;

   void i(int var1, String var2) throws RemoteException;

   void i(DataHolder var1) throws RemoteException;

   void j(DataHolder var1) throws RemoteException;

   void k(DataHolder var1) throws RemoteException;

   void l(DataHolder var1) throws RemoteException;

   void m(DataHolder var1) throws RemoteException;

   void n(DataHolder var1) throws RemoteException;

   void o(DataHolder var1) throws RemoteException;

   void onInvitationRemoved(String var1) throws RemoteException;

   void onLeftRoom(int var1, String var2) throws RemoteException;

   void onP2PConnected(String var1) throws RemoteException;

   void onP2PDisconnected(String var1) throws RemoteException;

   void onRealTimeMessageReceived(RealTimeMessage var1) throws RemoteException;

   void onRequestRemoved(String var1) throws RemoteException;

   void onTurnBasedMatchRemoved(String var1) throws RemoteException;

   void p(DataHolder var1) throws RemoteException;

   void q(DataHolder var1) throws RemoteException;

   void r(DataHolder var1) throws RemoteException;

   void s(DataHolder var1) throws RemoteException;

   void t(DataHolder var1) throws RemoteException;

   void u(DataHolder var1) throws RemoteException;

   void v(DataHolder var1) throws RemoteException;

   void w(DataHolder var1) throws RemoteException;

   void x(DataHolder var1) throws RemoteException;

   void y(DataHolder var1) throws RemoteException;

   void z(DataHolder var1) throws RemoteException;

   public abstract static class Stub extends Binder implements IGamesCallbacks {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
      }

      public static IGamesCallbacks aD(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (IGamesCallbacks)(var1 != null && var1 instanceof IGamesCallbacks?(IGamesCallbacks)var1:new IGamesCallbacks.Proxy(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         DataHolder var7 = null;
         Contents var8 = null;
         String var10 = null;
         Object var11 = null;
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
         Object var26 = null;
         Object var27 = null;
         Object var28 = null;
         Object var29 = null;
         Object var30 = null;
         Object var31 = null;
         Object var32 = null;
         Object var33 = null;
         Object var34 = null;
         Object var35 = null;
         Object var36 = null;
         Object var37 = null;
         Object var38 = null;
         Object var39 = null;
         Object var40 = null;
         Object var41 = null;
         Object var42 = null;
         Object var43 = null;
         Object var44 = null;
         Contents var9 = null;
         Object var45 = null;
         Object var46 = null;
         Object var47 = null;
         Object var48 = null;
         Object var49 = null;
         Object var50 = null;
         Object var51 = null;
         Object var52 = null;
         Object var53 = null;
         DataHolder var6 = null;
         Bundle var54;
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.f(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            DataHolder var58;
            if(var2.readInt() != 0) {
               var58 = DataHolder.CREATOR.B(var2);
            } else {
               var58 = null;
            }

            this.c(var58);
            var3.writeNoException();
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.g(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.e(var6);
            var3.writeNoException();
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            } else {
               var6 = null;
            }

            if(var2.readInt() != 0) {
               var7 = DataHolder.CREATOR.B(var2);
            }

            this.a(var6, var7);
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = var8;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.f(var6);
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = var10;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.g(var6);
            var3.writeNoException();
            return true;
         case 5008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var11;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.h(var6);
            var3.writeNoException();
            return true;
         case 5009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var12;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.i(var6);
            var3.writeNoException();
            return true;
         case 5010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var13;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.j(var6);
            var3.writeNoException();
            return true;
         case 5011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var14;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.k(var6);
            var3.writeNoException();
            return true;
         case 5016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.fK();
            var3.writeNoException();
            return true;
         case 5017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var15;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.m(var6);
            var3.writeNoException();
            return true;
         case 5018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var17;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.u(var6);
            var3.writeNoException();
            return true;
         case 5019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var18;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.v(var6);
            var3.writeNoException();
            return true;
         case 5020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onLeftRoom(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var19;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.w(var6);
            var3.writeNoException();
            return true;
         case 5022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var20;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.x(var6);
            var3.writeNoException();
            return true;
         case 5023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var21;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.y(var6);
            var3.writeNoException();
            return true;
         case 5024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var22;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.z(var6);
            var3.writeNoException();
            return true;
         case 5025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var23;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.A(var6);
            var3.writeNoException();
            return true;
         case 5026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var24;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.a(var6, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var25;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.b(var6, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var26;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.c(var6, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var27;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.d(var6, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var28;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.e(var6, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var29;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.f(var6, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            RealTimeMessage var57;
            if(var2.readInt() != 0) {
               var57 = (RealTimeMessage)RealTimeMessage.CREATOR.createFromParcel(var2);
            } else {
               var57 = null;
            }

            this.onRealTimeMessageReceived(var57);
            var3.writeNoException();
            return true;
         case 5033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.b(var2.readInt(), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var1 = var2.readInt();
            String var59 = var2.readString();
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.a(var1, var59, var5);
            var3.writeNoException();
            return true;
         case 5035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var31;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.C(var6);
            var3.writeNoException();
            return true;
         case 5036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.dO(var2.readInt());
            var3.writeNoException();
            return true;
         case 5037:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var16;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.n(var6);
            var3.writeNoException();
            return true;
         case 5038:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var30;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.B(var6);
            var3.writeNoException();
            return true;
         case 5039:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var32;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.D(var6);
            var3.writeNoException();
            return true;
         case 5040:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.dP(var2.readInt());
            var3.writeNoException();
            return true;
         case 6001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onP2PConnected(var2.readString());
            var3.writeNoException();
            return true;
         case 6002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onP2PDisconnected(var2.readString());
            var3.writeNoException();
            return true;
         case 8001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var33;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.E(var6);
            var3.writeNoException();
            return true;
         case 8002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var54 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var54 = null;
            }

            this.b(var1, var54);
            var3.writeNoException();
            return true;
         case 8003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var34;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.p(var6);
            var3.writeNoException();
            return true;
         case 8004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var35;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.q(var6);
            var3.writeNoException();
            return true;
         case 8005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var36;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.r(var6);
            var3.writeNoException();
            return true;
         case 8006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var37;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.s(var6);
            var3.writeNoException();
            return true;
         case 8007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.h(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 8008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var38;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.t(var6);
            var3.writeNoException();
            return true;
         case 8009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onTurnBasedMatchRemoved(var2.readString());
            var3.writeNoException();
            return true;
         case 8010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onInvitationRemoved(var2.readString());
            var3.writeNoException();
            return true;
         case 9001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var39;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.l(var6);
            var3.writeNoException();
            return true;
         case 10001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var40;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.o(var6);
            var3.writeNoException();
            return true;
         case 10002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onRequestRemoved(var2.readString());
            var3.writeNoException();
            return true;
         case 10003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var41;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.F(var6);
            var3.writeNoException();
            return true;
         case 10004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var42;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.G(var6);
            var3.writeNoException();
            return true;
         case 10005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var54 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var54 = null;
            }

            this.c(var1, var54);
            var3.writeNoException();
            return true;
         case 10006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var43;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.H(var6);
            var3.writeNoException();
            return true;
         case 11001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var54 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var54 = null;
            }

            this.d(var1, var54);
            var3.writeNoException();
            return true;
         case 12001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var44;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.I(var6);
            var3.writeNoException();
            return true;
         case 12003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var54 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var54 = null;
            }

            this.e(var1, var54);
            var3.writeNoException();
            return true;
         case 12004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            } else {
               var6 = null;
            }

            Contents var55;
            if(var2.readInt() != 0) {
               var55 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var55 = null;
            }

            this.a(var6, var55);
            var3.writeNoException();
            return true;
         case 12005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var45;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.J(var6);
            var3.writeNoException();
            return true;
         case 12006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var48;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.K(var6);
            var3.writeNoException();
            return true;
         case 12007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var49;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.L(var6);
            var3.writeNoException();
            return true;
         case 12008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var52;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.O(var6);
            var3.writeNoException();
            return true;
         case 12011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var47;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.d(var6);
            var3.writeNoException();
            return true;
         case 12012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.i(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 12013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var46;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.P(var6);
            var3.writeNoException();
            return true;
         case 12014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var50;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.M(var6);
            var3.writeNoException();
            return true;
         case 12015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var54 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var54 = null;
            }

            this.f(var1, var54);
            var3.writeNoException();
            return true;
         case 12016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var51;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.N(var6);
            var3.writeNoException();
            return true;
         case 12017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            } else {
               var6 = null;
            }

            var10 = var2.readString();
            Contents var56;
            if(var2.readInt() != 0) {
               var56 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var56 = null;
            }

            if(var2.readInt() != 0) {
               var8 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            if(var2.readInt() != 0) {
               var9 = (Contents)Contents.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var10, var56, var8, var9);
            var3.writeNoException();
            return true;
         case 13001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            var6 = (DataHolder)var53;
            if(var2.readInt() != 0) {
               var6 = DataHolder.CREATOR.B(var2);
            }

            this.Q(var6);
            var3.writeNoException();
            return true;
         case 13002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.dQ(var2.readInt());
            var3.writeNoException();
            return true;
         case 14001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.a((DataHolder[])var2.createTypedArray(DataHolder.CREATOR));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IGamesCallbacks {
      private IBinder le;

      Proxy(IBinder var1) {
         this.le = var1;
      }

      public void A(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void B(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void C(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void D(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void E(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void F(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void G(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void H(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void I(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void J(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void K(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void L(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void M(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void N(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void O(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void P(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void Q(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(int param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1, DataHolder param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1, Contents param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1, String param2, Contents param3, Contents param4, Contents param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder[] var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeTypedArray(var1, 0);
            this.le.transact(14001, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.le.transact(5033, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void b(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void dO(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeInt(var1);
            this.le.transact(5036, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void dP(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeInt(var1);
            this.le.transact(5040, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void dQ(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeInt(var1);
            this.le.transact(13002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void e(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.le.transact(5001, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void f(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void fK() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            this.le.transact(5016, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void g(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.le.transact(5003, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void g(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void h(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.le.transact(8007, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void h(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void i(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.le.transact(12012, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void i(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void j(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void k(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void l(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void m(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void n(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void o(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onInvitationRemoved(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.le.transact(8010, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onLeftRoom(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.le.transact(5020, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void onP2PConnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.le.transact(6001, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onP2PDisconnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.le.transact(6002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onRealTimeMessageReceived(RealTimeMessage param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onRequestRemoved(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.le.transact(10002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onTurnBasedMatchRemoved(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.le.transact(8009, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void p(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void q(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void r(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void s(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void t(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void u(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void v(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void w(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void x(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void y(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void z(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
