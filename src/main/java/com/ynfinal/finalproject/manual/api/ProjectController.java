package com.ynfinal.finalproject.manual.api;


import com.ynfinal.finalproject.manual.dto.request.ProjectDeleteDTO;
import com.ynfinal.finalproject.manual.dto.request.ProjectPostDTO;
import com.ynfinal.finalproject.manual.dto.response.ProjectResponseDTO;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.manual.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@Validated
@RequestMapping("/ynfinal/project")

public class ProjectController {
    private final ProjectService projectService;


    @GetMapping
    public ResponseEntity<?> getProject(){
        List<ProjectResponseDTO> list = projectService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> postProject(
            @Valid @RequestBody List<ProjectPostDTO> requestDTO
    ){
        projectService.insertProject(requestDTO);
        return ResponseEntity.ok("저장 성공했습니다.");

    }

    @DeleteMapping
    public ResponseEntity<?> deleteProject(
            @Valid @RequestBody List<ProjectDeleteDTO> requestDTO
    ){
        projectService.deleteProject(requestDTO);
        return ResponseEntity.ok("삭제 성공했습니다.");
    }

}
