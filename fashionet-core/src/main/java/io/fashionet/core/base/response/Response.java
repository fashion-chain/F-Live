package io.fashionet.core.base.response;

import io.fashionet.core.base.request.argument.flag.FlagPageable;
import org.springframework.data.domain.Page;

public class Response {
    private Integer code;
    private Object data;
    private String message;
    private String error;
    private String flag;
    private String flagPre;

    private Response(Integer code, Object data, String message, String error, String flag, String flagPre) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.error = error;
        this.flag = flag;
        this.flagPre = flagPre;
    }

    public boolean isSuccess() {
        return code == 0;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public String getFlag() {
        return flag;
    }

    public String getFlagPre() {
        return flagPre;
    }

    public static class ResponseBuilder {
        private Integer code;
        private Object data;
        private String message;
        private String error;
        private String flag;
        private String flagPre;

        public static ResponseBuilder result(EResponseResult result) {
            ResponseBuilder builder = new ResponseBuilder();
            builder.code(result.getCode());
            builder.message(result.getMessage());
            builder.error(result.getError());
            return builder;
        }

        public ResponseBuilder pageableSortable(Page<?> page, FlagPageable flagPageable) {
            this.flagPre(flagPageable.hasPrevious() ? flagPageable.getFlagResolver().previous() : null);
            this.flag(page.getNumberOfElements() >= flagPageable.getFlagResolver().getSize() ? flagPageable.getFlagResolver().next() : null);
            return this;
        }

        public ResponseBuilder code(int code) {
            this.code = code;
            return this;
        }

        public ResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public ResponseBuilder flag(String flag) {
            this.flag = flag;
            return this;
        }

        public ResponseBuilder flagPre(String flagPre) {
            this.flagPre = flagPre;
            return this;
        }

        public ResponseBuilder error(String error) {
            this.error = error;
            return this;
        }

        public Response create() {
            return new Response(this.code,
                    this.data,
                    this.message,
                    this.error,
                    this.flag,
                    this.flagPre);
        }
    }
}
