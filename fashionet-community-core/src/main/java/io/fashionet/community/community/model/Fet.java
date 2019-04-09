package io.fashionet.community.community.model;

import io.fashionet.core.base.model.EntityBase;
import io.fashionet.community.community.model.bean.EFeedType;
import io.fashionet.community.community.model.bean.FeedEntity;
import io.fashionet.community.community.model.converter.ConverterEFeedType;
import io.fashionet.community.community.model.converter.ConverterFeedEntity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import java.util.HashMap;

@Entity
public class Fet extends EntityBase {

    @Column(columnDefinition = "varchar(160) NOT NULL COMMENT 'Fet文本' ")
    private String text;

    @Column(columnDefinition = "int(2) NOT NULL COMMENT 'Feed类型' ")
    @Convert(converter = ConverterEFeedType.class)
    private EFeedType feedType;

    @Column(columnDefinition = "int(11) NOT NULL COMMENT 'FeedId' ")
    private Long feedId;

    @Column(columnDefinition = "int(11) NOT NULL COMMENT 'PlazaId' ")
    private Long plazaId;

    @Column(columnDefinition = "JSON NOT NULL COMMENT 'Feed Entities' ")
    @Convert(converter = ConverterFeedEntity.class)
    private HashMap<String, FeedEntity> entities;

    @Column(columnDefinition = "varchar(63) NOT NULL COMMENT 'Fet来源' ")
    private String source;

    @Column(columnDefinition = "int(10) NOT NULL COMMENT '评论数' ")
    private Integer commentCount;

    @Column(columnDefinition = "int(10) NOT NULL COMMENT '回复数' ")
    private Integer replyCount;

    @Column(columnDefinition = "int(10) NOT NULL COMMENT '喜欢数' ")
    private Integer favoriteCount;

    @Column(columnDefinition = "int(10) NOT NULL COMMENT '转发数' ")
    private Integer refetCount;

    @Column(columnDefinition = "int(10) NOT NULL COMMENT '引用数' ")
    private Integer quoteCount;

    @Column(columnDefinition = "int(10) NOT NULL COMMENT '点赞数' ")
    private Integer voteUpCount;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public EFeedType getFeedType() {
        return feedType;
    }

    public void setFeedType(EFeedType feedType) {
        this.feedType = feedType;
    }

    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }

    public Long getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(Long plazaId) {
        this.plazaId = plazaId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public HashMap<String, FeedEntity> getEntities() {
        return entities;
    }

    public void setEntities(HashMap<String, FeedEntity> entities) {
        this.entities = entities;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Integer getRefetCount() {
        return refetCount;
    }

    public void setRefetCount(Integer refetCount) {
        this.refetCount = refetCount;
    }

    public Integer getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }

    public Integer getVoteUpCount() {
        return voteUpCount;
    }

    public void setVoteUpCount(Integer voteUpCount) {
        this.voteUpCount = voteUpCount;
    }
}
