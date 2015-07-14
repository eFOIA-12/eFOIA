package android.support.v4.app;

import android.support.annotation.Nullable;
import android.view.View;

interface FragmentContainer {
   @Nullable
   View findViewById(int var1);

   boolean hasView();
}
