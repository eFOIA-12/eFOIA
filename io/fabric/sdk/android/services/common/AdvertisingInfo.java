package io.fabric.sdk.android.services.common;

class AdvertisingInfo {
   public final String advertisingId;
   public final boolean limitAdTrackingEnabled;

   AdvertisingInfo(String var1, boolean var2) {
      this.advertisingId = var1;
      this.limitAdTrackingEnabled = var2;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || this.getClass() != var1.getClass()) {
            return false;
         } else {
            AdvertisingInfo var2 = (AdvertisingInfo)var1;
            if(this.limitAdTrackingEnabled != var2.limitAdTrackingEnabled) {
               return false;
            } else {
               if(this.advertisingId != null) {
                  if(this.advertisingId.equals(var2.advertisingId)) {
                     return true;
                  }
               } else if(var2.advertisingId == null) {
                  return true;
               }

               return false;
            }
         }
      } else {
         return true;
      }
   }

   public int hashCode() {
      byte var2 = 0;
      int var1;
      if(this.advertisingId != null) {
         var1 = this.advertisingId.hashCode();
      } else {
         var1 = 0;
      }

      if(this.limitAdTrackingEnabled) {
         var2 = 1;
      }

      return var1 * 31 + var2;
   }
}
