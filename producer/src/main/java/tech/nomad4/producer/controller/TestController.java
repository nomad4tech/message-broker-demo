package tech.nomad4.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.nomad4.model.PostMsgDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("test")
public class TestController {
    private final TestControllerService testControllerService;

    @GetMapping
    public ResponseEntity<String> message(@RequestParam String msg) {
        testControllerService.sendTest(msg);
        return ResponseEntity.ok(msg);
    }

    @PostMapping
    public ResponseEntity<PostMsgDto> postMessage(@RequestBody PostMsgDto msgDto) {
        testControllerService.sendPost(msgDto);
        return ResponseEntity.ok(msgDto);
    }

}