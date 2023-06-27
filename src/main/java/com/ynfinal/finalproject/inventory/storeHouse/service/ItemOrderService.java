package com.ynfinal.finalproject.inventory.storeHouse.service;

import com.ynfinal.finalproject.inventory.storeHouse.dto.request.ItemOrderInputRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.ItemOrderListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrderDetail;
import com.ynfinal.finalproject.inventory.storeHouse.repository.ItemOrderDetailRepository;
import com.ynfinal.finalproject.inventory.storeHouse.repository.ItemOrderRepository;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.company.repository.TradeCompanyRepository;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ItemOrderService {

    private final ItemOrderRepository itemOrderRepository;
    private final ItemOrderDetailRepository detailRepository;
    private final TradeCompanyRepository tradeCompanyRepository;
    private final EmployeesRepository employeesRepository;

    // 전체 발주서 리스트 조회하기
    public List<ItemOrderListResponseDTO> itemOrderList() {

        return itemOrderRepository.findAll().stream()
                .map(ItemOrderListResponseDTO::new)
                .collect(Collectors.toList());


    }

    // 발주 등록하기
    @Transactional
    public boolean addItemOrder(ItemOrderInputRequestDTO requestDTO) {

        Long trCompCode = requestDTO.getTrCompCode();
        Long empNo = requestDTO.getEmpNo();

        log.info("{}-------------------ㅋㅋㅋ", trCompCode);

        TradeCompany tradeCompany = tradeCompanyRepository.findById(trCompCode).orElseThrow();
//        TradeCompany tradeCompany = tradeCompanyRepository.findByTrCompCode(trCompCode);
        Employees foundEmp = employeesRepository.findByEmpNo(empNo);

        ItemOrder itemOrder = ItemOrder.builder()
                .itemOrderCheck(requestDTO.getItemOrderCheck())
                .itemOrderStart(requestDTO.getItemOrderStart())
                .itemOrderReg(requestDTO.getItemOrderReg())
                .itemOrderUpdate(requestDTO.getItemOrderUpdate())
                .tradeCompany(tradeCompany)
                .employees(foundEmp)
                .build();

        itemOrderRepository.save(itemOrder);
        return true;
    }



    // 발주서 삭제하기
    public void deleteItemOrder(Long itemOrderCode) {

        log.info("발주서 삭제하기");
        itemOrderRepository.deleteById(itemOrderCode);

    }
}
