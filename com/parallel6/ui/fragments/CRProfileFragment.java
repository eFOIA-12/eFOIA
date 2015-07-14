package com.parallel6.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.network.login.PutProfileTask;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.utils.ProfileUtils;

public class CRProfileFragment extends BaseFragment {
   private static final int MAX_AGE_RANGE = 120;
   private static final int MIN_AGE_RANGE = 10;
   private EditText mAge;
   private EditText mEmail;
   private EditText mFirstName;
   private RadioGroup mGenderGroup;
   private EditText mLastName;
   private Button mSubmitButton;
   private CRTheme theme;

   private void formListener() {
      this.getFirstName();
      this.getLastName();
      this.getEmail();
      this.getGenderGroup();
      this.getAge();
      this.getSubmitButton();
   }

   private void sendProfile() {
      boolean var2 = false;
      if(!StringUtils.isEmpty(this.mFirstName.getText().toString())) {
         SettingsUtils.setFirstName(this.getActivity(), this.mFirstName.getText().toString());
      }

      if(!StringUtils.isEmpty(this.mLastName.getText().toString())) {
         SettingsUtils.setLastName(this.getActivity(), this.mLastName.getText().toString());
      }

      boolean var1 = var2;
      if(!StringUtils.isEmpty(this.mAge.getText().toString())) {
         int var4 = Integer.parseInt(this.mAge.getText().toString());
         if(var4 >= 10 && var4 <= 120) {
            SettingsUtils.setAge(this.getActivity(), this.mAge.getText().toString());
            var1 = var2;
         } else {
            this.mAge.setError(String.format("Age must be between %d and %d years.", new Object[]{Integer.valueOf(10), Integer.valueOf(120)}));
            var1 = true;
         }
      }

      RadioButton var3 = (RadioButton)this.mGenderGroup.findViewById(this.mGenderGroup.getCheckedRadioButtonId());
      String var5;
      switch(null.$SwitchMap$com$parallel6$ui$fragments$CRProfileFragment$ProfileGender[((CRProfileFragment.ProfileGender)var3.getTag()).ordinal()]) {
      case 1:
         var5 = CRProfileFragment.ProfileGender.Male.toString().toLowerCase();
         break;
      case 2:
         var5 = CRProfileFragment.ProfileGender.Male.toString().toLowerCase();
         break;
      default:
         var5 = "";
      }

      SettingsUtils.setGender(this.getActivity(), var5);
      var2 = var1;
      if(!StringUtils.isEmpty(this.mEmail.getText().toString())) {
         if(ProfileUtils.validEmail(this.mEmail.getText().toString())) {
            SettingsUtils.setEmail(this.getActivity(), this.mEmail.getText().toString());
            var2 = var1;
         } else {
            this.mEmail.setError("Invalid email");
            var2 = true;
         }
      }

      if(!var2) {
         (new PutProfileTask(this.getActivity(), (String)null, (TaskListener)null, ProfileUtils.getProfile(this.getActivity()))).execute(new Void[0]);
         Toast.makeText(this.getActivity(), "Your profile has been saved", 0).show();
         this.controller.handleMessage(-1412628477);
      }

   }

