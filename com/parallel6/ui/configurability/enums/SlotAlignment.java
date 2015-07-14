package com.parallel6.ui.configurability.enums;

public enum SlotAlignment {
   BOTTOM,
   CENTER,
   LEFT,
   RIGHT,
   TOP,
   UNDEFINED;

   public static int getSafeSlotAlignment(String var0, String var1) {
      SlotAlignment var4;
      SlotAlignment var5;
      try {
         var4 = valueOf(var0);
         var5 = valueOf(var1);
      } catch (Exception var3) {
         var4 = UNDEFINED;
         var5 = UNDEFINED;
      }

      byte var2 = 3;
      switch(null.$SwitchMap$com$parallel6$ui$configurability$enums$SlotAlignment[var4.ordinal()]) {
      case 1:
      case 2:
         var2 = 3;
         break;
      case 3:
         var2 = 1;
         break;
      case 4:
         var2 = 5;
      }

      switch(null.$SwitchMap$com$parallel6$ui$configurability$enums$SlotAlignment[var5.ordinal()]) {
      case 1:
      case 5:
         return var2 | 48;
      case 2:
      case 4:
      default:
         return var2;
      case 3:
         return var2 | 16;
      case 6:
         return var2 | 80;
      }
   }
}
