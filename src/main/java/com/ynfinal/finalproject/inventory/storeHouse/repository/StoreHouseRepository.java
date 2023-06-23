package com.ynfinal.finalproject.inventory.storeHouse.repository;

import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseInsertDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHousefilterDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.StoreHouseListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface StoreHouseRepository extends JpaRepository<StoreHouse, Long> {

    Optional<StoreHouseListResponseDTO> findByStorehouseName(String storehouseName);

//    @Query("SELECT s FROM Storehouse s " +
//            "WHERE (:name IS NULL OR s.storehouseName = :name OR :name = '') " +
//            "AND (:address IS NULL OR s.storehouseAddr = :address OR :address = '') " +
//            "AND (:type IS NULL OR s.storehouseType = :type OR :type = '') " +
//            "AND (:etc IS NULL OR s.storehouseEtc = :etc OR :etc = '')")
//    List<StoreHouse> findFilteredStorehouses(@Param("name") String name, @Param("address") String address, @Param("type") String type, @Param("etc") String etc);
}
