package io.fashionet.core.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(String error) {
        logger.error(error);
    }

    public static void error(StackTraceElement[] elements) {
        logger.error(CommonUtil.printStackTraceElements(elements));
    }
}
