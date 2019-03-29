package com.example.springstartertester.splider.mainpage;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

@PipelineName("consolePipeline")
public class ConsolePipeline implements Pipeline<MyGithub> {
    @Override
    public void process(MyGithub bean) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(bean));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        next(bean);

    }

    private void next(MyGithub bean) {
        String url = String.format("http://tu.duowan.com/tu?offset=%d&order=created&math=%f", 60, Math.random());
        DeriveSchedulerContext.into(bean.getRequest().subRequest(url));
    }
}
