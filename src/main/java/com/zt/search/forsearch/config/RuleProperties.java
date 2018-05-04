package com.zt.search.forsearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <h3>抓取规则的配置类</h3>
 *
 * @author zhangtao
 * @since 2018-05-04 下午1:37
 */
@Component
public class RuleProperties {

    /**
     * 入口地址
     */
    @Value("${startUrl}")
    private String startUrl;

    /**
     * 列表页的抓取规则
     */
    @Value("${rule.list}")
    private String listUrlRule;
    /**
     * 列表页文章url的范围
     */
    @Value("${rule.list.tag}")
    private String listTagRule;

    /**
     * 文章页的抓取规则
     */
    @Value("${rule.article}")
    private String articleUrlRule;

    /**
     * 文章页标题的抓取规则
     */
    @Value("${rule.article.title}")
    private String titleRule;
    /**
     * 文章页文章内容的抓取规则
     */
    @Value("${rule.article.content}")
    private String contentRule;

    /**
     * 搜索匹配的关键词
     */
    @Value("#{'${kewords}'.split(',')}")
    private Set<String> keywords;


    public String getListUrlRule() {
        return listUrlRule;
    }

    public void setListUrlRule(String listUrlRule) {
        this.listUrlRule = listUrlRule;
    }

    public String getListTagRule() {
        return listTagRule;
    }

    public void setListTagRule(String listTagRule) {
        this.listTagRule = listTagRule;
    }

    public String getArticleUrlRule() {
        return articleUrlRule;
    }

    public void setArticleUrlRule(String articleUrlRule) {
        this.articleUrlRule = articleUrlRule;
    }

    public String getTitleRule() {
        return titleRule;
    }

    public void setTitleRule(String titleRule) {
        this.titleRule = titleRule;
    }

    public String getContentRule() {
        return contentRule;
    }

    public void setContentRule(String contentRule) {
        this.contentRule = contentRule;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }
}