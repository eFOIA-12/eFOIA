package gov.dhs.mobile.efoia.viewcontrollers.events;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.arrayadapters.EventCalendarTableArrayAdapter;
import gov.dhs.mobile.efoia.models.EventCalendarItem;
import gov.dhs.mobile.efoia.viewcontrollers.eventdetails.EventDetailsActivity;
import java.lang.reflect.Type;
import java.util.List;

public class EventsActivity extends Activity {
   private ListView activityListView;
   private TaskListener cmsTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            EventsActivity.this.eventList = var1.getContent();
            EventsActivity.this.activityListView.setAdapter(new EventCalendarTableArrayAdapter(EventsActivity.this, 2130968638, EventsActivity.this.eventList));
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private List eventList;

   public void goBack(View var1) {
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968604);
      String var6 = this.getIntent().getExtras().getString("action_object");
      TextView var2 = (TextView)this.findViewById(2131689588);
      TextView var3 = (TextView)this.findViewById(2131689587);
      Typeface var4 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      Typeface var5 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      var2.setTypeface(var4);
      var3.setTypeface(var5);
      Type var7 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink(var6).withTaskListener(this.cmsTaskListener).withType(var7).build().execute();
      this.activityListView = (ListView)this.findViewById(2131689586);
      this.activityListView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
            EventCalendarItem var7 = (EventCalendarItem)EventsActivity.this.eventList.get(var3);
            Intent var8 = new Intent(EventsActivity.this, EventDetailsActivity.class);
            Bundle var6 = new Bundle();
            var6.putString("dateTime", var7.getEvent_date());
            var6.putString("location", var7.getLocation());
            var6.putString("desc", var7.getDetails());
            var6.putString("title", var7.getTitle());
            var8.putExtras(var6);
            EventsActivity.this.startActivity(var8);
         }
      });
   }
}
