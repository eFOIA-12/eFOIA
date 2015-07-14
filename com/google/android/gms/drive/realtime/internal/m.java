package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest;
import com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;
import com.google.android.gms.drive.realtime.internal.c;
import com.google.android.gms.drive.realtime.internal.d;
import com.google.android.gms.drive.realtime.internal.e;
import com.google.android.gms.drive.realtime.internal.f;
import com.google.android.gms.drive.realtime.internal.g;
import com.google.android.gms.drive.realtime.internal.h;
import com.google.android.gms.drive.realtime.internal.i;
import com.google.android.gms.drive.realtime.internal.j;
import com.google.android.gms.drive.realtime.internal.k;
import com.google.android.gms.drive.realtime.internal.l;
import com.google.android.gms.drive.realtime.internal.n;
import com.google.android.gms.drive.realtime.internal.o;

public interface m extends IInterface {
   void a(int var1, j var2) throws RemoteException;

   void a(BeginCompoundOperationRequest var1, o var2) throws RemoteException;

   void a(EndCompoundOperationRequest var1, j var2) throws RemoteException;

   void a(EndCompoundOperationRequest var1, o var2) throws RemoteException;

   void a(ParcelableIndexReference var1, n var2) throws RemoteException;

   void a(c var1) throws RemoteException;

   void a(d var1) throws RemoteException;

   void a(e var1) throws RemoteException;

   void a(h var1) throws RemoteException;

   void a(i var1) throws RemoteException;

   void a(j var1) throws RemoteException;

   void a(l var1) throws RemoteException;

   void a(o var1) throws RemoteException;

   void a(String var1, int var2, int var3, g var4) throws RemoteException;

   void a(String var1, int var2, int var3, j var4) throws RemoteException;

   void a(String var1, int var2, DataHolder var3, g var4) throws RemoteException;

   void a(String var1, int var2, DataHolder var3, j var4) throws RemoteException;

   void a(String var1, int var2, o var3) throws RemoteException;

   void a(String var1, int var2, String var3, int var4, j var5) throws RemoteException;

   void a(String var1, int var2, String var3, j var4) throws RemoteException;

   void a(String var1, DataHolder var2, j var3) throws RemoteException;

   void a(String var1, f var2) throws RemoteException;

   void a(String var1, j var2) throws RemoteException;

   void a(String var1, k var2) throws RemoteException;

   void a(String var1, l var2) throws RemoteException;

   void a(String var1, n var2) throws RemoteException;

   void a(String var1, o var2) throws RemoteException;

   void a(String var1, String var2, f var3) throws RemoteException;

   void a(String var1, String var2, g var3) throws RemoteException;

   void a(String var1, String var2, j var3) throws RemoteException;

   void b(c var1) throws RemoteException;

   void b(j var1) throws RemoteException;

   void b(l var1) throws RemoteException;

   void b(o var1) throws RemoteException;

   void b(String var1, f var2) throws RemoteException;

   void b(String var1, l var2) throws RemoteException;

   void b(String var1, n var2) throws RemoteException;

   void b(String var1, o var2) throws RemoteException;

   void c(c var1) throws RemoteException;

   void c(String var1, l var2) throws RemoteException;

   void d(c var1) throws RemoteException;

   public abstract static class a extends Binder implements m {
      public static m al(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (m)(var1 != null && var1 instanceof m?(m)var1:new m.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         String var6 = null;
         String var7 = null;
         Object var8 = null;
         Object var9 = null;
         Object var10 = null;
         Object var11 = null;
         DataHolder var5 = null;
         EndCompoundOperationRequest var12;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), n.a.am(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(c.a.ab(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(o.a.an(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readString(), f.a.ae(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), l.a.ak(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            var6 = var2.readString();
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.a(var6, var5, j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(var2.readString(), l.a.ak(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(var2.readString(), n.a.am(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readInt(), var2.readString(), j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readInt(), var2.readInt(), j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readString(), j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(var2.readString(), f.a.ae(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.c(var2.readString(), l.a.ak(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            var7 = var2.readString();
            var1 = var2.readInt();
            var5 = var6;
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.a(var7, var1, var5, j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            var6 = var2.readString();
            var1 = var2.readInt();
            var5 = var7;
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.a(var6, var1, var5, g.a.af(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readInt(), var2.readInt(), g.a.af(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            BeginCompoundOperationRequest var14 = (BeginCompoundOperationRequest)var8;
            if(var2.readInt() != 0) {
               var14 = (BeginCompoundOperationRequest)BeginCompoundOperationRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var14, o.a.an(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            var12 = (EndCompoundOperationRequest)var11;
            if(var2.readInt() != 0) {
               var12 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var12, o.a.an(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), f.a.ae(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readString(), g.a.af(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.c(c.a.ab(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.d(c.a.ab(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            ParcelableIndexReference var13 = (ParcelableIndexReference)var10;
            if(var2.readInt() != 0) {
               var13 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(var2);
            }

            this.a(var13, n.a.am(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), k.a.aj(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readInt(), o.a.an(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(l.a.ak(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readInt(), j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(e.a.ad(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(d.a.ac(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(c.a.ab(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(i.a.ah(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(o.a.an(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(h.a.ag(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), var2.readInt(), var2.readString(), var2.readInt(), j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 38:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(var2.readString(), o.a.an(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 39:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.b(var2.readString(), o.a.an(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            this.a(l.a.ak(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            var12 = (EndCompoundOperationRequest)var9;
            if(var2.readInt() != 0) {
               var12 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var12, j.a.ai(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements m {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(int param1, j param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(BeginCompoundOperationRequest param1, o param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(EndCompoundOperationRequest param1, j param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(EndCompoundOperationRequest param1, o param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ParcelableIndexReference param1, n param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(c param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(e param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(h param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(i param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(j param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(o param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, int param2, int param3, g param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, int param2, int param3, j param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, int param2, DataHolder param3, g param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, int param2, DataHolder param3, j param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, int param2, o param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, int param2, String param3, int param4, j param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, int param2, String param3, j param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, DataHolder param2, j param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, f param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, j param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, k param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, l param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, n param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, o param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, String param2, f param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, String param2, g param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, String param2, j param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(c param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(j param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(o param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(String param1, f param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(String param1, l param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(String param1, n param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(String param1, o param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(c param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(String param1, l param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(c param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
