package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public class BasicNameValuePair implements NameValuePair, Cloneable, Serializable {
   private static final long serialVersionUID = -6437800749411518984L;
   private final String name;
   private final String value;

   public BasicNameValuePair(String var1, String var2) {
      this.name = (String)Args.notNull(var1, "Name");
      this.value = var2;
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof NameValuePair)) {
            return false;
         }

         BasicNameValuePair var2 = (BasicNameValuePair)var1;
         if(!this.name.equals(var2.name) || !LangUtils.equals((Object)this.value, (Object)var2.value)) {
            return false;
         }
      }

      return true;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
   }

   public String toString() {
      if(this.value == null) {
         return this.name;
      } else {
         StringBuilder var1 = new StringBuilder(this.name.length() + 1 + this.value.length());
         var1.append(this.name);
         var1.append("=");
         var1.append(this.value);
         return var1.toString();
      }
   }
}
