package gov.dhs.mobile.efoia.arrayadapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import gov.dhs.mobile.efoia.models.FeeStructure;
import java.util.List;

public class FeeStructureArrayAdapter extends ArrayAdapter {
   private Typeface bold;
   private Context context;
   private List data;
   private Typeface light;
   List mIdMap;

   public FeeStructureArrayAdapter(Context var1, int var2, List var3) {
      super(var1, var2, var3);
      this.light = Typeface.createFromAsset(var1.getAssets(), "nexa_light.otf");
      this.bold = Typeface.createFromAsset(var1.getAssets(), "nexa_bold.otf");
      this.context = var1;
      this.mIdMap = var3;
   }

   public int getCount() {
      return this.mIdMap.size();
   }

   public FeeStructure getItem(int var1) {
      return (FeeStructure)this.mIdMap.get(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      FeeStructureArrayAdapter.ViewHolder var5;
      if(var2 == null) {
         var2 = LayoutInflater.from(this.getContext()).inflate(2130968661, var3, false);
         var5 = new FeeStructureArrayAdapter.ViewHolder();
         var5.position = var1;
         var2.setTag(var5);
      } else {
         var5 = (FeeStructureArrayAdapter.ViewHolder)var2.getTag();
      }

      FeeStructure var4 = (FeeStructure)this.mIdMap.get(var1);
      var5.actHeader = (TextView)var2.findViewById(2131689834);
      var5.actHeader.setTypeface(this.bold);
      var5.actHeader.setText(var4.getTitle());
      var5.actText = (TextView)var2.findViewById(2131689835);
      var5.actText.setTypeface(this.light);
      var5.actText.setText(var4.getFee_note());
      return var2;
   }

   public boolean hasStableIds() {
      return true;
   }

   static class ViewHolder {
      TextView actHeader;
      TextView actText;
      int position;
   }
}
