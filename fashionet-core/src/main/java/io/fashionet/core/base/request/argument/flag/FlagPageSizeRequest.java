package io.fashionet.core.base.request.argument.flag;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

public class FlagPageSizeRequest extends FlagPageable implements Serializable {
    public FlagPageSizeRequest(String flag) {
        super(new FlagPageSizeResolver(flag));
    }

    @Override
    public Sort getSort() {
        return getSortResolver() != null ? getSortResolver().sort() : null;
    }

    @Override
    public Pageable previous() {
        return new FlagPageSizeRequest(getFlagResolver().previous());
    }

    @Override
    public Pageable next() {
        return new FlagPageSizeRequest(getFlagResolver().next());
    }

    @Override
    public Pageable first() {
        return new FlagPageSizeRequest(getFlagResolver().first());
    }
}
