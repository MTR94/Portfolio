package com.mtrybala.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is required")
    @Size(min = 3 , max = 100 , message = "Title must be between 3 and 100 characters ")
    private String title;
    @NotBlank(message = "Description is required")
    @Size(min = 10 , max = 500 , message = "Description must be between 10 and 500 characters")
    private String description;
    @NotBlank(message = "Technology stack is required")
    @Size(min = 1 , max = 255 , message = "Technology stack must be between 1 and 255 characters")
    private String technologyStack;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(String technologyStack) {
        this.technologyStack = technologyStack;
    }
}
