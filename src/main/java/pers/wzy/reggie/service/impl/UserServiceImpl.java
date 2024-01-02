package pers.wzy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.wzy.reggie.service.UserService;
import pers.wzy.reggie.entity.User;
import pers.wzy.reggie.mapper.UserMapper;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/31 15:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
