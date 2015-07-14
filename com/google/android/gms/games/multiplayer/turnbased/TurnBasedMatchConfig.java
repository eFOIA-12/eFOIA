package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfigImpl;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig {
   public static TurnBasedMatchConfig.Builder builder() {
      return new TurnBasedMatchConfig.Builder(null);
   }

   public static Bundle createAutoMatchCriteria(int var0, int var1, long var2) {
      Bundle var4 = new Bundle();
      var4.putInt("min_automatch_players", var0);
      var4.putInt("max_automatch_players", var1);
      var4.putLong("exclusive_bit_mask", var2);
      return var4;
   }

   public abstract Bundle getAutoMatchCriteria();

   public abstract String[] getInvitedPlayerIds();

   public abstract int getVariant();

   public abstract int mO();

   public static final class Builder {
      int adW;
      ArrayList ael;
      Bundle aem;
      int aew;

      private Builder() {
         this.adW = -1;
         this.ael = new ArrayList();
         this.aem = null;
         this.aew = 2;
      }

      // $FF: synthetic method
      Builder(Object var1) {
         this();
      }

      public TurnBasedMatchConfig.Builder addInvitedPlayer(String var1) {
         jx.i(var1);
         this.ael.add(var1);
         return this;
      }

      public TurnBasedMatchConfig.Builder addInvitedPlayers(ArrayList var1) {
         jx.i(var1);
         this.ael.addAll(var1);
         return this;
      }

      public TurnBasedMatchConfig build() {
         return new TurnBasedMatchConfigImpl(this);
      }

      public TurnBasedMatchConfig.Builder setAutoMatchCriteria(Bundle var1) {
         this.aem = var1;
         return this;
      }

      public TurnBasedMatchConfig.Builder setVariant(int var1) {
         boolean var2;
         if(var1 != -1 && var1 <= 0) {
            var2 = false;
         } else {
            var2 = true;
         }

         jx.b(var2, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
         this.adW = var1;
         return this;
      }
   }
}
