package com.softserve.edu.service.state.verificator;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.edu.entity.Organization;
import com.softserve.edu.repository.OrganizationRepository;


@Service
@Transactional
public class StateVerificatorService {

        @Autowired
        private OrganizationRepository stateVerificatorRepository;

        @Transactional
        public void saveStateVerificator(Organization cstateVerificatorlibrator) {
            stateVerificatorRepository.save(cstateVerificatorlibrator);
        }
 
        @Transactional (readOnly = true)
        public List<Organization> findByDistrict(String district, String type) {
        	  return stateVerificatorRepository.getByTypeAndDistrict(district, type);
        }
        
        @Transactional(readOnly = true)
        public Organization findById(Long id){
        	return stateVerificatorRepository.findOne(id);
        }

}
