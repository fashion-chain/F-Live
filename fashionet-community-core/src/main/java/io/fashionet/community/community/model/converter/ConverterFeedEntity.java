package io.fashionet.community.community.model.converter;

import com.google.gson.reflect.TypeToken;
import io.fashionet.core.base.model.converter.GsonAttributeConverter;
import io.fashionet.community.community.model.bean.FeedEntity;

import java.lang.reflect.Type;
import java.util.HashMap;

public class ConverterFeedEntity extends GsonAttributeConverter<HashMap<String, FeedEntity>> {
    @Override
    public Type getType() {
        return new TypeToken<HashMap<String, FeedEntity>>(){}.getType();
    }
}
