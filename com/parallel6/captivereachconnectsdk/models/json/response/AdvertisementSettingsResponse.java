package com.parallel6.captivereachconnectsdk.models.json.response;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.AdvertisementSetting;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;

public class AdvertisementSettingsResponse extends BaseJSon {
   @SerializedName("advertisements")
   private AdvertisementSettingsResponse.AdsSettings adsSettings;

   public AdvertisementSettingsResponse.AdsSettings getAdsSettings() {
      return this.adsSettings;
   }

   public void setAdsSettings(AdvertisementSettingsResponse.AdsSettings var1) {
      this.adsSettings = var1;
   }

   public class AdsSettings {
      @SerializedName("settings")
      private AdvertisementSetting advertisementSetting;

      public AdvertisementSetting getAdvertisementSetting() {
         return this.advertisementSetting;
      }

      public void setAdvertisementSetting(AdvertisementSetting var1) {
         this.advertisementSetting = var1;
      }
   }
}
