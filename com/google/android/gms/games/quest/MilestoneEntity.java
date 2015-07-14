package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntityCreator;
import com.google.android.gms.internal.jv;

public final class MilestoneEntity implements SafeParcelable, Milestone {
   public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
   private final int CK;
   private final String Ye;
   private final String Zn;
   private final long aeH;
   private final long aeI;
   private final byte[] aeJ;
   private final int mState;

   MilestoneEntity(int var1, String var2, long var3, long var5, byte[] var7, int var8, String var9) {
      this.CK = var1;
      this.Zn = var2;
      this.aeH = var3;
      this.aeI = var5;
      this.aeJ = var7;
      this.mState = var8;
      this.Ye = var9;
   }

   public MilestoneEntity(Milestone var1) {
      this.CK = 4;
      this.Zn = var1.getMilestoneId();
      this.aeH = var1.getCurrentProgress();
      this.aeI = var1.getTargetProgress();
      this.mState = var1.getState();
      this.Ye = var1.getEventId();
      byte[] var2 = var1.getCompletionRewardData();
      if(var2 == null) {
         this.aeJ = null;
      } else {
         this.aeJ = new byte[var2.length];
         System.arraycopy(var2, 0, this.aeJ, 0, var2.length);
      }
   }

   static int a(Milestone var0) {
      return jv.hashCode(new Object[]{var0.getMilestoneId(), Long.valueOf(var0.getCurrentProgress()), Long.valueOf(var0.getTargetProgress()), Integer.valueOf(var0.getState()), var0.getEventId()});
   }

   static boolean a(Milestone var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Milestone)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Milestone var4 = (Milestone)var1;
            if(jv.equal(var4.getMilestoneId(), var0.getMilestoneId()) && jv.equal(Long.valueOf(var4.getCurrentProgress()), Long.valueOf(var0.getCurrentProgress())) && jv.equal(Long.valueOf(var4.getTargetProgress()), Long.valueOf(var0.getTargetProgress())) && jv.equal(Integer.valueOf(var4.getState()), Integer.valueOf(var0.getState()))) {
               var2 = var3;
               if(jv.equal(var4.getEventId(), var0.getEventId())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Milestone var0) {
      return jv.h(var0).a("MilestoneId", var0.getMilestoneId()).a("CurrentProgress", Long.valueOf(var0.getCurrentProgress())).a("TargetProgress", Long.valueOf(var0.getTargetProgress())).a("State", Integer.valueOf(var0.getState())).a("CompletionRewardData", var0.getCompletionRewardData()).a("EventId", var0.getEventId()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Milestone freeze() {
      return this;
   }

   public byte[] getCompletionRewardData() {
      return this.aeJ;
   }

   public long getCurrentProgress() {
      return this.aeH;
   }

   public String getEventId() {
      return this.Ye;
   }

   public String getMilestoneId() {
      return this.Zn;
   }

   public int getState() {
      return this.mState;
   }

   public long getTargetProgress() {
      return this.aeI;
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

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      MilestoneEntityCreator.a(this, var1, var2);
   }
}
