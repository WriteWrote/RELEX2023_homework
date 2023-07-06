package org.obukhova.ssr.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {
        "org.obukhova.ssr.controller",
        "org.obukhova.ssr.service",
        "org.obukhova.ssr.model.*"
})
@EnableAspectJAutoProxy
public class Configuration {
}
