package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.query.Filter;

public abstract class AbstractFilter implements Filter {
   public String toString() {
      return String.format("Filter[%s]", new Object[]{this.a(new com.google.android.gms.drive.query.c())});
   }
}
