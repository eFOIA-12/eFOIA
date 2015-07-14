package com.google.android.gms.internal;

public enum ii {
   EA("ServiceDisabled"),
   EB("ServiceUnavailable"),
   EC("CaptchaRequired"),
   ED("NetworkError"),
   EE("UserCancel"),
   EF("PermissionDenied"),
   @Deprecated
   EG("DeviceManagementRequiredOrSyncDisabled"),
   EH("DeviceManagementInternalError"),
   EI("DeviceManagementSyncDisabled"),
   EJ("DeviceManagementAdminBlocked"),
   EK("DeviceManagementAdminPendingApproval"),
   EL("DeviceManagementStaleSyncRequired"),
   EM("DeviceManagementDeactivated"),
   EN("DeviceManagementRequired"),
   EO("ClientLoginDisabled"),
   EP("NeedPermission"),
   EQ("WeakPassword"),
   ER("ALREADY_HAS_GMAIL"),
   ES("BadRequest"),
   ET("BadUsername"),
   EU("LoginFail"),
   EV("NotLoggedIn"),
   EW("NoGmail"),
   EX("RequestDenied"),
   EY("ServerError"),
   EZ("UsernameUnavailable"),
   Er("Ok"),
   Es("BadAuthentication"),
   Et("InvalidSecondFactor"),
   Eu("NotVerified"),
   Ev("TermsNotAgreed"),
   Ew("Unknown"),
   Ex("UNKNOWN_ERR"),
   Ey("AccountDeleted"),
   Ez("AccountDisabled"),
   Fa("DeletedGmail"),
   Fb("SocketTimeout"),
   Fc("ExistingUsername"),
   Fd("NeedsBrowser"),
   Fe("GPlusOther"),
   Ff("GPlusNickname"),
   Fg("GPlusInvalidChar"),
   Fh("GPlusInterstitial"),
   Fi("ProfileUpgradeError"),
   Fj("INVALID_SCOPE");

   public static String Fk;
   public static String Fl;
   private final String Fm;

   static {
      Fk = "Error";
      Fl = "status";
   }

   private ii(String var3) {
      this.Fm = var3;
   }

   public String fO() {
      return this.Fm;
   }
}
