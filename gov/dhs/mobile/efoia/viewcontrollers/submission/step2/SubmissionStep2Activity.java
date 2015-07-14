package gov.dhs.mobile.efoia.viewcontrollers.submission.step2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.arrayadapters.CountryArrayAdapter;
import gov.dhs.mobile.efoia.arrayadapters.StateArrayAdapter;
import gov.dhs.mobile.efoia.arrayadapters.SuffixArrayAdapter;
import gov.dhs.mobile.efoia.arrayadapters.TitleArrayAdapter;
import gov.dhs.mobile.efoia.datastructures.Submission;
import gov.dhs.mobile.efoia.models.Country;
import gov.dhs.mobile.efoia.models.State;
import gov.dhs.mobile.efoia.models.Suffix;
import gov.dhs.mobile.efoia.models.Title;
import gov.dhs.mobile.efoia.viewcontrollers.submission.step3.SubmissionStep3Activity;
import java.lang.reflect.Type;
import java.util.List;

public class SubmissionStep2Activity extends Activity {
   private EditText addr1;
   private EditText addr2;
   private EditText city;
   private List countryList;
   private Spinner countrySpinner;
   private TaskListener countryTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            SubmissionStep2Activity.this.countryList = var1.getContent();
            SubmissionStep2Activity.this.countryList.add(0, new Country(0L, "None", "", (CRImage)null, ""));
            CountryArrayAdapter var2 = new CountryArrayAdapter(SubmissionStep2Activity.this.mContext, 2130968674, SubmissionStep2Activity.this.countryList);
            SubmissionStep2Activity.this.countrySpinner.setAdapter(var2);
            SubmissionStep2Activity.this.countrySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
               public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
                  if(var3 > 0) {
                     SubmissionStep2Activity.this.submission.setCountry(((Country)SubmissionStep2Activity.this.countryList.get(var3)).getCode());
                     SubmissionStep2Activity.this.nextButton.setEnabled(true);
                  } else {
                     SubmissionStep2Activity.this.submission.setCountry("");
                     SubmissionStep2Activity.this.nextButton.setEnabled(false);
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
   private EditText emailAddr;
   private EditText fax;
   private EditText firstName;
   private EditText lastName;
   private Context mContext = this;
   private EditText middleInitial;
   private ImageButton nextButton;
   private List stateList;
   private Spinner stateSpinner;
   private TaskListener stateTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            SubmissionStep2Activity.this.stateList = var1.getContent();
            SubmissionStep2Activity.this.stateList.add(0, new State(0L, "None", "", (CRImage)null, ""));
            StateArrayAdapter var2 = new StateArrayAdapter(SubmissionStep2Activity.this.mContext, 2130968674, SubmissionStep2Activity.this.stateList);
            SubmissionStep2Activity.this.stateSpinner.setAdapter(var2);
            SubmissionStep2Activity.this.stateSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
               public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
                  if(var3 > 0) {
                     SubmissionStep2Activity.this.submission.setState(((State)SubmissionStep2Activity.this.stateList.get(var3)).getCode());
                     SubmissionStep2Activity.this.nextButton.setEnabled(true);
                  } else {
                     SubmissionStep2Activity.this.submission.setState("");
                     SubmissionStep2Activity.this.nextButton.setEnabled(false);
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
   private Submission submission;
   private List suffixList;
   private Spinner suffixSpinner;
   private TaskListener suffixTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            SubmissionStep2Activity.this.suffixList = var1.getContent();
            SubmissionStep2Activity.this.suffixList.add(0, new Suffix(0L, "None", "", (CRImage)null));
            SuffixArrayAdapter var2 = new SuffixArrayAdapter(SubmissionStep2Activity.this.mContext, 2130968674, SubmissionStep2Activity.this.suffixList);
            SubmissionStep2Activity.this.suffixSpinner.setAdapter(var2);
            SubmissionStep2Activity.this.suffixSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
               public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
                  if(var3 > 0) {
                     SubmissionStep2Activity.this.submission.setSuffix(((Suffix)SubmissionStep2Activity.this.suffixList.get(var3)).getTitle());
                  } else {
                     SubmissionStep2Activity.this.submission.setSuffix("");
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
   private EditText telephone;
   private List titleList;
   private Spinner titleSpinner;
   private TaskListener titleTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            SubmissionStep2Activity.this.titleList = var1.getContent();
            SubmissionStep2Activity.this.titleList.add(0, new Title(0L, "None", "", (CRImage)null));
            TitleArrayAdapter var2 = new TitleArrayAdapter(SubmissionStep2Activity.this.mContext, 2130968674, SubmissionStep2Activity.this.titleList);
            SubmissionStep2Activity.this.titleSpinner.setAdapter(var2);
            SubmissionStep2Activity.this.titleSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
               public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
                  if(var3 > 0) {
                     SubmissionStep2Activity.this.submission.setTitle(((Title)SubmissionStep2Activity.this.titleList.get(var3)).getTitle());
                  } else {
                     SubmissionStep2Activity.this.submission.setTitle("");
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
   private EditText zip;

   private void attributeText(TextView var1) {
      String var3 = var1.getText().toString();
      int var2 = var3.indexOf("*");
      SpannableStringBuilder var4 = new SpannableStringBuilder(var3);
      var4.setSpan(new ForegroundColorSpan(-65536), var2, var2 + 1, 18);
      var1.setText(var4);
   }

   private boolean validateEmail(String var1) {
      return var1.matches("(?:[a-z0-9!#$%\\&\'*+/=?\\^_`{|}~-]+(?:\\.[a-z0-9!#$%\\&\'*+/=?\\^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
   }

   private boolean validateEntries() {
      return this.firstName.getText().toString().length() > 1 && this.lastName.getText().toString().length() > 1 && this.emailAddr.getText().toString().length() > 1 && this.validateEmail(this.emailAddr.getText().toString()) && this.submission.getCountry().length() > 1 && this.addr1.getText().toString().length() > 1 && this.submission.getState().toString().length() > 1 && this.zip.getText().toString().length() > 1;
   }

   public void goBack(View var1) {
      this.finish();
   }

   public void next(View var1) {
      if(this.validateEntries()) {
         this.submission.setAddressLine2(this.addr2.getText().toString());
         this.submission.setAddressLine1(this.addr1.getText().toString());
         this.submission.setZipCode(this.zip.getText().toString());
         this.submission.setEmailAddress(this.emailAddr.getText().toString());
         this.submission.setFirstName(this.firstName.getText().toString());
         this.submission.setLastName(this.lastName.getText().toString());
         this.submission.setCity(this.city.getText().toString());
         this.submission.setMiddleInitial(this.middleInitial.getText().toString());
         this.submission.setTelephone(this.telephone.getText().toString());
         this.submission.setFax(this.fax.getText().toString());
         Intent var3 = new Intent(this, SubmissionStep3Activity.class);
         Bundle var2 = new Bundle();
         var2.putParcelable("submission", this.submission);
         var3.putExtras(var2);
         this.startActivity(var3);
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968620);
      this.submission = (Submission)this.getIntent().getExtras().getParcelable("submission");
      Typeface var19 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      TextView var3 = (TextView)this.findViewById(2131689650);
      TextView var4 = (TextView)this.findViewById(2131689652);
      TextView var5 = (TextView)this.findViewById(2131689661);
      TextView var6 = (TextView)this.findViewById(2131689663);
      TextView var7 = (TextView)this.findViewById(2131689665);
      this.titleSpinner = (Spinner)this.findViewById(2131689662);
      this.firstName = (EditText)this.findViewById(2131689664);
      this.middleInitial = (EditText)this.findViewById(2131689666);
      TextView var8 = (TextView)this.findViewById(2131689667);
      this.lastName = (EditText)this.findViewById(2131689668);
      TextView var9 = (TextView)this.findViewById(2131689669);
      this.suffixSpinner = (Spinner)this.findViewById(2131689670);
      TextView var10 = (TextView)this.findViewById(2131689671);
      this.emailAddr = (EditText)this.findViewById(2131689672);
      TextView var11 = (TextView)this.findViewById(2131689673);
      this.countrySpinner = (Spinner)this.findViewById(2131689674);
      TextView var12 = (TextView)this.findViewById(2131689675);
      this.addr1 = (EditText)this.findViewById(2131689676);
      TextView var13 = (TextView)this.findViewById(2131689677);
      this.addr2 = (EditText)this.findViewById(2131689678);
      TextView var14 = (TextView)this.findViewById(2131689679);
      this.city = (EditText)this.findViewById(2131689680);
      TextView var15 = (TextView)this.findViewById(2131689681);
      this.stateSpinner = (Spinner)this.findViewById(2131689682);
      TextView var16 = (TextView)this.findViewById(2131689683);
      this.zip = (EditText)this.findViewById(2131689684);
      TextView var17 = (TextView)this.findViewById(2131689685);
      this.telephone = (EditText)this.findViewById(2131689686);
      TextView var18 = (TextView)this.findViewById(2131689687);
      this.fax = (EditText)this.findViewById(2131689688);
      this.nextButton = (ImageButton)this.findViewById(2131689653);
      var3.setTypeface(var19);
      var4.setTypeface(var19);
      var5.setTypeface(var19);
      var6.setTypeface(var19);
      var7.setTypeface(var19);
      var8.setTypeface(var19);
      var9.setTypeface(var19);
      var10.setTypeface(var19);
      var11.setTypeface(var19);
      var12.setTypeface(var19);
      var13.setTypeface(var19);
      var14.setTypeface(var19);
      var15.setTypeface(var19);
      var16.setTypeface(var19);
      var17.setTypeface(var19);
      var18.setTypeface(var19);
      this.firstName.setTypeface(var2);
      this.middleInitial.setTypeface(var2);
      this.lastName.setTypeface(var2);
      this.emailAddr.setTypeface(var2);
      this.addr1.setTypeface(var2);
      this.addr2.setTypeface(var2);
      this.city.setTypeface(var2);
      this.zip.setTypeface(var2);
      this.telephone.setTypeface(var2);
      this.fax.setTypeface(var2);
      this.attributeText(var6);
      this.attributeText(var8);
      this.attributeText(var14);
      this.attributeText(var15);
      this.attributeText(var10);
      this.attributeText(var16);
      this.attributeText(var11);
      this.attributeText(var12);
      Type var20 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink("title").withParam("page", "0").withTaskListener(this.titleTaskListener).withType(var20).build().execute();
      var20 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink("suffix").withParam("page", "0").withTaskListener(this.suffixTaskListener).withType(var20).build().execute();
      var20 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink("state").withTaskListener(this.stateTaskListener).withParam("page", "0").withType(var20).build().execute();
      var20 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink("country_codes").withParam("page", "0").withTaskListener(this.countryTaskListener).withType(var20).build().execute();
   }
}
