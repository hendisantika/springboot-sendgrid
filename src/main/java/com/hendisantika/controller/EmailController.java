package com.hendisantika.controller;

import com.hendisantika.dto.EmailRequest;
import com.hendisantika.service.EmailService;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailrequest) {

        Response response = emailService.sendEmail(emailrequest);
        if (response.getStatusCode() == 200 || response.getStatusCode() == 202)
            return new ResponseEntity<>("send successfully", HttpStatus.OK);
        return new ResponseEntity<>("failed to sent", HttpStatus.NOT_FOUND);

    }
}
