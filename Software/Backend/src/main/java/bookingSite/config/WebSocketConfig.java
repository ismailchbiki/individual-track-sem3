package bookingSite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //to establish the connection the server side
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //the client-side connects to this point to connect with the backend
        //using sockjs
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }


    //after the backend processing is done,
    //pass the messages to a broker,
    //so that the broker can send the data back to the client,
    //and the client will be listening to the created broker (topic): chatroom & user to get the data back
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/chatroom", "/user");
        registry.setUserDestinationPrefix("/user");
    }
}
