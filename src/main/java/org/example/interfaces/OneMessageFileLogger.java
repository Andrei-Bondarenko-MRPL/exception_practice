package org.example.interfaces;

public interface OneMessageFileLogger {
    String MESSAGE_START_WITH = "MESSAGE:";
    void log(String message) throws Exception;
}
