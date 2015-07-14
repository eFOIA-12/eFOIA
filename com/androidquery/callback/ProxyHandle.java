package com.androidquery.callback;

import com.androidquery.callback.AbstractAjaxCallback;
import java.net.Proxy;
import org.apache.http.HttpRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public abstract class ProxyHandle {
   public abstract void applyProxy(AbstractAjaxCallback var1, HttpRequest var2, DefaultHttpClient var3);

   public abstract Proxy makeProxy(AbstractAjaxCallback var1);
}
