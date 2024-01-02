package pers.wzy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.wzy.reggie.entity.Orders;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2024/1/2 14:00
 */
public interface OrderService extends IService<Orders> {

    //用户下单
    public void submit(Orders orders);

}
