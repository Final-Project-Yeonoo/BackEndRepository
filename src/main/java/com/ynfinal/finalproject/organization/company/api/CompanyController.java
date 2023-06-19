package com.ynfinal.finalproject.organization.company.api;

import com.ynfinal.finalproject.organization.company.dto.request.CompanyModifyRequestDTO;
import com.ynfinal.finalproject.organization.company.dto.request.CompanyPostRequestDTO;
import com.ynfinal.finalproject.organization.company.entity.Company;
import com.ynfinal.finalproject.organization.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ynfinal/comp")
//@CrossOrigin("*")
//@CrossOrigin(origins = "http://127.0.0.1:5502")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> handleCompGetRequest(){
        log.info("/ynfinal/comp GET!!");
        List<Company> companyList = companyService.findAll();
        for (Company company : companyList) {
            log.info("compnay {}", company);
        }
        return ResponseEntity.ok(companyList);
    }


    /**
     * 회사코드를 받아서 하나의 회사 정보를 출력한다.
     * @param compCode
     * @return Company
     */
    @GetMapping("/{compCode}")
    public ResponseEntity<?> handleCompGetRequest(@PathVariable("compCode")Long compCode){
        log.info("/ynfinal/comp/{compCode} GET!!");
//        Company company = companyService.findOne(compCode);
        Company company = companyService.findOne(compCode);
        return ResponseEntity.ok(company);
    }



    // 하나의 회사를 저장한다.
    // POST /ynfinal/comp
    @PostMapping
    public ResponseEntity<?> handleCompPostRequest(@RequestBody CompanyPostRequestDTO companyPostRequestDTO){
        Company company = companyService.insertOne(companyPostRequestDTO);

        return ResponseEntity.ok(company + " 저장 성공");
    }

    // 회사 정보를 수정한다
    @PatchMapping
    public ResponseEntity<?> handleCompPatchRequest(@Validated @RequestBody List<CompanyModifyRequestDTO> companyModifyRequestDTOList) {

        List<Company> companies = companyService.modifyAll(companyModifyRequestDTOList);

        for (CompanyModifyRequestDTO companyModifyDTO : companyModifyRequestDTOList) {
            log.info(companyModifyDTO.toString());
        }
        return ResponseEntity.ok(companies);
    }

    @DeleteMapping("/{compCode}")
    public ResponseEntity<?> handleCompDeleteRequest(@PathVariable("compCode")Long compCode ){
        List<Company> companies = companyService.deleteOne(compCode);
        return ResponseEntity.ok(companies);
    }

}
