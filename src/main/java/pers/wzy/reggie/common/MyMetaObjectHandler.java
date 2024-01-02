package pers.wzy.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 11:11
 */

/**
 * 自定义元数据对象处理器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        Long empId = BaseContext.getCurrentId();
        metaObject.setValue("createUser", empId);
        metaObject.setValue("updateUser", empId);
    }

    /**
     * 更新操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");
        //Long id = Thread.currentThread().getId();
        //log.info("线程id为: {}", id);
        metaObject.setValue("updateTime", LocalDateTime.now());
        Long empId = BaseContext.getCurrentId();
        metaObject.setValue("updateUser", empId);
    }
}
