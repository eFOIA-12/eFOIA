package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.Nullable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintContextWrapper;
import android.support.v7.internal.widget.TintInfo;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {
   private static final int[] TINT_ATTRS = new int[]{16842964, 16843126};
   private TintInfo mBackgroundTint;
   private TintManager mTintManager;

   public AppCompatMultiAutoCompleteTextView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatMultiAutoCompleteTextView(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.autoCompleteTextViewStyle);
   }

   public AppCompatMultiAutoCompleteTextView(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.wrap(var1), var2, var3);
      if(TintManager.SHOULD_BE_USED) {
         TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
         this.mTintManager = var4.getTintManager();
         if(var4.hasValue(0)) {
            ColorStateList var5 = var4.getTintManager().getTintList(var4.getResourceId(0, -1));
            if(var5 != null) {
               this.setSupportBackgroundTintList(var5);
            }
         }

         if(var4.hasValue(1)) {
            this.setDropDownBackgroundDrawable(var4.getDrawable(1));
         }

         var4.recycle();
      }

   }

   private void applySupportBackgroundTint() {
      if(this.getBackground() != null && this.mBackgroundTint != null) {
         TintManager.tintViewBackground(this, this.mBackgroundTint);
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.applySupportBackgroundTint();
   }

   @Nullable
   public ColorStateList getSupportBackgroundTintList() {
      return this.mBackgroundTint != null?this.mBackgroundTint.mTintList:null;
   }

   @Nullable
   public Mode getSupportBackgroundTintMode() {
      return this.mBackgroundTint != null?this.mBackgroundTint.mTintMode:null;
   }

   public void setDropDownBackgroundResource(int var1) {
      if(this.mTintManager != null) {
         this.setDropDownBackgroundDrawable(this.mTintManager.getDrawable(var1));
      } else {
         super.setDropDownBackgroundResource(var1);
      }
   }

   public void setSupportBackgroundTintList(@Nullable ColorStateList var1) {
      if(this.mBackgroundTint == null) {
         this.mBackgroundTint = new TintInfo();
      }

      this.mBackgroundTint.mTintList = var1;
      this.mBackgroundTint.mHasTintList = true;
      this.applySupportBackgroundTint();
   }

   public void setSupportBackgroundTintMode(@Nullable Mode var1) {
      if(this.mBackgroundTint == null) {
         this.mBackgroundTint = new TintInfo();
      }

      this.mBackgroundTint.mTintMode = var1;
      this.mBackgroundTint.mHasTintMode = true;
      this.applySupportBackgroundTint();
   }
}
