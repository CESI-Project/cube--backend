package com.svt.cube.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Tag {
    @Id
    @SequenceGenerator(name = "tag_sequence", sequenceName = "tag_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence")
    private Integer id;
    private String nameEn;
    private String nameFr;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "familytag_id", nullable = false)
    private FamilyTag familyTag;
    @ManyToMany
    Set<Topic> topics;

    public Tag() {
    }

    public Tag(String nameEn, String nameFr) {
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

    public FamilyTag getFamilyTag() {
        return familyTag;
    }

    public void setFamilyTag(FamilyTag familyTag) {
        this.familyTag = familyTag;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
}
