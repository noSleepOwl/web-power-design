package com.example.springstartertester.splider.nextpage;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.AbstractHttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;
import lombok.Data;

//http://tu.duowan.com/tu?offset=120&order=created&math=0.4602613688985995
@Data
@Gecco(matchUrl = "http://tu.duowan.com/tu?offset={offset}&order=created&math={math}", pipelines = "NextPagePipeline")
public class NextPage implements JsonBean {
    @RequestParameter("offset")
    private Integer offset;
    @RequestParameter("math")
    private Double math;
    @Request
    private AbstractHttpRequest request;


    @JSONPath("$.enabled")
    private Boolean enabled;
    @JSONPath("$.html")
    private String html;
}
