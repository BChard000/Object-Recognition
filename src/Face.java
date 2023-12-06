import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Face {
    private CascadeClassifier faceCascade;

    public Face(String xmlFilePath) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.faceCascade = new CascadeClassifier(xmlFilePath);
        if (faceCascade.empty()) {
            System.out.println("Failed to load cascade classifier");
        } else {
            System.out.println("Cascade classifier loaded successfully");
        }
    }

    public Rect[] detectFaces(Mat image) {
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        MatOfRect faceDetections = new MatOfRect();
        faceCascade.detectMultiScale(image, faceDetections, 1.3, 5);

        grayImage.release();

        return faceDetections.toArray();
    }
}
