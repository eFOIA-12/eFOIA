package gov.dhs.mobile.efoia.viewcontrollers.submission.step7;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step8.SubmissionStep8Activity;

public class SubmissionStep7Activity extends Activity {
   private Submission submission;
   private EditText waiverText;

   public void goBack(View var1) {
      this.finish();
   }

   public void next(View var1) {
      Intent var3 = new Intent(this, SubmissionStep8Activity.class);
      Bundle var2 = new Bundle();
      var2.putParcelable("submission", this.submission);
      var3.putExtras(var2);
      this.startActivity(var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968625);
      Typeface var9 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.submission = (Submission)this.getIntent().getExtras().getParcelable("submission");
      TextView var3 = (TextView)this.findViewById(2131689725);
      TextView var4 = (TextView)this.findViewById(2131689726);
      TextView var5 = (TextView)this.findViewById(2131689727);
      TextView var6 = (TextView)this.findViewById(2131689728);
      ToggleButton var7 = (ToggleButton)this.findViewById(2131689730);
      TextView var10 = (TextView)this.findViewById(2131689731);
      TextView var8 = (TextView)this.findViewById(2131689732);
      this.waiverText = (EditText)this.findViewById(2131689733);
      var3.setTypeface(var9);
      var4.setTypeface(var2);
      var5.setTypeface(var2);
      var6.setTypeface(var9);
      var10.setTypeface(var2);
      var8.setTypeface(var9);
      this.waiverText.setTypeface(var2);
   }

   public void setSubmissionType(View var1) {
      if(((ToggleButton)var1).isChecked()) {
         this.submission.setRequestFeeWaiver(true);
         this.submission.setFeeWaiverDescription(this.waiverText.getText().toString());
      } else {
         this.submission.setRequestFeeWaiver(false);
         this.submission.setFeeWaiverDescription("");
         this.waiverText.setText("");
      }
   }
}
