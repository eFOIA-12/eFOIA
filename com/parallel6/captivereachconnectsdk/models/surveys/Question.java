package com.parallel6.captivereachconnectsdk.models.surveys;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.enums.QuestionType;
import com.parallel6.captivereachconnectsdk.models.surveys.SurveyItem;
import java.util.List;

public class Question extends SurveyItem {
   @SerializedName("body")
   private String body;
   @SerializedName("choices")
   private List choiceList;
   @SerializedName("instructions")
   private String instructions;
   @SerializedName("style")
   private String questionStyle;
   private QuestionType questionType;
   @SerializedName("question_type")
   private String questionTypeString;
   @SerializedName("survey_id")
   private String surveyId;

   public Question() {
      super(0L, "");
   }

   public Question(String var1, String var2, List var3) {
      super(0L, (String)null);
      this.body = var1;
      this.questionTypeString = var2;
      this.choiceList = var3;
   }

   public String getBody() {
      return this.body;
   }

   public List getChoiceList() {
      return this.choiceList;
   }

   public String getInstructions() {
      return this.instructions;
   }

   public String getQuestionStyle() {
      return this.questionStyle;
   }

   public QuestionType getQuestionType() {
      return this.questionType;
   }

   public String getQuestionTypeString() {
      return this.questionTypeString;
   }

   public String getSurveyId() {
      return this.surveyId;
   }

   public void setBody(String var1) {
      this.body = var1;
   }

   public void setChoiceList(List var1) {
      this.choiceList = var1;
   }

   public void setInstructions(String var1) {
      this.instructions = var1;
   }

   public void setQuestionStyle(String var1) {
      this.questionStyle = var1;
   }

   public void setQuestionType(QuestionType var1) {
      this.questionType = var1;
   }

   public void setQuestionTypeString(String var1) {
      this.questionTypeString = var1;
   }

   public void setSurveyId(String var1) {
      this.surveyId = var1;
   }
}
