package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class dk {
   private final boolean rs;
   private final boolean rt;
   private final boolean ru;
   private final boolean rv;
   private final boolean rw;

   private dk(dk.a var1) {
      this.rs = var1.rs;
      this.rt = var1.rt;
      this.ru = var1.ru;
      this.rv = var1.rv;
      this.rw = var1.rw;
   }

   // $FF: synthetic method
   dk(dk.a var1, Object var2) {
      this(var1);
   }

   public JSONObject toJson() {
      try {
         JSONObject var1 = (new JSONObject()).put("sms", this.rs).put("tel", this.rt).put("calendar", this.ru).put("storePicture", this.rv).put("inlineVideo", this.rw);
         return var1;
      } catch (JSONException var2) {
         gr.b("Error occured while obtaining the MRAID capabilities.", var2);
         return null;
      }
   }

   public static final class a {
      private boolean rs;
      private boolean rt;
      private boolean ru;
      private boolean rv;
      private boolean rw;

      public dk bU() {
         return new dk(this, null);
      }

      public dk.a k(boolean var1) {
         this.rs = var1;
         return this;
      }

      public dk.a l(boolean var1) {
         this.rt = var1;
         return this;
      }

      public dk.a m(boolean var1) {
         this.ru = var1;
         return this;
      }

      public dk.a n(boolean var1) {
         this.rv = var1;
         return this;
      }

      public dk.a o(boolean var1) {
         this.rw = var1;
         return this;
      }
   }
}
