package com.example.appnewssite.entity;

import com.example.appnewssite.entity.enums.Permission;
import com.example.appnewssite.entity.template.AbstarctEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends AbstarctEntity {

    @Column(unique = true,nullable = false)
    private String name;

    @Column(length = 600)
    private String description;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Permission> permissionList;


}
