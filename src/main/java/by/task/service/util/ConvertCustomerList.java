package by.task.service.util;

import by.task.repository.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class ConvertCustomerList {
    public static List<Customer> customerList (List<by.task.service.dto.CustomerDTO> customerDTODTOList){
        List<Customer> customerList = new ArrayList<>();
        for (by.task.service.dto.CustomerDTO c: customerDTODTOList){
            customerList.add(ConvertForCustomer.toCustomer(c));
        }
        return customerList;
    }

    public static List<by.task.service.dto.CustomerDTO> customerDTOList (List<Customer> customerList){
        List<by.task.service.dto.CustomerDTO> customerDTODTOList = new ArrayList<>();
        for(Customer c: customerList){
            customerDTODTOList.add(ConvertForCustomer.toCustomerDTO(c));
        }
        return customerDTODTOList;
    }
}
