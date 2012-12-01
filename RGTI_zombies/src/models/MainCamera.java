package models;

import main.Settings;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class MainCamera extends Model3D
{
    //the rotation around the Y axis of the camera
    private float yaw = 0.0f;
    //the rotation around the X axis of the camera
    private float pitch = 0.0f;

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

    public void yaw(float amount)
    {
        //increment the yaw by the amount param
        yaw += amount;
    }

    //increment the camera's current yaw rotation
    public void pitch(float amount)
    {
        //increment the pitch by the amount param
        pitch += amount;
    }

    public float getYaw() {
        return yaw;
    }

    public void lookThrough()
    {
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        //roatate the pitch around the X axis
        GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        //roatate the yaw around the Y axis
        GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        //translate to the position vector's location
        GL11.glTranslatef(position.x, position.y, position.z);
    }

}
