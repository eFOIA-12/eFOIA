package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.ly;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.mc;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.mp;

public interface lz extends IInterface {
   void a(DataDeleteRequest var1, md var2, String var3) throws RemoteException;

   void a(DataReadRequest var1, lw var2, String var3) throws RemoteException;

   void a(DataSourcesRequest var1, lx var2, String var3) throws RemoteException;

   void a(DataTypeCreateRequest var1, ly var2, String var3) throws RemoteException;

   void a(SessionInsertRequest var1, md var2, String var3) throws RemoteException;

   void a(SessionReadRequest var1, mb var2, String var3) throws RemoteException;

   void a(StartBleScanRequest var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.aa var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.ad var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.af var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.ah var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.aj var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.b var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.e var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.j var1, ly var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.m var1, ma var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.o var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.q var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.u var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.w var1, md var2, String var3) throws RemoteException;

   void a(com.google.android.gms.fitness.request.y var1, mc var2, String var3) throws RemoteException;

   void a(md var1, String var2) throws RemoteException;

   void a(mp var1, String var2) throws RemoteException;

   void b(md var1, String var2) throws RemoteException;

   public abstract static class a extends Binder implements lz {
      public static lz av(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return (lz)(var1 != null && var1 instanceof lz?(lz)var1:new lz.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         Object var7 = null;
         Object var8 = null;
         Object var9 = null;
         Object var10 = null;
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
         DataDeleteRequest var5 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            DataSourcesRequest var45 = var5;
            if(var2.readInt() != 0) {
               var45 = (DataSourcesRequest)DataSourcesRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var45, lx.a.at(var2.readStrongBinder()), var2.readString());
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.o var44 = (com.google.android.gms.fitness.request.o)var6;
            if(var2.readInt() != 0) {
               var44 = (com.google.android.gms.fitness.request.o)com.google.android.gms.fitness.request.o.CREATOR.createFromParcel(var2);
            }

            this.a(var44, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.q var43 = (com.google.android.gms.fitness.request.q)var7;
            if(var2.readInt() != 0) {
               var43 = (com.google.android.gms.fitness.request.q)com.google.android.gms.fitness.request.q.CREATOR.createFromParcel(var2);
            }

            this.a(var43, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.af var42 = (com.google.android.gms.fitness.request.af)var8;
            if(var2.readInt() != 0) {
               var42 = (com.google.android.gms.fitness.request.af)com.google.android.gms.fitness.request.af.CREATOR.createFromParcel(var2);
            }

            this.a(var42, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.aj var41 = (com.google.android.gms.fitness.request.aj)var9;
            if(var2.readInt() != 0) {
               var41 = (com.google.android.gms.fitness.request.aj)com.google.android.gms.fitness.request.aj.CREATOR.createFromParcel(var2);
            }

            this.a(var41, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.m var40 = (com.google.android.gms.fitness.request.m)var10;
            if(var2.readInt() != 0) {
               var40 = (com.google.android.gms.fitness.request.m)com.google.android.gms.fitness.request.m.CREATOR.createFromParcel(var2);
            }

            this.a(var40, ma.a.aw(var2.readStrongBinder()), var2.readString());
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.e var39 = (com.google.android.gms.fitness.request.e)var11;
            if(var2.readInt() != 0) {
               var39 = (com.google.android.gms.fitness.request.e)com.google.android.gms.fitness.request.e.CREATOR.createFromParcel(var2);
            }

            this.a(var39, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            DataReadRequest var38 = (DataReadRequest)var15;
            if(var2.readInt() != 0) {
               var38 = (DataReadRequest)DataReadRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var38, lw.a.as(var2.readStrongBinder()), var2.readString());
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            SessionInsertRequest var37 = (SessionInsertRequest)var16;
            if(var2.readInt() != 0) {
               var37 = (SessionInsertRequest)SessionInsertRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var37, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            SessionReadRequest var36 = (SessionReadRequest)var17;
            if(var2.readInt() != 0) {
               var36 = (SessionReadRequest)SessionReadRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var36, mb.a.ax(var2.readStrongBinder()), var2.readString());
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.w var35 = (com.google.android.gms.fitness.request.w)var18;
            if(var2.readInt() != 0) {
               var35 = (com.google.android.gms.fitness.request.w)com.google.android.gms.fitness.request.w.CREATOR.createFromParcel(var2);
            }

            this.a(var35, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.y var34 = (com.google.android.gms.fitness.request.y)var19;
            if(var2.readInt() != 0) {
               var34 = (com.google.android.gms.fitness.request.y)com.google.android.gms.fitness.request.y.CREATOR.createFromParcel(var2);
            }

            this.a(var34, mc.a.ay(var2.readStrongBinder()), var2.readString());
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            DataTypeCreateRequest var33 = (DataTypeCreateRequest)var13;
            if(var2.readInt() != 0) {
               var33 = (DataTypeCreateRequest)DataTypeCreateRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var33, ly.a.au(var2.readStrongBinder()), var2.readString());
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.j var32 = (com.google.android.gms.fitness.request.j)var14;
            if(var2.readInt() != 0) {
               var32 = (com.google.android.gms.fitness.request.j)com.google.android.gms.fitness.request.j.CREATOR.createFromParcel(var2);
            }

            this.a(var32, ly.a.au(var2.readStrongBinder()), var2.readString());
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            StartBleScanRequest var31 = (StartBleScanRequest)var20;
            if(var2.readInt() != 0) {
               var31 = (StartBleScanRequest)StartBleScanRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var31, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.ad var30 = (com.google.android.gms.fitness.request.ad)var21;
            if(var2.readInt() != 0) {
               var30 = (com.google.android.gms.fitness.request.ad)com.google.android.gms.fitness.request.ad.CREATOR.createFromParcel(var2);
            }

            this.a(var30, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.b var29 = (com.google.android.gms.fitness.request.b)var22;
            if(var2.readInt() != 0) {
               var29 = (com.google.android.gms.fitness.request.b)com.google.android.gms.fitness.request.b.CREATOR.createFromParcel(var2);
            }

            this.a(var29, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.ah var28 = (com.google.android.gms.fitness.request.ah)var23;
            if(var2.readInt() != 0) {
               var28 = (com.google.android.gms.fitness.request.ah)com.google.android.gms.fitness.request.ah.CREATOR.createFromParcel(var2);
            }

            this.a(var28, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            var5 = (DataDeleteRequest)var12;
            if(var2.readInt() != 0) {
               var5 = (DataDeleteRequest)DataDeleteRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var5, md.a.az(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.u var27 = (com.google.android.gms.fitness.request.u)var24;
            if(var2.readInt() != 0) {
               var27 = (com.google.android.gms.fitness.request.u)com.google.android.gms.fitness.request.u.CREATOR.createFromParcel(var2);
            }

            this.a(var27, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            com.google.android.gms.fitness.request.aa var26 = (com.google.android.gms.fitness.request.aa)var25;
            if(var2.readInt() != 0) {
               var26 = (com.google.android.gms.fitness.request.aa)com.google.android.gms.fitness.request.aa.CREATOR.createFromParcel(var2);
            }

            this.a(var26, md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            this.a(md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            this.b(md.a.az(var2.readStrongBinder()), var2.readString());
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            this.a(mp.a.aA(var2.readStrongBinder()), var2.readString());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements lz {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(DataDeleteRequest param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataReadRequest param1, lw param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataSourcesRequest param1, lx param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataTypeCreateRequest param1, ly param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(SessionInsertRequest param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(SessionReadRequest param1, mb param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(StartBleScanRequest param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.aa param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.ad param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.af param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.ah param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.aj param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.b param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.e param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.j param1, ly param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.m param1, ma param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.o param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.q param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.u param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.w param1, md param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.fitness.request.y param1, mc param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(md param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(mp param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(md param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
