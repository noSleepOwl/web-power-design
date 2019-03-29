package com.example.springstartertester.splider.detailpage;

import com.example.springstartertester.splider.image.ImageControl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.utils.DownloadImage;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@PipelineName("detailLines")
public class DetailPipeline implements Pipeline<PictureDetail> {
    @Override
    public void process(PictureDetail bean) {
        ObjectMapper mapper = new ObjectMapper();

        bean.getRes().getPicInfo().forEach(o -> {
            System.out.println(o.get("source"));
            download("d:/gecco/jd/img", o.get("source").toString(), o.get("add_intro").toString());
        });
    }

    /**
     * 下载图片到指定目录
     *
     * @param parentPath 指定目录
     * @param imgUrl     图片地址
     * @return 下载文件地址
     */
    public String download(String parentPath, String imgUrl, String name) {
        if (Strings.isNullOrEmpty(imgUrl) || Strings.isNullOrEmpty(parentPath)) {
            return null;
        }
        if (imgUrl.length() > 500) {
            return null;
        }
        Closer closer = Closer.create();
        try {
            File imageDir = new File(parentPath);
            if (!imageDir.exists()) {
                imageDir.mkdirs();
            }
            String fileName = StringUtils.substringBefore(imgUrl, "?");
            fileName = StringUtils.substringAfterLast(fileName, "/");
            File imageFile = new File(imageDir, fileName);
            InputStream in = closer.register(new URL(imgUrl).openStream());
            if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                ImageControl.addBorderToImage(in, name, imageFile);
            } else {
                Files.write(ByteStreams.toByteArray(in), imageFile);
            }
            return imageFile.getAbsolutePath();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                closer.close();
            } catch (IOException e) {
                closer = null;
            }
        }
    }
}
