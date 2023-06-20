package com.ynfinal.finalproject.inventory.storeHouse.repository;

import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseInsertDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.StoreHouseListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface StoreHouseRepository extends JpaRepository<StoreHouse, Long> {

    Optional<StoreHouseListResponseDTO> findByStorehouseName(String storehouseName);


}
