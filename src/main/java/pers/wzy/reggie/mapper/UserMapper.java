package pers.wzy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.wzy.reggie.entity.User;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/31 15:32
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
