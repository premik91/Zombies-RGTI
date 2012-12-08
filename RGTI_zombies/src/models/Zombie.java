package models;

import jinngine.physics.Body;
import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.opengl.Texture;

import static main.Settings.zombieObjectHealth;
import static org.lwjgl.opengl.GL11.*;


public class Zombie extends Model3D {
    float[] a = {-1.0f, -1.0f, 1.0f};
    float[] b = {1.0f, -1.0f, 1.0f};
    float[] c = {-1.0f, 1.0f, 1.0f};
    float[] d = {1.0f, 1.0f, 1.0f};

    float[] e = {-1.0f, -1.0f, -1.0f};
    float[] f = {1.0f, -1.0f, -1.0f};
    float[] g = {-1.0f, 1.0f, -1.0f};
    float[] h = {1.0f, 1.0f, -1.0f};

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


//        glBegin(GL_QUADS);
//        glColor4f(1.0f, 1.0f, 0, 1.0f);
//        glVertex3f(h[0],h[1],h[2]);
//        glVertex3f(g[0],g[1],g[2]);
//        glVertex3f(c[0],c[1],c[2]);
//        glVertex3f(d[0],d[1],d[2]);
//
//        glVertex3f(d[0],d[1],d[2]);
//        glVertex3f(c[0],c[1],c[2]);
//        glVertex3f(a[0],a[1],a[2]);
//        glVertex3f(b[0],b[1],b[2]);
//
//        glVertex3f(f[0],f[1],f[2]);
//        glVertex3f(e[0],e[1],e[2]);
//        glVertex3f(g[0],g[1],g[2]);
//        glVertex3f(h[0],h[1],h[2]);
//
//        glVertex3f(c[0],c[1],c[2]);
//        glVertex3f(g[0],g[1],g[2]);
//        glVertex3f(e[0],e[1],e[2]);
//        glVertex3f(a[0],a[1],a[2]);
//
//        glVertex3f(h[0],h[1],h[2]);
//        glVertex3f(d[0],d[1],d[2]);
//        glVertex3f(b[0],b[1],b[2]);
//        glVertex3f(f[0],f[1],f[2]);
//
//        glEnd();
    }
}
