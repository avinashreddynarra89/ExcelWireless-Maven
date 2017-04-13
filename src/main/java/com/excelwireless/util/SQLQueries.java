package com.excelwireless.util;

import org.springframework.stereotype.Component;

/**
 * Created by asp5045 on 5/9/16.
 */
@Component
public class SQLQueries {

    public String addCustomerQuery =
            "INSERT INTO customer " +
            "(" +
                    "FIRST_NAME," +
                    "LAST_NAME," +
                    "PHONE_NO," +
                    "EMAIL," +
                    "TAX_ID," +
                    "DATEOFBIRTH," +
                    "CUSTOMER_TYPE," +
                    "GENDER," +
                    "STREET," +
                    "CITY," +
                    "STATE," +
                    "COUNTRY," +
                    "ZIPCODE," +
                    "FAX," +
                    "CUSTOMER_CREATE_DATE," +
                    "COMPANY_NAME)" +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


    //ADD TRANSACTION INTO DATABASE

    public String addWebTransaction =
            "INSERT INTO web_transaction(TRANSACTION_DATE," +
                    "TOTAL_AMOUNT," +
                    "TAX_AMOUNT," +
                    "DISCOUNT_AMOUNT," +
                    "SUBTOTAL," +
                    "TOTALQUANTITY," +
                    "CUSTOMER_PHONENO," +
                    "STATUS," +
                    "PREVIOUS_BALANCE, " +
                    "BALANCE, " +
                    "RECEIPT_NOTE," +
                    "FIRST_NAME_LAST_NAME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public String addTransactionLineItem =
            "INSERT INTO transaction_line_item " +
            "(TRANSACTION_COMP_ID," +
                    "DATE," +
                    "TRANSACTION_STATUS," +
                    "PRODUCT_NO," +
                    "QUANTITY," +
                    "RETAIL," +
                    "COST," +
                    "DISCOUNT," +
                    "DISCOUNT_PERCENTAGE," +
                    "RETAILWITHDISCOUNT," +
                    "TOTALPRODUCTPRICE," +
                    "TOTAL_PRODUCT_PRICE_WITH_TAX)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";



    public String addPhoneDetailsAsProduct =
            "INSERT INTO phone " +
                    "(PRODUCT_NO,IMEI_NO,COST,RETAIL,MARKUP,LAST_UPDATED_TIME) " +
                    "VALUES (?,?,?,?,?,?)";




    public String editCustomerQuery = "UPDATE customer" +
            " SET FIRST_NAME = ?,  " +
            "LAST_NAME = ?, " +
            "PHONE_NO = ?, " +
            "EMAIL = ?, " +
            "TAX_ID = ?,  " +
            "DATEOFBIRTH = ?," +
            "CUSTOMER_TYPE = ?, " +
            "GENDER = ?, " +
            " STREET = ?," +
            " CITY = ?, " +
            "STATE = ?, " +
            "COUNTRY = ?, " +
            "ZIPCODE = ?, " +
            "FAX = ?, " +
            "COMPANY_NAME = ? " +
            "WHERE CUSTOMER_ID = ? AND PHONE_NO = ?";


    public String updateProductQuantity =
            "UPDATE web_transaction_line_item SET " +
                    "QUANTITY = ? " +
                    "WHERE CUSTOMER_PHONENO = ? AND PRODUCT_NO = ?";


    //SQL QUERY TO GET  DETAILS FROM DATABASE

    public String getProductDetails = "SELECT " +
            "PRODUCT_ID," +
            "PRODUCT_NO," +
            "CATEGORY_ID," +
            "VENDOR_ID," +
            "BRAND_ID," +
            "MODEL_ID, " +
            "DESCRIPTION," +
            "COST_PRICE," +
            "RETAIL_PRICE," +
            "QUANTITY," +
            "IMAGE " +
          //  "TAX," +
            "FROM product where ACTIVE_FLAG = 1";

    public String getModelDetails = "SELECT * FROM PRODUCT_MODEL WHERE ID = ? AND ID <> 'NULL' ";

   // ORDER BY DESCRIPTION

    public String getCustomerDetails = "SELECT * FROM customer ORDER BY FIRST_NAME";

    public String getCategoryDetails = "SELECT * FROM category ORDER BY CATEGORY_NAME";

    public String getBrandDetails = "SELECT * FROM brand ORDER BY BRAND_NAME";

    public String getCustomerDetailsForLogin = "SELECT PHONE_NO,EMAIL,PASSWORD,STREET,CITY,STATE,COUNTRY,ZIPCODE,FAX,COMPANY_NAME,FIRST_NAME,LAST_NAME FROM customer where EMAIL = ?";

    public String getUserDetails = "SELECT USERNAME,PASSWORD,USER_ROLE FROM user where USERNAME = ? ";


    //SQL QUERY TO DELETE FROM DATABASE


    public String deleteCustomer = "DELETE FROM customer WHERE CUSTOMER_ID = ?";







    public String getProductQuantity = "SELECT QUANTITY FROM PRODUCT WHERE PRODUCT_NO = ?";


    public String getCustomerBalance = "SELECT BALANCE FROM CUSTOMER WHERE PHONE_NO = ?";

    public String updateBalanceToCustomerProfile = "UPDATE CUSTOMER SET BALANCE = ?, BALANCE_LAST_UPDATE_DATE = ? WHERE PHONE_NO = ? ";


