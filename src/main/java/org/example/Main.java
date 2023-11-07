package org.example;

import org.example.Impl.OneMessageFileLoggerImpl;
import org.example.Impl.SaverImpl;
import org.example.exception.MessageIsNotFormattedException;

import java.io.File;

public class Main {
    public static void main(String[] args) throws MessageIsNotFormattedException {
        String absolutPath = "file.txt";
        String message = "MESSAGE: hi)";
        OneMessageFileLoggerImpl logger = new OneMessageFileLoggerImpl(absolutPath, new SaverImpl());
        logger.log(message);
        File file = new File(absolutPath);
        System.out.println(file.exists());
    }
}