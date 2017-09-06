package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private float ang;
    private Rectangle rect;

    public Rectangle getRect() {
        return rect;
    }

    public Asteroid() {
        if (texture == null)
            texture = new Texture("asteroid60.tga");
        speed = 1.0f + (float) Math.random() * 9.0f;
        position = new Vector2(1280 + (float) Math.random() * 640, (float) Math.random() * 720);
        ang = (float) Math.random() * 360;
        rect = new Rectangle(position.x, position.y, 60, 60);
    }

    public void update() {
        position.x -= speed;
        ang += speed;
        if (position.x < -60) {
            recreate();
        }
        rect.x = position.x;
        rect.y = position.y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 30, 30, 60, 60, 1.0f, 1.0f, ang, 0, 0, 60, 60, false, false);
    }

    public void recreate() {
        position.x = 1280 + (float) Math.random() * 640;
        position.y = (float) Math.random() * 720;
    }
}
