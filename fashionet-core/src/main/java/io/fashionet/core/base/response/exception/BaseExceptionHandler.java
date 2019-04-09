package io.fashionet.core.base.response.exception;

import io.fashionet.core.base.response.EResponseResult;
import io.fashionet.core.base.response.Response;
import io.fashionet.core.base.utils.CommonUtil;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    private ResponseEntity<Response> handleException(Exception ex) {
        logger.info(String.format("Exception：%s", CommonUtil.printStackTraceElements(ex.getStackTrace())));
        return new ResponseEntity<Response>(Response.ResponseBuilder
                .result(EResponseResult.ERROR_INTERVAL)
                .error(CommonUtil.printStackTraceElements(ex.getStackTrace()))
                .create(), HttpStatus.OK);
    }
}
