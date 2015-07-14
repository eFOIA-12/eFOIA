package gov.dhs.mobile.efoia.viewcontrollers.privacypolicy;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.models.PrivacyPolicy;
import java.lang.reflect.Type;

public class PrivacyPolicyActivity extends Activity {
   private TaskListener cmsTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            PrivacyPolicy var2 = (PrivacyPolicy)var1.getContent().get(0);
            PrivacyPolicyActivity.this.policyTextView.setText(Html.fromHtml(var2.getPolicy()));
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private TextView policyTextView;

   public void cancelPressed(View var1) {
      Builder var2 = new Builder(this);
      var2.setTitle("Privacy Act Statement");
      var2.setMessage("To use this app, you must agree to the privacy policy. If you do not agree and wish to quit, please press home and remove the app.").setCancelable(false).setPositiveButton("OK", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var1.cancel();
         }
      });
      var2.create().show();
   }

   public void goBack(View var1) {
      this.finish();
   }

   public void okPressed(View var1) {
      Editor var2 = this.getSharedPreferences("E-FOIA_PREFS", 0).edit();
      var2.putBoolean("AGREED", true);
      var2.commit();
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968615);
      String var5 = this.getIntent().getExtras().getString("action_object");
      ImageButton var2 = (ImageButton)this.findViewById(2131689643);
      ImageButton var3 = (ImageButton)this.findViewById(2131689642);
      ImageButton var4 = (ImageButton)this.findViewById(2131689640);
      if(this.getSharedPreferences("E-FOIA_PREFS", 0).getBoolean("AGREED", false)) {
         var2.setVisibility(8);
         var3.setVisibility(8);
      } else {
         var4.setVisibility(8);
      }

      this.policyTextView = (TextView)this.findViewById(2131689641);
      this.policyTextView.setMovementMethod(new LinkMovementMethod());
      Typeface var6 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.policyTextView.setTypeface(var6);
      Type var7 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink(var5).withTaskListener(this.cmsTaskListener).withType(var7).build().execute();
   }
}
