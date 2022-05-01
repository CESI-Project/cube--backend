package com.svt.cube.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Tag {
    @Id
    @SequenceGenerator(name = "tag_sequence", sequenceName = "tag_sequence", initialValue = 18, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence")
    private Integer id;
    private String nameEn;
    private String nameFr;
    private Integer familyTagId;
    @ManyToMany
    private Set<Topic> topics;

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

    public Integer getFamilyTagId() {
        return familyTagId;
    }

    public void setfamilyTagId(Integer familyTagId) {
        this.familyTagId = familyTagId;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
}
