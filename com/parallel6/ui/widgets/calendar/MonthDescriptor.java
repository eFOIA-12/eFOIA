package com.parallel6.ui.widgets.calendar;

import java.util.Date;

class MonthDescriptor {
   private final Date date;
   private String label;
   private final int month;
   private final int year;

   public MonthDescriptor(int var1, int var2, Date var3, String var4) {
      this.month = var1;
      this.year = var2;
      this.date = var3;
      this.label = var4;
   }

   public Date getDate() {
      return this.date;
   }

   public String getLabel() {
      return this.label;
   }

   public int getMonth() {
      return this.month;
   }

   public int getYear() {
      return this.year;
   }

   void setLabel(String var1) {
      this.label = var1;
   }

   public String toString() {
      return "MonthDescriptor{label=\'" + this.label + '\'' + ", month=" + this.month + ", year=" + this.year + '}';
   }
}
