package data.lab.ongdb.visual.server;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Test;

/*
 *
 * Data Lab - graph database organization.
 *
 */

/**
 * @author Yc-Ma
 * @PACKAGE_NAME: data.lab.ongdb.visual.server
 * @Description: TODO
 * @date 2020/4/28 17:35
 */
public class HttpServiceTest {
    // 定义日志记录器对象
    // org.apache.logging.log4j.LogManager
    // org.apache.logging.log4j.Logger
    public static final Logger LOGGER = LogManager.getLogger(HttpServiceTest.class);

    @Test
    public void testQuick() throws Exception {
        // 日志消息输出
        Configurator.setAllLevels("",Level.INFO);
        LOGGER.isDebugEnabled();
        LOGGER.fatal("fatal");
        LOGGER.error("error"); //默认
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }

}
