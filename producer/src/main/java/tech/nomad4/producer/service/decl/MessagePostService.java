package tech.nomad4.producer.service.decl;

import tech.nomad4.model.PostMsgDto;

public interface MessagePostService {

    void sendPost(PostMsgDto msg);
    
}