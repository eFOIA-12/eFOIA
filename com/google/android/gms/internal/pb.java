package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class pb implements Moments {
   public PendingResult load(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new pb.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.j(this);
         }
      }));
   }

   public PendingResult load(final GoogleApiClient var1, final int var2, final String var3, final Uri var4, final String var5, final String var6) {
      return var1.a((BaseImplementation.a)(new pb.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.a(this, var2, var3, var4, var5, var6);
         }
      }));
   }

   public PendingResult remove(final GoogleApiClient var1, final String var2) {
      return var1.b(new pb.b(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.removeMoment(var2);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult write(final GoogleApiClient var1, final Moment var2) {
      return var1.b(new pb.c(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.a((BaseImplementation.b)this, (Moment)var2);
         }
      });
   }

   private abstract static class a extends Plus.a {
      private a(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      a(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Moments.LoadMomentsResult aB(final Status var1) {
         return new Moments.LoadMomentsResult() {
            public MomentBuffer getMomentBuffer() {
               return null;
            }

            public String getNextPageToken() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }

            public String getUpdated() {
               return null;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.aB(var1);
      }
   }

   private abstract static class b extends Plus.a {
      private b(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      b(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }

   private abstract static class c extends Plus.a {
      private c(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      c(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }
}
