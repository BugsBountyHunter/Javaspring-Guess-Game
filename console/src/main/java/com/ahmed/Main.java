package com.ahmed;

import com.ahmed.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Now We Create A configurableApplicationContext Container");
        ConfigurableApplicationContext configurableApplicationContext = new AnnotationConfigApplicationContext(GameConfig.class);
        configurableApplicationContext.close();
    }
}
