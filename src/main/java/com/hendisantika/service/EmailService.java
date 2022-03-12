package com.hendisantika.service;

import com.hendisantika.dto.EmailRequest;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    public Response sendEmail(EmailRequest emailrequest) {

        Mail mail = new Mail(new Email("hendisantika@yahoo.co.id"), emailrequest.getSubject(), new Email(emailrequest.getTo()), new Content("text/plain", emailrequest.getBody()));
        mail.setReplyTo(new Email("hendisantika@yahoo.co.id"));
        Request request = new Request();

        Response response = null;

        try {

            request.setMethod(Method.POST);

            request.setEndpoint("mail/send");

            request.setBody(mail.build());

            response = this.sendGrid.api(request);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

        return response;

    }


}
