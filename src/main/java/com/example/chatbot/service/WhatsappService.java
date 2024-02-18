package com.example.chatbot.service;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

@Service
    public class WhatsappService {
        // Find your Account Sid and Token at twilio.com/console
        public static final String ACCOUNT_SID = "AC77b8195bd63e9e41aed8bca71dcc6256";
        public static final String AUTH_TOKEN = "6995a8b97cb84316bc96e4f5f105725d";

        public  void sendMessage() {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:+918805006748"),
                    new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                    "Hello" +
                            "\nHow may i help you?")

                            .create();

            System.out.println(message.getSid());
        }

        public void sendMessage(String message, String recipient) {
            // Implement the logic to send a WhatsApp message
            System.out.println("Sending message to " + recipient + ": " + message);
            // Implement the actual WhatsApp sending logic here
        }
    }

