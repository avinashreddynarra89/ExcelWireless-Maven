package com.excelwireless.bl;


import com.excelwireless.dto.CustomerDto;
import com.excelwireless.dto.UserDto;
import com.excelwireless.dto.UserLogin;
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
 * Created by asp5045 on 1/8/17.
 */

@Component
public class UserManager {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SQLQueries sqlQuery;

    public UserLogin getUserLoginDetails(String username, String password) {

        List<UserDto> user = new ArrayList<UserDto>();

        CustomerDto customerDto = new CustomerDto();

        UserLogin userLogin = new UserLogin();
        boolean response = false;
        try
        {
            customerDto = jdbcTemplate.queryForObject(sqlQuery.getCustomerDetailsForLogin, new UserManager.CustomerLoginAndAddMapper(),username);

            if(null != customerDto && customerDto.getEmail().equalsIgnoreCase(username) && customerDto.getPassword().equals(password))
            {
                userLogin.setPhoneNo(customerDto.getPhoneNo());
                userLogin.setValidUser(true);
                userLogin.setStreet(customerDto.getStreet());
                userLogin.setCity(customerDto.getCity());
                userLogin.setState(customerDto.getState());
                userLogin.setZipcode(customerDto.getZipcode());
                userLogin.setCountry(customerDto.getCountry());
                userLogin.setFax(customerDto.getFax());
                userLogin.setCompanyName(customerDto.getCompanyName());
                userLogin.setFirstName(customerDto.getFirstName());
                userLogin.setLastName(customerDto.getLastName());
                userLogin.setUserRole("Customer");

                System.out.println("Send customer information successfully");
            }
            else
            {
                userLogin.setValidUser(false);
            }
        }
        catch (Exception e)
        {
            //Here i am checking when customer login credentials failed i am checking for the admin and if admin then showing admin view.
            //Because i am doing query for object and its throwing no result found exception
            UserDto userDto;
            userDto = jdbcTemplate.queryForObject(sqlQuery.getUserDetails, new UserManager.UserLoginMapper(),username);

            if(null != userDto && userDto.getUsername().equalsIgnoreCase(username) && userDto.getPassword().equals(password))
            {
                userLogin.setUserRole(userDto.getUserRole());
                userLogin.setValidUser(true);
            }
            System.out.println(e);
        }

        return userLogin;
    }

    private static final class CustomerLoginAndAddMapper implements RowMapper<CustomerDto>
    {

        @Override
        public CustomerDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            CustomerDto customerDto = new CustomerDto();

            customerDto.setPhoneNo(rs.getString("PHONE_NO"));
            customerDto.setEmail(rs.getString("EMAIL"));
            customerDto.setPassword(rs.getString("PASSWORD"));
            customerDto.setStreet(rs.getString("STREET"));
            customerDto.setCity(rs.getString("CITY"));
            customerDto.setState(rs.getString("STATE"));
            customerDto.setZipcode(rs.getString("ZIPCODE"));
            customerDto.setCountry(rs.getString("COUNTRY"));
            customerDto.setFax(rs.getString("FAX"));
            customerDto.setCompanyName(rs.getString("COMPANY_NAME"));
            customerDto.setFirstName(rs.getString("FIRST_NAME"));
            customerDto.setLastName(rs.getString("LAST_NAME"));

            return customerDto;
        }
    }

    private static final class UserLoginMapper implements RowMapper<UserDto>
    {

        @Override
        public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            UserDto userDto = new UserDto();

            userDto.setUserRole(rs.getString("USER_ROLE"));
            userDto.setUsername(rs.getString("USERNAME"));
            userDto.setPassword(rs.getString("PASSWORD"));

            return userDto;
        }

    }
}