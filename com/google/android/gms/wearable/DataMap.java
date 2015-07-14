package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.ql;
import com.google.android.gms.internal.qm;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import com.google.android.gms.wearable.Asset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap {
   public static final String TAG = "DataMap";
   private final HashMap axg = new HashMap();

   private static void a(Bundle var0, String var1, Object var2) {
      if(var2 instanceof String) {
         var0.putString(var1, (String)var2);
      } else {
         if(var2 instanceof Integer) {
            var0.putInt(var1, ((Integer)var2).intValue());
            return;
         }

         if(var2 instanceof Long) {
            var0.putLong(var1, ((Long)var2).longValue());
            return;
         }

         if(var2 instanceof Double) {
            var0.putDouble(var1, ((Double)var2).doubleValue());
            return;
         }

         if(var2 instanceof Float) {
            var0.putFloat(var1, ((Float)var2).floatValue());
            return;
         }

         if(var2 instanceof Boolean) {
            var0.putBoolean(var1, ((Boolean)var2).booleanValue());
            return;
         }

         if(var2 instanceof Byte) {
            var0.putByte(var1, ((Byte)var2).byteValue());
            return;
         }

         if(var2 instanceof byte[]) {
            var0.putByteArray(var1, (byte[])((byte[])var2));
            return;
         }

         if(var2 instanceof String[]) {
            var0.putStringArray(var1, (String[])((String[])var2));
            return;
         }

         if(var2 instanceof long[]) {
            var0.putLongArray(var1, (long[])((long[])var2));
            return;
         }

         if(var2 instanceof float[]) {
            var0.putFloatArray(var1, (float[])((float[])var2));
            return;
         }

         if(var2 instanceof Asset) {
            var0.putParcelable(var1, (Asset)var2);
            return;
         }

         if(var2 instanceof DataMap) {
            var0.putParcelable(var1, ((DataMap)var2).toBundle());
            return;
         }

         if(var2 instanceof ArrayList) {
            switch(d((ArrayList)var2)) {
            case 0:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 1:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 2:
               var0.putIntegerArrayList(var1, (ArrayList)var2);
               return;
            case 3:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 4:
               ArrayList var3 = new ArrayList();
               Iterator var4 = ((ArrayList)var2).iterator();

               while(var4.hasNext()) {
                  var3.add(((DataMap)var4.next()).toBundle());
               }

               var0.putParcelableArrayList(var1, var3);
               return;
            default:
               return;
            }
         }
      }

   }

   private static void a(DataMap var0, String var1, Object var2) {
      if(var2 instanceof String) {
         var0.putString(var1, (String)var2);
      } else {
         if(var2 instanceof Integer) {
            var0.putInt(var1, ((Integer)var2).intValue());
            return;
         }

         if(var2 instanceof Long) {
            var0.putLong(var1, ((Long)var2).longValue());
            return;
         }

         if(var2 instanceof Double) {
            var0.putDouble(var1, ((Double)var2).doubleValue());
            return;
         }

         if(var2 instanceof Float) {
            var0.putFloat(var1, ((Float)var2).floatValue());
            return;
         }

         if(var2 instanceof Boolean) {
            var0.putBoolean(var1, ((Boolean)var2).booleanValue());
            return;
         }

         if(var2 instanceof Byte) {
            var0.putByte(var1, ((Byte)var2).byteValue());
            return;
         }

         if(var2 instanceof byte[]) {
            var0.putByteArray(var1, (byte[])((byte[])var2));
            return;
         }

         if(var2 instanceof String[]) {
            var0.putStringArray(var1, (String[])((String[])var2));
            return;
         }

         if(var2 instanceof long[]) {
            var0.putLongArray(var1, (long[])((long[])var2));
            return;
         }

         if(var2 instanceof float[]) {
            var0.putFloatArray(var1, (float[])((float[])var2));
            return;
         }

         if(var2 instanceof Asset) {
            var0.putAsset(var1, (Asset)var2);
            return;
         }

         if(var2 instanceof Bundle) {
            var0.putDataMap(var1, fromBundle((Bundle)var2));
            return;
         }

         if(var2 instanceof ArrayList) {
            switch(d((ArrayList)var2)) {
            case 0:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 1:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 2:
               var0.putIntegerArrayList(var1, (ArrayList)var2);
               return;
            case 3:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 4:
            default:
               return;
            case 5:
               var0.putDataMapArrayList(var1, arrayListFromBundleArrayList((ArrayList)var2));
               return;
            }
         }
      }

   }

   private void a(String var1, Object var2, String var3, ClassCastException var4) {
      this.a(var1, var2, var3, "<null>", var4);
   }

   private void a(String var1, Object var2, String var3, Object var4, ClassCastException var5) {
      StringBuilder var6 = new StringBuilder();
      var6.append("Key ");
      var6.append(var1);
      var6.append(" expected ");
      var6.append(var3);
      var6.append(" but value was a ");
      var6.append(var2.getClass().getName());
      var6.append(".  The default value ");
      var6.append(var4);
      var6.append(" was returned.");
      Log.w("DataMap", var6.toString());
      Log.w("DataMap", "Attempt to cast generated internal exception:", var5);
   }

   private static boolean a(Asset var0, Asset var1) {
      return var0 != null && var1 != null?(!TextUtils.isEmpty(var0.getDigest())?var0.getDigest().equals(var1.getDigest()):Arrays.equals(var0.getData(), var1.getData())):var0 == var1;
   }

   private static boolean a(DataMap var0, DataMap var1) {
      if(var0.size() == var1.size()) {
         Iterator var3 = var0.keySet().iterator();

         while(true) {
            if(!var3.hasNext()) {
               return true;
            }

            String var5 = (String)var3.next();
            Object var4 = var0.get(var5);
            Object var6 = var1.get(var5);
            if(var4 instanceof Asset) {
               if(!(var6 instanceof Asset)) {
                  break;
               }

               if(!a((Asset)var4, (Asset)var6)) {
                  return false;
               }
            } else if(var4 instanceof String[]) {
               if(!(var6 instanceof String[])) {
                  break;
               }

               if(!Arrays.equals((String[])((String[])var4), (String[])((String[])var6))) {
                  return false;
               }
            } else if(var4 instanceof long[]) {
               if(!(var6 instanceof long[])) {
                  break;
               }

               if(!Arrays.equals((long[])((long[])var4), (long[])((long[])var6))) {
                  return false;
               }
            } else if(var4 instanceof float[]) {
               if(!(var6 instanceof float[])) {
                  break;
               }

               if(!Arrays.equals((float[])((float[])var4), (float[])((float[])var6))) {
                  return false;
               }
            } else if(var4 instanceof byte[]) {
               if(!(var6 instanceof byte[])) {
                  break;
               }

               if(!Arrays.equals((byte[])((byte[])var4), (byte[])((byte[])var6))) {
                  return false;
               }
            } else {
               if(var4 == null || var6 == null) {
                  boolean var2;
                  if(var4 == var6) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  return var2;
               }

               if(!var4.equals(var6)) {
                  return false;
               }
            }
         }
      }

      return false;
   }

   public static ArrayList arrayListFromBundleArrayList(ArrayList var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(fromBundle((Bundle)var2.next()));
      }

      return var1;
   }

   private static int d(ArrayList var0) {
      if(var0.isEmpty()) {
         return 0;
      } else {
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            Object var1 = var2.next();
            if(var1 != null) {
               if(var1 instanceof Integer) {
                  return 2;
               }

               if(var1 instanceof String) {
                  return 3;
               }

               if(var1 instanceof DataMap) {
                  return 4;
               }

               if(var1 instanceof Bundle) {
                  return 5;
               }
            }
         }

         return 1;
      }
   }

   public static DataMap fromBundle(Bundle var0) {
      var0.setClassLoader(Asset.class.getClassLoader());
      DataMap var1 = new DataMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         a(var1, var3, var0.get(var3));
      }

      return var1;
   }

   public static DataMap fromByteArray(byte[] var0) {
      try {
         DataMap var2 = ql.a(new ql.a(qm.n(var0), new ArrayList()));
         return var2;
      } catch (qv var1) {
         throw new IllegalArgumentException("Unable to convert data", var1);
      }
   }

   public void clear() {
      this.axg.clear();
   }

   public boolean containsKey(String var1) {
      return this.axg.containsKey(var1);
   }

   public boolean equals(Object var1) {
      return !(var1 instanceof DataMap)?false:a(this, (DataMap)var1);
   }

   public Object get(String var1) {
      return this.axg.get(var1);
   }

   public Asset getAsset(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            Asset var3 = (Asset)var2;
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "Asset", var4);
            return null;
         }
      }
   }

   public boolean getBoolean(String var1) {
      return this.getBoolean(var1, false);
   }

   public boolean getBoolean(String var1, boolean var2) {
      Object var4 = this.axg.get(var1);
      if(var4 == null) {
         return var2;
      } else {
         try {
            boolean var3 = ((Boolean)var4).booleanValue();
            return var3;
         } catch (ClassCastException var6) {
            this.a(var1, var4, "Boolean", Boolean.valueOf(var2), var6);
            return var2;
         }
      }
   }

   public byte getByte(String var1) {
      return this.getByte(var1, (byte)0);
   }

   public byte getByte(String var1, byte var2) {
      Object var4 = this.axg.get(var1);
      if(var4 == null) {
         return var2;
      } else {
         try {
            byte var3 = ((Byte)var4).byteValue();
            return var3;
         } catch (ClassCastException var6) {
            this.a(var1, var4, "Byte", Byte.valueOf(var2), var6);
            return var2;
         }
      }
   }

   public byte[] getByteArray(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            byte[] var3 = (byte[])((byte[])var2);
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "byte[]", var4);
            return null;
         }
      }
   }

   public DataMap getDataMap(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            DataMap var3 = (DataMap)var2;
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "DataMap", var4);
            return null;
         }
      }
   }

   public ArrayList getDataMapArrayList(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            ArrayList var3 = (ArrayList)var2;
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "ArrayList<DataMap>", var4);
            return null;
         }
      }
   }

   public double getDouble(String var1) {
      return this.getDouble(var1, 0.0D);
   }

   public double getDouble(String var1, double var2) {
      Object var6 = this.axg.get(var1);
      if(var6 == null) {
         return var2;
      } else {
         try {
            double var4 = ((Double)var6).doubleValue();
            return var4;
         } catch (ClassCastException var8) {
            this.a(var1, var6, "Double", Double.valueOf(var2), var8);
            return var2;
         }
      }
   }

   public float getFloat(String var1) {
      return this.getFloat(var1, 0.0F);
   }

   public float getFloat(String var1, float var2) {
      Object var4 = this.axg.get(var1);
      if(var4 == null) {
         return var2;
      } else {
         try {
            float var3 = ((Float)var4).floatValue();
            return var3;
         } catch (ClassCastException var6) {
            this.a(var1, var4, "Float", Float.valueOf(var2), var6);
            return var2;
         }
      }
   }

   public float[] getFloatArray(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            float[] var3 = (float[])((float[])var2);
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "float[]", var4);
            return null;
         }
      }
   }

   public int getInt(String var1) {
      return this.getInt(var1, 0);
   }

   public int getInt(String var1, int var2) {
      Object var4 = this.axg.get(var1);
      if(var4 == null) {
         return var2;
      } else {
         try {
            int var3 = ((Integer)var4).intValue();
            return var3;
         } catch (ClassCastException var6) {
            this.a(var1, var4, "Integer", var6);
            return var2;
         }
      }
   }

   public ArrayList getIntegerArrayList(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            ArrayList var3 = (ArrayList)var2;
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "ArrayList<Integer>", var4);
            return null;
         }
      }
   }

   public long getLong(String var1) {
      return this.getLong(var1, 0L);
   }

   public long getLong(String var1, long var2) {
      Object var6 = this.axg.get(var1);
      if(var6 == null) {
         return var2;
      } else {
         try {
            long var4 = ((Long)var6).longValue();
            return var4;
         } catch (ClassCastException var8) {
            this.a(var1, var6, "long", var8);
            return var2;
         }
      }
   }

   public long[] getLongArray(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            long[] var3 = (long[])((long[])var2);
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "long[]", var4);
            return null;
         }
      }
   }

   public String getString(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            String var3 = (String)var2;
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "String", var4);
            return null;
         }
      }
   }

   public String getString(String var1, String var2) {
      var1 = this.getString(var1);
      return var1 == null?var2:var1;
   }

   public String[] getStringArray(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            String[] var3 = (String[])((String[])var2);
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "String[]", var4);
            return null;
         }
      }
   }

   public ArrayList getStringArrayList(String var1) {
      Object var2 = this.axg.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            ArrayList var3 = (ArrayList)var2;
            return var3;
         } catch (ClassCastException var4) {
            this.a(var1, var2, "ArrayList<String>", var4);
            return null;
         }
      }
   }

   public int hashCode() {
      return this.axg.hashCode() * 29;
   }

   public boolean isEmpty() {
      return this.axg.isEmpty();
   }

   public Set keySet() {
      return this.axg.keySet();
   }

   public void putAll(DataMap var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.axg.put(var3, var1.get(var3));
      }

   }

   public void putAsset(String var1, Asset var2) {
      this.axg.put(var1, var2);
   }

   public void putBoolean(String var1, boolean var2) {
      this.axg.put(var1, Boolean.valueOf(var2));
   }

   public void putByte(String var1, byte var2) {
      this.axg.put(var1, Byte.valueOf(var2));
   }

   public void putByteArray(String var1, byte[] var2) {
      this.axg.put(var1, var2);
   }

   public void putDataMap(String var1, DataMap var2) {
      this.axg.put(var1, var2);
   }

   public void putDataMapArrayList(String var1, ArrayList var2) {
      this.axg.put(var1, var2);
   }

   public void putDouble(String var1, double var2) {
      this.axg.put(var1, Double.valueOf(var2));
   }

   public void putFloat(String var1, float var2) {
      this.axg.put(var1, Float.valueOf(var2));
   }

   public void putFloatArray(String var1, float[] var2) {
      this.axg.put(var1, var2);
   }

   public void putInt(String var1, int var2) {
      this.axg.put(var1, Integer.valueOf(var2));
   }

   public void putIntegerArrayList(String var1, ArrayList var2) {
      this.axg.put(var1, var2);
   }

   public void putLong(String var1, long var2) {
      this.axg.put(var1, Long.valueOf(var2));
   }

   public void putLongArray(String var1, long[] var2) {
      this.axg.put(var1, var2);
   }

   public void putString(String var1, String var2) {
      this.axg.put(var1, var2);
   }

   public void putStringArray(String var1, String[] var2) {
      this.axg.put(var1, var2);
   }

   public void putStringArrayList(String var1, ArrayList var2) {
      this.axg.put(var1, var2);
   }

   public Object remove(String var1) {
      return this.axg.remove(var1);
   }

   public int size() {
      return this.axg.size();
   }

   public Bundle toBundle() {
      Bundle var1 = new Bundle();
      Iterator var2 = this.axg.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         a(var1, var3, this.axg.get(var3));
      }

      return var1;
   }

   public byte[] toByteArray() {
      return qw.f(ql.a(this).ayo);
   }

   public String toString() {
      return this.axg.toString();
   }
}
