package models;

import main.Settings;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class MainCamera extends Model3D {
    public MainCamera() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(45, Settings.windowWidth / (float) Settings.windowHeight, 1.0f, 100.0f);
    }

    @Override
    public void render3D() {
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glTranslatef(position.x, position.y, position.z);

        glRotatef(rotation.z, 0, 0, 1);
        glRotatef(rotation.y, 0, 1, 0);
        glRotatef(rotation.x, 1, 0, 0);
    }

    @Override
    protected void render() {}
}
