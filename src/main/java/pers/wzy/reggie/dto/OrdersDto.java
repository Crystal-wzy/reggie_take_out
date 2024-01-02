package pers.wzy.reggie.dto;

import pers.wzy.reggie.entity.OrderDetail;
import pers.wzy.reggie.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
