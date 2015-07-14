package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.experience.ExperienceEvent;
import com.google.android.gms.games.internal.experience.ExperienceEventRef;

public final class ExperienceEventBuffer extends DataBuffer {
   public ExperienceEventBuffer(DataHolder var1) {
      super(var1);
   }

   public ExperienceEvent ea(int var1) {
      return new ExperienceEventRef(this.JG, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.ea(var1);
   }
}
