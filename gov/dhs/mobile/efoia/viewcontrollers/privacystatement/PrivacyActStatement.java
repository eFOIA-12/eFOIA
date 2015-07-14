package gov.dhs.mobile.efoia.viewcontrollers.privacystatement;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.models.PrivacyPolicy;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step1.SubmissionStep1Activity;

public class PrivacyActStatement extends Activity {
   private TaskListener cmsTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            PrivacyPolicy var2 = (PrivacyPolicy)var1.getContent().get(0);
            PrivacyActStatement.this.policyTextView.setText(Html.fromHtml(var2.getPolicy()));
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private TextView policyTextView;

   public void goBack(View var1) {
      this.finish();
   }

   public void goNext(View var1) {
      this.startActivity(new Intent(this, SubmissionStep1Activity.class));
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968616);
      this.policyTextView = (TextView)this.findViewById(2131689641);
      this.policyTextView.setMovementMethod(new LinkMovementMethod());
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.policyTextView.setTypeface(var2);
      this.policyTextView.setText(Html.fromHtml("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"><html><head></head><body><p class=\"p1\"><span class=\"s1\"><b>Privacy Act Statement</b></span></p><p class=\"p1\"><span class=\"s1\"><b>eFOIA Mobile Application</b></span></p><p class=\"p1\"><span class=\"s1\"> </span></p><p class=\"p1\"><span class=\"s1\"><b>Authorities: </b>5 U.S.C. § 552, 5 U.S.C. § 552a, and 44 U.S.C. § 3101 authorize the collection of this information.</span></p><p class=\"p1\"><span class=\"s1\"> </span></p><p class=\"p1\"><span class=\"s1\"><b>Purpose:</b>  DHS will use this information to locate applicable records and to respond to requests made under the Freedom of Information Act (5 U.S.C. § 552) and Privacy Act of 1974 (5 U.S.C. § 552a).</span></p><p class=\"p1\"><span class=\"s1\"> </span></p><p class=\"p1\"><span class=\"s1\"><b>Routine Uses:</b>  This information may be used by and disclosed to DHS personnel, contractors, and/or other agents who need the information to assist in activities related to the processing of your Freedom of Information Act and/or Privacy Act request.  Additionally, DHS may use the information, as necessary and authorized by the routine uses published in the <a href=\"https://www.federalregister.gov/articles/2014/02/04/2014-02206/privacy-act-of-1974-department-of-homeland-securityall-001-freedom-of-information-act-and-privacy\"><span class=\"s2\">DHS/ALL-001 - Department of Homeland Security (DHS) Freedom of Information Act (FIOA)and Privacy Act (PA) Record System</span></a> February 4, 2014, 79 FR 6609.</span></p><p class=\"p1\"><span class=\"s1\"> </span></p><p class=\"p2\"><span class=\"s1\"><b>Disclosure:</b> Furnishing this information is voluntary; however, failure to provide the information requested may delay or prevent DHS from processing your Freedom of Information Act or Privacy Act Request.</span></p></body></html>"));
   }
}
