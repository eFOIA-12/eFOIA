package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public interface ExtendedGame extends Parcelable, Freezable {
   Game getGame();

   ArrayList lY();

   int lZ();

   boolean ma();

   int mb();

   long mc();

   long md();

   String me();

   long mf();

   String mg();

   SnapshotMetadata mh();
}
