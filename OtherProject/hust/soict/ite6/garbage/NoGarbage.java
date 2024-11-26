package hust.soict.ite6.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        // Đường dẫn của file test.txt trong package
        String filename = "hust/soict/ite6/garbage/test.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;
        try {
            String filePath = ClassLoader.getSystemResource(filename).getPath();
            inputBytes = Files.readAllBytes(Paths.get(filePath));
        } catch (NullPointerException e) {
            System.out.println("File not found: " + filename);
            return;
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for(byte b : inputBytes) {
        	outputStringBuilder.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }
}
