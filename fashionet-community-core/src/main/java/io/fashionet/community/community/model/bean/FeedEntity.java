package io.fashionet.community.community.model.bean;

import java.io.Serializable;
import io.fashionet.core.base.utils.bean.Tuple;

public abstract class FeedEntity implements Serializable {
    private Tuple<Integer, Integer> indices;
}
