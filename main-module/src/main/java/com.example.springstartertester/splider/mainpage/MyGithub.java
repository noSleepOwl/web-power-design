package com.example.springstartertester.splider.mainpage;

import com.geccocrawler.gecco.annotation.Ajax;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.AbstractHttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

@Data
@Gecco(matchUrl = "http://tu.duowan.com/tag/4953.html", pipelines = "consolePipeline")
public class MyGithub implements HtmlBean {

    private static final long serialVersionUID = -7127412585200687225L;
    @HtmlField(cssPath = ".pic-list")
    private List<Item> items;
    @Request
    private AbstractHttpRequest request;
    /*@Ajax(url = "http://tu.duowan.com/tu?offset=60&order=created&math=0.4602613688985995")
    private ScrollPage page;
   *//* @RequestParameter("user")
    private String user;//url中的{user}值

    @RequestParameter("project")
    private String project;//url中的{project}值

    @Text
    @HtmlField(cssPath = ".repository-meta-content")
    private String title;//抽取页面中的title

    @Text
    @HtmlField(cssPath = ".pagehead-actions li:nth-child(2) .social-count")
    private int star;//抽取页面中的star

    @Text
    @HtmlField(cssPath = ".pagehead-actions li:nth-child(3) .social-count")
    private int fork;//抽取页面中的fork

    @Html
    @HtmlField(cssPath = ".entry-content")
    private String readme;//抽取页面中的readme*/


}