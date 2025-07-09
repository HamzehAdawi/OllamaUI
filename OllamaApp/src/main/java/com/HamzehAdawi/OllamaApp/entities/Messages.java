package com.HamzehAdawi.OllamaApp.entities;

import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class Messages {

    private ArrayList<String> userMessages;

    public Messages() {
        this.userMessages = new ArrayList<>();
    }

    public ArrayList<String> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(ArrayList<String> userMessages) {
        this.userMessages = userMessages;
    }

    public void addMessage(String input) {
        userMessages.add(input);
    }

    public ArrayList<String> getAllMessages() {
        return userMessages;
    }
}
