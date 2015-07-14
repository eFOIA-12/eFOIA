package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventEntityCreator;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class EventEntity implements SafeParcelable, Event {
   public static final EventEntityCreator CREATOR = new EventEntityCreator();
   private final int CK;
   private final String UO;
   private final Uri WD;
   private final String WO;
   private final PlayerEntity XE;
   private final String Ye;
   private final long Yf;
   private final String Yg;
   private final boolean Yh;
   private final String mName;

   EventEntity(int var1, String var2, String var3, String var4, Uri var5, String var6, Player var7, long var8, String var10, boolean var11) {
      this.CK = var1;
      this.Ye = var2;
      this.mName = var3;
      this.UO = var4;
      this.WD = var5;
      this.WO = var6;
      this.XE = new PlayerEntity(var7);
      this.Yf = var8;
      this.Yg = var10;
      this.Yh = var11;
   }

   public EventEntity(Event var1) {
      this.CK = 1;
      this.Ye = var1.getEventId();
      this.mName = var1.getName();
      this.UO = var1.getDescription();
      this.WD = var1.getIconImageUri();
      this.WO = var1.getIconImageUrl();
      this.XE = (PlayerEntity)var1.getPlayer().freeze();
      this.Yf = var1.getValue();
      this.Yg = var1.getFormattedValue();
      this.Yh = var1.isVisible();
   }

   static int a(Event var0) {
      return jv.hashCode(new Object[]{var0.getEventId(), var0.getName(), var0.getDescription(), var0.getIconImageUri(), var0.getIconImageUrl(), var0.getPlayer(), Long.valueOf(var0.getValue()), var0.getFormattedValue(), Boolean.valueOf(var0.isVisible())});
   }

   static boolean a(Event var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Event)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Event var4 = (Event)var1;
            if(jv.equal(var4.getEventId(), var0.getEventId()) && jv.equal(var4.getName(), var0.getName()) && jv.equal(var4.getDescription(), var0.getDescription()) && jv.equal(var4.getIconImageUri(), var0.getIconImageUri()) && jv.equal(var4.getIconImageUrl(), var0.getIconImageUrl()) && jv.equal(var4.getPlayer(), var0.getPlayer()) && jv.equal(Long.valueOf(var4.getValue()), Long.valueOf(var0.getValue())) && jv.equal(var4.getFormattedValue(), var0.getFormattedValue())) {
               var2 = var3;
               if(jv.equal(Boolean.valueOf(var4.isVisible()), Boolean.valueOf(var0.isVisible()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Event var0) {
      return jv.h(var0).a("Id", var0.getEventId()).a("Name", var0.getName()).a("Description", var0.getDescription()).a("IconImageUri", var0.getIconImageUri()).a("IconImageUrl", var0.getIconImageUrl()).a("Player", var0.getPlayer()).a("Value", Long.valueOf(var0.getValue())).a("FormattedValue", var0.getFormattedValue()).a("isVisible", Boolean.valueOf(var0.isVisible())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Event freeze() {
      return this;
   }

   public String getDescription() {
      return this.UO;
   }

   public void getDescription(CharArrayBuffer var1) {
      le.b(this.UO, var1);
   }

   public String getEventId() {
      return this.Ye;
   }

   public String getFormattedValue() {
      return this.Yg;
   }

   public void getFormattedValue(CharArrayBuffer var1) {
      le.b(this.Yg, var1);
   }

   public Uri getIconImageUri() {
      return this.WD;
   }

   public String getIconImageUrl() {
      return this.WO;
   }

   public String getName() {
      return this.mName;
   }

   public void getName(CharArrayBuffer var1) {
      le.b(this.mName, var1);
   }

   public Player getPlayer() {
      return this.XE;
   }

   public long getValue() {
      return this.Yf;
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

   public boolean isVisible() {
      return this.Yh;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      EventEntityCreator.a(this, var1, var2);
   }
}
