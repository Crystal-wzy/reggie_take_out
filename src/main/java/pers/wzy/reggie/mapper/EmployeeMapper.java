package pers.wzy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.wzy.reggie.entity.Employee;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/26 11:45
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
