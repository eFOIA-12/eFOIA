package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public interface MetadataField {
   Object a(DataHolder var1, int var2, int var3);

   void a(DataHolder var1, MetadataBundle var2, int var3, int var4);

   void a(Object var1, Bundle var2);

   String getName();

   Object h(Bundle var1);
}
