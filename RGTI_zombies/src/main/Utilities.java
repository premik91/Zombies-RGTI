package main;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
    private static final String xmlScores = "RGTI_zombies/xml/scores.xml";

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
        saveToXML(name, zombiesKilled, zombiesEscaped);
        readXML();
    }

    public static boolean readXML() {
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = dBuilder.parse(new File(xmlScores));
            document.getDocumentElement().normalize();

            System.out.println(document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("player");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    String node = ((Element) nNode).
                            getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                    System.out.println("Name : " + node);
                    node = ((Element) nNode).
                            getElementsByTagName("killed").item(0).getChildNodes().item(0).getNodeValue();
                    System.out.println("Killed : " + node);
                    node = ((Element) nNode).
                            getElementsByTagName("escaped").item(0).getChildNodes().item(0).getNodeValue();
                    System.out.println("Escaped : " + node);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void saveToXML(String name, int killed, int escaped) {
        try {
            List<String> lines = new ArrayList<String>();
            String newPlayer =
                    "\n<player>\n"+
                            "\t<name>" + name + "</name>\n"+
                            "\t<killed>" + killed + "</killed>\n"+
                            "\t<escaped>" + escaped + "</escaped>\n"+
                            "</player>\n" +
                            "</scores>\n";
            BufferedReader in = new BufferedReader(new FileReader(xmlScores));
            String line = in.readLine();
            while (!line.contains("</scores>")) {
                lines.add(line);
                line = in.readLine();
            }
            in.close();

            lines.add(newPlayer);
            PrintWriter out = new PrintWriter(xmlScores);
            for (String l : lines)
                out.println(l);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
