package gov.dhs.mobile.efoia.viewcontrollers.statutes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.models.Statutes;
import gov.dhs.mobile.efoia.webview.FOIAWebView;
import java.lang.reflect.Type;

public class FOIAStatutes extends Activity {
   private Button button;
   private TaskListener cmsTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            Statutes var4 = (Statutes)var1.getContent().get(0);
            FOIAStatutes.this.url = var4.getStatutes_url();
            FOIAStatutes.this.desc.setText(var4.getDescription());
            FOIAStatutes.this.sTitle.setText(var4.getTitle());
            String var5 = var4.getImage().getImageForDensity(CRImage.IMAGE_TYPE.SMALL, (Activity)FOIAStatutes.this.mContext);
            AQuery var2 = new AQuery(FOIAStatutes.this.mContext);
            Bitmap var3 = var2.getCachedImage(var5);
            if(var3 == null) {
               ((AQuery)var2.id(FOIAStatutes.this.imageView)).image(var5, true, true, 0, 0);
               return;
            }

            ((AQuery)var2.id(FOIAStatutes.this.imageView)).image(var5, true, true, 0, 0, var3, -1);
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private TextView desc;
   private ImageView imageView;
   private Context mContext;
   private TextView sTitle;
   private String url;

   public void goBack(View var1) {
      this.finish();
   }

   public void onClick(View var1) {
      Intent var3 = new Intent(this, FOIAWebView.class);
      Bundle var2 = new Bundle();
      var2.putString("key_url", this.url);
      var2.putString("extras_title", "FOIA Statutes");
      var3.putExtras(var2);
      this.startActivity(var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968610);
      this.mContext = this;
      String var4 = this.getIntent().getExtras().getString("action_object");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      Typeface var3 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      this.desc = (TextView)this.findViewById(2131689622);
      this.sTitle = (TextView)this.findViewById(2131689623);
      this.button = (Button)this.findViewById(2131689625);
      this.imageView = (ImageView)this.findViewById(2131689624);
      this.desc.setTypeface(var2);
      this.button.setTypeface(var3);
      this.sTitle.setTypeface(var3);
      Type var5 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink(var4).withTaskListener(this.cmsTaskListener).withType(var5).build().execute();
   }
}
