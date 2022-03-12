package com.hendisantika.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/03/22
 * Time: 20.07
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SendgridConfig {

    @Value("${sendgrid.key}")
    private String key;


    @Bean
    public SendGrid getSendgrid() {
        return new SendGrid(key);
    }
}
