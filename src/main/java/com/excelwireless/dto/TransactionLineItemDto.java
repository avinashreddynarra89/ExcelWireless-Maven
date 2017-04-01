package com.excelwireless.dto;

/**
 * Created by asp5045 on 5/20/16.
 */
public class TransactionLineItemDto {

    private int transactionCompId;
    private boolean addTax;
    private int brandId;
    private int categoryId;
    private int vendorId;
    private int modelId;
    private String description;
    private String image;
    private String phoneNo;
    private String productNo;
    private int quantity;
    private double retailPrice;
    private String transactionDate;
    private double retailWithDis;
    private double totalProductPrice;
    private double totalProductPriceWithTax;
    private double discountPercentage;
    private int quantityForSell;
    private double costPrice;
    private double discount;
    private String transactionStatus;


    public int getTransactionCompId() {
        return transactionCompId;
    }

    public void setTransactionCompId(int transactionCompId) {
        this.transactionCompId = transactionCompId;
    }

    public boolean isAddTax() {
        return addTax;
    }

    public void setAddTax(boolean addTax) {
        this.addTax = addTax;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getRetailWithDis() {
        return retailWithDis;
    }

    public void setRetailWithDis(double retailWithDis) {
        this.retailWithDis = retailWithDis;
    }

    public double getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(double totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public double getTotalProductPriceWithTax() {
        return totalProductPriceWithTax;
    }

    public void setTotalProductPriceWithTax(double totalProductPriceWithTax) {
        this.totalProductPriceWithTax = totalProductPriceWithTax;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getQuantityForSell() {
        return quantityForSell;
    }

    public void setQuantityForSell(int quantityForSell) {
        this.quantityForSell = quantityForSell;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
