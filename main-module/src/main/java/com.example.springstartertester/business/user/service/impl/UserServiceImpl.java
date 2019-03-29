package com.example.springstartertester.business.user.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@Service
@Log4j2
public class UserServiceImpl {


    public static void main(String[] args) throws Exception {
        List<String> list = loadFile("E:\\my_self_project\\web-power-design\\main-module");

        int fonitSize = 50;
        int height = list.size() * fonitSize;
        int width = list.stream().map(String::length).max(Comparator.comparingInt(self -> self)).orElse(0) * (fonitSize/2);
        createImage(g -> {
            for (int i = 0; i < list.size(); i++) {
                g.drawString(list.get(i), 0, i * fonitSize);

            }
        }, new Font("微软雅黑", Font.PLAIN, fonitSize), new File("d:/a.png"), width, height);

    }


    public static List<String> loadFile(String path) {
        List<String> stringList = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    List<String> strings = new ArrayList<>();
                    try {
                        strings = readFile(file);
                    } catch (MalformedInputException e) {
                        e.printStackTrace();
                    }
                    stringList.addAll(strings);
                    return super.visitFile(file, attrs);
                }


            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringList;
    }

    private static List<String> readFile(Path file) throws IOException {
        log.info(file.toAbsolutePath());
        return Files.readAllLines(file);
    }

    // 根据str,font的样式以及输出文件目录
    public static void createImage(DrawFont drawFont, Font font, File outFile,
                                   Integer width, Integer height) throws Exception {
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);// 先用黑色填充整张图片,也就是背景
        g.setColor(Color.black);// 在换成黑色
        g.setFont(font);// 设置画笔字体

        drawFont.draw(g);
        g.dispose();
        ImageIO.write(image, "png", outFile);// 输出png图片
    }


    interface DrawFont {
        void draw(Graphics graphics);
    }

}
