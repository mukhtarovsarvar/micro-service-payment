package com.click.dto.profile;

import com.click.enums.EntityStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfileDTO {

    private String uuid;

    private LocalDateTime createDate;

    private EntityStatus status;

    private String name;

    private String surname;

    private String phone;
}
