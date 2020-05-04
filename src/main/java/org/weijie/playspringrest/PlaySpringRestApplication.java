package org.weijie.playspringrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = "org.weijie")
public class PlaySpringRestApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(PlaySpringRestApplication.class, args);
    }

}
