package pers.wzy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.wzy.reggie.service.SetmealDishService;
import pers.wzy.reggie.entity.SetmealDish;
import pers.wzy.reggie.mapper.SetmealDishMapper;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/28 16:26
 */
@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
