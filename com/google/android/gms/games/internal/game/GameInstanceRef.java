package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.games.internal.game.GameInstance;
import com.google.android.gms.internal.jv;

public final class GameInstanceRef extends d implements GameInstance {
   GameInstanceRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public String getApplicationId() {
      return this.getString("external_game_id");
   }

   public String getDisplayName() {
      return this.getString("instance_display_name");
   }

   public String getPackageName() {
      return this.getString("package_name");
   }

   public int jC() {
      return this.getInteger("platform_type");
   }

   public boolean ml() {
      return this.getInteger("real_time_support") > 0;
   }

   public boolean mm() {
      return this.getInteger("turn_based_support") > 0;
   }

   public boolean mn() {
      return this.getInteger("piracy_check") > 0;
   }

   public boolean mo() {
      return this.getInteger("installed") > 0;
   }

   public String toString() {
      return jv.h(this).a("ApplicationId", this.getApplicationId()).a("DisplayName", this.getDisplayName()).a("SupportsRealTime", Boolean.valueOf(this.ml())).a("SupportsTurnBased", Boolean.valueOf(this.mm())).a("PlatformType", PlatformType.dZ(this.jC())).a("PackageName", this.getPackageName()).a("PiracyCheckEnabled", Boolean.valueOf(this.mn())).a("Installed", Boolean.valueOf(this.mo())).toString();
   }
}
