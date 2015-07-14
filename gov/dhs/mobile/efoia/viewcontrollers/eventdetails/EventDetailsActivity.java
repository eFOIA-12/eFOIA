package gov.dhs.mobile.efoia.viewcontrollers.eventdetails;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDetailsActivity extends Activity {
   public void goBack(View var1) {
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968603);
      Bundle var2 = this.getIntent().getExtras();
      String var13 = var2.getString("dateTime");
      String var4 = var2.getString("location");
      String var5 = var2.getString("desc");
      String var6 = var2.getString("title");
      Typeface var7 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      Typeface var8 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      TextView var9 = (TextView)this.findViewById(2131689577);
      TextView var15 = (TextView)this.findViewById(2131689579);
      TextView var10 = (TextView)this.findViewById(2131689581);
      TextView var3 = (TextView)this.findViewById(2131689582);
      TextView var11 = (TextView)this.findViewById(2131689580);
      var10.setMovementMethod(new LinkMovementMethod());
      var9.setTypeface(var8);
      var15.setTypeface(var8);
      var10.setTypeface(var7);
      var3.setTypeface(var7);
      var11.setTypeface(var8);
      var9.setText(var6);
      var10.setText(Html.fromHtml(var5));
      var11.setText(var4);
      SimpleDateFormat var18 = new SimpleDateFormat("MM/dd/yy HH:mm:ss a");
      SimpleDateFormat var16 = new SimpleDateFormat("MMMM dd, yyyy");
      SimpleDateFormat var17 = new SimpleDateFormat("hh:mm a");

      try {
         Date var14 = var18.parse(var13);
         var3.setText(var17.format(var14));
         var15.setText(var16.format(var14) + " | ");
      } catch (ParseException var12) {
         var12.printStackTrace();
      }
   }
}
