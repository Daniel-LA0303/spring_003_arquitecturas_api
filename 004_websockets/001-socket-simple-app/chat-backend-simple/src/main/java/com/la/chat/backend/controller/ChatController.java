package com.la.chat.backend.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.la.chat.backend.models.Message;
import com.la.chat.backend.services.MessageService;

/**
 * Controlador principal para el manejo del chat mediante WebSockets
 * 
 * Responsabilidades:
 * - Recibir mensajes de los clientes
 * - Gestionar notificaciones de "usuario escribiendo"
 * - Proporcionar historial de mensajes
 */
@Controller
public class ChatController {

    /**
     * Array de colores disponibles para asignar a nuevos usuarios
     */
    private String[] colors = {"red", "blue", "green", "magenta", "orange", "purple", "yellow"};

    /**
     * Servicio para operaciones con mensajes (persistencia)
     */
    private final MessageService service;

    /**
     * Template de Spring para enviar mensajes WebSocket
     */
    @Autowired
    private SimpMessagingTemplate webSocket;

    /**
     * Constructor con inyección de dependencias
     * @param service Implementación del servicio de mensajes
     */
    public ChatController(@Qualifier("messageServiceMongo") MessageService service) {
        this.service = service;
    }

    /**
     * Maneja los mensajes entrantes del chat
     * 
     * @param message Objeto Message recibido del cliente
     * @return El mismo mensaje procesado (para broadcast)
     * 
     * Flujo:
     * 1. Cliente envía a /app/message
     * 2. Este método procesa el mensaje
     * 3. Se reenvía a todos los suscritos en /chat/message
     */
    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message) {
        // Establece la fecha actual en el mensaje
        message.setDate(new Date().getTime());
        
        // Lógica para nuevos usuarios
        if(message.getType().equals("NEW_USER")) {
            // Asigna un color aleatorio al nuevo usuario, el msg de la notificacion no se guarda
            message.setColor(this.colors[new Random().nextInt(colors.length)]);
            message.setText("nuevo usuario");
        } else {
            // Guarda mensajes normales en la base de datos
            service.save(message);
        }
        
        return message; // Se envía a todos los clientes suscritos a /chat/message
    }

    /**
     * Maneja las notificaciones de "usuario escribiendo"
     * 
     * @param username Nombre del usuario que está escribiendo
     * @return String con el mensaje de notificación
     * 
     * Flujo:
     * 1. Cliente envía a /app/writing
     * 2. Este método procesa la notificación
     * 3. Se reenvía a todos en /chat/writing
     */
    @MessageMapping("/writing")
    @SendTo("/chat/writing")
    public String isWriting(String username) {
        return username.concat(" está escribiendo ...");
    }

    /**
     * Proporciona el historial de mensajes a un cliente específico
     * 
     * @param clientId ID único del cliente que solicita el historial
     * 
     * Flujo:
     * 1. Cliente envía su clientId a /app/history
     * 2. Este método busca todos los mensajes
     * 3. Se envía solo a ese cliente en /chat/history/{clientId}
     */
    @MessageMapping("/history")
    public void getHistoryMessages(String clientId) {
        // Envía el historial solo al cliente que lo solicitó
        webSocket.convertAndSend("/chat/history/".concat(clientId), service.findAll());
    }
}