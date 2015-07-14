package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.wearable.Node;
import java.util.List;

public interface NodeApi {
   PendingResult addListener(GoogleApiClient var1, NodeApi.NodeListener var2);

   PendingResult getConnectedNodes(GoogleApiClient var1);

   PendingResult getLocalNode(GoogleApiClient var1);

   PendingResult removeListener(GoogleApiClient var1, NodeApi.NodeListener var2);

   public interface GetConnectedNodesResult extends Result {
      List getNodes();
   }

   public interface GetLocalNodeResult extends Result {
      Node getNode();
   }

   public interface NodeListener {
      void onPeerConnected(Node var1);

      void onPeerDisconnected(Node var1);
   }
}
