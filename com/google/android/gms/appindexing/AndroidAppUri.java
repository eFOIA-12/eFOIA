package com.google.android.gms.appindexing;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.internal.jv;
import java.util.Iterator;
import java.util.List;

public final class AndroidAppUri {
   private final Uri mUri;

   private AndroidAppUri(Uri var1) {
      this.mUri = var1;
   }

   private static boolean a(AndroidAppUri var0) {
      if(!"android-app".equals(var0.mUri.getScheme())) {
         throw new IllegalArgumentException("android-app scheme is required.");
      } else if(TextUtils.isEmpty(var0.getPackageName())) {
         throw new IllegalArgumentException("Package name is empty.");
      } else {
         Uri var1 = newAndroidAppUri(var0.getPackageName(), var0.getDeepLinkUri()).toUri();
         if(!var0.mUri.equals(var1)) {
            throw new IllegalArgumentException("URI is not canonical.");
         } else {
            return true;
         }
      }
   }

   public static AndroidAppUri newAndroidAppUri(Uri var0) {
      AndroidAppUri var1 = new AndroidAppUri(var0);
      if(a(var1)) {
         return var1;
      } else {
         throw new IllegalArgumentException("AndroidAppUri validation failed.");
      }
   }

   public static AndroidAppUri newAndroidAppUri(String var0, Uri var1) {
      Builder var3 = (new Builder()).scheme("android-app").authority(var0);
      if(var1 != null) {
         var3.appendPath(var1.getScheme());
         if(var1.getAuthority() != null) {
            var3.appendPath(var1.getAuthority());
         }

         Iterator var2 = var1.getPathSegments().iterator();

         while(var2.hasNext()) {
            var3.appendPath((String)var2.next());
         }

         var3.encodedQuery(var1.getEncodedQuery()).encodedFragment(var1.getEncodedFragment());
      }

      return new AndroidAppUri(var3.build());
   }

   public boolean equals(Object var1) {
      return var1 instanceof AndroidAppUri?this.mUri.equals(((AndroidAppUri)var1).mUri):false;
   }

   public Uri getDeepLinkUri() {
      List var2 = this.mUri.getPathSegments();
      if(var2.size() <= 0) {
         return null;
      } else {
         String var3 = (String)var2.get(0);
         Builder var4 = new Builder();
         var4.scheme(var3);
         if(var2.size() > 1) {
            var4.authority((String)var2.get(1));

            for(int var1 = 2; var1 < var2.size(); ++var1) {
               var4.appendPath((String)var2.get(var1));
            }
         }

         var4.encodedQuery(this.mUri.getEncodedQuery());
         var4.encodedFragment(this.mUri.getEncodedFragment());
         return var4.build();
      }
   }

   public String getPackageName() {
      return this.mUri.getAuthority();
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.mUri});
   }

   public String toString() {
      return this.mUri.toString();
   }

   public Uri toUri() {
      return this.mUri;
   }
}
