package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.io.IOException;

public abstract class il {
   protected final is He;
   private final String Hf;
   private iu Hg;

   protected il(String var1, String var2, String var3) {
      in.aF(var1);
      this.Hf = var1;
      this.He = new is(var2);
      if(!TextUtils.isEmpty(var3)) {
         this.He.aK(var3);
      }

   }

   public final void a(iu var1) {
      this.Hg = var1;
      if(this.Hg == null) {
         this.fV();
      }

   }

   protected final void a(String var1, long var2, String var4) throws IOException {
      this.He.a("Sending text message: %s to: %s", new Object[]{var1, var4});
      this.Hg.a(this.Hf, var1, var2, var4);
   }

   public void aD(String var1) {
   }

   public void b(long var1, int var3) {
   }

   protected final long fU() {
      return this.Hg.fS();
   }

   public void fV() {
   }

   public final String getNamespace() {
      return this.Hf;
   }
}
