package com.example.springstartertester.splider.mainpage;

import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.spider.JsonBean;
import lombok.Data;

@Data
public class ScrollPage implements JsonBean {
    @JSONPath("$.enabled")
    private Boolean enabled;
    @JSONPath("$.html")
    private String html;

}
