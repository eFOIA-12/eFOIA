package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import com.google.android.gms.internal.ll;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
   public static final int COLOR_UNSPECIFIED = 0;
   public static final float DEFAULT_FONT_SCALE = 1.0F;
   public static final int EDGE_TYPE_DEPRESSED = 4;
   public static final int EDGE_TYPE_DROP_SHADOW = 2;
   public static final int EDGE_TYPE_NONE = 0;
   public static final int EDGE_TYPE_OUTLINE = 1;
   public static final int EDGE_TYPE_RAISED = 3;
   public static final int EDGE_TYPE_UNSPECIFIED = -1;
   public static final int FONT_FAMILY_CASUAL = 4;
   public static final int FONT_FAMILY_CURSIVE = 5;
   public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
   public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
   public static final int FONT_FAMILY_SANS_SERIF = 0;
   public static final int FONT_FAMILY_SERIF = 2;
   public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
   public static final int FONT_FAMILY_UNSPECIFIED = -1;
   public static final int FONT_STYLE_BOLD = 1;
   public static final int FONT_STYLE_BOLD_ITALIC = 3;
   public static final int FONT_STYLE_ITALIC = 2;
   public static final int FONT_STYLE_NORMAL = 0;
   public static final int FONT_STYLE_UNSPECIFIED = -1;
   public static final int WINDOW_TYPE_NONE = 0;
   public static final int WINDOW_TYPE_NORMAL = 1;
   public static final int WINDOW_TYPE_ROUNDED = 2;
   public static final int WINDOW_TYPE_UNSPECIFIED = -1;
   private float GT;
   private int GU;
   private int GV;
   private int GW;
   private int GX;
   private int GY;
   private int GZ;
   private JSONObject Ga;
   private String Ha;
   private int Hb;
   private int Hc;
   private int xB;

   public TextTrackStyle() {
      this.clear();
   }

   private int aC(String var1) {
      byte var3 = 0;
      int var2 = var3;
      if(var1 != null) {
         var2 = var3;
         if(var1.length() == 9) {
            var2 = var3;
            if(var1.charAt(0) == 35) {
               try {
                  var2 = Integer.parseInt(var1.substring(1, 3), 16);
                  int var6 = Integer.parseInt(var1.substring(3, 5), 16);
                  int var4 = Integer.parseInt(var1.substring(5, 7), 16);
                  var2 = Color.argb(Integer.parseInt(var1.substring(7, 9), 16), var2, var6, var4);
               } catch (NumberFormatException var5) {
                  return 0;
               }
            }
         }
      }

      return var2;
   }

   private void clear() {
      this.GT = 1.0F;
      this.GU = 0;
      this.xB = 0;
      this.GV = -1;
      this.GW = 0;
      this.GX = -1;
      this.GY = 0;
      this.GZ = 0;
      this.Ha = null;
      this.Hb = -1;
      this.Hc = -1;
      this.Ga = null;
   }

   public static TextTrackStyle fromSystemSettings(Context var0) {
      TextTrackStyle var3 = new TextTrackStyle();
      if(!ll.im()) {
         return var3;
      } else {
         CaptioningManager var4 = (CaptioningManager)var0.getSystemService("captioning");
         var3.setFontScale(var4.getFontScale());
         CaptionStyle var5 = var4.getUserStyle();
         var3.setBackgroundColor(var5.backgroundColor);
         var3.setForegroundColor(var5.foregroundColor);
         switch(var5.edgeType) {
         case 1:
            var3.setEdgeType(1);
            break;
         case 2:
            var3.setEdgeType(2);
            break;
         default:
            var3.setEdgeType(0);
         }

         var3.setEdgeColor(var5.edgeColor);
         Typeface var6 = var5.getTypeface();
         if(var6 != null) {
            if(Typeface.MONOSPACE.equals(var6)) {
               var3.setFontGenericFamily(1);
            } else if(Typeface.SANS_SERIF.equals(var6)) {
               var3.setFontGenericFamily(0);
            } else if(Typeface.SERIF.equals(var6)) {
               var3.setFontGenericFamily(2);
            } else {
               var3.setFontGenericFamily(0);
            }

            boolean var1 = var6.isBold();
            boolean var2 = var6.isItalic();
            if(var1 && var2) {
               var3.setFontStyle(3);
            } else if(var1) {
               var3.setFontStyle(1);
            } else if(var2) {
               var3.setFontStyle(2);
            } else {
               var3.setFontStyle(0);
            }
         }

         return var3;
      }
   }

   private String u(int var1) {
      return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(var1)), Integer.valueOf(Color.green(var1)), Integer.valueOf(Color.blue(var1)), Integer.valueOf(Color.alpha(var1))});
   }

   public void c(JSONObject var1) throws JSONException {
      this.clear();
      this.GT = (float)var1.optDouble("fontScale", 1.0D);
      this.GU = this.aC(var1.optString("foregroundColor"));
      this.xB = this.aC(var1.optString("backgroundColor"));
      String var2;
      if(var1.has("edgeType")) {
         var2 = var1.getString("edgeType");
         if("NONE".equals(var2)) {
            this.GV = 0;
         } else if("OUTLINE".equals(var2)) {
            this.GV = 1;
         } else if("DROP_SHADOW".equals(var2)) {
            this.GV = 2;
         } else if("RAISED".equals(var2)) {
            this.GV = 3;
         } else if("DEPRESSED".equals(var2)) {
            this.GV = 4;
         }
      }

      this.GW = this.aC(var1.optString("edgeColor"));
      if(var1.has("windowType")) {
         var2 = var1.getString("windowType");
         if("NONE".equals(var2)) {
            this.GX = 0;
         } else if("NORMAL".equals(var2)) {
            this.GX = 1;
         } else if("ROUNDED_CORNERS".equals(var2)) {
            this.GX = 2;
         }
      }

      this.GY = this.aC(var1.optString("windowColor"));
      if(this.GX == 2) {
         this.GZ = var1.optInt("windowRoundedCornerRadius", 0);
      }

      this.Ha = var1.optString("fontFamily", (String)null);
      if(var1.has("fontGenericFamily")) {
         var2 = var1.getString("fontGenericFamily");
         if("SANS_SERIF".equals(var2)) {
            this.Hb = 0;
         } else if("MONOSPACED_SANS_SERIF".equals(var2)) {
            this.Hb = 1;
         } else if("SERIF".equals(var2)) {
            this.Hb = 2;
         } else if("MONOSPACED_SERIF".equals(var2)) {
            this.Hb = 3;
         } else if("CASUAL".equals(var2)) {
            this.Hb = 4;
         } else if("CURSIVE".equals(var2)) {
            this.Hb = 5;
         } else if("SMALL_CAPITALS".equals(var2)) {
            this.Hb = 6;
         }
      }

      if(var1.has("fontStyle")) {
         var2 = var1.getString("fontStyle");
         if("NORMAL".equals(var2)) {
            this.Hc = 0;
         } else if("BOLD".equals(var2)) {
            this.Hc = 1;
         } else if("ITALIC".equals(var2)) {
            this.Hc = 2;
         } else if("BOLD_ITALIC".equals(var2)) {
            this.Hc = 3;
         }
      }

      this.Ga = var1.optJSONObject("customData");
   }

   public boolean equals(Object var1) {
      boolean var5 = true;
      boolean var6 = false;
      boolean var4;
      if(this == var1) {
         var4 = true;
      } else {
         var4 = var6;
         if(var1 instanceof TextTrackStyle) {
            TextTrackStyle var7 = (TextTrackStyle)var1;
            boolean var2;
            if(this.Ga == null) {
               var2 = true;
            } else {
               var2 = false;
            }

            boolean var3;
            if(var7.Ga == null) {
               var3 = true;
            } else {
               var3 = false;
            }

            var4 = var6;
            if(var2 == var3) {
               if(this.Ga != null && var7.Ga != null) {
                  var4 = var6;
                  if(!li.d(this.Ga, var7.Ga)) {
                     return var4;
                  }
               }

               if(this.GT == var7.GT && this.GU == var7.GU && this.xB == var7.xB && this.GV == var7.GV && this.GW == var7.GW && this.GX == var7.GX && this.GZ == var7.GZ && in.a(this.Ha, var7.Ha) && this.Hb == var7.Hb && this.Hc == var7.Hc) {
                  var4 = var5;
               } else {
                  var4 = false;
               }

               return var4;
            }
         }
      }

      return var4;
   }

   public int getBackgroundColor() {
      return this.xB;
   }

   public JSONObject getCustomData() {
      return this.Ga;
   }

   public int getEdgeColor() {
      return this.GW;
   }

   public int getEdgeType() {
      return this.GV;
   }

   public String getFontFamily() {
      return this.Ha;
   }

   public int getFontGenericFamily() {
      return this.Hb;
   }

   public float getFontScale() {
      return this.GT;
   }

   public int getFontStyle() {
      return this.Hc;
   }

   public int getForegroundColor() {
      return this.GU;
   }

   public int getWindowColor() {
      return this.GY;
   }

   public int getWindowCornerRadius() {
      return this.GZ;
   }

   public int getWindowType() {
      return this.GX;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Float.valueOf(this.GT), Integer.valueOf(this.GU), Integer.valueOf(this.xB), Integer.valueOf(this.GV), Integer.valueOf(this.GW), Integer.valueOf(this.GX), Integer.valueOf(this.GY), Integer.valueOf(this.GZ), this.Ha, Integer.valueOf(this.Hb), Integer.valueOf(this.Hc), this.Ga});
   }

   public void setBackgroundColor(int var1) {
      this.xB = var1;
   }

   public void setCustomData(JSONObject var1) {
      this.Ga = var1;
   }

   public void setEdgeColor(int var1) {
      this.GW = var1;
   }

   public void setEdgeType(int var1) {
      if(var1 >= 0 && var1 <= 4) {
         this.GV = var1;
      } else {
         throw new IllegalArgumentException("invalid edgeType");
      }
   }

   public void setFontFamily(String var1) {
      this.Ha = var1;
   }

   public void setFontGenericFamily(int var1) {
      if(var1 >= 0 && var1 <= 6) {
         this.Hb = var1;
      } else {
         throw new IllegalArgumentException("invalid fontGenericFamily");
      }
   }

   public void setFontScale(float var1) {
      this.GT = var1;
   }

   public void setFontStyle(int var1) {
      if(var1 >= 0 && var1 <= 3) {
         this.Hc = var1;
      } else {
         throw new IllegalArgumentException("invalid fontStyle");
      }
   }

   public void setForegroundColor(int var1) {
      this.GU = var1;
   }

   public void setWindowColor(int var1) {
      this.GY = var1;
   }

   public void setWindowCornerRadius(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException("invalid windowCornerRadius");
      } else {
         this.GZ = var1;
      }
   }

   public void setWindowType(int var1) {
      if(var1 >= 0 && var1 <= 2) {
         this.GX = var1;
      } else {
         throw new IllegalArgumentException("invalid windowType");
      }
   }

   public JSONObject toJson() {
      // $FF: Couldn't be decompiled
   }
}
