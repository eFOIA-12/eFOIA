package gov.dhs.mobile.efoia.viewcontrollers.submission.step1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.arrayadapters.ComponentArrayAdapter;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.models.Component;
import gov.dhs.mobile.efoia.models.SubmissionPageOne;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step2.SubmissionStep2Activity;
import gov.dhs.mobile.efoia.webview.FOIAWebView;
import java.lang.reflect.Type;
import java.util.List;

public class SubmissionStep1Activity extends Activity {
   private Button choose_secretary_button;
   private TaskListener cmsTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            SubmissionStep1Activity.this.componentList = var1.getContent();
            SubmissionStep1Activity.this.componentList.add(0, new Component(0L, "Select Component", "", (CRImage)null, ""));
            ComponentArrayAdapter var2 = new ComponentArrayAdapter(SubmissionStep1Activity.this.mContext, 2130968674, SubmissionStep1Activity.this.componentList);
            SubmissionStep1Activity.this.select_dhs_component.setAdapter(var2);
            SubmissionStep1Activity.this.select_dhs_component.setOnItemSelectedListener(new OnItemSelectedListener() {
               public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
                  SubmissionStep1Activity.this.submission.setComponent(((Component)SubmissionStep1Activity.this.componentList.get(var3)).getValue() + " ");
                  if(var3 > 0) {
                     SubmissionStep1Activity.this.next_button.setEnabled(true);
                  } else {
                     SubmissionStep1Activity.this.next_button.setEnabled(false);
                  }
               }

               public void onNothingSelected(AdapterView var1) {
               }
            });
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private TextView component;
   private List componentList;
   private Context mContext = this;
   private ImageButton next_button;
   private SubmissionPageOne pageOneLinks;
   private TaskListener pageOneTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            SubmissionStep1Activity.this.pageOneLinks = (SubmissionPageOne)var1.getContent().get(0);
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private TextView select_component_text;
   private Button select_component_url;
   private Spinner select_dhs_component;
   private TextView select_text;
   private boolean set;
   private TextView step_1_desc;
   private TextView step_1_title;
   private TextView step_page_title;
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
      Intent var3 = new Intent(this, SubmissionStep2Activity.class);
      Bundle var2 = new Bundle();
      var2.putParcelable("submission", this.submission);
      var3.putExtras(var2);
      this.startActivity(var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968619);
      this.step_1_desc = (TextView)this.findViewById(2131689650);
      this.step_1_title = (TextView)this.findViewById(2131689652);
      this.step_page_title = (TextView)this.findViewById(2131689651);
      this.next_button = (ImageButton)this.findViewById(2131689653);
      this.component = (TextView)this.findViewById(2131689655);
      this.select_text = (TextView)this.findViewById(2131689656);
      this.choose_secretary_button = (Button)this.findViewById(2131689657);
      this.select_component_url = (Button)this.findViewById(2131689658);
      this.select_component_text = (TextView)this.findViewById(2131689659);
      this.select_dhs_component = (Spinner)this.findViewById(2131689660);
      Typeface var3 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      this.step_1_desc.setTypeface(var2);
      this.step_1_title.setTypeface(var3);
      this.step_page_title.setTypeface(var3);
      this.component.setTypeface(var2);
      this.select_text.setTypeface(var3);
      this.choose_secretary_button.setTypeface(var2);
      this.select_component_url.setTypeface(var2);
      this.select_component_text.setTypeface(var2);
      this.next_button.setEnabled(false);
      this.submission = new Submission();
      this.attributeText(this.select_text);
      this.set = false;
      Type var4 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink("dhs_component").withParam("page", "0").withTaskListener(this.cmsTaskListener).withType(var4).build().execute();
      var4 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink("submission_1").withTaskListener(this.pageOneTaskListener).withType(var4).build().execute();
      new ComponentArrayAdapter(this, 2130968674, this.componentList);
   }

   public void showComponent(View var1) {
      Intent var3 = new Intent(this, FOIAWebView.class);
      Bundle var2 = new Bundle();
      var2.putString("key_url", this.pageOneLinks.getComponent());
      var2.putString("extras_title", "Component");
      var3.putExtras(var2);
      this.startActivity(var3);
   }

   public void showSecretary(View var1) {
      Intent var3 = new Intent(this, FOIAWebView.class);
      Bundle var2 = new Bundle();
      var2.putString("key_url", this.pageOneLinks.getSecretary());
      var2.putString("extras_title", "Office of the Secretary");
      var3.putExtras(var2);
      this.startActivity(var3);
   }
}
