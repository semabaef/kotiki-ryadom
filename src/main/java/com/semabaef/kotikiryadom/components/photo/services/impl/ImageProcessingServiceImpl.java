package com.semabaef.kotikiryadom.components.photo.services.impl;

import com.semabaef.kotikiryadom.components.photo.services.ImageProcessingService;
import lombok.RequiredArgsConstructor;
import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageProcessingServiceImpl implements ImageProcessingService {

//    @PostConstruct
//    private void init(){
//        OpenCV.loadShared();
//    }

    @Override
    public boolean detectiveCatInImage(String imageName) {
//        Mat loadedImage = loadImage(imageName);
//        MatOfRect catsDetected = new MatOfRect();
//        CascadeClassifier cascadeClassifier = new CascadeClassifier();
//        int minFaceSize = Math.round(loadedImage.rows() * 0.1f);
//        cascadeClassifier.load("./src/main/resources/haarcascades/haarcascade_frontalcatface.xml");
//        cascadeClassifier.detectMultiScale(loadedImage,
//                catsDetected,
//                1.1,
//                3,
//                Objdetect.CASCADE_SCALE_IMAGE,
//                new Size(minFaceSize, minFaceSize),
//                new Size()
//        );
//        for(Rect cat : catsDetected.toArray()) {
//            Imgproc.rectangle(loadedImage, cat.tl(), cat.br(), new Scalar(0, 0, 255), 3);
//        }
        return false;
    }

//    private Mat loadImage(String imageName) {
//        Imgcodecs imageCodecs = new Imgcodecs();
//        return imageCodecs.imread("где-то там изображение");
//    }
}
