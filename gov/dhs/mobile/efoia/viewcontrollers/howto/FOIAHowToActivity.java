package gov.dhs.mobile.efoia.viewcontrollers.howto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.captivereachconnectsdk.models.json.response.MobileMenuResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.arrayadapters.HowToViewTableArrayAdapter;
import gov.dhs.mobile.efoia.tasks.GetSubMenusTask;
import gov.dhs.mobile.efoia.viewcontrollers.feestructure.FeeStructureActivity;
import gov.dhs.mobile.efoia.viewcontrollers.fivesteps.FiveStepsActivity;
import gov.dhs.mobile.efoia.viewcontrollers.limits.LimitsActivity;
import gov.dhs.mobile.efoia.viewcontrollers.privacyact.PrivacyActActivity;
import gov.dhs.mobile.efoia.viewcontrollers.processing.ProcessingActivity;
import java.util.List;

public class FOIAHowToActivity extends Activity {
   private ListView activityListView;
   private List menus;
   private TaskListener mobileMenusTaskCallback = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
         Toast.makeText(FOIAHowToActivity.this, "Your token has been saved", 0).show();
      }

      public void onTaskSuccess(MobileMenuResponse var1) {
         if(var1 != null && var1.getMobileMenus() != null && var1.getMobileMenus().size() > 0) {
            FOIAHowToActivity.this.menus = var1.getMobileMenus();
            FOIAHowToActivity.this.activityListView.setAdapter(new HowToViewTableArrayAdapter(FOIAHowToActivity.this, 2130968657, FOIAHowToActivity.this.menus));
         }

      }

      public void onTaskTimeOut() {
      }
   };

   private void launchSubActivity(MobileMenu var1) {
      Bundle var2 = new Bundle();
      var2.putString("action_object", (String)var1.getActionObject());
      CaptiveReachConnect.getInstance().trackInsightV2(this, "How To Menu", var1.getAction(), "", "");
      Intent var3;
      if(((String)var1.getActionObject()).equalsIgnoreCase("five_steps")) {
         var3 = new Intent(this, FiveStepsActivity.class);
      } else if(((String)var1.getActionObject()).equalsIgnoreCase("fee_structure")) {
         var3 = new Intent(this, FeeStructureActivity.class);
      } else if(((String)var1.getActionObject()).equalsIgnoreCase("processing")) {
         var3 = new Intent(this, ProcessingActivity.class);
      } else if(((String)var1.getActionObject()).equalsIgnoreCase("limits_exemptions")) {
         var3 = new Intent(this, LimitsActivity.class);
      } else {
         var3 = new Intent(this, PrivacyActActivity.class);
      }

      if(var3 != null) {
         var3.putExtras(var2);
         this.startActivity(var3);
      }

   }

   public void goBack(View var1) {
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968611);
      CaptiveReachConnect.getInstance();
      int var2 = this.getIntent().getExtras().getInt("menu_id");
      Typeface var5 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      Typeface var3 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      (new GetSubMenusTask(this, this.mobileMenusTaskCallback, var2)).execute(new Void[0]);
      TextView var4 = (TextView)this.findViewById(2131689626);
      ((TextView)this.findViewById(2131689627)).setTypeface(var5);
      var4.setTypeface(var3);
      this.activityListView = (ListView)this.findViewById(2131689629);
      this.activityListView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
            MobileMenu var6 = (MobileMenu)FOIAHowToActivity.this.menus.get(var3);
            FOIAHowToActivity.this.launchSubActivity(var6);
         }
      });
   }
}
