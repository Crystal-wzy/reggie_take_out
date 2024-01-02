package pers.wzy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.wzy.reggie.entity.OrderDetail;
import pers.wzy.reggie.mapper.OrderDetailMapper;
import pers.wzy.reggie.service.OrderDetailService;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2024/1/2 14:08
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
