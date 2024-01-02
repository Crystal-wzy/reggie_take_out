package pers.wzy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.wzy.reggie.entity.Dish;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 14:00
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
