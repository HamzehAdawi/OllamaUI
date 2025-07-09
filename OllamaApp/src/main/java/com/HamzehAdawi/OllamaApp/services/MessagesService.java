package com.HamzehAdawi.OllamaApp.services;

import java.util.List;

public interface MessagesService {
    void addUserMessage(String input);
    void addOllamaResponse(String response);
    List<String> getConversation();

}
