package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AdvertisingInfo;
import io.fabric.sdk.android.services.common.AdvertisingInfoProvider;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeviceIdentifierProvider;
import io.fabric.sdk.android.services.common.InstallerPackageNameProvider;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.json.JSONObject;

public class IdManager {
   public static final String APPLICATION_INSTALL_ID_FIELD = "APPLICATION_INSTALLATION_UUID";
   private static final String BAD_ANDROID_ID = "9774d56d682e549c";
   public static final String BETA_DEVICE_TOKEN_FIELD = "font_token";
   private static final String BLUETOOTH_ERROR_MESSAGE = "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()";
   public static final String COLLECT_DEVICE_IDENTIFIERS = "com.crashlytics.CollectDeviceIdentifiers";
   public static final String COLLECT_USER_IDENTIFIERS = "com.crashlytics.CollectUserIdentifiers";
   public static final String DEFAULT_VERSION_NAME = "0.0";
   private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");
   private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
   public static final String MODEL_FIELD = "model";
   public static final String OS_VERSION_FIELD = "os_version";
   private static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
   private static final String SDK_ASSETS_ROOT = ".TwitterSdk";
   private final Context appContext;
   private final String appIdentifier;
   private final String appInstallIdentifier;
   private final boolean collectHardwareIds;
   private final boolean collectUserIds;
   private final ReentrantLock installationIdLock = new ReentrantLock();
   private final InstallerPackageNameProvider installerPackageNameProvider;
   private final Collection kits;

