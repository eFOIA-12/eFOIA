package android.support.v7.internal.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class AppCompatViewInflater {
   private static final Map sConstructorMap = new HashMap();
   static final Class[] sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
   private final Object[] mConstructorArgs = new Object[2];
   private final Context mContext;

   public AppCompatViewInflater(Context var1) {
      this.mContext = var1;
   }

   private View createView(String param1, String param2) throws ClassNotFoundException, InflateException {
      // $FF: Couldn't be decompiled
   }

   private View createViewFromTag(Context var1, String var2, AttributeSet var3) {
      String var4 = var2;
      if(var2.equals("view")) {
         var4 = var3.getAttributeValue((String)null, "class");
      }

      View var9;
      try {
         this.mConstructorArgs[0] = var1;
         this.mConstructorArgs[1] = var3;
         if(-1 == var4.indexOf(46)) {
            var9 = this.createView(var4, "android.widget.");
            return var9;
         }

         var9 = this.createView(var4, (String)null);
      } catch (Exception var7) {
         return null;
      } finally {
         this.mConstructorArgs[0] = null;
         this.mConstructorArgs[1] = null;
      }

      return var9;
   }

   public final View createView(View var1, String var2, @NonNull Context var3, @NonNull AttributeSet var4, boolean var5, boolean var6) {
      Context var8 = var3;
      if(var5) {
         var8 = var3;
         if(var1 != null) {
            var8 = var1.getContext();
         }
      }

      Context var9 = var8;
      if(var6) {
         var9 = ViewUtils.themifyContext(var8, var4, true, true);
      }

      byte var7 = -1;
      switch(var2.hashCode()) {
      case -1946472170:
         if(var2.equals("RatingBar")) {
            var7 = 7;
         }
         break;
      case -1455429095:
         if(var2.equals("CheckedTextView")) {
            var7 = 4;
         }
         break;
      case -1346021293:
         if(var2.equals("MultiAutoCompleteTextView")) {
            var7 = 6;
         }
         break;
      case -938935918:
         if(var2.equals("TextView")) {
            var7 = 9;
         }
         break;
      case -339785223:
         if(var2.equals("Spinner")) {
            var7 = 1;
         }
         break;
      case 776382189:
         if(var2.equals("RadioButton")) {
            var7 = 3;
         }
         break;
      case 1413872058:
         if(var2.equals("AutoCompleteTextView")) {
            var7 = 5;
         }
         break;
      case 1601505219:
         if(var2.equals("CheckBox")) {
            var7 = 2;
         }
         break;
      case 1666676343:
         if(var2.equals("EditText")) {
            var7 = 0;
         }
         break;
      case 2001146706:
         if(var2.equals("Button")) {
            var7 = 8;
         }
      }

      switch(var7) {
      case 0:
         return new AppCompatEditText(var9, var4);
      case 1:
         return new AppCompatSpinner(var9, var4);
      case 2:
         return new AppCompatCheckBox(var9, var4);
      case 3:
         return new AppCompatRadioButton(var9, var4);
      case 4:
         return new AppCompatCheckedTextView(var9, var4);
      case 5:
         return new AppCompatAutoCompleteTextView(var9, var4);
      case 6:
         return new AppCompatMultiAutoCompleteTextView(var9, var4);
      case 7:
         return new AppCompatRatingBar(var9, var4);
      case 8:
         return new AppCompatButton(var9, var4);
      case 9:
         return new AppCompatTextView(var9, var4);
      default:
         return var3 != var9?this.createViewFromTag(var9, var2, var4):null;
      }
   }
}
