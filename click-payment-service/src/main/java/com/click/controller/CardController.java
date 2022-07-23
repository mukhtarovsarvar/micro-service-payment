package com.click.controller;

import com.click.dto.uzCard.CardUzCardDTO;
import com.click.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;


    @GetMapping("/create")
    public ResponseEntity<CardUzCardDTO> create(){

        CardUzCardDTO dto = new CardUzCardDTO();
        dto.setClientId("8a8a81bc81132a510181132da9f80001");

        CardUzCardDTO uzCardDTO = cardService.create(dto);


        return ResponseEntity.ok(uzCardDTO);
    }



    @GetMapping("")
    public ResponseEntity<CardUzCardDTO[]> getAll(){
        return ResponseEntity.ok(cardService.getAll());
    }



}
