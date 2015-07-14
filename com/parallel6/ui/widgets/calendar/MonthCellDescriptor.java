package com.parallel6.ui.widgets.calendar;

import java.util.Date;

class MonthCellDescriptor {
   private final Date date;
   private final boolean isCurrentMonth;
   private boolean isHighlighted;
   private final boolean isSelectable;
   private boolean isSelected;
   private final boolean isToday;
   private MonthCellDescriptor.RangeState rangeState;
   private final int value;

   MonthCellDescriptor(Date var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, int var7, MonthCellDescriptor.RangeState var8) {
      this.date = var1;
      this.isCurrentMonth = var2;
      this.isSelectable = var3;
      this.isHighlighted = var6;
      this.isSelected = var4;
      this.isToday = var5;
      this.value = var7;
      this.rangeState = var8;
   }

   public Date getDate() {
      return this.date;
   }

   public MonthCellDescriptor.RangeState getRangeState() {
      return this.rangeState;
   }

   public int getValue() {
      return this.value;
   }

   public boolean isCurrentMonth() {
      return this.isCurrentMonth;
   }

   boolean isHighlighted() {
      return this.isHighlighted;
   }

   public boolean isSelectable() {
      return this.isSelectable;
   }

   public boolean isSelected() {
      return this.isSelected;
   }

   public boolean isToday() {
      return this.isToday;
   }

   void setHighlighted(boolean var1) {
      this.isHighlighted = var1;
   }

   public void setRangeState(MonthCellDescriptor.RangeState var1) {
      this.rangeState = var1;
   }

   public void setSelected(boolean var1) {
      this.isSelected = var1;
   }

   public String toString() {
      return "MonthCellDescriptor{date=" + this.date + ", value=" + this.value + ", isCurrentMonth=" + this.isCurrentMonth + ", isSelected=" + this.isSelected + ", isToday=" + this.isToday + ", isSelectable=" + this.isSelectable + ", isHighlighted=" + this.isHighlighted + ", rangeState=" + this.rangeState + '}';
   }

   public static enum RangeState {
      FIRST,
      LAST,
      MIDDLE,
      NONE;
   }
}
