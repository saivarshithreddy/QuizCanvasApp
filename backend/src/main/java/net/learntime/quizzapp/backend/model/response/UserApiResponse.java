package net.learntime.quizzapp.backend.model.response;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserApiResponse {

    private UUID id;
    private String name;
    private String email;
    private String provider;
    private String image;

}
