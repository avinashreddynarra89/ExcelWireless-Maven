package com.excelwireless.bl;


import com.excelwireless.dto.*;
import com.excelwireless.util.SQLQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asp5045 on 11/17/16.
 */

@Component
public class WebMenuManager {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SQLQueries sqlQueries;

    public MenuDto getWebMenu() {

        MenuDto menuDto = new MenuDto();

        List<CategoryDto> categoryDtoList;
        List<BrandDto> brandDtos;
        List<ModelDto> modelDtoList;

        List<WebBrandDto> webBrandDtoList = new ArrayList<>();


        //Getting all the category from table
        categoryDtoList = jdbcTemplate.query(sqlQueries.getCategoryDetails, new WebCategoryMapper());

        //Getting all brands from brand table
        brandDtos = jdbcTemplate.query(sqlQueries.getBrandDetails,new WebBrandMapper());

        //Now for Each brand id getting MODEL IDS from PRODUCT table
        for(int i = 0; i<brandDtos.size(); i++)
        {
            WebBrandDto webBrandDto = new WebBrandDto();

            webBrandDto.setBrandId(brandDtos.get(i).getBrandId());
            webBrandDto.setBrandName(brandDtos.get(i).getBrandName());

            //Calling method to get all models details for particular brand id.
            modelDtoList = getModelListForBrand(brandDtos.get(i).getBrandId());

            webBrandDto.setModelDtoList(modelDtoList);

            webBrandDtoList.add(webBrandDto);

            webBrandDtoList.set(i,webBrandDto);
        }

        menuDto.setCategoryDtoList(categoryDtoList);
        menuDto.setWebBrandDtoList(webBrandDtoList);

        System.out.println("Send Web Menu Details Successfully");

        return menuDto;


    }

    private List<ModelDto> getModelListForBrand(int brandId) {

        List<ModelDto> modelDtoListGlobal = new ArrayList<>();

        List<Integer> modelNos;

        modelNos = jdbcTemplate.queryForList(sqlQueries.getModelDetailsForBrand,Integer.class,brandId);

        for(int i = 0;i<modelNos.size(); i++)

        {
            ModelDto modelDto = new ModelDto();

            List<ModelDto> modelDtoList;

            modelDtoList = jdbcTemplate.query(sqlQueries.getModelDetails,new WebModelMapper(),modelNos.get(i) );

            if(modelDtoList.size() != 0)
            {

                modelDto.setModelId(modelDtoList.get(0).getModelId());
                modelDto.setModelName(modelDtoList.get(0).getModelName());

                modelDtoListGlobal.add(modelDto);
                modelDtoListGlobal.set(i,modelDto);
            }


        }

        return modelDtoListGlobal;

    }

    public List<WebBrandDto> getSideBardForParts() {

        List<BrandDto> brandDtoList = new ArrayList<>();
        List<ModelDto> modelDtoList = new ArrayList<>();
        List<WebBrandDto> webBrandDtoList = new ArrayList<>();

        brandDtoList = jdbcTemplate.query(sqlQueries.getBrandDetailsForParts,new WebBrandMapper());

        //Now for Each brand id getting MODEL IDS from PRODUCT table
        for(int i = 0; i<brandDtoList.size(); i++)
        {
            WebBrandDto webBrandDto = new WebBrandDto();

            webBrandDto.setBrandId(brandDtoList.get(i).getBrandId());
            webBrandDto.setBrandName(brandDtoList.get(i).getBrandName());

            //Calling method to get all models details for particular brand id.
            modelDtoList = getModelListForBrand(brandDtoList.get(i).getBrandId());

            webBrandDto.setModelDtoList(modelDtoList);

            webBrandDtoList.add(webBrandDto);

            webBrandDtoList.set(i,webBrandDto);
        }

        return webBrandDtoList;

    }

    private final class WebCategoryMapper implements RowMapper<CategoryDto> {

        @Override
        public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            CategoryDto category = new CategoryDto();

            category.setCategoryId(rs.getInt("CATEGORY_ID"));
            category.setCategoryName(rs.getString("CATEGORY_NAME"));

            return category;
        }
    }

    private final class WebBrandMapper implements RowMapper<BrandDto> {

        @Override
        public BrandDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            BrandDto brand = new BrandDto();

            brand.setBrandId(rs.getInt("BRAND_ID"));
            brand.setBrandName(rs.getString("BRAND_NAME"));

//            List<ModelDto> modelDtoList = new ArrayList<>();
//
//            modelDtoList = jdbcTemplate.query(sqlQueries.getModelDetailsForBrand, new WebModelMapper(), brand.getBrandId());




            return brand;
        }

    }

    private final class WebModelMapper implements RowMapper<ModelDto>
    {

        @Override
        public ModelDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            ModelDto modelDto = new ModelDto();

            modelDto.setModelId(rs.getInt("ID"));

            modelDto.setModelName(rs.getString("NAME"));

            return modelDto;
        }

    }
}


