package com.androidquery.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public class XmlDom {
   private Element root;

   public XmlDom(InputStream var1) throws SAXException {
      DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();

      try {
         this.root = var2.newDocumentBuilder().parse(var1).getDocumentElement();
      } catch (ParserConfigurationException var3) {
         ;
      } catch (IOException var4) {
         throw new SAXException(var4);
      }
   }

   public XmlDom(String var1) throws SAXException {
      this(var1.getBytes());
   }

   public XmlDom(Element var1) {
      this.root = var1;
   }

   public XmlDom(byte[] var1) throws SAXException {
      this((InputStream)(new ByteArrayInputStream(var1)));
   }

   private static XmlDom convert(Node var0, String var1, String var2, String var3) {
      if(var0.getNodeType() == 1) {
         Element var4 = (Element)var0;
         if((var1 == null || var1.equals(var4.getTagName())) && (var2 == null || var4.hasAttribute(var2)) && (var3 == null || var3.equals(var4.getAttribute(var2)))) {
            return new XmlDom(var4);
         }
      }

      return null;
   }

   private static List convert(NodeList var0, String var1, String var2, String var3) {
      ArrayList var5 = new ArrayList();

      for(int var4 = 0; var4 < var0.getLength(); ++var4) {
         XmlDom var6 = convert(var0.item(var4), var1, var2, var3);
         if(var6 != null) {
            var5.add(var6);
         }
      }

      return var5;
   }

   private String serialize(Element param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private void serialize(Element var1, XmlSerializer var2, int var3, String var4) throws Exception {
      String var8 = var1.getTagName();
      this.writeSpace(var2, var3, var4);
      var2.startTag("", var8);
      int var5;
      if(var1.hasAttributes()) {
         NamedNodeMap var9 = var1.getAttributes();

         for(var5 = 0; var5 < var9.getLength(); ++var5) {
            Attr var10 = (Attr)var9.item(var5);
            var2.attribute("", var10.getName(), var10.getValue());
         }
      }

      if(var1.hasChildNodes()) {
         NodeList var11 = var1.getChildNodes();
         int var6 = 0;

         int var7;
         for(var5 = 0; var5 < var11.getLength(); var6 = var7) {
            Node var12 = var11.item(var5);
            var7 = var6;
            switch(var12.getNodeType()) {
            case 1:
               this.serialize((Element)var12, var2, var3 + 1, var4);
               var7 = var6 + 1;
            case 2:
               break;
            case 3:
               var2.text(this.text(var12));
               var7 = var6;
               break;
            case 4:
               var2.cdsect(this.text(var12));
               var7 = var6;
               break;
            default:
               var7 = var6;
            }

            ++var5;
         }

         if(var6 > 0) {
            this.writeSpace(var2, var3, var4);
         }
      }

      var2.endTag("", var8);
   }

   private String text(Node var1) {
      String var2 = null;
      String var3;
      switch(var1.getNodeType()) {
      case 3:
         var2 = var1.getNodeValue();
         var3 = var2;
         if(var2 != null) {
            var3 = var2.trim();
         }
         break;
      case 4:
         var3 = var1.getNodeValue();
         break;
      default:
         var3 = var2;
      }

      var2 = var3;
      if(var3 == null) {
         var2 = "";
      }

      return var2;
   }

   private void writeSpace(XmlSerializer var1, int var2, String var3) throws Exception {
      if(var3 != null) {
         var1.text("\n");

         for(int var4 = 0; var4 < var2; ++var4) {
            var1.text(var3);
         }
      }

   }

   public String attr(String var1) {
      return this.root.getAttribute(var1);
   }

   public XmlDom child(String var1) {
      return this.child(var1, (String)null, (String)null);
   }

   public XmlDom child(String var1, String var2, String var3) {
      List var4 = this.children(var1, var2, var3);
      return var4.size() == 0?null:(XmlDom)var4.get(0);
   }

   public List children(String var1) {
      return this.children(var1, (String)null, (String)null);
   }

   public List children(String var1, String var2, String var3) {
      return convert(this.root.getChildNodes(), var1, var2, var3);
   }

   public Element getElement() {
      return this.root;
   }

   public XmlDom tag(String var1) {
      NodeList var3 = this.root.getElementsByTagName(var1);
      Object var2 = null;
      XmlDom var4 = (XmlDom)var2;
      if(var3 != null) {
         var4 = (XmlDom)var2;
         if(var3.getLength() > 0) {
            var4 = new XmlDom((Element)var3.item(0));
         }
      }

      return var4;
   }

   public XmlDom tag(String var1, String var2, String var3) {
      List var4 = this.tags(var1, var2, var3);
      return var4.size() == 0?null:(XmlDom)var4.get(0);
   }

   public List tags(String var1) {
      return this.tags(var1, (String)null, (String)null);
   }

   public List tags(String var1, String var2, String var3) {
      return convert((NodeList)this.root.getElementsByTagName(var1), (String)null, var2, var3);
   }

   public String text() {
      NodeList var2 = this.root.getChildNodes();
      if(var2.getLength() == 1) {
         return var2.item(0).getNodeValue();
      } else {
         StringBuilder var3 = new StringBuilder();

         for(int var1 = 0; var1 < var2.getLength(); ++var1) {
            var3.append(this.text(var2.item(var1)));
         }

         return var3.toString();
      }
   }

   public String text(String var1) {
      XmlDom var2 = this.child(var1);
      return var2 == null?null:var2.text();
   }

   public String toString() {
      return this.toString(0);
   }

   public String toString(int var1) {
      return this.serialize(this.root, var1);
   }
}
