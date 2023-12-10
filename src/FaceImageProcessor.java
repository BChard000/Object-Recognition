import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceImageProcessor {
    private final Mat image;
    private final CascadeClassifier faceCascade;

    public FaceImageProcessor(String imagePath, String xmlFilePath) {
        this.image = Imgcodecs.imread(imagePath);
        if (this.image.empty()) {
            throw new IllegalArgumentException("Image could not be loaded from path: " + imagePath);
        }

        this.faceCascade = new CascadeClassifier(xmlFilePath);
        if (this.faceCascade.empty()) {
            throw new IllegalStateException("Failed to load cascade classifier from: " + xmlFilePath);
        }
    }

    public void processImage() {
        Mat grayImage = new Mat();
        Imgproc.cvtColor(this.image, grayImage, Imgproc.COLOR_BGR2GRAY);

        MatOfRect faceDetections = new MatOfRect();
        this.faceCascade.detectMultiScale(grayImage, faceDetections, 1.3, 5);

        for (Rect face : faceDetections.toArray()) {
            annotateFace(face);
        }

        grayImage.release();
    }

    private void annotateFace(Rect face) {
        Imgproc.rectangle(this.image, new Point(face.x, face.y), new Point(face.x + face.width, face.y + face.height),
                new Scalar(255, 0, 0), 2);
        Imgproc.putText(this.image, "FACE", new Point(face.x, face.y + face.height + 30),
                Imgproc.FONT_HERSHEY_SIMPLEX, 0.8, new Scalar(255, 255, 255), 2);
    }

    public void saveImage(String savePath) {
        Imgcodecs.imwrite(savePath, image);
    }

    public void releaseResources() {
        if (this.image != null) {
            this.image.release();
        }
    }
}