    //I need to for last 12 months but here i am not putting between date condition i need to fox it.
    public String getCustomersLast12MonthSpend = "SELECT sum(TOTAL_AMOUNT) TOTAL FROM transaction where CUSTOMER_PHONENO = ?";


    public String getProductId = "SELECT PRODUCT_ID FROM PRODUCT WHERE PRODUCT_NO = ?";


    public String deleteImeiDetailsFromPhone = "DELETE FROM PHONE WHERE ID = ? ";



    public String getModelDetailsForBrand = "SELECT distinct MODEL_ID FROM product WHERE BRAND_ID = ? AND MODEL_ID <> 'NULL' ";

    public String getProductDetailsByCategoryId = "SELECT " +
            " PRODUCT_NO," +
            "PRODUCT_ID," +
            " CATEGORY_ID," +
            " VENDOR_ID," +
            " BRAND_ID," +
            " MODEL_ID," +
            " DESCRIPTION," +
            " COST_PRICE," +
            " RETAIL_PRICE," +
            " IMAGE," +
            " QUANTITY " +
            " FROM product where ACTIVE_FLAG = 1 AND CATEGORY_ID = ?";

    public String getProductDetailsByModelId = "SELECT " +
            "PRODUCT_NO," +
            "CATEGORY_ID," +
            "VENDOR_ID," +
            "BRAND_ID," +
            "MODEL_ID, " +
            "DESCRIPTION," +
            "COST_PRICE," +
            "RETAIL_PRICE" +
            ",QUANTITY," +
            "IMAGE" +
            //"TAX" +
            "FROM product WHERE MODEL_ID = ? AND ACTIVE_FLAG = 1";
    public String updateProductImage = "UPDATE product SET IMAGE = ? WHERE PRODUCT_ID = ?";
    public String getBrandDetailsForParts = "SELECT distinct p.BRAND_ID, b.BRAND_NAME FROM product p JOIN brand b on p.BRAND_ID = b.BRAND_ID where p.CATEGORY_ID = 14";
    public String addSingleTransactionLineItem = "INSERT INTO web_transaction_line_item ("+
            "CUSTOMER_PHONENO," +
            "DATE," +
            "PRODUCT_NO," +
            "QUANTITY," +
            "RETAIL," +
            "COST," +
            "DISCOUNT," +
            "DISCOUNT_PERCENTAGE," +
            "RETAILWITHDISCOUNT," +
            "TOTALPRODUCTPRICE," +
            "TOTAL_PRODUCT_PRICE_WITH_TAX) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    public String getProductDescription = "SELECT DESCRIPTION FROM product WHERE PRODUCT_NO = ?";

    public String getTransactionLineItemDetails = "SELECT " +
            "PRODUCT_NO," +
            "QUANTITY," +
            "RETAIL," +
            "COST," +
            "DISCOUNT," +
            "DISCOUNT_PERCENTAGE," +
            "RETAILWITHDISCOUNT," +
            "TOTALPRODUCTPRICE," +
            "TOTAL_PRODUCT_PRICE_WITH_TAX " +
            "FROM web_transaction_line_item " +
            "WHERE CUSTOMER_PHONENO = ?";


    public String deleteProductFromCustomerOrder = "DELETE FROM web_transaction_line_item where CUSTOMER_PHONENO = ? AND PRODUCT_NO = ?";
    public String getLastTransactionId = "SELECT max(CAST(TRANSACTION_COMP_ID AS SIGNED)) FROM transaction";
    public String addTransaction =
            "INSERT INTO transaction(" +
                    "TRANSACTION_COMP_ID," +
                    "TRANSACTION_DATE," +
                    "TOTAL_AMOUNT," +
                    "TAX_AMOUNT," +
                    "DISCOUNT_AMOUNT," +
                    "SUBTOTAL," +
                    "TOTALQUANTITY," +
                    "CUSTOMER_PHONENO," +
                    "USER_ID," +
                    "STATUS," +
                    "PREVIOUS_BALANCE, " +
                    "BALANCE, " +
                    "RECEIPT_NOTE," +
                    "FIRST_NAME_LAST_NAME," +
                    "USERNAME) VALUES (?,?,?,?,?,?,?,?,'3',?,?,?,?,?,'asif')";

    public String getProductForSearch = "SELECT PRODUCT_NO,DESCRIPTION,CATEGORY_ID,BRAND_ID,MODEL_ID FROM product where ACTIVE_FLAG = 1 ";
    public String getProductsByDescription = "SELECT " +
            "PRODUCT_NO," +
            "CATEGORY_ID," +
            "VENDOR_ID," +
            "BRAND_ID," +
            "MODEL_ID," +
            "DESCRIPTION," +
            "COST_PRICE," +
            "RETAIL_PRICE," +
            "QUANTITY," +
            "IMAGE " +
            "FROM product " +
            "WHERE MODEL_ID = " +
            "(SELECT MODEL_ID FROM product " +
            " WHERE DESCRIPTION = ?)";
    public String deleteAllTransactionLineItem = "DELETE FROM web_transaction_line_item WHERE CUSTOMER_PHONENO = ?";
    public String getProductPriceDetailsByCustomer = "SELECT PRODUCT_NO, RETAIL_PRICE FROM customer_product_price WHERE CUSTOMER_PHONENO = ?";
}
