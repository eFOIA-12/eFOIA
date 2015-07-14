package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

public interface IGamesService extends IInterface {
   void O(boolean var1) throws RemoteException;

   void P(boolean var1) throws RemoteException;

   void Q(boolean var1) throws RemoteException;

   int a(IGamesCallbacks var1, byte[] var2, String var3, String var4) throws RemoteException;

   Intent a(int var1, int var2, boolean var3) throws RemoteException;

   Intent a(int var1, byte[] var2, int var3, String var4) throws RemoteException;

   Intent a(AchievementEntity var1) throws RemoteException;

   Intent a(ZInvitationCluster var1, String var2, String var3) throws RemoteException;

   Intent a(GameRequestCluster var1, String var2) throws RemoteException;

   Intent a(RoomEntity var1, int var2) throws RemoteException;

   Intent a(String var1, boolean var2, boolean var3, int var4) throws RemoteException;

   Intent a(ParticipantEntity[] var1, String var2, String var3, Uri var4, Uri var5) throws RemoteException;

   Intent a(ParticipantEntity[] var1, String var2, String var3, Uri var4, Uri var5, String var6) throws RemoteException;

   void a(long var1, String var3) throws RemoteException;

   void a(IBinder var1, Bundle var2) throws RemoteException;

   void a(Contents var1) throws RemoteException;

   void a(IGamesCallbacks var1) throws RemoteException;

   void a(IGamesCallbacks var1, int var2) throws RemoteException;

   void a(IGamesCallbacks var1, int var2, int var3, int var4) throws RemoteException;

   void a(IGamesCallbacks var1, int var2, int var3, boolean var4, boolean var5) throws RemoteException;

   void a(IGamesCallbacks var1, int var2, int var3, String[] var4, Bundle var5) throws RemoteException;

   void a(IGamesCallbacks var1, int var2, String var3, String[] var4, boolean var5) throws RemoteException;

