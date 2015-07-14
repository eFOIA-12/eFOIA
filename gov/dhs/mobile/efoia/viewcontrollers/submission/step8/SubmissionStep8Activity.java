package gov.dhs.mobile.efoia.viewcontrollers.submission.step8;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import gov.dhs.mobile.efoia.MainActivity;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.tasks.RetrieveFormIDTask;
import gov.dhs.mobile.efoia.tasks.SubmitFOIATask;
import java.util.concurrent.ExecutionException;

public class SubmissionStep8Activity extends Activity {
   private String expediteSubmissionText;
   private EditText expediteText;
   private ToggleButton harmToggle;
   private ToggleButton impairmentToggle;
   private Submission submission;
   private ToggleButton threatToggle;
   private ToggleButton urgencyToggle;

   public void goBack(View var1) {
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968626);
      this.expediteSubmissionText = "";
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var3 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.submission = (Submission)this.getIntent().getExtras().getParcelable("submission");
      TextView var4 = (TextView)this.findViewById(2131689734);
      TextView var5 = (TextView)this.findViewById(2131689735);
      TextView var6 = (TextView)this.findViewById(2131689736);
      TextView var7 = (TextView)this.findViewById(2131689737);
      TextView var8 = (TextView)this.findViewById(2131689739);
      TextView var9 = (TextView)this.findViewById(2131689741);
      TextView var10 = (TextView)this.findViewById(2131689743);
      TextView var11 = (TextView)this.findViewById(2131689745);
      TextView var12 = (TextView)this.findViewById(2131689746);
      ImageButton var15 = (ImageButton)this.findViewById(2131689748);
      this.expediteText = (EditText)this.findViewById(2131689747);
      this.threatToggle = (ToggleButton)this.findViewById(2131689738);
      this.urgencyToggle = (ToggleButton)this.findViewById(2131689740);
      this.impairmentToggle = (ToggleButton)this.findViewById(2131689742);
      this.harmToggle = (ToggleButton)this.findViewById(2131689744);
      var4.setTypeface(var2);
      var5.setTypeface(var3);
      var6.setTypeface(var3);
      var7.setTypeface(var2);
      var8.setTypeface(var3);
      var9.setTypeface(var3);
      var10.setTypeface(var3);
      var11.setTypeface(var3);
      var12.setTypeface(var2);
      this.expediteText.setTypeface(var3);
      var15.setEnabled(false);
      RetrieveFormIDTask var16 = new RetrieveFormIDTask();

      try {
         this.submission.setDrupalFormID((String)var16.execute(new Void[0]).get());
         var15.setEnabled(true);
      } catch (InterruptedException var13) {
         Toast.makeText(this, "An Error has Occurred Please Try Again Later", 0);
      } catch (ExecutionException var14) {
         Toast.makeText(this, "An Error has Occurred Please Try Again Later", 0);
      }
   }

   public void setSubmissionType(View var1) {
      ToggleButton var2 = (ToggleButton)var1;
      if(var2.getId() == this.threatToggle.getId()) {
         this.expediteSubmissionText = "Imminent threat to the life or physical safety of an individual ";
      } else if(var2.getId() == this.harmToggle.getId()) {
         this.expediteSubmissionText = "A harm to substantial humanitarian concerns exists ";
      } else if(var2.getId() == this.impairmentToggle.getId()) {
         this.expediteSubmissionText = "An impairment of substantial due process rights of the requester exists ";
      } else {
         this.expediteSubmissionText = "Urgency to inform the public concerning actual or alleged Federal Government activity ";
      }
   }

   public void submitFOIA(View var1) {
      CaptiveReachConnect.getInstance().trackInsightV2(this, "Submission", "Executed Submission", "", "");
      SubmitFOIATask var3 = new SubmitFOIATask();
      this.submission.setExpediteRequested(this.expediteSubmissionText);
      this.submission.setExpediteRequestedDescription(this.expediteText.getText().toString());

      Builder var4;
      try {
         if(((Boolean)var3.execute(new Submission[]{this.submission}).get()).booleanValue()) {
            var4 = new Builder(this);
            var4.setMessage("Your FOIA Request Has Been Submitted").setTitle("FOIA Submission").setCancelable(false).setPositiveButton("OK", new OnClickListener() {
               public void onClick(DialogInterface var1, int var2) {
                  Intent var3 = new Intent(SubmissionStep8Activity.this.getApplicationContext(), MainActivity.class);
                  var3.addFlags(67108864);
                  SubmissionStep8Activity.this.startActivity(var3);
               }
            });
            var4.create().show();
         } else {
            var4 = new Builder(this);
            var4.setMessage("An Error has Occurred Please Try Again Later").setCancelable(false).setPositiveButton("OK", new OnClickListener() {
               public void onClick(DialogInterface var1, int var2) {
                  Intent var3 = new Intent(SubmissionStep8Activity.this.getApplicationContext(), MainActivity.class);
                  var3.addFlags(67108864);
                  SubmissionStep8Activity.this.startActivity(var3);
               }
            });
            var4.create().show();
         }
      } catch (Exception var2) {
         var4 = new Builder(this);
         var4.setMessage("An Error has Occurred Please Try Again Later").setCancelable(false).setPositiveButton("OK", new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               Intent var3 = new Intent(SubmissionStep8Activity.this.getApplicationContext(), MainActivity.class);
               var3.addFlags(67108864);
               SubmissionStep8Activity.this.startActivity(var3);
            }
         });
         var4.create().show();
      }
   }
}
