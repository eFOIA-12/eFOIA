package gov.dhs.mobile.efoia.arrayadapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import gov.dhs.mobile.efoia.models.PrivacyAct;
import java.util.List;

public class PrivacyActArrayAdapter extends ArrayAdapter {
   private Typeface bold;
   private Context context;
   private List data;
   private Typeface light;
   List mIdMap;

   public PrivacyActArrayAdapter(Context var1, int var2, List var3) {
      super(var1, var2, var3);
      this.light = Typeface.createFromAsset(var1.getAssets(), "nexa_light.otf");
      this.bold = Typeface.createFromAsset(var1.getAssets(), "nexa_bold.otf");
      this.context = var1;
      this.mIdMap = var3;
   }

   public int getCount() {
      return this.mIdMap.size();
   }

   public PrivacyAct getItem(int var1) {
      return (PrivacyAct)this.mIdMap.get(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      PrivacyActArrayAdapter.ViewHolder var5;
      if(var2 == null) {
         var2 = LayoutInflater.from(this.getContext()).inflate(2130968661, var3, false);
         var5 = new PrivacyActArrayAdapter.ViewHolder();
         var5.position = var1;
         var2.setTag(var5);
      } else {
         var5 = (PrivacyActArrayAdapter.ViewHolder)var2.getTag();
      }

      PrivacyAct var4 = (PrivacyAct)this.mIdMap.get(var1);
      var5.actHeader = (TextView)var2.findViewById(2131689834);
      var5.actHeader.setTypeface(this.bold);
      if(!var4.getTitle().contains("preamble")) {
         var5.actHeader.setText(var4.getTitle());
      } else {
         var5.actHeader.setText("");
      }

      var5.actText = (TextView)var2.findViewById(2131689835);
      var5.actText.setTypeface(this.light);
      var5.actText.setText(var4.getRequest_step());
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
