package com.ynfinal.finalproject.organization.user.api;

import antlr.Token;
import com.ynfinal.finalproject.organization.user.auth.TokenEmployeeInfo;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesLoginRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesModifyDTO;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesSignUpRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.MypageModifyDTO;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesSignUpResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.LoginResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.MypageResponseDTO;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.exception.DuplicatedEmpIdExpcetion;
import com.ynfinal.finalproject.organization.user.exception.NoRegisteredArgumentsException;
import com.ynfinal.finalproject.organization.user.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ynfinal/employee")
//@CrossOrigin("*")
@RequiredArgsConstructor
public class EmployeesController {


    private final EmployeesService employeesService;


    //    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping


//    사용자 조회

    @GetMapping
    public ResponseEntity<?> handleEmployeesGetRequest(){
        List<EmployeesResponseDTO> responseDTOList = employeesService.findAll();

        return ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/mypage/{empNo}")
    public ResponseEntity<?> handleMyPageEmployeesGetRequest(@PathVariable("empNo")Long empNo){
        MypageResponseDTO mypageResponseDTO = employeesService.findMyPage(empNo);

        return ResponseEntity.ok(mypageResponseDTO);
    }


    // empId 중복체크 GET:  /ynfinal/employee/check?empId=aaa@aaa.com
    @GetMapping("/check")
    public ResponseEntity<?> check(String empId){

        if(empId.trim().equals("")){
            return ResponseEntity.badRequest()
                    .body("사원 이메일이 없습니다.");
        }


        boolean resultFlag = employeesService.isDuplicate(empId);

        return ResponseEntity.ok().body(resultFlag);

    }


    // 회원가입 요청처리
    // POST : /ynfinal/employee
    @PostMapping
    public ResponseEntity<?> signUp(
            @Validated @RequestBody EmployeesSignUpRequestDto dto,
            BindingResult result
    ){
        log.info("/api/auth POST! - {}", dto);

        if( result.hasErrors()){
            log.warn(result.toString());
            return ResponseEntity.badRequest()
                    .body(result.getFieldError());
        }

        EmployeesSignUpResponseDTO responseDTO = employeesService.create(dto);
            return ResponseEntity.ok()
                    .body(responseDTO);
    }

    @PostMapping("/{empNo}")
    public ResponseEntity<?> modify(
            @Validated @RequestBody EmployeesSignUpRequestDto dto,
            BindingResult result
    ){
        log.info("/api/auth POST! - {}", dto);

        if( result.hasErrors()){
            log.warn(result.toString());
            return ResponseEntity.badRequest()
                    .body(result.getFieldError());
        }

        EmployeesSignUpResponseDTO responseDTO = employeesService.create(dto);
        return ResponseEntity.ok()
                .body(responseDTO);
    }


    @PostMapping("/image")
    public ResponseEntity<?> modifyProfile(
            @AuthenticationPrincipal TokenEmployeeInfo tokenEmployeeInfo
            , @RequestPart(value = "profileImg", required = false) MultipartFile profileImg
    ) {
        try {

            log.info("{} 이미지" , profileImg);
            String uploadedFilePath = null;
            if(profileImg != null) {
                log.info("attached file name: {}", profileImg.getOriginalFilename());
                uploadedFilePath = employeesService.uploadProfileImage(profileImg);
            }

            employeesService.modifyProfile(tokenEmployeeInfo ,uploadedFilePath);
            return ResponseEntity.ok()
                    .body("수정완료");

        } catch (Exception e) {
            log.warn("기타 예외가 발생했습니다.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    // 로그인 요청 처리
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(
            @Validated @RequestBody EmployeesLoginRequestDto dto
            ) {

        LoginResponseDTO loginResponseDTO = employeesService.authenticate(dto);

        return ResponseEntity.ok().body(loginResponseDTO);


    }


    @PatchMapping("/mypage")
    public ResponseEntity<?> handleMyPageEmployeesGetRequest(@Validated @RequestBody MypageModifyDTO modifyDTO){
        MypageResponseDTO mypageResponseDTO = employeesService.updateMyPage(modifyDTO);

        return ResponseEntity.ok(mypageResponseDTO);
    }

    @RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<?> modifyEmployee (@Valid @RequestBody EmployeesModifyDTO employeesModifyDTO){
        log.info("MODIFY 0K! {}",employeesModifyDTO );

        List<EmployeesResponseDTO> responseDTOList = employeesService.updateEmployee(employeesModifyDTO);

        return ResponseEntity.ok().body(responseDTOList);
    }









    // 프로필 사진 이미지 데이터를 클라이언트에게 응답처리
    @GetMapping("/load-profile")
    public ResponseEntity<?> loadFile(
            @AuthenticationPrincipal TokenEmployeeInfo tokenEmployeeInfo
    ) {
        log.info("/api/auth/load-profile GET ! - user: {}", tokenEmployeeInfo.getEmpName());

        try {
            // 클라이언트가 요청한 프로필 사진을 응답해야 함
            // 1. 프로필 사진의 경로를 얻어야 함.
            String filePath
                    = employeesService.getProfilePath(tokenEmployeeInfo.getEmpId());

            // 2. 얻어낸 파일 경로를 통해서 실제 파일데이터 로드하기
            File profileFile = new File(filePath);

            if (!profileFile.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 해당 경로에 저장된 파일을 바이트배열로 직렬화해서 리턴
            byte[] fileData = FileCopyUtils.copyToByteArray(profileFile);

            // 3. 응답 헤더에 컨텐츠 타입을 설정
            HttpHeaders headers = new HttpHeaders();
            MediaType contentType = findExtensionAndGetMediaType(filePath);
            if (contentType == null) {
                return ResponseEntity.internalServerError()
                        .body("발견된 파일은 이미지 파일이 아닙니다.");
            }
            headers.setContentType(contentType);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileData);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("파일을 찾을 수 없습니다.");
        }

    }

    private MediaType findExtensionAndGetMediaType(String filePath) {

        // 파일경로에서 확장자 추출하기
        // D:/todo_upload/kfdslfjhsdkjhf_abc.jpg
        String ext
                = filePath.substring(filePath.lastIndexOf(".") + 1);

        switch (ext.toUpperCase()) {
            case "JPG": case "JPEG":
                return MediaType.IMAGE_JPEG;
            case "PNG":
                return MediaType.IMAGE_PNG;
            case "GIF":
                return MediaType.IMAGE_GIF;
            default:
                return null;
        }

    }


    // s3에서 불러온 프로필 사진 처리
    @GetMapping("/load-s3")
    public ResponseEntity<?> loadS3(
            @AuthenticationPrincipal TokenEmployeeInfo tokenEmployeeInfo
    ) {
        log.info("/api/auth/load-s3 GET - user: {}", tokenEmployeeInfo);

        try {
            String profilePath = employeesService.getProfilePath(tokenEmployeeInfo.getEmpId());
            return ResponseEntity.ok().body(profilePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

