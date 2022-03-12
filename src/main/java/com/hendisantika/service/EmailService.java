package com.hendisantika.service;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/03/22
 * Time: 20.08
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EmailService {
    @Autowired
    private SendGrid sendGrid;

}
