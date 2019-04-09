package io.fashionet.community.community.model.bean;

public enum EUserPlazaRelationType {
    Subscribe(1),
    Moderator(2);

    private Integer relType;

    EUserPlazaRelationType(Integer relType) {
        this.relType = relType;
    }

    public Integer getRelType() {
        return relType;
    }
}
