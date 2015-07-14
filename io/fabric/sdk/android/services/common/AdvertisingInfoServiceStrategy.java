package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.AdvertisingInfo;
import io.fabric.sdk.android.services.common.AdvertisingInfoStrategy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class AdvertisingInfoServiceStrategy implements AdvertisingInfoStrategy {
   public static final String GOOGLE_PLAY_SERVICES_INTENT = "com.google.android.gms.ads.identifier.service.START";
   public static final String GOOGLE_PLAY_SERVICES_INTENT_PACKAGE_NAME = "com.google.android.gms";
   private static final String GOOGLE_PLAY_SERVICE_PACKAGE_NAME = "com.android.vending";
   private final Context context;

   public AdvertisingInfoServiceStrategy(Context var1) {
      this.context = var1.getApplicationContext();
   }

   public AdvertisingInfo getAdvertisingInfo() {
      // $FF: Couldn't be decompiled
   }

   private static final class AdvertisingConnection implements ServiceConnection {
      private static final int QUEUE_TIMEOUT_IN_MS = 200;
      private final LinkedBlockingQueue queue;
      private boolean retrieved;

      private AdvertisingConnection() {
         this.retrieved = false;
         this.queue = new LinkedBlockingQueue(1);
      }

      // $FF: synthetic method
      AdvertisingConnection(Object var1) {
         this();
      }

      public IBinder getBinder() {
         if(this.retrieved) {
            Fabric.getLogger().e("Fabric", "getBinder already called");
         }

         this.retrieved = true;

         try {
            IBinder var1 = (IBinder)this.queue.poll(200L, TimeUnit.MILLISECONDS);
            return var1;
         } catch (InterruptedException var2) {
            return null;
         }
      }

      public void onServiceConnected(ComponentName var1, IBinder var2) {
         try {
            this.queue.put(var2);
         } catch (InterruptedException var3) {
            ;
         }
      }

      public void onServiceDisconnected(ComponentName var1) {
         this.queue.clear();
      }
   }

   private static final class AdvertisingInterface implements IInterface {
      public static final String ADVERTISING_ID_SERVICE_INTERFACE_TOKEN = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
      private static final int AD_TRANSACTION_CODE_ID = 1;
      private static final int AD_TRANSACTION_CODE_LIMIT_AD_TRACKING = 2;
      private static final int FLAGS_NONE = 0;
      private final IBinder binder;

      public AdvertisingInterface(IBinder var1) {
         this.binder = var1;
      }

      public IBinder asBinder() {
         return this.binder;
      }

      public String getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.binder.transact(1, var1, var2, 0);
            var2.readException();
            String var3 = var2.readString();
            return var3;
         } catch (Exception var6) {
            Fabric.getLogger().d("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return null;
      }

      public boolean isLimitAdTrackingEnabled() throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var8 = false;

         int var1;
         label49: {
            try {
               var8 = true;
               var3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
               var3.writeInt(1);
               this.binder.transact(2, var3, var4, 0);
               var4.readException();
               var1 = var4.readInt();
               var8 = false;
               break label49;
            } catch (Exception var9) {
               Fabric.getLogger().d("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
               var8 = false;
            } finally {
               if(var8) {
                  var4.recycle();
                  var3.recycle();
               }
            }

            var4.recycle();
            var3.recycle();
            return false;
         }

         boolean var2;
         if(var1 != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }
   }
}
