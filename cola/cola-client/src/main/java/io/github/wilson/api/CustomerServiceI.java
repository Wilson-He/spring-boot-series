package io.github.wilson.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import io.github.wilson.dto.CustomerAddCmd;
import io.github.wilson.dto.CustomerListByNameQry;
import io.github.wilson.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
