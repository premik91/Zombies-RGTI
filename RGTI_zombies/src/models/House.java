package models;

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glVertex3f;

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

    private float[] rgb;

    public House(float[] rgb) {
        this.rgb = rgb;
    }

    @Override
    public void render() {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor4f(rgb[0], rgb[1], rgb[2], 1.0f);

        glVertex3f(h[0],h[1],h[2]);
        glVertex3f(g[0],g[1],g[2]);
        glVertex3f(c[0],c[1],c[2]);
        glVertex3f(d[0],d[1],d[2]);

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

        GL11.glEnd();
    }
}