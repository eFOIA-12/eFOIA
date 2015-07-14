package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jx;

public class i {
   private String OH;
   private DriveId OJ;
   protected MetadataChangeSet Pu;
   private Integer Pv;
   private final int Pw;

   public i(int var1) {
      this.Pw = var1;
   }

   public void a(DriveId var1) {
      this.OJ = (DriveId)jx.i(var1);
   }

   public void a(MetadataChangeSet var1) {
      this.Pu = (MetadataChangeSet)jx.i(var1);
   }

   public void bl(String var1) {
      this.OH = (String)jx.i(var1);
   }

   public void bq(int var1) {
      this.Pv = Integer.valueOf(var1);
   }

   public IntentSender build(GoogleApiClient var1) {
      jx.b((Object)this.Pu, "Must provide initial metadata to CreateFileActivityBuilder.");
      jx.a(var1.isConnected(), "Client must be connected");
      r var4 = (r)var1.a(Drive.DQ);
      this.Pu.iz().setContext(var4.getContext());
      int var2;
      if(this.Pv == null) {
         var2 = -1;
      } else {
         var2 = this.Pv.intValue();
      }

      try {
         IntentSender var5 = var4.iG().a(new CreateFileIntentSenderRequest(this.Pu.iz(), var2, this.OH, this.OJ, this.Pw));
         return var5;
      } catch (RemoteException var3) {
         throw new RuntimeException("Unable to connect Drive Play Service", var3);
      }
   }
}
