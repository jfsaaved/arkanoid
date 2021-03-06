package com.jfsaaved.arkanoid.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


/**
 *
 * Author: Julian Saavedra
 * E-mail: julian.felipe.saavedra@gmail.com
 * Date: November 8, 2015
 *
 */

public class Brick extends GameObject {

    private boolean hide;
    private Rectangle rectangle;
    private Texture texture;

    public Brick(float x, float y, String image){
        texture = new Texture(Gdx.files.internal(image));
        rectangle = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public void setHide(boolean b){
        hide = b;
    }

    public Boolean getHide(){
        return hide;
    }

    @Override
    public void setX(float x){
        rectangle.setX(x);
    }

    @Override
    public void setY(float y){
        rectangle.setY(y);
    }

    @Override
    public float getX() {
        return rectangle.x;
    }

    @Override
    public float getY() {
        return rectangle.y;
    }

    @Override
    public float getWidth() { return rectangle.getWidth(); }

    @Override
    public float getHeight() { return rectangle.getHeight(); }

    @Override
    public boolean contains(float x, float y){ return rectangle.contains(x, y); }

    @Override
    public void render(SpriteBatch sb) {
        if(!hide)
            sb.draw(texture,rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }

    @Override
    public void renderShape(ShapeRenderer sr) {
        if(!hide)
            sr.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public void dispose(){
        texture.dispose();
    }
}
