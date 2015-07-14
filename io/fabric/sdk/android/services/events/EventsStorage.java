package io.fabric.sdk.android.services.events;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface EventsStorage {
   void add(byte[] var1) throws IOException;

   boolean canWorkingFileStore(int var1, int var2);

   void deleteFilesInRollOverDirectory(List var1);

   void deleteWorkingFile();

   List getAllFilesInRollOverDirectory();

   List getBatchOfFilesToSend(int var1);

   File getRollOverDirectory();

   File getWorkingDirectory();

   int getWorkingFileUsedSizeInBytes();

   boolean isWorkingFileEmpty();

   void rollOver(String var1) throws IOException;
}
