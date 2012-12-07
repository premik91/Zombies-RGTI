package models;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class DeadZombie extends Model3D {
    private ArrayList<float[]> zombieBlood = new ArrayList<float[]>();
    public DeadZombie() {
        for(int i = 0; i < Math.random()*100 + 100; i++) {
            zombieBlood.add(new float[]{(float) Math.random(), 0, (float) Math.random()});
        }
    }

    @Override
    public void render() {
        glBegin(GL_QUADS);
        glColor4f(1.0f, 0, 0, 1.0f);
        for(float[] blood: zombieBlood) {
            glVertex3f(blood[0], blood[1], blood[2]);
        }
        glEnd();
    }
}
