package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import java.util.Map;

class m extends aj {
   private static final String ID;
   private static final String VALUE;

   static {
      ID = com.google.android.gms.internal.a.A.toString();
      VALUE = com.google.android.gms.internal.b.ff.toString();
   }

   public m() {
      super(ID, new String[]{VALUE});
   }

   public static String ph() {
      return ID;
   }

   public static String pi() {
      return VALUE;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return (com.google.android.gms.internal.d)var1.get(VALUE);
   }

   public boolean pe() {
      return true;
   }
}
