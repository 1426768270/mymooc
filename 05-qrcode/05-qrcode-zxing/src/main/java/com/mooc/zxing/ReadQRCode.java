package com.mooc.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 读取二维码
 * @Author       LQ
 * @CreateDate   2020/7/4 16:49
 * @Version      1.0
 */
public class ReadQRCode {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {

        MultiFormatReader formatReader = new MultiFormatReader();

        // 定义二维码文件路径
        File file = new File("img.png");
        // 读取图片文件识别为一个图片流
        BufferedImage image;
        try {
            image = ImageIO.read(file);

            BinaryBitmap binaryBitmap =
                    new BinaryBitmap(
                            new HybridBinarizer(
                                    new BufferedImageLuminanceSource(image)));
            // 定义二维码的参数
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置字符编码
            // 解析二维码
            Result result = formatReader.decode(binaryBitmap,hints);

            System.out.println("解析结果："+result.toString());
            System.out.println("格式类型："+result.getBarcodeFormat());
            System.out.println("文本内容："+result.getText());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}
