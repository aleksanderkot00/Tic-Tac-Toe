package com.github.aleksanderkot00.tictactoe.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Helper {

        public static String loadStringFromFile(File file) {
            StringBuilder sb = new StringBuilder();
            try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
                stream.forEach(sb::append);
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return sb.toString();
        }

        public static void saveStringToFile(String string, File file) {
            try {
                Files.write(Paths.get(file.toURI()), string.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
