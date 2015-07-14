package com.parallel6.ui.configurability.models;

import com.google.gson.annotations.SerializedName;

public class CRConfLayoutStyle {
   @SerializedName("bold")
   private boolean bold;
   @SerializedName("font_color")
   private String fontColor;
   @SerializedName("font_size")
   private int fontSize;
   @SerializedName("horizontal_alignment")
   private String horizontalAlignment;
   @SerializedName("italic")
   private boolean italic;
   @SerializedName("max_lines")
   private int maxLines;
   @SerializedName("underlined")
   private boolean underlined;
   @SerializedName("vertical_alignment")
   private String verticalAlignment;

   public String getFontColor() {
      return this.fontColor;
   }

   public int getFontSize() {
      return this.fontSize;
   }

   public String getHorizontalAlignment() {
      return this.horizontalAlignment;
   }

   public int getMaxLines() {
      return this.maxLines;
   }

   public String getVerticalAlignment() {
      return this.verticalAlignment;
   }

   public boolean isBold() {
      return this.bold;
   }

   public boolean isItalic() {
      return this.italic;
   }

   public boolean isUnderlined() {
      return this.underlined;
   }

   public void setBold(boolean var1) {
      this.bold = var1;
   }

   public void setFontColor(String var1) {
      this.fontColor = var1;
   }

   public void setFontSize(int var1) {
      this.fontSize = var1;
   }

   public void setHorizontalAlignment(String var1) {
      this.horizontalAlignment = var1;
   }

   public void setItalic(boolean var1) {
      this.italic = var1;
   }

   public void setMaxLines(int var1) {
      this.maxLines = var1;
   }

   public void setUnderlined(boolean var1) {
      this.underlined = var1;
   }

   public void setVerticalAlignment(String var1) {
      this.verticalAlignment = var1;
   }
}
