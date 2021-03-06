package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlusShare {
   public static final String EXTRA_CALL_TO_ACTION = "com.google.android.apps.plus.CALL_TO_ACTION";
   public static final String EXTRA_CONTENT_DEEP_LINK_ID = "com.google.android.apps.plus.CONTENT_DEEP_LINK_ID";
   public static final String EXTRA_CONTENT_DEEP_LINK_METADATA = "com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA";
   public static final String EXTRA_CONTENT_URL = "com.google.android.apps.plus.CONTENT_URL";
   public static final String EXTRA_IS_INTERACTIVE_POST = "com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST";
   public static final String EXTRA_SENDER_ID = "com.google.android.apps.plus.SENDER_ID";
   public static final String KEY_CALL_TO_ACTION_DEEP_LINK_ID = "deepLinkId";
   public static final String KEY_CALL_TO_ACTION_LABEL = "label";
   public static final String KEY_CALL_TO_ACTION_URL = "url";
   public static final String KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION = "description";
   public static final String KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL = "thumbnailUrl";
   public static final String KEY_CONTENT_DEEP_LINK_METADATA_TITLE = "title";
   public static final String PARAM_CONTENT_DEEP_LINK_ID = "deep_link_id";

   @Deprecated
   protected PlusShare() {
      throw new AssertionError();
   }

   public static Bundle a(String var0, String var1, Uri var2) {
      Bundle var3 = new Bundle();
      var3.putString("title", var0);
      var3.putString("description", var1);
      if(var2 != null) {
         var3.putString("thumbnailUrl", var2.toString());
      }

      return var3;
   }

   protected static boolean cg(String var0) {
      if(TextUtils.isEmpty(var0)) {
         Log.e("GooglePlusPlatform", "The provided deep-link ID is empty.");
         return false;
      } else if(var0.contains(" ")) {
         Log.e("GooglePlusPlatform", "Spaces are not allowed in deep-link IDs.");
         return false;
      } else {
         return true;
      }
   }

   public static Person createPerson(String var0, String var1) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("MinimalPerson ID must not be empty.");
      } else if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("Display name must not be empty.");
      } else {
         return new pi(var1, var0, (pi.c)null, 0, (String)null);
      }
   }

   public static String getDeepLinkId(Intent var0) {
      Object var2 = null;
      String var1 = (String)var2;
      if(var0 != null) {
         var1 = (String)var2;
         if(var0.getData() != null) {
            var1 = var0.getData().getQueryParameter("deep_link_id");
         }
      }

      return var1;
   }

   public static class Builder {
      private boolean anE;
      private ArrayList anF;
      private final Context mContext;
      private final Intent mIntent;

      public Builder(Activity var1) {
         this.mContext = var1;
         this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
         this.mIntent.addFlags(524288);
         if(var1 != null && var1.getComponentName() != null) {
            this.anE = true;
         }

      }

      @Deprecated
      public Builder(Activity var1, PlusClient var2) {
         this(var1);
         boolean var3;
         if(var2 != null) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.a(var3, "PlusClient must not be null.");
         jx.a(var2.isConnected(), "PlusClient must be connected to create an interactive post.");
         jx.a(var2.os().cj("https://www.googleapis.com/auth/plus.login"), "Must request PLUS_LOGIN scope in PlusClient to create an interactive post.");
         Person var4 = var2.getCurrentPerson();
         String var5;
         if(var4 != null) {
            var5 = var4.getId();
         } else {
            var5 = "0";
         }

         this.mIntent.putExtra("com.google.android.apps.plus.SENDER_ID", var5);
      }

      public Builder(Context var1) {
         this.mContext = var1;
         this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
      }

      public PlusShare.Builder addCallToAction(String var1, Uri var2, String var3) {
         jx.a(this.anE, "Must include the launching activity with PlusShare.Builder constructor before setting call-to-action");
         boolean var4;
         if(var2 != null && !TextUtils.isEmpty(var2.toString())) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Must provide a call to action URL");
         Bundle var5 = new Bundle();
         if(!TextUtils.isEmpty(var1)) {
            var5.putString("label", var1);
         }

         var5.putString("url", var2.toString());
         if(!TextUtils.isEmpty(var3)) {
            jx.a(PlusShare.cg(var3), "The specified deep-link ID was malformed.");
            var5.putString("deepLinkId", var3);
         }

         this.mIntent.putExtra("com.google.android.apps.plus.CALL_TO_ACTION", var5);
         this.mIntent.putExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", true);
         this.mIntent.setType("text/plain");
         return this;
      }

      public PlusShare.Builder addStream(Uri var1) {
         Uri var2 = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
         if(var2 == null) {
            return this.setStream(var1);
         } else {
            if(this.anF == null) {
               this.anF = new ArrayList();
            }

            this.anF.add(var2);
            this.anF.add(var1);
            return this;
         }
      }

      public Intent getIntent() {
         boolean var3 = true;
         boolean var1;
         if(this.anF != null && this.anF.size() > 1) {
            var1 = true;
         } else {
            var1 = false;
         }

         boolean var4 = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
         boolean var5 = this.mIntent.getBooleanExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", false);
         boolean var2;
         if(var1 && var5) {
            var2 = false;
         } else {
            var2 = true;
         }

         jx.a(var2, "Call-to-action buttons are only available for URLs.");
         if(var5 && !this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_URL")) {
            var2 = false;
         } else {
            var2 = true;
         }

         jx.a(var2, "The content URL is required for interactive posts.");
         var2 = var3;
         if(var5) {
            var2 = var3;
            if(!this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_URL")) {
               if(this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
                  var2 = var3;
               } else {
                  var2 = false;
               }
            }
         }

         jx.a(var2, "Must set content URL or content deep-link ID to use a call-to-action button.");
         if(this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
            jx.a(PlusShare.cg(this.mIntent.getStringExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")), "The specified deep-link ID was malformed.");
         }

         if(!var1 && var4) {
            this.mIntent.setAction("android.intent.action.SEND");
            if(this.anF != null && !this.anF.isEmpty()) {
               this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.anF.get(0));
            } else {
               this.mIntent.removeExtra("android.intent.extra.STREAM");
            }

            this.anF = null;
         }

         if(var1 && !var4) {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            if(this.anF != null && !this.anF.isEmpty()) {
               this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.anF);
            } else {
               this.mIntent.removeExtra("android.intent.extra.STREAM");
            }
         }

         if("com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.mIntent.getAction())) {
            this.mIntent.setPackage("com.google.android.gms");
            return this.mIntent;
         } else if(!this.mIntent.hasExtra("android.intent.extra.STREAM")) {
            this.mIntent.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
            this.mIntent.setPackage("com.google.android.gms");
            return this.mIntent;
         } else {
            this.mIntent.setPackage("com.google.android.apps.plus");
            return this.mIntent;
         }
      }

      public PlusShare.Builder setContentDeepLinkId(String var1) {
         return this.setContentDeepLinkId(var1, (String)null, (String)null, (Uri)null);
      }

      public PlusShare.Builder setContentDeepLinkId(String var1, String var2, String var3, Uri var4) {
         jx.b(this.anE, "Must include the launching activity with PlusShare.Builder constructor before setting deep links");
         boolean var5;
         if(!TextUtils.isEmpty(var1)) {
            var5 = true;
         } else {
            var5 = false;
         }

         jx.b(var5, "The deepLinkId parameter is required.");
         Bundle var6 = PlusShare.a(var2, var3, var4);
         this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID", var1);
         this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA", var6);
         this.mIntent.setType("text/plain");
         return this;
      }

      public PlusShare.Builder setContentUrl(Uri var1) {
         String var2 = null;
         if(var1 != null) {
            var2 = var1.toString();
         }

         if(TextUtils.isEmpty(var2)) {
            this.mIntent.removeExtra("com.google.android.apps.plus.CONTENT_URL");
            return this;
         } else {
            this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_URL", var2);
            return this;
         }
      }

      public PlusShare.Builder setRecipients(Person var1, List var2) {
         Intent var3 = this.mIntent;
         String var4;
         if(var1 != null) {
            var4 = var1.getId();
         } else {
            var4 = "0";
         }

         var3.putExtra("com.google.android.apps.plus.SENDER_ID", var4);
         return this.setRecipients(var2);
      }

      @Deprecated
      public PlusShare.Builder setRecipients(List var1) {
         int var2;
         if(var1 != null) {
            var2 = var1.size();
         } else {
            var2 = 0;
         }

         if(var2 == 0) {
            this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_IDS");
            this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES");
            return this;
         } else {
            ArrayList var3 = new ArrayList(var2);
            ArrayList var4 = new ArrayList(var2);
            Iterator var6 = var1.iterator();

            while(var6.hasNext()) {
               Person var5 = (Person)var6.next();
               var3.add(var5.getId());
               var4.add(var5.getDisplayName());
            }

            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_IDS", var3);
            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES", var4);
            return this;
         }
      }

      public PlusShare.Builder setStream(Uri var1) {
         this.anF = null;
         this.mIntent.putExtra("android.intent.extra.STREAM", var1);
         return this;
      }

      public PlusShare.Builder setText(CharSequence var1) {
         this.mIntent.putExtra("android.intent.extra.TEXT", var1);
         return this;
      }

      public PlusShare.Builder setType(String var1) {
         this.mIntent.setType(var1);
         return this;
      }
   }
}
