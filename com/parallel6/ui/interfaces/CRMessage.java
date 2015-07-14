package com.parallel6.ui.interfaces;

public class CRMessage {
   private Object[] data;
   private int messageCode;

   public CRMessage() {
   }

   public CRMessage(int var1) {
      this.messageCode = var1;
   }

   public CRMessage(int var1, Object... var2) {
      this.messageCode = var1;
      this.data = var2;
   }

   public Object[] getData() {
      return this.data;
   }

   public int getMessageCode() {
      return this.messageCode;
   }

   public void setData(Object... var1) {
      this.data = var1;
   }

   public void setMessageCode(int var1) {
      this.messageCode = var1;
   }
}
