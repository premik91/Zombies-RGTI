package models;

import jinngine.physics.Body;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

public abstract class Model3D {

    protected Vector3f position = new Vector3f();
    protected Vector3f rotation = new Vector3f();
    protected Vector3f scale = new Vector3f();

    protected Body body;
    protected Texture texture = null;

    protected abstract void render();

    public void render3D() {
        glMatrixMode(GL_MODELVIEW);
        glPushMatrix();

        glTranslatef(position.x, position.y, position.z);

        glRotatef(rotation.z, 0, 0, 1);
        glRotatef(rotation.y, 0, 1, 0);
        glRotatef(rotation.x, 1, 0, 0);

        glScalef(scale.x, scale.y, scale.z);

        render();
        glPopMatrix();
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body bombBody) {
        this.body = bombBody;
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

    public Vector3f getPosition() {
        return this.position;
    }

    public void setPosition(float x, float y, float z) {
        this.position.set(x, y, z);
    }

    public Vector3f getScale() {
        return scale;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }
}
