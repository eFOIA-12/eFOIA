package com.parallel6.ui.models;

import com.parallel6.ui.models.CRThemeDrawables;

public class CRTheme {
   private int appActionbarColorResource;
   private int appBaseColorResource;
   private CRThemeDrawables appDrawables;
   private int appPrimaryColorResource;
   private int appSecondaryColorResource;
   private int appTabBarColorResource;

   public int getAppActionbarColorResource() {
      return this.appActionbarColorResource;
   }

   public int getAppBaseColorResource() {
      return this.appBaseColorResource;
   }

   public CRThemeDrawables getAppDrawables() {
      return this.appDrawables;
   }

   public int getAppPrimaryColorResource() {
      return this.appPrimaryColorResource;
   }

   public int getAppSecondaryColorResource() {
      return this.appSecondaryColorResource;
   }

   public int getAppTabBarColorResource() {
      return this.appTabBarColorResource;
   }

   public void setAppActionbarColorResource(int var1) {
      this.appActionbarColorResource = var1;
   }

   public void setAppBaseColorResource(int var1) {
      this.appBaseColorResource = var1;
   }

   public void setAppDrawables(CRThemeDrawables var1) {
      this.appDrawables = var1;
   }

   public void setAppPrimaryColorResource(int var1) {
      this.appPrimaryColorResource = var1;
   }

   public void setAppSecondaryColorResource(int var1) {
      this.appSecondaryColorResource = var1;
   }

   public void setAppTabBarColorResource(int var1) {
      this.appTabBarColorResource = var1;
   }
}
