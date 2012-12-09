package models;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class Crosshair extends Model3D {

    float radius;

    public Crosshair(float radius) {
        this.radius = radius;
    }

    public void render() {
        glBegin(GL_LINES);
        glColor3f(0f, 0f, 1.0f);

        for (int i=0; i < 360; i++) {
            float degInRad = i * 0.0174532925f;
            glVertex2f((float)cos(degInRad)*radius,(float)sin(degInRad)*radius);
            glVertex2f((float)cos(degInRad)*radius*0.8f,(float)sin(degInRad)*radius*0.8f);
            glVertex2f((float)cos(degInRad)*radius*0.6f,(float)sin(degInRad)*radius*0.6f);

        }

        glEnd();
    }
}
