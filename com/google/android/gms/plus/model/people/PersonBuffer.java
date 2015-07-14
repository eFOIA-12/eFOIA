package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.pi;
import com.google.android.gms.internal.pt;
import com.google.android.gms.plus.model.people.Person;

public final class PersonBuffer extends DataBuffer {
   private final e apT;

   public PersonBuffer(DataHolder var1) {
      super(var1);
      if(var1.gV() != null && var1.gV().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
         this.apT = new e(var1, pi.CREATOR);
      } else {
         this.apT = null;
      }
   }

   public Person get(int var1) {
      return (Person)(this.apT != null?(Person)this.apT.at(var1):new pt(this.JG, var1));
   }
}
