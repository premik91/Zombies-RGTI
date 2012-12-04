package models;

import main.Settings;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class MainCamera extends Model3D
{

    public MainCamera()
    {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(45, Settings.windowWidth / (float) Settings.windowHeight, 1.0f, 30.0f);
    }

    @Override
    public void render3D()
    {
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(position.x, position.y, position.z);

        GL11.glRotatef(rotation.z, 0, 0, 1);
        GL11.glRotatef(rotation.y, 0, 1, 0);
        GL11.glRotatef(rotation.x, 1, 0, 0);
    }

    @Override
    protected void render(){}
}
