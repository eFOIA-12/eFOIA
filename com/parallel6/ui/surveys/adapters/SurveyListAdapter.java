package com.parallel6.ui.surveys.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.surveys.Survey;
import java.util.List;

public class SurveyListAdapter extends BaseAdapter {
   private Context mContext;
   private List mSurveyList;

   public SurveyListAdapter(Context var1, List var2) {
      this.mContext = var1;
      this.mSurveyList = var2;
   }

   private SurveyListAdapter.ViewHolder initViewHolder(View var1) {
      SurveyListAdapter.ViewHolder var2 = new SurveyListAdapter.ViewHolder();
      var2.title = (TextView)var1.findViewById(R.id.row_survey_list_title);
      var2.answered = (TextView)var1.findViewById(R.id.row_survey_list_tv_answered);
      return var2;
   }

   public int getCount() {
      return this.mSurveyList.size();
   }

   public Survey getItem(int var1) {
      return (Survey)this.mSurveyList.get(var1);
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      SurveyListAdapter.ViewHolder var5;
      if(var2 == null) {
         var2 = View.inflate(this.mContext, R.layout.row_survey_list, (ViewGroup)null);
         var5 = this.initViewHolder(var2);
         var2.setTag(var5);
      } else {
         var5 = (SurveyListAdapter.ViewHolder)var2.getTag();
      }

      Survey var4 = this.getItem(var1);
      var5.title.setText(var4.getTitle());
      TextView var6 = var5.answered;
      String var7;
      if(!this.isEnabled(var1)) {
         var7 = "Answered";
      } else {
         var7 = "";
      }

      var6.setText(var7);
      return var2;
   }

   public boolean isEnabled(int var1) {
      return this.getItem(var1).getAnswered() == 0;
   }

   public static class ViewHolder {
      private TextView answered;
      private TextView title;
   }
}
