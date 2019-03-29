package com.example.springstartertester.splider.detailpage;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.AbstractHttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

@Data
@Gecco(matchUrl = "http://tu.duowan.com/gallery/{packageNumber}.html", pipelines = "detailLines" , downloader = "PicDownload")
public class PictureDetail implements HtmlBean {

    @Request
    private AbstractHttpRequest request;

    @HtmlField(cssPath = ".show-img>img")
    private String image;
    @Html
    @HtmlField(cssPath = "html")
    private String html;

    @RequestParameter("packageNumber")
    private String project;//url中的{project}值
    @Ajax(url = "http://tu.duowan.com/index.php?r=show/getByGallery/&gid={packageNumber}")
    private ImageInfo res;
}
