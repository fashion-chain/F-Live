package io.fashionet.core.base.model.converter;

import javax.persistence.AttributeConverter;

public abstract class StringAttributeConverter<T extends StringObjectMapper> implements AttributeConverter<T, String> {
    @Override
    public String convertToDatabaseColumn(T s) {
        return s.toObjString();
    }
}
