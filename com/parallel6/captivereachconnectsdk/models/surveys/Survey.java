package com.parallel6.captivereachconnectsdk.models.surveys;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.surveys.SurveyItem;

public class Survey extends SurveyItem {
   @SerializedName("answered")
   private int answered;
   @SerializedName("completion_text")
   private String completion;
   @SerializedName("introduction")
   private String introduction;

   public Survey(long var1, String var3) {
      super(var1, var3);
   }

   public int getAnswered() {
      return this.answered;
   }

   public String getCompletion() {
      return this.completion;
   }

   public String getIntroduction() {
      return this.introduction;
   }

   public void setAnswered(int var1) {
      this.answered = var1;
   }

   public void setCompletion(String var1) {
      this.completion = var1;
   }

   public void setIntroduction(String var1) {
      this.introduction = var1;
   }
}
