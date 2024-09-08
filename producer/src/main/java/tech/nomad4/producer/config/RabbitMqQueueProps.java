package tech.nomad4.producer.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Getter
@Setter
@ConfigurationProperties("app.rabbitmq.queue")
public class RabbitMqQueueProps {

    private String test;
    private String post;

    @PostConstruct
    public void validate() {
        Set<String> queueNames = new HashSet<>();
        queueNames.add(test);
        queueNames.add(post);

        if (queueNames.size() < 2) {
            throw new IllegalStateException("Queue names must be unique.");
        }
    }
}