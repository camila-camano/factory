package com.coderhouse.usuarios.model.request;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String type;
    private String  name;
}