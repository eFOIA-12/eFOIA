package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.b;
import com.google.android.gms.drive.internal.ah;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.lh;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
   public static final Creator CREATOR = new b();
   public static final int STATUS_CANCELED = 3;
   public static final int STATUS_CONFLICT = 2;
   public static final int STATUS_FAILURE = 1;
   public static final int STATUS_SUCCESS = 0;
   final int CK;
   final String DZ;
   final int FP;
   final ParcelFileDescriptor OY;
   final ParcelFileDescriptor OZ;
   final DriveId Oj;
   final MetadataBundle Pa;
   final List Pb;
   final IBinder Pc;
   private boolean Pd = false;
   private boolean Pe = false;
   private boolean Pf = false;

   CompletionEvent(int var1, DriveId var2, String var3, ParcelFileDescriptor var4, ParcelFileDescriptor var5, MetadataBundle var6, List var7, int var8, IBinder var9) {
      this.CK = var1;
      this.Oj = var2;
      this.DZ = var3;
      this.OY = var4;
      this.OZ = var5;
      this.Pa = var6;
      this.Pb = var7;
      this.FP = var8;
      this.Pc = var9;
   }

   private void M(boolean var1) {
      this.iC();
      this.Pf = true;
      lh.a(this.OY);
      lh.a(this.OZ);
      String var2;
      if(this.Pc == null) {
         StringBuilder var3 = (new StringBuilder()).append("No callback on ");
         if(var1) {
            var2 = "snooze";
         } else {
            var2 = "dismiss";
         }

         w.p("CompletionEvent", var3.append(var2).toString());
      } else {
         try {
            ah.a.aa(this.Pc).M(var1);
         } catch (RemoteException var5) {
            StringBuilder var4 = (new StringBuilder()).append("RemoteException on ");
            if(var1) {
               var2 = "snooze";
            } else {
               var2 = "dismiss";
            }

            w.p("CompletionEvent", var4.append(var2).append(": ").append(var5).toString());
         }
      }
   }

   private void iC() {
      if(this.Pf) {
         throw new IllegalStateException("Event has already been dismissed or snoozed.");
      }
   }

   public int describeContents() {
      return 0;
   }

   public void dismiss() {
      this.M(false);
   }

   public String getAccountName() {
      this.iC();
      return this.DZ;
   }

   public InputStream getBaseContentsInputStream() {
      this.iC();
      if(this.OY == null) {
         return null;
      } else if(this.Pd) {
         throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
      } else {
         this.Pd = true;
         return new FileInputStream(this.OY.getFileDescriptor());
      }
   }

   public DriveId getDriveId() {
      this.iC();
      return this.Oj;
   }

   public InputStream getModifiedContentsInputStream() {
      this.iC();
      if(this.OZ == null) {
         return null;
      } else if(this.Pe) {
         throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
      } else {
         this.Pe = true;
         return new FileInputStream(this.OZ.getFileDescriptor());
      }
   }

   public MetadataChangeSet getModifiedMetadataChangeSet() {
      this.iC();
      return this.Pa != null?new MetadataChangeSet(this.Pa):null;
   }

   public int getStatus() {
      this.iC();
      return this.FP;
   }

   public List getTrackingTags() {
      this.iC();
      return new ArrayList(this.Pb);
   }

   public int getType() {
      return 2;
   }

   public void snooze() {
      this.M(true);
   }

   public String toString() {
      String var1;
      if(this.Pb == null) {
         var1 = "<null>";
      } else {
         var1 = "\'" + TextUtils.join("\',\'", this.Pb) + "\'";
      }

      return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.Oj, Integer.valueOf(this.FP), var1});
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
