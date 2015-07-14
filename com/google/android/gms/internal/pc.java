package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jr;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class pc implements People {
   public Person getCurrentPerson(GoogleApiClient var1) {
      return Plus.a(var1, Plus.DQ).getCurrentPerson();
   }

   public PendingResult load(final GoogleApiClient var1, final Collection var2) {
      return var1.a((BaseImplementation.a)(new pc.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.a((BaseImplementation.b)this, (Collection)var2);
         }
      }));
   }

   public PendingResult load(final GoogleApiClient var1, final String... var2) {
      return var1.a((BaseImplementation.a)(new pc.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.d(this, var2);
         }
      }));
   }

   public PendingResult loadConnected(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new pc.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.k(this);
         }
      }));
   }

   public PendingResult loadVisible(final GoogleApiClient var1, final int var2, final String var3) {
      return var1.a((BaseImplementation.a)(new pc.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            this.a((jr)var1.a(this, var2, var3));
         }
      }));
   }

   public PendingResult loadVisible(final GoogleApiClient var1, final String var2) {
      return var1.a((BaseImplementation.a)(new pc.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            this.a((jr)var1.q(this, var2));
         }
      }));
   }

   private abstract static class a extends Plus.a {
      private a(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      a(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public People.LoadPeopleResult aC(final Status var1) {
         return new People.LoadPeopleResult() {
            public String getNextPageToken() {
               return null;
            }

            public PersonBuffer getPersonBuffer() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.aC(var1);
      }
   }
}
