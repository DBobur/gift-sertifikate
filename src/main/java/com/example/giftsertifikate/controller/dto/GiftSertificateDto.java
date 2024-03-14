package com.example.giftsertifikate.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiftSertificateDto {
    private String name;
    private String description;
    private List<TagDto> tags;
}
