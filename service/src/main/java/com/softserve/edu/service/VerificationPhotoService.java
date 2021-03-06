package com.softserve.edu.service;

import java.io.InputStream;
import java.nio.file.FileSystems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.service.storage.impl.FileOperationImpl;

@Service
public class VerificationPhotoService {

    @Autowired
    private CalibrationTestService calibrationTestService;

    @Autowired
    private FileOperationImpl fileOperationImpl;

    private String sep = FileSystems.getDefault().getSeparator();

    public boolean putResourse(long testId, InputStream stream, String fileType) {
        CalibrationTest test = calibrationTestService.findTestById(testId);
        String verId = test.getVerification().getId();
        String relFolder = verId + sep + testId + sep;
        test.setPhotoPath(fileOperationImpl.putResourse(stream, relFolder, fileType));
        return true;
    }
}