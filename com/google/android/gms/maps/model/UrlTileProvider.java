package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
   private final int li;
   private final int lj;

   public UrlTileProvider(int var1, int var2) {
      this.li = var1;
      this.lj = var2;
   }

   private static long a(InputStream var0, OutputStream var1) throws IOException {
      byte[] var5 = new byte[4096];
      long var3 = 0L;

      while(true) {
         int var2 = var0.read(var5);
         if(var2 == -1) {
            return var3;
         }

         var1.write(var5, 0, var2);
         var3 += (long)var2;
      }
   }

   private static byte[] e(InputStream var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      a(var0, var1);
      return var1.toByteArray();
   }

   public final Tile getTile(int var1, int var2, int var3) {
      URL var4 = this.getTileUrl(var1, var2, var3);
      if(var4 == null) {
         return NO_TILE;
      } else {
         try {
            Tile var6 = new Tile(this.li, this.lj, e(var4.openStream()));
            return var6;
         } catch (IOException var5) {
            return null;
         }
      }
   }

   public abstract URL getTileUrl(int var1, int var2, int var3);
}
