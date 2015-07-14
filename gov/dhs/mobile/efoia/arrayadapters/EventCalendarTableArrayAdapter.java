package gov.dhs.mobile.efoia.arrayadapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import gov.dhs.mobile.efoia.models.EventCalendarItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

public class EventCalendarTableArrayAdapter extends ArrayAdapter {
   private Typeface bold;
   private Context context;
   private Typeface light;
   private Context mContext;
   HashMap mIdMap = new HashMap();

   public EventCalendarTableArrayAdapter(Context var1, int var2, List var3) {
      super(var1, var2, var3);
      this.light = Typeface.createFromAsset(var1.getAssets(), "nexa_light.otf");
      this.bold = Typeface.createFromAsset(var1.getAssets(), "nexa_bold.otf");
      this.context = var1;

      for(var2 = 0; var2 < var3.size(); ++var2) {
         this.mIdMap.put(var3.get(var2), Integer.valueOf(var2));
      }

   }

   public long getItemId(int var1) {
      EventCalendarItem var2 = (EventCalendarItem)this.getItem(var1);
      return (long)((Integer)this.mIdMap.get(var2)).intValue();
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      EventCalendarItem var5 = (EventCalendarItem)this.getItem(var1);
      View var4 = var2;
      if(var2 == null) {
         var4 = LayoutInflater.from(this.getContext()).inflate(2130968638, var3, false);
      }

      TextView var9 = (TextView)var4.findViewById(2131689766);
      TextView var8 = (TextView)var4.findViewById(2131689767);
      var4.setContentDescription("View " + var5.getTitle());
      var9.setTypeface(this.bold);
      var8.setTypeface(this.bold);
      var9.setText(var5.getTitle());
      SimpleDateFormat var10 = new SimpleDateFormat("MM/dd/yy HH:mm:ss a");
      SimpleDateFormat var6 = new SimpleDateFormat("MMMM dd, yyyy");

      try {
         var8.setText(var6.format(var10.parse(var5.getEvent_date())));
         return var4;
      } catch (ParseException var7) {
         var7.printStackTrace();
         return var4;
      }
   }

   public boolean hasStableIds() {
      return true;
   }
}
