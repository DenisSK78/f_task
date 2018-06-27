package by.task.service.util;

import by.task.repository.entity.Customer;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConvertCustomerList {
    public static List<Customer> customerList (List<by.task.service.dto.CustomerDTO> customerDTOList){
        return customerDTOList.stream()
                .map(ConvertForCustomer::toCustomer)
                .collect(toList());
    }

    public static List<by.task.service.dto.CustomerDTO> customerDTOList (List<Customer> customerList){
        return customerList.stream()
                .map(ConvertForCustomer::toCustomerDTO)
                .collect(toList());
    }
}
