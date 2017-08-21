/*
*          ┌─┐       ┌─┐
*       ┌──┘ ┴───────┘ ┴──┐
*       │                 │
*       │       ───       │
*       │  ─┬┘       └┬─  │
*       │                 │
*       │       ─┴─       │
*       │                 │
*       └───┐         ┌───┘
*           │         │
*           │         │
*           │         │
*           │         └──────────────┐
*           │                        │
*           │                        ├─┐
*           │                        ┌─┘    
*           │                        │
*           └─┐  ┐  ┌───────┬──┐  ┌──┘         
*             │ ─┤ ─┤       │ ─┤ ─┤         
*             └──┴──┘       └──┴──┘ 
*                 神兽保佑 
*                 代码无BUG! 
*/

package com.sunday.learn.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.http.entity.ContentType;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author : Sunday
 * @Description : 裁剪、缩放图片工具类
 * @Date : 14:08 2017/8/21
 * @Modified By :
 */
public class ImgUtils {

    /**
     * 缩放图片方法
     *
     * @param srcImageFile 要缩放的图片路径
     * @param result 缩放后的图片路径
     * @param height 目标高度像素
     * @param width  目标宽度像素
     * @param bb     是否补白
     */
    public final static void scale(String srcImageFile, String result, int height, int width, boolean bb) {
        try {
            double ratio = 0.0; // 缩放比例
            File f = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(f);
            Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);//bi.SCALE_SMOOTH  选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
            // 计算比例
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                double   ratioHeight = (new Integer(height)).doubleValue()/ bi.getHeight();
                double   ratioWhidth = (new Integer(width)).doubleValue()/ bi.getWidth();
                if(ratioHeight>ratioWhidth){
                    ratio= ratioHeight;
                }else{
                    ratio= ratioWhidth;
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform//仿射转换
                        .getScaleInstance(ratio, ratio), null);//返回表示剪切变换的变换
                itemp = op.filter(bi, null);//转换源 BufferedImage 并将结果存储在目标 BufferedImage 中。
            }
            if (bb) {//补白
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);//构造一个类型为预定义图像类型之一的 BufferedImage。
                Graphics2D g = image.createGraphics();//创建一个 Graphics2D，可以将它绘制到此 BufferedImage 中。
                g.setColor(Color.white);//控制颜色
                g.fillRect(0, 0, width, height);// 使用 Graphics2D 上下文的设置，填充 Shape 的内部区域。
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                g.dispose();
                itemp = image;
            }
            ImageIO.write((BufferedImage) itemp, "JPEG", new File(result));      //输出压缩图片
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 裁剪图片方法
     *
     * @param bufferedImage 图像源
     * @param startX 裁剪开始x坐标
     * @param startY 裁剪开始y坐标
     * @param endX 裁剪结束x坐标
     * @param endY 裁剪结束y坐标
     * @return
     */
    public static BufferedImage cropImage(BufferedImage bufferedImage, int startX, int startY, int endX, int endY) {
        int width  = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        if (startX == -1) {
            startX = 0;
        }
        if (startY == -1) {
            startY = 0;
        }
        if (endX == -1) {
            endX = width - 1;
        }
        if (endY == -1) {
            endY = height - 1;
        }
        BufferedImage result = new BufferedImage(endX - startX, endY - startY, 4);
        for (int x = startX; x < endX; ++x) {
            for (int y = startY; y < endY; ++y) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(x - startX, y - startY, rgb);
            }
        }
        return result;
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    public static String suffixFile(String fileName) {
        String suffix = null;
        if (fileName == null || fileName.length() < 0 || fileName.indexOf('.') <= 0) {
            return suffix;
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()).toLowerCase();
    }

    /**
     * 获得指定文件的byte数组
     *
     * @param filePath
     * @return
     */
    public static byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 根据byte数组，生成文件
     *
     * @param bfile
     * @param filePath
     * @param fileName
     */
    public static void setFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 对上传的图片进行裁切
     *
     * @param fileOri
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public static MultipartFile corpPic(MultipartFile fileOri, Integer x, Integer y, Integer width, Integer height) throws Exception{
        // 获得文件名：
        String fileName = fileOri.getOriginalFilename();
        String prifix = DateUtils.getCurrentDate() + "_" + UUIDUtils.generateUUID();
        // 生成最终和临时文件名
        String fileTmp   = prifix + "_tmp_" + fileName;
        String fileFinal = prifix + "_final_" + fileName;
        // 最终MultipartFile类型文件
        String fileMulti = prifix + "_multi_" + fileName;
        // MultipartFile转存为File
        File newFile  = ImgUtils.multi2File(fileOri, fileTmp);
        // 获取转存后的newFile
        BufferedImage bufferedImage = ImageIO.read(newFile);
        // 裁切
        bufferedImage = ImgUtils.cropImage(bufferedImage, x, y, x + width, y + height);
        // 输出裁切图片
        File fileFinalData = new File(fileFinal);
        fileFinalData.createNewFile();
        BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newBufferedImage.createGraphics();
        try {
            g.drawImage(bufferedImage, 0, 0, null);
            if (!ImageIO.write(newBufferedImage, ImgUtils.suffixFile(fileName), fileFinalData)) {
                throw new IllegalArgumentException(String.format("not found writer for '%s'",ImgUtils.suffixFile(fileName)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            g.dispose();
        }
        // File to MultipartFile
        MultipartFile multipartFile = ImgUtils.file2Multi(fileFinalData, fileMulti);
        //MultipartFile file = new MockMultipartFile("image", fileMulti, "image/" + ImgUtils.suffixFile(fileName), ImgUtils.getBytes(fileFinal));
        // 删除本地临时文件
        newFile.delete();
        fileFinalData.delete();
        return multipartFile;
    }

    /**
     * MultipartFile to File
     *
     * @param file
     * @param fileName
     * @return
     * @throws Exception
     */
    public static File multi2File(MultipartFile file, String fileName) throws Exception{
        File convFile = new File(fileName);
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    /**
     * File to MultipartFile
     *
     * @param file
     * @param fileName
     * @return
     */
    public static MultipartFile file2Multi(File file, String fileName) throws Exception{
        if (!file.exists()) {
            file.createNewFile();
        }
        // 小于5M文件都在内存中,否则存入硬盘
        final int tmpFileSize = 5242880;
        // 设置临时文件大小以及临时文件存储路径
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory(tmpFileSize, new File(fileName));
        // 创建fileItem
        FileItem fileItem = fileItemFactory.createItem(
                "file",                                 // 表单参数名
                ContentType.APPLICATION_OCTET_STREAM.toString(),    // 文件类型
                false,                                  // 是否为表单格式
                fileName                                // 文件名
        );
        // 将File内容写入fileItem,使用org.apache.commons.io.IOUtils
        IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
        // 创建multipartfile
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        return multipartFile;
    }

}
