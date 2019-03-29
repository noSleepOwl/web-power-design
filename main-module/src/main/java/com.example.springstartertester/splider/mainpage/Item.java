package com.example.springstartertester.splider.mainpage;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

@Data
public class Item implements HtmlBean {
    private static final long serialVersionUID = 3018760488621382659L;
    @Href(click = true)
    @HtmlField(cssPath = "em>a")
    private String href;
    @Text
    @HtmlField(cssPath = "em>a")
    private String name;
    @Html
    private String html;
//    private String href;
//    private String img;
}
