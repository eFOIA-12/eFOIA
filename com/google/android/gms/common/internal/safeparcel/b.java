package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class b {
   private static int F(Parcel var0, int var1) {
      var0.writeInt(-65536 | var1);
      var0.writeInt(0);
      return var0.dataPosition();
   }

   private static void G(Parcel var0, int var1) {
      int var2 = var0.dataPosition();
      var0.setDataPosition(var1 - 4);
      var0.writeInt(var2 - var1);
      var0.setDataPosition(var2);
   }

   public static int H(Parcel var0) {
      return F(var0, 20293);
   }

   public static void H(Parcel var0, int var1) {
      G(var0, var1);
   }

   public static void a(Parcel var0, int var1, byte var2) {
      b(var0, var1, 4);
      var0.writeInt(var2);
   }

   public static void a(Parcel var0, int var1, double var2) {
      b(var0, var1, 8);
      var0.writeDouble(var2);
   }

   public static void a(Parcel var0, int var1, float var2) {
      b(var0, var1, 4);
      var0.writeFloat(var2);
   }

   public static void a(Parcel var0, int var1, long var2) {
      b(var0, var1, 8);
      var0.writeLong(var2);
   }

   public static void a(Parcel var0, int var1, Bundle var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeBundle(var2);
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, IBinder var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeStrongBinder(var2);
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, Parcel var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.appendFrom(var2, 0, var2.dataSize());
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, Parcelable var2, int var3, boolean var4) {
      if(var2 == null) {
         if(var4) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var2.writeToParcel(var0, var3);
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, Boolean var2, boolean var3) {
      byte var4 = 0;
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         b(var0, var1, 4);
         byte var5 = var4;
         if(var2.booleanValue()) {
            var5 = 1;
         }

         var0.writeInt(var5);
      }
   }

   public static void a(Parcel var0, int var1, Integer var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         b(var0, var1, 4);
         var0.writeInt(var2.intValue());
      }
   }

   public static void a(Parcel var0, int var1, Long var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         b(var0, var1, 8);
         var0.writeLong(var2.longValue());
      }
   }

   public static void a(Parcel var0, int var1, String var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeString(var2);
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, List var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         int var4 = F(var0, var1);
         int var5 = var2.size();
         var0.writeInt(var5);

         for(var1 = 0; var1 < var5; ++var1) {
            var0.writeInt(((Integer)var2.get(var1)).intValue());
         }

         G(var0, var4);
      }
   }

   public static void a(Parcel var0, int var1, short var2) {
      b(var0, var1, 4);
      var0.writeInt(var2);
   }

   public static void a(Parcel var0, int var1, boolean var2) {
      b(var0, var1, 4);
      byte var3;
      if(var2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var0.writeInt(var3);
   }

   public static void a(Parcel var0, int var1, byte[] var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeByteArray(var2);
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, int[] var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeIntArray(var2);
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, Parcelable[] var2, int var3, boolean var4) {
      if(var2 == null) {
         if(var4) {
            b(var0, var1, 0);
         }

      } else {
         int var5 = F(var0, var1);
         int var6 = var2.length;
         var0.writeInt(var6);

         for(var1 = 0; var1 < var6; ++var1) {
            Parcelable var7 = var2[var1];
            if(var7 == null) {
               var0.writeInt(0);
            } else {
               a(var0, var7, var3);
            }
         }

         G(var0, var5);
      }
   }

   public static void a(Parcel var0, int var1, String[] var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeStringArray(var2);
         G(var0, var1);
      }
   }

   public static void a(Parcel var0, int var1, byte[][] var2, boolean var3) {
      byte var4 = 0;
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         int var5 = F(var0, var1);
         int var6 = var2.length;
         var0.writeInt(var6);

         for(var1 = var4; var1 < var6; ++var1) {
            var0.writeByteArray(var2[var1]);
         }

         G(var0, var5);
      }
   }

   private static void a(Parcel var0, Parcelable var1, int var2) {
      int var3 = var0.dataPosition();
      var0.writeInt(1);
      int var4 = var0.dataPosition();
      var1.writeToParcel(var0, var2);
      var2 = var0.dataPosition();
      var0.setDataPosition(var3);
      var0.writeInt(var2 - var4);
      var0.setDataPosition(var2);
   }

   private static void b(Parcel var0, int var1, int var2) {
      if(var2 >= '\uffff') {
         var0.writeInt(-65536 | var1);
         var0.writeInt(var2);
      } else {
         var0.writeInt(var2 << 16 | var1);
      }
   }

   public static void b(Parcel var0, int var1, List var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeStringList(var2);
         G(var0, var1);
      }
   }

   public static void c(Parcel var0, int var1, int var2) {
      b(var0, var1, 4);
      var0.writeInt(var2);
   }

   public static void c(Parcel var0, int var1, List var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         int var4 = F(var0, var1);
         int var5 = var2.size();
         var0.writeInt(var5);

         for(var1 = 0; var1 < var5; ++var1) {
            Parcelable var6 = (Parcelable)var2.get(var1);
            if(var6 == null) {
               var0.writeInt(0);
            } else {
               a(var0, var6, 0);
            }
         }

         G(var0, var4);
      }
   }

   public static void d(Parcel var0, int var1, List var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            b(var0, var1, 0);
         }

      } else {
         var1 = F(var0, var1);
         var0.writeList(var2);
         G(var0, var1);
      }
   }
}
