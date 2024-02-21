package com.example.backendappproduits.service;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LignProdDto {

    @CsvBindByPosition(position = 0)
    private String groupLabel;

    @CsvBindByPosition(position = 1)
    private String appliCode;
}
