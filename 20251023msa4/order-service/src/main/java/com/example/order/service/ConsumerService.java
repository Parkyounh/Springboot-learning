package com.example.order.service;

import com.example.order.config.RabbitConfig;
import com.example.order.model.MessageEntity;
import com.example.order.repository.MessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final MessageRepository messageRepository;

    public ConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("📩 메시지 수신: " + message);
        MessageEntity entity = new MessageEntity();
        entity.setContent(message);
        messageRepository.save(entity);
        System.out.println("💾 DB 저장 완료");
    }
}

