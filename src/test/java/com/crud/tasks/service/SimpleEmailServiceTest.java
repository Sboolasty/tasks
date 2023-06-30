package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com", "Test", "Test Message", Optional.of("test2@test.com"));

        //When
        simpleEmailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(new SimpleMailMessage() {{
            setTo(mail.getMailTo());
            setSubject(mail.getSubject());
            setText(mail.getMessage());
            mail.getCc().ifPresent(cc -> setCc(cc));
        }});
    }
}
