package org.example.Impl;

import org.example.interfaces.Saver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaverImpl implements Saver {
    @Override
    public void save(String text, String fileAbsolutePath) {
        File file = new File(fileAbsolutePath);
        if (file.exists()) {
            try {
                throw new IOException("This file already exists");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file", e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileAbsolutePath))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write this text", e);
        }
    }
}
