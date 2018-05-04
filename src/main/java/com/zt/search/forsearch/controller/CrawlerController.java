/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zt.search.forsearch.controller;

import com.zt.search.forsearch.config.RuleProperties;
import com.zt.search.forsearch.config.StaticClass;
import com.zt.search.forsearch.domain.BaseDomain;
import com.zt.search.forsearch.pipeline.SavePipeline;
import com.zt.search.forsearch.processor.MyPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <h3>前端控制器</h3>
 *
 * @author zhangtao
 * @since 2018-05-04 下午12:00
 */
@RestController
public class CrawlerController {

    @Autowired
    private RuleProperties ruleProperties;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() {

        System.out.println("入口url地址:"+ruleProperties.getStartUrl());
        System.out.println("列表页链接的匹配规则:"+ruleProperties.getListUrlRule());
        System.out.println("文章页链接的匹配规则:"+ruleProperties.getArticleUrlRule());
        System.out.println("列表页文章链接的范围:"+ruleProperties.getListTagRule());
        System.out.println("标题的匹配规则:"+ruleProperties.getTitleRule());
        System.out.println("内容的匹配规则:"+ruleProperties.getContentRule());
        Set<String> keywords = ruleProperties.getKeywords();
        keywords.forEach(item->{
            System.out.println("关键词:"+item);
        });

        StaticClass.startUrl = ruleProperties.getStartUrl();
        StaticClass.listUrlRule = ruleProperties.getListUrlRule();
        StaticClass.articleUrlRule = ruleProperties.getArticleUrlRule();
        StaticClass.listTagRule = ruleProperties.getListTagRule();
        StaticClass.titleRule = ruleProperties.getTitleRule();
        StaticClass.contentRule = ruleProperties.getContentRule();
        StaticClass.keywords = ruleProperties.getKeywords();


        Spider.create(new MyPageProcessor()).addUrl(ruleProperties.getStartUrl())
                .addPipeline(new SavePipeline())
                .run();
        return "开始";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<BaseDomain> all() {
        return StaticClass.allResult;
    }

    @RequestMapping(value = "current", method = RequestMethod.GET)
    public Set<BaseDomain> current() {
        return StaticClass.currentResult;
    }

    @RequestMapping(value = "currentR", method = RequestMethod.GET)
    public Set<R> currentR() {

        Set<R> result = new HashSet<>();
        StaticClass.currentResult.forEach(item->{
            R r = new R();
            r.name = item.getTitle();
            r.url = item.getUrl();
            result.add(r);
        });
        return result;
    }


    @RequestMapping(value = "exception", method = RequestMethod.GET)
    public Set<BaseDomain> error() {
        return StaticClass.errorResult;
    }

}


class R implements Serializable {
    private static final long serialVersionUID = -3042686055658047285L;
    String name;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}