package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class m extends j {
   public m(String var1, int var2) {
      super(var1, bp(var1), Collections.emptyList(), var2);
   }

   private String bo(String var1) {
      return q(this.getName(), var1);
   }

   private static Collection bp(String var0) {
      return Arrays.asList(new String[]{q(var0, "permissionId"), q(var0, "displayName"), q(var0, "picture"), q(var0, "isAuthenticatedUser"), q(var0, "emailAddress")});
   }

   private static String q(String var0, String var1) {
      return var0 + "." + var1;
   }

   protected boolean b(DataHolder var1, int var2, int var3) {
      return !var1.h(this.bo("permissionId"), var2, var3);
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.j(var1, var2, var3);
   }

   protected UserMetadata j(DataHolder var1, int var2, int var3) {
      String var5 = var1.c(this.bo("permissionId"), var2, var3);
      if(var5 != null) {
         String var6 = var1.c(this.bo("displayName"), var2, var3);
         String var7 = var1.c(this.bo("picture"), var2, var3);
         boolean var4 = var1.d(this.bo("isAuthenticatedUser"), var2, var3);
         String var8 = var1.c(this.bo("emailAddress"), var2, var3);
         return new UserMetadata(var5, var6, var7, Boolean.valueOf(var4).booleanValue(), var8);
      } else {
         return null;
      }
   }
}
