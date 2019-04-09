package io.fashionet.core.base;

public class BaseConstant {
    public static class Request {
        public static class Header {
            public static final String HEADER_BASE_AGENT = "b_agent";

            public static final String SPLITTER = "&";

            public static final String APP_VERSION = "av";
            public static final String SYSTEM_VERSION = "sv";
            public static final String DEVICE_MODEL = "dm";
            public static final String DEVICE_ID = "di";
            public static final String NETWORK_TYPE = "nt";
            public static final String RESOLUTION_RATIO = "rr";
            public static final String ADAPTER_WIDTH = "aw";
            public static final String LATITUDE_LONGITUDE = "ll";
            public static final String USER_ID = "ui";
        }

        public static class Argument {
            public static final String FLAG = "flag";
            public static final String SORT = "sort";
        }
    }

    public static class Response {
        public static final Integer PAGE_SIZE = 20;

        public static class Code {
            public static final Integer OK = 0;
            public static final Integer ERROR_INTERVAL = 1;
        }
    }
}
