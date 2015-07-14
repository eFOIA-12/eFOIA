package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

class e {
   static MetadataField b(MetadataBundle var0) {
      Set var1 = var0.ja();
      if(var1.size() != 1) {
         throw new IllegalArgumentException("bundle should have exactly 1 populated field");
      } else {
         return (MetadataField)var1.iterator().next();
      }
   }
}
