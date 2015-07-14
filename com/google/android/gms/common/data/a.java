package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class a implements SafeParcelable {
   public static final Creator CREATOR = new b();
   final int CK;
   final int Gt;
   ParcelFileDescriptor KS;
   private Bitmap KT;
   private boolean KU;
   private File KV;

   a(int var1, ParcelFileDescriptor var2, int var3) {
      this.CK = var1;
      this.KS = var2;
      this.Gt = var3;
      this.KT = null;
      this.KU = false;
   }

   public a(Bitmap var1) {
      this.CK = 1;
      this.KS = null;
      this.Gt = 0;
      this.KT = var1;
      this.KU = true;
   }

   private void a(Closeable var1) {
      try {
         var1.close();
      } catch (IOException var2) {
         Log.w("BitmapTeleporter", "Could not close stream", var2);
      }
   }

   private FileOutputStream gU() {
      if(this.KV == null) {
         throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
      } else {
         File var1;
         try {
            var1 = File.createTempFile("teleporter", ".tmp", this.KV);
         } catch (IOException var4) {
            throw new IllegalStateException("Could not create temporary file", var4);
         }

         FileOutputStream var2;
         try {
            var2 = new FileOutputStream(var1);
            this.KS = ParcelFileDescriptor.open(var1, 268435456);
         } catch (FileNotFoundException var3) {
            throw new IllegalStateException("Temporary file is somehow already deleted");
         }

         var1.delete();
         return var2;
      }
   }

   public void a(File var1) {
      if(var1 == null) {
         throw new NullPointerException("Cannot set null temp directory");
      } else {
         this.KV = var1;
      }
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap gT() {
      if(!this.KU) {
         DataInputStream var3 = new DataInputStream(new AutoCloseInputStream(this.KS));

         int var1;
         int var2;
         Config var4;
         byte[] var5;
         try {
            var5 = new byte[var3.readInt()];
            var1 = var3.readInt();
            var2 = var3.readInt();
            var4 = Config.valueOf(var3.readUTF());
            var3.read(var5);
         } catch (IOException var8) {
            throw new IllegalStateException("Could not read from parcel file descriptor", var8);
         } finally {
            this.a((Closeable)var3);
         }

         ByteBuffer var10 = ByteBuffer.wrap(var5);
         Bitmap var11 = Bitmap.createBitmap(var1, var2, var4);
         var11.copyPixelsFromBuffer(var10);
         this.KT = var11;
         this.KU = true;
      }

      return this.KT;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.KS == null) {
         Bitmap var4 = this.KT;
         ByteBuffer var3 = ByteBuffer.allocate(var4.getRowBytes() * var4.getHeight());
         var4.copyPixelsToBuffer(var3);
         byte[] var5 = var3.array();
         DataOutputStream var10 = new DataOutputStream(this.gU());

         try {
            var10.writeInt(var5.length);
            var10.writeInt(var4.getWidth());
            var10.writeInt(var4.getHeight());
            var10.writeUTF(var4.getConfig().toString());
            var10.write(var5);
         } catch (IOException var8) {
            throw new IllegalStateException("Could not write into unlinked file", var8);
         } finally {
            this.a((Closeable)var10);
         }
      }

      b.a(this, var1, var2);
   }
}
