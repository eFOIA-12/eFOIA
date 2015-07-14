package com.parallel6.ui.configurability.enums;

public enum LayoutTemplates {
   CONFIG_CALENDAR,
   CONFIG_DETAIL_1,
   CONFIG_LIST_1,
   CONFIG_LIST_2,
   CONFIG_LIST_3,
   CONFIG_LIST_4,
   CONFIG_MAP,
   DETAIL_001,
   DETAIL_002,
   DETAIL_003,
   LIST_001,
   LIST_002,
   UNDEFINED;

   public static LayoutTemplates getSafeTemplate(String var0) {
      try {
         LayoutTemplates var2 = valueOf(var0.toUpperCase());
         return var2;
      } catch (Exception var1) {
         return UNDEFINED;
      }
   }
}
