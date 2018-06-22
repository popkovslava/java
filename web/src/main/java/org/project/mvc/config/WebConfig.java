package org.project.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.project.mvc.controller","org.project.service"})
@Import(value = {org.project.mvc.config.InternationalizationConfig.class, org.project.mvc.config.ThymeleafConfig.class})
public class WebConfig {
}
