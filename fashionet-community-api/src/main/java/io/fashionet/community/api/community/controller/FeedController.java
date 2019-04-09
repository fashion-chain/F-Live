package io.fashionet.community.api.community.controller;

import io.fashionet.community.community.repository.FetRepository;
import io.fashionet.core.base.response.EResponseResult;
import io.fashionet.core.base.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/feed")
public class FeedController {

    @Autowired
    public FetRepository fetRepository;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public Response feedList() {
        return Response.ResponseBuilder.result(EResponseResult.OK).create();
    }
}
