package study.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    public enum MessageType{
        ENTER, TALK
    }
    private String roomId;
    private String type;
    private String id;
    private String sender;
    private String message;

    }
