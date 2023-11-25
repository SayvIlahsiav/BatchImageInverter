import edu.duke.*;
/**
 * Write a description of BatchImageInverter here.
 * 
 * @author Vaishali Vyas
 * @version 2023, November 25th
 */
public class BatchImageInverter {
    
    public ImageResource invertImage(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255 - inPixel.getRed());
            pixel.setGreen(255 - inPixel.getGreen());
            pixel.setBlue(255 - inPixel.getBlue());
        }
        return outImage;
    }
    
    public void testInvertImage() {
        ImageResource ir = new ImageResource();
        ImageResource inverted = invertImage(ir);
        inverted.draw();
    }
    
    public static void main(String[] args) {
        BatchImageInverter bii = new BatchImageInverter();
        bii.testInvertImage();
    }
    
}
