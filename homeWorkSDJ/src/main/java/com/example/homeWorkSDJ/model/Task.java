package com.example.homeWorkSDJ.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "DESCRIPTION")
    private String description;

    @Column (name = "STATUS")
    private TaskStatus status;

    @Column (name = "CREATED_DATE")
    private LocalDateTime createdDate;

}
