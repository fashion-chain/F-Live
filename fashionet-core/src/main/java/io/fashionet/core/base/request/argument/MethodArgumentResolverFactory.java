package io.fashionet.core.base.request.argument;


import io.fashionet.core.base.request.argument.base.BaseParamArgumentResolver;
import io.fashionet.core.base.request.argument.flag.FlagMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.ArrayList;
import java.util.List;

public class MethodArgumentResolverFactory {
    public static List<HandlerMethodArgumentResolver> resolverList() {
        List<HandlerMethodArgumentResolver> resolverList = new ArrayList<>();
        resolverList.add(new FlagMethodArgumentResolver());
        resolverList.add(new BaseParamArgumentResolver());
        return resolverList;
    }
}
