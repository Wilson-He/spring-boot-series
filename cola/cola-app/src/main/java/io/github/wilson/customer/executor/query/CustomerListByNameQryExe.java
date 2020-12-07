package io.github.wilson.customer.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import io.github.wilson.dto.CustomerListByNameQry;
import io.github.wilson.dto.data.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomerListByNameQryExe {
    public MultiResponse<CustomerDTO> execute(CustomerListByNameQry cmd) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("Frank");
        customerDTOList.add(customerDTO);
        return MultiResponse.ofWithoutTotal(customerDTOList);
    }
}
