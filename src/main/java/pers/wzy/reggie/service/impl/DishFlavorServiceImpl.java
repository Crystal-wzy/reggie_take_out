package pers.wzy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.wzy.reggie.service.DishFlavorService;
import pers.wzy.reggie.entity.DishFlavor;
import pers.wzy.reggie.mapper.DishFlavorMapper;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 17:19
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
