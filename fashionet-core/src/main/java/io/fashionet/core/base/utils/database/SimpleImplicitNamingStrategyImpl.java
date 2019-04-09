package io.fashionet.core.base.utils.database;

public class SimpleImplicitNamingStrategyImpl extends ImplicitNamingStrategyImpl {
    @Override
    public String getPrefix() {
        return "fs_";
    }

    @Override
    public String customize(String defaultTableEntityName) {
        return defaultTableEntityName;
    }
}
