package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="`MANUFACTURER`")
public class Manufacturer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "manufacturer_id")
    private Set<Device> devices;
    
//    @OneToMany
//    @JoinColumn(name = "manufacturer_id")
//    private Set<MeasuringEquipment> measuringEquipment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

//	public Set<MeasuringEquipment> getMeasuringEquipment() {
//		return measuringEquipment;
//	}
//
//	public void setMeasuringEquipment(Set<MeasuringEquipment> measuringEquipment) {
//		this.measuringEquipment = measuringEquipment;
//	}
    
    
    
    
}
