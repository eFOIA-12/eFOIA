package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nh;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.nn;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.ns;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.nw;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.oc;
import com.google.android.gms.internal.oe;
import com.google.android.gms.internal.og;
import com.google.android.gms.internal.oh;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

public interface ni extends IInterface {
   void S(boolean var1) throws RemoteException;

   void a(long var1, boolean var3, PendingIntent var4) throws RemoteException;

   void a(PendingIntent var1) throws RemoteException;

   void a(PendingIntent var1, nh var2, String var3) throws RemoteException;

   void a(Location var1, int var2) throws RemoteException;

   void a(nh var1, String var2) throws RemoteException;

   void a(nl var1, PendingIntent var2) throws RemoteException;

   void a(nl var1, com.google.android.gms.location.b var2) throws RemoteException;

   void a(ns var1, oh var2, PendingIntent var3) throws RemoteException;

   void a(nu var1, oh var2, og var3) throws RemoteException;

   void a(nw var1, oh var2) throws RemoteException;

   void a(ny var1, oh var2, PendingIntent var3) throws RemoteException;

   void a(oc var1, oh var2, og var3) throws RemoteException;

   void a(oe var1, LatLngBounds var2, List var3, oh var4, og var5) throws RemoteException;

   void a(oh var1, PendingIntent var2) throws RemoteException;

   void a(GeofencingRequest var1, PendingIntent var2, nh var3) throws RemoteException;

   void a(LocationRequest var1, PendingIntent var2) throws RemoteException;

   void a(LocationRequest var1, com.google.android.gms.location.b var2) throws RemoteException;

   void a(LocationRequest var1, com.google.android.gms.location.b var2, String var3) throws RemoteException;

   void a(com.google.android.gms.location.b var1) throws RemoteException;

   void a(LatLng var1, nu var2, oh var3, og var4) throws RemoteException;

   void a(LatLngBounds var1, int var2, nu var3, oh var4, og var5) throws RemoteException;

   void a(LatLngBounds var1, int var2, String var3, nu var4, oh var5, og var6) throws RemoteException;

   void a(String var1, oh var2, og var3) throws RemoteException;

   void a(String var1, LatLngBounds var2, nq var3, oh var4, og var5) throws RemoteException;

   void a(List var1, PendingIntent var2, nh var3, String var4) throws RemoteException;

   void a(List var1, oh var2, og var3) throws RemoteException;

   void a(String[] var1, nh var2, String var3) throws RemoteException;

   void b(PendingIntent var1) throws RemoteException;

   void b(Location var1) throws RemoteException;

   void b(oh var1, PendingIntent var2) throws RemoteException;

   void b(String var1, oh var2, og var3) throws RemoteException;

   Location bZ(String var1) throws RemoteException;

   com.google.android.gms.location.e ca(String var1) throws RemoteException;

   Location ni() throws RemoteException;

   IBinder nj() throws RemoteException;

   IBinder nk() throws RemoteException;

