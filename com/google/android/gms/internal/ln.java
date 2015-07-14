package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.lo;
import com.google.android.gms.internal.lq;
import java.util.Collections;

public class ln {
   public static final ln.c RA;
   public static final MetadataField RB;
   public static final com.google.android.gms.drive.metadata.b RC;
   public static final com.google.android.gms.drive.metadata.internal.m RD;
   public static final com.google.android.gms.drive.metadata.internal.m RE;
   public static final ln.d RF;
   public static final ln.e RG;
   public static final ln.f RH;
   public static final MetadataField RI;
   public static final ln.g RJ;
   public static final ln.h RK;
   public static final MetadataField RL;
   public static final MetadataField RM;
   public static final MetadataField RN;
   public static final com.google.android.gms.drive.metadata.internal.b RO;
   public static final MetadataField RP;
   public static final MetadataField Rj;
   public static final MetadataField Rk;
   public static final ln.a Rl;
   public static final MetadataField Rm;
   public static final MetadataField Rn;
   public static final MetadataField Ro;
   public static final MetadataField Rp;
   public static final MetadataField Rq;
   public static final MetadataField Rr;
   public static final MetadataField Rs;
   public static final MetadataField Rt;
   public static final MetadataField Ru;
   public static final ln.b Rv;
   public static final MetadataField Rw;
   public static final MetadataField Rx;
   public static final MetadataField Ry;
   public static final MetadataField Rz;

   static {
      Rj = lq.RV;
      Rk = new com.google.android.gms.drive.metadata.internal.l("alternateLink", 4300000);
      Rl = new ln.a(5000000);
      Rm = new com.google.android.gms.drive.metadata.internal.l("description", 4300000);
      Rn = new com.google.android.gms.drive.metadata.internal.l("embedLink", 4300000);
      Ro = new com.google.android.gms.drive.metadata.internal.l("fileExtension", 4300000);
      Rp = new com.google.android.gms.drive.metadata.internal.g("fileSize", 4300000);
      Rq = new com.google.android.gms.drive.metadata.internal.b("hasThumbnail", 4300000);
      Rr = new com.google.android.gms.drive.metadata.internal.l("indexableText", 4300000);
      Rs = new com.google.android.gms.drive.metadata.internal.b("isAppData", 4300000);
      Rt = new com.google.android.gms.drive.metadata.internal.b("isCopyable", 4300000);
      Ru = new com.google.android.gms.drive.metadata.internal.b("isEditable", 4100000);
      Rv = new ln.b("isPinned", 4100000);
      Rw = new com.google.android.gms.drive.metadata.internal.b("isRestricted", 4300000);
      Rx = new com.google.android.gms.drive.metadata.internal.b("isShared", 4300000);
      Ry = new com.google.android.gms.drive.metadata.internal.b("isTrashable", 4400000);
      Rz = new com.google.android.gms.drive.metadata.internal.b("isViewed", 4300000);
      RA = new ln.c("mimeType", 4100000);
      RB = new com.google.android.gms.drive.metadata.internal.l("originalFilename", 4300000);
      RC = new com.google.android.gms.drive.metadata.internal.k("ownerNames", 4300000);
      RD = new com.google.android.gms.drive.metadata.internal.m("lastModifyingUser", 6000000);
      RE = new com.google.android.gms.drive.metadata.internal.m("sharingUser", 6000000);
      RF = new ln.d("parents", 4100000);
      RG = new ln.e("quotaBytesUsed", 4300000);
      RH = new ln.f("starred", 4100000);
      RI = new com.google.android.gms.drive.metadata.internal.j("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
         // $FF: synthetic method
         protected Object c(DataHolder var1, int var2, int var3) {
            return this.k(var1, var2, var3);
         }

         protected com.google.android.gms.common.data.a k(DataHolder var1, int var2, int var3) {
            throw new IllegalStateException("Thumbnail field is write only");
         }
      };
      RJ = new ln.g("title", 4100000);
      RK = new ln.h("trashed", 4100000);
      RL = new com.google.android.gms.drive.metadata.internal.l("webContentLink", 4300000);
      RM = new com.google.android.gms.drive.metadata.internal.l("webViewLink", 4300000);
      RN = new com.google.android.gms.drive.metadata.internal.l("uniqueIdentifier", 5000000);
      RO = new com.google.android.gms.drive.metadata.internal.b("writersCanShare", 6000000);
      RP = new com.google.android.gms.drive.metadata.internal.l("role", 6000000);
   }

   public static class a extends lo implements SearchableMetadataField {
      public a(int var1) {
         super(var1);
      }
   }

   public static class b extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField {
      public b(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class c extends com.google.android.gms.drive.metadata.internal.l implements SearchableMetadataField {
      public c(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class d extends com.google.android.gms.drive.metadata.internal.i implements SearchableCollectionMetadataField {
      public d(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class e extends com.google.android.gms.drive.metadata.internal.g implements SortableMetadataField {
      public e(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class f extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField {
      public f(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class g extends com.google.android.gms.drive.metadata.internal.l implements SearchableMetadataField, SortableMetadataField {
      public g(String var1, int var2) {
         super(var1, var2);
      }
   }

   public static class h extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField {
      public h(String var1, int var2) {
         super(var1, var2);
      }

      // $FF: synthetic method
      protected Object c(DataHolder var1, int var2, int var3) {
         return this.e(var1, var2, var3);
      }

      protected Boolean e(DataHolder var1, int var2, int var3) {
         boolean var4;
         if(var1.b(this.getName(), var2, var3) != 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         return Boolean.valueOf(var4);
      }
   }
}
