package com.click.service;

import com.click.dto.uzCard.CardUzCardDTO;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.HttpHead;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CardService {

    private final RestTemplate restTemplate;

    @Value("${api.url.uzcard}")
    private String uzCardUrl;


    public CardUzCardDTO create(CardUzCardDTO card) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<CardUzCardDTO> entity = new HttpEntity<>(card, headers);

        String createCardUrl = uzCardUrl + "uzcard/api/v1/card/create";

        CardUzCardDTO body = restTemplate.exchange(createCardUrl, HttpMethod.POST, entity, CardUzCardDTO.class).getBody();

        return body;


    }

    public CardUzCardDTO[] getAll() {

        String createCardUrl = uzCardUrl + "uzcard/api/v1/card/all";

        CardUzCardDTO[] object = restTemplate.getForObject(createCardUrl,  CardUzCardDTO[].class);

        return object;
    }


}
