package co.newlabs.repository;


import co.newlabs.repository.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {


    private NamedParameterJdbcTemplate template;

    @Autowired
    public CustomerRepository(NamedParameterJdbcTemplate t) {
        this.template = t;
    }

    public CustomerEntity getCustomerByOrderId(int orderid) {
        String query = "select * from customers where id = (select customerid from orders where id = :var)";
        Map<String, Object> param = new HashMap<>();
        param.put("var", orderid);
        RowMapper<CustomerEntity> rowMapper = new BeanPropertyRowMapper<>(CustomerEntity.class);
        return template.queryForObject(query, param, rowMapper);
    }

    public void updateOrderStatus(int orderid) {
        String query = "update orders set complete = '"+1+"' where id = :var";
        Map<String, Object> param = new HashMap<>();
        param.put("var", orderid);

        template.update(query, param);

    }
}
