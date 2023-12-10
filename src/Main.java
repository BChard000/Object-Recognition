import org.opencv.core.*;

public class Main {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String imagePath = "imagePath";
        String xmlFilePath = "xmlFilePath";
        String outputImagePath = "outputImagePath";

        try {
            FaceImageProcessor processor = new FaceImageProcessor(imagePath, xmlFilePath);
            processor.processImage();
            processor.saveImage(outputImagePath);
            processor.releaseResources();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }
}