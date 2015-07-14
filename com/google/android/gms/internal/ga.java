package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.ck;
import com.google.android.gms.internal.ex;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.gb;
import com.google.android.gms.internal.gc;
import com.google.android.gms.internal.gd;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.ld;
import java.lang.Thread.UncaughtExceptionHandler;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

@ey
public class ga implements ck.b {
   private static final ga vX = new ga();
   public static final String vY;
   private Context mContext;
   private final Object mH = new Object();
   private am nE;
   private al nF;
   private ex nG;
   private gs qJ;
   private boolean uV;
   private boolean uW;
   public final String vZ;
   private final gb wa;
   private ld wb;
   private BigInteger wc;
   private final HashSet wd;
   private final HashMap we;
   private boolean wf;
   private boolean wg;
   private an wh;
   private LinkedList wi;
   private boolean wj;
   private Bundle wk;
   private String wl;

   static {
      vY = vX.vZ;
   }

   private ga() {
      this.wc = BigInteger.ONE;
      this.wd = new HashSet();
      this.we = new HashMap();
      this.wf = false;
      this.uV = true;
      this.wg = false;
      this.uW = true;
      this.nE = null;
      this.wh = null;
      this.nF = null;
      this.wi = new LinkedList();
      this.wj = false;
      this.wk = bn.by();
      this.nG = null;
      this.vZ = gi.dx();
      this.wa = new gb(this.vZ);
   }

   public static Bundle a(Context var0, gc var1, String var2) {
      return vX.b(var0, var1, var2);
   }

   public static void a(Context var0, gs var1) {
      vX.b(var0, var1);
   }

   public static void a(Context var0, boolean var1) {
      vX.b(var0, var1);
   }

   public static void b(HashSet var0) {
      vX.c(var0);
   }

   public static Bundle bN() {
      return vX.dp();
   }

   public static String c(int var0, String var1) {
      return vX.d(var0, var1);
   }

   public static ga dc() {
      return vX;
   }

   public static String df() {
      return vX.dg();
   }

   public static gb dh() {
      return vX.di();
   }

   public static boolean dj() {
      return vX.dk();
   }

   public static boolean dl() {
      return vX.dm();
   }

   public static String dn() {
      return vX.do();
   }

   public static void e(Throwable var0) {
      vX.f(var0);
   }

   public void a(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(fz param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(String param1, gd param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(Thread param1) {
      // $FF: Couldn't be decompiled
   }

   public Bundle b(Context param1, gc param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public void b(Context param1, gs param2) {
      // $FF: Couldn't be decompiled
   }

   public void b(Context param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void c(HashSet param1) {
      // $FF: Couldn't be decompiled
   }

   public String d(int var1, String var2) {
      Resources var3;
      if(this.qJ.wV) {
         var3 = this.mContext.getResources();
      } else {
         var3 = GooglePlayServicesUtil.getRemoteResource(this.mContext);
      }

      return var3 == null?var2:var3.getString(var1);
   }

   public ld dd() {
      // $FF: Couldn't be decompiled
   }

   public boolean de() {
      // $FF: Couldn't be decompiled
   }

   public String dg() {
      // $FF: Couldn't be decompiled
   }

   public gb di() {
      // $FF: Couldn't be decompiled
   }

   public boolean dk() {
      // $FF: Couldn't be decompiled
   }

   public boolean dm() {
      // $FF: Couldn't be decompiled
   }

   public String do() {
      // $FF: Couldn't be decompiled
   }

   public Bundle dp() {
      // $FF: Couldn't be decompiled
   }

   public void f(Throwable var1) {
      if(this.wg) {
         (new ex(this.mContext, this.qJ, (UncaughtExceptionHandler)null, (UncaughtExceptionHandler)null)).b(var1);
      }

   }

   public an l(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void x(boolean param1) {
      // $FF: Couldn't be decompiled
   }
}
