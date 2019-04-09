package io.fashionet.core.base.model.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class TypeAdapterFactoryGenerator {

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> unboxed,
                                                     final Class<TT> boxed,
                                                     final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                return (rawType == unboxed || rawType == boxed) ? (TypeAdapter<T>) typeAdapter : null;
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> boxed,
                                                     final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                return (rawType == boxed) ? (TypeAdapter<T>) typeAdapter : null;
            }
        };
    }
}
