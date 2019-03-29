package com.example.springstartertester.splider.image;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageControl {
    public static void main(String[] args) {
//        new ImageControl().addBorderToImage("d:/test.png", "");
    }

    public static void addBorderToImage(InputStream input, String info, File outPath) {
        try {
//            File _file = new File(filePath); // 读入文件
            Image src = javax.imageio.ImageIO.read(input); // 构造Image对象
            int width = src.getWidth(null); // 得到源图宽
            int height = src.getHeight(null); // 得到源图长

            int backgroundWidth = width;
            int backgroundHeight = height + 100;

            int msgStart_x = 0;
            int msgStart_y = height + 32;

            Font font = new Font("微软雅黑", Font.PLAIN, 32);

            BufferedImage image = new BufferedImage(backgroundWidth, backgroundHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setBackground(Color.WHITE);
            graphics.clearRect(0, 0, image.getWidth(), image.getHeight());
            // 绘制图
            graphics.drawImage(src, 0, 0, width, height, null);
            // 绘制文字
            graphics.setFont(font);
            graphics.setColor(Color.black);
            graphics.drawString(info, msgStart_x, msgStart_y);
            // 绘制图片边框
            graphics.setColor(Color.GRAY);
            graphics.drawRect(0, 0, width - 1, height - 1);
            graphics.drawRect(1, 1, width - 1, height - 1);
            graphics.drawRect(0, 0, width - 2, height - 2);
            // 文件输出
            FileOutputStream out = new FileOutputStream(outPath); // 输出到文件流
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
