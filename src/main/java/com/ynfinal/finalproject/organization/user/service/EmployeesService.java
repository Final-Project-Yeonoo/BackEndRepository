package com.ynfinal.finalproject.organization.user.service;

import com.ynfinal.finalproject.aws.S3Service;
import com.ynfinal.finalproject.organization.user.auth.TokenEmployeeInfo;
import com.ynfinal.finalproject.organization.user.auth.TokenProvider;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesLoginRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesSignUpRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesModifyDTO;
import com.ynfinal.finalproject.organization.user.dto.request.MypageModifyDTO;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesSignUpResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.LoginResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.MypageResponseDTO;
import com.ynfinal.finalproject.organization.user.entity.Authorization;
import com.ynfinal.finalproject.organization.user.entity.Department;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.entity.Position;
import com.ynfinal.finalproject.organization.user.exception.DuplicatedEmpIdExpcetion;
import com.ynfinal.finalproject.organization.user.exception.NoRegisteredArgumentsException;
import com.ynfinal.finalproject.organization.user.repository.AuthorizationRepository;
import com.ynfinal.finalproject.organization.user.repository.DepartmentRepository;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import com.ynfinal.finalproject.organization.user.repository.PositionRepository;
import com.ynfinal.finalproject.util.Check;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmployeesService {
    private final AuthorizationRepository authorizationRepository;
    private final EmployeesRepository employeesRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    private final PasswordEncoder encoder;
    private final TokenProvider tokenProvider;
    private final S3Service s3Service;

//    @Value("${upload.path}")
//    private String uploadRootPath;
    //유저리스트 변경내용
    public List<EmployeesResponseDTO> updateEmployee(EmployeesModifyDTO employeesModifyDTO) {

//        List<EmployeesResponseDTO> updatedEmployees = new ArrayList<>();
//
//        log.info("확인!!{}", employeesModifyDTO);
//        // 수정 전 데이터 조회
//        Long target = employeesModifyDTO.getEmpNo();
//        System.out.println("target : " + target);
//
//        Optional<Employees> byEmpNo = employeesRepository.findByEmpNo(target);
//
//        System.out.println("\n\n");
//        System.out.println("list = " + byEmpNo);
//
//        // 변경이 안되는 값
//        byEmpNo.ifPresent(entity -> {
//            Long empNo = entity.getEmpNo();
//            // 변경이 될 수 있는 DTO에서 받은 값
//            Long modifyDTODeptCode = employeesModifyDTO.getDeptCode();
//            String modifyDTOEmpAddress = employeesModifyDTO.getEmpAddress();
//            LocalDate modifyDTOEmpHiredDate = employeesModifyDTO.getEmpHiredDate();
//            String modifyDTOEmpExtension = employeesModifyDTO.getEmpExtension();
//            String modifyDTOEmpId = employeesModifyDTO.getEmpId();
//            String employeesModifyDTOEmpName = employeesModifyDTO.getEmpName();
//            String employeesModifyDTOEmpPassword = employeesModifyDTO.getEmpPassword();
//            String employeesModifyDTOEmpPhone = employeesModifyDTO.getEmpPhone();
//            Long employeesModifyDTOPosCode = employeesModifyDTO.getPosCode();
//            Check modifyDTOInfoAuth = employeesModifyDTO.getInfoAuth();
//            Check employeesModifyDTOInventoryAuth = employeesModifyDTO.getInventoryAuth();
//            Check employeesModifyDTOPurchaseAuth = employeesModifyDTO.getPurchaseAuth();
//            Check employeesModifyDTOUserAuth = employeesModifyDTO.getUserAuth();
//            boolean employeesModifyDTOEmpValidate = employeesModifyDTO.isEmpValidate();
//
//            System.out.println("employeesModifyDTOPosCode : " + employeesModifyDTOPosCode);
//            System.out.println("modifyDTODeptCode : " + modifyDTODeptCode);
//
//            entity.setEmpId(modifyDTOEmpId);
//            entity.setEmpPassword(employeesModifyDTOEmpPassword);
//            entity.setDepartment(Department.builder().deptCode(modifyDTODeptCode).build());
//            entity.setPosition(Position.builder().posCode(employeesModifyDTOPosCode).build());
//            entity.setEmpExtension(modifyDTOEmpExtension);
//            entity.setEmpName(employeesModifyDTOEmpName);
//            entity.setEmpPhone(employeesModifyDTOEmpPhone);
//            entity.setEmpValidate(employeesModifyDTOEmpValidate);
//            entity.setEmpHiredDate(modifyDTOEmpHiredDate);
//            entity.setEmpAddress(modifyDTOEmpAddress);
//            entity.setUserAuth(employeesModifyDTOUserAuth);
//            entity.setInfoAuth(modifyDTOInfoAuth);
//            entity.setInventoryAuth(employeesModifyDTOInventoryAuth);
//            entity.setPurchaseAuth(employeesModifyDTOPurchaseAuth);
//
//            Employees updated = employeesRepository.save(entity);
//            updatedEmployees.add(convertToResponseDTO(updated));
//        });
//
//
//        return updatedEmployees ;

        List<EmployeesResponseDTO> updatedEmployees = new ArrayList<>();

        log.info("확인!!{}", employeesModifyDTO);
        // 수정 전 데이터 조회
        Long target = employeesModifyDTO.getEmpNo();
        System.out.println("target : " + target);

        Employees employees = employeesRepository.findByEmpNo(target);

        System.out.println("\n\n");
        System.out.println("employees = " + employees);

        if (employees != null) {
            // 변경이 안되는 값
            Long empNo = employees.getEmpNo();
            // 변경이 될 수 있는 DTO에서 받은 값
            Long modifyDTODeptCode = employeesModifyDTO.getDeptCode();
            String modifyDTOEmpAddress = employeesModifyDTO.getEmpAddress();
            Date modifyDTOEmpHiredDate = employeesModifyDTO.getEmpHiredDate();
            String modifyDTOEmpExtension = employeesModifyDTO.getEmpExtension();
            String modifyDTOEmpId = employeesModifyDTO.getEmpId();
            String employeesModifyDTOEmpName = employeesModifyDTO.getEmpName();
            String employeesModifyDTOEmpPassword = employeesModifyDTO.getEmpPassword();
            String employeesModifyDTOEmpPhone = employeesModifyDTO.getEmpPhone();
            Long employeesModifyDTOPosCode = employeesModifyDTO.getPosCode();
            Check modifyDTOInfoAuth = employeesModifyDTO.getInfoAuth();
            Check employeesModifyDTOInventoryAuth = employeesModifyDTO.getInventoryAuth();
            Check employeesModifyDTOPurchaseAuth = employeesModifyDTO.getPurchaseAuth();
            Check employeesModifyDTOUserAuth = employeesModifyDTO.getUserAuth();
            boolean employeesModifyDTOEmpValidate = employeesModifyDTO.isEmpValidate();

            System.out.println("employeesModifyDTOPosCode : " + employeesModifyDTOPosCode);
            System.out.println("modifyDTODeptCode : " + modifyDTODeptCode);

            employees.setEmpId(modifyDTOEmpId);
            employees.setEmpPassword(employeesModifyDTOEmpPassword);
            employees.setDepartment(Department.builder().deptCode(modifyDTODeptCode).build());
            employees.setPosition(Position.builder().posCode(employeesModifyDTOPosCode).build());
            employees.setEmpExtension(modifyDTOEmpExtension);
            employees.setEmpName(employeesModifyDTOEmpName);
            employees.setEmpPhone(employeesModifyDTOEmpPhone);
            employees.setEmpValidate(employeesModifyDTOEmpValidate);
            employees.setEmpHiredDate(modifyDTOEmpHiredDate);
            employees.setEmpAddress(modifyDTOEmpAddress);
//            employees.setUserAuth(employeesModifyDTOUserAuth);
//            employees.setInfoAuth(modifyDTOInfoAuth);
//            employees.setInventoryAuth(employeesModifyDTOInventoryAuth);
//            employees.setPurchaseAuth(employeesModifyDTOPurchaseAuth);

            Employees updated = employeesRepository.save(employees);
            Authorization authorization = Authorization.builder()
                    .employees(updated)
                    .infoAuth(modifyDTOInfoAuth)
                    .userAuth(employeesModifyDTOUserAuth)
                    .inventoryAuth(employeesModifyDTOInventoryAuth)
                    .purchaseAuth(employeesModifyDTOPurchaseAuth)
                    .build();
            authorizationRepository.save(authorization);
            updatedEmployees.add(convertToResponseDTO(updated));
        } else {
            log.warn("Employee not found for empNo: {}", target);
            // 추가적인 로깅 또는 기타 작업 수행
        }

        return updatedEmployees;



    }


    private EmployeesResponseDTO convertToResponseDTO(Employees employees) {
        EmployeesResponseDTO responseDTO = new EmployeesResponseDTO();

        // Employees 객체의 필드 값을 EmployeesResponseDTO에 설정
        responseDTO.setEmpNo(employees.getEmpNo());
        responseDTO.setEmpId(employees.getEmpId());
        responseDTO.setEmpName(employees.getEmpName());
        responseDTO.setEmpAddress(employees.getEmpAddress());
        responseDTO.setEmpPassword(employees.getEmpPassword());
        responseDTO.setEmpPhone(employees.getEmpPhone());

        return responseDTO;
    }


    // 회원가입 처리
    public EmployeesSignUpResponseDTO create(EmployeesSignUpRequestDto dto)
    throws RuntimeException{

        if(dto == null){
            throw new NoRegisteredArgumentsException("가입 정보가 없습니다.");
        }
        // 중복검증 테스트
        duplicateValidate(dto);


        // 패스워드 인코딩
        String encoded = passwordEncode(dto);
        dto.setEmpPassword(encoded);



        // 사원 엔터티로 변환
        Employees employees = dto.toEntity();
        Employees saved = employeesRepository.save(employees);

        // 권한 저장 처리
        Authorization authorization = Authorization.builder()
                .employees(Employees.builder().empNo(saved.getEmpNo()).build())
                .userAuth(dto.getUserAuth())
                .infoAuth(dto.getInfoAuth())
                .purchaseAuth(dto.getPurchaseAuth())
                .inventoryAuth(dto.getInventoryAuth())
                .build();
        authorizationRepository.save(authorization);

        log.info("회원가입 정상 수행!!! -- save user {}", saved);




        return new EmployeesSignUpResponseDTO(saved);

    }

    private String passwordEncode(EmployeesSignUpRequestDto dto) {
        String encoded = encoder.encode(dto.getEmpPassword());
        return encoded;
    }

    private void duplicateValidate(EmployeesSignUpRequestDto dto) {
        String empId = dto.getEmpId();
        String empExtension = dto.getEmpExtension();
        String empPhone = dto.getEmpPhone();
        if(isDuplicate(empId)){
            log.warn("이메일이 중복되었습니다. {}", empId );
            throw new DuplicatedEmpIdExpcetion("중복된 사원아이디입니다.");
        }

        if(isEmpPhone(empPhone)){
            log.warn("핸드폰번호가 중복되었습니다. - {}", empPhone);
            throw new DuplicatedEmpIdExpcetion("중복된 핸드폰번호입니다.");
        }

        if(isExtensionDuplicate(empExtension)){
            log.warn("내선번호가 중복되었습니다. - {}", empExtension);
            throw new DuplicatedEmpIdExpcetion("중복된 내선번호입니다.");
        }
    }

    private boolean isEmpPhone(String empPhone) {
        return employeesRepository.existsByEmpPhone(empPhone);
    }

    private boolean isExtensionDuplicate(String empExtension) {
        return employeesRepository.existsByEmpExtension(empExtension);
    }

    public boolean isDuplicate(String empId) {
        return employeesRepository.existsByEmpId(empId);
    }

    // 사원 인증
    public LoginResponseDTO authenticate(final EmployeesLoginRequestDto dto){

        // 사원 아이디를 통해 회원 정보 조회
        Employees employees = employeesRepository.findByEmpId(dto.getEmpId())
                .orElseThrow(
                        () -> new RuntimeException("가입된 사원이 아닙니다")
                );

        // 패스워드 검증
        String rawPassword = dto.getEmpPassword();
        String encodedPassword = employees.getEmpPassword();

        if (!encoder.matches(rawPassword, encodedPassword)){
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

        log.info("{}님 로그인 성공!!", employees.getEmpName());
        Authorization authorization = authorizationRepository.findByEmployees_EmpNo(employees.getEmpNo());
        // 로그인 성공 후에 클라이언트에 리턴된 값, 토큰 인증 방식
        // Jwt를 클라이언트에게 발급
        String token = tokenProvider.createToken(employees, authorization);

        return new LoginResponseDTO(employees, token, authorization);


    }

    // 사원 전체 조회
    public List<EmployeesResponseDTO> findAll() {
        List<Employees> employeesList = employeesRepository.findAll();
        List<EmployeesResponseDTO> employeesResponseDTOList = employeesList.stream().map(employees ->
        {
            Authorization byEmployeesEmpNo = authorizationRepository.findByEmployees_EmpNo(employees.getEmpNo());



            return EmployeesResponseDTO.builder()
                    .empNo(employees.getEmpNo())
                    .empId(employees.getEmpId())
                    .empName(employees.getEmpName())
                    .posName(employees.getPosition().getPosName())
                    .deptName(employees.getDepartment().getDeptName())
                    .empExtension(employees.getEmpExtension())
                    .empHiredDate(employees.getEmpHiredDate())
                    .empPhone(employees.getEmpPhone())
                    .empAddress(employees.getEmpAddress())
                    .empPassword(employees.getEmpPassword())
                    .empValidate(employees.isEmpValidate())
                    .userAuth(byEmployeesEmpNo.getUserAuth())
                    .infoAuth(byEmployeesEmpNo.getInfoAuth())
                    .salesAuth(byEmployeesEmpNo.getSalesAuth())
                    .purchaseAuth(byEmployeesEmpNo.getPurchaseAuth())
                    .inventoryAuth(byEmployeesEmpNo.getInventoryAuth())
                    .productAuth(byEmployeesEmpNo.getProductAuth())
                    .build();
        }


        ).collect(Collectors.toList());

        return employeesResponseDTOList;


    }

    public MypageResponseDTO findMyPage(Long empNo) {
        log.info("empNo {}", empNo);

        Employees employees = employeesRepository.findByEmpNo(empNo);
        if(employees==null) {
            throw new RuntimeException("해당 사원 정보가 없습니다.");
        }

        log.info("employess ----------------{}", employees);
        return MypageResponseDTO.builder()
                .empNo(empNo)
                .empId(employees.getEmpId())
                .empName(employees.getEmpName())
                .deptName(employees.getDepartment().getDeptName())
                .posName(employees.getPosition().getPosName())
                .empExtension(employees.getEmpExtension())
                .empPhone(employees.getEmpPhone())
                .empAddress(employees.getEmpAddress())
                .build();

    }

    public MypageResponseDTO updateMyPage(MypageModifyDTO modifyDTO) {

        log.info("{}---------", modifyDTO);

        Employees employees = employeesRepository.findByEmpId(modifyDTO.getEmpId()).orElseThrow();
        employees.setEmpAddress(modifyDTO.getEmpAddress());
        employees.setEmpPhone(modifyDTO.getEmpPhone());
        employees.setEmpPassword(encoder.encode(modifyDTO.getEmpPassword()));

        Employees saved = employeesRepository.save(employees);

        return MypageResponseDTO.builder()
                 .empNo(saved.getEmpNo())
                .empId(saved.getEmpId())
                .deptName(saved.getDepartment().getDeptName())
                .posName(saved.getPosition().getPosName())
                .empExtension(saved.getEmpExtension())
                .empPhone(saved.getEmpPhone())
                .empAddress(saved.getEmpAddress())
                .build();

    }

    /**
     * 업로드된 파일을 서버에 저장하고 저장 경로를 리턴
     * @param originalFile - 업로드된 파일의 정보
     * @return 실제로 저장된 이미지의 경로
     */
    public String uploadProfileImage(MultipartFile originalFile) throws IOException {

        // 루트 디렉토리가 존재하는지 확인 후 존재하지 않으면 생성
//        File rootDir = new File(uploadRootPath);
//        if (!rootDir.exists()) rootDir.mkdir();

        // 파일명을 유니크하게 변경
        String uniqueFileName = UUID.randomUUID()
                + "_" + originalFile.getOriginalFilename();

//         파일을 저장
//        File uploadFile = new File(uploadRootPath + "/" + uniqueFileName);
//        originalFile.transferTo(uploadFile);

        // 파일을 S3 버킷에 저장
        String uploadUrl = s3Service.uploadToS3Bucket(originalFile.getBytes(), uniqueFileName);

        return uploadUrl;
//            return uploadFile.toString();
    }

    public String getProfilePath(String empId) {
        Employees employees = employeesRepository.findByEmpId(empId).orElseThrow();
//        return uploadRootPath + "/" + user.getProfileImg();
        return employees.getEmpProfile();
    }

    public void modifyProfile(TokenEmployeeInfo tokenEmployeeInfo, String uploadedFilePath) {
        log.info("{}---------ㅋㅋ", tokenEmployeeInfo.getEmpId());
        Employees employees1 = employeesRepository.findByEmpId(tokenEmployeeInfo.getEmpId()).orElseThrow();
        employees1.setEmpProfile(uploadedFilePath);
        employeesRepository.save(employees1);
    }


}
