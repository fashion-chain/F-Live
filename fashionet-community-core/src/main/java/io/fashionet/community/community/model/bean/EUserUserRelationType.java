package io.fashionet.community.community.model.bean;

public enum EUserUserRelationType {
    Follower(1);

    private Integer relType;

    EUserUserRelationType(Integer relType) {
        this.relType = relType;
    }

    public Integer getRelType() {
        return relType;
    }
}
