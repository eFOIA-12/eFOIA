package gov.dhs.mobile.efoia.viewcontrollers.status;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import gov.dhs.mobile.efoia.datastructures.CheckStatus;
import gov.dhs.mobile.efoia.tasks.CheckStatusTask;
import gov.dhs.mobile.efoia.tasks.GetFormIDTask;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class FOIAStatus extends Activity {
   private TextView closedDate;
   private TextView delDate;
   private String formID;
   private TextView recv;
   private TextView reqNumber;
   private EditText reqNumberEdit;
   private TextView status;

   public void goBack(View var1) {
      this.finish();
   }

   public void onClick(View var1) {
      CaptiveReachConnect.getInstance().trackInsightV2(this, "Check Status", "Executed Check", "", "");
      if(this.reqNumberEdit.getText().toString().length() > 1) {
         CheckStatus var4 = new CheckStatus();
         var4.setDrupalFormID("formID");
         var4.setFoia_request_number(this.reqNumberEdit.getText().toString());
         CheckStatusTask var2 = new CheckStatusTask();

         try {
            HashMap var5 = (HashMap)var2.execute(new CheckStatus[]{var4}).get();
            this.closedDate.setText((CharSequence)var5.get("Closed Date"));
            this.recv.setText((CharSequence)var5.get("Received Date"));
            this.delDate.setText((CharSequence)var5.get("Estimated Delivery Date"));
            this.status.setText((CharSequence)var5.get("Request Status"));
            this.reqNumber.setText(this.reqNumberEdit.getText().toString());
         } catch (Exception var3) {
            Toast.makeText(this, "An Error has Occurred Please Try Again Later", 0);
         }
      } else {
         Toast.makeText(this, "Please Enter a FOIA Request Number", 0);
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968609);
      TextView var14 = (TextView)this.findViewById(2131689606);
      TextView var2 = (TextView)this.findViewById(2131689608);
      TextView var3 = (TextView)this.findViewById(2131689609);
      TextView var4 = (TextView)this.findViewById(2131689618);
      TextView var5 = (TextView)this.findViewById(2131689620);
      TextView var6 = (TextView)this.findViewById(2131689616);
      TextView var7 = (TextView)this.findViewById(2131689614);
      Button var8 = (Button)this.findViewById(2131689611);
      TextView var16 = (TextView)this.findViewById(2131689612);
      this.reqNumberEdit = (EditText)this.findViewById(2131689610);
      this.reqNumber = (TextView)this.findViewById(2131689613);
      this.recv = (TextView)this.findViewById(2131689615);
      this.status = (TextView)this.findViewById(2131689617);
      this.delDate = (TextView)this.findViewById(2131689619);
      this.closedDate = (TextView)this.findViewById(2131689621);
      Typeface var9 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      Typeface var10 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      var14.setTypeface(var9);
      var2.setTypeface(var9);
      var3.setTypeface(var9);
      this.reqNumberEdit.setTypeface(var10);
      var16.setTypeface(var9);
      this.reqNumber.setTypeface(var9);
      var7.setTypeface(var9);
      this.recv.setTypeface(var9);
      var6.setTypeface(var9);
      this.status.setTypeface(var9);
      var4.setTypeface(var9);
      this.delDate.setTypeface(var9);
      var5.setTypeface(var9);
      this.closedDate.setTypeface(var9);
      GetFormIDTask var15 = new GetFormIDTask();

      try {
         this.formID = (String)var15.execute(new Void[0]).get();
      } catch (InterruptedException var11) {
         ;
      } catch (ConcurrentModificationException var12) {
         ;
      } catch (ExecutionException var13) {
         ;
      }
   }
}
