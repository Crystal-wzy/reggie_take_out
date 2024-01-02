package pers.wzy.reggie.controller;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 17:21
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.wzy.reggie.common.R;
import pers.wzy.reggie.dto.DishDto;
import pers.wzy.reggie.entity.Category;
import pers.wzy.reggie.entity.Dish;
import pers.wzy.reggie.entity.DishFlavor;
import pers.wzy.reggie.service.CategoryService;
import pers.wzy.reggie.service.DishFlavorService;
import pers.wzy.reggie.service.DishService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜品管理
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增菜品
     * @param dishDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        dishService.saveWithFlavor(dishDto);
        return R.success("新增菜品成功");
    }

    /**
     * 菜品分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        //分页构造器
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishDto> dishDtoPage = new Page<>();
        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件，如果name不为空则添加，否则不添加
        queryWrapper.like(StringUtils.isNotEmpty(name), Dish::getName, name);
        //添加排序条件，根据价格进行排序
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        //进行分页查询
        dishService.page(pageInfo, queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");
        //记录拷贝
        List<Dish> records = pageInfo.getRecords();
        List<DishDto> list = records.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId(); //分类id
            //根据id查询分类对象
            Category category = categoryService.getById(categoryId);
            if(category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(list);

        return R.success(dishDtoPage);
    }

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<DishDto> getById(@PathVariable Long id) {
        log.info("根据id查询菜品信息...");
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        if(dishDto != null) {
            return R.success(dishDto);
        }
        return R.error("没有查询到对应的菜品信息");
    }

    /**
     * 根据id修改菜品信息
     * @param dishDto
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto) {
        log.info("修改菜品信息: {}", dishDto);
        dishService.updateWithFlaor(dishDto);
        return R.success("菜品信息修改成功");
    }

    /**
     * 停售/启售菜品--含批量
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    public R<String> updateStatus(@PathVariable int status, String ids) {
        log.info("停售/启售菜品: {}, {}", status, ids);
        if(ids.contains(",")) {
            //批量操作
            String[] id_arr = ids.split(",");
            for(String id : id_arr) {
                Dish dish = dishService.getById(id);
                dish.setStatus(status);
                dishService.updateById(dish);
            }
        }
        else {
            Dish dish = dishService.getById(ids);
            dish.setStatus(status);
            dishService.updateById(dish);
        }
        return R.success("菜品状态更新成功");
    }

    /**
     * 根据id删除菜品--含批量
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> ids) {
        log.info("删除菜品，id为: {}", ids);
        dishService.removeWithFlavor(ids);
        return R.success("菜品删除成功");
    }

    /**
     * 根据类别和启售状态查询对应的菜品数据
     * @param dish
     * @return
     */
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish) {
        //构造查询条件
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus, 1);
        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list(queryWrapper);
        List<DishDto> dishDtoList = list.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(DishFlavor::getDishId, dishId);
            List<DishFlavor> dishFlavorList = dishFlavorService.list(lambdaQueryWrapper);
            if(dishFlavorList != null) {
                dishDto.setFlavors(dishFlavorList);
            }
            return dishDto;
        }).collect(Collectors.toList());
        return R.success(dishDtoList);
    }

}
