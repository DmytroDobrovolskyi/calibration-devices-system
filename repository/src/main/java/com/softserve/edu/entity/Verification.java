package com.softserve.edu.entity;

import com.softserve.edu.entity.user.Employee;
import com.softserve.edu.entity.util.ReadStatus;
import com.softserve.edu.entity.util.Status;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * Verification entity.
 * Contains data about whole business process of verification.
 */
@Entity
@Table(name = "`VERIFICATION`")
public class Verification {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private Status status;
    
    // my changes
    @Enumerated(EnumType.STRING)
    private ReadStatus readStatus;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @OneToMany
    @JoinColumn(name = "verification_id")
    private Set<CalibrationTest> calibrationTests;

    @ManyToOne
    private Organization provider;

    @ManyToOne
    private Employee providerEmployee;

    @ManyToOne
    private Organization calibrator;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee calibratorEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization stateVerificator;
    @ManyToOne
    private Employee stateVerificatorEmployee;

    @Embedded
    private ClientData clientData;

    @Temporal(TemporalType.DATE)
    private Date initialDate;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public Verification() {}

    public Verification(Date initialDate, ClientData clientData, Organization provider, 
    		Status status, ReadStatus readStatus) {
        this(initialDate, clientData, provider, status, readStatus, null);
    }

    public Verification(Date initialDate, ClientData clientData, Organization provider, Status
            status, ReadStatus readStatus, Organization calibrator) {
        this.id = UUID.randomUUID().toString();
        this.initialDate = initialDate;
        this.clientData = clientData;
        this.provider = provider;
        this.status = status;
        this.readStatus = readStatus;
        this.calibrator = calibrator;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ReadStatus getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(ReadStatus readStatus) {
		this.readStatus = readStatus;
	}
    
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Set<CalibrationTest> getCalibrationTests() {
        return calibrationTests;
    }

    public void setCalibrationTests(Set<CalibrationTest> calibrationTests) {
        this.calibrationTests = calibrationTests;
    }

    public Organization getProvider() {
        return provider;
    }

    public void setProvider(Organization provider) {
        this.provider = provider;
    }

    public Employee getProviderEmployee() {
        return providerEmployee;
    }

    public void setProviderEmployee(Employee providerEmployee) {
        this.providerEmployee = providerEmployee;
    }

    public Organization getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Organization calibrator) {
        this.calibrator = calibrator;
    }

    public Employee getCalibratorEmployee() {
        return calibratorEmployee;
    }

    public void setCalibratorEmployee(Employee calibratorEmployee) {
        this.calibratorEmployee = calibratorEmployee;
    }

    public Organization getStateVerificator() {
        return stateVerificator;
    }

    public void setStateVerificator(Organization stateVerificator) {
        this.stateVerificator = stateVerificator;
    }

    public Employee getStateVerificatorEmployee() {
        return stateVerificatorEmployee;
    }

    public void setStateVerificatorEmployee(Employee stateVerificatorEmployee) {
        this.stateVerificatorEmployee = stateVerificatorEmployee;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
