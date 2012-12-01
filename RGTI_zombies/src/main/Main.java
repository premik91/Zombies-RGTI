package main;

import models.MainCamera;
import models.Terrain;
import models.UserObject;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

import javax.swing.*;

public class Main {

    private MainCamera camera;
    private Terrain terrain;
    private UserObject user;

    public static void main(String[] args) {
        Main main = new Main();
        main.startLoop();
    }

    private void startLoop() {
        if (JOptionPane.showConfirmDialog(null, "Would You Like To Run In Fullscreen Mode?",
                "Start Fullscreen?", JOptionPane.YES_NO_OPTION) == 1) {
            Settings.fullScreen = false;
        }

        try {
            if (!CreateGLWindow(Settings.windowTitle, Settings.windowWidth, Settings.windowHeight, Settings.fullScreen)) {
                // Quit If Window Was Not Created
                throw new Exception();
            }
            initializeObjects();
            while (true) {
                resetDisplay();

                if (!Display.isActive() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || Display.isCloseRequested()) {
                    // Quit if told to
                    break;
                }
                render();
                processInput();
                // Toggle Fullscreen / Windowed Mode
                if (Keyboard.isKeyDown(Settings.changeWindowModeKey)) {
                    Settings.fullScreen = !Settings.fullScreen;
                    Display.setFullscreen(Settings.fullScreen);
                }
                Display.update();
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            Display.destroy();
        }
        System.exit(0);
    }

    private void resetDisplay() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);
        GL11.glClearColor(1, 1, 1, 1);
    }

    private void render() {
        camera.render3D();
        terrain.render3D();
        user.render3D();
    }

    private void initializeObjects() {
        camera = new MainCamera();
        camera.translate(0, -1.0f, -10.0f);
        camera.rotate(15.0f, 0.0f, 0.0f);

        terrain = new Terrain();
        terrain.scale(10.0f, 10.0f, 10.0f);
        terrain.translate(5.0f, 10.0f, 10.0f);

        user = new UserObject();
        user.scale(0.3f, 0.3f, 0.3f);
        user.translate(1.0f, 0.0f, 0.0f);
    }

    private boolean CreateGLWindow(String windowTitle, int windowWidth, int windowHeight, boolean fullScreen) throws LWJGLException {
        DisplayMode bestMode = null;
        for (DisplayMode d: Display.getAvailableDisplayModes()) {
            if (d.getWidth() == windowWidth && d.getHeight() == windowHeight && d.getFrequency() <= 85) {
                if (bestMode == null || (d.getBitsPerPixel() >= bestMode.getBitsPerPixel() && d.getFrequency() > bestMode.getFrequency())) bestMode = d;
            }
        }

        Display.setDisplayMode(bestMode);
        Display.create(new PixelFormat(8, 8, 8, 4));
        Display.setFullscreen(fullScreen);
        Display.setTitle(windowTitle);
        ReSizeGLScene(windowWidth, windowHeight);

        // Initialize Our Newly Created GL Window
        // Enable Smooth Shading
        GL11.glShadeModel(GL11.GL_SMOOTH);
        // Depth Buffer Setup
        GL11.glClearDepth(1.0f);
        // Enables Depth Testing
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        // The Type Of Depth Testing To Do
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        // Really Nice Perspective Calculations
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
        return true;
    }

    private void ReSizeGLScene(int windowWidth, int windowHeight) {
        if (windowHeight == 0) {
            windowHeight = 1;
        }
        // Reset The Current Viewport
        GL11.glViewport(0, 0, windowWidth, windowHeight);

        // Select The Projection Matrix
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        // Reset The Projection Matrix
        GL11.glLoadIdentity();

        // Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(45.0f, (float) windowWidth / (float) windowHeight, 0.1f, 100.0f);

        // Select The Modelview Matrix
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        // Reset The Modelview Matrix
        GL11.glLoadIdentity();
    }

    protected void processInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            user.rotate(0.0f, 0.1f, 0.0f);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_E)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {}
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {}
    }
}
