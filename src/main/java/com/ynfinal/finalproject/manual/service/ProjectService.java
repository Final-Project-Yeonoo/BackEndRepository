package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.ProjectDeleteDTO;
import com.ynfinal.finalproject.manual.dto.request.ProjectPostDTO;
import com.ynfinal.finalproject.manual.dto.response.ProjectResponseDTO;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.manual.repository.ProjectRepository;
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
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeesRepository employeesRepository;

    public List<ProjectResponseDTO> findAll() {
        return projectRepository.findAll().stream()
                .map(ProjectResponseDTO::new).collect(Collectors.toList());
    }


    public void insertProject(List<ProjectPostDTO> requestDTO) {
        for (ProjectPostDTO projectPostDTO : requestDTO) {
            Project project = projectPostDTO.toEntity();
            String s = projectPostDTO.getEmpId();
            if(s==null) continue;
            Employees employees = employeesRepository.findByEmpId(s).orElseThrow();
            project.setEmployees(employees);
            projectRepository.save(project);

        }
    }

    public void deleteProject(List<ProjectDeleteDTO> requestDTO) {
        requestDTO.stream().forEach( d -> {
                    if(d.getProjectCode()==null) return;
                    projectRepository.deleteById(d.getProjectCode());
                }
        );
    }
}
