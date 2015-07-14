package com.parallel6.captivereachconnectsdk.models.surveys;

import com.google.gson.annotations.SerializedName;

public class Answer {
   @SerializedName("choice_id")
   private long choiceId;
   @SerializedName("question_id")
   private long questionId;
   @SerializedName("rank")
   private int rank;
   @SerializedName("value")
   private String value;

   public Answer() {
   }

   public Answer(String var1, long var2) {
      this(var1, -1L, var2);
   }

   public Answer(String var1, long var2, long var4) {
      this(var1, var2, var4, -1);
   }

   public Answer(String var1, long var2, long var4, int var6) {
      this.value = var1;
      this.choiceId = var2;
      this.questionId = var4;
      this.rank = var6;
   }

   public long getChoiceId() {
      return this.choiceId;
   }

   public long getQuestionId() {
      return this.questionId;
   }

   public int getRank() {
      return this.rank;
   }

   public String getValue() {
      return this.value;
   }

   public void setChoiceId(long var1) {
      this.choiceId = var1;
   }

   public void setQuestionId(long var1) {
      this.questionId = var1;
   }

   public void setRank(int var1) {
      this.rank = var1;
   }

   public void setValue(String var1) {
      this.value = var1;
   }
}
