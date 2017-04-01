package com.excelwireless.dto;

import java.util.List;

/**
 * Created by asp5045 on 11/17/16.
 */
public class WebBrandDto {

    private int brandId;
    private String brandName;
    private List<ModelDto> modelDtoList;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ModelDto> getModelDtoList() {
        return modelDtoList;
    }

    public void setModelDtoList(List<ModelDto> modelDtoList) {
        this.modelDtoList = modelDtoList;
    }
}
