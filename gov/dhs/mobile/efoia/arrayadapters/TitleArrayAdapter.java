package gov.dhs.mobile.efoia.arrayadapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import gov.dhs.mobile.efoia.models.Title;
import java.util.List;

public class TitleArrayAdapter extends ArrayAdapter {
   private Context context;
   LayoutInflater inflater;
   List mIdMap;

   public TitleArrayAdapter(Context var1, int var2, List var3) {
      super(var1, var2, var3);
      this.context = var1;
      this.mIdMap = var3;
      this.inflater = (LayoutInflater)var1.getSystemService("layout_inflater");
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      var2 = this.inflater.inflate(2130968674, var3, false);
      TextView var5 = (TextView)var2.findViewById(2131689856);
      var5.setTextSize(14.0F);
      Typeface var4 = Typeface.createFromAsset(this.context.getAssets(), "nexa_bold.otf");
      var5.setTextColor(this.context.getResources().getColor(2131623953));
      var5.setTypeface(var4);
      var5.setText(((Title)this.mIdMap.get(var1)).getTitle());
      return var2;
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      var2 = this.inflater.inflate(2130968674, var3, false);
      TextView var4 = (TextView)var2.findViewById(2131689856);
      var4.setTextSize(14.0F);
      var4.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "nexa_light.otf"));
      var4.setText(((Title)this.mIdMap.get(var1)).getTitle());
      return var2;
   }

   public boolean hasStableIds() {
      return true;
   }
}
