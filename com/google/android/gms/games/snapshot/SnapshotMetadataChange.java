package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.a;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

public abstract class SnapshotMetadataChange {
   public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

   public abstract Bitmap getCoverImage();

   public abstract String getDescription();

   public abstract Long getPlayedTimeMillis();

   public abstract a mT();

   public static final class Builder {
      private String UO;
      private Long afb;
      private a afc;
      private Uri afd;

      public SnapshotMetadataChange build() {
         return new SnapshotMetadataChangeEntity(this.UO, this.afb, this.afc, this.afd);
      }

      public SnapshotMetadataChange.Builder fromMetadata(SnapshotMetadata var1) {
         this.UO = var1.getDescription();
         this.afb = Long.valueOf(var1.getPlayedTime());
         if(this.afb.longValue() == -1L) {
            this.afb = null;
         }

         this.afd = var1.getCoverImageUri();
         if(this.afd != null) {
            this.afc = null;
         }

         return this;
      }

      public SnapshotMetadataChange.Builder setCoverImage(Bitmap var1) {
         this.afc = new a(var1);
         this.afd = null;
         return this;
      }

      public SnapshotMetadataChange.Builder setDescription(String var1) {
         this.UO = var1;
         return this;
      }

      public SnapshotMetadataChange.Builder setPlayedTimeMillis(long var1) {
         this.afb = Long.valueOf(var1);
         return this;
      }
   }
}
