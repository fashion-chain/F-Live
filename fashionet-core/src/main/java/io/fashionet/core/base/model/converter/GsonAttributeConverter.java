package io.fashionet.core.base.model.converter;

import io.fashionet.core.base.configuration.BaseConfiguration;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Type;

public abstract class GsonAttributeConverter<T> implements AttributeConverter<T, String> {
    @Override
    public String convertToDatabaseColumn(T t) {
        return BaseConfiguration.generalGson().toJson(t);
    }

    @Override
    public T convertToEntityAttribute(String s) {
        return BaseConfiguration.generalGson().fromJson(s, getType());
    }

    public abstract Type getType();
}
