package com.HamzehAdawi.OllamaApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${spring.ai.ollama.chat.model}")
    private String ollamaModel;

    public String getOllamaModel() {
        return ollamaModel;
    }
}