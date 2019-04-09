package io.fashionet.community.community.model.converter;

import com.google.gson.reflect.TypeToken;
import io.fashionet.core.base.model.converter.GsonAttributeConverter;
import io.fashionet.community.community.model.bean.EFeedType;

import java.lang.reflect.Type;

public class ConverterEFeedType extends GsonAttributeConverter<EFeedType> {
    @Override
    public Type getType() {
        return new TypeToken<EFeedType>(){}.getType();
    }
}
