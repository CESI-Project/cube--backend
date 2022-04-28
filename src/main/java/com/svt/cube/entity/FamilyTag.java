package com.svt.cube.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class FamilyTag {
    @Id
    @SequenceGenerator(name = "familyTag_sequence", sequenceName = "familyTag_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "familyTag_sequence")
    private Integer id;
    private String nameEn;
    private String nameFr;
    @JsonManagedReference
    @OneToMany(mappedBy = "familyTag")
    private List<Tag> tags;

    public FamilyTag() {
    }

    public FamilyTag(String nameEn, String nameFr, List<Tag> tags) {
        this.nameEn = nameEn;
        this.nameFr = nameFr;
        this.tags = tags;
    }

    public FamilyTag(String nameEn, String nameFr) {
        this.nameEn = nameEn;
        this.nameFr = nameFr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
