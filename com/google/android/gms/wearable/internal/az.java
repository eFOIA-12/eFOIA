package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.internal.a;
import com.google.android.gms.wearable.internal.ab;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.ap;
import com.google.android.gms.wearable.internal.at;
import com.google.android.gms.wearable.internal.av;
import com.google.android.gms.wearable.internal.f;
import com.google.android.gms.wearable.internal.p;
import com.google.android.gms.wearable.internal.v;
import com.google.android.gms.wearable.internal.x;
import com.google.android.gms.wearable.internal.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class az {
   abstract static class a extends a {
      private BaseImplementation.b DA;

      public a(BaseImplementation.b var1) {
         this.DA = var1;
      }

      public void A(Object var1) {
         BaseImplementation.b var2 = this.DA;
         if(var2 != null) {
            var2.b(var1);
            this.DA = null;
         }

      }
   }

   static final class b extends az.a {
      public b(BaseImplementation.b var1) {
         super(var1);
      }

      public void a(p var1) {
         this.A(new f.c(av.gN(var1.statusCode), var1.axI));
      }
   }

   static final class c extends az.a {
      public c(BaseImplementation.b var1) {
         super(var1);
      }

      public void a(v var1) {
         ArrayList var2 = new ArrayList();
         var2.addAll(var1.axL);
         this.A(new ak.b(av.gN(var1.statusCode), var2));
      }
   }

   static final class d extends az.a {
      public d(BaseImplementation.b var1) {
         super(var1);
      }

      public void a(x var1) {
         this.A(new f.b(av.gN(var1.statusCode), var1.axM));
      }
   }

   static final class e extends az.a {
      public e(BaseImplementation.b var1) {
         super(var1);
      }

      public void ab(DataHolder var1) {
         this.A(new DataItemBuffer(var1));
      }
   }

   static final class f extends az.a {
      public f(BaseImplementation.b var1) {
         super(var1);
      }

      public void a(z var1) {
         this.A(new f.d(av.gN(var1.statusCode), var1.axN));
      }
   }

   static final class g extends az.a {
      public g(BaseImplementation.b var1) {
         super(var1);
      }

      public void a(ab var1) {
         this.A(new ak.c(av.gN(var1.statusCode), var1.axO));
      }
   }

   static final class h extends a {
      public void a(Status var1) {
      }
   }

   static final class i extends az.a {
      private final List ayf;

      i(BaseImplementation.b var1, List var2) {
         super(var1);
         this.ayf = var2;
      }

      public void a(ap var1) {
         this.A(new f.b(av.gN(var1.statusCode), var1.axM));
         if(var1.statusCode != 0) {
            Iterator var2 = this.ayf.iterator();

            while(var2.hasNext()) {
               ((FutureTask)var2.next()).cancel(true);
            }
         }

      }
   }

   static final class j extends az.a {
      public j(BaseImplementation.b var1) {
         super(var1);
      }

      public void a(at var1) {
         this.A(new ah.b(av.gN(var1.statusCode), var1.ayd));
      }
   }
}
