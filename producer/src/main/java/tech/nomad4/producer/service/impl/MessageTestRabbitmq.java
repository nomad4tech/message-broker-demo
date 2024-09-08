package tech.nomad4.producer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.nomad4.producer.config.RabbitMqQueueProps;
import tech.nomad4.producer.service.decl.MessageTestService;

@Service
@RequiredArgsConstructor
class MessageTestRabbitmq implements MessageTestService {

    private final RabbitMqQueueProps queueProps;

    @Qualifier("testQueue")
    private final AmqpTemplate testQueue;

    @Override
    public void sendTest(String msg) {
        testQueue.convertAndSend(queueProps.getTest(), msg);
    }
}