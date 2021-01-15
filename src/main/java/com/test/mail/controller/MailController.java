package com.test.mail.controller;

import com.test.mail.domain.entities.MailRequest;
import com.test.mail.domain.entities.MailResponse;
import com.test.mail.service.MailServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/mail")
public class MailController {
    @Autowired
    MailServiceV1 mailServiceV1;

    @PostMapping(path="/", consumes="application/json", produces="application/json")
    @ResponseBody
    public MailResponse sendMail(@RequestBody MailRequest mailRequest){
        MailResponse response = new MailResponse();
        mailServiceV1.sendMail(mailRequest.getFrom(), mailRequest.getTo(), mailRequest.getSubject(), mailRequest.getBody());
        response.setMessage("Good Job");
        return response;
    }
}
