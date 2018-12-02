package by.lk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "by.lk")
@Import(value = {RootConfig.class})
@EnableTransactionManagement
public class ServiceConfig {
}