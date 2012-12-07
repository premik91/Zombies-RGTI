package models;

import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

public class House extends Model3D {

    /*
        FRONT
        c_______d
        |       |
        |       |
        |       |
        |_______|
        a       b
     */
    float[] a = {-1.0f, -1.0f, 1.0f};
    float[] b = {1.0f, -1.0f, 1.0f};
    float[] c = {-1.0f, 1.0f, 1.0f};
    float[] d = {1.0f, 1.0f, 1.0f};
    /*
        BACK
        g_______h
        |       |
        |       |
        |       |
        |_______|
        e      f
    */
    float[] e = {-1.0f, -1.0f, -1.0f};
    float[] f = {1.0f, -1.0f, -1.0f};
    float[] g = {-1.0f, 1.0f, -1.0f};
    float[] h = {1.0f, 1.0f, -1.0f};

    Texture texture;

    private float[] rgb;

    public House(float[] rgb, Texture texture) {
        this.rgb = rgb;
        this.texture = texture;
    }

    @Override
    public void render() {


        glEnable(GL_TEXTURE_2D);
        glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE );

        if (texture != null) {
            glBindTexture(GL_TEXTURE_2D, texture.getTextureID());
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        }

        glBegin(GL_QUADS);
//        glColor4f(1.0f, 1.0f, 1.0f, 0.0f);

        glColor4f(rgb[0], rgb[1], rgb[2], 1.0f);

        glTexCoord2f(0,0);
        glVertex3f(h[0],h[1],h[2]);
        glTexCoord2f(1,0);
        glVertex3f(g[0],g[1],g[2]);
        glTexCoord2f(1,1);
        glVertex3f(c[0],c[1],c[2]);
        glTexCoord2f(0,1);
        glVertex3f(d[0],d[1],d[2]);

        glTexCoord2f(0,0);
        glVertex3f(d[0],d[1],d[2]);
        glTexCoord2f(1,0);
        glVertex3f(c[0],c[1],c[2]);
        glTexCoord2f(1,1);
        glVertex3f(a[0],a[1],a[2]);
        glTexCoord2f(0,1);
        glVertex3f(b[0],b[1],b[2]);

        glTexCoord2f(0,0);
        glVertex3f(f[0],f[1],f[2]);
        glTexCoord2f(1,0);
        glVertex3f(e[0],e[1],e[2]);
        glTexCoord2f(1,1);
        glVertex3f(g[0],g[1],g[2]);
        glTexCoord2f(0,1);
        glVertex3f(h[0],h[1],h[2]);

        glTexCoord2f(0,0);
        glVertex3f(c[0],c[1],c[2]);
        glTexCoord2f(1,0);
        glVertex3f(g[0],g[1],g[2]);
        glTexCoord2f(1,1);
        glVertex3f(e[0],e[1],e[2]);
        glTexCoord2f(0,1);
        glVertex3f(a[0],a[1],a[2]);

        glTexCoord2f(0,0);
        glVertex3f(h[0],h[1],h[2]);
        glTexCoord2f(1,0);
        glVertex3f(d[0],d[1],d[2]);
        glTexCoord2f(1,1);
        glVertex3f(b[0],b[1],b[2]);
        glTexCoord2f(0,1);
        glVertex3f(f[0],f[1],f[2]);

        glEnd();

        glDisable(GL_TEXTURE_2D);
    }
}