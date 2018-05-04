package com.zt.search.forsearch.pipeline;
import com.zt.search.forsearch.config.StaticClass;
import com.zt.search.forsearch.domain.BaseDomain;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Set;

/**
 * <h3>将结果保存到Map中</h3>
 *
 * @author zhangtao
 * @since 2018-05-04 下午2:12
 */
@Component
public class SavePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        BaseDomain baseDomain = resultItems.get("baseDomain");
        try {

            StaticClass.allResult.add(baseDomain);
            //筛选
            String str = baseDomain.getTitle()+"  "+baseDomain.getContent();
            Set<String> keywords = StaticClass.getKeywords();
            keywords.forEach(item->{
                if(str.contains(item)) {
                    StaticClass.currentResult.add(baseDomain);
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
            StaticClass.errorResult.add(baseDomain);
        }



    }
}