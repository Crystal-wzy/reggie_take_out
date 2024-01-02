package pers.wzy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.wzy.reggie.entity.Category;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 13:11
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
