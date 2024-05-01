package study.chat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import study.chat.entity.ChatMessage;

@RequiredArgsConstructor
@Controller
@Slf4j
public class ChatController {
//pub
    private final SimpMessageSendingOperations messagingTemplate;
    private final ObjectMapper objectMapper;

    //이게 됐떤건데
    @MessageMapping("/chat/message")
    public void message(String message) throws JsonProcessingException {
        var dto = objectMapper.readValue(message, ChatMessage.class);

        if (!dto.getType().equals("TALK")) {
            dto.setMessage(dto.getSender() + "님이 입장하셨습니다. 👋🏼");
        }

        messagingTemplate.convertAndSend("/sub/chat/room/" + dto.getRoomId(), message);
    }

    //
//    @MessageMapping("/chat/message")
//    public void message(ChatMessage message) {
//        if (message.getType().equals(ChatMessage.MessageType.ENTER)) {
//            message.setMessage(message.getSender() + "님이 입장하셨습니다. 👋🏼");
//        }
//        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//    }
}
