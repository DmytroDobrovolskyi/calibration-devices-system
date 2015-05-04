package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
public class CalibrationTestData {
    @Id
    @GeneratedValue
    private Long id;
    private Double givenConsumption;
    private Integer acceptableError;
    private Integer volumeOfStdart;
    private Double initialValue;
    private Double endValue;
    private Double volumInDevice;
    private Double testTime;
    private Double actualConsumption;
    private Double consumptionStatus;

    @ManyToOne
    @JoinColumn(name = "calibrationTest_id")
    private CalibrationTest calibrationTest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGivenConsumption() {
        return givenConsumption;
    }

    public void setGivenConsumption(Double givenConsumption) {
        this.givenConsumption = givenConsumption;
    }

    public Integer getAcceptableError() {
        return acceptableError;
    }

    public void setAcceptableError(Integer acceptableError) {
        this.acceptableError = acceptableError;
    }

    public Integer getVolumeOfStdart() {
        return volumeOfStdart;
    }

    public void setVolumeOfStdart(Integer volumeOfStdart) {
        this.volumeOfStdart = volumeOfStdart;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Double getEndValue() {
        return endValue;
    }

    public void setEndValue(Double endValue) {
        this.endValue = endValue;
    }

    public Double getVolumInDevice() {
        return volumInDevice;
    }

    public void setVolumInDevice(Double volumInDevice) {
        this.volumInDevice = volumInDevice;
    }

    public Double getTestTime() {
        return testTime;
    }

    public void setTestTime(Double testTime) {
        this.testTime = testTime;
    }

    public Double getActualConsumption() {
        return actualConsumption;
    }

    public void setActualConsumption(Double actualConsumption) {
        this.actualConsumption = actualConsumption;
    }

    public Double getConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(Double consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
    }

    public CalibrationTest getCalibrationTest() {
        return calibrationTest;
    }

    public void setCalibrationTest(CalibrationTest calibrationTest) {
        this.calibrationTest = calibrationTest;
    }
}
