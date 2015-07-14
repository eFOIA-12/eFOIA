package gov.dhs.mobile.efoia.viewcontrollers.library;

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
import gov.dhs.mobile.efoia.models.Library;
import gov.dhs.mobile.efoia.webview.FOIAWebView;
import java.lang.reflect.Type;

public class FOIALibrary extends Activity {
   private Button button;
   private TaskListener cmsTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1 != null && var1.getContent() != null && var1.getContent().size() > 0) {
            Library var4 = (Library)var1.getContent().get(0);
            FOIALibrary.this.url = var4.getLibrary_url();
            FOIALibrary.this.desc.setText(var4.getDescription());
            FOIALibrary.this.lTitle.setText(var4.getTitle());
            String var5 = var4.getImage().getImageForDensity(CRImage.IMAGE_TYPE.SMALL, (Activity)FOIALibrary.this.mContext);
            AQuery var2 = new AQuery(FOIALibrary.this.mContext);
            Bitmap var3 = var2.getCachedImage(var5);
            if(var3 == null) {
               ((AQuery)var2.id(FOIALibrary.this.imageView)).image(var5, true, true, 0, 0);
               return;
            }

            ((AQuery)var2.id(FOIALibrary.this.imageView)).image(var5, true, true, 0, 0, var3, -1);
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private TextView desc;
   private ImageView imageView;
   private TextView lTitle;
   private Context mContext;
   private String url;

   public void goBack(View var1) {
      this.finish();
   }

   public void onClick(View var1) {
      Intent var3 = new Intent(this, FOIAWebView.class);
      Bundle var2 = new Bundle();
      var2.putString("key_url", this.url);
      var2.putString("extras_title", "FOIA Library");
      var3.putExtras(var2);
      this.startActivity(var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968608);
      this.mContext = this;
      String var4 = this.getIntent().getExtras().getString("action_object");
      Typeface var2 = Typeface.createFromAsset(this.getAssets(), "nexa_light.otf");
      Typeface var3 = Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf");
      this.desc = (TextView)this.findViewById(2131689601);
      this.lTitle = (TextView)this.findViewById(2131689602);
      this.button = (Button)this.findViewById(2131689604);
      this.imageView = (ImageView)this.findViewById(2131689603);
      this.desc.setTypeface(var2);
      this.button.setTypeface(var3);
      this.lTitle.setTypeface(var3);
      Type var5 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this).withMethod("GET").withPermanentLink(var4).withTaskListener(this.cmsTaskListener).withType(var5).build().execute();
   }
}
