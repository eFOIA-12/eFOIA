package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qy;
import com.google.android.gms.internal.qz;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class qr {
   protected final Class ayX;
   protected final boolean ayY;
   public final int tag;
   protected final int type;

   private qr(int var1, Class var2, int var3, boolean var4) {
      this.type = var1;
      this.ayX = var2;
      this.tag = var3;
      this.ayY = var4;
   }

   public static qr a(int var0, Class var1, int var2) {
      return new qr(var0, var1, var2, false);
   }

   private Object n(List var1) {
      byte var3 = 0;
      ArrayList var6 = new ArrayList();

      int var2;
      for(var2 = 0; var2 < var1.size(); ++var2) {
         qy var5 = (qy)var1.get(var2);
         if(var5.azi.length != 0) {
            this.a((qy)var5, (List)var6);
         }
      }

      int var4 = var6.size();
      Object var7;
      if(var4 == 0) {
         var7 = null;
      } else {
         Object var8 = this.ayX.cast(Array.newInstance(this.ayX.getComponentType(), var4));
         var2 = var3;

         while(true) {
            var7 = var8;
            if(var2 >= var4) {
               break;
            }

            Array.set(var8, var2, var6.get(var2));
            ++var2;
         }
      }

      return var7;
   }

   private Object o(List var1) {
      if(var1.isEmpty()) {
         return null;
      } else {
         qy var2 = (qy)var1.get(var1.size() - 1);
         return this.ayX.cast(this.x(qo.p(var2.azi)));
      }
   }

   int B(Object var1) {
      return this.ayY?this.C(var1):this.D(var1);
   }

   protected int C(Object var1) {
      int var3 = 0;
      int var5 = Array.getLength(var1);

      int var4;
      for(int var2 = 0; var2 < var5; var3 = var4) {
         var4 = var3;
         if(Array.get(var1, var2) != null) {
            var4 = var3 + this.D(Array.get(var1, var2));
         }

         ++var2;
      }

      return var3;
   }

   protected int D(Object var1) {
      int var2 = qz.hl(this.tag);
      switch(this.type) {
      case 10:
         return qp.b(var2, (qw)var1);
      case 11:
         return qp.c(var2, (qw)var1);
      default:
         throw new IllegalArgumentException("Unknown type " + this.type);
      }
   }

   protected void a(qy var1, List var2) {
      var2.add(this.x(qo.p(var1.azi)));
   }

   void a(Object var1, qp var2) throws IOException {
      if(this.ayY) {
         this.c(var1, var2);
      } else {
         this.b(var1, var2);
      }
   }

   protected void b(Object param1, qp param2) {
      // $FF: Couldn't be decompiled
   }

   protected void c(Object var1, qp var2) {
      int var4 = Array.getLength(var1);

      for(int var3 = 0; var3 < var4; ++var3) {
         Object var5 = Array.get(var1, var3);
         if(var5 != null) {
            this.b(var5, var2);
         }
      }

   }

   final Object m(List var1) {
      return var1 == null?null:(this.ayY?this.n(var1):this.o(var1));
   }

   protected Object x(qo param1) {
      // $FF: Couldn't be decompiled
   }
}
