package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.List;

public final class pt extends com.google.android.gms.common.data.d implements Person {
   public pt(DataHolder var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.oZ();
   }

   public String getAboutMe() {
      return null;
   }

   public Person.AgeRange getAgeRange() {
      return null;
   }

   public String getBirthday() {
      return null;
   }

   public String getBraggingRights() {
      return null;
   }

   public int getCircledByCount() {
      return 0;
   }

   public Person.Cover getCover() {
      return null;
   }

   public String getCurrentLocation() {
      return null;
   }

   public String getDisplayName() {
      return this.getString("displayName");
   }

   public int getGender() {
      return 0;
   }

   public String getId() {
      return this.getString("personId");
   }

   public Person.Image getImage() {
      return new pi.c(this.getString("image"));
   }

   public String getLanguage() {
      return null;
   }

   public Person.Name getName() {
      return null;
   }

   public String getNickname() {
      return null;
   }

   public int getObjectType() {
      return pi.e.ck(this.getString("objectType"));
   }

   // $FF: synthetic method
   public List getOrganizations() {
      return this.oW();
   }

   // $FF: synthetic method
   public List getPlacesLived() {
      return this.oX();
   }

   public int getPlusOneCount() {
      return 0;
   }

   public int getRelationshipStatus() {
      return 0;
   }

   public String getTagline() {
      return null;
   }

   public String getUrl() {
      return this.getString("url");
   }

   // $FF: synthetic method
   public List getUrls() {
      return this.oY();
   }

   public boolean hasAboutMe() {
      return false;
   }

   public boolean hasAgeRange() {
      return false;
   }

   public boolean hasBirthday() {
      return false;
   }

   public boolean hasBraggingRights() {
      return false;
   }

   public boolean hasCircledByCount() {
      return false;
   }

   public boolean hasCover() {
      return false;
   }

   public boolean hasCurrentLocation() {
      return false;
   }

   public boolean hasDisplayName() {
      return true;
   }

   public boolean hasGender() {
      return false;
   }

   public boolean hasId() {
      return true;
   }

   public boolean hasImage() {
      return true;
   }

   public boolean hasIsPlusUser() {
      return false;
   }

   public boolean hasLanguage() {
      return false;
   }

   public boolean hasName() {
      return false;
   }

   public boolean hasNickname() {
      return false;
   }

   public boolean hasObjectType() {
      return true;
   }

   public boolean hasOrganizations() {
      return false;
   }

   public boolean hasPlacesLived() {
      return false;
   }

   public boolean hasPlusOneCount() {
      return false;
   }

   public boolean hasRelationshipStatus() {
      return false;
   }

   public boolean hasTagline() {
      return false;
   }

   public boolean hasUrl() {
      return true;
   }

   public boolean hasUrls() {
      return false;
   }

   public boolean hasVerified() {
      return false;
   }

   public boolean isPlusUser() {
      return false;
   }

   public boolean isVerified() {
      return false;
   }

   public ArrayList oW() {
      return null;
   }

   public ArrayList oX() {
      return null;
   }

   public ArrayList oY() {
      return null;
   }

   public Person oZ() {
      return new pi(this.getDisplayName(), this.getId(), (pi.c)this.getImage(), this.getObjectType(), this.getUrl());
   }
}
