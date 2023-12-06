# Overview
This Java application demonstrates basic face detection using the OpenCV library. It includes two primary classes: 'Main' and 'Face'. The 'Main' class serves as the entry point, invoking face detection on a specified image, while the 'Face' class encapsulates the face detection functionality using OpenCV's Haar Cascade classifier.

# Key Components
- 'Face' Class: Manages the loading of the Haar Cascade classifier and performs face detection on images.
- 'Main' Class: Handles image loading, calls the face detection method, and processes the detection results (drawing rectangles and text on detected faces).

# False Positives
The 'detectMultiScale' method's parameters, such as 'scaleFactor' and 'minNeighbors', significantly influence detection accuracy. Improper tuning of these parameters can lead to higher false positives. This Java application demonstrates basic face detection but can generate false positives due to various inherent limitations and environmental factors. Careful adjustment of parameters and conditions can help mitigate these issues, but some level of inaccuracy is expected with Haar Cascade classifiers.
