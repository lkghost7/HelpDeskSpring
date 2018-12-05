package by.lk.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.lk")
@Import({
        InternationalizationConfig.class,
        ThymeleafConfig.class,
        MvcConfig.class
})
public class WebConfig {

}