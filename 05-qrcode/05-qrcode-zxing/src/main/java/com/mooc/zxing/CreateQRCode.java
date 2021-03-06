package com.mooc.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * https://segmentfault.com/a/1190000009909177
 * 生成二维码
 * @Author       LQ
 * @CreateDate   2020/7/4 16:46
 * @Version      1.0
 */
public class CreateQRCode {

    public static void main(String[] args) {
        // 定义图片的宽度和高度
        int width = 300;
        int height = 300;
        // 定义图片的格式
        String format = "png";
        // 定义二维码的内容
        String contents = "www.imooc.com";

        Path file = new File("img.png").toPath();
        // 定义二维码的参数
        HashMap<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置字符编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 设置容错等级
        hints.put(EncodeHintType.MARGIN, 2);// 设置边距（默认值5）

        // 生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height,hints);
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
