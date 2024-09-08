package tech.nomad4.producer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.nomad4.model.PostMsgDto;
import tech.nomad4.producer.service.decl.MessagePostService;
import tech.nomad4.producer.service.decl.MessageTestService;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestControllerService {

    private final MessageTestService messageTestService;

    private final MessagePostService messagePostService;

    public void sendTest(String msg) {
        messageTestService.sendTest(msg);
        log.info("sendTest: {}", msg);
    }

    public void sendPost(PostMsgDto msg) {
        messagePostService.sendPost(msg);
        log.info("sendPost {}", msg);
    }

}