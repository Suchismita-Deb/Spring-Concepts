package com.springHelloWorld.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class StudentRequestBody {
    private int count;
    @JsonProperty("studentIds")//If the name in the request bofy differs from variable name
    private List<String> studentIdList;
    private String greeting;
}
