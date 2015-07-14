package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.ko;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.pj;
import com.google.android.gms.internal.pk;
import com.google.android.gms.internal.pl;
import com.google.android.gms.internal.pm;
import com.google.android.gms.internal.pn;
import com.google.android.gms.internal.po;
import com.google.android.gms.internal.pp;
import com.google.android.gms.internal.pq;
import com.google.android.gms.internal.pr;
import com.google.android.gms.internal.ps;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class pi extends ks implements Person {
   public static final pj CREATOR = new pj();
   private static final HashMap aom = new HashMap();
   String CE;
   final int CK;
   String FR;
   String OS;
   final Set aon;
   int apA;
   String apB;
   List apC;
   boolean apD;
   String apl;
   pi.a apm;
   String apn;
   String apo;
   int app;
   pi.b apq;
   String apr;
   pi.c aps;
   boolean apt;
   pi.d apu;
   String apv;
   int apw;
   List apx;
   List apy;
   int apz;
   int ow;
   String vf;

   static {
      aom.put("aboutMe", kr.a.l("aboutMe", 2));
      aom.put("ageRange", kr.a.a("ageRange", 3, pi.a.class));
      aom.put("birthday", kr.a.l("birthday", 4));
      aom.put("braggingRights", kr.a.l("braggingRights", 5));
      aom.put("circledByCount", kr.a.i("circledByCount", 6));
      aom.put("cover", kr.a.a("cover", 7, pi.b.class));
      aom.put("currentLocation", kr.a.l("currentLocation", 8));
      aom.put("displayName", kr.a.l("displayName", 9));
      aom.put("gender", kr.a.a("gender", 12, (new ko()).h("male", 0).h("female", 1).h("other", 2), false));
      aom.put("id", kr.a.l("id", 14));
      aom.put("image", kr.a.a("image", 15, pi.c.class));
      aom.put("isPlusUser", kr.a.k("isPlusUser", 16));
      aom.put("language", kr.a.l("language", 18));
      aom.put("name", kr.a.a("name", 19, pi.d.class));
      aom.put("nickname", kr.a.l("nickname", 20));
      aom.put("objectType", kr.a.a("objectType", 21, (new ko()).h("person", 0).h("page", 1), false));
      aom.put("organizations", kr.a.b("organizations", 22, pi.f.class));
      aom.put("placesLived", kr.a.b("placesLived", 23, pi.g.class));
      aom.put("plusOneCount", kr.a.i("plusOneCount", 24));
      aom.put("relationshipStatus", kr.a.a("relationshipStatus", 25, (new ko()).h("single", 0).h("in_a_relationship", 1).h("engaged", 2).h("married", 3).h("its_complicated", 4).h("open_relationship", 5).h("widowed", 6).h("in_domestic_partnership", 7).h("in_civil_union", 8), false));
      aom.put("tagline", kr.a.l("tagline", 26));
      aom.put("url", kr.a.l("url", 27));
      aom.put("urls", kr.a.b("urls", 28, pi.h.class));
      aom.put("verified", kr.a.k("verified", 29));
   }

   public pi() {
      this.CK = 1;
      this.aon = new HashSet();
   }

   public pi(String var1, String var2, pi.c var3, int var4, String var5) {
      this.CK = 1;
      this.aon = new HashSet();
      this.OS = var1;
      this.aon.add(Integer.valueOf(9));
      this.CE = var2;
      this.aon.add(Integer.valueOf(14));
      this.aps = var3;
      this.aon.add(Integer.valueOf(15));
      this.apw = var4;
      this.aon.add(Integer.valueOf(21));
      this.vf = var5;
      this.aon.add(Integer.valueOf(27));
   }

   pi(Set var1, int var2, String var3, pi.a var4, String var5, String var6, int var7, pi.b var8, String var9, String var10, int var11, String var12, pi.c var13, boolean var14, String var15, pi.d var16, String var17, int var18, List var19, List var20, int var21, int var22, String var23, String var24, List var25, boolean var26) {
      this.aon = var1;
      this.CK = var2;
      this.apl = var3;
      this.apm = var4;
      this.apn = var5;
      this.apo = var6;
      this.app = var7;
      this.apq = var8;
      this.apr = var9;
      this.OS = var10;
      this.ow = var11;
      this.CE = var12;
      this.aps = var13;
      this.apt = var14;
      this.FR = var15;
      this.apu = var16;
      this.apv = var17;
      this.apw = var18;
      this.apx = var19;
      this.apy = var20;
      this.apz = var21;
      this.apA = var22;
      this.apB = var23;
      this.vf = var24;
      this.apC = var25;
      this.apD = var26;
   }

   public static pi i(byte[] var0) {
      Parcel var1 = Parcel.obtain();
      var1.unmarshall(var0, 0, var0.length);
      var1.setDataPosition(0);
      pi var2 = CREATOR.dz(var1);
      var1.recycle();
      return var2;
   }

   protected boolean a(kr.a var1) {
      return this.aon.contains(Integer.valueOf(var1.hR()));
   }

   protected Object b(kr.a var1) {
      switch(var1.hR()) {
      case 2:
         return this.apl;
      case 3:
         return this.apm;
      case 4:
         return this.apn;
      case 5:
         return this.apo;
      case 6:
         return Integer.valueOf(this.app);
      case 7:
         return this.apq;
      case 8:
         return this.apr;
      case 9:
         return this.OS;
      case 10:
      case 11:
      case 13:
      case 17:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
      case 12:
         return Integer.valueOf(this.ow);
      case 14:
         return this.CE;
      case 15:
         return this.aps;
      case 16:
         return Boolean.valueOf(this.apt);
      case 18:
         return this.FR;
      case 19:
         return this.apu;
      case 20:
         return this.apv;
      case 21:
         return Integer.valueOf(this.apw);
      case 22:
         return this.apx;
      case 23:
         return this.apy;
      case 24:
         return Integer.valueOf(this.apz);
      case 25:
         return Integer.valueOf(this.apA);
      case 26:
         return this.apB;
      case 27:
         return this.vf;
      case 28:
         return this.apC;
      case 29:
         return Boolean.valueOf(this.apD);
      }
   }

   public int describeContents() {
      pj var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof pi)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         pi var4 = (pi)var1;
         Iterator var2 = aom.values().iterator();

         while(var2.hasNext()) {
            kr.a var3 = (kr.a)var2.next();
            if(this.a(var3)) {
               if(!var4.a(var3)) {
                  return false;
               }

               if(!this.b(var3).equals(var4.b(var3))) {
                  return false;
               }
            } else if(var4.a(var3)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.oL();
   }

   public String getAboutMe() {
      return this.apl;
   }

   public Person.AgeRange getAgeRange() {
      return this.apm;
   }

   public String getBirthday() {
      return this.apn;
   }

   public String getBraggingRights() {
      return this.apo;
   }

   public int getCircledByCount() {
      return this.app;
   }

   public Person.Cover getCover() {
      return this.apq;
   }

   public String getCurrentLocation() {
      return this.apr;
   }

   public String getDisplayName() {
      return this.OS;
   }

   public int getGender() {
      return this.ow;
   }

   public String getId() {
      return this.CE;
   }

   public Person.Image getImage() {
      return this.aps;
   }

   public String getLanguage() {
      return this.FR;
   }

   public Person.Name getName() {
      return this.apu;
   }

   public String getNickname() {
      return this.apv;
   }

   public int getObjectType() {
      return this.apw;
   }

   public List getOrganizations() {
      return (ArrayList)this.apx;
   }

   public List getPlacesLived() {
      return (ArrayList)this.apy;
   }

   public int getPlusOneCount() {
      return this.apz;
   }

   public int getRelationshipStatus() {
      return this.apA;
   }

   public String getTagline() {
      return this.apB;
   }

   public String getUrl() {
      return this.vf;
   }

   public List getUrls() {
      return (ArrayList)this.apC;
   }

   public HashMap hK() {
      return aom;
   }

   public boolean hasAboutMe() {
      return this.aon.contains(Integer.valueOf(2));
   }

   public boolean hasAgeRange() {
      return this.aon.contains(Integer.valueOf(3));
   }

   public boolean hasBirthday() {
      return this.aon.contains(Integer.valueOf(4));
   }

   public boolean hasBraggingRights() {
      return this.aon.contains(Integer.valueOf(5));
   }

   public boolean hasCircledByCount() {
      return this.aon.contains(Integer.valueOf(6));
   }

   public boolean hasCover() {
      return this.aon.contains(Integer.valueOf(7));
   }

   public boolean hasCurrentLocation() {
      return this.aon.contains(Integer.valueOf(8));
   }

   public boolean hasDisplayName() {
      return this.aon.contains(Integer.valueOf(9));
   }

   public boolean hasGender() {
      return this.aon.contains(Integer.valueOf(12));
   }

   public boolean hasId() {
      return this.aon.contains(Integer.valueOf(14));
   }

   public boolean hasImage() {
      return this.aon.contains(Integer.valueOf(15));
   }

   public boolean hasIsPlusUser() {
      return this.aon.contains(Integer.valueOf(16));
   }

   public boolean hasLanguage() {
      return this.aon.contains(Integer.valueOf(18));
   }

   public boolean hasName() {
      return this.aon.contains(Integer.valueOf(19));
   }

   public boolean hasNickname() {
      return this.aon.contains(Integer.valueOf(20));
   }

   public boolean hasObjectType() {
      return this.aon.contains(Integer.valueOf(21));
   }

   public boolean hasOrganizations() {
      return this.aon.contains(Integer.valueOf(22));
   }

   public boolean hasPlacesLived() {
      return this.aon.contains(Integer.valueOf(23));
   }

   public boolean hasPlusOneCount() {
      return this.aon.contains(Integer.valueOf(24));
   }

   public boolean hasRelationshipStatus() {
      return this.aon.contains(Integer.valueOf(25));
   }

   public boolean hasTagline() {
      return this.aon.contains(Integer.valueOf(26));
   }

   public boolean hasUrl() {
      return this.aon.contains(Integer.valueOf(27));
   }

   public boolean hasUrls() {
      return this.aon.contains(Integer.valueOf(28));
   }

   public boolean hasVerified() {
      return this.aon.contains(Integer.valueOf(29));
   }

   public int hashCode() {
      Iterator var3 = aom.values().iterator();
      int var1 = 0;

      while(var3.hasNext()) {
         kr.a var4 = (kr.a)var3.next();
         if(this.a(var4)) {
            int var2 = var4.hR();
            var1 = this.b(var4).hashCode() + var1 + var2;
         }
      }

      return var1;
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isPlusUser() {
      return this.apt;
   }

   public boolean isVerified() {
      return this.apD;
   }

   public pi oL() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      pj var3 = CREATOR;
      pj.a(this, var1, var2);
   }

   public static final class a extends ks implements Person.AgeRange {
      public static final pk CREATOR = new pk();
      private static final HashMap aom = new HashMap();
      final int CK;
      final Set aon;
      int apE;
      int apF;

      static {
         aom.put("max", kr.a.i("max", 2));
         aom.put("min", kr.a.i("min", 3));
      }

      public a() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      a(Set var1, int var2, int var3, int var4) {
         this.aon = var1;
         this.CK = var2;
         this.apE = var3;
         this.apF = var4;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return Integer.valueOf(this.apE);
         case 3:
            return Integer.valueOf(this.apF);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         pk var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.a)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.a var4 = (pi.a)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oM();
      }

      public int getMax() {
         return this.apE;
      }

      public int getMin() {
         return this.apF;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasMax() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasMin() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public pi.a oM() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         pk var3 = CREATOR;
         pk.a(this, var1, var2);
      }
   }

   public static final class b extends ks implements Person.Cover {
      public static final pl CREATOR = new pl();
      private static final HashMap aom = new HashMap();
      final int CK;
      final Set aon;
      pi.a apG;
      pi.b apH;
      int apI;

      static {
         aom.put("coverInfo", kr.a.a("coverInfo", 2, pi.a.class));
         aom.put("coverPhoto", kr.a.a("coverPhoto", 3, pi.b.class));
         aom.put("layout", kr.a.a("layout", 4, (new ko()).h("banner", 0), false));
      }

      public b() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      b(Set var1, int var2, pi.a var3, pi.b var4, int var5) {
         this.aon = var1;
         this.CK = var2;
         this.apG = var3;
         this.apH = var4;
         this.apI = var5;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return this.apG;
         case 3:
            return this.apH;
         case 4:
            return Integer.valueOf(this.apI);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         pl var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.b)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.b var4 = (pi.b)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oN();
      }

      public Person.CoverInfo getCoverInfo() {
         return this.apG;
      }

      public Person.CoverPhoto getCoverPhoto() {
         return this.apH;
      }

      public int getLayout() {
         return this.apI;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasCoverInfo() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasCoverPhoto() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasLayout() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public pi.b oN() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         pl var3 = CREATOR;
         pl.a(this, var1, var2);
      }
   }

   public static final class a extends ks implements Person.CoverInfo {
      public static final pm CREATOR = new pm();
      private static final HashMap aom = new HashMap();
      final int CK;
      final Set aon;
      int apJ;
      int apK;

      static {
         aom.put("leftImageOffset", kr.a.i("leftImageOffset", 2));
         aom.put("topImageOffset", kr.a.i("topImageOffset", 3));
      }

      public a() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      a(Set var1, int var2, int var3, int var4) {
         this.aon = var1;
         this.CK = var2;
         this.apJ = var3;
         this.apK = var4;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return Integer.valueOf(this.apJ);
         case 3:
            return Integer.valueOf(this.apK);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         pm var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.a)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.a var4 = (pi.a)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oO();
      }

      public int getLeftImageOffset() {
         return this.apJ;
      }

      public int getTopImageOffset() {
         return this.apK;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasLeftImageOffset() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasTopImageOffset() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public pi.a oO() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         pm var3 = CREATOR;
         pm.a(this, var1, var2);
      }
   }

   public static final class b extends ks implements Person.CoverPhoto {
      public static final pn CREATOR = new pn();
      private static final HashMap aom = new HashMap();
      final int CK;
      final Set aon;
      int li;
      int lj;
      String vf;

      static {
         aom.put("height", kr.a.i("height", 2));
         aom.put("url", kr.a.l("url", 3));
         aom.put("width", kr.a.i("width", 4));
      }

      public b() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      b(Set var1, int var2, int var3, String var4, int var5) {
         this.aon = var1;
         this.CK = var2;
         this.lj = var3;
         this.vf = var4;
         this.li = var5;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return Integer.valueOf(this.lj);
         case 3:
            return this.vf;
         case 4:
            return Integer.valueOf(this.li);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         pn var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.b)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.b var4 = (pi.b)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oP();
      }

      public int getHeight() {
         return this.lj;
      }

      public String getUrl() {
         return this.vf;
      }

      public int getWidth() {
         return this.li;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasHeight() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasUrl() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasWidth() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public pi.b oP() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         pn var3 = CREATOR;
         pn.a(this, var1, var2);
      }
   }

   public static final class c extends ks implements Person.Image {
      public static final po CREATOR = new po();
      private static final HashMap aom = new HashMap();
      final int CK;
      final Set aon;
      String vf;

      static {
         aom.put("url", kr.a.l("url", 2));
      }

      public c() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      public c(String var1) {
         this.aon = new HashSet();
         this.CK = 1;
         this.vf = var1;
         this.aon.add(Integer.valueOf(2));
      }

      c(Set var1, int var2, String var3) {
         this.aon = var1;
         this.CK = var2;
         this.vf = var3;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return this.vf;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         po var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.c)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.c var4 = (pi.c)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oQ();
      }

      public String getUrl() {
         return this.vf;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasUrl() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public pi.c oQ() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         po var3 = CREATOR;
         po.a(this, var1, var2);
      }
   }

   public static final class d extends ks implements Person.Name {
      public static final pp CREATOR = new pp();
      private static final HashMap aom = new HashMap();
      final int CK;
      String aoL;
      String aoO;
      final Set aon;
      String apL;
      String apM;
      String apN;
      String apO;

      static {
         aom.put("familyName", kr.a.l("familyName", 2));
         aom.put("formatted", kr.a.l("formatted", 3));
         aom.put("givenName", kr.a.l("givenName", 4));
         aom.put("honorificPrefix", kr.a.l("honorificPrefix", 5));
         aom.put("honorificSuffix", kr.a.l("honorificSuffix", 6));
         aom.put("middleName", kr.a.l("middleName", 7));
      }

      public d() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      d(Set var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8) {
         this.aon = var1;
         this.CK = var2;
         this.aoL = var3;
         this.apL = var4;
         this.aoO = var5;
         this.apM = var6;
         this.apN = var7;
         this.apO = var8;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return this.aoL;
         case 3:
            return this.apL;
         case 4:
            return this.aoO;
         case 5:
            return this.apM;
         case 6:
            return this.apN;
         case 7:
            return this.apO;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         pp var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.d)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.d var4 = (pi.d)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oR();
      }

      public String getFamilyName() {
         return this.aoL;
      }

      public String getFormatted() {
         return this.apL;
      }

      public String getGivenName() {
         return this.aoO;
      }

      public String getHonorificPrefix() {
         return this.apM;
      }

      public String getHonorificSuffix() {
         return this.apN;
      }

      public String getMiddleName() {
         return this.apO;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasFamilyName() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasFormatted() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasGivenName() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public boolean hasHonorificPrefix() {
         return this.aon.contains(Integer.valueOf(5));
      }

      public boolean hasHonorificSuffix() {
         return this.aon.contains(Integer.valueOf(6));
      }

      public boolean hasMiddleName() {
         return this.aon.contains(Integer.valueOf(7));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public pi.d oR() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         pp var3 = CREATOR;
         pp.a(this, var1, var2);
      }
   }

   public static class e {
      public static int ck(String var0) {
         if(var0.equals("person")) {
            return 0;
         } else if(var0.equals("page")) {
            return 1;
         } else {
            throw new IllegalArgumentException("Unknown objectType string: " + var0);
         }
      }
   }

   public static final class f extends ks implements Person.Organizations {
      public static final pq CREATOR = new pq();
      private static final HashMap aom = new HashMap();
      final int CK;
      int Gt;
      String OH;
      String UO;
      String aoK;
      final Set aon;
      String apP;
      String apQ;
      boolean apR;
      String apa;
      String mName;

      static {
         aom.put("department", kr.a.l("department", 2));
         aom.put("description", kr.a.l("description", 3));
         aom.put("endDate", kr.a.l("endDate", 4));
         aom.put("location", kr.a.l("location", 5));
         aom.put("name", kr.a.l("name", 6));
         aom.put("primary", kr.a.k("primary", 7));
         aom.put("startDate", kr.a.l("startDate", 8));
         aom.put("title", kr.a.l("title", 9));
         aom.put("type", kr.a.a("type", 10, (new ko()).h("work", 0).h("school", 1), false));
      }

      public f() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      f(Set var1, int var2, String var3, String var4, String var5, String var6, String var7, boolean var8, String var9, String var10, int var11) {
         this.aon = var1;
         this.CK = var2;
         this.apP = var3;
         this.UO = var4;
         this.aoK = var5;
         this.apQ = var6;
         this.mName = var7;
         this.apR = var8;
         this.apa = var9;
         this.OH = var10;
         this.Gt = var11;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return this.apP;
         case 3:
            return this.UO;
         case 4:
            return this.aoK;
         case 5:
            return this.apQ;
         case 6:
            return this.mName;
         case 7:
            return Boolean.valueOf(this.apR);
         case 8:
            return this.apa;
         case 9:
            return this.OH;
         case 10:
            return Integer.valueOf(this.Gt);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         pq var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.f)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.f var4 = (pi.f)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oS();
      }

      public String getDepartment() {
         return this.apP;
      }

      public String getDescription() {
         return this.UO;
      }

      public String getEndDate() {
         return this.aoK;
      }

      public String getLocation() {
         return this.apQ;
      }

      public String getName() {
         return this.mName;
      }

      public String getStartDate() {
         return this.apa;
      }

      public String getTitle() {
         return this.OH;
      }

      public int getType() {
         return this.Gt;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasDepartment() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasDescription() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasEndDate() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public boolean hasLocation() {
         return this.aon.contains(Integer.valueOf(5));
      }

      public boolean hasName() {
         return this.aon.contains(Integer.valueOf(6));
      }

      public boolean hasPrimary() {
         return this.aon.contains(Integer.valueOf(7));
      }

      public boolean hasStartDate() {
         return this.aon.contains(Integer.valueOf(8));
      }

      public boolean hasTitle() {
         return this.aon.contains(Integer.valueOf(9));
      }

      public boolean hasType() {
         return this.aon.contains(Integer.valueOf(10));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public boolean isPrimary() {
         return this.apR;
      }

      public pi.f oS() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         pq var3 = CREATOR;
         pq.a(this, var1, var2);
      }
   }

   public static final class g extends ks implements Person.PlacesLived {
      public static final pr CREATOR = new pr();
      private static final HashMap aom = new HashMap();
      final int CK;
      final Set aon;
      boolean apR;
      String mValue;

      static {
         aom.put("primary", kr.a.k("primary", 2));
         aom.put("value", kr.a.l("value", 3));
      }

      public g() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      g(Set var1, int var2, boolean var3, String var4) {
         this.aon = var1;
         this.CK = var2;
         this.apR = var3;
         this.mValue = var4;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 2:
            return Boolean.valueOf(this.apR);
         case 3:
            return this.mValue;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         pr var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.g)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.g var4 = (pi.g)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oT();
      }

      public String getValue() {
         return this.mValue;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasPrimary() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasValue() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      public boolean isPrimary() {
         return this.apR;
      }

      public pi.g oT() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         pr var3 = CREATOR;
         pr.a(this, var1, var2);
      }
   }

   public static final class h extends ks implements Person.Urls {
      public static final ps CREATOR = new ps();
      private static final HashMap aom = new HashMap();
      final int CK;
      int Gt;
      String XL;
      final Set aon;
      private final int apS = 4;
      String mValue;

      static {
         aom.put("label", kr.a.l("label", 5));
         aom.put("type", kr.a.a("type", 6, (new ko()).h("home", 0).h("work", 1).h("blog", 2).h("profile", 3).h("other", 4).h("otherProfile", 5).h("contributor", 6).h("website", 7), false));
         aom.put("value", kr.a.l("value", 4));
      }

      public h() {
         this.CK = 1;
         this.aon = new HashSet();
      }

      h(Set var1, int var2, String var3, int var4, String var5, int var6) {
         this.aon = var1;
         this.CK = var2;
         this.XL = var3;
         this.Gt = var4;
         this.mValue = var5;
      }

      protected boolean a(kr.a var1) {
         return this.aon.contains(Integer.valueOf(var1.hR()));
      }

      protected Object b(kr.a var1) {
         switch(var1.hR()) {
         case 4:
            return this.mValue;
         case 5:
            return this.XL;
         case 6:
            return Integer.valueOf(this.Gt);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
         }
      }

      public int describeContents() {
         ps var1 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof pi.h)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            pi.h var4 = (pi.h)var1;
            Iterator var2 = aom.values().iterator();

            while(var2.hasNext()) {
               kr.a var3 = (kr.a)var2.next();
               if(this.a(var3)) {
                  if(!var4.a(var3)) {
                     return false;
                  }

                  if(!this.b(var3).equals(var4.b(var3))) {
                     return false;
                  }
               } else if(var4.a(var3)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.oV();
      }

      public String getLabel() {
         return this.XL;
      }

      public int getType() {
         return this.Gt;
      }

      public String getValue() {
         return this.mValue;
      }

      public HashMap hK() {
         return aom;
      }

      public boolean hasLabel() {
         return this.aon.contains(Integer.valueOf(5));
      }

      public boolean hasType() {
         return this.aon.contains(Integer.valueOf(6));
      }

      public boolean hasValue() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var3 = aom.values().iterator();
         int var1 = 0;

         while(var3.hasNext()) {
            kr.a var4 = (kr.a)var3.next();
            if(this.a(var4)) {
               int var2 = var4.hR();
               var1 = this.b(var4).hashCode() + var1 + var2;
            }
         }

         return var1;
      }

      public boolean isDataValid() {
         return true;
      }

      @Deprecated
      public int oU() {
         return 4;
      }

      public pi.h oV() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         ps var3 = CREATOR;
         ps.a(this, var1, var2);
      }
   }
}
