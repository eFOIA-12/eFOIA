package io.fabric.sdk.android.services.settings;

public class PromptSettingsData {
   public final String alwaysSendButtonTitle;
   public final String cancelButtonTitle;
   public final String message;
   public final String sendButtonTitle;
   public final boolean showAlwaysSendButton;
   public final boolean showCancelButton;
   public final String title;

   public PromptSettingsData(String var1, String var2, String var3, boolean var4, String var5, boolean var6, String var7) {
      this.title = var1;
      this.message = var2;
      this.sendButtonTitle = var3;
      this.showCancelButton = var4;
      this.cancelButtonTitle = var5;
      this.showAlwaysSendButton = var6;
      this.alwaysSendButtonTitle = var7;
   }
}
