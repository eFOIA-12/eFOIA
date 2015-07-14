package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class m extends Metadata {
   private final MetadataBundle PD;

   public m(MetadataBundle var1) {
      this.PD = var1;
   }

   protected Object a(MetadataField var1) {
      return this.PD.a(var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.iy();
   }

   public boolean isDataValid() {
      return this.PD != null;
   }

   public Metadata iy() {
      return new m(MetadataBundle.a(this.PD));
   }

   public String toString() {
      return "Metadata [mImpl=" + this.PD + "]";
   }
}
