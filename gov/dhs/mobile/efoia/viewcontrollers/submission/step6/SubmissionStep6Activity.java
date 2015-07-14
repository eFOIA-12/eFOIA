package gov.dhs.mobile.efoia.viewcontrollers.submission.step6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step7.SubmissionStep7Activity;

public class SubmissionStep6Activity extends Activity {
   private ToggleButton affiliateToggle;
   private ToggleButton infoToggle;
   private ImageButton nextButton;
   private ToggleButton privateToggle;
   private ToggleButton repToggle;
   private String requestType;
   private Submission submission;

   private void attributeText(TextView var1) {
      String var3 = var1.getText().toString();
      int var2 = var3.indexOf("*");
      SpannableStringBuilder var4 = new SpannableStringBuilder(var3);
      var4.setSpan(new ForegroundColorSpan(-65536), var2, var2 + 1, 18);
      var1.setText(var4);
   }

   public void goBack(View var1) {
      this.finish();
   }

   public void next(View var1) {
      this.submission.setRequestCategory(this.requestType);
      Intent var3 = new Intent(this, SubmissionStep7Activity.class);
      Bundle var2 = new Bundle();
      var2.putParcelable("submission", this.submission);
      var3.putExtras(var2);
      this.startActivity(var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968624);
      this.requestType = "";
      Typeface var9 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.submission = (Submission)this.getIntent().getExtras().getParcelable("submission");
      this.nextButton = (ImageButton)this.findViewById(2131689710);
      this.infoToggle = (ToggleButton)this.findViewById(2131689717);
      this.repToggle = (ToggleButton)this.findViewById(2131689719);
      this.affiliateToggle = (ToggleButton)this.findViewById(2131689721);
      this.privateToggle = (ToggleButton)this.findViewById(2131689723);
      TextView var3 = (TextView)this.findViewById(2131689718);
      TextView var4 = (TextView)this.findViewById(2131689720);
      TextView var5 = (TextView)this.findViewById(2131689722);
      TextView var6 = (TextView)this.findViewById(2131689713);
      TextView var7 = (TextView)this.findViewById(2131689716);
      TextView var8 = (TextView)this.findViewById(2131689724);
      var3.setTypeface(var2);
      var4.setTypeface(var2);
      var5.setTypeface(var2);
      var8.setTypeface(var2);
      var6.setTypeface(var9);
      var7.setTypeface(var9);
      this.attributeText(var6);
      this.nextButton.setEnabled(false);
   }

   public void setSubmissionType(View var1) {
      this.nextButton.setEnabled(true);
      ToggleButton var2 = (ToggleButton)var1;
      if(var2.getId() == this.infoToggle.getId()) {
         this.requestType = "Personal Use ";
         this.repToggle.setChecked(false);
         this.privateToggle.setChecked(false);
         this.affiliateToggle.setChecked(false);
      } else {
         if(var2.getId() == this.repToggle.getId()) {
            this.requestType = "News Media ";
            this.infoToggle.setChecked(false);
            this.privateToggle.setChecked(false);
            this.affiliateToggle.setChecked(false);
            return;
         }

         if(var2.getId() == this.privateToggle.getId()) {
            this.requestType = "Educational or Scholarly ";
            this.infoToggle.setChecked(false);
            this.repToggle.setChecked(false);
            this.affiliateToggle.setChecked(false);
            return;
         }

         if(var2.getId() == this.affiliateToggle.getId()) {
            this.requestType = "Private Corporation ";
            this.infoToggle.setChecked(false);
            this.repToggle.setChecked(false);
            this.privateToggle.setChecked(false);
            return;
         }
      }

   }
}
