package com.ynfinal.finalproject.inventory.storeHouse.service;

import com.ynfinal.finalproject.inventory.storeHouse.dto.request.ItemOrderInputRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.ItemOrderListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.inventory.storeHouse.repository.ItemOrderRepository;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.company.repository.TradeCompanyRepository;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemOrderService {

    private final ItemOrderRepository itemOrderRepository;
    private final TradeCompanyRepository tradeCompanyRepository;
    private final EmployeesRepository employeesRepository;

    // 전체 발주서 리스트 조회하기
    public List<ItemOrderListResponseDTO> itemOrderList() {

        return itemOrderRepository.findAll().stream()
                .map(ItemOrderListResponseDTO::new)
                .collect(Collectors.toList());


    }


    // 발주 등록하기
    public ItemOrder addItemOrder(ItemOrderInputRequestDTO requestDTO) {

        // ItemOrder 엔티티 생성
        ItemOrder itemOrder = ItemOrder.builder()
                .itemOrderCheck(requestDTO.getItemOrderCheck())
                .itemOrderStart(requestDTO.getItemOrderStart())
                .itemOrderReg(requestDTO.getItemOrderReg())
                .itemOrderUpdate(requestDTO.getItemOrderUpdate())
                .build();

        // TradeCompany 조회 및 연결
        TradeCompany tradeCompany = tradeCompanyRepository.findById(requestDTO.getTrCompCode())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Trade Company Code"));
        itemOrder.setTradeCompany(tradeCompany);

        // Employees 조회 및 연결
        Employees employees = employeesRepository.findById(requestDTO.getEmpNo())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee Number"));
        itemOrder.setEmployees(employees);

        // ItemOrder 저장
        return itemOrderRepository.save(itemOrder);


    }

    public void deleteItemOrder(Long itemOrderCode) {

        log.info("발주서 삭제하기");
        itemOrderRepository.deleteById(itemOrderCode);

    }
}
