package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
   final e ant;

   @Deprecated
   public void clearDefaultAccount() {
      this.ant.clearDefaultAccount();
   }

   @Deprecated
   public void connect() {
      this.ant.connect();
   }

   @Deprecated
   public void disconnect() {
      this.ant.disconnect();
   }

   @Deprecated
   public String getAccountName() {
      return this.ant.getAccountName();
   }

   @Deprecated
   public Person getCurrentPerson() {
      return this.ant.getCurrentPerson();
   }

   @Deprecated
   public boolean isConnected() {
      return this.ant.isConnected();
   }

   @Deprecated
   public boolean isConnecting() {
      return this.ant.isConnecting();
   }

   @Deprecated
   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.ant.isConnectionCallbacksRegistered(var1);
   }

   @Deprecated
   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.ant.isConnectionFailedListenerRegistered(var1);
   }

   @Deprecated
   public void loadMoments(final PlusClient.OnMomentsLoadedListener var1) {
      this.ant.j(new BaseImplementation.b() {
         public void a(Moments.LoadMomentsResult var1x) {
            var1.onMomentsLoaded(var1x.getStatus().gQ(), var1x.getMomentBuffer(), var1x.getNextPageToken(), var1x.getUpdated());
         }

         // $FF: synthetic method
         public void b(Object var1x) {
            this.a((Moments.LoadMomentsResult)var1x);
         }
      });
   }

   @Deprecated
   public void loadMoments(final PlusClient.OnMomentsLoadedListener var1, int var2, String var3, Uri var4, String var5, String var6) {
      this.ant.a(new BaseImplementation.b() {
         public void a(Moments.LoadMomentsResult var1x) {
            var1.onMomentsLoaded(var1x.getStatus().gQ(), var1x.getMomentBuffer(), var1x.getNextPageToken(), var1x.getUpdated());
         }

         // $FF: synthetic method
         public void b(Object var1x) {
            this.a((Moments.LoadMomentsResult)var1x);
         }
      }, var2, var3, var4, var5, var6);
   }

   @Deprecated
   public void loadPeople(final PlusClient.OnPeopleLoadedListener var1, Collection var2) {
      this.ant.a(new BaseImplementation.b() {
         public void a(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().gQ(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }

         // $FF: synthetic method
         public void b(Object var1x) {
            this.a((People.LoadPeopleResult)var1x);
         }
      }, var2);
   }

   @Deprecated
   public void loadPeople(final PlusClient.OnPeopleLoadedListener var1, String... var2) {
      this.ant.d(new BaseImplementation.b() {
         public void a(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().gQ(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }

         // $FF: synthetic method
         public void b(Object var1x) {
            this.a((People.LoadPeopleResult)var1x);
         }
      }, var2);
   }

   @Deprecated
   public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener var1, int var2, String var3) {
      this.ant.a(new BaseImplementation.b() {
         public void a(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().gQ(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }

         // $FF: synthetic method
         public void b(Object var1x) {
            this.a((People.LoadPeopleResult)var1x);
         }
      }, var2, var3);
   }

   @Deprecated
   public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener var1, String var2) {
      this.ant.q(new BaseImplementation.b() {
         public void a(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().gQ(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }

         // $FF: synthetic method
         public void b(Object var1x) {
            this.a((People.LoadPeopleResult)var1x);
         }
      }, var2);
   }

   e os() {
      return this.ant;
   }

   @Deprecated
   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.ant.registerConnectionCallbacks(var1);
   }

   @Deprecated
   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.ant.registerConnectionFailedListener(var1);
   }

   @Deprecated
   public void removeMoment(String var1) {
      this.ant.removeMoment(var1);
   }

   @Deprecated
   public void revokeAccessAndDisconnect(final PlusClient.OnAccessRevokedListener var1) {
      this.ant.l(new BaseImplementation.b() {
         public void az(Status var1x) {
            var1.onAccessRevoked(var1x.getStatus().gQ());
         }

         // $FF: synthetic method
         public void b(Object var1x) {
            this.az((Status)var1x);
         }
      });
   }

   @Deprecated
   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.ant.unregisterConnectionCallbacks(var1);
   }

   @Deprecated
   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.ant.unregisterConnectionFailedListener(var1);
   }

   @Deprecated
   public void writeMoment(Moment var1) {
      this.ant.a((BaseImplementation.b)null, (Moment)var1);
   }

   @Deprecated
   public interface OnAccessRevokedListener {
      void onAccessRevoked(ConnectionResult var1);
   }

   @Deprecated
   public interface OnMomentsLoadedListener {
      @Deprecated
      void onMomentsLoaded(ConnectionResult var1, MomentBuffer var2, String var3, String var4);
   }

   @Deprecated
   public interface OnPeopleLoadedListener {
      void onPeopleLoaded(ConnectionResult var1, PersonBuffer var2, String var3);
   }
}
