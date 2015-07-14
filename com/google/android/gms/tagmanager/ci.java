package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dd;
import com.google.android.gms.tagmanager.di;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ci extends dd {
   private static final String ID;
   private static final String asy;

   static {
      ID = com.google.android.gms.internal.a.ap.toString();
      asy = com.google.android.gms.internal.b.dc.toString();
   }

   public ci() {
      super(ID);
   }

   protected boolean a(String var1, String var2, Map var3) {
      byte var4;
      if(di.n((com.google.android.gms.internal.d)var3.get(asy)).booleanValue()) {
         var4 = 66;
      } else {
         var4 = 64;
      }

      try {
         boolean var5 = Pattern.compile(var2, var4).matcher(var1).find();
         return var5;
      } catch (PatternSyntaxException var6) {
         return false;
      }
   }
}
