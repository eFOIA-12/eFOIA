package com.parallel6.captivereachconnectsdk.enums;

public enum RestfulAction {
   FAVORITES("favorites"),
   FILTER("filter"),
   NONE(""),
   RANDOM("random"),
   SHOW("{id}/show"),
   UPDATE("{ID}");

   String action;

   private RestfulAction(String var3) {
      this.action = var3;
   }

   public String getValue() {
      return this.action;
   }
}
