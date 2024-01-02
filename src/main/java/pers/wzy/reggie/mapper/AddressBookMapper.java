package pers.wzy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.wzy.reggie.entity.AddressBook;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/31 16:40
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
