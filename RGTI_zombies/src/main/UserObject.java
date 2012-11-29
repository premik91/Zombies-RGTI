package main;

import org.lwjgl.opengl.GL11;

public class UserObject {
    private float R;
    private float G;
    private float B;
    private float alpha;

    public UserObject(float R, float G, float B, float alpha) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.alpha = alpha;
    }

    public void drawUserObject() {
        GL11.glTranslatef(0.0f, 0.0f, -20.0f);				// Translate Into The Screen 7.0 Units
        GL11.glRotatef(0.0f,0.0f,1.0f,0.0f);				// Rotate The cube around the Y axis
        GL11.glRotatef(0.0f,1.0f,1.0f,1.0f);
        GL11.glBegin(GL11.GL_QUADS);					    // Draw a cube with quads
        GL11.glColor4f(R, G, B, alpha);						// Color Blue
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
