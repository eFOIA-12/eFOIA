package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntityCreator;
import com.google.android.gms.internal.jv;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
   public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
   private final int CK;
   private final String acF;
   private final String acG;
   private final long acH;
   private final Uri acI;
   private final Uri acJ;
   private final Uri acK;

   MostRecentGameInfoEntity(int var1, String var2, String var3, long var4, Uri var6, Uri var7, Uri var8) {
      this.CK = var1;
      this.acF = var2;
      this.acG = var3;
      this.acH = var4;
      this.acI = var6;
      this.acJ = var7;
      this.acK = var8;
   }

   public MostRecentGameInfoEntity(MostRecentGameInfo var1) {
      this.CK = 2;
      this.acF = var1.mw();
      this.acG = var1.mx();
      this.acH = var1.my();
      this.acI = var1.mz();
      this.acJ = var1.mA();
      this.acK = var1.mB();
   }

   static int a(MostRecentGameInfo var0) {
      return jv.hashCode(new Object[]{var0.mw(), var0.mx(), Long.valueOf(var0.my()), var0.mz(), var0.mA(), var0.mB()});
   }

   static boolean a(MostRecentGameInfo var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof MostRecentGameInfo)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            MostRecentGameInfo var4 = (MostRecentGameInfo)var1;
            if(jv.equal(var4.mw(), var0.mw()) && jv.equal(var4.mx(), var0.mx()) && jv.equal(Long.valueOf(var4.my()), Long.valueOf(var0.my())) && jv.equal(var4.mz(), var0.mz()) && jv.equal(var4.mA(), var0.mA())) {
               var2 = var3;
               if(jv.equal(var4.mB(), var0.mB())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(MostRecentGameInfo var0) {
      return jv.h(var0).a("GameId", var0.mw()).a("GameName", var0.mx()).a("ActivityTimestampMillis", Long.valueOf(var0.my())).a("GameIconUri", var0.mz()).a("GameHiResUri", var0.mA()).a("GameFeaturedUri", var0.mB()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mC();
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

   public Uri mA() {
      return this.acJ;
   }

   public Uri mB() {
      return this.acK;
   }

   public MostRecentGameInfo mC() {
      return this;
   }

   public String mw() {
      return this.acF;
   }

   public String mx() {
      return this.acG;
   }

   public long my() {
      return this.acH;
   }

   public Uri mz() {
      return this.acI;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      MostRecentGameInfoEntityCreator.a(this, var1, var2);
   }
}
