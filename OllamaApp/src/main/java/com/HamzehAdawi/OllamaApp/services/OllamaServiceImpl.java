package com.HamzehAdawi.OllamaApp.services;

import com.HamzehAdawi.OllamaApp.entities.Messages;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;

@Service
public class OllamaServiceImpl implements OllamaService {

    private final ChatClient chatClient;

    @Autowired
    public OllamaServiceImpl(ChatClient.Builder builder) {
        ChatMemory memory = MessageWindowChatMemory.builder()
                .maxMessages(10)
                .build();

        MessageChatMemoryAdvisor advisor = MessageChatMemoryAdvisor.builder(memory).build();

        this.chatClient = builder
                .defaultAdvisors(advisor)
                .build();
    }

    public String chat(String userInput) {
        return chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
}
