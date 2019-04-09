package io.fashionet.community.community.model;

import io.fashionet.core.base.model.RelationBase;
import io.fashionet.community.community.model.bean.EUserUserRelationType;
import io.fashionet.community.community.model.converter.ConverterEUserUserRelationType;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"fromUserId", "toUserId", "relType"})
})
public class RelationUserUser extends RelationBase {

    @Column(columnDefinition = "int(11) NOT NULL COMMENT '操作用户Id' ")
    private Long fromUserId;

    @Column(columnDefinition = "int(11) NOT NULL COMMENT '目标用户Id' ")
    private Long toUserId;

    @Column(columnDefinition = "int(2) NOT NULL COMMENT '关系类型' ")
    @Convert(converter = ConverterEUserUserRelationType.class)
    private EUserUserRelationType relType;

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public EUserUserRelationType getRelType() {
        return relType;
    }

    public void setRelType(EUserUserRelationType relType) {
        this.relType = relType;
    }
}
