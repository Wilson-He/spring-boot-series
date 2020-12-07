package io.github.wilson.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import io.github.wilson.api.CustomerServiceI;
import io.github.wilson.customer.executor.CustomerAddCmdExe;
import io.github.wilson.customer.executor.query.CustomerListByNameQryExe;
import io.github.wilson.dto.CustomerAddCmd;
import io.github.wilson.dto.CustomerListByNameQry;
import io.github.wilson.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    @Override
    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}