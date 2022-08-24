import report.models.pic.GaoDePic;
import report.utils.GaoDeMapTools;
import report.utils.PicTools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test3 {

    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = testGaoDePic();
        ImageIO.write(bufferedImage,"jpg",new File("D:\\test.jpg"));


    }

    //测试下载和生成地图，从x为26969开始下载20张，y为12397开始下载15张，合并为一个图片
    public static void testGetAndCombineImage() throws IOException {
        GaoDeMapTools.level = 15;
        BufferedImage[][] areaImage = GaoDeMapTools.getAreaImage(26969, 20, 12397, 15);
        BufferedImage bufferedImage = PicTools.combinePicByBufferedImageArray(areaImage, 0, 0);
        ImageIO.write(bufferedImage,"jpg",new File("d:\\123\\64.jpg"));
    }

    //测试根据经纬度获取地图的图片
    public static void getPicByGIS() throws IOException {
        GaoDeMapTools.level = 18;
        double[] p1 = {117.151187,31.738979};
        double[] p2 = {117.166133,31.728773};
        BufferedImage bufferImageByGPS = GaoDeMapTools.getBufferImageByGPS(p1, p2);
        ImageIO.write(bufferImageByGPS,"jpg",new File("D:\\123\\test.jpg"));
    }
    //根据经纬度获取图片中某个像素点
    public static int[] getPix(){
        GaoDeMapTools.level = 18;
        return GaoDeMapTools.getPixByGIS(117.169559, 31.758077);
    }

    //根据经纬度获取一个图片，并且在图片中打点
    public static BufferedImage testGaoDePic() throws IOException {
        GaoDeMapTools.level = 18;
        double[] p1 = {117.151187,31.738979};
        double[] p2 = {117.166133,31.728773};
        GaoDePic gaoDePic = GaoDeMapTools.createGaoDePicByGPS(p1, p2);
        Color[] colors = {Color.pink,Color.orange,Color.CYAN,Color.BLUE,Color.RED};
        String name = "上派中心学校";
        int[] azimuths = {270};
        gaoDePic.drawCell(name,117.161627,31.731693,azimuths);
        return gaoDePic.image;
    }



}
