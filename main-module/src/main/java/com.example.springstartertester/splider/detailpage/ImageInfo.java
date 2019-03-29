package com.example.springstartertester.splider.detailpage;

import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.spider.JsonBean;
import lombok.Data;

import java.util.List;

@Data
public class ImageInfo implements JsonBean {
    private static final long serialVersionUID = 2250225801616402995L;
    @JSONPath("$.gallery_title")
    private String gallery_title;
    @JSONPath("$.picInfo")
    private List<JSONObject> picInfo;


}
