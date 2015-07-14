package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@NotThreadSafe
public class BasicHeaderElement implements HeaderElement, Cloneable {
   private final String name;
   private final NameValuePair[] parameters;
   private final String value;

   public BasicHeaderElement(String var1, String var2) {
      this(var1, var2, (NameValuePair[])null);
   }

   public BasicHeaderElement(String var1, String var2, NameValuePair[] var3) {
      this.name = (String)Args.notNull(var1, "Name");
      this.value = var2;
      if(var3 != null) {
         this.parameters = var3;
      } else {
         this.parameters = new NameValuePair[0];
      }
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof HeaderElement)) {
            return false;
         }

         BasicHeaderElement var2 = (BasicHeaderElement)var1;
         if(!this.name.equals(var2.name) || !LangUtils.equals((Object)this.value, (Object)var2.value) || !LangUtils.equals((Object[])this.parameters, (Object[])var2.parameters)) {
            return false;
         }
      }

      return true;
   }

   public String getName() {
      return this.name;
   }

   public NameValuePair getParameter(int var1) {
      return this.parameters[var1];
   }

   public NameValuePair getParameterByName(String var1) {
      Args.notNull(var1, "Name");
      Object var5 = null;
      NameValuePair[] var6 = this.parameters;
      int var3 = var6.length;
      int var2 = 0;

      NameValuePair var4;
      while(true) {
         var4 = (NameValuePair)var5;
         if(var2 >= var3) {
            break;
         }

         var4 = var6[var2];
         if(var4.getName().equalsIgnoreCase(var1)) {
            break;
         }

         ++var2;
      }

      return var4;
   }

   public int getParameterCount() {
      return this.parameters.length;
   }

   public NameValuePair[] getParameters() {
      return (NameValuePair[])this.parameters.clone();
   }

   public String getValue() {
      return this.value;
   }

   public int hashCode() {
      int var2 = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
      NameValuePair[] var4 = this.parameters;
      int var3 = var4.length;

      for(int var1 = 0; var1 < var3; ++var1) {
         var2 = LangUtils.hashCode(var2, var4[var1]);
      }

      return var2;
   }

   public String toString() {
      StringBuilder var3 = new StringBuilder();
      var3.append(this.name);
      if(this.value != null) {
         var3.append("=");
         var3.append(this.value);
      }

      NameValuePair[] var4 = this.parameters;
      int var2 = var4.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         NameValuePair var5 = var4[var1];
         var3.append("; ");
         var3.append(var5);
      }

      return var3.toString();
   }
}
