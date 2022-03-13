package com.zwx.order;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(OrderApplicationTests.class);

    @Test
    public void contextLoads() {
        // 系统默认日志级别是info以上 所以debug不会输出
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
    }

}
