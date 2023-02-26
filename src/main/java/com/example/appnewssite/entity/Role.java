package com.example.appnewssite.entity;

import com.example.appnewssite.entity.enums.Permission;
import com.example.appnewssite.entity.template.AbstarctEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<Permission> permissionList;


}
