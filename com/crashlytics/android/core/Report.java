package com.crashlytics.android.core;

import java.io.File;
import java.util.Map;

interface Report {
   Map getCustomHeaders();

   File getFile();

   String getFileName();

   String getIdentifier();

   boolean remove();
}
