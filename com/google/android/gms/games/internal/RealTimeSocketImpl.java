package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl implements RealTimeSocket {
   private ParcelFileDescriptor LG;
   private final LocalSocket ZV;
   private final String Zk;

   RealTimeSocketImpl(LocalSocket var1, String var2) {
      this.ZV = var1;
      this.Zk = var2;
   }

   public void close() throws IOException {
      this.ZV.close();
   }

   public InputStream getInputStream() throws IOException {
      return this.ZV.getInputStream();
   }

   public OutputStream getOutputStream() throws IOException {
      return this.ZV.getOutputStream();
   }

   public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
      if(this.LG == null && !this.isClosed()) {
         Parcel var1 = Parcel.obtain();
         var1.writeFileDescriptor(this.ZV.getFileDescriptor());
         var1.setDataPosition(0);
         this.LG = var1.readFileDescriptor();
      }

      return this.LG;
   }

   public boolean isClosed() {
      return !this.ZV.isConnected() && !this.ZV.isBound();
   }
}
