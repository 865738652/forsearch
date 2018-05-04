package com.zt.search.forsearch.processor;

import com.zt.search.forsearch.config.StaticClass;
import com.zt.search.forsearch.domain.BaseDomain;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * <h3></h3>
 *
 * @author zhangtao
 * @since 2018-05-04 下午1:48
 */

public class MyPageProcessor implements PageProcessor {


    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public Site getSite() {
        return this.site;
    }

    @Override
    public void process(Page page) {
        //列表页
        if(page.getUrl().regex(StaticClass.getListUrlRule()).match()){
            //处理文章的链接
            page.addTargetRequests(page.getHtml().xpath(StaticClass.getListTagRule()).links().regex(StaticClass.getArticleUrlRule()).all());
            //处理 页数的链接
            page.addTargetRequests(page.getHtml().links().regex(StaticClass.getListUrlRule()).all());
        } else {
            //文章页
            String title = page.getHtml().xpath(StaticClass.getTitleRule()).toString();
            String content = page.getHtml().xpath(StaticClass.getContentRule()).toString();
            String url = page.getUrl().toString();
            String parentUrl = "应该需要自己实现DownLoader才可以拿到";

            title = StaticClass.delHTMLTag(title);
            content = StaticClass.delHTMLTag(content);

            BaseDomain bd = new BaseDomain(title, content, url, parentUrl);
            page.putField("baseDomain", bd);
        }
    }


}