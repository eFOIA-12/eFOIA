package gov.dhs.mobile.efoia.arrayadapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import java.util.HashMap;
import java.util.List;

public class HowToViewTableArrayAdapter extends ArrayAdapter {
   private Context context;
   HashMap mIdMap = new HashMap();

   public HowToViewTableArrayAdapter(Context var1, int var2, List var3) {
      super(var1, var2, var3);
      this.context = var1;

      for(var2 = 0; var2 < var3.size(); ++var2) {
         this.mIdMap.put(var3.get(var2), Integer.valueOf(var2));
      }

   }

   public long getItemId(int var1) {
      MobileMenu var2 = (MobileMenu)this.getItem(var1);
      return (long)((Integer)this.mIdMap.get(var2)).intValue();
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      MobileMenu var5 = (MobileMenu)this.getItem(var1);
      View var4 = var2;
      if(var2 == null) {
         var4 = LayoutInflater.from(this.getContext()).inflate(2130968657, var3, false);
      }

      ImageView var7 = (ImageView)var4.findViewById(2131689829);
      TextView var8 = (TextView)var4.findViewById(2131689626);
      var8.setContentDescription("View " + var5.getTitle());
      var8.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "nexa_light.otf"));
      var8.setText(var5.getTitle());
      String var9 = var5.getImage().getCRImage().getImageForDensity(CRImage.IMAGE_TYPE.FULLSCREEN, (Activity)this.context);
      AQuery var10 = new AQuery(this.context);
      Bitmap var6 = var10.getCachedImage(var9);
      if(var6 != null) {
         ((AQuery)var10.id(var7)).image(var9, true, true, 0, 0, var6, -1);
         return var4;
      } else {
         ((AQuery)var10.id(var7)).image(var9, true, true, 0, 0);
         return var4;
      }
   }

   public boolean hasStableIds() {
      return true;
   }
}
