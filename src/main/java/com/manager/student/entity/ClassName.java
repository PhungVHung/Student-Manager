package com.manager.student.entity;

import javax.persistence.*;
import java.util.Set;

public class ClassName {
    private int classId;
    private String className;

    public int getClassId() {
        return classId;
    }
    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})

    @JoinTable(name = "classNameSet", joinColumns = @JoinColumn(name = "classId"), inverseJoinColumns =
    @JoinColumn(name = "studentId"))
    private Set<Student> studentSet;
    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
