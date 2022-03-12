package com.hendisantika.controller;

import com.hendisantika.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/03/22
 * Time: 20.11
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;
}
