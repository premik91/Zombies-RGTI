package models;

import jinngine.physics.Body;
import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.opengl.Texture;

import static main.Settings.zombieObjectHealth;
import static org.lwjgl.opengl.GL11.*;


public class Zombie extends Model3D {
    private int ZombieHealth = zombieObjectHealth;

    public Zombie(Body zombieBody, Texture texture) {
        this.body = zombieBody;
        this.texture = texture;
    }

    public int getZombieHealth() {
        return ZombieHealth;
    }

    public void setZombieHealth(int ZombieHealth) {
        this.ZombieHealth = ZombieHealth;
    }

    @Override
    public void render() {
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texture.getTextureID());
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

        glEnable(GL_TEXTURE_GEN_S);
        glEnable(GL_TEXTURE_GEN_T);
        glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
        glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_SPHERE_MAP);

        glColor4f(1.0f, 1.0f, 0, 1.0f);
        Sphere s = new Sphere();
        s.draw(2.0f, 16, 16);

        glDisable(GL_TEXTURE_GEN_S);
        glDisable(GL_TEXTURE_GEN_T);
        glDisable(GL_TEXTURE_2D);
    }
}
