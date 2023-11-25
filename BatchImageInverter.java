import edu.duke.*;
import java.io.*;

/**
 * The BatchImageInverter is a Java application 
 * designed for creating photographic negatives of images in batch. 
 * It processes selected images, inverting their colors, and 
 * saves the altered images with a new filename in a specified directory, preserving the original images.
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
    
    public void selectAndInvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource inverted = invertImage(inImage);
            String fileName = inImage.getFileName();
            String newName = "inverted-" + fileName;
            String directoryPath = "D:\\Study\\Coursera\\Java - Duke University\\Projects\\BatchImageInverter\\images\\";
            String fullPath = directoryPath + newName;
            inverted.setFileName(fullPath);
            inverted.draw();
            inverted.save();
        }
    }
    public static void main(String[] args) {
        BatchImageInverter bii = new BatchImageInverter();
        bii.selectAndInvert();
    }
    
}
