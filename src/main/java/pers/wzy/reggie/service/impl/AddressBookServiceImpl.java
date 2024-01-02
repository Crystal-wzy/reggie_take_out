package pers.wzy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.wzy.reggie.entity.AddressBook;
import pers.wzy.reggie.mapper.AddressBookMapper;
import pers.wzy.reggie.service.AddressBookService;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/31 16:43
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
