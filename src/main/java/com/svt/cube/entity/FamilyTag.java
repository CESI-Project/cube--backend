package com.svt.cube.entity;

import javax.persistence.*;

@Entity
@Table
public class FamilyTag {
    @Id
    @SequenceGenerator(name = "familyTag_sequence", sequenceName = "familyTag_sequence", initialValue = 6, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "familyTag_sequence")
    private Integer id;
    private String nameEn;
    private String nameFr;

    public FamilyTag() {
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
}
