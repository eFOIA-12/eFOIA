package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
   public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
   public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
   public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
   public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
   public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
   public static final MetadataChangeSet OE = new MetadataChangeSet(MetadataBundle.iZ());
   private final MetadataBundle OF;

   public MetadataChangeSet(MetadataBundle var1) {
      this.OF = MetadataBundle.a(var1);
   }

   public Map getCustomPropertyChangeMap() {
      AppVisibleCustomProperties var1 = (AppVisibleCustomProperties)this.OF.a((MetadataField)ln.Rl);
      return var1 == null?Collections.emptyMap():var1.iV();
   }

   public String getDescription() {
      return (String)this.OF.a(ln.Rm);
   }

   public String getIndexableText() {
      return (String)this.OF.a(ln.Rr);
   }

   public Date getLastViewedByMeDate() {
      return (Date)this.OF.a((MetadataField)lp.RR);
   }

   public String getMimeType() {
      return (String)this.OF.a((MetadataField)ln.RA);
   }

   public String getTitle() {
      return (String)this.OF.a((MetadataField)ln.RJ);
   }

   public Boolean isPinned() {
      return (Boolean)this.OF.a((MetadataField)ln.Rv);
   }

   public Boolean isStarred() {
      return (Boolean)this.OF.a((MetadataField)ln.RH);
   }

   public Boolean isViewed() {
      return (Boolean)this.OF.a(ln.Rz);
   }

   public MetadataBundle iz() {
      return this.OF;
   }

   public static class Builder {
      private final MetadataBundle OF = MetadataBundle.iZ();
      private AppVisibleCustomProperties.a OG;

      private int bk(String var1) {
         return var1 == null?0:var1.getBytes().length;
      }

      private String i(String var1, int var2, int var3) {
         return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{var1, Integer.valueOf(var2), Integer.valueOf(var3)});
      }

      private AppVisibleCustomProperties.a iA() {
         if(this.OG == null) {
            this.OG = new AppVisibleCustomProperties.a();
         }

         return this.OG;
      }

      private void j(String var1, int var2, int var3) {
         boolean var4;
         if(var3 <= var2) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, this.i(var1, var2, var3));
      }

      public MetadataChangeSet build() {
         if(this.OG != null) {
            this.OF.b(ln.Rl, this.OG.iW());
         }

         return new MetadataChangeSet(this.OF);
      }

      public MetadataChangeSet.Builder deleteCustomProperty(CustomPropertyKey var1) {
         jx.b((Object)var1, "key");
         this.iA().a(var1, (String)null);
         return this;
      }

      public MetadataChangeSet.Builder setCustomProperty(CustomPropertyKey var1, String var2) {
         jx.b((Object)var1, "key");
         jx.b((Object)var2, "value");
         this.j("The total size of key string and value string of a custom property", 124, this.bk(var1.getKey()) + this.bk(var2));
         this.iA().a(var1, var2);
         return this;
      }

      public MetadataChangeSet.Builder setDescription(String var1) {
         this.OF.b(ln.Rm, var1);
         return this;
      }

      public MetadataChangeSet.Builder setIndexableText(String var1) {
         this.j("Indexable text size", 131072, this.bk(var1));
         this.OF.b(ln.Rr, var1);
         return this;
      }

      public MetadataChangeSet.Builder setLastViewedByMeDate(Date var1) {
         this.OF.b(lp.RR, var1);
         return this;
      }

      public MetadataChangeSet.Builder setMimeType(String var1) {
         this.OF.b(ln.RA, var1);
         return this;
      }

      public MetadataChangeSet.Builder setPinned(boolean var1) {
         this.OF.b(ln.Rv, Boolean.valueOf(var1));
         return this;
      }

      public MetadataChangeSet.Builder setStarred(boolean var1) {
         this.OF.b(ln.RH, Boolean.valueOf(var1));
         return this;
      }

      public MetadataChangeSet.Builder setTitle(String var1) {
         this.OF.b(ln.RJ, var1);
         return this;
      }

      public MetadataChangeSet.Builder setViewed(boolean var1) {
         this.OF.b(ln.Rz, Boolean.valueOf(var1));
         return this;
      }
   }
}
