package com.androidquery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.callback.ImageOptions;
import com.androidquery.callback.Transformer;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.Constants;
import com.androidquery.util.WebImage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public abstract class AbstractAQuery implements Constants {
   private static Class[] LAYER_TYPE_SIG;
   private static final Class[] ON_CLICK_SIG = new Class[]{View.class};
   private static Class[] ON_ITEM_SIG;
   private static Class[] ON_SCROLLED_STATE_SIG;
   private static final Class[] OVER_SCROLL_SIG;
   private static Class[] PENDING_TRANSITION_SIG;
   private static final Class[] TEXT_CHANGE_SIG;
   private static WeakHashMap dialogs;
   private Activity act;
   protected AccountHandle ah;
   private Constructor constructor;
   private Context context;
   private int policy = 0;
   protected Object progress;
   private HttpHost proxy;
   private View root;
   private Transformer trans;
   protected View view;

   static {
      ON_ITEM_SIG = new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE};
      ON_SCROLLED_STATE_SIG = new Class[]{AbsListView.class, Integer.TYPE};
      TEXT_CHANGE_SIG = new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
      PENDING_TRANSITION_SIG = new Class[]{Integer.TYPE, Integer.TYPE};
      OVER_SCROLL_SIG = new Class[]{Integer.TYPE};
      LAYER_TYPE_SIG = new Class[]{Integer.TYPE, Paint.class};
      dialogs = new WeakHashMap();
   }

   public AbstractAQuery(Activity var1) {
      this.act = var1;
   }

   public AbstractAQuery(Activity var1, View var2) {
      this.root = var2;
      this.view = var2;
      this.act = var1;
   }

   public AbstractAQuery(Context var1) {
      this.context = var1;
   }

   public AbstractAQuery(View var1) {
      this.root = var1;
      this.view = var1;
   }

   private View findView(int var1) {
      View var2 = null;
      if(this.root != null) {
         var2 = this.root.findViewById(var1);
      } else if(this.act != null) {
         return this.act.findViewById(var1);
      }

      return var2;
   }

   private View findView(String var1) {
      Object var3 = null;
      View var2;
      if(this.root != null) {
         var2 = this.root.findViewWithTag(var1);
      } else {
         var2 = (View)var3;
         if(this.act != null) {
            View var4 = ((ViewGroup)this.act.findViewById(16908290)).getChildAt(0);
            var2 = (View)var3;
            if(var4 != null) {
               return var4.findViewWithTag(var1);
            }
         }
      }

      return var2;
   }

   private View findView(int... var1) {
      View var3 = this.findView(var1[0]);

      for(int var2 = 1; var2 < var1.length && var3 != null; ++var2) {
         var3 = var3.findViewById(var1[var2]);
      }

      return var3;
   }

   private Constructor getConstructor() {
      if(this.constructor == null) {
         try {
            this.constructor = this.getClass().getConstructor(new Class[]{View.class});
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

      return this.constructor;
   }

   private Common setScrollListener() {
      AbsListView var3 = (AbsListView)this.view;
      Common var2 = (Common)var3.getTag(1090453506);
      Common var1 = var2;
      if(var2 == null) {
         var1 = new Common();
         var3.setOnScrollListener(var1);
         var3.setTag(1090453506, var1);
         AQUtility.debug((Object)"set scroll listenr");
      }

      return var1;
   }

   private void size(boolean var1, int var2, boolean var3) {
      if(this.view != null) {
         LayoutParams var5 = this.view.getLayoutParams();
         Context var6 = this.getContext();
         int var4 = var2;
         if(var2 > 0) {
            var4 = var2;
            if(var3) {
               var4 = AQUtility.dip2pixel(var6, (float)var2);
            }
         }

         if(var1) {
            var5.width = var4;
         } else {
            var5.height = var4;
         }

         this.view.setLayoutParams(var5);
      }

   }

   public AbstractAQuery adapter(Adapter var1) {
      if(this.view instanceof AdapterView) {
         ((AdapterView)this.view).setAdapter(var1);
      }

      return this.self();
   }

   public AbstractAQuery adapter(ExpandableListAdapter var1) {
      if(this.view instanceof ExpandableListView) {
         ((ExpandableListView)this.view).setAdapter(var1);
      }

      return this.self();
   }

   public AbstractAQuery ajax(AjaxCallback var1) {
      return this.invoke(var1);
   }

   public AbstractAQuery ajax(String var1, Class var2, long var3, AjaxCallback var5) {
      ((AjaxCallback)((AjaxCallback)((AjaxCallback)var5.type(var2)).url(var1)).fileCache(true)).expire(var3);
      return this.ajax(var5);
   }

   public AbstractAQuery ajax(String var1, Class var2, long var3, Object var5, String var6) {
      AjaxCallback var7 = new AjaxCallback();
      ((AjaxCallback)((AjaxCallback)((AjaxCallback)var7.type(var2)).weakHandler(var5, var6)).fileCache(true)).expire(var3);
      return this.ajax(var1, var2, var7);
   }

   public AbstractAQuery ajax(String var1, Class var2, AjaxCallback var3) {
      ((AjaxCallback)var3.type(var2)).url(var1);
      return this.ajax(var3);
   }

   public AbstractAQuery ajax(String var1, Class var2, Object var3, String var4) {
      AjaxCallback var5 = new AjaxCallback();
      ((AjaxCallback)var5.type(var2)).weakHandler(var3, var4);
      return this.ajax(var1, var2, var5);
   }

   public AbstractAQuery ajax(String var1, Map var2, Class var3, AjaxCallback var4) {
      ((AjaxCallback)((AjaxCallback)var4.type(var3)).url(var1)).params(var2);
      return this.ajax(var4);
   }

   public AbstractAQuery ajax(String var1, Map var2, Class var3, Object var4, String var5) {
      AjaxCallback var6 = new AjaxCallback();
      ((AjaxCallback)var6.type(var3)).weakHandler(var4, var5);
      return this.ajax(var1, var2, var3, var6);
   }

   public AbstractAQuery ajaxCancel() {
      AjaxCallback.cancel();
      return this.self();
   }

   public AbstractAQuery animate(int var1) {
      return this.animate(var1, (AnimationListener)null);
   }

   public AbstractAQuery animate(int var1, AnimationListener var2) {
      Animation var3 = AnimationUtils.loadAnimation(this.getContext(), var1);
      var3.setAnimationListener(var2);
      return this.animate(var3);
   }

   public AbstractAQuery animate(Animation var1) {
      if(this.view != null && var1 != null) {
         this.view.startAnimation(var1);
      }

      return this.self();
   }

   public AbstractAQuery auth(AccountHandle var1) {
      this.ah = var1;
      return this.self();
   }

   public AbstractAQuery background(int var1) {
      if(this.view != null) {
         if(var1 != 0) {
            this.view.setBackgroundResource(var1);
         } else {
            this.view.setBackgroundDrawable((Drawable)null);
         }
      }

      return this.self();
   }

   public AbstractAQuery backgroundColor(int var1) {
      if(this.view != null) {
         this.view.setBackgroundColor(var1);
      }

      return this.self();
   }

   public AbstractAQuery backgroundColorId(int var1) {
      if(this.view != null) {
         this.view.setBackgroundColor(this.getContext().getResources().getColor(var1));
      }

      return this.self();
   }

   public AbstractAQuery cache(String var1, long var2) {
      return this.ajax(var1, byte[].class, var2, (Object)null, (String)null);
   }

   public AbstractAQuery checked(boolean var1) {
      if(this.view instanceof CompoundButton) {
         ((CompoundButton)this.view).setChecked(var1);
      }

      return this.self();
   }

   public AbstractAQuery clear() {
      if(this.view != null) {
         if(this.view instanceof ImageView) {
            ImageView var1 = (ImageView)this.view;
            var1.setImageBitmap((Bitmap)null);
            var1.setTag(1090453505, (Object)null);
         } else if(this.view instanceof WebView) {
            WebView var2 = (WebView)this.view;
            var2.stopLoading();
            var2.clearView();
            var2.setTag(1090453505, (Object)null);
         } else if(this.view instanceof TextView) {
            ((TextView)this.view).setText("");
         }
      }

      return this.self();
   }

   public AbstractAQuery click() {
      if(this.view != null) {
         this.view.performClick();
      }

      return this.self();
   }

   public AbstractAQuery clickable(boolean var1) {
      if(this.view != null) {
         this.view.setClickable(var1);
      }

      return this.self();
   }

   public AbstractAQuery clicked(OnClickListener var1) {
      if(this.view != null) {
         this.view.setOnClickListener(var1);
      }

      return this.self();
   }

   public AbstractAQuery clicked(Object var1, String var2) {
      return this.clicked((new Common()).forward(var1, var2, true, ON_CLICK_SIG));
   }

   protected AbstractAQuery create(View param1) {
      // $FF: Couldn't be decompiled
   }

   public AbstractAQuery dataChanged() {
      if(this.view instanceof AdapterView) {
         Adapter var1 = ((AdapterView)this.view).getAdapter();
         if(var1 instanceof BaseAdapter) {
            ((BaseAdapter)var1).notifyDataSetChanged();
         }
      }

      return this.self();
   }

   public AbstractAQuery delete(String var1, Class var2, AjaxCallback var3) {
      ((AjaxCallback)((AjaxCallback)var3.url(var1)).type(var2)).method(2);
      return this.ajax(var3);
   }

   public AbstractAQuery delete(String var1, Class var2, Object var3, String var4) {
      AjaxCallback var5 = new AjaxCallback();
      var5.weakHandler(var3, var4);
      return this.delete(var1, var2, var5);
   }

   public AbstractAQuery dismiss() {
      for(Iterator var1 = dialogs.keySet().iterator(); var1.hasNext(); var1.remove()) {
         Dialog var2 = (Dialog)var1.next();

         try {
            var2.dismiss();
         } catch (Exception var3) {
            ;
         }
      }

      return this.self();
   }

   public AbstractAQuery dismiss(Dialog var1) {
      if(var1 != null) {
         try {
            dialogs.remove(var1);
            var1.dismiss();
         } catch (Exception var2) {
            ;
         }
      }

      return this.self();
   }

   public AbstractAQuery download(String var1, File var2, AjaxCallback var3) {
      ((AjaxCallback)((AjaxCallback)var3.url(var1)).type(File.class)).targetFile(var2);
      return this.ajax(var3);
   }

   public AbstractAQuery download(String var1, File var2, Object var3, String var4) {
      AjaxCallback var5 = new AjaxCallback();
      var5.weakHandler(var3, var4);
      return this.download(var1, var2, var5);
   }

   public AbstractAQuery enabled(boolean var1) {
      if(this.view != null) {
         this.view.setEnabled(var1);
      }

      return this.self();
   }

   public AbstractAQuery expand(int var1, boolean var2) {
      if(this.view instanceof ExpandableListView) {
         ExpandableListView var3 = (ExpandableListView)this.view;
         if(var2) {
            var3.expandGroup(var1);
         } else {
            var3.collapseGroup(var1);
         }
      }

      return this.self();
   }

   public AbstractAQuery expand(boolean var1) {
      if(this.view instanceof ExpandableListView) {
         ExpandableListView var4 = (ExpandableListView)this.view;
         ExpandableListAdapter var5 = var4.getExpandableListAdapter();
         if(var5 != null) {
            int var3 = var5.getGroupCount();

            for(int var2 = 0; var2 < var3; ++var2) {
               if(var1) {
                  var4.expandGroup(var2);
               } else {
                  var4.collapseGroup(var2);
               }
            }
         }
      }

      return this.self();
   }

   public AbstractAQuery find(int var1) {
      return this.create(this.findView(var1));
   }

   public Button getButton() {
      return (Button)this.view;
   }

   public File getCachedFile(String var1) {
      File var3 = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(this.getContext(), 1), var1);
      File var2 = var3;
      if(var3 == null) {
         var2 = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(this.getContext(), 0), var1);
      }

      return var2;
   }

   public Bitmap getCachedImage(int var1) {
      return BitmapAjaxCallback.getMemoryCached(this.getContext(), var1);
   }

   public Bitmap getCachedImage(String var1) {
      return this.getCachedImage(var1, 0);
   }

   public Bitmap getCachedImage(String var1, int var2) {
      Bitmap var4 = BitmapAjaxCallback.getMemoryCached(var1, var2);
      Bitmap var3 = var4;
      if(var4 == null) {
         File var5 = this.getCachedFile(var1);
         var3 = var4;
         if(var5 != null) {
            var3 = BitmapAjaxCallback.getResizedImage(var5.getAbsolutePath(), (byte[])null, var2, true, 0);
         }
      }

      return var3;
   }

   public CheckBox getCheckBox() {
      return (CheckBox)this.view;
   }

   public Context getContext() {
      return (Context)(this.act != null?this.act:(this.root != null?this.root.getContext():this.context));
   }

   public EditText getEditText() {
      return (EditText)this.view;
   }

   public Editable getEditable() {
      Editable var1 = null;
      if(this.view instanceof EditText) {
         var1 = ((EditText)this.view).getEditableText();
      }

      return var1;
   }

   public ExpandableListView getExpandableListView() {
      return (ExpandableListView)this.view;
   }

   public Gallery getGallery() {
      return (Gallery)this.view;
   }

   public GridView getGridView() {
      return (GridView)this.view;
   }

   public ImageView getImageView() {
      return (ImageView)this.view;
   }

   public ListView getListView() {
      return (ListView)this.view;
   }

   public ProgressBar getProgressBar() {
      return (ProgressBar)this.view;
   }

   public RatingBar getRatingBar() {
      return (RatingBar)this.view;
   }

   public SeekBar getSeekBar() {
      return (SeekBar)this.view;
   }

   public Object getSelectedItem() {
      Object var1 = null;
      if(this.view instanceof AdapterView) {
         var1 = ((AdapterView)this.view).getSelectedItem();
      }

      return var1;
   }

   public int getSelectedItemPosition() {
      int var1 = -1;
      if(this.view instanceof AdapterView) {
         var1 = ((AdapterView)this.view).getSelectedItemPosition();
      }

      return var1;
   }

   public Spinner getSpinner() {
      return (Spinner)this.view;
   }

   public Object getTag() {
      Object var1 = null;
      if(this.view != null) {
         var1 = this.view.getTag();
      }

      return var1;
   }

   public Object getTag(int var1) {
      Object var2 = null;
      if(this.view != null) {
         var2 = this.view.getTag(var1);
      }

      return var2;
   }

   public CharSequence getText() {
      CharSequence var1 = null;
      if(this.view instanceof TextView) {
         var1 = ((TextView)this.view).getText();
      }

      return var1;
   }

   public TextView getTextView() {
      return (TextView)this.view;
   }

   public View getView() {
      return this.view;
   }

   public WebView getWebView() {
      return (WebView)this.view;
   }

   public AbstractAQuery gone() {
      return this.visibility(8);
   }

   public AbstractAQuery hardwareAccelerated11() {
      if(this.act != null) {
         this.act.getWindow().setFlags(16777216, 16777216);
      }

      return this.self();
   }

   public AbstractAQuery height(int var1) {
      this.size(false, var1, true);
      return this.self();
   }

   public AbstractAQuery height(int var1, boolean var2) {
      this.size(false, var1, var2);
      return this.self();
   }

   public AbstractAQuery id(int var1) {
      return this.id(this.findView(var1));
   }

   public AbstractAQuery id(View var1) {
      this.view = var1;
      this.reset();
      return this.self();
   }

   public AbstractAQuery id(String var1) {
      return this.id(this.findView(var1));
   }

   public AbstractAQuery id(int... var1) {
      return this.id(this.findView(var1));
   }

   public AbstractAQuery image(int var1) {
      if(this.view instanceof ImageView) {
         ImageView var2 = (ImageView)this.view;
         var2.setTag(1090453505, (Object)null);
         if(var1 == 0) {
            var2.setImageBitmap((Bitmap)null);
         } else {
            var2.setImageResource(var1);
         }
      }

      return this.self();
   }

   public AbstractAQuery image(Bitmap var1) {
      if(this.view instanceof ImageView) {
         ImageView var2 = (ImageView)this.view;
         var2.setTag(1090453505, (Object)null);
         var2.setImageBitmap(var1);
      }

      return this.self();
   }

   public AbstractAQuery image(Bitmap var1, float var2) {
      BitmapAjaxCallback var3 = new BitmapAjaxCallback();
      var3.ratio(var2).bitmap(var1);
      return this.image(var3);
   }

   public AbstractAQuery image(Drawable var1) {
      if(this.view instanceof ImageView) {
         ImageView var2 = (ImageView)this.view;
         var2.setTag(1090453505, (Object)null);
         var2.setImageDrawable(var1);
      }

      return this.self();
   }

   public AbstractAQuery image(BitmapAjaxCallback var1) {
      if(this.view instanceof ImageView) {
         var1.imageView((ImageView)this.view);
         this.invoke(var1);
      }

      return this.self();
   }

   public AbstractAQuery image(File var1, int var2) {
      return this.image(var1, true, var2, (BitmapAjaxCallback)null);
   }

   public AbstractAQuery image(File var1, boolean var2, int var3, BitmapAjaxCallback var4) {
      BitmapAjaxCallback var5 = var4;
      if(var4 == null) {
         var5 = new BitmapAjaxCallback();
      }

      var5.file(var1);
      String var6 = null;
      if(var1 != null) {
         var6 = var1.getAbsolutePath();
      }

      return this.image(var6, var2, true, var3, 0, var5);
   }

   public AbstractAQuery image(String var1) {
      return this.image(var1, true, true, 0, 0);
   }

   public AbstractAQuery image(String var1, ImageOptions var2) {
      return this.image(var1, var2, (String)null);
   }

   protected AbstractAQuery image(String var1, ImageOptions var2, String var3) {
      if(this.view instanceof ImageView) {
         BitmapAjaxCallback.async(this.act, this.getContext(), (ImageView)this.view, var1, this.progress, this.ah, var2, this.proxy, var3);
         this.reset();
      }

      return this.self();
   }

   public AbstractAQuery image(String var1, boolean var2, boolean var3) {
      return this.image(var1, var2, var3, 0, 0);
   }

   public AbstractAQuery image(String var1, boolean var2, boolean var3, int var4, int var5) {
      return this.image(var1, var2, var3, var4, var5, (Bitmap)null, 0);
   }

   public AbstractAQuery image(String var1, boolean var2, boolean var3, int var4, int var5, Bitmap var6, int var7) {
      return this.image(var1, var2, var3, var4, var5, var6, var7, 0.0F);
   }

   public AbstractAQuery image(String var1, boolean var2, boolean var3, int var4, int var5, Bitmap var6, int var7, float var8) {
      return this.image(var1, var2, var3, var4, var5, var6, var7, var8, 0, (String)null);
   }

   protected AbstractAQuery image(String var1, boolean var2, boolean var3, int var4, int var5, Bitmap var6, int var7, float var8, int var9, String var10) {
      if(this.view instanceof ImageView) {
         BitmapAjaxCallback.async(this.act, this.getContext(), (ImageView)this.view, var1, var2, var3, var4, var5, var6, var7, var8, Float.MAX_VALUE, this.progress, this.ah, this.policy, var9, this.proxy, var10);
         this.reset();
      }

      return this.self();
   }

   public AbstractAQuery image(String var1, boolean var2, boolean var3, int var4, int var5, BitmapAjaxCallback var6) {
      ((BitmapAjaxCallback)((BitmapAjaxCallback)var6.targetWidth(var4).fallback(var5).url(var1)).memCache(var2)).fileCache(var3);
      return this.image(var6);
   }

   public View inflate(View var1, int var2, ViewGroup var3) {
      if(var1 != null) {
         Integer var4 = (Integer)var1.getTag(1090453507);
         if(var4 != null && var4.intValue() == var2) {
            return var1;
         }
      }

      LayoutInflater var5;
      if(this.act != null) {
         var5 = this.act.getLayoutInflater();
      } else {
         var5 = (LayoutInflater)this.getContext().getSystemService("layout_inflater");
      }

      var1 = var5.inflate(var2, var3, false);
      var1.setTag(1090453507, Integer.valueOf(var2));
      return var1;
   }

   public AbstractAQuery invalidate(String var1) {
      File var2 = this.getCachedFile(var1);
      if(var2 != null) {
         var2.delete();
      }

      return this.self();
   }

   public AbstractAQuery invisible() {
      return this.visibility(4);
   }

   protected AbstractAQuery invoke(AbstractAjaxCallback var1) {
      if(this.ah != null) {
         var1.auth(this.ah);
      }

      if(this.progress != null) {
         var1.progress(this.progress);
      }

      if(this.trans != null) {
         var1.transformer(this.trans);
      }

      var1.policy(this.policy);
      if(this.proxy != null) {
         var1.proxy(this.proxy.getHostName(), this.proxy.getPort());
      }

      if(this.act != null) {
         var1.async(this.act);
      } else {
         var1.async(this.getContext());
      }

      this.reset();
      return this.self();
   }

   public Object invoke(String var1, Class[] var2, Object... var3) {
      View var5 = this.view;
      Object var4 = var5;
      if(var5 == null) {
         var4 = this.act;
      }

      return AQUtility.invokeHandler(var4, var1, false, false, var2, var3);
   }

   public boolean isChecked() {
      boolean var1 = false;
      if(this.view instanceof CompoundButton) {
         var1 = ((CompoundButton)this.view).isChecked();
      }

      return var1;
   }

   public boolean isExist() {
      return this.view != null;
   }

   public AbstractAQuery itemClicked(OnItemClickListener var1) {
      if(this.view instanceof AdapterView) {
         ((AdapterView)this.view).setOnItemClickListener(var1);
      }

      return this.self();
   }

   public AbstractAQuery itemClicked(Object var1, String var2) {
      return this.itemClicked((new Common()).forward(var1, var2, true, ON_ITEM_SIG));
   }

   public AbstractAQuery itemLongClicked(OnItemLongClickListener var1) {
      if(this.view instanceof AdapterView) {
         ((AdapterView)this.view).setOnItemLongClickListener(var1);
      }

      return this.self();
   }

   public AbstractAQuery itemLongClicked(Object var1, String var2) {
      return this.itemLongClicked((new Common()).forward(var1, var2, true, ON_ITEM_SIG));
   }

   public AbstractAQuery itemSelected(OnItemSelectedListener var1) {
      if(this.view instanceof AdapterView) {
         ((AdapterView)this.view).setOnItemSelectedListener(var1);
      }

      return this.self();
   }

   public AbstractAQuery itemSelected(Object var1, String var2) {
      return this.itemSelected((new Common()).forward(var1, var2, true, ON_ITEM_SIG));
   }

   public AbstractAQuery longClick() {
      if(this.view != null) {
         this.view.performLongClick();
      }

      return this.self();
   }

   public AbstractAQuery longClicked(OnLongClickListener var1) {
      if(this.view != null) {
         this.view.setOnLongClickListener(var1);
      }

      return this.self();
   }

   public AbstractAQuery longClicked(Object var1, String var2) {
      return this.longClicked((new Common()).forward(var1, var2, true, ON_CLICK_SIG));
   }

   public File makeSharedFile(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public AbstractAQuery margin(float var1, float var2, float var3, float var4) {
      if(this.view != null) {
         LayoutParams var9 = this.view.getLayoutParams();
         if(var9 instanceof MarginLayoutParams) {
            Context var10 = this.getContext();
            int var5 = AQUtility.dip2pixel(var10, var1);
            int var6 = AQUtility.dip2pixel(var10, var2);
            int var7 = AQUtility.dip2pixel(var10, var3);
            int var8 = AQUtility.dip2pixel(var10, var4);
            ((MarginLayoutParams)var9).setMargins(var5, var6, var7, var8);
            this.view.setLayoutParams(var9);
         }
      }

      return this.self();
   }

   public AbstractAQuery overridePendingTransition5(int var1, int var2) {
      if(this.act != null) {
         AQUtility.invokeHandler(this.act, "overridePendingTransition", false, false, PENDING_TRANSITION_SIG, new Object[]{Integer.valueOf(var1), Integer.valueOf(var2)});
      }

      return this.self();
   }

   public AbstractAQuery parent(int var1) {
      View var2 = this.view;
      Object var4 = null;

      View var3;
      while(true) {
         var3 = (View)var4;
         if(var2 == null) {
            break;
         }

         if(var2.getId() == var1) {
            var3 = var2;
            break;
         }

         ViewParent var5 = var2.getParent();
         var3 = (View)var4;
         if(!(var5 instanceof View)) {
            break;
         }

         var2 = (View)var5;
      }

      return this.create(var3);
   }

   public AbstractAQuery policy(int var1) {
      this.policy = var1;
      return this.self();
   }

   public AbstractAQuery post(String var1, String var2, HttpEntity var3, Class var4, AjaxCallback var5) {
      ((AjaxCallback)((AjaxCallback)((AjaxCallback)((AjaxCallback)var5.url(var1)).type(var4)).method(1)).header("Content-Type", var2)).param("%entity", var3);
      return this.ajax(var5);
   }

   public AbstractAQuery post(String var1, JSONObject var2, Class var3, AjaxCallback var4) {
      try {
         AbstractAQuery var6 = this.post(var1, "application/json", new StringEntity(var2.toString(), "UTF-8"), var3, var4);
         return var6;
      } catch (UnsupportedEncodingException var5) {
         throw new IllegalArgumentException(var5);
      }
   }

   public AbstractAQuery progress(int var1) {
      this.progress = this.findView(var1);
      return this.self();
   }

   public AbstractAQuery progress(Dialog var1) {
      this.progress = var1;
      return this.self();
   }

   public AbstractAQuery progress(Object var1) {
      this.progress = var1;
      return this.self();
   }

   public AbstractAQuery proxy(String var1, int var2) {
      this.proxy = new HttpHost(var1, var2);
      return this.self();
   }

   public AbstractAQuery put(String var1, String var2, HttpEntity var3, Class var4, AjaxCallback var5) {
      ((AjaxCallback)((AjaxCallback)((AjaxCallback)((AjaxCallback)var5.url(var1)).type(var4)).method(3)).header("Content-Type", var2)).param("%entity", var3);
      return this.ajax(var5);
   }

   public AbstractAQuery put(String var1, JSONObject var2, Class var3, AjaxCallback var4) {
      try {
         AbstractAQuery var6 = this.put(var1, "application/json", new StringEntity(var2.toString(), "UTF-8"), var3, var4);
         return var6;
      } catch (UnsupportedEncodingException var5) {
         throw new IllegalArgumentException(var5);
      }
   }

   public AbstractAQuery rating(float var1) {
      if(this.view instanceof RatingBar) {
         ((RatingBar)this.view).setRating(var1);
      }

      return this.self();
   }

   public AbstractAQuery recycle(View var1) {
      this.root = var1;
      this.view = var1;
      this.reset();
      this.context = null;
      return this.self();
   }

   protected void reset() {
      this.ah = null;
      this.progress = null;
      this.trans = null;
      this.policy = 0;
      this.proxy = null;
   }

   public AbstractAQuery scrolled(OnScrollListener var1) {
      if(this.view instanceof AbsListView) {
         this.setScrollListener().forward(var1);
      }

      return this.self();
   }

   public AbstractAQuery scrolledBottom(Object var1, String var2) {
      if(this.view instanceof AbsListView) {
         this.setScrollListener().forward(var1, var2, true, ON_SCROLLED_STATE_SIG);
      }

      return this.self();
   }

   protected AbstractAQuery self() {
      return this;
   }

   public AbstractAQuery setLayerType11(int var1, Paint var2) {
      if(this.view != null) {
         AQUtility.invokeHandler(this.view, "setLayerType", false, false, LAYER_TYPE_SIG, new Object[]{Integer.valueOf(var1), var2});
      }

      return this.self();
   }

   public AbstractAQuery setOverScrollMode9(int var1) {
      if(this.view instanceof AbsListView) {
         AQUtility.invokeHandler(this.view, "setOverScrollMode", false, false, OVER_SCROLL_SIG, new Object[]{Integer.valueOf(var1)});
      }

      return this.self();
   }

   public AbstractAQuery setSelection(int var1) {
      if(this.view instanceof AdapterView) {
         ((AdapterView)this.view).setSelection(var1);
      }

      return this.self();
   }

   public boolean shouldDelay(int var1, int var2, boolean var3, View var4, ViewGroup var5, String var6) {
      return Common.shouldDelay(var1, var2, var4, var5, var6);
   }

   public boolean shouldDelay(int var1, View var2, ViewGroup var3, String var4) {
      if(var3 instanceof ExpandableListView) {
         throw new IllegalArgumentException("Please use the other shouldDelay methods for expandable list.");
      } else {
         return Common.shouldDelay(var1, var2, var3, var4);
      }
   }

   public boolean shouldDelay(int var1, boolean var2, View var3, ViewGroup var4, String var5) {
      return Common.shouldDelay(var1, -1, var3, var4, var5);
   }

   @Deprecated
   public boolean shouldDelay(View var1, ViewGroup var2, String var3, float var4) {
      return Common.shouldDelay(var1, var2, var3, var4, true);
   }

   @Deprecated
   public boolean shouldDelay(View var1, ViewGroup var2, String var3, float var4, boolean var5) {
      return Common.shouldDelay(var1, var2, var3, var4, var5);
   }

   public AbstractAQuery show(Dialog var1) {
      if(var1 != null) {
         try {
            var1.show();
            dialogs.put(var1, (Object)null);
         } catch (Exception var2) {
            ;
         }
      }

      return this.self();
   }

   public AbstractAQuery sync(AjaxCallback var1) {
      this.ajax(var1);
      var1.block();
      return this.self();
   }

   public AbstractAQuery tag(int var1, Object var2) {
      if(this.view != null) {
         this.view.setTag(var1, var2);
      }

      return this.self();
   }

   public AbstractAQuery tag(Object var1) {
      if(this.view != null) {
         this.view.setTag(var1);
      }

      return this.self();
   }

   public AbstractAQuery text(int var1) {
      if(this.view instanceof TextView) {
         ((TextView)this.view).setText(var1);
      }

      return this.self();
   }

   public AbstractAQuery text(int var1, Object... var2) {
      Context var3 = this.getContext();
      if(var3 != null) {
         this.text((CharSequence)var3.getString(var1, var2));
      }

      return this.self();
   }

   public AbstractAQuery text(Spanned var1) {
      if(this.view instanceof TextView) {
         ((TextView)this.view).setText(var1);
      }

      return this.self();
   }

   public AbstractAQuery text(CharSequence var1) {
      if(this.view instanceof TextView) {
         ((TextView)this.view).setText(var1);
      }

      return this.self();
   }

   public AbstractAQuery text(CharSequence var1, boolean var2) {
      return var2 && (var1 == null || var1.length() == 0)?this.gone():this.text(var1);
   }

   public AbstractAQuery textChanged(Object var1, String var2) {
      if(this.view instanceof TextView) {
         ((TextView)this.view).addTextChangedListener((new Common()).forward(var1, var2, true, TEXT_CHANGE_SIG));
      }

      return this.self();
   }

   public AbstractAQuery textColor(int var1) {
      if(this.view instanceof TextView) {
         ((TextView)this.view).setTextColor(var1);
      }

      return this.self();
   }

   public AbstractAQuery textColorId(int var1) {
      return this.textColor(this.getContext().getResources().getColor(var1));
   }

   public AbstractAQuery textSize(float var1) {
      if(this.view instanceof TextView) {
         ((TextView)this.view).setTextSize(var1);
      }

      return this.self();
   }

   public AbstractAQuery transformer(Transformer var1) {
      this.trans = var1;
      return this.self();
   }

   public AbstractAQuery transparent(boolean var1) {
      if(this.view != null) {
         AQUtility.transparent(this.view, var1);
      }

      return this.self();
   }

   public AbstractAQuery typeface(Typeface var1) {
      if(this.view instanceof TextView) {
         ((TextView)this.view).setTypeface(var1);
      }

      return this.self();
   }

   public AbstractAQuery visibility(int var1) {
      if(this.view != null && this.view.getVisibility() != var1) {
         this.view.setVisibility(var1);
      }

      return this.self();
   }

   public AbstractAQuery visible() {
      return this.visibility(0);
   }

   public AbstractAQuery webImage(String var1) {
      return this.webImage(var1, true, false, -16777216);
   }

   public AbstractAQuery webImage(String var1, boolean var2, boolean var3, int var4) {
      if(this.view instanceof WebView) {
         this.setLayerType11(1, (Paint)null);
         (new WebImage((WebView)this.view, var1, this.progress, var2, var3, var4)).load();
         this.progress = null;
      }

      return this.self();
   }

   public AbstractAQuery width(int var1) {
      this.size(true, var1, true);
      return this.self();
   }

   public AbstractAQuery width(int var1, boolean var2) {
      this.size(true, var1, var2);
      return this.self();
   }
}
