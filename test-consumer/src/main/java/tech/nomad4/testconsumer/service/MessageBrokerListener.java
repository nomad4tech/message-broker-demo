package tech.nomad4.testconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageBrokerListener {
    @RabbitListener(queues = "${app.rabbitmq.queue.test}")
    public void listen(String msg) {
        log.info("message received: {}", msg);
    }
}
