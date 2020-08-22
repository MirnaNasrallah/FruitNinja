/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 *
 * @author Nurcan
 */
public class Sprite {
   private Image image;
   private double positionX;        
   private double positionY;
   private double velocityX;
   private double velocityY;
   
    
   public Sprite()
    {
        positionX = 0;
        positionY = 0;    
        velocityX = 0;
        velocityY = 0;
    }

    
   public Sprite(Image image){
   this.image = image;
   this.positionX = 0;
   this.positionY =0;
   
   
   }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }
   public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    

   public void render(GraphicsContext gc) {
       gc.drawImage(image, positionX, positionY);
    }

   public void update(double mouseX , double mouseY) {
   this.positionX = mouseX;
   this.positionY = mouseY;
   }
   public void update(double time)
    {
        
        positionY += velocityY * time;
    }

    public void move(double time){
        
    }
    
    private Rectangle2D getBoundry(){
        return new Rectangle2D(positionX,positionY,50,50);
    }

    public boolean intersects(Sprite sprite){
        return this.getBoundry().intersects(sprite.getBoundry());
    }

    

    

}
