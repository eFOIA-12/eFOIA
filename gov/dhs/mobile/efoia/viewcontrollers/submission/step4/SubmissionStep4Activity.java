package gov.dhs.mobile.efoia.viewcontrollers.submission.step4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step5.SubmissionStep5Activity;

public class SubmissionStep4Activity extends Activity {
   private EditText recordsRequest;
   private Submission submission;

   public void goBack(View var1) {
      this.finish();
   }

   public void next(View var1) {
      this.submission.setRecordsDescription(this.recordsRequest.getText().toString());
      Intent var3 = new Intent(this, SubmissionStep5Activity.class);
      Bundle var2 = new Bundle();
      var2.putParcelable("submission", this.submission);
      var3.putExtras(var2);
      this.startActivity(var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968622);
      Typeface var7 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      TextView var3 = (TextView)this.findViewById(2131689705);
      TextView var4 = (TextView)this.findViewById(2131689706);
      TextView var5 = (TextView)this.findViewById(2131689707);
      TextView var6 = (TextView)this.findViewById(2131689708);
      this.recordsRequest = (EditText)this.findViewById(2131689709);
      this.submission = (Submission)this.getIntent().getExtras().getParcelable("submission");
      var3.setTypeface(var7);
      var4.setTypeface(var2);
      var5.setTypeface(var2);
      var6.setTypeface(var7);
      this.recordsRequest.setTypeface(var2);
   }
}
