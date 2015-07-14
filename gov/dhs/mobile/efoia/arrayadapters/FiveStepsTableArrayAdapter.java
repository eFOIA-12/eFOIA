package gov.dhs.mobile.efoia.arrayadapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import gov.dhs.mobile.efoia.models.FiveStepsItem;
import java.util.List;

public class FiveStepsTableArrayAdapter extends ArrayAdapter {
   private Typeface bold;
   private Context context;
   private List data;
   int layoutResourceId;
   private Typeface light;
   List mIdMap;

   public FiveStepsTableArrayAdapter(Context var1, int var2, List var3) {
      super(var1, var2, var3);
      this.light = Typeface.createFromAsset(var1.getAssets(), "nexa_light.otf");
      this.bold = Typeface.createFromAsset(var1.getAssets(), "nexa_bold.otf");
      this.context = var1;
      this.mIdMap = var3;
   }

   public int getCount() {
      return this.mIdMap.size();
   }

   public FiveStepsItem getItem(int var1) {
      return (FiveStepsItem)this.mIdMap.get(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      FiveStepsTableArrayAdapter.ViewHolder var5;
      if(var2 == null) {
         var2 = LayoutInflater.from(this.getContext()).inflate(2130968639, var3, false);
         var5 = new FiveStepsTableArrayAdapter.ViewHolder();
         var5.position = var1;
         var2.setTag(var5);
      } else {
         var5 = (FiveStepsTableArrayAdapter.ViewHolder)var2.getTag();
      }

      FiveStepsItem var4 = (FiveStepsItem)this.mIdMap.get(var1);
      var5.stepNumber = (TextView)var2.findViewById(2131689771);
      var5.stepText = (TextView)var2.findViewById(2131689772);
      var5.stepNumber.setTypeface(this.bold);
      var5.stepText.setTypeface(this.light);
      var5.stepNumber.setText("" + (var1 + 1));
      var5.stepText.setText(var4.getFoia_step_text());
      return var2;
   }

   public boolean hasStableIds() {
      return true;
   }

   static class ViewHolder {
      int position;
      TextView stepNumber;
      TextView stepText;
   }
}
