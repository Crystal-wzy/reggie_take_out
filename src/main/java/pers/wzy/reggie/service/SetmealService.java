package pers.wzy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.wzy.reggie.dto.SetmealDto;
import pers.wzy.reggie.entity.Setmeal;

import java.util.List;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 14:02
 */
public interface SetmealService extends IService<Setmeal> {

    //新增套餐，同时保存套餐和菜品的关联关系
    public void saveWithDish(SetmealDto setmealDto);

    //删除套餐，同时删除套餐和菜品的关联关系
    public void removeWithDish(List<Long> ids);

}