   public EditText getAge() {
      if(this.mAge == null) {
         this.mAge = (EditText)this.findView(this.getView(), R.id.fragment_profile_et_age);
         this.mAge.setText(SettingsUtils.getAge(this.getActivity()));
         this.mAge.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View var1, boolean var2) {
               if(!var2) {
                  SettingsUtils.setAge(CRProfileFragment.this.getActivity(), CRProfileFragment.this.mAge.getText().toString());
               }

            }
         });
      }

      return this.mAge;
   }

   public EditText getEmail() {
      if(this.mEmail == null) {
         this.mEmail = (EditText)this.findView(this.getView(), R.id.fragment_profile_et_email);
         this.mEmail.setText(SettingsUtils.getEmail(this.getActivity()));
         this.mEmail.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View var1, boolean var2) {
            }
         });
      }

      return this.mEmail;
   }

   public EditText getFirstName() {
      if(this.mFirstName == null) {
         this.mFirstName = (EditText)this.findView(this.getView(), R.id.fragment_profile_et_fName);
         this.mFirstName.setText(SettingsUtils.getFirstname(this.getActivity()));
         this.mFirstName.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View var1, boolean var2) {
               if(!var2) {
                  SettingsUtils.setFirstName(CRProfileFragment.this.getActivity(), CRProfileFragment.this.mFirstName.getText().toString());
               }

            }
         });
      }

      return this.mFirstName;
   }

   public RadioGroup getGenderGroup() {
      if(this.mGenderGroup == null) {
         this.mGenderGroup = (RadioGroup)this.findView(this.getView(), R.id.fragment_profile_rgrp_gender);
         this.mGenderGroup.findViewById(R.id.fragment_profile_rbtn_male).setTag(CRProfileFragment.ProfileGender.Male);
         this.mGenderGroup.findViewById(R.id.fragment_profile_rbtn_female).setTag(CRProfileFragment.ProfileGender.Female);
         this.mGenderGroup.findViewById(R.id.fragment_profile_rbtn_unknown).setTag(CRProfileFragment.ProfileGender.Unknown);
         this.mGenderGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup var1, int var2) {
               CRProfileFragment.ProfileGender var3 = (CRProfileFragment.ProfileGender)((RadioButton)CRProfileFragment.this.findView(var1, var2)).getTag();
               if(var3 != CRProfileFragment.ProfileGender.Male && var3 != CRProfileFragment.ProfileGender.Female) {
                  SettingsUtils.setGender(CRProfileFragment.this.getActivity(), (String)null);
               } else {
                  SettingsUtils.setGender(CRProfileFragment.this.getActivity(), var3.toString().toLowerCase());
               }
            }
         });
         if(SettingsUtils.getGender(this.getActivity()).equalsIgnoreCase(CRProfileFragment.ProfileGender.Male.toString().toLowerCase())) {
            SettingsUtils.setGender(this.getActivity(), CRProfileFragment.ProfileGender.Male.toString().toLowerCase());
            this.mGenderGroup.check(R.id.fragment_profile_rbtn_male);
         } else if(SettingsUtils.getGender(this.getActivity()).equalsIgnoreCase(CRProfileFragment.ProfileGender.Female.toString().toLowerCase())) {
            SettingsUtils.setGender(this.getActivity(), CRProfileFragment.ProfileGender.Female.toString().toLowerCase());
            this.mGenderGroup.check(R.id.fragment_profile_rbtn_female);
         } else {
            SettingsUtils.setGender(this.getActivity(), (String)null);
            this.mGenderGroup.check(R.id.fragment_profile_rbtn_unknown);
         }
      }

      return this.mGenderGroup;
   }

   public EditText getLastName() {
      if(this.mLastName == null) {
         this.mLastName = (EditText)this.findView(this.getView(), R.id.fragment_profile_et_lName);
         this.mLastName.setText(SettingsUtils.getLastname(this.getActivity()));
         this.mLastName.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View var1, boolean var2) {
               if(!var2) {
                  SettingsUtils.setLastName(CRProfileFragment.this.getActivity(), CRProfileFragment.this.mLastName.getText().toString());
               }

            }
         });
      }

      return this.mLastName;
   }

   public Button getSubmitButton() {
      if(this.mSubmitButton == null) {
         this.mSubmitButton = (Button)this.findView(this.getView(), R.id.fragment_profile_btn_done);
         this.mSubmitButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               CRProfileFragment.this.sendProfile();
            }
         });
      }

      return this.mSubmitButton;
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.theme = ((CRMainActivity)this.getActivity()).getCRTheme();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_profile, (ViewGroup)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      ((ImageView)var1.findViewById(R.id.fragment_profile_iv_image)).setImageResource(this.theme.getAppDrawables().getAppProfileImageResource());
      var1.findViewById(R.id.fragment_profile_btn_done).setBackgroundResource(R.color.app_primary_color);
      this.formListener();
   }

   public static enum ProfileGender {
      Female,
      Male,
      Unknown;
   }
}
