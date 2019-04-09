package io.fashionet.community.user.model.converter;

import com.google.gson.reflect.TypeToken;
import io.fashionet.core.base.model.converter.StringAttributeConverter;
import io.fashionet.core.base.model.converter.StringObjectMapper;
import io.fashionet.community.user.model.bean.Mobile;

import java.lang.reflect.Type;

public class MobileConverter extends StringAttributeConverter<Mobile> {

    @Override
    public Mobile convertToEntityAttribute(String s) {
        return Mobile.parseFromString(s);
    }
}
