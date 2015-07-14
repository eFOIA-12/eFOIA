package gov.dhs.mobile.efoia.viewcontrollers.limits;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.arrayadapters.LimitsArrayAdapter;
import java.lang.reflect.Type;
import java.util.List;

public class LimitsActivity extends Activity {
   public static int arrayIndex;
   private ListView activityListView;
   private TaskListener cmsTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            LimitsActivity.this.listItems = var1.getContent();
            LimitsActivity.arrayIndex = 0;
            LimitsActivity.this.activityListView.setAdapter(new LimitsArrayAdapter(LimitsActivity.this, 2130968661, LimitsActivity.this.listItems));
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private List listItems;

   public void goBack(View var1) {
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968612);
      String var4 = this.getIntent().getExtras().getString("action_object");
      Type var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink(var4).withTaskListener(this.cmsTaskListener).withType(var2).build().execute();
      this.activityListView = (ListView)this.findViewById(2131689632);
      Typeface var5 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      TextView var6 = (TextView)this.findViewById(2131689630);
      TextView var3 = (TextView)this.findViewById(2131689631);
      var6.setTypeface(var5);
      var3.setTypeface(var5);
   }
}
