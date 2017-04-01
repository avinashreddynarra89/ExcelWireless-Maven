package com.excelwireless.dto;

import java.util.List;

/**
 * Created by asp5045 on 11/17/16.
 */
public class MenuDto {

    private List<CategoryDto> categoryDtoList;
    private List<WebBrandDto> webBrandDtoList;
    private List<ModelDto> modelDtoList;

    public List<CategoryDto> getCategoryDtoList() {
        return categoryDtoList;
    }

    public void setCategoryDtoList(List<CategoryDto> categoryDtoList) {
        this.categoryDtoList = categoryDtoList;
    }

    public List<WebBrandDto> getWebBrandDtoList() {
        return webBrandDtoList;
    }

    public void setWebBrandDtoList(List<WebBrandDto> webBrandDtoList) {
        this.webBrandDtoList = webBrandDtoList;
    }

    public List<ModelDto> getModelDtoList() {
        return modelDtoList;
    }

    public void setModelDtoList(List<ModelDto> modelDtoList) {
        this.modelDtoList = modelDtoList;
    }
}
