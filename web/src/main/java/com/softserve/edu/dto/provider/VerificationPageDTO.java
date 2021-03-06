package com.softserve.edu.dto.provider;


import java.util.Date;

import com.softserve.edu.entity.user.User;
import com.softserve.edu.entity.util.ReadStatus;
import com.softserve.edu.entity.util.Status;

public class VerificationPageDTO {
    private String id;
    private Date initialDate;
    private String surname;
    private String name;
    private String district;
    private String locality;
    private String phone;
    private String street;
    private Status status;
    private String providerEmployee;
    private String calibratorEmployee;
    private String stateVerificatorEmployee;
    private Long countOfWork;
    private ReadStatus readStatus;
    private boolean isUpload;

    public VerificationPageDTO() {
    }

    public VerificationPageDTO(String id, Date initialDate, String surname, String street,
                               Status status, ReadStatus readStatus, User providerEmployee, User calibratorEmployee, User stateVerificatorEmployee, 
                               String name, String district, String locality, String phone,boolean isUpload) {

        this.id = id;
        this.initialDate = initialDate;
        this.surname = surname;
        this.street = street;
        this.status = status;
        this.readStatus = readStatus;
        if (providerEmployee != null) {
            if (providerEmployee.getMiddleName() != null) {
                this.providerEmployee = providerEmployee.getLastName() + " " + providerEmployee.getFirstName() + " " + providerEmployee.getMiddleName();
            } else {
                this.providerEmployee = providerEmployee.getLastName() + " " + providerEmployee.getFirstName();
            }
        };
        if (calibratorEmployee != null) {
            if (calibratorEmployee.getMiddleName() != null) {
                this.calibratorEmployee = calibratorEmployee.getLastName() + " " + calibratorEmployee.getFirstName() + " " + calibratorEmployee.getMiddleName();
            } else {
                this.calibratorEmployee = calibratorEmployee.getLastName() + " " + calibratorEmployee.getFirstName();
            }
        };
        if (stateVerificatorEmployee != null) {
            if (stateVerificatorEmployee.getMiddleName() != null) {
                this.stateVerificatorEmployee = stateVerificatorEmployee.getLastName() + " " + stateVerificatorEmployee.getFirstName() + " " + stateVerificatorEmployee.getMiddleName();
            } else {
                this.stateVerificatorEmployee = stateVerificatorEmployee.getLastName() + " " + stateVerificatorEmployee.getFirstName();
            }
        };
        this.name=name;
        this.district=district;
        this.locality=locality;
        this.phone=phone;
        this.isUpload=isUpload;
    }
    public VerificationPageDTO(Long count) {
        this.countOfWork = count;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String getProviderEmployee() {
        return providerEmployee;
    }

    public void setProviderEmployee(String providerEmployee) {
        this.providerEmployee = providerEmployee;
    }

    public Long getCountOfWork() {
        return countOfWork;
    }

    public void setCountOfWork(Long countOfWork) {
        this.countOfWork = countOfWork;
    }

    public ReadStatus getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(ReadStatus readStatus) {
        this.readStatus = readStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCalibratorEmployee() {
		return calibratorEmployee;
	}

	public void setCalibratorEmployee(String calibratorEmployee) {
		this.calibratorEmployee = calibratorEmployee;
	}

	public String getStateVerificatorEmployee() {
		return stateVerificatorEmployee;
	}

	public void setStateVerificatorEmployee(String stateVerificatorEmployee) {
		this.stateVerificatorEmployee = stateVerificatorEmployee;
	}

    public boolean isUpload() {
        return isUpload;
    }

    public void setIsUpload(boolean isUpload) {
        this.isUpload = isUpload;
    }

    @Override
    public String toString() {
        return "VerificationPageDTO{" +
                "id='" + id + '\'' +
                ", initialDate=" + initialDate +
                ", surname='" + surname + '\'' +
                ", street='" + street + '\'' +
                ", status=" + status +
                '}';
    }
}


