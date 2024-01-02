package pers.wzy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.wzy.reggie.entity.Category;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 13:10
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
