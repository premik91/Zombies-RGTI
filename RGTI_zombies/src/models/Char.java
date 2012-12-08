package models;

import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Char extends Model3D {
    float[] a = {-1.0f, -1.0f, 1.0f};
    float[] b = {1.0f, -1.0f, 1.0f};
    float[] c = {-1.0f, 1.0f, 1.0f};
    float[] d = {1.0f, 1.0f, 1.0f};

    public Char(Texture texture) {
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
        glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

        glTexCoord2f(0,0);
        glVertex3f(d[0],d[1],d[2]);

        glTexCoord2f(0,1);
        glVertex3f(c[0],c[1],c[2]);

        glTexCoord2f(1,1);
        glVertex3f(a[0],a[1],a[2]);

        glTexCoord2f(1,0);
        glVertex3f(b[0],b[1],b[2]);

        glEnd();
        glDisable(GL_TEXTURE_2D);
    }
}