   public abstract static class a extends Binder implements ni {
      public static ni aO(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (ni)(var1 != null && var1 instanceof ni?(ni)var1:new ni.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var5 = false;
         Object var17 = null;
         Object var18 = null;
         oh var10 = null;
         Object var13 = null;
         String var11 = null;
         oh var9 = null;
         Object var14 = null;
         Object var15 = null;
         Object var12 = null;
         oh var8 = null;
         Object var16 = null;
         IBinder var19;
         PendingIntent var20;
         Location var23;
         ArrayList var24;
         LatLngBounds var27;
         nl var29;
         nu var33;
         String var35;
         LocationRequest var38;
         PendingIntent var42;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var24 = var2.createTypedArrayList(nn.CREATOR);
            if(var2.readInt() != 0) {
               var42 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var42 = null;
            }

            this.a(var24, var42, nh.a.aN(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var42 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var42 = null;
            }

            this.a(var42, nh.a.aN(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(var2.createStringArray(), nh.a.aN(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(nh.a.aN(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            long var6 = var2.readLong();
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var6, var5, var20);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var20);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var23 = this.ni();
            var3.writeNoException();
            if(var23 != null) {
               var3.writeInt(1);
               var23.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var38 = (LocationRequest)var16;
            if(var2.readInt() != 0) {
               var38 = LocationRequest.CREATOR.cJ(var2);
            }

            this.a(var38, com.google.android.gms.location.b.aL(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var38 = LocationRequest.CREATOR.cJ(var2);
            } else {
               var38 = null;
            }

            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var38, var20);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(com.google.android.gms.location.b.aL(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.b(var20);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var5 = true;
            }

            this.S(var5);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var23 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var23 = null;
            }

            this.b(var23);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var27 = LatLngBounds.CREATOR.dd(var2);
            } else {
               var27 = null;
            }

            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var33 = nu.CREATOR.cQ(var2);
            } else {
               var33 = null;
            }

            if(var2.readInt() != 0) {
               var10 = oh.CREATOR.cW(var2);
            } else {
               var10 = null;
            }

            this.a(var27, var1, var33, var10, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var35 = var2.readString();
            var8 = (oh)var13;
            if(var2.readInt() != 0) {
               var8 = oh.CREATOR.cW(var2);
            }

            this.a(var35, var8, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LatLng var41;
            if(var2.readInt() != 0) {
               var41 = LatLng.CREATOR.de(var2);
            } else {
               var41 = null;
            }

            if(var2.readInt() != 0) {
               var33 = nu.CREATOR.cQ(var2);
            } else {
               var33 = null;
            }

            var10 = var11;
            if(var2.readInt() != 0) {
               var10 = oh.CREATOR.cW(var2);
            }

            this.a(var41, var33, var10, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            nu var40;
            if(var2.readInt() != 0) {
               var40 = nu.CREATOR.cQ(var2);
            } else {
               var40 = null;
            }

            if(var2.readInt() != 0) {
               var9 = oh.CREATOR.cW(var2);
            }

            this.a(var40, var9, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ny var39;
            if(var2.readInt() != 0) {
               var39 = ny.CREATOR.cS(var2);
            } else {
               var39 = null;
            }

            if(var2.readInt() != 0) {
               var9 = oh.CREATOR.cW(var2);
            } else {
               var9 = null;
            }

            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var39, var9, var20);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var8 = oh.CREATOR.cW(var2);
            } else {
               var8 = null;
            }

            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var8, var20);
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var38 = (LocationRequest)var17;
            if(var2.readInt() != 0) {
               var38 = LocationRequest.CREATOR.cJ(var2);
            }

            this.a(var38, com.google.android.gms.location.b.aL(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var23 = this.bZ(var2.readString());
            var3.writeNoException();
            if(var23 != null) {
               var3.writeInt(1);
               var23.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            nw var21;
            if(var2.readInt() != 0) {
               var21 = nw.CREATOR.cR(var2);
            } else {
               var21 = null;
            }

            if(var2.readInt() != 0) {
               var8 = oh.CREATOR.cW(var2);
            }

            this.a(var21, var8);
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var37;
            if(var2.readInt() != 0) {
               var37 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var37 = null;
            }

            this.a(var37, var2.readInt());
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            com.google.android.gms.location.e var22 = this.ca(var2.readString());
            var3.writeNoException();
            if(var22 != null) {
               var3.writeInt(1);
               var22.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var35 = var2.readString();
            var8 = (oh)var14;
            if(var2.readInt() != 0) {
               var8 = oh.CREATOR.cW(var2);
            }

            this.b(var35, var8, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            oc var36;
            if(var2.readInt() != 0) {
               var36 = (oc)oc.CREATOR.createFromParcel(var2);
            } else {
               var36 = null;
            }

            var9 = (oh)var12;
            if(var2.readInt() != 0) {
               var9 = oh.CREATOR.cW(var2);
            }

            this.a(var36, var9, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 47:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var27 = LatLngBounds.CREATOR.dd(var2);
            } else {
               var27 = null;
            }

            var1 = var2.readInt();
            var11 = var2.readString();
            if(var2.readInt() != 0) {
               var33 = nu.CREATOR.cQ(var2);
            } else {
               var33 = null;
            }

            if(var2.readInt() != 0) {
               var10 = oh.CREATOR.cW(var2);
            }

            this.a(var27, var1, var11, var33, var10, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 48:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ns var34;
            if(var2.readInt() != 0) {
               var34 = ns.CREATOR.cP(var2);
            } else {
               var34 = null;
            }

            if(var2.readInt() != 0) {
               var9 = oh.CREATOR.cW(var2);
            } else {
               var9 = null;
            }

            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var34, var9, var20);
            var3.writeNoException();
            return true;
         case 49:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var8 = oh.CREATOR.cW(var2);
            } else {
               var8 = null;
            }

            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.b(var8, var20);
            var3.writeNoException();
            return true;
         case 50:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            oe var32;
            if(var2.readInt() != 0) {
               var32 = oe.CREATOR.cV(var2);
            } else {
               var32 = null;
            }

            LatLngBounds var30;
            if(var2.readInt() != 0) {
               var30 = LatLngBounds.CREATOR.dd(var2);
            } else {
               var30 = null;
            }

            ArrayList var31 = var2.createStringArrayList();
            if(var2.readInt() != 0) {
               var10 = oh.CREATOR.cW(var2);
            } else {
               var10 = null;
            }

            this.a(var32, var30, var31, var10, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 51:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var19 = this.nj();
            var3.writeNoException();
            var3.writeStrongBinder(var19);
            return true;
         case 52:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var29 = (nl)var18;
            if(var2.readInt() != 0) {
               var29 = nl.CREATOR.cM(var2);
            }

            this.a(var29, com.google.android.gms.location.b.aL(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 53:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if(var2.readInt() != 0) {
               var29 = nl.CREATOR.cM(var2);
            } else {
               var29 = null;
            }

            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var29, var20);
            var3.writeNoException();
            return true;
         case 54:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var19 = this.nk();
            var3.writeNoException();
            var3.writeStrongBinder(var19);
            return true;
         case 55:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var11 = var2.readString();
            if(var2.readInt() != 0) {
               var27 = LatLngBounds.CREATOR.dd(var2);
            } else {
               var27 = null;
            }

            nq var28;
            if(var2.readInt() != 0) {
               var28 = nq.CREATOR.cO(var2);
            } else {
               var28 = null;
            }

            if(var2.readInt() != 0) {
               var10 = oh.CREATOR.cW(var2);
            } else {
               var10 = null;
            }

            this.a(var11, var27, var28, var10, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 57:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            GeofencingRequest var25;
            if(var2.readInt() != 0) {
               var25 = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(var2);
            } else {
               var25 = null;
            }

            PendingIntent var26;
            if(var2.readInt() != 0) {
               var26 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var26 = null;
            }

            this.a(var25, var26, nh.a.aN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 58:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            var24 = var2.createStringArrayList();
            var8 = (oh)var15;
            if(var2.readInt() != 0) {
               var8 = oh.CREATOR.cW(var2);
            }

            this.a(var24, var8, og.a.aP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ni {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void S(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(long param1, boolean param3, PendingIntent param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(PendingIntent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(PendingIntent param1, nh param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(Location param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(nh param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(nl param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(nl param1, com.google.android.gms.location.b param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ns param1, oh param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(nu param1, oh param2, og param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(nw param1, oh param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ny param1, oh param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(oc param1, oh param2, og param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(oe param1, LatLngBounds param2, List param3, oh param4, og param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(oh param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(GeofencingRequest param1, PendingIntent param2, nh param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(LocationRequest param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(LocationRequest param1, com.google.android.gms.location.b param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(LocationRequest param1, com.google.android.gms.location.b param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.location.b param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(LatLng param1, nu param2, oh param3, og param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(LatLngBounds param1, int param2, nu param3, oh param4, og param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(LatLngBounds param1, int param2, String param3, nu param4, oh param5, og param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, oh param2, og param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, LatLngBounds param2, nq param3, oh param4, og param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(List param1, PendingIntent param2, nh param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(List param1, oh param2, og param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String[] param1, nh param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(PendingIntent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(oh param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(String param1, oh param2, og param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Location bZ(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Location var7;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               var2.writeString(var1);
               this.le.transact(21, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var7 = (Location)Location.CREATOR.createFromParcel(var3);
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

      public com.google.android.gms.location.e ca(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         com.google.android.gms.location.e var7;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               var2.writeString(var1);
               this.le.transact(34, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var7 = com.google.android.gms.location.e.CREATOR.cK(var3);
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

      public Location ni() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Location var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               this.le.transact(7, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Location)Location.CREATOR.createFromParcel(var3);
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

      public IBinder nj() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IBinder var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.le.transact(51, var1, var2, 0);
            var2.readException();
            var3 = var2.readStrongBinder();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public IBinder nk() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IBinder var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.le.transact(54, var1, var2, 0);
            var2.readException();
            var3 = var2.readStrongBinder();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }
   }
}
