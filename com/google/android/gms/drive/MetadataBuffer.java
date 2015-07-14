package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.internal.m;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.ln;
import java.util.Iterator;

public final class MetadataBuffer extends DataBuffer {
   private final String OB;
   private MetadataBuffer.a OC;

   public MetadataBuffer(DataHolder var1, String var2) {
      super(var1);
      this.OB = var2;
      var1.gV().setClassLoader(MetadataBuffer.class.getClassLoader());
   }

   public Metadata get(int var1) {
      MetadataBuffer.a var3 = this.OC;
      MetadataBuffer.a var2;
      if(var3 != null) {
         var2 = var3;
         if(var3.OD == var1) {
            return var2;
         }
      }

      var2 = new MetadataBuffer.a(this.JG, var1);
      this.OC = var2;
      return var2;
   }

   public String getNextPageToken() {
      return this.OB;
   }

   private static class a extends Metadata {
      private final DataHolder JG;
      private final int La;
      private final int OD;

      public a(DataHolder var1, int var2) {
         this.JG = var1;
         this.OD = var2;
         this.La = var1.au(var2);
      }

      protected Object a(MetadataField var1) {
         return var1.a(this.JG, this.OD, this.La);
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.iy();
      }

      public boolean isDataValid() {
         return !this.JG.isClosed();
      }

      public Metadata iy() {
         MetadataBundle var1 = MetadataBundle.iZ();
         Iterator var2 = com.google.android.gms.drive.metadata.internal.e.iY().iterator();

         while(var2.hasNext()) {
            MetadataField var3 = (MetadataField)var2.next();
            if(!(var3 instanceof com.google.android.gms.drive.metadata.b) && var3 != ln.RI) {
               var3.a(this.JG, var1, this.OD, this.La);
            }
         }

         return new m(var1);
      }
   }
}
