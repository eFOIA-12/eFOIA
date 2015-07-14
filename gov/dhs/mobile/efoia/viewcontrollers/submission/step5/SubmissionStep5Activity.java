package gov.dhs.mobile.efoia.viewcontrollers.submission.step5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step6.SubmissionStep6Activity;

public class SubmissionStep5Activity extends Activity {
   EditText feeAmount;
   Submission submission;

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
      if(this.feeAmount.getText().length() > 1) {
         this.submission.setPayAmount(this.feeAmount.getText().toString());
         Intent var3 = new Intent(this, SubmissionStep6Activity.class);
         Bundle var2 = new Bundle();
         var2.putParcelable("submission", this.submission);
         var3.putExtras(var2);
         this.startActivity(var3);
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968623);
      Typeface var7 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.submission = (Submission)this.getIntent().getExtras().getParcelable("submission");
      TextView var3 = (TextView)this.findViewById(2131689712);
      TextView var4 = (TextView)this.findViewById(2131689713);
      TextView var5 = (TextView)this.findViewById(2131689714);
      this.feeAmount = (EditText)this.findViewById(2131689715);
      TextView var6 = (TextView)this.findViewById(2131689711);
      var3.setTypeface(var2);
      var4.setTypeface(var2);
      var5.setTypeface(var7);
      var6.setTypeface(var7);
      this.feeAmount.setTypeface(var2);
      this.attributeText(var5);
   }
}