   public IdManager(Context var1, String var2, String var3, Collection var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("appContext must not be null");
      } else if(var2 == null) {
         throw new IllegalArgumentException("appIdentifier must not be null");
      } else if(var4 == null) {
         throw new IllegalArgumentException("kits must not be null");
      } else {
         this.appContext = var1;
         this.appIdentifier = var2;
         this.appInstallIdentifier = var3;
         this.kits = var4;
         this.installerPackageNameProvider = new InstallerPackageNameProvider();
         this.collectHardwareIds = CommonUtils.getBooleanResourceValue(var1, "com.crashlytics.CollectDeviceIdentifiers", true);
         if(!this.collectHardwareIds) {
            Fabric.getLogger().d("Fabric", "Device ID collection disabled for " + var1.getPackageName());
         }

         this.collectUserIds = CommonUtils.getBooleanResourceValue(var1, "com.crashlytics.CollectUserIdentifiers", true);
         if(!this.collectUserIds) {
            Fabric.getLogger().d("Fabric", "User information collection disabled for " + var1.getPackageName());
         }

      }
   }

   private void addAppInstallIdTo(JSONObject var1) {
      try {
         var1.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), this.getAppInstallIdentifier());
      } catch (Exception var2) {
         Fabric.getLogger().e("Fabric", "Could not write application id to JSON", var2);
      }
   }

   private void addDeviceIdentifiersTo(JSONObject var1) {
      Iterator var2 = this.getDeviceIdentifiers().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();

         try {
            var1.put(((IdManager.DeviceIdentifierType)var3.getKey()).name().toLowerCase(Locale.US), var3.getValue());
         } catch (Exception var5) {
            Fabric.getLogger().e("Fabric", "Could not write value to JSON: " + ((IdManager.DeviceIdentifierType)var3.getKey()).name(), var5);
         }
      }

   }

   private void addModelName(JSONObject var1) {
      try {
         var1.put("model", this.getModelName());
      } catch (Exception var2) {
         Fabric.getLogger().e("Fabric", "Could not write model to JSON", var2);
      }
   }

   private void addOsVersionTo(JSONObject var1) {
      try {
         var1.put("os_version", this.getOsVersionString());
      } catch (Exception var2) {
         Fabric.getLogger().e("Fabric", "Could not write OS version to JSON", var2);
      }
   }

   private String createInstallationUUID(SharedPreferences param1) {
      // $FF: Couldn't be decompiled
   }

   private String formatId(String var1) {
      return var1 == null?null:ID_PATTERN.matcher(var1).replaceAll("").toLowerCase(Locale.US);
   }

   private String[] getTwitterSdkAssetsList() {
      return new String[0];
   }

   private boolean hasPermission(String var1) {
      return this.appContext.checkCallingPermission(var1) == 0;
   }

   private void putNonNullIdInto(Map var1, IdManager.DeviceIdentifierType var2, String var3) {
      if(var3 != null) {
         var1.put(var2, var3);
      }

   }

   private String removeForwardSlashesIn(String var1) {
      return var1.replaceAll(FORWARD_SLASH_REGEX, "");
   }

   public boolean canCollectUserIds() {
      return this.collectUserIds;
   }

   public String createIdHeaderValue(String var1, String var2) {
      Cipher var6;
      try {
         var2 = var2.replaceAll("\\.", (new StringBuilder(new String(new char[]{'s', 'l', 'c'}))).reverse().toString());
         var6 = CommonUtils.createCipher(1, CommonUtils.sha1(var1 + var2));
      } catch (GeneralSecurityException var5) {
         Fabric.getLogger().e("Fabric", "Could not create cipher to encrypt headers.", var5);
         return "";
      }

      JSONObject var3 = new JSONObject();
      this.addAppInstallIdTo(var3);
      this.addDeviceIdentifiersTo(var3);
      this.addOsVersionTo(var3);
      this.addModelName(var3);
      var1 = "";
      if(var3.length() > 0) {
         try {
            var1 = CommonUtils.hexify(var6.doFinal(var3.toString().getBytes()));
         } catch (GeneralSecurityException var4) {
            Fabric.getLogger().e("Fabric", "Could not encrypt IDs", var4);
            return "";
         }
      }

      return var1;
   }

   public String getAdvertisingId() {
      Object var2 = null;
      String var1 = (String)var2;
      if(this.collectHardwareIds) {
         AdvertisingInfo var3 = (new AdvertisingInfoProvider(this.appContext)).getAdvertisingInfo();
         var1 = (String)var2;
         if(var3 != null) {
            var1 = var3.advertisingId;
         }
      }

      return var1;
   }

   public String getAndroidId() {
      Object var2 = null;
      String var1 = (String)var2;
      if(this.collectHardwareIds) {
         String var3 = Secure.getString(this.appContext.getContentResolver(), "android_id");
         var1 = (String)var2;
         if(!"9774d56d682e549c".equals(var3)) {
            var1 = this.formatId(var3);
         }
      }

      return var1;
   }

   public String getAppIdentifier() {
      return this.appIdentifier;
   }

   public String getAppInstallIdentifier() {
      String var2 = this.appInstallIdentifier;
      String var1 = var2;
      if(var2 == null) {
         SharedPreferences var3 = CommonUtils.getSharedPrefs(this.appContext);
         var2 = var3.getString("crashlytics.installation.id", (String)null);
         var1 = var2;
         if(var2 == null) {
            var1 = this.createInstallationUUID(var3);
         }
      }

      return var1;
   }

   public String getBluetoothMacAddress() {
      // $FF: Couldn't be decompiled
   }

   public Map getDeviceIdentifiers() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.kits.iterator();

      while(var2.hasNext()) {
         Kit var3 = (Kit)var2.next();
         if(var3 instanceof DeviceIdentifierProvider) {
            Iterator var5 = ((DeviceIdentifierProvider)var3).getDeviceIdentifiers().entrySet().iterator();

            while(var5.hasNext()) {
               Entry var4 = (Entry)var5.next();
               this.putNonNullIdInto(var1, (IdManager.DeviceIdentifierType)var4.getKey(), (String)var4.getValue());
            }
         }
      }

      this.putNonNullIdInto(var1, IdManager.DeviceIdentifierType.ANDROID_ID, this.getAndroidId());
      this.putNonNullIdInto(var1, IdManager.DeviceIdentifierType.ANDROID_DEVICE_ID, this.getTelephonyId());
      this.putNonNullIdInto(var1, IdManager.DeviceIdentifierType.ANDROID_SERIAL, this.getSerialNumber());
      this.putNonNullIdInto(var1, IdManager.DeviceIdentifierType.WIFI_MAC_ADDRESS, this.getWifiMacAddress());
      this.putNonNullIdInto(var1, IdManager.DeviceIdentifierType.BLUETOOTH_MAC_ADDRESS, this.getBluetoothMacAddress());
      this.putNonNullIdInto(var1, IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID, this.getAdvertisingId());
      return Collections.unmodifiableMap(var1);
   }

   public String getDeviceUUID() {
      String var1 = "";
      if(this.collectHardwareIds) {
         String var2 = this.getAndroidId();
         var1 = var2;
         if(var2 == null) {
            SharedPreferences var3 = CommonUtils.getSharedPrefs(this.appContext);
            var2 = var3.getString("crashlytics.installation.id", (String)null);
            var1 = var2;
            if(var2 == null) {
               var1 = this.createInstallationUUID(var3);
            }
         }
      }

      return var1;
   }

   public String getInstallerPackageName() {
      return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
   }

   public String getModelName() {
      return String.format(Locale.US, "%s/%s", new Object[]{this.removeForwardSlashesIn(Build.MANUFACTURER), this.removeForwardSlashesIn(Build.MODEL)});
   }

   public String getOsVersionString() {
      return String.format(Locale.US, "%s/%s", new Object[]{this.removeForwardSlashesIn(VERSION.RELEASE), this.removeForwardSlashesIn(VERSION.INCREMENTAL)});
   }

   public String getSerialNumber() {
      if(this.collectHardwareIds && VERSION.SDK_INT >= 9) {
         try {
            String var1 = this.formatId((String)Build.class.getField("SERIAL").get((Object)null));
            return var1;
         } catch (Exception var2) {
            Fabric.getLogger().e("Fabric", "Could not retrieve android.os.Build.SERIAL value", var2);
         }
      }

      return null;
   }

   public String getTelephonyId() {
      if(this.collectHardwareIds && this.hasPermission("android.permission.READ_PHONE_STATE")) {
         TelephonyManager var1 = (TelephonyManager)this.appContext.getSystemService("phone");
         if(var1 != null) {
            return this.formatId(var1.getDeviceId());
         }
      }

      return null;
   }

   public String getWifiMacAddress() {
      if(this.collectHardwareIds && this.hasPermission("android.permission.ACCESS_WIFI_STATE")) {
         WifiManager var1 = (WifiManager)this.appContext.getSystemService("wifi");
         if(var1 != null) {
            WifiInfo var2 = var1.getConnectionInfo();
            if(var2 != null) {
               return this.formatId(var2.getMacAddress());
            }
         }
      }

      return null;
   }

   public static enum DeviceIdentifierType {
      ANDROID_ADVERTISING_ID(103),
      ANDROID_DEVICE_ID(101),
      ANDROID_ID(100),
      ANDROID_SERIAL(102),
      BLUETOOTH_MAC_ADDRESS(2),
      FONT_TOKEN(53),
      WIFI_MAC_ADDRESS(1);

      public final int protobufIndex;

      private DeviceIdentifierType(int var3) {
         this.protobufIndex = var3;
      }
   }
}
