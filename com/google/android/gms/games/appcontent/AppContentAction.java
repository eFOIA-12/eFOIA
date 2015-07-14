package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public interface AppContentAction extends Parcelable, Freezable {
   Bundle getExtras();

   String getLabel();

   String getType();

   List kH();

   String kI();

   String kJ();
}
