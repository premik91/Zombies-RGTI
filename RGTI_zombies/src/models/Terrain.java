package models;

import org.lwjgl.opengl.GL11;

public class Terrain extends Model3D {

    @Override
    public void render() {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor4f(0, 0, 1.0f, 1.0f);

        GL11.glVertex3f( 1.0f, 0.0f, 1.0f);
        GL11.glVertex3f(-1.0f, 0.0f, 1.0f);
        GL11.glVertex3f(-1.0f, 0.0f,-1.0f);
        GL11.glVertex3f( 1.0f, 0.0f,-1.0f);

        GL11.glEnd();
    }
}
