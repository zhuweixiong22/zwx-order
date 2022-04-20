package com.zwx.order.util;

import java.util.Random;

/**
 * @author novo
 * @date 2022/4/20-19:59
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间 + 随机数
     *
     * @return
     */
    // TODO synchronized关键字避免并发生成重复订单id
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
