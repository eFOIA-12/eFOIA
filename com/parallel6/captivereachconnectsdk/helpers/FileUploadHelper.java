package com.parallel6.captivereachconnectsdk.helpers;

import com.parallel6.captivereachconnectsdk.models.CRFile;
import com.parallel6.captivereachconnectsdk.network.request.ProgressiveEntity;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

public class FileUploadHelper {
   private static File getFile(String var0) throws Exception {
      File var1 = new File(var0);
      if(!var1.exists()) {
         throw new Exception("FileUploadHelper: File with path " + var0 + " does not exists");
      } else {
         return var1;
      }
   }

   public static HttpEntity postFile(String var0, String var1) throws Exception {
      MultipartEntityBuilder var2 = MultipartEntityBuilder.create();
      FileBody var3 = new FileBody(getFile(var0));
      var2.addPart("content[" + var1 + "]", var3);
      return new ProgressiveEntity(var2.build());
   }

   public static HttpEntity postFiles(List var0) throws Exception {
      MultipartEntityBuilder var1 = MultipartEntityBuilder.create();
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         CRFile var2 = (CRFile)var4.next();
         FileBody var3 = new FileBody(getFile(var2.getFilePath()));
         var1.addPart("content[" + var2.getAttributeName() + "][]", var3);
      }

      return new ProgressiveEntity(var1.build());
   }
}
