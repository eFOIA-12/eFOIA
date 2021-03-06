package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public interface AppContentCard extends Parcelable, Freezable {
   List getActions();

   String getDescription();

   Uri getIconImageUri();

   String getTitle();

   String getType();

   List kH();

   String kI();

   Uri kL();

   List kN();

   int kO();

   Bundle kP();

   String kQ();

   int kR();
}
