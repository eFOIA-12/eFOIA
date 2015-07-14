package org.apache.http.config;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.MessageConstraints;
import org.apache.http.util.Args;

@Immutable
public class ConnectionConfig implements Cloneable {
   public static final ConnectionConfig DEFAULT = (new ConnectionConfig.Builder()).build();
   private final int bufferSize;
   private final Charset charset;
   private final int fragmentSizeHint;
   private final CodingErrorAction malformedInputAction;
   private final MessageConstraints messageConstraints;
   private final CodingErrorAction unmappableInputAction;

   ConnectionConfig(int var1, int var2, Charset var3, CodingErrorAction var4, CodingErrorAction var5, MessageConstraints var6) {
      this.bufferSize = var1;
      this.fragmentSizeHint = var2;
      this.charset = var3;
      this.malformedInputAction = var4;
      this.unmappableInputAction = var5;
      this.messageConstraints = var6;
   }

   public static ConnectionConfig.Builder copy(ConnectionConfig var0) {
      Args.notNull(var0, "Connection config");
      return (new ConnectionConfig.Builder()).setCharset(var0.getCharset()).setMalformedInputAction(var0.getMalformedInputAction()).setUnmappableInputAction(var0.getUnmappableInputAction()).setMessageConstraints(var0.getMessageConstraints());
   }

   public static ConnectionConfig.Builder custom() {
      return new ConnectionConfig.Builder();
   }

   protected ConnectionConfig clone() throws CloneNotSupportedException {
      return (ConnectionConfig)super.clone();
   }

   public int getBufferSize() {
      return this.bufferSize;
   }

   public Charset getCharset() {
      return this.charset;
   }

   public int getFragmentSizeHint() {
      return this.fragmentSizeHint;
   }

   public CodingErrorAction getMalformedInputAction() {
      return this.malformedInputAction;
   }

   public MessageConstraints getMessageConstraints() {
      return this.messageConstraints;
   }

   public CodingErrorAction getUnmappableInputAction() {
      return this.unmappableInputAction;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[bufferSize=").append(this.bufferSize).append(", fragmentSizeHint=").append(this.fragmentSizeHint).append(", charset=").append(this.charset).append(", malformedInputAction=").append(this.malformedInputAction).append(", unmappableInputAction=").append(this.unmappableInputAction).append(", messageConstraints=").append(this.messageConstraints).append("]");
      return var1.toString();
   }

   public static class Builder {
      private int bufferSize;
      private Charset charset;
      private int fragmentSizeHint = -1;
      private CodingErrorAction malformedInputAction;
      private MessageConstraints messageConstraints;
      private CodingErrorAction unmappableInputAction;

      public ConnectionConfig build() {
         Charset var4 = this.charset;
         Charset var3 = var4;
         if(var4 == null) {
            label22: {
               if(this.malformedInputAction == null) {
                  var3 = var4;
                  if(this.unmappableInputAction == null) {
                     break label22;
                  }
               }

               var3 = Consts.ASCII;
            }
         }

         int var1;
         if(this.bufferSize > 0) {
            var1 = this.bufferSize;
         } else {
            var1 = 8192;
         }

         int var2;
         if(this.fragmentSizeHint >= 0) {
            var2 = this.fragmentSizeHint;
         } else {
            var2 = var1;
         }

         return new ConnectionConfig(var1, var2, var3, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
      }

      public ConnectionConfig.Builder setBufferSize(int var1) {
         this.bufferSize = var1;
         return this;
      }

      public ConnectionConfig.Builder setCharset(Charset var1) {
         this.charset = var1;
         return this;
      }

      public ConnectionConfig.Builder setFragmentSizeHint(int var1) {
         this.fragmentSizeHint = var1;
         return this;
      }

      public ConnectionConfig.Builder setMalformedInputAction(CodingErrorAction var1) {
         this.malformedInputAction = var1;
         if(var1 != null && this.charset == null) {
            this.charset = Consts.ASCII;
         }

         return this;
      }

      public ConnectionConfig.Builder setMessageConstraints(MessageConstraints var1) {
         this.messageConstraints = var1;
         return this;
      }

      public ConnectionConfig.Builder setUnmappableInputAction(CodingErrorAction var1) {
         this.unmappableInputAction = var1;
         if(var1 != null && this.charset == null) {
            this.charset = Consts.ASCII;
         }

         return this;
      }
   }
}
