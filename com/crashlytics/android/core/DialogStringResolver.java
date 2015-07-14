package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.PromptSettingsData;

class DialogStringResolver {
   private static final String PROMPT_MESSAGE_RES_NAME = "com.crashlytics.CrashSubmissionPromptMessage";
   private static final String PROMPT_TITLE_RES_NAME = "com.crashlytics.CrashSubmissionPromptTitle";
   private static final String SUBMISSION_ALWAYS_SEND_RES_NAME = "com.crashlytics.CrashSubmissionAlwaysSendTitle";
   private static final String SUBMISSION_CANCEL_RES_NAME = "com.crashlytics.CrashSubmissionCancelTitle";
   private static final String SUBMISSION_SEND_RES_NAME = "com.crashlytics.CrashSubmissionSendTitle";
   private final Context context;
   private final PromptSettingsData promptData;

   public DialogStringResolver(Context var1, PromptSettingsData var2) {
      this.context = var1;
      this.promptData = var2;
   }

   private boolean isNullOrEmpty(String var1) {
      return var1 == null || var1.length() == 0;
   }

   private String resourceOrFallbackValue(String var1, String var2) {
      return this.stringOrFallback(CommonUtils.getStringsFileValue(this.context, var1), var2);
   }

   private String stringOrFallback(String var1, String var2) {
      return this.isNullOrEmpty(var1)?var2:var1;
   }

   public String getAlwaysSendButtonTitle() {
      return this.resourceOrFallbackValue("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.promptData.alwaysSendButtonTitle);
   }

   public String getCancelButtonTitle() {
      return this.resourceOrFallbackValue("com.crashlytics.CrashSubmissionCancelTitle", this.promptData.cancelButtonTitle);
   }

   public String getMessage() {
      return this.resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptMessage", this.promptData.message);
   }

   public String getSendButtonTitle() {
      return this.resourceOrFallbackValue("com.crashlytics.CrashSubmissionSendTitle", this.promptData.sendButtonTitle);
   }

   public String getTitle() {
      return this.resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptTitle", this.promptData.title);
   }
}
