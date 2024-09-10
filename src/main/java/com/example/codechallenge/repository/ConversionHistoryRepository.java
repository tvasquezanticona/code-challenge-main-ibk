package com.example.codechallenge.repository;

import com.example.codechallenge.model.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Integer> {
   // UserResponse getReferenceById(UserRequest userRequest);

    ConversionHistory findByPhone(String phone);
    ConversionHistory findByEmail(String email);



    ConversionHistory findByNroDocumento(String value);
    //UserEntity findByDni(String nroDocumento);
    //UserEntity findByRuc(String nroDocumento);
    //UserEntity findByCarnet(String nroDocumento );
}
