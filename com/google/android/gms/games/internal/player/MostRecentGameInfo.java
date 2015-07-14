package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface MostRecentGameInfo extends Parcelable, Freezable {
   Uri mA();

   Uri mB();

   String mw();

   String mx();

   long my();

   Uri mz();
}
