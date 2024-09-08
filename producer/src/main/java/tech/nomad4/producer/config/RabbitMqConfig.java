package tech.nomad4.producer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

    private final RabbitMqConnectProps connectProps;
    private final RabbitMqQueueProps queueProps;

    private CachingConnectionFactory getConnectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(connectProps.getHost());
        factory.setPort(connectProps.getPort());
        factory.setUsername(connectProps.getUsername());
        factory.setPassword(connectProps.getPassword());

        return factory;
    }

    @Bean
    public RabbitAdmin getRabbitAdmin() {
        return new RabbitAdmin(getConnectionFactory());
    }

    @Bean(name = "testQueue")
    public Queue getTestQueue(RabbitAdmin rabbitAdmin) {
        Queue queue = new Queue(queueProps.getTest(), false);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean(name = "postQueue")
    public Queue getPostQueue(RabbitAdmin rabbitAdmin) {
        Queue queue = new Queue(queueProps.getPost(), false);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(getConnectionFactory());
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }
}