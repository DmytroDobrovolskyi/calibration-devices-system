package com.softserve.edu.entity.catalogue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.softserve.edu.entity.catalogue.util.Checker.checkForEmptyText;

@Entity
public class Region extends AbstractCatalogue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String designation;

    protected Region() {}

    public Region(String name) {
        this.designation = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    private void setDesignation(String designation) {
        checkForEmptyText(designation);
        this.designation = designation;
    }

    @Override
    public String toString() {
        return designation;
    }
}
