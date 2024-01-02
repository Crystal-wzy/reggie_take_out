package pers.wzy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.wzy.reggie.dto.DishDto;
import pers.wzy.reggie.entity.Dish;

import java.util.List;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 14:02
 */
public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish, dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品，同时更新菜品对应的口味数据，需要操作两张表：dish, dish_flavor
    public void updateWithFlaor(DishDto dishDto);

    //删除菜品，同时删除菜品对应的口味数据，需要操作两张表：dish, dish_flavor
    public void removeWithFlavor(List<Long> ids);

}
