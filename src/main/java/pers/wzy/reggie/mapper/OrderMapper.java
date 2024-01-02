package pers.wzy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.wzy.reggie.entity.Orders;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2024/1/2 13:48
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
