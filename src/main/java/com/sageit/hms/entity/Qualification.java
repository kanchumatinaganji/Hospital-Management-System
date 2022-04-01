package com.sageit.hms.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Qualification  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 25, nullable = false,unique = true)
    private String name;

    public Qualification() { }
    public Qualification(int id,String name) {
        super();
        this.id=id;
        this.name=name;
    }

    public Qualification(String name) {
        super();
        this.name=name;
    }

    public Qualification(int id) {
        super();
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qualification that = (Qualification) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
