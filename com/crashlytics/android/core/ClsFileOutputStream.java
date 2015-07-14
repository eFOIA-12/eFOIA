package com.crashlytics.android.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class ClsFileOutputStream extends FileOutputStream {
   public static final String IN_PROGRESS_SESSION_FILE_EXTENSION = ".cls_temp";
   public static final String SESSION_FILE_EXTENSION = ".cls";
   public static final FilenameFilter TEMP_FILENAME_FILTER = new FilenameFilter() {
      public boolean accept(File var1, String var2) {
         return var2.endsWith(".cls_temp");
      }
   };
   private boolean closed;
   private File complete;
   private File inProgress;
   private final String root;

   public ClsFileOutputStream(File var1, String var2) throws FileNotFoundException {
      super(new File(var1, var2 + ".cls_temp"));
      this.closed = false;
      this.root = var1 + File.separator + var2;
      this.inProgress = new File(this.root + ".cls_temp");
   }

   public ClsFileOutputStream(String var1, String var2) throws FileNotFoundException {
      this(new File(var1), var2);
   }

   public void close() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void closeInProgressStream() throws IOException {
      if(!this.closed) {
         this.closed = true;
         super.flush();
         super.close();
      }
   }

   public File getCompleteFile() {
      return this.complete;
   }

   public File getInProgressFile() {
      return this.inProgress;
   }
}
