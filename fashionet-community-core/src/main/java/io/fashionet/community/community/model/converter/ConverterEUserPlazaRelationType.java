package io.fashionet.community.community.model.converter;

import com.google.gson.reflect.TypeToken;
import io.fashionet.core.base.model.converter.GsonAttributeConverter;
import io.fashionet.community.community.model.bean.EUserPlazaRelationType;

import java.lang.reflect.Type;

public class ConverterEUserPlazaRelationType extends GsonAttributeConverter<EUserPlazaRelationType> {
    @Override
    public Type getType() {
        return new TypeToken<EUserPlazaRelationType>(){}.getType();
    }
}
