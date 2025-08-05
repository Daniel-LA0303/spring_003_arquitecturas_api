package com.la.chat.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	/**
	 * proposito del metodo: crea el endpoint WebSocket para que los clientes como STOMP.JS se conecten
	 * prodiamos decir que aqui los clientes usarian el comando CONNECT para hacer su conecion
	 */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-websocket")
        .setAllowedOriginPatterns("*") // ciente permitido
                .withSockJS(); // permite compatibilidad con navegadores antiguos

    }

    /**
     * Proposito del metodo:
     * Permite el prfijo "chat" para destinos donde el broker envia mensajes a clientes suscritos
     * Prefijo app para los mnsaje que deben ser procesados por tu controlados
     * 
     * En pocas palabras tendremos multiples topic / canal con el prefijo chat
     * En esta parte se configuran los comandos CUBSCRIBE, SEND y UNSUSCRIBE/DISCONNECT
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	//podmeos tener mas de un prefijo:  registry.enableSimpleBroker("/chat/", "/queue/");
        registry.enableSimpleBroker("/chat/"); // el prefino permite crear multiples canales dianmicos
        registry.setApplicationDestinationPrefixes("/app"); 
    }
    
    
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.setSendTimeLimit(15 * 1000)
                   .setSendBufferSizeLimit(512 * 1024);
    }

}
