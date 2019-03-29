package com.example.springstartertester.splider.nextpage;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@PipelineName("NextPagePipeline")
public class NextPagePipeline implements Pipeline<NextPage> {
    @Override
    public void process(NextPage bean) {
        System.out.println(bean);
        Document doc = Jsoup.parse(bean.getHtml());
        Elements elements = doc.select("li em a");
        for (Element element : elements) {
            String href = element.attr("href");
            DeriveSchedulerContext.into(bean.getRequest().subRequest(href));
        }
        next(bean);
    }

    private void next(NextPage bean) {
        String url = String.format("http://tu.duowan.com/tu?offset=%d&order=created&math=%f", bean.getOffset() + 30, Math.random());
        DeriveSchedulerContext.into(bean.getRequest().subRequest(url));
    }
}
