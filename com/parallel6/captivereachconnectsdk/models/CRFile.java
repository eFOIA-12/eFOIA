package com.parallel6.captivereachconnectsdk.models;

public class CRFile {
   private String attributeName;
   private String fileName;
   private String filePath;
   private String fileType;
   private String sizeLabel;

   public CRFile(String var1, String var2) {
      this.filePath = var1;
      this.attributeName = var2;
   }

   public CRFile(String var1, String var2, String var3, String var4) {
      this.filePath = var1;
      this.attributeName = var2;
      this.fileType = var3;
      this.sizeLabel = var4;
   }

   public String getAttributeName() {
      return this.attributeName;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public String getFileType() {
      return this.fileType;
   }

   public String getSizeLabel() {
      return this.sizeLabel;
   }

   public void setAttributeName(String var1) {
      this.attributeName = var1;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public void setFilePath(String var1) {
      this.filePath = var1;
   }

   public void setFileType(String var1) {
      this.fileType = var1;
   }

   public void setSizeLabel(String var1) {
      this.sizeLabel = var1;
   }
}
