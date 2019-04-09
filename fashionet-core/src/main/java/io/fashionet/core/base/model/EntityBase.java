package io.fashionet.core.base.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class EntityBase extends TableBase {

    @Column(columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(columnDefinition = "datetime DEFAULT NULL COMMENT '删除时间'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
