package io.fashionet.community.community.model;

import io.fashionet.core.base.model.RelationBase;
import io.fashionet.community.community.model.bean.EUserPlazaRelationType;
import io.fashionet.community.community.model.converter.ConverterEUserPlazaRelationType;

import javax.persistence.*;


@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"userId", "plazaId", "relType"})
})
public class RelationUserPlaza extends RelationBase {
    @Column(columnDefinition = "int(11) NOT NULL COMMENT 'userId' ")
    private Long userId;

    @Column(columnDefinition = "int(11) NOT NULL COMMENT 'PlazaId' ")
    private Long plazaId;

    @Column(columnDefinition = "int(2) NOT NULL COMMENT '关系类型' ")
    @Convert(converter = ConverterEUserPlazaRelationType.class)
    private EUserPlazaRelationType relType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(Long plazaId) {
        this.plazaId = plazaId;
    }

    public EUserPlazaRelationType getRelType() {
        return relType;
    }

    public void setRelType(EUserPlazaRelationType relType) {
        this.relType = relType;
    }
}
