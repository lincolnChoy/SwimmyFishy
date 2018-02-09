package com.henryandlincoln.swimmyfishy;


public class Rectangle {

    public int x;
    public int y;
    public float width;
    public float height;
    private boolean firstIntersect;

    public Rectangle(){
        firstIntersect = true;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public boolean intersects(Rectangle other){

        if (this.x > (other.x + other.width) || other.x > (this.x + this.width)){
            return false;
        }

        if (this.y > (other.y + other.height) || other.y > (this.y + this.height)){
            return false;
        }
        return true;

        //return (this.x < (other.x + other.width) && (this.x + this.width) > other.x && this.y < (other.y  + other.height) && (this.y +  this.height) > other.y );
    }

    public boolean firstIntersect(){

        return this.firstIntersect;
    }

    public void setFirstIntersect(boolean firstIntersect){

        this.firstIntersect = firstIntersect;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return this.x;
    }
}
