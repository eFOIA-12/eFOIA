package com.parallel6.ui.enums;

public enum Action {
   ABOUT_US(0),
   ALERTS(0),
   AR(11),
   ARTS(6),
   BRANDS(7),
   CALENDAR(29),
   COST_CALCULATOR(21),
   DEALER_LOCATOR(16),
   DEALS(15),
   DYNAMIC_CONTENTS(27),
   DYNAMIC_CONTENT_DETAIL(0),
   EVENTS(3),
   FAVORITES(28),
   FITTING_TOOL(18),
   GALLERIES(4),
   GOLF_TIPS(17),
   HOME(25),
   INFORMATION(13),
   MAP(0),
   NEWS(5),
   NO_ACTION(0),
   OFFERS(10),
   OUTAGE_MAP(20),
   PAYMENT_LOCATOR(22),
   PLACES(2),
   PROFILE(26),
   PROXIMITY_ALERTS(0),
   REPORT_AN_OUTAGE(23),
   REWARDS(8),
   SCAVENGER(9),
   SETTINGS(14),
   SHAFT_STANDARDS(19),
   SHARE(12),
   SUBCATEGORY(24),
   SURVEYS(0),
   TAGGED_CONTENTS(0),
   URL(1);

   int id;

   private Action(int var3) {
      this.id = var3;
   }
}
