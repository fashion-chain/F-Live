package io.fashionet.community.community.model.bean;

public enum EFeedType {
    Fet(0),
    Article(1);

    private Integer feedType;

    EFeedType(Integer feedType) {
        this.feedType = feedType;
    }

    public Integer getFeedType() {
        return feedType;
    }
}
