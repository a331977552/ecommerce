package com.food.utils;

import lombok.extern.log4j.Log4j2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
@Log4j2
public class ImgUtil {
    final static String types = Arrays.toString(ImageIO.getReaderFormatNames());

    private static String DEFAULT_PREVFIX = "thumb_";


    /**
     * @param imgFile
     * @param targetW
     * @param targetH
     * @param force
     * @return filename
     */
    public static  String createThumbnail(File imgFile, int targetW, int targetH,boolean force) {
        if(imgFile.exists()){
            try {
                // ImageIO supported types : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String suffix = null;
                // get suffix
                if(imgFile.getName().contains(".")) {
                    suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                }// check
                if(suffix == null || !types.toLowerCase().contains(suffix.toLowerCase())){
                    log.error("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                    return null;
                }
                log.debug("target image's size, width:{}, height:{}.",targetW,targetH);
                Image img = ImageIO.read(imgFile);
                if(!force){
                    // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if((width*1.0)/targetW < (height*1.0)/targetH){
                        if(width > targetW){
                            targetH = Integer.parseInt(new java.text.DecimalFormat("0").format(height * targetW/(width*1.0)));
                            log.debug("change image's height, width:{}, height:{}.",targetW,targetH);
                        }
                    } else {
                        if(height > targetH){
                            targetW = Integer.parseInt(new java.text.DecimalFormat("0").format(width * targetH/(height*1.0)));
                            log.debug("change image's width, width:{}, height:{}.",targetW,targetH);
                        }
                    }
                }
                BufferedImage bi = new BufferedImage(targetW, targetH, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, targetW, targetH, Color.LIGHT_GRAY, null);
                g.dispose();
                String p = imgFile.getPath();
                // 将图片保存在原目录并加上前缀
                String destPath = p.substring(0, p.lastIndexOf(File.separator)) + File.separator + DEFAULT_PREVFIX + imgFile.getName();
                ImageIO.write(bi, suffix, new File(destPath));
                return  DEFAULT_PREVFIX + imgFile.getName();
            } catch (IOException e) {
                throw new RuntimeException("generate thumbnail image failed.",e);
            }
        }else{
            throw new IllegalArgumentException(" img file doesn't exist");
        }

    }

}
