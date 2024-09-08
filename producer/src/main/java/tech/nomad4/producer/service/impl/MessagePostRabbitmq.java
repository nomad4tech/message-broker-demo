package tech.nomad4.producer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.nomad4.model.PostMsgDto;
import tech.nomad4.producer.config.RabbitMqQueueProps;
import tech.nomad4.producer.service.decl.MessagePostService;

@Service
@RequiredArgsConstructor
class MessagePostRabbitmq implements MessagePostService {

    private final RabbitMqQueueProps queueProps;

    @Qualifier("postQueue")
    private final AmqpTemplate postQueue;

    @Override
    public void sendPost(PostMsgDto msg) {
        postQueue.convertAndSend(queueProps.getPost(), msg);
    }
}
