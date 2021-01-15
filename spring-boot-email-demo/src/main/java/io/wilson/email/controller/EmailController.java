package io.wilson.email.controller;

import io.springframework.common.response.ServerResponse;
import io.swagger.annotations.Api;
import io.wilson.email.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author Wilson
 */
@RestController
@RequestMapping("/email")
@AllArgsConstructor
@Api
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/attachment")
    public ServerResponse<?> sendAttachment(@RequestParam String subject,
                                            @RequestParam String recipient,
                                            @RequestParam String filePath,
                                            @RequestParam String content) throws IOException, MessagingException {
        emailService.sendAttachmentMail(subject, content, filePath, recipient);
        return ServerResponse.success();
    }
}
