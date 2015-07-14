package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jx;

public class OpenFileActivityBuilder {
   public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
   private String OH;
   private String[] OI;
   private DriveId OJ;

   public IntentSender build(GoogleApiClient var1) {
      jx.a(var1.isConnected(), "Client must be connected");
      if(this.OI == null) {
         this.OI = new String[0];
      }

      try {
         IntentSender var3 = ((r)var1.a(Drive.DQ)).iG().a(new OpenFileIntentSenderRequest(this.OH, this.OI, this.OJ));
         return var3;
      } catch (RemoteException var2) {
         throw new RuntimeException("Unable to connect Drive Play Service", var2);
      }
   }

   public OpenFileActivityBuilder setActivityStartFolder(DriveId var1) {
      this.OJ = (DriveId)jx.i(var1);
      return this;
   }

   public OpenFileActivityBuilder setActivityTitle(String var1) {
      this.OH = (String)jx.i(var1);
      return this;
   }

   public OpenFileActivityBuilder setMimeType(String[] var1) {
      boolean var2;
      if(var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.b(var2, "mimeTypes may not be null");
      this.OI = var1;
      return this;
   }
}
