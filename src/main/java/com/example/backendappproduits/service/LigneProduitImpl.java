package com.example.backendappproduits.service;

import com.example.backendappproduits.models.LigneProduit;
import com.example.backendappproduits.repository.LigneProdRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class LigneProduitImpl implements LigneProdService {

    @Autowired
    private LigneProdRepository lpRepo;

    @Override
    public List<LigneProduit> readCsvFile(MultipartFile file) {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            var csvToBean = new CsvToBeanBuilder<LignProdDto>(reader)
                    .withType(LignProdDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreQuotations(true)
                    .withSkipLines(1)
                    .withSeparator(';')
                    .build()
                    .parse();


            List<LigneProduit> dataFromCsv = convertCsvToLp(csvToBean);

            return dataFromCsv;

        } catch (IOException io) {
            return null;
        }
    }

    @Override
    public void saveCsvList(List<LigneProduit> lpList) {
        lpRepo.saveAll(lpList);
    }

    public static LigneProduit convertToEntity(LignProdDto dto) {
        LigneProduit lp = new LigneProduit();

        lp.setGroupLabel(dto.getGroupLabel());
        lp.setAppCode(dto.getAppliCode());
        return lp;
    }

    public static List<LigneProduit> convertCsvToLp(List<LignProdDto> dtoList) {
        List<LigneProduit> result = new ArrayList<>();

        for (LignProdDto dtoConvert : dtoList) {
            result.add(convertToEntity(dtoConvert));
        }
        return result;
    }


}
