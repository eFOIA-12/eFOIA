package com.parallel6.captivereachconnectsdk.models.filters;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CRKeywordFilter extends CRFilter {
   @SerializedName("whole_word")
   private boolean wholeWord;

   public CRKeywordFilter(String var1) {
      super(var1);
   }

   public CRKeywordFilter(String var1, String var2, String var3) {
      ArrayList var4 = new ArrayList();
      var4.addAll(Arrays.asList(var2.split(" ")));
      super.setAttributeName(var1);
      super.setFilterValues(var4);
      super.setSearch_method(var3);
   }

   public CRKeywordFilter(String var1, List var2) {
      super(var1, var2);
   }

   public CRKeywordFilter(String var1, List var2, String var3) {
      super(var1, var2, var3);
   }

   public CRKeywordFilter(String var1, List var2, boolean var3) {
      super(var1, var2);
      this.wholeWord = var3;
   }

   public boolean isWholeWord() {
      return this.wholeWord;
   }

   public void setWholeWord(boolean var1) {
      this.wholeWord = var1;
   }
}
