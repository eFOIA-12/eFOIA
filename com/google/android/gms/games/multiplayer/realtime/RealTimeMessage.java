package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jx;

public final class RealTimeMessage implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public RealTimeMessage cB(Parcel var1) {
         return new RealTimeMessage(var1, null);
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cB(var1);
      }

      public RealTimeMessage[] en(int var1) {
         return new RealTimeMessage[var1];
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.en(var1);
      }
   };
   public static final int RELIABLE = 1;
   public static final int UNRELIABLE = 0;
   private final String aee;
   private final byte[] aef;
   private final int aeg;

   private RealTimeMessage(Parcel var1) {
      this(var1.readString(), var1.createByteArray(), var1.readInt());
   }

   // $FF: synthetic method
   RealTimeMessage(Parcel var1, Object var2) {
      this(var1);
   }

   public RealTimeMessage(String var1, byte[] var2, int var3) {
      this.aee = (String)jx.i(var1);
      this.aef = (byte[])((byte[])jx.i(var2)).clone();
      this.aeg = var3;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getMessageData() {
      return this.aef;
   }

   public String getSenderParticipantId() {
      return this.aee;
   }

   public boolean isReliable() {
      return this.aeg == 1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.aee);
      var1.writeByteArray(this.aef);
      var1.writeInt(this.aeg);
   }
}
