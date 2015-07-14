package gov.dhs.mobile.efoia.viewcontrollers.submission.step3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step4.SubmissionStep4Activity;

public class SubmissionStep3Activity extends Activity {
   private EditText initials;
   private ImageButton nextButton;
   private ToggleButton perjury;
   private ToggleButton recordsNo;
   private ToggleButton recordsYes;
   private Submission submission;

   private void attributeText(TextView var1) {
      String var3 = var1.getText().toString();
      int var2 = var3.indexOf("*");
      SpannableStringBuilder var4 = new SpannableStringBuilder(var3);
      var4.setSpan(new ForegroundColorSpan(-65536), var2, var2 + 1, 18);
      var1.setText(var4);
   }

   private boolean validateEntries() {
      if(!this.recordsYes.isChecked()) {
         this.nextButton.setEnabled(true);
         this.submission.setRecordsForSelf(false);
         return true;
      } else if(this.initials.getText().toString().length() > 1 && this.perjury.isChecked()) {
         this.submission.setInitials(this.initials.getText().toString());
         this.submission.setDeclaration(true);
         return true;
      } else {
         return false;
      }
   }

   public void goBack(View var1) {
      this.finish();
   }

   public void next(View var1) {
      if(this.validateEntries()) {
         Intent var3 = new Intent(this, SubmissionStep4Activity.class);
         Bundle var2 = new Bundle();
         var2.putParcelable("submission", this.submission);
         var3.putExtras(var2);
         this.startActivity(var3);
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968621);
      Typeface var12 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.submission = (Submission)this.getIntent().getExtras().getParcelable("submission");
      this.recordsYes = (ToggleButton)this.findViewById(2131689695);
      this.recordsNo = (ToggleButton)this.findViewById(2131689697);
      this.perjury = (ToggleButton)this.findViewById(2131689701);
      this.initials = (EditText)this.findViewById(2131689704);
      this.nextButton = (ImageButton)this.findViewById(2131689653);
      TextView var3 = (TextView)this.findViewById(2131689690);
      TextView var4 = (TextView)this.findViewById(2131689691);
      TextView var5 = (TextView)this.findViewById(2131689693);
      TextView var6 = (TextView)this.findViewById(2131689696);
      TextView var7 = (TextView)this.findViewById(2131689698);
      TextView var8 = (TextView)this.findViewById(2131689699);
      TextView var9 = (TextView)this.findViewById(2131689702);
      TextView var10 = (TextView)this.findViewById(2131689703);
      TextView var11 = (TextView)this.findViewById(2131689689);
      var5.setTypeface(var12);
      var10.setTypeface(var12);
      var11.setTypeface(var12);
      var8.setTypeface(var12);
      var3.setTypeface(var2);
      var4.setTypeface(var2);
      var9.setTypeface(var2);
      this.initials.setTypeface(var2);
      var6.setTypeface(var2);
      var7.setTypeface(var2);
      this.attributeText(var5);
      this.submission.setRecordsForSelf(true);
   }

   public void setSubmissionType(View var1) {
      if(((ToggleButton)var1).getId() == this.recordsNo.getId()) {
         this.initials.setEnabled(false);
         this.perjury.setEnabled(false);
         this.recordsYes.setChecked(false);
         this.initials.setText("");
         this.perjury.setChecked(false);
      } else {
         this.initials.setEnabled(true);
         this.perjury.setEnabled(true);
         this.recordsNo.setChecked(false);
      }
   }
}
