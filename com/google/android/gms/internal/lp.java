package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;

public class lp {
   public static final lp.a RQ = new lp.a("created", 4100000);
   public static final lp.b RR = new lp.b("lastOpenedTime", 4300000);
   public static final lp.d RS = new lp.d("modified", 4100000);
   public static final lp.c RT = new lp.c("modifiedByMe", 4100000);
   public static final lp.e RU = new lp.e("sharedWithMe", 4100000);

   public static class a extends com.google.android.gms.drive.metadata.internal.d implements SortableMetadataField {
      public a(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class b extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField, SortableMetadataField {
      public b(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class c extends com.google.android.gms.drive.metadata.internal.d implements SortableMetadataField {
      public c(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class d extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField, SortableMetadataField {
      public d(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class e extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField, SortableMetadataField {
      public e(String var1, int var2) {
         super(var1, var2);
      }
   }
}
