package io.fashionet.core.base.request.argument.flag;

public interface FlagResolver {
    int getPage();

    int getSize();

    long getOffset();

    String next();

    String first();

    String previous();

    String toFlag();
}
