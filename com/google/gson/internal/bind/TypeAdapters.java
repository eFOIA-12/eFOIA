package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Map.Entry;

public final class TypeAdapters {
   public static final TypeAdapter BIG_DECIMAL;
   public static final TypeAdapter BIG_INTEGER;
   public static final TypeAdapter BIT_SET;
   public static final TypeAdapterFactory BIT_SET_FACTORY;
   public static final TypeAdapter BOOLEAN;
   public static final TypeAdapter BOOLEAN_AS_STRING;
   public static final TypeAdapterFactory BOOLEAN_FACTORY;
   public static final TypeAdapter BYTE;
   public static final TypeAdapterFactory BYTE_FACTORY;
   public static final TypeAdapter CALENDAR;
   public static final TypeAdapterFactory CALENDAR_FACTORY;
   public static final TypeAdapter CHARACTER;
   public static final TypeAdapterFactory CHARACTER_FACTORY;
   public static final TypeAdapter CLASS = new TypeAdapter() {
      public Class read(JsonReader var1) throws IOException {
         if(var1.peek() == JsonToken.NULL) {
            var1.nextNull();
            return null;
         } else {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
         }
      }

      public void write(JsonWriter var1, Class var2) throws IOException {
         if(var2 == null) {
            var1.nullValue();
         } else {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + var2.getName() + ". Forgot to register a type adapter?");
         }
      }
   };
   public static final TypeAdapterFactory CLASS_FACTORY;
   public static final TypeAdapter DOUBLE;
   public static final TypeAdapterFactory ENUM_FACTORY;
   public static final TypeAdapter FLOAT;
   public static final TypeAdapter INET_ADDRESS;
   public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
   public static final TypeAdapter INTEGER;
   public static final TypeAdapterFactory INTEGER_FACTORY;
   public static final TypeAdapter JSON_ELEMENT;
   public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
   public static final TypeAdapter LOCALE;
   public static final TypeAdapterFactory LOCALE_FACTORY;
   public static final TypeAdapter LONG;
   public static final TypeAdapter NUMBER;
   public static final TypeAdapterFactory NUMBER_FACTORY;
   public static final TypeAdapter SHORT;
   public static final TypeAdapterFactory SHORT_FACTORY;
   public static final TypeAdapter STRING;
   public static final TypeAdapter STRING_BUFFER;
   public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
   public static final TypeAdapter STRING_BUILDER;
   public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
   public static final TypeAdapterFactory STRING_FACTORY;
   public static final TypeAdapterFactory TIMESTAMP_FACTORY;
   public static final TypeAdapter URI;
   public static final TypeAdapterFactory URI_FACTORY;
   public static final TypeAdapter URL;
   public static final TypeAdapterFactory URL_FACTORY;
   public static final TypeAdapter UUID;
   public static final TypeAdapterFactory UUID_FACTORY;

   static {
      CLASS_FACTORY = newFactory(Class.class, CLASS);
      BIT_SET = new TypeAdapter() {
         public BitSet read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               BitSet var6 = new BitSet();
               var1.beginArray();
               int var2 = 0;

               for(JsonToken var5 = var1.peek(); var5 != JsonToken.END_ARRAY; var5 = var1.peek()) {
                  boolean var4;
                  switch(null.$SwitchMap$com$google$gson$stream$JsonToken[var5.ordinal()]) {
                  case 1:
                     if(var1.nextInt() != 0) {
                        var4 = true;
                     } else {
                        var4 = false;
                     }
                     break;
                  case 2:
                     var4 = var1.nextBoolean();
                     break;
                  case 3:
                     String var8 = var1.nextString();

                     int var3;
                     try {
                        var3 = Integer.parseInt(var8);
                     } catch (NumberFormatException var7) {
                        throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + var8);
                     }

                     if(var3 != 0) {
                        var4 = true;
                     } else {
                        var4 = false;
                     }
                     break;
                  default:
                     throw new JsonSyntaxException("Invalid bitset value type: " + var5);
                  }

                  if(var4) {
                     var6.set(var2);
                  }

                  ++var2;
               }

               var1.endArray();
               return var6;
            }
         }

         public void write(JsonWriter var1, BitSet var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               var1.beginArray();

               for(int var3 = 0; var3 < var2.length(); ++var3) {
                  byte var4;
                  if(var2.get(var3)) {
                     var4 = 1;
                  } else {
                     var4 = 0;
                  }

                  var1.value((long)var4);
               }

               var1.endArray();
            }
         }
      };
      BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
      BOOLEAN = new TypeAdapter() {
         public Boolean read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return var1.peek() == JsonToken.STRING?Boolean.valueOf(Boolean.parseBoolean(var1.nextString())):Boolean.valueOf(var1.nextBoolean());
            }
         }

         public void write(JsonWriter var1, Boolean var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               var1.value(var2.booleanValue());
            }
         }
      };
      BOOLEAN_AS_STRING = new TypeAdapter() {
         public Boolean read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Boolean.valueOf(var1.nextString());
            }
         }

         public void write(JsonWriter var1, Boolean var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = "null";
            } else {
               var3 = var2.toString();
            }

            var1.value(var3);
         }
      };
      BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
      BYTE = new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               byte var2;
               try {
                  var2 = (byte)var1.nextInt();
               } catch (NumberFormatException var3) {
                  throw new JsonSyntaxException(var3);
               }

               return Byte.valueOf(var2);
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            var1.value(var2);
         }
      };
      BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
      SHORT = new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               short var2;
               try {
                  var2 = (short)var1.nextInt();
               } catch (NumberFormatException var3) {
                  throw new JsonSyntaxException(var3);
               }

               return Short.valueOf(var2);
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            var1.value(var2);
         }
      };
      SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
      INTEGER = new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               int var2;
               try {
                  var2 = var1.nextInt();
               } catch (NumberFormatException var3) {
                  throw new JsonSyntaxException(var3);
               }

               return Integer.valueOf(var2);
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            var1.value(var2);
         }
      };
      INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
      LONG = new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               long var2;
               try {
                  var2 = var1.nextLong();
               } catch (NumberFormatException var4) {
                  throw new JsonSyntaxException(var4);
               }

               return Long.valueOf(var2);
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            var1.value(var2);
         }
      };
      FLOAT = new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Float.valueOf((float)var1.nextDouble());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            var1.value(var2);
         }
      };
      DOUBLE = new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Double.valueOf(var1.nextDouble());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            var1.value(var2);
         }
      };
      NUMBER = new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            JsonToken var2 = var1.peek();
            switch(null.$SwitchMap$com$google$gson$stream$JsonToken[var2.ordinal()]) {
            case 1:
               return new LazilyParsedNumber(var1.nextString());
            case 2:
            case 3:
            default:
               throw new JsonSyntaxException("Expecting number, got: " + var2);
            case 4:
               var1.nextNull();
               return null;
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            var1.value(var2);
         }
      };
      NUMBER_FACTORY = newFactory(Number.class, NUMBER);
      CHARACTER = new TypeAdapter() {
         public Character read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               String var2 = var1.nextString();
               if(var2.length() != 1) {
                  throw new JsonSyntaxException("Expecting character, got: " + var2);
               } else {
                  return Character.valueOf(var2.charAt(0));
               }
            }
         }

         public void write(JsonWriter var1, Character var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = String.valueOf(var2);
            }

            var1.value(var3);
         }
      };
      CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
      STRING = new TypeAdapter() {
         public String read(JsonReader var1) throws IOException {
            JsonToken var2 = var1.peek();
            if(var2 == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return var2 == JsonToken.BOOLEAN?Boolean.toString(var1.nextBoolean()):var1.nextString();
            }
         }

         public void write(JsonWriter var1, String var2) throws IOException {
            var1.value(var2);
         }
      };
      BIG_DECIMAL = new TypeAdapter() {
         public BigDecimal read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               try {
                  BigDecimal var3 = new BigDecimal(var1.nextString());
                  return var3;
               } catch (NumberFormatException var2) {
                  throw new JsonSyntaxException(var2);
               }
            }
         }

         public void write(JsonWriter var1, BigDecimal var2) throws IOException {
            var1.value((Number)var2);
         }
      };
      BIG_INTEGER = new TypeAdapter() {
         public BigInteger read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               try {
                  BigInteger var3 = new BigInteger(var1.nextString());
                  return var3;
               } catch (NumberFormatException var2) {
                  throw new JsonSyntaxException(var2);
               }
            }
         }

         public void write(JsonWriter var1, BigInteger var2) throws IOException {
            var1.value((Number)var2);
         }
      };
      STRING_FACTORY = newFactory(String.class, STRING);
      STRING_BUILDER = new TypeAdapter() {
         public StringBuilder read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return new StringBuilder(var1.nextString());
            }
         }

         public void write(JsonWriter var1, StringBuilder var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = var2.toString();
            }

            var1.value(var3);
         }
      };
      STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
      STRING_BUFFER = new TypeAdapter() {
         public StringBuffer read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return new StringBuffer(var1.nextString());
            }
         }

         public void write(JsonWriter var1, StringBuffer var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = var2.toString();
            }

            var1.value(var3);
         }
      };
      STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
      URL = new TypeAdapter() {
         public URL read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
            } else {
               String var2 = var1.nextString();
               if(!"null".equals(var2)) {
                  return new URL(var2);
               }
            }

            return null;
         }

         public void write(JsonWriter var1, URL var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = var2.toExternalForm();
            }

            var1.value(var3);
         }
      };
      URL_FACTORY = newFactory(URL.class, URL);
      URI = new TypeAdapter() {
         public URI read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
            } else {
               try {
                  String var3 = var1.nextString();
                  if(!"null".equals(var3)) {
                     URI var4 = new URI(var3);
                     return var4;
                  }
               } catch (URISyntaxException var2) {
                  throw new JsonIOException(var2);
               }
            }

            return null;
         }

         public void write(JsonWriter var1, URI var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = var2.toASCIIString();
            }

            var1.value(var3);
         }
      };
      URI_FACTORY = newFactory(URI.class, URI);
      INET_ADDRESS = new TypeAdapter() {
         public InetAddress read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return InetAddress.getByName(var1.nextString());
            }
         }

         public void write(JsonWriter var1, InetAddress var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = var2.getHostAddress();
            }

            var1.value(var3);
         }
      };
      INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
      UUID = new TypeAdapter() {
         public UUID read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return UUID.fromString(var1.nextString());
            }
         }

         public void write(JsonWriter var1, UUID var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = var2.toString();
            }

            var1.value(var3);
         }
      };
      UUID_FACTORY = newFactory(UUID.class, UUID);
      TIMESTAMP_FACTORY = new TypeAdapterFactory() {
         public TypeAdapter create(Gson var1, TypeToken var2) {
            return var2.getRawType() != Timestamp.class?null:new TypeAdapter() {
               // $FF: synthetic field
               final TypeAdapter val$dateTypeAdapter;

               {
                  this.val$dateTypeAdapter = var2;
               }

               public Timestamp read(JsonReader var1) throws IOException {
                  Date var2 = (Date)this.val$dateTypeAdapter.read(var1);
                  return var2 != null?new Timestamp(var2.getTime()):null;
               }

               public void write(JsonWriter var1, Timestamp var2) throws IOException {
                  this.val$dateTypeAdapter.write(var1, var2);
               }
            };
         }
      };
      CALENDAR = new TypeAdapter() {
         private static final String DAY_OF_MONTH = "dayOfMonth";
         private static final String HOUR_OF_DAY = "hourOfDay";
         private static final String MINUTE = "minute";
         private static final String MONTH = "month";
         private static final String SECOND = "second";
         private static final String YEAR = "year";

         public Calendar read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               var1.beginObject();
               int var8 = 0;
               int var7 = 0;
               int var6 = 0;
               int var5 = 0;
               int var4 = 0;
               int var3 = 0;

               while(var1.peek() != JsonToken.END_OBJECT) {
                  String var9 = var1.nextName();
                  int var2 = var1.nextInt();
                  if("year".equals(var9)) {
                     var8 = var2;
                  } else if("month".equals(var9)) {
                     var7 = var2;
                  } else if("dayOfMonth".equals(var9)) {
                     var6 = var2;
                  } else if("hourOfDay".equals(var9)) {
                     var5 = var2;
                  } else if("minute".equals(var9)) {
                     var4 = var2;
                  } else if("second".equals(var9)) {
                     var3 = var2;
                  }
               }

               var1.endObject();
               return new GregorianCalendar(var8, var7, var6, var5, var4, var3);
            }
         }

         public void write(JsonWriter var1, Calendar var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               var1.beginObject();
               var1.name("year");
               var1.value((long)var2.get(1));
               var1.name("month");
               var1.value((long)var2.get(2));
               var1.name("dayOfMonth");
               var1.value((long)var2.get(5));
               var1.name("hourOfDay");
               var1.value((long)var2.get(11));
               var1.name("minute");
               var1.value((long)var2.get(12));
               var1.name("second");
               var1.value((long)var2.get(13));
               var1.endObject();
            }
         }
      };
      CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
      LOCALE = new TypeAdapter() {
         public Locale read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               StringTokenizer var4 = new StringTokenizer(var1.nextString(), "_");
               String var5 = null;
               String var2 = null;
               String var3 = null;
               if(var4.hasMoreElements()) {
                  var5 = var4.nextToken();
               }

               if(var4.hasMoreElements()) {
                  var2 = var4.nextToken();
               }

               if(var4.hasMoreElements()) {
                  var3 = var4.nextToken();
               }

               return var2 == null && var3 == null?new Locale(var5):(var3 == null?new Locale(var5, var2):new Locale(var5, var2, var3));
            }
         }

         public void write(JsonWriter var1, Locale var2) throws IOException {
            String var3;
            if(var2 == null) {
               var3 = null;
            } else {
               var3 = var2.toString();
            }

            var1.value(var3);
         }
      };
      LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
      JSON_ELEMENT = new TypeAdapter() {
         public JsonElement read(JsonReader var1) throws IOException {
            switch(null.$SwitchMap$com$google$gson$stream$JsonToken[var1.peek().ordinal()]) {
            case 1:
               return new JsonPrimitive(new LazilyParsedNumber(var1.nextString()));
            case 2:
               return new JsonPrimitive(Boolean.valueOf(var1.nextBoolean()));
            case 3:
               return new JsonPrimitive(var1.nextString());
            case 4:
               var1.nextNull();
               return JsonNull.INSTANCE;
            case 5:
               JsonArray var3 = new JsonArray();
               var1.beginArray();

               while(var1.hasNext()) {
                  var3.add(this.read(var1));
               }

               var1.endArray();
               return var3;
            case 6:
               JsonObject var2 = new JsonObject();
               var1.beginObject();

               while(var1.hasNext()) {
                  var2.add(var1.nextName(), this.read(var1));
               }

               var1.endObject();
               return var2;
            default:
               throw new IllegalArgumentException();
            }
         }

         public void write(JsonWriter var1, JsonElement var2) throws IOException {
            if(var2 != null && !var2.isJsonNull()) {
               if(var2.isJsonPrimitive()) {
                  JsonPrimitive var5 = var2.getAsJsonPrimitive();
                  if(var5.isNumber()) {
                     var1.value(var5.getAsNumber());
                  } else if(var5.isBoolean()) {
                     var1.value(var5.getAsBoolean());
                  } else {
                     var1.value(var5.getAsString());
                  }
               } else {
                  Iterator var4;
                  if(var2.isJsonArray()) {
                     var1.beginArray();
                     var4 = var2.getAsJsonArray().iterator();

                     while(var4.hasNext()) {
                        this.write(var1, (JsonElement)var4.next());
                     }

                     var1.endArray();
                  } else if(!var2.isJsonObject()) {
                     throw new IllegalArgumentException("Couldn\'t write " + var2.getClass());
                  } else {
                     var1.beginObject();
                     var4 = var2.getAsJsonObject().entrySet().iterator();

                     while(var4.hasNext()) {
                        Entry var3 = (Entry)var4.next();
                        var1.name((String)var3.getKey());
                        this.write(var1, (JsonElement)var3.getValue());
                     }

                     var1.endObject();
                  }
               }
            } else {
               var1.nullValue();
            }
         }
      };
      JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, JSON_ELEMENT);
      ENUM_FACTORY = new TypeAdapterFactory() {
         public TypeAdapter create(Gson var1, TypeToken var2) {
            Class var4 = var2.getRawType();
            if(Enum.class.isAssignableFrom(var4) && var4 != Enum.class) {
               Class var3 = var4;
               if(!var4.isEnum()) {
                  var3 = var4.getSuperclass();
               }

               return new TypeAdapters.EnumTypeAdapter(var3);
            } else {
               return null;
            }
         }
      };
   }

   public static TypeAdapterFactory newFactory(final TypeToken var0, final TypeAdapter var1) {
      return new TypeAdapterFactory() {
         public TypeAdapter create(Gson var1x, TypeToken var2) {
            return var2.equals(var0)?var1:null;
         }
      };
   }

   public static TypeAdapterFactory newFactory(final Class var0, final TypeAdapter var1) {
      return new TypeAdapterFactory() {
         public TypeAdapter create(Gson var1x, TypeToken var2) {
            return var2.getRawType() == var0?var1:null;
         }

         public String toString() {
            return "Factory[type=" + var0.getName() + ",adapter=" + var1 + "]";
         }
      };
   }

   public static TypeAdapterFactory newFactory(final Class var0, final Class var1, final TypeAdapter var2) {
      return new TypeAdapterFactory() {
         public TypeAdapter create(Gson var1x, TypeToken var2x) {
            Class var3 = var2x.getRawType();
            return var3 != var0 && var3 != var1?null:var2;
         }

         public String toString() {
            return "Factory[type=" + var1.getName() + "+" + var0.getName() + ",adapter=" + var2 + "]";
         }
      };
   }

   public static TypeAdapterFactory newFactoryForMultipleTypes(final Class var0, final Class var1, final TypeAdapter var2) {
      return new TypeAdapterFactory() {
         public TypeAdapter create(Gson var1x, TypeToken var2x) {
            Class var3 = var2x.getRawType();
            return var3 != var0 && var3 != var1?null:var2;
         }

         public String toString() {
            return "Factory[type=" + var0.getName() + "+" + var1.getName() + ",adapter=" + var2 + "]";
         }
      };
   }

   public static TypeAdapterFactory newTypeHierarchyFactory(final Class var0, final TypeAdapter var1) {
      return new TypeAdapterFactory() {
         public TypeAdapter create(Gson var1x, TypeToken var2) {
            return var0.isAssignableFrom(var2.getRawType())?var1:null;
         }

         public String toString() {
            return "Factory[typeHierarchy=" + var0.getName() + ",adapter=" + var1 + "]";
         }
      };
   }

   private static final class EnumTypeAdapter extends TypeAdapter {
      private final Map constantToName;
      private final Map nameToConstant;

      public EnumTypeAdapter(Class param1) {
         // $FF: Couldn't be decompiled
      }

      public Enum read(JsonReader var1) throws IOException {
         if(var1.peek() == JsonToken.NULL) {
            var1.nextNull();
            return null;
         } else {
            return (Enum)this.nameToConstant.get(var1.nextString());
         }
      }

      public void write(JsonWriter var1, Enum var2) throws IOException {
         String var3;
         if(var2 == null) {
            var3 = null;
         } else {
            var3 = (String)this.constantToName.get(var2);
         }

         var1.value(var3);
      }
   }
}
