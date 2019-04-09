package io.fashionet.core.base.response.exclusion;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomExclusionStrategy implements ExclusionStrategy {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Class<?> clazz;
    private List<String> exclusionFieldNames;

    public CustomExclusionStrategy(Class<?> clazz, String... fieldNames) {
        this.clazz = clazz;
        this.exclusionFieldNames = new ArrayList<>();
        this.exclusionFieldNames.addAll(Arrays.asList(fieldNames));
    }

    public void addExclusionField(String fieldName) {
        this.exclusionFieldNames.add(fieldName);
    }

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if (fieldAttributes.getDeclaringClass() == clazz) {
            for (String fieldName : this.exclusionFieldNames) {
                if (fieldName.equals(fieldAttributes.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
