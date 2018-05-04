/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zt.search.forsearch.domain;

/**
 * <h3>领域模型：csdn的文章类</h3>
 *
 * @author zhangtao
 * @since 2018-05-04 上午11:28
 */
public class CsdnDomain extends BaseDomain {
    public CsdnDomain(String title, String content, String url, String parentUrl) {
        super(title, content, url, parentUrl);
    }
}