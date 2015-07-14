package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.pf;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable {
   String getId();

   ItemScope getResult();

   String getStartDate();

   ItemScope getTarget();

   String getType();

   boolean hasId();

   boolean hasResult();

   boolean hasStartDate();

   boolean hasTarget();

   boolean hasType();

   public static class Builder {
      private String CE;
      private final Set aon = new HashSet();
      private String apa;
      private pd api;
      private pd apj;
      private String vc;

      public Moment build() {
         return new pf(this.aon, this.CE, this.api, this.apa, this.apj, this.vc);
      }

      public Moment.Builder setId(String var1) {
         this.CE = var1;
         this.aon.add(Integer.valueOf(2));
         return this;
      }

      public Moment.Builder setResult(ItemScope var1) {
         this.api = (pd)var1;
         this.aon.add(Integer.valueOf(4));
         return this;
      }

      public Moment.Builder setStartDate(String var1) {
         this.apa = var1;
         this.aon.add(Integer.valueOf(5));
         return this;
      }

      public Moment.Builder setTarget(ItemScope var1) {
         this.apj = (pd)var1;
         this.aon.add(Integer.valueOf(6));
         return this;
      }

      public Moment.Builder setType(String var1) {
         this.vc = var1;
         this.aon.add(Integer.valueOf(7));
         return this;
      }
   }
}
