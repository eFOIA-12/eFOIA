package gov.dhs.mobile.efoia.webview;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class FOIAWebView extends Activity {
   private String title;
   private String url;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968627);
      WebView var4 = (WebView)this.findViewById(2131689750);
      TextView var2 = (TextView)this.findViewById(2131689751);
      var2.setTypeface(Typeface.createFromAsset(this.getAssets(), "nexa_bold.otf"));
      Bundle var3 = this.getIntent().getExtras();
      this.url = var3.getString("key_url");
      this.title = var3.getString("extras_title");
      var4.getSettings().setUseWideViewPort(true);
      var4.getSettings().setLoadWithOverviewMode(true);
      var2.setText(this.title);
      var4.loadUrl(this.url);
   }
}
