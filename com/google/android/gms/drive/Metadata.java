package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import com.google.android.gms.internal.lr;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable {
   public static final int CONTENT_AVAILABLE_LOCALLY = 1;
   public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

   protected abstract Object a(MetadataField var1);

   public String getAlternateLink() {
      return (String)this.a(ln.Rk);
   }

   public int getContentAvailability() {
      Integer var1 = (Integer)this.a(lr.RW);
      return var1 == null?0:var1.intValue();
   }

   public Date getCreatedDate() {
      return (Date)this.a(lp.RQ);
   }

   public Map getCustomProperties() {
      AppVisibleCustomProperties var1 = (AppVisibleCustomProperties)this.a(ln.Rl);
      return var1 == null?Collections.emptyMap():var1.iV();
   }

   public String getDescription() {
      return (String)this.a(ln.Rm);
   }

   public DriveId getDriveId() {
      return (DriveId)this.a(ln.Rj);
   }

   public String getEmbedLink() {
      return (String)this.a(ln.Rn);
   }

   public String getFileExtension() {
      return (String)this.a(ln.Ro);
   }

   public long getFileSize() {
      return ((Long)this.a(ln.Rp)).longValue();
   }

   public Date getLastViewedByMeDate() {
      return (Date)this.a(lp.RR);
   }

   public String getMimeType() {
      return (String)this.a(ln.RA);
   }

   public Date getModifiedByMeDate() {
      return (Date)this.a(lp.RT);
   }

   public Date getModifiedDate() {
      return (Date)this.a(lp.RS);
   }

   public String getOriginalFilename() {
      return (String)this.a(ln.RB);
   }

   public long getQuotaBytesUsed() {
      return ((Long)this.a(ln.RG)).longValue();
   }

   public Date getSharedWithMeDate() {
      return (Date)this.a(lp.RU);
   }

   public String getTitle() {
      return (String)this.a(ln.RJ);
   }

   public String getWebContentLink() {
      return (String)this.a(ln.RL);
   }

   public String getWebViewLink() {
      return (String)this.a(ln.RM);
   }

   public boolean isEditable() {
      Boolean var1 = (Boolean)this.a(ln.Ru);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isFolder() {
      return "application/vnd.google-apps.folder".equals(this.getMimeType());
   }

   public boolean isInAppFolder() {
      Boolean var1 = (Boolean)this.a(ln.Rs);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isPinnable() {
      Boolean var1 = (Boolean)this.a(lr.RX);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isPinned() {
      Boolean var1 = (Boolean)this.a(ln.Rv);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isRestricted() {
      Boolean var1 = (Boolean)this.a(ln.Rw);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isShared() {
      Boolean var1 = (Boolean)this.a(ln.Rx);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isStarred() {
      Boolean var1 = (Boolean)this.a(ln.RH);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isTrashed() {
      Boolean var1 = (Boolean)this.a(ln.RK);
      return var1 == null?false:var1.booleanValue();
   }

   public boolean isViewed() {
      Boolean var1 = (Boolean)this.a(ln.Rz);
      return var1 == null?false:var1.booleanValue();
   }
}
