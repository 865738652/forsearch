/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zt.search.forsearch.domain;

import com.zt.search.forsearch.config.StaticClass;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * <h3>领域模型：文章基类</h3>
 *
 * @author zhangtao
 * @since 2018-05-04 上午11:21
 */
public class BaseDomain implements Serializable{

    private static final long serialVersionUID = -3042686055658047285L;

    private String id;
    /**
     * 文章的标题
     */
    private String title;
    /**
     * 文章的正文
     */
    private String content;
    /**
     * 当前页面的url
     */
    private String url;
    /**
     * 父页面的url，列表页的url
     */
    private String parentUrl;

    public BaseDomain(String title, String content, String url, String parentUrl) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.url = url;
        this.parentUrl = parentUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomain that = (BaseDomain) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(url, that.url) &&
                Objects.equals(parentUrl, that.parentUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, content, url, parentUrl);
    }
}