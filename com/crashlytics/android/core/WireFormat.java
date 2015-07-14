package com.crashlytics.android.core;

import com.crashlytics.android.core.ByteString;

final class WireFormat {
   static final int MESSAGE_SET_ITEM = 1;
   static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
   static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
   static final int MESSAGE_SET_MESSAGE = 3;
   static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
   static final int MESSAGE_SET_TYPE_ID = 2;
   static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
   static final int TAG_TYPE_BITS = 3;
   static final int TAG_TYPE_MASK = 7;
   public static final int WIRETYPE_END_GROUP = 4;
   public static final int WIRETYPE_FIXED32 = 5;
   public static final int WIRETYPE_FIXED64 = 1;
   public static final int WIRETYPE_LENGTH_DELIMITED = 2;
   public static final int WIRETYPE_START_GROUP = 3;
   public static final int WIRETYPE_VARINT = 0;

   public static int getTagFieldNumber(int var0) {
      return var0 >>> 3;
   }

   static int getTagWireType(int var0) {
      return var0 & 7;
   }

   static int makeTag(int var0, int var1) {
      return var0 << 3 | var1;
   }

   static enum FieldType {
      BOOL,
      BYTES,
      DOUBLE,
      ENUM,
      FIXED32,
      FIXED64,
      FLOAT,
      GROUP,
      INT32,
      INT64,
      MESSAGE,
      SFIXED32,
      SFIXED64,
      SINT32,
      SINT64,
      STRING,
      UINT32,
      UINT64;

      private final WireFormat.JavaType javaType;
      private final int wireType;

      static {
         DOUBLE = new WireFormat.FieldType("DOUBLE", 0, WireFormat.JavaType.DOUBLE, 1);
         FLOAT = new WireFormat.FieldType("FLOAT", 1, WireFormat.JavaType.FLOAT, 5);
         INT64 = new WireFormat.FieldType("INT64", 2, WireFormat.JavaType.LONG, 0);
         UINT64 = new WireFormat.FieldType("UINT64", 3, WireFormat.JavaType.LONG, 0);
         INT32 = new WireFormat.FieldType("INT32", 4, WireFormat.JavaType.INT, 0);
         FIXED64 = new WireFormat.FieldType("FIXED64", 5, WireFormat.JavaType.LONG, 1);
         FIXED32 = new WireFormat.FieldType("FIXED32", 6, WireFormat.JavaType.INT, 5);
         BOOL = new WireFormat.FieldType("BOOL", 7, WireFormat.JavaType.BOOLEAN, 0);
         STRING = new WireFormat.FieldType("STRING", 8, WireFormat.JavaType.STRING, 2, null) {
            public boolean isPackable() {
               return false;
            }
         };
         GROUP = new WireFormat.FieldType("GROUP", 9, WireFormat.JavaType.MESSAGE, 3, null) {
            public boolean isPackable() {
               return false;
            }
         };
         MESSAGE = new WireFormat.FieldType("MESSAGE", 10, WireFormat.JavaType.MESSAGE, 2, null) {
            public boolean isPackable() {
               return false;
            }
         };
         BYTES = new WireFormat.FieldType("BYTES", 11, WireFormat.JavaType.BYTE_STRING, 2, null) {
            public boolean isPackable() {
               return false;
            }
         };
         UINT32 = new WireFormat.FieldType("UINT32", 12, WireFormat.JavaType.INT, 0);
         ENUM = new WireFormat.FieldType("ENUM", 13, WireFormat.JavaType.ENUM, 0);
         SFIXED32 = new WireFormat.FieldType("SFIXED32", 14, WireFormat.JavaType.INT, 5);
         SFIXED64 = new WireFormat.FieldType("SFIXED64", 15, WireFormat.JavaType.LONG, 1);
         SINT32 = new WireFormat.FieldType("SINT32", 16, WireFormat.JavaType.INT, 0);
         SINT64 = new WireFormat.FieldType("SINT64", 17, WireFormat.JavaType.LONG, 0);
      }

      private FieldType(WireFormat.JavaType var3, int var4) {
         this.javaType = var3;
         this.wireType = var4;
      }

      // $FF: synthetic method
      FieldType(WireFormat.JavaType var3, int var4, Object var5) {
         this(var3, var4);
      }

      public WireFormat.JavaType getJavaType() {
         return this.javaType;
      }

      public int getWireType() {
         return this.wireType;
      }

      public boolean isPackable() {
         return true;
      }
   }

   static enum JavaType {
      BOOLEAN(Boolean.valueOf(false)),
      BYTE_STRING,
      DOUBLE(Double.valueOf(0.0D)),
      ENUM,
      FLOAT(Float.valueOf(0.0F)),
      INT(Integer.valueOf(0)),
      LONG(Long.valueOf(0L)),
      MESSAGE,
      STRING("");

      private final Object defaultDefault;

      static {
         BYTE_STRING = new WireFormat.JavaType("BYTE_STRING", 6, ByteString.EMPTY);
         ENUM = new WireFormat.JavaType("ENUM", 7, (Object)null);
         MESSAGE = new WireFormat.JavaType("MESSAGE", 8, (Object)null);
      }

      private JavaType(Object var3) {
         this.defaultDefault = var3;
      }

      Object getDefaultDefault() {
         return this.defaultDefault;
      }
   }
}
