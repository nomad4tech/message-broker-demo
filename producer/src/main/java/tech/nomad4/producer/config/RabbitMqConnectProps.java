package tech.nomad4.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("app.rabbitmq.connect")
class RabbitMqConnectProps {

    private String host;

    private Integer port;

    private String username;

    private String password;

}