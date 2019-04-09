package io.fashionet.community.user.configuration;

import io.fashionet.community.CommunityCoreConstant;
import io.fashionet.core.base.utils.RsaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Autowired
    public void initUserRsaRegister(RsaUtil rsaUtil) {
        rsaUtil.initRsaPair(CommunityCoreConstant.Module.USER);
    }
}
