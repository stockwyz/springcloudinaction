package com.didispace.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SocketUtils;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class TraceClientLauncher {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                int port = SocketUtils.findAvailableTcpPort(8001, 8999);
                container.setPort(port);
                System.getProperties().put("server.port", port);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceClientLauncher.class, args);
    }
}
