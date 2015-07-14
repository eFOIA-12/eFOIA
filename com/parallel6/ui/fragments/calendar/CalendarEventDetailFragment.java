package com.parallel6.ui.fragments.calendar;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.broadcast.CalendarAlarmReceiver;
import com.parallel6.ui.database.my_calendar.CalendarDao;
import com.parallel6.ui.enums.CalendarEventTone;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.fragments.calendar.CRCalendarFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.models.CalendarEvent;
import com.parallel6.ui.utils.DialogUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarEventDetailFragment extends BaseFragment {
   private OnClickListener backListener = new OnClickListener() {
      public void onClick(DialogInterface var1, int var2) {
         CalendarEventDetailFragment.this.controller.handleMessage(-1412628478);
      }
   };
   private android.view.View.OnClickListener clickListener = new android.view.View.OnClickListener() {
      public void onClick(View var1) {
         if(var1 == CalendarEventDetailFragment.this.eventDate) {
            CalendarEventDetailFragment.this.setDate(var1);
         } else {
            if(var1 == CalendarEventDetailFragment.this.eventTime) {
               if(StringUtils.isNotEmpty(CalendarEventDetailFragment.this.eventDate.getText().toString())) {
                  CalendarEventDetailFragment.this.setTime(var1);
                  return;
               }

               CalendarEventDetailFragment.this.makeToast(CalendarEventDetailFragment.this.getString(R.string.set_date_first));
               return;
            }

            if(var1 == CalendarEventDetailFragment.this.eventTone) {
               CalendarEventDetailFragment.this.setTone();
               return;
            }
         }

      }
   };
   private DateFormat dateFormat;
   private Button deleteCancelButton;
   private OnClickListener deleteListener = new OnClickListener() {
      public void onClick(DialogInterface var1, int var2) {
         (new CalendarDao(CalendarEventDetailFragment.this.getActivity())).deleteByID(new String[]{String.valueOf(CalendarEventDetailFragment.this.eventModel.getId())});
         CaptiveReachConnect.getInstance().trackInsightV2(CalendarEventDetailFragment.this.getActivity(), "calendar", "delete", "", "");
         CRCalendarFragment.setIsUpdated(true);
         CalendarEventDetailFragment.this.controller.handleMessage(-1412628478);
      }
   };
   private boolean editMode;
   private TextView eventDate;
   private AutoCompleteTextView eventLocation;
   private CalendarEvent eventModel;
   private EditText eventNotes;
   private Spinner eventReminder;
   private TextView eventTime;
   private TextView eventTone;
   private OnCheckedChangeListener eventToneCheckedListener = new OnCheckedChangeListener() {
      public void onCheckedChanged(RadioGroup var1, int var2) {
         if(CalendarEventDetailFragment.this.editMode) {
            String var3 = (String)((RadioButton)CalendarEventDetailFragment.this.findView(var1, var2)).getTag();
            if(var3.equals("none")) {
               CalendarEventDetailFragment.this.selectedTone = CalendarEventTone.None;
               return;
            }

            if(var3.equals("default")) {
               CalendarEventDetailFragment.this.selectedTone = CalendarEventTone.Default;
               return;
            }

            if(var3.equals("custom")) {
               CalendarEventDetailFragment.this.selectedTone = CalendarEventTone.Custom;
               CalendarEventDetailFragment.this.setTone();
               return;
            }
         }

      }
   };
   private LinearLayout eventToneLayout;
   private RadioGroup eventToneRadioGroup;
   private EditText eventType;
   private String formatedDateString;
   private String formatedTimeString;
   private boolean isNewEvent;
   private Date maxdate;
   private String messageReminder;
   private Date mindate;
   private ProgressBar progressBar;
   private int remindBeforeMillis = -1;
   private OnItemSelectedListener reminderItemListener = new OnItemSelectedListener() {
      public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
         CalendarEventDetailFragment.this.makeRemindBeforeMillis(var3);
         CalendarEventDetailFragment.this.spinnerIndex = var3;
      }

      public void onNothingSelected(AdapterView var1) {
      }
   };
   private Button saveEditButton;
   private long selectedMillis;
   private CalendarEventTone selectedTone;
   private ArrayAdapter spinnerAdatpter;
   private int spinnerIndex = 0;
   private SimpleDateFormat timeFormat;
   private Uri toneUri;

   private CalendarEvent getModelFromFields() {
      CalendarEvent var1 = new CalendarEvent();
      if(this.eventModel != null) {
         var1 = this.eventModel;
      }

      var1.setNotes(this.eventNotes.getText().toString());
      var1.setType(this.eventType.getText().toString());
      var1.setLocation(this.eventLocation.getText().toString());
      var1.setMillis(this.selectedMillis);
      var1.setReminderIndex(this.spinnerIndex);
      var1.setAppointmentDate(this.formatedDateString);
      var1.setTime(this.formatedTimeString);
      var1.setEventTone(this.selectedTone);
      return var1;
   }

   private boolean isAllBlank() {
      return !StringUtils.isNotEmpty(this.eventDate.getText().toString()) && !StringUtils.isNotEmpty(this.eventLocation.getText().toString()) && !StringUtils.isNotEmpty(this.eventTime.getText().toString()) && !StringUtils.isNotEmpty(this.eventNotes.getText().toString()) && !StringUtils.isNotEmpty(this.eventType.getText().toString());
   }

   private boolean isAllFilled() {
      return StringUtils.isNotEmpty(this.eventDate.getText().toString()) && StringUtils.isNotEmpty(this.eventTime.getText().toString());
   }

   private void launchReminder(Context var1, String var2, Uri var3, CalendarEventTone var4, long var5, long var7) {
      Intent var9 = new Intent(this.getActivity(), CalendarAlarmReceiver.class);
      var9.putExtra("ALARM_MESSAGE", var2);
      var9.putExtra("ALARM_TONE", var3);
      var9.putExtra("ALARM_TONE_TYPE", var4);
      var9.setAction("ALARM_ACTION");
      PendingIntent var10 = PendingIntent.getBroadcast(var1, 0, var9, 0);
      ((AlarmManager)((AlarmManager)var1.getSystemService("alarm"))).set(0, var5 - var7, var10);
   }

   private void makeRemindBeforeMillis(int var1) {
      switch(var1) {
      case 0:
         this.remindBeforeMillis = -1;
         break;
      case 1:
         this.remindBeforeMillis = 0;
         this.messageReminder = "now";
         break;
      case 2:
         this.remindBeforeMillis = 300000;
         this.messageReminder = "5 minutes";
         break;
      case 3:
         this.remindBeforeMillis = 900000;
         this.messageReminder = "15 minutes";
         break;
      case 4:
         this.remindBeforeMillis = 1800000;
         this.messageReminder = "30 minutes";
         break;
      case 5:
         this.remindBeforeMillis = 3600000;
         this.messageReminder = "1 hour";
         break;
      case 6:
         this.remindBeforeMillis = 7200000;
         this.messageReminder = "2 hours";
         break;
      case 7:
         this.remindBeforeMillis = 86400000;
         this.messageReminder = "1 day";
         break;
      case 8:
         this.remindBeforeMillis = 604800000;
         this.messageReminder = "1 week";
      }

      if(var1 == 0) {
         this.eventToneLayout.setVisibility(4);
      } else {
         this.eventToneLayout.setVisibility(0);
      }
   }

   private void makeToast(String var1) {
      Toast var2 = Toast.makeText(this.getActivity(), var1, 0);
      var2.setGravity(17, 0, 0);
      var2.show();
   }

   private void saveData(CalendarEvent var1) {
      long var2 = (new CalendarDao(this.getActivity())).insertToEvent(var1, (String)null);
      this.eventModel = (new CalendarDao(this.getActivity())).getByIndex(var2, (String)null);
      if(this.eventModel != null) {
         if(this.isNewEvent) {
            if(this.remindBeforeMillis != -1) {
               this.launchReminder(this.getActivity(), "Your event starts in " + this.messageReminder, this.toneUri, this.selectedTone, this.eventModel.getMillis(), (long)this.remindBeforeMillis);
            }

            CaptiveReachConnect.getInstance().trackInsightV2(this.getActivity(), "calendar", "create", "", "");
         } else {
            CaptiveReachConnect.getInstance().trackInsightV2(this.getActivity(), "calendar", "edit", "", "");
         }

         this.isNewEvent = false;
         CRCalendarFragment.setIsUpdated(true);
         this.controller.handleMessage(-1412628478);
      }
   }

   private void setButtonEditMode(boolean var1) {
      if(var1) {
         this.saveEditButton.setText("Save");
         this.deleteCancelButton.setText("Cancel");
      } else {
         this.saveEditButton.setText("Edit");
         this.deleteCancelButton.setText("Delete");
      }
   }

   private void setDate(final View var1) {
      final Calendar var2 = Calendar.getInstance();
      if(StringUtils.isNotEmpty(this.eventDate.getText().toString())) {
         var2.setTimeInMillis(this.selectedMillis);
      }

      (new DatePickerDialog(this.getActivity(), new OnDateSetListener() {
         public void onDateSet(DatePicker var1x, int var2x, int var3, int var4) {
            Calendar var5 = Calendar.getInstance();
            if(StringUtils.isNotEmpty(CalendarEventDetailFragment.this.eventTime.getText().toString())) {
               var5.setTimeInMillis(CalendarEventDetailFragment.this.selectedMillis);
            }

            var5.set(var2x, var3, var4);
            Calendar var7 = var5;
            if(var5.getTime().before(CalendarEventDetailFragment.this.mindate)) {
               var7 = var2;
               String var6 = CalendarEventDetailFragment.this.getString(R.string.invalid_date, new Object[]{CalendarEventDetailFragment.this.dateFormat.format(CalendarEventDetailFragment.this.mindate), CalendarEventDetailFragment.this.dateFormat.format(CalendarEventDetailFragment.this.maxdate)});
               CalendarEventDetailFragment.this.makeToast(var6);
            }

            CalendarEventDetailFragment.this.selectedMillis = var7.getTimeInMillis();
            ((TextView)var1).setText(CalendarEventDetailFragment.this.dateFormat.format(var7.getTime()));
            CalendarEventDetailFragment.this.formatedDateString = CalendarEventDetailFragment.this.dateFormat.format(var7.getTime());
         }
      }, var2.get(1), var2.get(2), var2.get(5))).show();
   }

   private void setFieldEditMode(boolean var1, TextView var2) {
      var2.setEnabled(var1);
      if(var1) {
         var2.setTextAppearance(this.getActivity(), R.style.CalendarEventEditTextEditMode);
         var2.setHintTextColor(this.getActivity().getResources().getColor(R.color.text_hint_color));
      } else {
         var2.setTextAppearance(this.getActivity(), R.style.CalendarEventEditTextDisplayMode);
         var2.setHintTextColor(this.getActivity().getResources().getColor(17170445));
         var2.setBackgroundColor(this.getActivity().getResources().getColor(17170445));
      }
   }

   private void setFieldsEditMode() {
      this.setButtonEditMode(this.editMode);
      this.setGroupEditMode(this.editMode);
      this.setFieldEditMode(this.editMode, this.eventDate);
      this.setFieldEditMode(this.editMode, this.eventLocation);
      this.setFieldEditMode(this.editMode, this.eventTime);
      this.setFieldEditMode(this.editMode, this.eventNotes);
      this.setFieldEditMode(this.editMode, this.eventType);
      this.eventReminder.setEnabled(this.editMode);
   }

   private void setGroupEditMode(boolean var1) {
      for(int var2 = 0; var2 < this.eventToneRadioGroup.getChildCount(); ++var2) {
         this.eventToneRadioGroup.getChildAt(var2).setEnabled(var1);
      }

   }

   private void setTime(final View var1) {
      Calendar var2 = Calendar.getInstance();
      if(StringUtils.isNotEmpty(this.eventTime.getText().toString())) {
         var2.setTimeInMillis(this.selectedMillis);
      }

      (new TimePickerDialog(this.getActivity(), new OnTimeSetListener() {
         public void onTimeSet(TimePicker var1x, int var2, int var3) {
            Calendar var4 = Calendar.getInstance();
            var4.setTimeInMillis(CalendarEventDetailFragment.this.selectedMillis);
            var4.set(11, var2);
            var4.set(12, var3);
            CalendarEventDetailFragment.this.selectedMillis = var4.getTimeInMillis();
            ((TextView)var1).setText(CalendarEventDetailFragment.this.timeFormat.format(var4.getTime()));
            CalendarEventDetailFragment.this.formatedTimeString = CalendarEventDetailFragment.this.timeFormat.format(var4.getTime());
         }
      }, var2.get(11), var2.get(12), false)).show();
   }

   private void setTone() {
      this.startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), 10086);
   }

   protected View getFragmentActionBarView(Context var1) {
      View var3 = View.inflate(var1, R.layout.actionbar_custom, (ViewGroup)null);
      ((TextView)var3.findViewById(R.id.actionbar_tv_title)).setText("Appointment");
      ImageView var2 = (ImageView)var3.findViewById(R.id.actionbar_left_action);
      var2.setImageResource(R.drawable.ic_back);
      var2.setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1) {
            if(CalendarEventDetailFragment.this.eventLocation != null) {
               CalendarEventDetailFragment.this.eventLocation.dismissDropDown();
            }

            if(CalendarEventDetailFragment.this.editMode) {
               if(CalendarEventDetailFragment.this.isAllBlank() && CalendarEventDetailFragment.this.isNewEvent) {
                  CalendarEventDetailFragment.this.controller.handleMessage(-1412628478);
               } else {
                  DialogUtils.showDialog(CalendarEventDetailFragment.this.getActivity(), CalendarEventDetailFragment.this.getString(R.string.dialog_cancel_confirm), CalendarEventDetailFragment.this.backListener, (OnClickListener)null);
               }
            } else {
               CalendarEventDetailFragment.this.controller.handleMessage(-1412628478);
            }
         }
      });
      return var3;
   }

   protected String getFragmentTitle() {
      return "Appointments";
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var2 == -1) {
         this.toneUri = var3.getData();
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         this.eventModel = (CalendarEvent)this.getArguments().getParcelable("extras_event_detail");
         this.mindate = new Date(this.getArguments().getLong("extras_event_mindate"));
         this.maxdate = new Date(this.getArguments().getLong("extras_event_maxdate"));
         this.selectedMillis = this.getArguments().getLong("extras_event_millis");
      }

      if(this.eventModel == null) {
         this.editMode = true;
         this.isNewEvent = true;
      } else {
         this.spinnerIndex = this.eventModel.getReminderIndex();
      }

      this.spinnerAdatpter = new ArrayAdapter(this.getActivity(), 17367048, this.getResources().getStringArray(R.array.remind_list_values));
      this.spinnerAdatpter.setDropDownViewResource(17367049);
      Locale var2 = Locale.getDefault();
      this.timeFormat = new SimpleDateFormat(this.getString(R.string.hour_minute_format));
      this.dateFormat = DateFormat.getDateInstance(2, var2);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_calendar_event_detail, (ViewGroup)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.eventDate = (TextView)this.findView(var1, R.id.fragment_event_detail_et_date);
      this.eventLocation = (AutoCompleteTextView)this.findView(var1, R.id.fragment_event_detail_et_location);
      this.eventTime = (TextView)this.findView(var1, R.id.fragment_event_detail_et_time);
      this.eventType = (EditText)this.findView(var1, R.id.fragment_event_detail_et_type);
      this.eventNotes = (EditText)this.findView(var1, R.id.fragment_event_detail_et_notes);
      this.eventReminder = (Spinner)this.findView(var1, R.id.fragment_event_detail_spn_remind);
      this.eventTone = (TextView)this.findView(var1, R.id.fragment_event_detail_tv_tone);
      this.progressBar = (ProgressBar)this.findView(var1, R.id.fragment_event_detail_pb);
      this.selectedTone = CalendarEventTone.Default;
      this.eventToneRadioGroup = (RadioGroup)this.findView(var1, R.id.fragment_calendar_event_detail_rgroup_tone);
      this.eventToneRadioGroup.setOnCheckedChangeListener(this.eventToneCheckedListener);
      this.eventToneLayout = (LinearLayout)this.findView(var1, R.id.fragment_calendar_event_detail_lyt_notificationTone);
      this.eventToneLayout.setVisibility(4);
      this.eventTime.setOnClickListener(this.clickListener);
      this.eventDate.setOnClickListener(this.clickListener);
      this.eventTone.setOnClickListener(this.clickListener);
      this.eventReminder.setAdapter(this.spinnerAdatpter);
      this.eventReminder.setSelection(this.spinnerIndex);
      this.eventReminder.setOnItemSelectedListener(this.reminderItemListener);
      this.saveEditButton = (Button)this.findView(var1, R.id.fragment_event_detail_btn_edit);
      this.deleteCancelButton = (Button)this.findView(var1, R.id.fragment_event_detail_btn_delete);
      if(this.eventModel != null) {
         switch(null.$SwitchMap$com$parallel6$ui$enums$CalendarEventTone[this.eventModel.getEventTone().ordinal()]) {
         case 1:
            ((RadioButton)this.findView(this.eventToneRadioGroup, R.id.fragment_calendar_event_detail_rbtn_tone_none)).setChecked(true);
            break;
         case 2:
            ((RadioButton)this.findView(this.eventToneRadioGroup, R.id.fragment_calendar_event_detail_rbtn_tone_default)).setChecked(true);
            break;
         case 3:
            ((RadioButton)this.findView(this.eventToneRadioGroup, R.id.fragment_calendar_event_detail_rbtn_tone_custom)).setChecked(true);
         }

         this.selectedMillis = this.eventModel.getMillis();
         if(StringUtils.isNotEmpty(this.eventModel.getNotes())) {
            this.eventNotes.setText(this.eventModel.getNotes());
         }

         if(StringUtils.isNotEmpty(this.eventModel.getLocation())) {
            this.eventLocation.setText(this.eventModel.getLocation());
         }

         if(StringUtils.isNotEmpty(this.eventModel.getType())) {
            this.eventType.setText(this.eventModel.getType());
         }
      }

      if(this.selectedMillis != 0L) {
         this.eventDate.setText(this.dateFormat.format(Long.valueOf(this.selectedMillis)));
         this.eventTime.setText(this.timeFormat.format(Long.valueOf(this.selectedMillis)));
         this.formatedDateString = this.dateFormat.format(Long.valueOf(this.selectedMillis));
         this.formatedTimeString = this.timeFormat.format(Long.valueOf(this.selectedMillis));
      }

      this.setFieldsEditMode();
      this.saveEditButton.setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1) {
            boolean var3 = true;
            boolean var2 = true;
            CalendarEventDetailFragment.this.controller.hideKeyboard();
            CalendarEventDetailFragment var4;
            if(CalendarEventDetailFragment.this.editMode) {
               if(CalendarEventDetailFragment.this.isAllFilled()) {
                  var4 = CalendarEventDetailFragment.this;
                  if(CalendarEventDetailFragment.this.editMode) {
                     var2 = false;
                  }

                  var4.editMode = var2;
                  CalendarEventDetailFragment.this.setFieldsEditMode();
                  CalendarEventDetailFragment.this.saveData(CalendarEventDetailFragment.this.getModelFromFields());
                  CalendarEventDetailFragment.this.makeToast(CalendarEventDetailFragment.this.getString(R.string.save_data_success));
               } else {
                  CalendarEventDetailFragment.this.makeToast(CalendarEventDetailFragment.this.getString(R.string.fill_data_hint));
               }
            } else {
               var4 = CalendarEventDetailFragment.this;
               if(!CalendarEventDetailFragment.this.editMode) {
                  var2 = var3;
               } else {
                  var2 = false;
               }

               var4.editMode = var2;
               CalendarEventDetailFragment.this.setFieldsEditMode();
            }
         }
      });
      this.deleteCancelButton.setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1) {
            if(CalendarEventDetailFragment.this.eventLocation != null) {
               CalendarEventDetailFragment.this.eventLocation.dismissDropDown();
            }

            if(CalendarEventDetailFragment.this.editMode) {
               if(CalendarEventDetailFragment.this.isAllBlank() && CalendarEventDetailFragment.this.isNewEvent) {
                  CalendarEventDetailFragment.this.controller.handleMessage(-1412628478);
               } else {
                  DialogUtils.showDialog(CalendarEventDetailFragment.this.getActivity(), CalendarEventDetailFragment.this.getString(R.string.dialog_cancel_confirm), CalendarEventDetailFragment.this.backListener, (OnClickListener)null);
               }
            } else {
               DialogUtils.showDialog(CalendarEventDetailFragment.this.getActivity(), CalendarEventDetailFragment.this.getString(R.string.dialog_delete_confirm), CalendarEventDetailFragment.this.deleteListener, (OnClickListener)null);
            }
         }
      });
   }
}
