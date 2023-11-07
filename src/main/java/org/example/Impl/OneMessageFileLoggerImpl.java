package org.example.Impl;

import org.example.exception.MessageIsNotFormattedException;
import org.example.interfaces.OneMessageFileLogger;

public class OneMessageFileLoggerImpl implements OneMessageFileLogger {
    String absolutePath;
    SaverImpl saver;

    public OneMessageFileLoggerImpl(String absolutePath, SaverImpl saver) {
        this.absolutePath = absolutePath;
        this.saver = saver;
    }

    @Override
    public void log(String message) throws MessageIsNotFormattedException {
        if (message.startsWith(MESSAGE_START_WITH)) {
            saver.save(message, absolutePath);
        } else {
            throw new MessageIsNotFormattedException("The message don't beginning with \"MESSAGE:\"");
        }
    }
}
