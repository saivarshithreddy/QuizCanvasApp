package net.learntime.quizzapp.backend.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RefreshTokenApiResponse {

    private String accessToken;
    private String refreshToken;
}
