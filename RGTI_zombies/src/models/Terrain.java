package models;

import static org.lwjgl.opengl.GL11.*;

public class Terrain extends Model3D {

    @Override
    public void render() {
        glBegin(GL_QUADS);
        glColor4f(1.0f, 0, 1.0f, 1.0f);

        glVertex3f(1.0f, 0.0f, 1.0f);
        glVertex3f(-1.0f, 0.0f, 1.0f);
        glVertex3f(-1.0f, 0.0f, -1.0f);
        glVertex3f(1.0f, 0.0f, -1.0f);

        glEnd();
    }
}
