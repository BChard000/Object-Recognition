import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Main {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Face faceDetector = new Face("xmlFilePath");
        Mat image = Imgcodecs.imread("imagePath");

        if (image.empty()) {
            System.out.println("Could not load image");
            return;
        }

        Rect[] faces = faceDetector.detectFaces(image);

        for (Rect face : faces) {
            Imgproc.rectangle(image, new Point(face.x, face.y), new Point(face.x + face.width, face.y + face.height),
                    new Scalar(255, 0, 0), 2);

            Imgproc.putText(image, "FACE", new Point(face.x, face.y + face.height + 30),
                    Imgproc.FONT_HERSHEY_SIMPLEX, 0.8, new Scalar(255, 255, 255), 2);
        }

        Imgcodecs.imwrite("resultImagePath", image);

        System.exit(0);
    }
}