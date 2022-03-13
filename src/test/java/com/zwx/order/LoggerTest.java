package com.zwx.order;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author novo
 * @date 2022/3/13-20:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(OrderApplicationTests.class);

    @Test
    public void test() {
        // 系统默认日志级别是info以上 所以debug不会输出
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
    }

}
