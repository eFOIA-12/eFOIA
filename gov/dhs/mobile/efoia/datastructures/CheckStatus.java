package gov.dhs.mobile.efoia.datastructures;

public class CheckStatus {
   private String drupalFormID = "";
   private String foia_request_number = "";

   public String getDrupalFormID() {
      return this.drupalFormID;
   }

   public String getFoia_request_number() {
      return this.foia_request_number;
   }

   public String serializeSubmission(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("\r\n--" + var1 + "\r\n");
      var2.append("Content-Disposition: form-data; name=\"foia_request_number\"\r\n\r\n" + this.foia_request_number);
      var2.append("\r\n--" + var1 + "\r\n");
      var2.append("Content-Disposition: form-data; name=\"op\"\r\n\r\nCheck Status");
      var2.append("\r\n--" + var1 + "\r\n");
      var2.append("Content-Disposition: form-data; name=\"form_build_id\"\r\n\r\n" + this.drupalFormID);
      var2.append("\r\n--" + var1 + "\r\n");
      var2.append("Content-Disposition: form-data; name=\"form_id\"\r\n\r\ncustom_foia_request_status_form");
      var2.append("\r\n--" + var1 + "\r\n");
      return var2.toString();
   }

   public void setDrupalFormID(String var1) {
      this.drupalFormID = var1;
   }

   public void setFoia_request_number(String var1) {
      this.foia_request_number = var1;
   }
}
