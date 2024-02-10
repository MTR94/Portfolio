package com.mtrybala.portfolio.controller;

import com.mtrybala.portfolio.model.Project;
import com.mtrybala.portfolio.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }
    @GetMapping
    public List<Project> getAllProjects(){
        return
                projectService.getAllProjects();
    }
    @PostMapping
    public ResponseEntity<Project> addProject(@Valid @RequestBody Project project) {
        Project savedProject = projectService.saveProject(project);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProject.getId())
                .toUri();
        return
                ResponseEntity.created(location).body(savedProject);
    }
    @PutMapping("/{id}")
    public ResponseEntity <Project> updateProject(@PathVariable Long id ,@Valid @RequestBody Project projectDetails){
        Project updatedProject = projectService.updateProject(id , projectDetails);
        return
                ResponseEntity.ok(updatedProject);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok().body(project);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }




}
