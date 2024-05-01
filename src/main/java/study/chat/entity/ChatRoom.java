package study.chat.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

//dto
@Getter
@Setter
public class ChatRoom {

    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
       ChatRoom chatRoom = new ChatRoom();
       chatRoom.roomId = UUID.randomUUID().toString();
       chatRoom.name = name;
       return chatRoom;
   }
}
