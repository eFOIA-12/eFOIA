package gov.dhs.mobile.efoia.arrayadapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import gov.dhs.mobile.efoia.models.Component;
import java.util.List;

public class ComponentArrayAdapter extends ArrayAdapter {
   private Context context;
   LayoutInflater inflater;
   List mIdMap;

   public ComponentArrayAdapter(Context var1, int var2, List var3) {
      super(var1, var2, var3);
      this.context = var1;
      this.mIdMap = var3;
      this.inflater = (LayoutInflater)var1.getSystemService("layout_inflater");
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      LayoutInflater var5 = this.inflater;
      var2 = LayoutInflater.from(this.getContext()).inflate(2130968674, var3, false);
      TextView var6 = (TextView)var2.findViewById(2131689856);
      Typeface var4 = Typeface.createFromAsset(this.context.getAssets(), "nexa_bold.otf");
      var6.setTextColor(this.context.getResources().getColor(2131623953));
      var6.setTypeface(var4);
      var6.setText(((Component)this.mIdMap.get(var1)).getTitle());
      return var2;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      var2 = this.inflater.inflate(2130968674, var3, false);
      TextView var4 = (TextView)var2.findViewById(2131689856);
      var4.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "nexa_light.otf"));
      var4.setText(((Component)this.mIdMap.get(var1)).getTitle());
      return var2;
   }
}
