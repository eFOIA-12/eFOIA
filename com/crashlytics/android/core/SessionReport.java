package com.crashlytics.android.core;

import com.crashlytics.android.core.Report;
import com.crashlytics.android.core.ReportUploader;
import io.fabric.sdk.android.Fabric;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class SessionReport implements Report {
   private final Map customHeaders;
   private final File file;

   public SessionReport(File var1) {
      this(var1, Collections.emptyMap());
   }

   public SessionReport(File var1, Map var2) {
      this.file = var1;
      this.customHeaders = new HashMap(var2);
      if(this.file.length() == 0L) {
         this.customHeaders.putAll(ReportUploader.HEADER_INVALID_CLS_FILE);
      }

   }

   public Map getCustomHeaders() {
      return Collections.unmodifiableMap(this.customHeaders);
   }

   public File getFile() {
      return this.file;
   }

   public String getFileName() {
      return this.getFile().getName();
   }

   public String getIdentifier() {
      String var1 = this.getFileName();
      return var1.substring(0, var1.lastIndexOf(46));
   }

   public boolean remove() {
      Fabric.getLogger().d("Fabric", "Removing report at " + this.file.getPath());
      return this.file.delete();
   }
}
