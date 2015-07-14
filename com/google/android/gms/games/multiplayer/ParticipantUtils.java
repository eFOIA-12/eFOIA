package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class ParticipantUtils {
   public static boolean bY(String var0) {
      jx.b((Object)var0, "Participant ID must not be null");
      return var0.startsWith("p_");
   }

   public static String getParticipantId(ArrayList var0, String var1) {
      int var3 = var0.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         Participant var4 = (Participant)var0.get(var2);
         Player var5 = var4.getPlayer();
         if(var5 != null && var5.getPlayerId().equals(var1)) {
            return var4.getParticipantId();
         }
      }

      return null;
   }
}
