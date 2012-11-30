package models;

import org.lwjgl.opengl.GL11;

public class UserObject extends Model3D {

    @Override
    public void render() {
        GL11.glBegin(GL11.GL_QUADS);					    // Draw a cube with quads
        GL11.glColor4f(0, 1.0f, 0, 1.0f);

        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);					// Top Right Of The Quad (Top)
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);					// Top Left Of The Quad (Top)
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);					// Bottom Left Of The Quad (Top)
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);					// Bottom Right Of The Quad (Top)
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Top Right Of The Quad (Bottom)
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Top Left Of The Quad (Bottom)
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);					// Bottom Left Of The Quad (Bottom)
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);					// Bottom Right Of The Quad (Bottom)
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);					// Top Right Of The Quad (Front)
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);					// Top Left Of The Quad (Front)
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Bottom Left Of The Quad (Front)
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Bottom Right Of The Quad (Front)
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);					// Top Right Of The Quad (Back)
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);					// Top Left Of The Quad (Back)
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);					// Bottom Left Of The Quad (Back)
        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);					// Bottom Right Of The Quad (Back)
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);					// Top Right Of The Quad (Left)
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);					// Top Left Of The Quad (Left)
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);					// Bottom Left Of The Quad (Left)
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);					// Bottom Right Of The Quad (Left)
        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);					// Top Right Of The Quad (Right)
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);					// Top Left Of The Quad (Right)
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);					// Bottom Left Of The Quad (Right)
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);					// Bottom Right Of The Quad (Right)

        GL11.glEnd();
    }
}
