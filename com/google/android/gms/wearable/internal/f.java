package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.d;
import java.io.InputStream;

public final class f implements DataApi {
   private PendingResult a(GoogleApiClient var1, DataApi.DataListener var2, IntentFilter[] var3) {
      return var1.a((BaseImplementation.a)(new f.a(var1, var2, var3, null)));
   }

   private void a(Asset var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("asset is null");
      } else if(var1.getDigest() == null) {
         throw new IllegalArgumentException("invalid asset");
      } else if(var1.getData() != null) {
         throw new IllegalArgumentException("invalid asset");
      }
   }

   public PendingResult addListener(GoogleApiClient var1, DataApi.DataListener var2) {
      return this.a(var1, var2, (IntentFilter[])null);
   }

   public PendingResult deleteDataItems(final GoogleApiClient var1, final Uri var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.c(this, var2);
         }

         protected DataApi.DeleteDataItemsResult aG(Status var1) {
            return new f.c(var1, 0);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aG(var1);
         }
      }));
   }

   public PendingResult getDataItem(final GoogleApiClient var1, final Uri var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.a((BaseImplementation.b)this, (Uri)var2);
         }

         protected DataApi.DataItemResult aE(Status var1) {
            return new f.b(var1, (DataItem)null);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aE(var1);
         }
      }));
   }

   public PendingResult getDataItems(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.n(this);
         }

         protected DataItemBuffer aF(Status var1) {
            return new DataItemBuffer(DataHolder.av(var1.getStatusCode()));
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aF(var1);
         }
      }));
   }

   public PendingResult getDataItems(final GoogleApiClient var1, final Uri var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.b(this, (Uri)var2);
         }

         protected DataItemBuffer aF(Status var1) {
            return new DataItemBuffer(DataHolder.av(var1.getStatusCode()));
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aF(var1);
         }
      }));
   }

   public PendingResult getFdForAsset(final GoogleApiClient var1, final Asset var2) {
      this.a(var2);
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.a((BaseImplementation.b)this, (Asset)var2);
         }

         protected DataApi.GetFdForAssetResult aH(Status var1) {
            return new f.d(var1, (ParcelFileDescriptor)null);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aH(var1);
         }
      }));
   }

   public PendingResult getFdForAsset(final GoogleApiClient var1, final DataItemAsset var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.a((BaseImplementation.b)this, (DataItemAsset)var2);
         }

         protected DataApi.GetFdForAssetResult aH(Status var1) {
            return new f.d(var1, (ParcelFileDescriptor)null);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aH(var1);
         }
      }));
   }

   public PendingResult putDataItem(final GoogleApiClient var1, final PutDataRequest var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.a((BaseImplementation.b)this, (PutDataRequest)var2);
         }

         public DataApi.DataItemResult aE(Status var1) {
            return new f.b(var1, (DataItem)null);
         }

         // $FF: synthetic method
         public Result c(Status var1) {
            return this.aE(var1);
         }
      }));
   }

   public PendingResult removeListener(final GoogleApiClient var1, final DataApi.DataListener var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.a((BaseImplementation.b)this, (DataApi.DataListener)var2);
         }

         public Status b(Status var1) {
            return var1;
         }

         // $FF: synthetic method
         public Result c(Status var1) {
            return this.b(var1);
         }
      }));
   }

   private static final class a extends d {
      private DataApi.DataListener axC;
      private IntentFilter[] axD;

      private a(GoogleApiClient var1, DataApi.DataListener var2, IntentFilter[] var3) {
         super(var1);
         this.axC = var2;
         this.axD = var3;
      }

      // $FF: synthetic method
      a(GoogleApiClient var1, DataApi.DataListener var2, IntentFilter[] var3, Object var4) {
         this(var1, var2, var3);
      }

      protected void a(ba var1) throws RemoteException {
         var1.a(this, (DataApi.DataListener)this.axC, this.axD);
         this.axC = null;
         this.axD = null;
      }

      public Status b(Status var1) {
         this.axC = null;
         this.axD = null;
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }

   public static class b implements DataApi.DataItemResult {
      private final Status Eb;
      private final DataItem axE;

      public b(Status var1, DataItem var2) {
         this.Eb = var1;
         this.axE = var2;
      }

      public DataItem getDataItem() {
         return this.axE;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   public static class c implements DataApi.DeleteDataItemsResult {
      private final Status Eb;
      private final int axF;

      public c(Status var1, int var2) {
         this.Eb = var1;
         this.axF = var2;
      }

      public int getNumDeleted() {
         return this.axF;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   public static class d implements DataApi.GetFdForAssetResult {
      private final Status Eb;
      private volatile InputStream ZO;
      private volatile ParcelFileDescriptor axG;
      private volatile boolean mClosed = false;

      public d(Status var1, ParcelFileDescriptor var2) {
         this.Eb = var1;
         this.axG = var2;
      }

      public ParcelFileDescriptor getFd() {
         if(this.mClosed) {
            throw new IllegalStateException("Cannot access the file descriptor after release().");
         } else {
            return this.axG;
         }
      }

      public InputStream getInputStream() {
         if(this.mClosed) {
            throw new IllegalStateException("Cannot access the input stream after release().");
         } else if(this.axG == null) {
            return null;
         } else {
            if(this.ZO == null) {
               this.ZO = new AutoCloseInputStream(this.axG);
            }

            return this.ZO;
         }
      }

      public Status getStatus() {
         return this.Eb;
      }

      public void release() {
         // $FF: Couldn't be decompiled
      }
   }
}
