package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startLoop();
    }

    private void startLoop() {
        // Ask The User if fullscreen
        if (JOptionPane.showConfirmDialog(null, "Would You Like To Run In Fullscreen Mode?",
                "Start Fullscreen?", JOptionPane.YES_NO_OPTION) == 1) {
            // Windowed Mode
            Settings.fullScreen = false;
        }
        try {
            if (!CreateGLWindow(Settings.windowTitle, Settings.windowWidth, Settings.windowHeight, Settings.fullScreen)) {
                // Quit If Window Was Not Created
                throw new Exception();
            }
            while (true) {
                Display.update();
                if (!Display.isActive() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || Display.isCloseRequested()) {
                    // Quit if told to
                    break;
                } else {
                    render();
                }
                // Toggle Fullscreen / Windowed Mode
                if (Keyboard.isKeyDown(Settings.changeWindowModeKey)) {
                    Settings.fullScreen = !Settings.fullScreen;
                    Display.setFullscreen(Settings.fullScreen);
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            Display.destroy();
        }
        System.exit(0);
    }

    private void render() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, Display.getDisplayMode().getWidth(), 0, Display.getDisplayMode().getHeight(), -1, 1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        // clear the screen
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);

        // center square according to screen size
        GL11.glPushMatrix();
        GL11.glTranslatef(Display.getDisplayMode().getWidth() / 2, Display.getDisplayMode().getHeight() / 2, 0.0f);

        // rotate square according to angle
        GL11.glRotatef(10.0f, 0, 0, 1.0f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2i(-50, -50);
        GL11.glVertex2i(50, -50);
        GL11.glVertex2i(50, 50);
        GL11.glVertex2i(-50, 50);
        GL11.glEnd();

        GL11.glPopMatrix();
    }


    private boolean CreateGLWindow(String windowTitle, int windowWidth, int windowHeight, boolean fullScreen) throws LWJGLException {
        DisplayMode bestMode = null;
        for (DisplayMode d: Display.getAvailableDisplayModes()) {
            if (d.getWidth() == windowWidth && d.getHeight() == windowHeight && d.getFrequency() <= 85) {
                if (bestMode == null || (d.getBitsPerPixel() >= bestMode.getBitsPerPixel() && d.getFrequency() > bestMode.getFrequency())) bestMode = d;
            }
        }

        Display.setDisplayMode(bestMode);
        Display.setFullscreen(fullScreen);
        Display.setTitle(windowTitle);
        Display.create();
        ReSizeGLScene(windowWidth, windowHeight);

        // Initialize Our Newly Created GL Window
        // Enable Smooth Shading
        GL11.glShadeModel(GL11.GL_SMOOTH);
        // Red Background
        GL11.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
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

}
