package io.fashionet.core.base.controller;

import io.fashionet.core.base.response.EResponseResult;
import io.fashionet.core.base.response.Response;
import io.fashionet.core.base.utils.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "/common")
public class CommonController {

    @RequestMapping(path = "/tick", method = RequestMethod.GET)
    private Response tick(HttpServletRequest request) {
        return Response.ResponseBuilder
                .result(EResponseResult.OK)
                .data(String.format("tick time: %s", new SimpleDateFormat(DateUtil.FORMAT_NORMAL).format(new Date())))
                .create();
    }
}
