package org.apache.http.params;

@Deprecated
public interface CoreProtocolPNames {
   String HTTP_CONTENT_CHARSET = "http.protocol.content-charset";
   String HTTP_ELEMENT_CHARSET = "http.protocol.element-charset";
   String HTTP_MALFORMED_INPUT_ACTION = "http.malformed.input.action";
   String HTTP_UNMAPPABLE_INPUT_ACTION = "http.unmappable.input.action";
   String ORIGIN_SERVER = "http.origin-server";
   String PROTOCOL_VERSION = "http.protocol.version";
   String STRICT_TRANSFER_ENCODING = "http.protocol.strict-transfer-encoding";
   String USER_AGENT = "http.useragent";
   String USE_EXPECT_CONTINUE = "http.protocol.expect-continue";
   String WAIT_FOR_CONTINUE = "http.protocol.wait-for-continue";
}
