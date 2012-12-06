package models;

import static org.lwjgl.opengl.GL11.*;

public class UserObject extends Model3D {
    float[] a = {-1.0f, -1.0f, 1.0f};
    float[] b = {1.0f, -1.0f, 1.0f};
    float[] c = {-1.0f, 1.0f, 1.0f};
    float[] d = {1.0f, 1.0f, 1.0f};

    float[] e = {-1.0f, -1.0f, -1.0f};
    float[] f = {1.0f, -1.0f, -1.0f};
    float[] g = {-1.0f, 1.0f, -1.0f};
    float[] h = {1.0f, 1.0f, -1.0f};

    @Override
    public void render() {
        glBegin(GL_QUADS);
        glColor4f(0, 1.0f, 0, 1.0f);

        glVertex3f(h[0],h[1],h[2]);
        glVertex3f(g[0],g[1],g[2]);
        glVertex3f(c[0],c[1],c[2]);
        glVertex3f(d[0],d[1],d[2]);

        glVertex3f(b[0],b[1],b[2]);
        glVertex3f(a[0],a[1],a[2]);
        glVertex3f(e[0],e[1],e[2]);
        glVertex3f(f[0],f[1],f[2]);

        glVertex3f(d[0],d[1],d[2]);
        glVertex3f(c[0],c[1],c[2]);
        glVertex3f(a[0],a[1],a[2]);
        glVertex3f(b[0],b[1],b[2]);

        glVertex3f(f[0],f[1],f[2]);
        glVertex3f(e[0],e[1],e[2]);
        glVertex3f(g[0],g[1],g[2]);
        glVertex3f(h[0],h[1],h[2]);

        glVertex3f(c[0],c[1],c[2]);
        glVertex3f(g[0],g[1],g[2]);
        glVertex3f(e[0],e[1],e[2]);
        glVertex3f(a[0],a[1],a[2]);

        glVertex3f(h[0],h[1],h[2]);
        glVertex3f(d[0],d[1],d[2]);
        glVertex3f(b[0],b[1],b[2]);
        glVertex3f(f[0],f[1],f[2]);

        glEnd();
    }
}
