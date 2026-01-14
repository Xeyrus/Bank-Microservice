package com.bankmicroservice.accounts.service.impl;

import com.bankmicroservice.accounts.dto.AccountsDto;
import com.bankmicroservice.accounts.dto.CardsDto;
import com.bankmicroservice.accounts.dto.CustomerDetailsDto;
import com.bankmicroservice.accounts.dto.LoansDto;
import com.bankmicroservice.accounts.entity.Accounts;
import com.bankmicroservice.accounts.entity.Customer;
import com.bankmicroservice.accounts.exception.ResourceNotFoundException;
import com.bankmicroservice.accounts.mapper.AccountsMapper;
import com.bankmicroservice.accounts.mapper.CustomerMapper;
import com.bankmicroservice.accounts.repository.AccountsRepository;
import com.bankmicroservice.accounts.repository.CustomerRepository;
import com.bankmicroservice.accounts.service.client.CardsFeignClient;
import com.bankmicroservice.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService{

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotFoundException("Customer","mobileNumber", mobileNumber));

        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()-> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
