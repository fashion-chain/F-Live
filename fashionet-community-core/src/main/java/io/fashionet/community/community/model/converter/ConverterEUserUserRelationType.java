package io.fashionet.community.community.model.converter;

import com.google.gson.reflect.TypeToken;
import io.fashionet.core.base.model.converter.GsonAttributeConverter;
import io.fashionet.community.community.model.bean.EUserUserRelationType;

import java.lang.reflect.Type;

public class ConverterEUserUserRelationType extends GsonAttributeConverter<EUserUserRelationType> {
    @Override
    public Type getType() {
        return new TypeToken<EUserUserRelationType>(){}.getType();
    }
}
