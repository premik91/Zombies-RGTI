package models;

import jinngine.physics.Body;
import org.lwjgl.util.glu.Sphere;

import static org.lwjgl.opengl.GL11.*;

public class Bomb extends Model3D {

    public Bomb(Body bombBody) {
        this.body = bombBody;
    }

    @Override
    public void render() {
        glPushMatrix();
        glColor4f(0,0,0,0);
        Sphere s = new Sphere();
        s.draw(0.4f, 16, 16);
        glPopMatrix();
    }
}
