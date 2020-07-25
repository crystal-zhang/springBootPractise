package com.crystal.SpringBootPractise.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConfigProperty {
    private int id;
    private String code;
    private String value;
    private String description;
    private String type;
    private String status;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

}
