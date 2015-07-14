package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.pe;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class pd extends ks implements ItemScope {
   public static final pe CREATOR = new pe();
   private static final HashMap aom = new HashMap();
   String CE;
   final int CK;
   String UO;
   double agg;
   double agh;
   String aoA;
   pd aoB;
   String aoC;
   String aoD;
   List aoE;
   String aoF;
   String aoG;
   String aoH;
   String aoI;
   String aoJ;
   String aoK;
   String aoL;
   String aoM;
   pd aoN;
   String aoO;
   String aoP;
   String aoQ;
   pd aoR;
   pd aoS;
   pd aoT;
   List aoU;
   String aoV;
   String aoW;
   String aoX;
   String aoY;
   pd aoZ;
   final Set aon;
   pd aoo;
   List aop;
   pd aoq;
   String aor;
   String aos;
   String aot;
   List aou;
   int aov;
   List aow;
   pd aox;
   List aoy;
   String aoz;
   String apa;
   String apb;
   String apc;
   pd apd;
   String ape;
   String apf;
   String apg;
   String aph;
   String mName;
   String ov;
   String vc;
   String vf;

   static {
      aom.put("about", kr.a.a("about", 2, pd.class));
      aom.put("additionalName", kr.a.m("additionalName", 3));
      aom.put("address", kr.a.a("address", 4, pd.class));
      aom.put("addressCountry", kr.a.l("addressCountry", 5));
      aom.put("addressLocality", kr.a.l("addressLocality", 6));
      aom.put("addressRegion", kr.a.l("addressRegion", 7));
      aom.put("associated_media", kr.a.b("associated_media", 8, pd.class));
      aom.put("attendeeCount", kr.a.i("attendeeCount", 9));
      aom.put("attendees", kr.a.b("attendees", 10, pd.class));
      aom.put("audio", kr.a.a("audio", 11, pd.class));
      aom.put("author", kr.a.b("author", 12, pd.class));
      aom.put("bestRating", kr.a.l("bestRating", 13));
      aom.put("birthDate", kr.a.l("birthDate", 14));
      aom.put("byArtist", kr.a.a("byArtist", 15, pd.class));
      aom.put("caption", kr.a.l("caption", 16));
      aom.put("contentSize", kr.a.l("contentSize", 17));
      aom.put("contentUrl", kr.a.l("contentUrl", 18));
      aom.put("contributor", kr.a.b("contributor", 19, pd.class));
      aom.put("dateCreated", kr.a.l("dateCreated", 20));
      aom.put("dateModified", kr.a.l("dateModified", 21));
      aom.put("datePublished", kr.a.l("datePublished", 22));
      aom.put("description", kr.a.l("description", 23));
      aom.put("duration", kr.a.l("duration", 24));
      aom.put("embedUrl", kr.a.l("embedUrl", 25));
      aom.put("endDate", kr.a.l("endDate", 26));
      aom.put("familyName", kr.a.l("familyName", 27));
      aom.put("gender", kr.a.l("gender", 28));
      aom.put("geo", kr.a.a("geo", 29, pd.class));
      aom.put("givenName", kr.a.l("givenName", 30));
      aom.put("height", kr.a.l("height", 31));
      aom.put("id", kr.a.l("id", 32));
      aom.put("image", kr.a.l("image", 33));
      aom.put("inAlbum", kr.a.a("inAlbum", 34, pd.class));
      aom.put("latitude", kr.a.j("latitude", 36));
      aom.put("location", kr.a.a("location", 37, pd.class));
      aom.put("longitude", kr.a.j("longitude", 38));
      aom.put("name", kr.a.l("name", 39));
      aom.put("partOfTVSeries", kr.a.a("partOfTVSeries", 40, pd.class));
      aom.put("performers", kr.a.b("performers", 41, pd.class));
      aom.put("playerType", kr.a.l("playerType", 42));
      aom.put("postOfficeBoxNumber", kr.a.l("postOfficeBoxNumber", 43));
      aom.put("postalCode", kr.a.l("postalCode", 44));
      aom.put("ratingValue", kr.a.l("ratingValue", 45));
      aom.put("reviewRating", kr.a.a("reviewRating", 46, pd.class));
      aom.put("startDate", kr.a.l("startDate", 47));
      aom.put("streetAddress", kr.a.l("streetAddress", 48));
      aom.put("text", kr.a.l("text", 49));
      aom.put("thumbnail", kr.a.a("thumbnail", 50, pd.class));
      aom.put("thumbnailUrl", kr.a.l("thumbnailUrl", 51));
      aom.put("tickerSymbol", kr.a.l("tickerSymbol", 52));
      aom.put("type", kr.a.l("type", 53));
      aom.put("url", kr.a.l("url", 54));
      aom.put("width", kr.a.l("width", 55));
      aom.put("worstRating", kr.a.l("worstRating", 56));
   }

   public pd() {
      this.CK = 1;
      this.aon = new HashSet();
   }

   pd(Set var1, int var2, pd var3, List var4, pd var5, String var6, String var7, String var8, List var9, int var10, List var11, pd var12, List var13, String var14, String var15, pd var16, String var17, String var18, String var19, List var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, pd var30, String var31, String var32, String var33, String var34, pd var35, double var36, pd var38, double var39, String var41, pd var42, List var43, String var44, String var45, String var46, String var47, pd var48, String var49, String var50, String var51, pd var52, String var53, String var54, String var55, String var56, String var57, String var58) {
      this.aon = var1;
      this.CK = var2;
      this.aoo = var3;
      this.aop = var4;
      this.aoq = var5;
      this.aor = var6;
      this.aos = var7;
      this.aot = var8;
      this.aou = var9;
      this.aov = var10;
      this.aow = var11;
      this.aox = var12;
      this.aoy = var13;
      this.aoz = var14;
      this.aoA = var15;
      this.aoB = var16;
      this.aoC = var17;
      this.aoD = var18;
      this.ov = var19;
      this.aoE = var20;
      this.aoF = var21;
      this.aoG = var22;
      this.aoH = var23;
      this.UO = var24;
      this.aoI = var25;
      this.aoJ = var26;
      this.aoK = var27;
      this.aoL = var28;
      this.aoM = var29;
      this.aoN = var30;
      this.aoO = var31;
      this.aoP = var32;
      this.CE = var33;
      this.aoQ = var34;
      this.aoR = var35;
      this.agg = var36;
      this.aoS = var38;
      this.agh = var39;
      this.mName = var41;
      this.aoT = var42;
      this.aoU = var43;
      this.aoV = var44;
      this.aoW = var45;
      this.aoX = var46;
      this.aoY = var47;
      this.aoZ = var48;
      this.apa = var49;
      this.apb = var50;
      this.apc = var51;
      this.apd = var52;
      this.ape = var53;
      this.apf = var54;
      this.vc = var55;
      this.vf = var56;
      this.apg = var57;
      this.aph = var58;
   }

   public pd(Set var1, pd var2, List var3, pd var4, String var5, String var6, String var7, List var8, int var9, List var10, pd var11, List var12, String var13, String var14, pd var15, String var16, String var17, String var18, List var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, pd var29, String var30, String var31, String var32, String var33, pd var34, double var35, pd var37, double var38, String var40, pd var41, List var42, String var43, String var44, String var45, String var46, pd var47, String var48, String var49, String var50, pd var51, String var52, String var53, String var54, String var55, String var56, String var57) {
      this.aon = var1;
      this.CK = 1;
      this.aoo = var2;
      this.aop = var3;
      this.aoq = var4;
      this.aor = var5;
      this.aos = var6;
      this.aot = var7;
      this.aou = var8;
      this.aov = var9;
      this.aow = var10;
      this.aox = var11;
      this.aoy = var12;
      this.aoz = var13;
      this.aoA = var14;
      this.aoB = var15;
      this.aoC = var16;
      this.aoD = var17;
      this.ov = var18;
      this.aoE = var19;
      this.aoF = var20;
      this.aoG = var21;
      this.aoH = var22;
      this.UO = var23;
      this.aoI = var24;
      this.aoJ = var25;
      this.aoK = var26;
      this.aoL = var27;
      this.aoM = var28;
      this.aoN = var29;
      this.aoO = var30;
      this.aoP = var31;
      this.CE = var32;
      this.aoQ = var33;
      this.aoR = var34;
      this.agg = var35;
      this.aoS = var37;
      this.agh = var38;
      this.mName = var40;
      this.aoT = var41;
      this.aoU = var42;
      this.aoV = var43;
      this.aoW = var44;
      this.aoX = var45;
      this.aoY = var46;
      this.aoZ = var47;
      this.apa = var48;
      this.apb = var49;
      this.apc = var50;
      this.apd = var51;
      this.ape = var52;
      this.apf = var53;
      this.vc = var54;
      this.vf = var55;
      this.apg = var56;
      this.aph = var57;
   }

   protected boolean a(kr.a var1) {
      return this.aon.contains(Integer.valueOf(var1.hR()));
   }

   protected Object b(kr.a var1) {
      switch(var1.hR()) {
      case 2:
         return this.aoo;
      case 3:
         return this.aop;
      case 4:
         return this.aoq;
      case 5:
         return this.aor;
      case 6:
         return this.aos;
      case 7:
         return this.aot;
      case 8:
         return this.aou;
      case 9:
         return Integer.valueOf(this.aov);
      case 10:
         return this.aow;
      case 11:
         return this.aox;
      case 12:
         return this.aoy;
      case 13:
         return this.aoz;
      case 14:
         return this.aoA;
      case 15:
         return this.aoB;
      case 16:
         return this.aoC;
      case 17:
         return this.aoD;
      case 18:
         return this.ov;
      case 19:
         return this.aoE;
      case 20:
         return this.aoF;
      case 21:
         return this.aoG;
      case 22:
         return this.aoH;
      case 23:
         return this.UO;
      case 24:
         return this.aoI;
      case 25:
         return this.aoJ;
      case 26:
         return this.aoK;
      case 27:
         return this.aoL;
      case 28:
         return this.aoM;
      case 29:
         return this.aoN;
      case 30:
         return this.aoO;
      case 31:
         return this.aoP;
      case 32:
         return this.CE;
      case 33:
         return this.aoQ;
      case 34:
         return this.aoR;
      case 35:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
      case 36:
         return Double.valueOf(this.agg);
      case 37:
         return this.aoS;
      case 38:
         return Double.valueOf(this.agh);
      case 39:
         return this.mName;
      case 40:
         return this.aoT;
      case 41:
         return this.aoU;
      case 42:
         return this.aoV;
      case 43:
         return this.aoW;
      case 44:
         return this.aoX;
      case 45:
         return this.aoY;
      case 46:
         return this.aoZ;
      case 47:
         return this.apa;
      case 48:
         return this.apb;
      case 49:
         return this.apc;
      case 50:
         return this.apd;
      case 51:
         return this.ape;
      case 52:
         return this.apf;
      case 53:
         return this.vc;
      case 54:
         return this.vf;
      case 55:
         return this.apg;
      case 56:
         return this.aph;
      }
   }

   public int describeContents() {
      pe var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof pd)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         pd var4 = (pd)var1;
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
      return this.oI();
   }

   public ItemScope getAbout() {
      return this.aoo;
   }

   public List getAdditionalName() {
      return this.aop;
   }

   public ItemScope getAddress() {
      return this.aoq;
   }

   public String getAddressCountry() {
      return this.aor;
   }

   public String getAddressLocality() {
      return this.aos;
   }

   public String getAddressRegion() {
      return this.aot;
   }

   public List getAssociated_media() {
      return (ArrayList)this.aou;
   }

   public int getAttendeeCount() {
      return this.aov;
   }

   public List getAttendees() {
      return (ArrayList)this.aow;
   }

   public ItemScope getAudio() {
      return this.aox;
   }

   public List getAuthor() {
      return (ArrayList)this.aoy;
   }

   public String getBestRating() {
      return this.aoz;
   }

   public String getBirthDate() {
      return this.aoA;
   }

   public ItemScope getByArtist() {
      return this.aoB;
   }

   public String getCaption() {
      return this.aoC;
   }

   public String getContentSize() {
      return this.aoD;
   }

   public String getContentUrl() {
      return this.ov;
   }

   public List getContributor() {
      return (ArrayList)this.aoE;
   }

   public String getDateCreated() {
      return this.aoF;
   }

   public String getDateModified() {
      return this.aoG;
   }

   public String getDatePublished() {
      return this.aoH;
   }

   public String getDescription() {
      return this.UO;
   }

   public String getDuration() {
      return this.aoI;
   }

   public String getEmbedUrl() {
      return this.aoJ;
   }

   public String getEndDate() {
      return this.aoK;
   }

   public String getFamilyName() {
      return this.aoL;
   }

   public String getGender() {
      return this.aoM;
   }

   public ItemScope getGeo() {
      return this.aoN;
   }

   public String getGivenName() {
      return this.aoO;
   }

   public String getHeight() {
      return this.aoP;
   }

   public String getId() {
      return this.CE;
   }

   public String getImage() {
      return this.aoQ;
   }

   public ItemScope getInAlbum() {
      return this.aoR;
   }

   public double getLatitude() {
      return this.agg;
   }

   public ItemScope getLocation() {
      return this.aoS;
   }

   public double getLongitude() {
      return this.agh;
   }

   public String getName() {
      return this.mName;
   }

   public ItemScope getPartOfTVSeries() {
      return this.aoT;
   }

   public List getPerformers() {
      return (ArrayList)this.aoU;
   }

   public String getPlayerType() {
      return this.aoV;
   }

   public String getPostOfficeBoxNumber() {
      return this.aoW;
   }

   public String getPostalCode() {
      return this.aoX;
   }

   public String getRatingValue() {
      return this.aoY;
   }

   public ItemScope getReviewRating() {
      return this.aoZ;
   }

   public String getStartDate() {
      return this.apa;
   }

   public String getStreetAddress() {
      return this.apb;
   }

   public String getText() {
      return this.apc;
   }

   public ItemScope getThumbnail() {
      return this.apd;
   }

   public String getThumbnailUrl() {
      return this.ape;
   }

   public String getTickerSymbol() {
      return this.apf;
   }

   public String getType() {
      return this.vc;
   }

   public String getUrl() {
      return this.vf;
   }

   public String getWidth() {
      return this.apg;
   }

   public String getWorstRating() {
      return this.aph;
   }

   public HashMap hK() {
      return aom;
   }

   public boolean hasAbout() {
      return this.aon.contains(Integer.valueOf(2));
   }

   public boolean hasAdditionalName() {
      return this.aon.contains(Integer.valueOf(3));
   }

   public boolean hasAddress() {
      return this.aon.contains(Integer.valueOf(4));
   }

   public boolean hasAddressCountry() {
      return this.aon.contains(Integer.valueOf(5));
   }

   public boolean hasAddressLocality() {
      return this.aon.contains(Integer.valueOf(6));
   }

   public boolean hasAddressRegion() {
      return this.aon.contains(Integer.valueOf(7));
   }

   public boolean hasAssociated_media() {
      return this.aon.contains(Integer.valueOf(8));
   }

   public boolean hasAttendeeCount() {
      return this.aon.contains(Integer.valueOf(9));
   }

   public boolean hasAttendees() {
      return this.aon.contains(Integer.valueOf(10));
   }

   public boolean hasAudio() {
      return this.aon.contains(Integer.valueOf(11));
   }

   public boolean hasAuthor() {
      return this.aon.contains(Integer.valueOf(12));
   }

   public boolean hasBestRating() {
      return this.aon.contains(Integer.valueOf(13));
   }

   public boolean hasBirthDate() {
      return this.aon.contains(Integer.valueOf(14));
   }

   public boolean hasByArtist() {
      return this.aon.contains(Integer.valueOf(15));
   }

   public boolean hasCaption() {
      return this.aon.contains(Integer.valueOf(16));
   }

   public boolean hasContentSize() {
      return this.aon.contains(Integer.valueOf(17));
   }

   public boolean hasContentUrl() {
      return this.aon.contains(Integer.valueOf(18));
   }

   public boolean hasContributor() {
      return this.aon.contains(Integer.valueOf(19));
   }

   public boolean hasDateCreated() {
      return this.aon.contains(Integer.valueOf(20));
   }

   public boolean hasDateModified() {
      return this.aon.contains(Integer.valueOf(21));
   }

   public boolean hasDatePublished() {
      return this.aon.contains(Integer.valueOf(22));
   }

   public boolean hasDescription() {
      return this.aon.contains(Integer.valueOf(23));
   }

   public boolean hasDuration() {
      return this.aon.contains(Integer.valueOf(24));
   }

   public boolean hasEmbedUrl() {
      return this.aon.contains(Integer.valueOf(25));
   }

   public boolean hasEndDate() {
      return this.aon.contains(Integer.valueOf(26));
   }

   public boolean hasFamilyName() {
      return this.aon.contains(Integer.valueOf(27));
   }

   public boolean hasGender() {
      return this.aon.contains(Integer.valueOf(28));
   }

   public boolean hasGeo() {
      return this.aon.contains(Integer.valueOf(29));
   }

   public boolean hasGivenName() {
      return this.aon.contains(Integer.valueOf(30));
   }

   public boolean hasHeight() {
      return this.aon.contains(Integer.valueOf(31));
   }

   public boolean hasId() {
      return this.aon.contains(Integer.valueOf(32));
   }

   public boolean hasImage() {
      return this.aon.contains(Integer.valueOf(33));
   }

   public boolean hasInAlbum() {
      return this.aon.contains(Integer.valueOf(34));
   }

   public boolean hasLatitude() {
      return this.aon.contains(Integer.valueOf(36));
   }

   public boolean hasLocation() {
      return this.aon.contains(Integer.valueOf(37));
   }

   public boolean hasLongitude() {
      return this.aon.contains(Integer.valueOf(38));
   }

   public boolean hasName() {
      return this.aon.contains(Integer.valueOf(39));
   }

   public boolean hasPartOfTVSeries() {
      return this.aon.contains(Integer.valueOf(40));
   }

   public boolean hasPerformers() {
      return this.aon.contains(Integer.valueOf(41));
   }

   public boolean hasPlayerType() {
      return this.aon.contains(Integer.valueOf(42));
   }

   public boolean hasPostOfficeBoxNumber() {
      return this.aon.contains(Integer.valueOf(43));
   }

   public boolean hasPostalCode() {
      return this.aon.contains(Integer.valueOf(44));
   }

   public boolean hasRatingValue() {
      return this.aon.contains(Integer.valueOf(45));
   }

   public boolean hasReviewRating() {
      return this.aon.contains(Integer.valueOf(46));
   }

   public boolean hasStartDate() {
      return this.aon.contains(Integer.valueOf(47));
   }

   public boolean hasStreetAddress() {
      return this.aon.contains(Integer.valueOf(48));
   }

   public boolean hasText() {
      return this.aon.contains(Integer.valueOf(49));
   }

   public boolean hasThumbnail() {
      return this.aon.contains(Integer.valueOf(50));
   }

   public boolean hasThumbnailUrl() {
      return this.aon.contains(Integer.valueOf(51));
   }

   public boolean hasTickerSymbol() {
      return this.aon.contains(Integer.valueOf(52));
   }

   public boolean hasType() {
      return this.aon.contains(Integer.valueOf(53));
   }

   public boolean hasUrl() {
      return this.aon.contains(Integer.valueOf(54));
   }

   public boolean hasWidth() {
      return this.aon.contains(Integer.valueOf(55));
   }

   public boolean hasWorstRating() {
      return this.aon.contains(Integer.valueOf(56));
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

   public pd oI() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      pe var3 = CREATOR;
      pe.a(this, var1, var2);
   }
}
