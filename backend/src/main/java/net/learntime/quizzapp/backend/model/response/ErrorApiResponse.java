package net.learntime.quizzapp.backend.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorApiResponse {

    private Integer code;
    private String message;
}
