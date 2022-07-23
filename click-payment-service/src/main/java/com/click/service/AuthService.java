package com.click.service;

import com.click.dto.profile.ProfileDTO;
import com.click.dto.profile.RegistrationDTO;
import com.click.dto.response.ApiResponse;
import com.click.model.ProfileEntity;
import com.click.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final ProfileRepository profileRepository;


    private final RestTemplate restTemplate;


    @Value("${api.url.uzcard}")
    private String uzCardUrl;

    public ApiResponse<ProfileEntity> registration(RegistrationDTO dto) {

        ProfileEntity entity = profileRepository.findByUsername(dto.getUsername()).orElse(null);

        ProfileEntity profile = profileRepository.findByPhone(dto.getPhone()).orElse(null);

        if (entity != null) return new ApiResponse<>("Username used!", false,400);

        if (profile != null) return new ApiResponse<>("PhoneNumber used!", false,400);

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName(dto.getName());
        profileEntity.setPassword(dto.getPassword());
        profileEntity.setUsername(dto.getUsername());
        profileEntity.setPhone(dto.getPhone());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");


        HttpEntity<ProfileEntity> httpEntity = new HttpEntity<>(profileEntity, headers);

        String createCardUrl = uzCardUrl + "uzcard/api/v1/client";
        ProfileDTO body = null;

        try {
            body = restTemplate.exchange(createCardUrl, HttpMethod.POST, httpEntity, ProfileDTO.class).getBody();
        } catch (HttpStatusCodeException exception) {
            return new ApiResponse<>(exception.getMessage(),false,exception.getStatusCode().value());
        }


        assert body != null;

        profileEntity.setUzCardProfileId(body.getUuid());

        profileRepository.save(profileEntity);

        return new ApiResponse<>("Success", true, 200, profileEntity);
    }
}
