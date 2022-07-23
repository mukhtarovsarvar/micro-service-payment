package com.click.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class ProfileEntity extends BaseEntity{

    private String name;

    private String username;

    private String password;

    private String phone;

    private String uzCardProfileId;

}
