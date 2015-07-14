package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntityCreator;
import com.google.android.gms.internal.jv;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
   public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntity.GameBadgeEntityCreatorCompat();
   private final int CK;
   private int Gt;
   private String OH;
   private String UO;
   private Uri WD;

   GameBadgeEntity(int var1, int var2, String var3, String var4, Uri var5) {
      this.CK = var1;
      this.Gt = var2;
      this.OH = var3;
      this.UO = var4;
      this.WD = var5;
   }

   public GameBadgeEntity(GameBadge var1) {
      this.CK = 1;
      this.Gt = var1.getType();
      this.OH = var1.getTitle();
      this.UO = var1.getDescription();
      this.WD = var1.getIconImageUri();
   }

   static int a(GameBadge var0) {
      return jv.hashCode(new Object[]{Integer.valueOf(var0.getType()), var0.getTitle(), var0.getDescription(), var0.getIconImageUri()});
   }

   static boolean a(GameBadge var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof GameBadge)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            GameBadge var4 = (GameBadge)var1;
            if(jv.equal(Integer.valueOf(var4.getType()), var0.getTitle())) {
               var2 = var3;
               if(jv.equal(var4.getDescription(), var0.getIconImageUri())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(GameBadge var0) {
      return jv.h(var0).a("Type", Integer.valueOf(var0.getType())).a("Title", var0.getTitle()).a("Description", var0.getDescription()).a("IconImageUri", var0.getIconImageUri()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mk();
   }

   public String getDescription() {
      return this.UO;
   }

   public Uri getIconImageUri() {
      return this.WD;
   }

   public String getTitle() {
      return this.OH;
   }

   public int getType() {
      return this.Gt;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public GameBadge mk() {
      return this;
   }

   public String toString() {
      return b((GameBadge)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         GameBadgeEntityCreator.a(this, var1, var2);
      } else {
         var1.writeInt(this.Gt);
         var1.writeString(this.OH);
         var1.writeString(this.UO);
         String var3;
         if(this.WD == null) {
            var3 = null;
         } else {
            var3 = this.WD.toString();
         }

         var1.writeString(var3);
      }
   }

   static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cv(var1);
      }

      public GameBadgeEntity cv(Parcel var1) {
         if(!GameBadgeEntity.c(GameBadgeEntity.ht()) && !GameBadgeEntity.aW(GameBadgeEntity.class.getCanonicalName())) {
            int var2 = var1.readInt();
            String var3 = var1.readString();
            String var4 = var1.readString();
            String var5 = var1.readString();
            Uri var6;
            if(var5 == null) {
               var6 = null;
            } else {
               var6 = Uri.parse(var5);
            }

            return new GameBadgeEntity(1, var2, var3, var4, var6);
         } else {
            return super.cv(var1);
         }
      }
   }
}
