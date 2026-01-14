package com.bankmicroservice.accounts.service.impl;

import com.bankmicroservice.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
