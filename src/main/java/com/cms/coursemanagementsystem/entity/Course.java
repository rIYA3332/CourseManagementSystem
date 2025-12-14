package com.cms.coursemanagementsystem.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;
    private int durationInWeeks;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Teacher teacher; // One course has one teacher

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private Program program; // Many courses belong to one program

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Module> modules; // One course has many modules

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>(); // Many courses have many students

    public Course() {}

    public Course(String courseName, String description, int durationInWeeks) {
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}