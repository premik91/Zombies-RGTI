package models;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public abstract class Model3D {

    protected Vector3f position = new Vector3f();
    protected Vector3f rotation = new Vector3f();
    protected Vector3f scale = new Vector3f();

    protected abstract void render();

    public void render3D() {
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPushMatrix();

        GL11.glTranslatef(position.x, position.y, position.z);

        GL11.glRotatef(rotation.z, 0, 0, 1);
        GL11.glRotatef(rotation.y, 0, 1, 0);
        GL11.glRotatef(rotation.x, 1, 0, 0);

        GL11.glScalef(scale.x, scale.y, scale.z);

        render();
        GL11.glPopMatrix();
    }

    public void translate(float x, float y, float z) {
        this.position.set(this.position.x+x, this.position.y+y, this.position.z+z);
    }

    public void rotate(float x, float y, float z) {
        this.rotation.set(this.rotation.x+x, this.rotation.y+y, this.rotation.z+z);
    }

    public void scale(float x, float y, float z) {
        this.scale.set(this.scale.x+x, this.scale.y+y, this.scale.z+z);
    }
}
