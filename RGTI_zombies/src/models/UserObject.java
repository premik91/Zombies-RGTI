package models;

import static org.lwjgl.opengl.GL11.*;

public class UserObject extends Model3D {

    @Override
    public void render() {
        glBegin(GL_QUADS);					    // Draw a cube with quads
        glColor4f(0, 1.0f, 0, 1.0f);

        glVertex3f(1.0f, 1.0f, -1.0f);					// Top Right Of The Quad (Top)
        glVertex3f(-1.0f, 1.0f, -1.0f);					// Top Left Of The Quad (Top)
        glVertex3f(-1.0f, 1.0f, 1.0f);					// Bottom Left Of The Quad (Top)
        glVertex3f(1.0f, 1.0f, 1.0f);					// Bottom Right Of The Quad (Top)
        glVertex3f(1.0f, -1.0f, 1.0f);					// Top Right Of The Quad (Bottom)
        glVertex3f(-1.0f, -1.0f, 1.0f);					// Top Left Of The Quad (Bottom)
        glVertex3f(-1.0f, -1.0f, -1.0f);					// Bottom Left Of The Quad (Bottom)
        glVertex3f(1.0f, -1.0f, -1.0f);					// Bottom Right Of The Quad (Bottom)
        glVertex3f(1.0f, 1.0f, 1.0f);					// Top Right Of The Quad (Front)
        glVertex3f(-1.0f, 1.0f, 1.0f);					// Top Left Of The Quad (Front)
        glVertex3f(-1.0f, -1.0f, 1.0f);					// Bottom Left Of The Quad (Front)
        glVertex3f(1.0f, -1.0f, 1.0f);					// Bottom Right Of The Quad (Front)
        glVertex3f(1.0f, -1.0f, -1.0f);					// Top Right Of The Quad (Back)
        glVertex3f(-1.0f, -1.0f, -1.0f);					// Top Left Of The Quad (Back)
        glVertex3f(-1.0f, 1.0f, -1.0f);					// Bottom Left Of The Quad (Back)
        glVertex3f(1.0f, 1.0f, -1.0f);					// Bottom Right Of The Quad (Back)
        glVertex3f(-1.0f, 1.0f, 1.0f);					// Top Right Of The Quad (Left)
        glVertex3f(-1.0f, 1.0f, -1.0f);					// Top Left Of The Quad (Left)
        glVertex3f(-1.0f, -1.0f, -1.0f);					// Bottom Left Of The Quad (Left)
        glVertex3f(-1.0f, -1.0f, 1.0f);					// Bottom Right Of The Quad (Left)
        glVertex3f(1.0f, 1.0f, -1.0f);					// Top Right Of The Quad (Right)
        glVertex3f(1.0f, 1.0f, 1.0f);					// Top Left Of The Quad (Right)
        glVertex3f(1.0f, -1.0f, 1.0f);					// Bottom Left Of The Quad (Right)
        glVertex3f(1.0f, -1.0f, -1.0f);					// Bottom Right Of The Quad (Right)

        glEnd();
    }
}
