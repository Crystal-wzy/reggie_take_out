package pers.wzy.reggie.common;

/**
 * @Description
 * @Author: Zhiyong Wang
 * @Date: 2023/12/27 14:21
 */

/**
 * 自定义业务类异常
 */
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

}
