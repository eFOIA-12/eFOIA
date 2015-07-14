package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.d;
import java.util.List;

public final class ak implements NodeApi {
   public PendingResult addListener(GoogleApiClient var1, NodeApi.NodeListener var2) {
      return var1.a((BaseImplementation.a)(new ak.a(var1, var2, null)));
   }

   public PendingResult getConnectedNodes(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.p(this);
         }

         protected NodeApi.GetConnectedNodesResult aK(Status var1) {
            return new ak.b(var1, (List)null);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aK(var1);
         }
      }));
   }

   public PendingResult getLocalNode(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.o(this);
         }

         protected NodeApi.GetLocalNodeResult aJ(Status var1) {
            return new ak.c(var1, (Node)null);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aJ(var1);
         }
      }));
   }

   public PendingResult removeListener(final GoogleApiClient var1, final NodeApi.NodeListener var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.b(this, (NodeApi.NodeListener)var2);
         }

         public Status b(Status var1) {
            return var1;
         }

         // $FF: synthetic method
         public Result c(Status var1) {
            return this.b(var1);
         }
      }));
   }

   private static final class a extends d {
      private NodeApi.NodeListener axZ;

      private a(GoogleApiClient var1, NodeApi.NodeListener var2) {
         super(var1);
         this.axZ = var2;
      }

      // $FF: synthetic method
      a(GoogleApiClient var1, NodeApi.NodeListener var2, Object var3) {
         this(var1, var2);
      }

      protected void a(ba var1) throws RemoteException {
         var1.a((BaseImplementation.b)this, (NodeApi.NodeListener)this.axZ);
         this.axZ = null;
      }

      public Status b(Status var1) {
         this.axZ = null;
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }

   public static class b implements NodeApi.GetConnectedNodesResult {
      private final Status Eb;
      private final List aya;

      public b(Status var1, List var2) {
         this.Eb = var1;
         this.aya = var2;
      }

      public List getNodes() {
         return this.aya;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   public static class c implements NodeApi.GetLocalNodeResult {
      private final Status Eb;
      private final Node ayb;

      public c(Status var1, Node var2) {
         this.Eb = var1;
         this.ayb = var2;
      }

      public Node getNode() {
         return this.ayb;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }
}
