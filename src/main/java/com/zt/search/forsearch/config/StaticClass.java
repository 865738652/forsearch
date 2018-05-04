/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zt.search.forsearch.config;

import com.zt.search.forsearch.domain.BaseDomain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3>保存着静态变量的类</h3>
 *
 * @author zhangtao
 * @since 2018-05-04 下午2:22
 */
public class StaticClass {

    /**
     * 保存着所有结果
     */
    public static Set<BaseDomain> allResult = Collections.synchronizedSet(new HashSet<>());

    /**
     * 保存着符合结果的有序的Map
     */
    public static Set<BaseDomain> currentResult = Collections.synchronizedSet(new HashSet<>());

    /**
     * 出现了异常的记录
     */
    public static Set<BaseDomain> errorResult = Collections.synchronizedSet(new HashSet<>());



    public static String startUrl;

    public static String listUrlRule;

    public static String listTagRule;

    public static String articleUrlRule;

    public static String titleRule;

    public static String contentRule;

    public static Set<String> keywords;

    public static String getStartUrl() {
        return startUrl;
    }

    public static void setStartUrl(String startUrl) {
        StaticClass.startUrl = startUrl;
    }

    public static String getListUrlRule() {
        return listUrlRule;
    }

    public static void setListUrlRule(String listUrlRule) {
        StaticClass.listUrlRule = listUrlRule;
    }

    public static String getListTagRule() {
        return listTagRule;
    }

    public static void setListTagRule(String listTagRule) {
        StaticClass.listTagRule = listTagRule;
    }

    public static String getArticleUrlRule() {
        return articleUrlRule;
    }

    public static void setArticleUrlRule(String articleUrlRule) {
        StaticClass.articleUrlRule = articleUrlRule;
    }

    public static String getTitleRule() {
        return titleRule;
    }

    public static void setTitleRule(String titleRule) {
        StaticClass.titleRule = titleRule;
    }

    public static String getContentRule() {
        return contentRule;
    }

    public static void setContentRule(String contentRule) {
        StaticClass.contentRule = contentRule;
    }

    public static Set<String> getKeywords() {
        return keywords;
    }

    public static void setKeywords(Set<String> keywords) {
        StaticClass.keywords = keywords;
    }


    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }

}