   void a(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   void a(IGamesCallbacks var1, int var2, int[] var3) throws RemoteException;

   void a(IGamesCallbacks var1, long var2) throws RemoteException;

   void a(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   void a(IGamesCallbacks var1, Bundle var2, int var3, int var4) throws RemoteException;

   void a(IGamesCallbacks var1, IBinder var2, int var3, String[] var4, Bundle var5, boolean var6, long var7) throws RemoteException;

   void a(IGamesCallbacks var1, IBinder var2, String var3, boolean var4, long var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int var3, int[] var4) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, long var3) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, long var3, String var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, SnapshotMetadataChangeEntity var3, Contents var4) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, int var4, int var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, SnapshotMetadataChangeEntity var4, Contents var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, int[] var4, int var5, boolean var6) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, String[] var4) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String var3, String[] var4, boolean var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, byte[] var3, ParticipantResult[] var4) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, int[] var3) throws RemoteException;

   void a(IGamesCallbacks var1, String var2, String[] var3, int var4, byte[] var5, int var6) throws RemoteException;

   void a(IGamesCallbacks var1, boolean var2) throws RemoteException;

   void a(IGamesCallbacks var1, boolean var2, Bundle var3) throws RemoteException;

   void a(IGamesCallbacks var1, boolean var2, String[] var3) throws RemoteException;

   void a(IGamesCallbacks var1, int[] var2) throws RemoteException;

   void a(IGamesCallbacks var1, int[] var2, int var3, boolean var4) throws RemoteException;

   void a(IGamesCallbacks var1, String[] var2) throws RemoteException;

   void a(IGamesCallbacks var1, String[] var2, boolean var3) throws RemoteException;

   void a(String var1, IBinder var2, Bundle var3) throws RemoteException;

   int b(byte[] var1, String var2, String[] var3) throws RemoteException;

   Intent b(int var1, int var2, boolean var3) throws RemoteException;

   Intent b(int[] var1) throws RemoteException;

   void b(long var1, String var3) throws RemoteException;

   void b(IGamesCallbacks var1) throws RemoteException;

   void b(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   void b(IGamesCallbacks var1, long var2) throws RemoteException;

   void b(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   void b(IGamesCallbacks var1, String var2) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   void b(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   void b(IGamesCallbacks var1, boolean var2) throws RemoteException;

   void b(IGamesCallbacks var1, String[] var2) throws RemoteException;

   void b(String var1, String var2, int var3) throws RemoteException;

   Intent bE(String var1) throws RemoteException;

   String bG(String var1) throws RemoteException;

   String bH(String var1) throws RemoteException;

   void bI(String var1) throws RemoteException;

   int bJ(String var1) throws RemoteException;

   Uri bK(String var1) throws RemoteException;

   void bL(String var1) throws RemoteException;

   Intent bM(String var1) throws RemoteException;

   ParcelFileDescriptor bN(String var1) throws RemoteException;

   void c(long var1, String var3) throws RemoteException;

   void c(IGamesCallbacks var1) throws RemoteException;

   void c(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   void c(IGamesCallbacks var1, long var2) throws RemoteException;

   void c(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   void c(IGamesCallbacks var1, String var2) throws RemoteException;

   void c(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   void c(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   void c(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   void c(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   void c(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   void c(IGamesCallbacks var1, boolean var2) throws RemoteException;

   void c(IGamesCallbacks var1, String[] var2) throws RemoteException;

   void c(String var1, String var2, int var3) throws RemoteException;

   void d(long var1, String var3) throws RemoteException;

   void d(IGamesCallbacks var1) throws RemoteException;

   void d(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   void d(IGamesCallbacks var1, long var2) throws RemoteException;

   void d(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   void d(IGamesCallbacks var1, String var2) throws RemoteException;

   void d(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   void d(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   void d(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   void d(IGamesCallbacks var1, boolean var2) throws RemoteException;

   void dT(int var1) throws RemoteException;

   void e(IGamesCallbacks var1) throws RemoteException;

   void e(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   void e(IGamesCallbacks var1, String var2) throws RemoteException;

   void e(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   void e(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   void e(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   void e(IGamesCallbacks var1, boolean var2) throws RemoteException;

   void f(IGamesCallbacks var1) throws RemoteException;

   void f(IGamesCallbacks var1, String var2) throws RemoteException;

   void f(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   void f(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   void f(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   void f(IGamesCallbacks var1, boolean var2) throws RemoteException;

   Bundle fX() throws RemoteException;

   void g(IGamesCallbacks var1) throws RemoteException;

   void g(IGamesCallbacks var1, String var2) throws RemoteException;

   void g(IGamesCallbacks var1, boolean var2) throws RemoteException;

   ParcelFileDescriptor h(Uri var1) throws RemoteException;

   RoomEntity h(IGamesCallbacks var1, String var2) throws RemoteException;

   void h(IGamesCallbacks var1) throws RemoteException;

   void h(IGamesCallbacks var1, boolean var2) throws RemoteException;

   void i(IGamesCallbacks var1) throws RemoteException;

   void i(IGamesCallbacks var1, String var2) throws RemoteException;

   void j(IGamesCallbacks var1) throws RemoteException;

   void j(IGamesCallbacks var1, String var2) throws RemoteException;

   void k(IGamesCallbacks var1, String var2) throws RemoteException;

   void l(IGamesCallbacks var1, String var2) throws RemoteException;

   int lA() throws RemoteException;

   int lB() throws RemoteException;

   int lC() throws RemoteException;

   void lE() throws RemoteException;

   DataHolder lG() throws RemoteException;

   boolean lH() throws RemoteException;

   DataHolder lI() throws RemoteException;

   void lJ() throws RemoteException;

   Intent lK() throws RemoteException;

   void lL() throws RemoteException;

   boolean lM() throws RemoteException;

   String lh() throws RemoteException;

   String li() throws RemoteException;

   Intent ll() throws RemoteException;

   Intent lm() throws RemoteException;

   Intent ln() throws RemoteException;

   Intent lo() throws RemoteException;

   Intent lt() throws RemoteException;

   Intent lu() throws RemoteException;

   int lv() throws RemoteException;

   String lw() throws RemoteException;

   int lx() throws RemoteException;

   Intent ly() throws RemoteException;

   int lz() throws RemoteException;

   void m(IGamesCallbacks var1, String var2) throws RemoteException;

   void n(IGamesCallbacks var1, String var2) throws RemoteException;

   void o(IGamesCallbacks var1, String var2) throws RemoteException;

   void o(String var1, int var2) throws RemoteException;

   void p(IGamesCallbacks var1, String var2) throws RemoteException;

   void p(String var1, int var2) throws RemoteException;

   void q(long var1) throws RemoteException;

   void q(IGamesCallbacks var1, String var2) throws RemoteException;

   void q(String var1, int var2) throws RemoteException;

   void r(long var1) throws RemoteException;

   void r(IGamesCallbacks var1, String var2) throws RemoteException;

   void s(long var1) throws RemoteException;

   void s(IGamesCallbacks var1, String var2) throws RemoteException;

   void s(String var1, int var2) throws RemoteException;

   void t(long var1) throws RemoteException;

   void t(IGamesCallbacks var1, String var2) throws RemoteException;

   void t(String var1, int var2) throws RemoteException;

   void t(String var1, String var2) throws RemoteException;

   Intent u(String var1, int var2) throws RemoteException;

   void u(long var1) throws RemoteException;

   void u(IGamesCallbacks var1, String var2) throws RemoteException;

   void u(String var1, String var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IGamesService {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
      }

      public static IGamesService aE(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (IGamesService)(var1 != null && var1 instanceof IGamesService?(IGamesService)var1:new IGamesService.Proxy(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Uri var43 = null;
         ParticipantEntity[] var44 = null;
         String var45 = null;
         Bundle var42 = null;
         boolean var7 = false;
         boolean var14 = false;
         boolean var15 = false;
         boolean var9 = false;
         boolean var11 = false;
         boolean var16 = false;
         byte var5 = 0;
         boolean var17 = false;
         boolean var18 = false;
         boolean var19 = false;
         boolean var20 = false;
         boolean var12 = false;
         boolean var13 = false;
         boolean var10 = false;
         boolean var21 = false;
         boolean var22 = false;
         boolean var23 = false;
         boolean var24 = false;
         boolean var25 = false;
         boolean var26 = false;
         boolean var27 = false;
         boolean var28 = false;
         boolean var29 = false;
         boolean var30 = false;
         boolean var31 = false;
         byte var6 = 0;
         boolean var32 = false;
         boolean var33 = false;
         boolean var34 = false;
         boolean var35 = false;
         boolean var36 = false;
         boolean var37 = false;
         boolean var38 = false;
         boolean var39 = false;
         boolean var40 = false;
         boolean var41 = false;
         boolean var8 = false;
         byte var47;
         Intent var48;
         Bundle var49;
         Contents var50;
         int var51;
         Uri var52;
         ParcelFileDescriptor var53;
         DataHolder var54;
         String var55;
         Uri var57;
         IGamesCallbacks var58;
         String var60;
         String var62;
         IBinder var63;
         IGamesCallbacks var64;
         String[] var65;
         String var66;
         String[] var67;
         SnapshotMetadataChangeEntity var68;
         IBinder var70;
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(var2.readLong());
            var3.writeNoException();
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var55 = this.lw();
            var3.writeNoException();
            var3.writeString(var55);
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var49 = this.fX();
            var3.writeNoException();
            if(var49 != null) {
               var3.writeInt(1);
               var49.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IBinder var76 = var2.readStrongBinder();
            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.a(var76, var49);
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.lE();
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var55 = this.lh();
            var3.writeNoException();
            var3.writeString(var55);
            return true;
         case 5012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var55 = this.li();
            var3.writeNoException();
            var3.writeString(var55);
            return true;
         case 5013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var54 = this.lG();
            var3.writeNoException();
            if(var54 != null) {
               var3.writeInt(1);
               var54.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            }

            this.a(var58, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 5016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readLong());
            var3.writeNoException();
            return true;
         case 5017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            var4 = var2.readInt();
            var51 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.a(var58, var60, var1, var4, var51, var7);
            var3.writeNoException();
            return true;
         case 5020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            var4 = var2.readInt();
            var51 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.b(var58, var60, var1, var4, var51, var7);
            var3.writeNoException();
            return true;
         case 5021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var64 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var42 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var42 = null;
            }

            this.a(var64, var42, var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var70 = var2.readStrongBinder();
            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.a(var58, var60, var70, var49);
            var3.writeNoException();
            return true;
         case 5024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var70 = var2.readStrongBinder();
            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.b(var58, var60, var70, var49);
            var3.writeNoException();
            return true;
         case 5025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            var70 = var2.readStrongBinder();
            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.a(var58, var60, var1, var70, var49);
            var3.writeNoException();
            return true;
         case 5026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.p(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var64 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var70 = var2.readStrongBinder();
            var1 = var2.readInt();
            var67 = var2.createStringArray();
            if(var2.readInt() != 0) {
               var42 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var64, var70, var1, var67, var42, var7, var2.readLong());
            var3.writeNoException();
            return true;
         case 5031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var63 = var2.readStrongBinder();
            var62 = var2.readString();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.a(var58, var63, var62, var7, var2.readLong());
            var3.writeNoException();
            return true;
         case 5032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.createByteArray(), var2.readString(), var2.readString());
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 5034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.b(var2.createByteArray(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 5035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var55 = this.bH(var2.readString());
            var3.writeNoException();
            var3.writeString(var55);
            return true;
         case 5036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.dT(var2.readInt());
            var3.writeNoException();
            return true;
         case 5037:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5038:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5039:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var1 = var2.readInt();
            var4 = var2.readInt();
            var51 = var2.readInt();
            var7 = var14;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var60, var62, var1, var4, var51, var7);
            var3.writeNoException();
            return true;
         case 5040:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var1 = var2.readInt();
            var4 = var2.readInt();
            var51 = var2.readInt();
            var7 = var15;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.b(var58, var60, var62, var1, var4, var51, var7);
            var3.writeNoException();
            return true;
         case 5041:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5042:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5043:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5044:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            var4 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.a(var58, var1, var4, var7, var8);
            var3.writeNoException();
            return true;
         case 5045:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.a(var58, var60, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 5046:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            var8 = var9;
            if(var2.readInt() != 0) {
               var8 = true;
            }

            this.b(var58, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 5047:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5048:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            var8 = var11;
            if(var2.readInt() != 0) {
               var8 = true;
            }

            this.c(var58, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 5049:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.g(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5050:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.bI(var2.readString());
            var3.writeNoException();
            return true;
         case 5051:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(var2.readString(), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5052:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.g(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5053:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            RoomEntity var56 = this.h(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            if(var56 != null) {
               var3.writeInt(1);
               var56.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5054:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var7 = var16;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var60, var7);
            var3.writeNoException();
            return true;
         case 5055:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5056:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.h(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5057:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.j(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5058:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 5059:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.r(var2.readLong());
            var3.writeNoException();
            return true;
         case 5060:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.bJ(var2.readString());
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 5061:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.i(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5062:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.i(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5063:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var18;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.a(var58, var7, var49);
            var3.writeNoException();
            return true;
         case 5064:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var55 = this.bG(var2.readString());
            var3.writeNoException();
            var3.writeString(var55);
            return true;
         case 5065:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5066:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var52 = this.bK(var2.readString());
            var3.writeNoException();
            if(var52 != null) {
               var3.writeInt(1);
               var52.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5067:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var7 = this.lH();
            var3.writeNoException();
            var47 = var5;
            if(var7) {
               var47 = 1;
            }

            var3.writeInt(var47);
            return true;
         case 5068:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var7 = var17;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.O(var7);
            var3.writeNoException();
            return true;
         case 5501:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.b(var58, var60, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 5502:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var54 = this.lI();
            var3.writeNoException();
            if(var54 != null) {
               var3.writeInt(1);
               var54.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 6001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var19;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var7);
            var3.writeNoException();
            return true;
         case 6002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var7 = var20;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var60, var62, var7);
            var3.writeNoException();
            return true;
         case 6003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            var8 = var12;
            if(var2.readInt() != 0) {
               var8 = true;
            }

            this.d(var58, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 6004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            var8 = var13;
            if(var2.readInt() != 0) {
               var8 = true;
            }

            this.e(var58, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 6501:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            if(var2.readInt() != 0) {
               var9 = true;
            } else {
               var9 = false;
            }

            if(var2.readInt() != 0) {
               var10 = true;
            }

            this.a(var58, var60, var1, var7, var8, var9, var10);
            var3.writeNoException();
            return true;
         case 6502:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var7 = var21;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.b(var58, var60, var7);
            var3.writeNoException();
            return true;
         case 6503:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var22;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.b(var58, var7);
            var3.writeNoException();
            return true;
         case 6504:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var7 = var23;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.c(var58, var60, var7);
            var3.writeNoException();
            return true;
         case 6505:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var7 = var24;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.d(var58, var60, var7);
            var3.writeNoException();
            return true;
         case 6506:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var7 = var25;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.b(var58, var60, var62, var7);
            var3.writeNoException();
            return true;
         case 6507:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            if(var2.readInt() != 0) {
               var52 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var52 = null;
            }

            var53 = this.h(var52);
            var3.writeNoException();
            if(var53 != null) {
               var3.writeInt(1);
               var53.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 7001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.k(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 7002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 7003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            var70 = var2.readStrongBinder();
            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.b(var58, var60, var1, var70, var49);
            var3.writeNoException();
            return true;
         case 8001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 8002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.bL(var2.readString());
            var3.writeNoException();
            return true;
         case 8003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 8004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            var4 = var2.readInt();
            var65 = var2.createStringArray();
            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.a(var58, var1, var4, var65, var49);
            var3.writeNoException();
            return true;
         case 8005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.l(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.m(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), var2.readString(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
            var3.writeNoException();
            return true;
         case 8008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
            var3.writeNoException();
            return true;
         case 8009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.n(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.o(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 8013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(var2.readLong());
            var3.writeNoException();
            return true;
         case 8014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.p(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 8018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.lJ();
            var3.writeNoException();
            return true;
         case 8023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            var7 = var26;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var60, var1, var7);
            var3.writeNoException();
            return true;
         case 8024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.lx();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 8025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(var2.readString(), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 8027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var27;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.c(var58, var7);
            var3.writeNoException();
            return true;
         case 9001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.c(var58, var60, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 9002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 9003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.ll();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.bM(var2.readString());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.lm();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.ln();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.lo();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = var2.readInt();
            var4 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            var48 = this.a(var1, var4, var7);
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = var2.readInt();
            var4 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            var48 = this.b(var1, var4, var7);
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.lt();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            RoomEntity var75;
            if(var2.readInt() != 0) {
               var75 = (RoomEntity)RoomEntity.CREATOR.createFromParcel(var2);
            } else {
               var75 = null;
            }

            var48 = this.a(var75, var2.readInt());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.lu();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.lK();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.lv();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 9020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.d(var58, var60, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 9028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.a(var58, var60, var62, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 9030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var53 = this.bN(var2.readString());
            var3.writeNoException();
            if(var53 != null) {
               var3.writeInt(1);
               var53.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ParticipantEntity[] var72 = (ParticipantEntity[])var2.createTypedArray(ParticipantEntity.CREATOR);
            var62 = var2.readString();
            var45 = var2.readString();
            if(var2.readInt() != 0) {
               var57 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var57 = null;
            }

            if(var2.readInt() != 0) {
               var52 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var52 = null;
            }

            var48 = this.a(var72, var62, var45, var57, var52);
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 10002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(var2.readLong());
            var3.writeNoException();
            return true;
         case 10003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 10004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 10005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.createStringArray(), var2.readInt(), var2.createByteArray(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.a(var2.readInt(), var2.createByteArray(), var2.readInt(), var2.readString());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.lz();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 10014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.ly();
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 10017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            var7 = var28;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.b(var58, var60, var1, var7);
            var3.writeNoException();
            return true;
         case 10018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readInt(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 10019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readInt(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 10020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ZInvitationCluster var74 = var44;
            if(var2.readInt() != 0) {
               var74 = ZInvitationCluster.CREATOR.cw(var2);
            }

            var48 = this.a(var74, var2.readString(), var2.readString());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            GameRequestCluster var73 = var43;
            if(var2.readInt() != 0) {
               var73 = GameRequestCluster.CREATOR.cy(var2);
            }

            var48 = this.a(var73, var2.readString());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.lA();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 11001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.j(IGamesCallbacks.Stub.aD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.lL();
            var3.writeNoException();
            return true;
         case 12001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var66 = var2.readString();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            var48 = this.a(var66, var7, var8, var2.readInt());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var29;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.d(var58, var7);
            var3.writeNoException();
            return true;
         case 12003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var7 = var30;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.c(var58, var60, var62, var7);
            var3.writeNoException();
            return true;
         case 12005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var7 = var31;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.e(var58, var60, var7);
            var3.writeNoException();
            return true;
         case 12007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var64 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var62 = var2.readString();
            if(var2.readInt() != 0) {
               var68 = SnapshotMetadataChangeEntity.CREATOR.cE(var2);
            } else {
               var68 = null;
            }

            if(var2.readInt() != 0) {
               var50 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var50 = null;
            }

            this.a(var64, var62, var68, var50);
            var3.writeNoException();
            return true;
         case 12008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 12010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            int[] var71 = var2.createIntArray();
            var1 = var2.readInt();
            var7 = var36;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var71, var1, var7);
            var3.writeNoException();
            return true;
         case 12011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 12012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(var2.readLong());
            var3.writeNoException();
            return true;
         case 12013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 12014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 12015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            int[] var69 = var2.createIntArray();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.a(var58, var60, var62, var69, var1, var7);
            var3.writeNoException();
            return true;
         case 12016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var34;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.f(var58, var7);
            var3.writeNoException();
            return true;
         case 12017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.o(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.b(var58, var60, var62, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 12019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            if(var2.readInt() != 0) {
               var50 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var50 = null;
            }

            this.a(var50);
            var3.writeNoException();
            return true;
         case 12020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.r(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.e(var58, var60, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 12022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.f(var58, var60, var1, var7, var8);
            var3.writeNoException();
            return true;
         case 12023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var7 = this.lM();
            var3.writeNoException();
            var47 = var6;
            if(var7) {
               var47 = 1;
            }

            var3.writeInt(var47);
            return true;
         case 12026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var7 = var32;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.P(var7);
            var3.writeNoException();
            return true;
         case 12027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(IGamesCallbacks.Stub.aD(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var62 = var2.readString();
            var67 = var2.createStringArray();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.a(var58, var60, var62, var67, var7);
            var3.writeNoException();
            return true;
         case 12029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var65 = var2.createStringArray();
            var7 = var37;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var65, var7);
            var3.writeNoException();
            return true;
         case 12030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.b(var2.createIntArray());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var35;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var58, var7, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 12032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var33;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.e(var58, var7);
            var3.writeNoException();
            return true;
         case 12033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var64 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var62 = var2.readString();
            var45 = var2.readString();
            if(var2.readInt() != 0) {
               var68 = SnapshotMetadataChangeEntity.CREATOR.cE(var2);
            } else {
               var68 = null;
            }

            if(var2.readInt() != 0) {
               var50 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var50 = null;
            }

            this.a(var64, var62, var45, var68, var50);
            var3.writeNoException();
            return true;
         case 12034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.bE(var2.readString());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.lB();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 12036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var1 = this.lC();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 13001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var7 = var38;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.Q(var7);
            var3.writeNoException();
            return true;
         case 13002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var66 = var2.readString();
            var63 = var2.readStrongBinder();
            if(var2.readInt() != 0) {
               var49 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            this.a(var66, var63, var49);
            var3.writeNoException();
            return true;
         case 13003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var39;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.g(var58, var7);
            var3.writeNoException();
            return true;
         case 13004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var7 = var40;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.h(var58, var7);
            var3.writeNoException();
            return true;
         case 13005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            AchievementEntity var59 = var45;
            if(var2.readInt() != 0) {
               var59 = AchievementEntity.CREATOR.createFromParcel(var2);
            }

            var48 = this.a(var59);
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 13006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var60 = var2.readString();
            var7 = var41;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.f(var58, var60, var7);
            var3.writeNoException();
            return true;
         case 14001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var48 = this.u(var2.readString(), var2.readInt());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 14002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var58 = IGamesCallbacks.Stub.aD(var2.readStrongBinder());
            var1 = var2.readInt();
            var60 = var2.readString();
            String[] var61 = var2.createStringArray();
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.a(var58, var1, var60, var61, var7);
            var3.writeNoException();
            return true;
         case 14003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            var44 = (ParticipantEntity[])var2.createTypedArray(ParticipantEntity.CREATOR);
            var45 = var2.readString();
            String var46 = var2.readString();
            if(var2.readInt() != 0) {
               var57 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var57 = null;
            }

            if(var2.readInt() != 0) {
               var43 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var43 = null;
            }

            var48 = this.a(var44, var45, var46, var57, var43, var2.readString());
            var3.writeNoException();
            if(var48 != null) {
               var3.writeInt(1);
               var48.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IGamesService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IGamesService {
      private IBinder le;

      Proxy(IBinder var1) {
         this.le = var1;
      }

      public void O(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void P(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void Q(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int a(IGamesCallbacks param1, byte[] param2, String param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(int param1, int param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(int var1, byte[] var2, int var3, String var4) throws RemoteException {
         Parcel var5 = Parcel.obtain();
         Parcel var6 = Parcel.obtain();
         boolean var8 = false;

         Intent var10;
         label36: {
            try {
               var8 = true;
               var5.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var5.writeInt(var1);
               var5.writeByteArray(var2);
               var5.writeInt(var3);
               var5.writeString(var4);
               this.le.transact(10012, var5, var6, 0);
               var6.readException();
               if(var6.readInt() != 0) {
                  var10 = (Intent)Intent.CREATOR.createFromParcel(var6);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var6.recycle();
                  var5.recycle();
               }
            }

            var10 = null;
         }

         var6.recycle();
         var5.recycle();
         return var10;
      }

      public Intent a(AchievementEntity param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(ZInvitationCluster param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(GameRequestCluster param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(RoomEntity param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(String param1, boolean param2, boolean param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(ParticipantEntity[] param1, String param2, String param3, Uri param4, Uri param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent a(ParticipantEntity[] param1, String param2, String param3, Uri param4, Uri param5, String param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.le.transact(8019, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void a(IBinder param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(Contents param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int param2, int param3, String[] param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int param2, String param3, String[] param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int param2, int[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, Bundle param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, IBinder param2, int param3, String[] param4, Bundle param5, boolean param6, long param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, IBinder param2, String param3, boolean param4, long param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5, boolean param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int param3, int[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, long param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, long param3, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, SnapshotMetadataChangeEntity param3, Contents param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, int param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, SnapshotMetadataChangeEntity param4, Contents param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, int[] param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, String[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String param3, String[] param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, byte[] param3, String param4, ParticipantResult[] param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, byte[] param3, ParticipantResult[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, int[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String param2, String[] param3, int param4, byte[] param5, int param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, boolean param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, boolean param2, String[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, int[] param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesCallbacks param1, String[] param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, IBinder param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public int b(byte[] var1, String var2, String[] var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();
         Parcel var6 = Parcel.obtain();

         int var4;
         try {
            var5.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var5.writeByteArray(var1);
            var5.writeString(var2);
            var5.writeStringArray(var3);
            this.le.transact(5034, var5, var6, 0);
            var6.readException();
            var4 = var6.readInt();
         } finally {
            var6.recycle();
            var5.recycle();
         }

         return var4;
      }

      public Intent b(int param1, int param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Intent b(int[] var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var7;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeIntArray(var1);
               this.le.transact(12030, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var7 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var7 = null;
         }

         var3.recycle();
         var2.recycle();
         return var7;
      }

      public void b(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.le.transact(8021, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void b(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(String var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.le.transact(5051, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public Intent bE(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var7;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.le.transact(12034, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var7 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var7 = null;
         }

         var3.recycle();
         var2.recycle();
         return var7;
      }

      public String bG(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.le.transact(5064, var2, var3, 0);
            var3.readException();
            var1 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public String bH(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.le.transact(5035, var2, var3, 0);
            var3.readException();
            var1 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public void bI(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.le.transact(5050, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public int bJ(String var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         int var2;
         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            this.le.transact(5060, var3, var4, 0);
            var4.readException();
            var2 = var4.readInt();
         } finally {
            var4.recycle();
            var3.recycle();
         }

         return var2;
      }

      public Uri bK(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Uri var7;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.le.transact(5066, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var7 = (Uri)Uri.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var7 = null;
         }

         var3.recycle();
         var2.recycle();
         return var7;
      }

      public void bL(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.le.transact(8002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public Intent bM(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var7;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.le.transact(9004, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var7 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var7 = null;
         }

         var3.recycle();
         var2.recycle();
         return var7;
      }

      public ParcelFileDescriptor bN(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         ParcelFileDescriptor var7;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.le.transact(9030, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var7 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var7 = null;
         }

         var3.recycle();
         var2.recycle();
         return var7;
      }

      public void c(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.le.transact(10004, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void c(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(String var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.le.transact(8026, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void d(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.le.transact(12014, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void d(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void dT(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeInt(var1);
            this.le.transact(5036, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void e(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Bundle fX() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Bundle var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(5004, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Bundle)Bundle.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public void g(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void g(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void g(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public ParcelFileDescriptor h(Uri param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public RoomEntity h(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void h(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void h(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void i(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void i(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void j(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void j(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void k(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void l(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int lA() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(10023, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public int lB() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(12035, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public int lC() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(12036, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public void lE() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(5006, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public DataHolder lG() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         DataHolder var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(5013, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = DataHolder.CREATOR.B(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public boolean lH() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(5067, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public DataHolder lI() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         DataHolder var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(5502, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = DataHolder.CREATOR.B(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public void lJ() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(8022, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public Intent lK() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(9013, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public void lL() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(11002, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean lM() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(12025, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public String lh() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(5007, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public String li() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(5012, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public Intent ll() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(9003, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public Intent lm() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(9005, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public Intent ln() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(9006, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public Intent lo() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(9007, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public Intent lt() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(9010, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public Intent lu() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(9012, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public int lv() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(9019, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public String lw() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(5003, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public int lx() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(8024, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public Intent ly() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Intent var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.le.transact(10015, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public int lz() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.le.transact(10013, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public void m(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void n(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void o(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void o(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(12017, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void p(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void p(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(5029, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void q(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.le.transact(5001, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void q(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void q(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(5028, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void r(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.le.transact(5059, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void r(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void s(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.le.transact(8013, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void s(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void s(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(5055, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void t(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.le.transact(10002, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void t(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void t(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(10014, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void t(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeString(var2);
            this.le.transact(5065, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public Intent u(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var6 = false;

         Intent var8;
         label36: {
            try {
               var6 = true;
               var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var3.writeString(var1);
               var3.writeInt(var2);
               this.le.transact(14001, var3, var4, 0);
               var4.readException();
               if(var4.readInt() != 0) {
                  var8 = (Intent)Intent.CREATOR.createFromParcel(var4);
                  var6 = false;
                  break label36;
               }

               var6 = false;
            } finally {
               if(var6) {
                  var4.recycle();
                  var3.recycle();
               }
            }

            var8 = null;
         }

         var4.recycle();
         var3.recycle();
         return var8;
      }

      public void u(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.le.transact(12012, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void u(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void u(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeString(var2);
            this.le.transact(8025, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }
   }
}
