package com.softserve.edu.repository.catalogue;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softserve.edu.entity.catalogue.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {
    Region findByDesignation(String designation);
}
