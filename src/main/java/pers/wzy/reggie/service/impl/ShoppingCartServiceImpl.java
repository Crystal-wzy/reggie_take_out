package pers.wzy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.wzy.reggie.service.ShoppingCartService;
import pers.wzy.reggie.entity.ShoppingCart;
import pers.wzy.reggie.mapper.ShoppingCartMapper;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2024/1/2 10:47
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
