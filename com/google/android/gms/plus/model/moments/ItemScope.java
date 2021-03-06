package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.pd;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable {
   ItemScope getAbout();

   List getAdditionalName();

   ItemScope getAddress();

   String getAddressCountry();

   String getAddressLocality();

   String getAddressRegion();

   List getAssociated_media();

   int getAttendeeCount();

   List getAttendees();

   ItemScope getAudio();

   List getAuthor();

   String getBestRating();

   String getBirthDate();

   ItemScope getByArtist();

   String getCaption();

   String getContentSize();

   String getContentUrl();

   List getContributor();

   String getDateCreated();

   String getDateModified();

   String getDatePublished();

   String getDescription();

   String getDuration();

   String getEmbedUrl();

   String getEndDate();

   String getFamilyName();

   String getGender();

   ItemScope getGeo();

   String getGivenName();

   String getHeight();

   String getId();

   String getImage();

   ItemScope getInAlbum();

   double getLatitude();

   ItemScope getLocation();

   double getLongitude();

   String getName();

   ItemScope getPartOfTVSeries();

   List getPerformers();

   String getPlayerType();

   String getPostOfficeBoxNumber();

   String getPostalCode();

   String getRatingValue();

   ItemScope getReviewRating();

   String getStartDate();

   String getStreetAddress();

   String getText();

   ItemScope getThumbnail();

   String getThumbnailUrl();

   String getTickerSymbol();

   String getType();

   String getUrl();

   String getWidth();

   String getWorstRating();

   boolean hasAbout();

   boolean hasAdditionalName();

   boolean hasAddress();

   boolean hasAddressCountry();

   boolean hasAddressLocality();

   boolean hasAddressRegion();

   boolean hasAssociated_media();

   boolean hasAttendeeCount();

   boolean hasAttendees();

   boolean hasAudio();

   boolean hasAuthor();

   boolean hasBestRating();

   boolean hasBirthDate();

   boolean hasByArtist();

   boolean hasCaption();

   boolean hasContentSize();

   boolean hasContentUrl();

   boolean hasContributor();

   boolean hasDateCreated();

   boolean hasDateModified();

   boolean hasDatePublished();

   boolean hasDescription();

   boolean hasDuration();

   boolean hasEmbedUrl();

   boolean hasEndDate();

   boolean hasFamilyName();

   boolean hasGender();

   boolean hasGeo();

   boolean hasGivenName();

   boolean hasHeight();

   boolean hasId();

   boolean hasImage();

   boolean hasInAlbum();

   boolean hasLatitude();

   boolean hasLocation();

   boolean hasLongitude();

   boolean hasName();

   boolean hasPartOfTVSeries();

   boolean hasPerformers();

   boolean hasPlayerType();

   boolean hasPostOfficeBoxNumber();

   boolean hasPostalCode();

   boolean hasRatingValue();

   boolean hasReviewRating();

   boolean hasStartDate();

   boolean hasStreetAddress();

   boolean hasText();

   boolean hasThumbnail();

   boolean hasThumbnailUrl();

   boolean hasTickerSymbol();

   boolean hasType();

   boolean hasUrl();

   boolean hasWidth();

   boolean hasWorstRating();

   public static class Builder {
      private String CE;
      private String UO;
      private double agg;
      private double agh;
      private String aoA;
      private pd aoB;
      private String aoC;
      private String aoD;
      private List aoE;
      private String aoF;
      private String aoG;
      private String aoH;
      private String aoI;
      private String aoJ;
      private String aoK;
      private String aoL;
      private String aoM;
      private pd aoN;
      private String aoO;
      private String aoP;
      private String aoQ;
      private pd aoR;
      private pd aoS;
      private pd aoT;
      private List aoU;
      private String aoV;
      private String aoW;
      private String aoX;
      private String aoY;
      private pd aoZ;
      private final Set aon = new HashSet();
      private pd aoo;
      private List aop;
      private pd aoq;
      private String aor;
      private String aos;
      private String aot;
      private List aou;
      private int aov;
      private List aow;
      private pd aox;
      private List aoy;
      private String aoz;
      private String apa;
      private String apb;
      private String apc;
      private pd apd;
      private String ape;
      private String apf;
      private String apg;
      private String aph;
      private String mName;
      private String ov;
      private String vc;
      private String vf;

      public ItemScope build() {
         return new pd(this.aon, this.aoo, this.aop, this.aoq, this.aor, this.aos, this.aot, this.aou, this.aov, this.aow, this.aox, this.aoy, this.aoz, this.aoA, this.aoB, this.aoC, this.aoD, this.ov, this.aoE, this.aoF, this.aoG, this.aoH, this.UO, this.aoI, this.aoJ, this.aoK, this.aoL, this.aoM, this.aoN, this.aoO, this.aoP, this.CE, this.aoQ, this.aoR, this.agg, this.aoS, this.agh, this.mName, this.aoT, this.aoU, this.aoV, this.aoW, this.aoX, this.aoY, this.aoZ, this.apa, this.apb, this.apc, this.apd, this.ape, this.apf, this.vc, this.vf, this.apg, this.aph);
      }

      public ItemScope.Builder setAbout(ItemScope var1) {
         this.aoo = (pd)var1;
         this.aon.add(Integer.valueOf(2));
         return this;
      }

      public ItemScope.Builder setAdditionalName(List var1) {
         this.aop = var1;
         this.aon.add(Integer.valueOf(3));
         return this;
      }

      public ItemScope.Builder setAddress(ItemScope var1) {
         this.aoq = (pd)var1;
         this.aon.add(Integer.valueOf(4));
         return this;
      }

      public ItemScope.Builder setAddressCountry(String var1) {
         this.aor = var1;
         this.aon.add(Integer.valueOf(5));
         return this;
      }

      public ItemScope.Builder setAddressLocality(String var1) {
         this.aos = var1;
         this.aon.add(Integer.valueOf(6));
         return this;
      }

      public ItemScope.Builder setAddressRegion(String var1) {
         this.aot = var1;
         this.aon.add(Integer.valueOf(7));
         return this;
      }

      public ItemScope.Builder setAssociated_media(List var1) {
         this.aou = var1;
         this.aon.add(Integer.valueOf(8));
         return this;
      }

      public ItemScope.Builder setAttendeeCount(int var1) {
         this.aov = var1;
         this.aon.add(Integer.valueOf(9));
         return this;
      }

      public ItemScope.Builder setAttendees(List var1) {
         this.aow = var1;
         this.aon.add(Integer.valueOf(10));
         return this;
      }

      public ItemScope.Builder setAudio(ItemScope var1) {
         this.aox = (pd)var1;
         this.aon.add(Integer.valueOf(11));
         return this;
      }

      public ItemScope.Builder setAuthor(List var1) {
         this.aoy = var1;
         this.aon.add(Integer.valueOf(12));
         return this;
      }

      public ItemScope.Builder setBestRating(String var1) {
         this.aoz = var1;
         this.aon.add(Integer.valueOf(13));
         return this;
      }

      public ItemScope.Builder setBirthDate(String var1) {
         this.aoA = var1;
         this.aon.add(Integer.valueOf(14));
         return this;
      }

      public ItemScope.Builder setByArtist(ItemScope var1) {
         this.aoB = (pd)var1;
         this.aon.add(Integer.valueOf(15));
         return this;
      }

      public ItemScope.Builder setCaption(String var1) {
         this.aoC = var1;
         this.aon.add(Integer.valueOf(16));
         return this;
      }

      public ItemScope.Builder setContentSize(String var1) {
         this.aoD = var1;
         this.aon.add(Integer.valueOf(17));
         return this;
      }

      public ItemScope.Builder setContentUrl(String var1) {
         this.ov = var1;
         this.aon.add(Integer.valueOf(18));
         return this;
      }

      public ItemScope.Builder setContributor(List var1) {
         this.aoE = var1;
         this.aon.add(Integer.valueOf(19));
         return this;
      }

      public ItemScope.Builder setDateCreated(String var1) {
         this.aoF = var1;
         this.aon.add(Integer.valueOf(20));
         return this;
      }

      public ItemScope.Builder setDateModified(String var1) {
         this.aoG = var1;
         this.aon.add(Integer.valueOf(21));
         return this;
      }

      public ItemScope.Builder setDatePublished(String var1) {
         this.aoH = var1;
         this.aon.add(Integer.valueOf(22));
         return this;
      }

      public ItemScope.Builder setDescription(String var1) {
         this.UO = var1;
         this.aon.add(Integer.valueOf(23));
         return this;
      }

      public ItemScope.Builder setDuration(String var1) {
         this.aoI = var1;
         this.aon.add(Integer.valueOf(24));
         return this;
      }

      public ItemScope.Builder setEmbedUrl(String var1) {
         this.aoJ = var1;
         this.aon.add(Integer.valueOf(25));
         return this;
      }

      public ItemScope.Builder setEndDate(String var1) {
         this.aoK = var1;
         this.aon.add(Integer.valueOf(26));
         return this;
      }

      public ItemScope.Builder setFamilyName(String var1) {
         this.aoL = var1;
         this.aon.add(Integer.valueOf(27));
         return this;
      }

      public ItemScope.Builder setGender(String var1) {
         this.aoM = var1;
         this.aon.add(Integer.valueOf(28));
         return this;
      }

      public ItemScope.Builder setGeo(ItemScope var1) {
         this.aoN = (pd)var1;
         this.aon.add(Integer.valueOf(29));
         return this;
      }

      public ItemScope.Builder setGivenName(String var1) {
         this.aoO = var1;
         this.aon.add(Integer.valueOf(30));
         return this;
      }

      public ItemScope.Builder setHeight(String var1) {
         this.aoP = var1;
         this.aon.add(Integer.valueOf(31));
         return this;
      }

      public ItemScope.Builder setId(String var1) {
         this.CE = var1;
         this.aon.add(Integer.valueOf(32));
         return this;
      }

      public ItemScope.Builder setImage(String var1) {
         this.aoQ = var1;
         this.aon.add(Integer.valueOf(33));
         return this;
      }

      public ItemScope.Builder setInAlbum(ItemScope var1) {
         this.aoR = (pd)var1;
         this.aon.add(Integer.valueOf(34));
         return this;
      }

      public ItemScope.Builder setLatitude(double var1) {
         this.agg = var1;
         this.aon.add(Integer.valueOf(36));
         return this;
      }

      public ItemScope.Builder setLocation(ItemScope var1) {
         this.aoS = (pd)var1;
         this.aon.add(Integer.valueOf(37));
         return this;
      }

      public ItemScope.Builder setLongitude(double var1) {
         this.agh = var1;
         this.aon.add(Integer.valueOf(38));
         return this;
      }

      public ItemScope.Builder setName(String var1) {
         this.mName = var1;
         this.aon.add(Integer.valueOf(39));
         return this;
      }

      public ItemScope.Builder setPartOfTVSeries(ItemScope var1) {
         this.aoT = (pd)var1;
         this.aon.add(Integer.valueOf(40));
         return this;
      }

      public ItemScope.Builder setPerformers(List var1) {
         this.aoU = var1;
         this.aon.add(Integer.valueOf(41));
         return this;
      }

      public ItemScope.Builder setPlayerType(String var1) {
         this.aoV = var1;
         this.aon.add(Integer.valueOf(42));
         return this;
      }

      public ItemScope.Builder setPostOfficeBoxNumber(String var1) {
         this.aoW = var1;
         this.aon.add(Integer.valueOf(43));
         return this;
      }

      public ItemScope.Builder setPostalCode(String var1) {
         this.aoX = var1;
         this.aon.add(Integer.valueOf(44));
         return this;
      }

      public ItemScope.Builder setRatingValue(String var1) {
         this.aoY = var1;
         this.aon.add(Integer.valueOf(45));
         return this;
      }

      public ItemScope.Builder setReviewRating(ItemScope var1) {
         this.aoZ = (pd)var1;
         this.aon.add(Integer.valueOf(46));
         return this;
      }

      public ItemScope.Builder setStartDate(String var1) {
         this.apa = var1;
         this.aon.add(Integer.valueOf(47));
         return this;
      }

      public ItemScope.Builder setStreetAddress(String var1) {
         this.apb = var1;
         this.aon.add(Integer.valueOf(48));
         return this;
      }

      public ItemScope.Builder setText(String var1) {
         this.apc = var1;
         this.aon.add(Integer.valueOf(49));
         return this;
      }

      public ItemScope.Builder setThumbnail(ItemScope var1) {
         this.apd = (pd)var1;
         this.aon.add(Integer.valueOf(50));
         return this;
      }

      public ItemScope.Builder setThumbnailUrl(String var1) {
         this.ape = var1;
         this.aon.add(Integer.valueOf(51));
         return this;
      }

      public ItemScope.Builder setTickerSymbol(String var1) {
         this.apf = var1;
         this.aon.add(Integer.valueOf(52));
         return this;
      }

      public ItemScope.Builder setType(String var1) {
         this.vc = var1;
         this.aon.add(Integer.valueOf(53));
         return this;
      }

      public ItemScope.Builder setUrl(String var1) {
         this.vf = var1;
         this.aon.add(Integer.valueOf(54));
         return this;
      }

      public ItemScope.Builder setWidth(String var1) {
         this.apg = var1;
         this.aon.add(Integer.valueOf(55));
         return this;
      }

      public ItemScope.Builder setWorstRating(String var1) {
         this.aph = var1;
         this.aon.add(Integer.valueOf(56));
         return this;
      }
   }
}
