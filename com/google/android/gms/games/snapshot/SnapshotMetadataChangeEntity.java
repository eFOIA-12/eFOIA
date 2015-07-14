package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;
import com.google.android.gms.internal.jx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
   public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
   private final int CK;
   private final String UO;
   private final Uri afd;
   private final Long afe;
   private a aff;

   SnapshotMetadataChangeEntity() {
      this(4, (String)null, (Long)null, (a)null, (Uri)null);
   }

   SnapshotMetadataChangeEntity(int var1, String var2, Long var3, a var4, Uri var5) {
      boolean var7 = true;
      boolean var6 = true;
      super();
      this.CK = var1;
      this.UO = var2;
      this.afe = var3;
      this.aff = var4;
      this.afd = var5;
      if(this.aff != null) {
         if(this.afd != null) {
            var6 = false;
         }

         jx.a(var6, "Cannot set both a URI and an image");
      } else if(this.afd != null) {
         if(this.aff == null) {
            var6 = var7;
         } else {
            var6 = false;
         }

         jx.a(var6, "Cannot set both a URI and an image");
         return;
      }

   }

   SnapshotMetadataChangeEntity(String var1, Long var2, a var3, Uri var4) {
      this(4, var1, var2, var3, var4);
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap getCoverImage() {
      return this.aff == null?null:this.aff.gT();
   }

   public Uri getCoverImageUri() {
      return this.afd;
   }

   public String getDescription() {
      return this.UO;
   }

   public Long getPlayedTimeMillis() {
      return this.afe;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public a mT() {
      return this.aff;
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataChangeCreator.a(this, var1, var2);
   }
}
