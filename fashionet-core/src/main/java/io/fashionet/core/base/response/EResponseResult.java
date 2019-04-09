package io.fashionet.core.base.response;

import io.fashionet.core.base.BaseConstant;
import io.fashionet.core.base.configuration.BaseConfiguration;
import org.apache.commons.lang.StringUtils;

public enum EResponseResult {
    OK(BaseConstant.Response.Code.OK, "", ""),
    ERROR_INTERVAL(BaseConstant.Response.Code.ERROR_INTERVAL, "common.message.interval", "common.error.interval");

    private Integer code;
    private String message;
    private String error;

    EResponseResult(Integer code, String messageCode, String errorCode) {
        this.code = code;
        this.message = !StringUtils.isEmpty(messageCode) ? BaseConfiguration.getMessage(messageCode) : "";
        this.error = !StringUtils.isEmpty(errorCode) ? BaseConfiguration.getMessage(errorCode) : null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
