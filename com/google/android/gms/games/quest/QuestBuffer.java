package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestRef;

public final class QuestBuffer extends g {
   public QuestBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.n(var1, var2);
   }

   protected String ha() {
      return "external_quest_id";
   }

   protected Quest n(int var1, int var2) {
      return new QuestRef(this.JG, var1, var2);
   }
}
