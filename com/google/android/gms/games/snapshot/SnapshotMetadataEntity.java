package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntityCreator;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
   public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
   private final int CK;
   private final String OH;
   private final String UO;
   private final String YB;
   private final GameEntity acs;
   private final Uri afd;
   private final PlayerEntity afg;
   private final String afh;
   private final long afi;
   private final long afj;
   private final float afk;
   private final String afl;
   private final boolean afm;

   SnapshotMetadataEntity(int var1, GameEntity var2, PlayerEntity var3, String var4, Uri var5, String var6, String var7, String var8, long var9, long var11, float var13, String var14, boolean var15) {
      this.CK = var1;
      this.acs = var2;
      this.afg = var3;
      this.YB = var4;
      this.afd = var5;
      this.afh = var6;
      this.afk = var13;
      this.OH = var7;
      this.UO = var8;
      this.afi = var9;
      this.afj = var11;
      this.afl = var14;
      this.afm = var15;
   }

   public SnapshotMetadataEntity(SnapshotMetadata var1) {
      this.CK = 4;
      this.acs = new GameEntity(var1.getGame());
      this.afg = new PlayerEntity(var1.getOwner());
      this.YB = var1.getSnapshotId();
      this.afd = var1.getCoverImageUri();
      this.afh = var1.getCoverImageUrl();
      this.afk = var1.getCoverImageAspectRatio();
      this.OH = var1.getTitle();
      this.UO = var1.getDescription();
      this.afi = var1.getLastModifiedTimestamp();
      this.afj = var1.getPlayedTime();
      this.afl = var1.getUniqueName();
      this.afm = var1.hasChangePending();
   }

   static int a(SnapshotMetadata var0) {
      return jv.hashCode(new Object[]{var0.getGame(), var0.getOwner(), var0.getSnapshotId(), var0.getCoverImageUri(), Float.valueOf(var0.getCoverImageAspectRatio()), var0.getTitle(), var0.getDescription(), Long.valueOf(var0.getLastModifiedTimestamp()), Long.valueOf(var0.getPlayedTime()), var0.getUniqueName(), Boolean.valueOf(var0.hasChangePending())});
   }

   static boolean a(SnapshotMetadata var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof SnapshotMetadata)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            SnapshotMetadata var4 = (SnapshotMetadata)var1;
            if(jv.equal(var4.getGame(), var0.getGame()) && jv.equal(var4.getOwner(), var0.getOwner()) && jv.equal(var4.getSnapshotId(), var0.getSnapshotId()) && jv.equal(var4.getCoverImageUri(), var0.getCoverImageUri()) && jv.equal(Float.valueOf(var4.getCoverImageAspectRatio()), Float.valueOf(var0.getCoverImageAspectRatio())) && jv.equal(var4.getTitle(), var0.getTitle()) && jv.equal(var4.getDescription(), var0.getDescription()) && jv.equal(Long.valueOf(var4.getLastModifiedTimestamp()), Long.valueOf(var0.getLastModifiedTimestamp())) && jv.equal(Long.valueOf(var4.getPlayedTime()), Long.valueOf(var0.getPlayedTime())) && jv.equal(var4.getUniqueName(), var0.getUniqueName())) {
               var2 = var3;
               if(jv.equal(Boolean.valueOf(var4.hasChangePending()), Boolean.valueOf(var0.hasChangePending()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(SnapshotMetadata var0) {
      return jv.h(var0).a("Game", var0.getGame()).a("Owner", var0.getOwner()).a("SnapshotId", var0.getSnapshotId()).a("CoverImageUri", var0.getCoverImageUri()).a("CoverImageUrl", var0.getCoverImageUrl()).a("CoverImageAspectRatio", Float.valueOf(var0.getCoverImageAspectRatio())).a("Description", var0.getDescription()).a("LastModifiedTimestamp", Long.valueOf(var0.getLastModifiedTimestamp())).a("PlayedTime", Long.valueOf(var0.getPlayedTime())).a("UniqueName", var0.getUniqueName()).a("ChangePending", Boolean.valueOf(var0.hasChangePending())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public SnapshotMetadata freeze() {
      return this;
   }

   public float getCoverImageAspectRatio() {
      return this.afk;
   }

   public Uri getCoverImageUri() {
      return this.afd;
   }

   public String getCoverImageUrl() {
      return this.afh;
   }

   public String getDescription() {
      return this.UO;
   }

   public void getDescription(CharArrayBuffer var1) {
      le.b(this.UO, var1);
   }

   public Game getGame() {
      return this.acs;
   }

   public long getLastModifiedTimestamp() {
      return this.afi;
   }

   public Player getOwner() {
      return this.afg;
   }

   public long getPlayedTime() {
      return this.afj;
   }

   public String getSnapshotId() {
      return this.YB;
   }

   public String getTitle() {
      return this.OH;
   }

   public String getUniqueName() {
      return this.afl;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public boolean hasChangePending() {
      return this.afm;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataEntityCreator.a(this, var1, var2);
   }
}
