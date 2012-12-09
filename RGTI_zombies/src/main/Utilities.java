package main;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.*;

public class Utilities {

    public static Texture loadTextures(String path) {
        Texture text = null;
        try {
            text = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void updateScore(String name, int zombiesKilled, int zombiesEscaped) {
        String line = String.format("%s %d %d\n", name, zombiesKilled, zombiesEscaped);
        String filePath = "/Users/Aljaz/Desktop/scores.txt";
        try {
            String fileContent = readFile(filePath);
            System.out.println(fileContent);
            fileContent += line;
            System.out.println(fileContent);
            writeFile(filePath, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String readFile(String filename) throws IOException {
        File file = new File(filename);

        if(!file.exists()) {
            file.createNewFile();
            System.out.print("new file");
        }

        int len = (int) file.length();
        byte[] bytes = new byte[len];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            assert len == fis.read(bytes);
        } catch (IOException e) {
            close(fis);
            throw e;
        }
        return new String(bytes, "UTF-8");
    }

    private static void writeFile(String filename, String text) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(text.getBytes("UTF-8"));
        } catch (IOException e) {
            close(fos);
            throw e;
        }
    }

    private static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch(IOException ignored) {
        }
    }


}
