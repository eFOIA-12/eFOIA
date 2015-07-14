package com.parallel6.captivereachconnectsdk.models.login;

import com.google.gson.annotations.SerializedName;

public class Avatar {
   @SerializedName("file_data")
   protected String file_data;
   @SerializedName("filename")
   protected String filename;

   public String getFileData() {
      return this.file_data;
   }

   public String getFileName() {
      return this.filename;
   }

   public void setFileData(String var1) {
      this.file_data = var1;
   }

   public void setFileName(String var1) {
      this.filename = var1;
   }
}
