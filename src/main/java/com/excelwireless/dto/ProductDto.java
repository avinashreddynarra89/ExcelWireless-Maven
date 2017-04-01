package com.excelwireless.dto;

/**
 * Created by asp5045 on 5/9/16.
 */
public class ProductDto {

    private int productId;
    private String productNo;
    private String oldProductNo;
    private int categoryId;
    private int vendorId;
    private int brandId;
    private int modelId;
    private String altNo;
    private String description;
    private double costPrice;
    private double markup;
    private double retailPrice;
    private int quantity;
    private int minProductQuantity;
    private String returnRule;
    private String image;
    private String createdDate;
    private String categoryName;
    private String brandName;
    private String vendorName;
    private String imeiNo;
    private boolean addTax;
    private int stock;
    private int quantityForSell;
    private boolean isRelatedProduct;
    private int phoneId;
    private int relatedProductId;

    public String getAltNo() {
        return altNo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setAltNo(String altNo) {
        this.altNo = altNo;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImeiNo() {
        return imeiNo;
    }

    public void setImeiNo(String imeiNo) {
        this.imeiNo = imeiNo;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public int getMinProductQuantity() {
        return minProductQuantity;
    }

    public void setMinProductQuantity(int minProductQuantity) {
        this.minProductQuantity = minProductQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityForSell() {
        return quantityForSell;
    }

    public void setQuantityForSell(int quantityForSell) {
        this.quantityForSell = quantityForSell;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getReturnRule() {
        return returnRule;
    }

    public void setReturnRule(String returnRule) {
        this.returnRule = returnRule;
    }

    public boolean isRelatedProduct() {
        return isRelatedProduct;
    }

    public void setRelatedProduct(boolean relatedProduct) {
        isRelatedProduct = relatedProduct;
    }

    public boolean isAddTax() {
        return addTax;
    }

    public void setAddTax(boolean addTax) {
        this.addTax = addTax;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getOldProductNo() {
        return oldProductNo;
    }

    public void setOldProductNo(String oldProductNo) {
        this.oldProductNo = oldProductNo;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getRelatedProductId() {
        return relatedProductId;
    }

    public void setRelatedProductId(int relatedProductId) {
        this.relatedProductId = relatedProductId;
    }
}
