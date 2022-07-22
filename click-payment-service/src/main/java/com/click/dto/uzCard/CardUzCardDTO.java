package com.click.dto.uzCard;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CardUzCardDTO {

    private String uuid;

    private String number;

    private String expDate;

    private Long balance;

    private String clientId;

    private String phoneNUmber;

    private LocalDateTime createDate;
}
