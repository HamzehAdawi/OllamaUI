package com.HamzehAdawi.OllamaApp.services;

import com.HamzehAdawi.OllamaApp.entities.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {

    private final Messages messages;

    @Autowired
    public MessagesServiceImpl(Messages messages) {
        this.messages = messages;
    }

    public void addUserMessage(String userInput) {
        messages.addMessage("Me: " + userInput + "\n");
    }

    public void addOllamaResponse(String response) {
        messages.addMessage("Ollama: "+ response + "\n");
    }

    public List<String> getConversation() {
        return messages.getAllMessages();
    }

}

