package com.xulong.amazingsite.common;

/**
 * BizException
 *
 * @author xulong
 * @date 2018/7/12
 */
public class BizException extends Exception {

    public static final Integer HttpStatus = 416;

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Integer httpStatus) {
        super(message);
    }

}
