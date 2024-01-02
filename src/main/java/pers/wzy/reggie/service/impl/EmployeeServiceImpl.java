package pers.wzy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.wzy.reggie.entity.Employee;
import pers.wzy.reggie.mapper.EmployeeMapper;
import pers.wzy.reggie.service.EmployeeService;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/26 11:49
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
