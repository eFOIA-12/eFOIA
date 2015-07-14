package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.events.QueueFileEventStorage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPQueueFileEventStorage extends QueueFileEventStorage {
   public GZIPQueueFileEventStorage(Context var1, File var2, String var3, String var4) throws IOException {
      super(var1, var2, var3, var4);
   }

   public OutputStream getMoveOutputStream(File var1) throws IOException {
      return new GZIPOutputStream(new FileOutputStream(var1));
   }
}
