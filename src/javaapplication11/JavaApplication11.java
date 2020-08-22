/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Nurcan
 */
public class JavaApplication11 extends Application {

    /**
     * @param args the command line arguments
     */
    AnimationTimer timer;
    //Fruit watermelon;
    Pane root = new Pane();
    List drop = new ArrayList();
    double mouseX;
    double mouseY;
    ImageView cont;
    //ImageView watermelon;
    double speed;
    double falling;
    Label lblMissed;
    
    int missed;
    
    Sprite knife;
    Sprite orange;
    Sprite fatalbomb;
    Sprite bomb;
    Sprite kiwi;
    Sprite melon;
    Sprite pineapple;
    Sprite apple;
    
    List<Sprite> Kiwi;
    List<Sprite> Apple;
    List<Sprite> FatalBomb;
    List<Sprite> PineApple;
    List<Sprite> Orange;
    List<Sprite> Bomb;
    List<Sprite> watermelon; 
    
    int currentScore = 0;
    int currentlifes = 5;
    
      AudioClip backgroundSound , sliceSound , endSound; 
    
    static Label txtScore = new Label(" 0 ");
    static Label life = new Label(" 5 ");
    
  
 
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
         backgroundSound = new AudioClip(this.getClass().getResource("Fruit Ninja Music.mp3").toExternalForm());
        backgroundSound.play(0.5);
        Image back = new Image(getClass().getResource("background.jpeg").toExternalForm());
        speed = 1;
        falling = 500;
        speed += falling / 4000;
        ImageView background = new ImageView(back);
        Scene scene = new Scene(root,800,600);
        Canvas canvas = new Canvas(800,600);
        root.getChildren().add(background);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
    
   
        
        txtScore.setLayoutX(0);
        txtScore.setLayoutY(0);
        //txtScore.setText("  ");
        
        life.setLayoutX(5);
        life.setLayoutY(5);
        //life.setText(" 5 ");
        root.getChildren().add(life);
        root.getChildren().add(txtScore);
        
        
        
        knife = new Sprite(new Image(getClass().getResource("knife.png").toExternalForm()));
        knife.render(gc);
        
        Random random = new Random();
        watermelon = new ArrayList<>();
         Kiwi = new ArrayList<>();
         Bomb = new ArrayList<>();
         PineApple = new ArrayList<>();
         Apple = new ArrayList<>();
         FatalBomb = new ArrayList<>();
         Orange = new ArrayList<>();
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> {
        
        speed += falling / 4000;
          
      
        for(int i = 0; i< 1;i++){
            int max = 700;
            int min = 50;
            melon = new Sprite(new Image(getClass().getResource("Watermelon.png").toExternalForm()));
            melon.setPositionX(Math.random() * max + min);
            
            apple = new Sprite(new Image(getClass().getResource("fullapple.png").toExternalForm()));
            apple.setPositionX(Math.random() * max + min);
            
            orange = new Sprite(new Image(getClass().getResource("Orange.png").toExternalForm()));
            orange.setPositionX(Math.random() * max + min);
            
            kiwi = new Sprite(new Image(getClass().getResource("Kiwi.png").toExternalForm()));
            kiwi.setPositionX(Math.random() * max + min);
            
            pineapple = new Sprite(new Image(getClass().getResource("pineapple.png").toExternalForm()));
            pineapple.setPositionX(Math.random() * max + min);
            
            
            watermelon.add(melon);
            melon.render(gc);
            Orange.add(orange);
            orange.render(gc); 
            Apple.add(apple);
            apple.render(gc);
            Kiwi.add(kiwi);
            kiwi.render(gc);
            PineApple.add(pineapple);
            pineapple.render(gc);
           
            
            
            
            
                           
        }  }));
        
        timeline.setCycleCount(1000);
        //timeline.setAutoReverse(true);
        timeline.play();
        Timeline timelineBomb = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            for(int i = 0; i< 1;i++){
            int max = 700;
            int min = 50;
            bomb = new Sprite(new Image(getClass().getResource("bomb.png").toExternalForm()));
            bomb.setPositionX(Math.random() * max + min);
             Bomb.add(bomb);
             bomb.render(gc);
            }
            
            
        }));
        
        timelineBomb.setCycleCount(1000);
        timelineBomb.play();
        
         Timeline timelineFatalBomb = new Timeline(new KeyFrame(Duration.seconds(4), event -> {
            for(int i = 0; i< 1;i++){
            int max = 700;
            int min = 50;
            fatalbomb = new Sprite(new Image(getClass().getResource("fatalBomb.png").toExternalForm()));
            fatalbomb.setPositionX(Math.random() * max + min);
             FatalBomb.add(fatalbomb);
             fatalbomb.render(gc);
            }
            
            
        }));
        
        timelineFatalBomb.setCycleCount(1000);
        timelineFatalBomb.play();
        
        scene.setOnMouseMoved(e -> {
        mouseX = e.getX();
        mouseY = e.getY();
        
        });
        
        timer = new AnimationTimer() {
          
        @Override
        public void handle(long now) {
           
        knife.update(mouseX,mouseY);
           for(int i = 0; i< watermelon.size();i++){
        
        watermelon.get(i).update(0.03);
        watermelon.get(i).addVelocity(1, 1);
        Apple.get(i).update(0.03);
        Apple.get(i).addVelocity(1, 1);
        Orange.get(i).update(0.03);
        Orange.get(i).addVelocity(1, 1);
        
        Kiwi.get(i).update(0.05);
        Kiwi.get(i).addVelocity(1, 1);
        PineApple.get(i).update(0.05);
        PineApple.get(i).addVelocity(1, 1);
        
                   }
           for(int i = 0;i<Bomb.size();i++){
                Bomb.get(i).update(0.03);
                Bomb.get(i).addVelocity(1, 1);

           }
           for(int i = 0;i<FatalBomb.size();i++){
                FatalBomb.get(i).update(0.07);
                FatalBomb.get(i).addVelocity(1, 1);

           }
        Iterator<Sprite> iteratork = Kiwi.iterator();
        Iterator<Sprite> iteratorw = watermelon.iterator();
        Iterator<Sprite> iteratorFatal = FatalBomb.iterator();
        Iterator<Sprite> iteratorBomb = Bomb.iterator();
        Iterator<Sprite> iteratoro= Orange.iterator();
        Iterator<Sprite> iteratora= Apple.iterator();
        Iterator<Sprite> iteratorp= PineApple.iterator();
        
        while(iteratork.hasNext()){
            Sprite kiwis = iteratork.next();
            if(knife.intersects(kiwis)){
                iteratork.remove();
                kiwis.setImage(new Image(getClass().getResource("halfKiwi.png").toExternalForm()));
                kiwis.setPositionX(kiwis.getPositionX());
                kiwis.setPositionY(kiwis.getPositionY());
                Kiwi.add(kiwis);
                 sliceSound =  new AudioClip(this.getClass().getResource("Ninja Samurai Sword.mp3").toExternalForm());
                sliceSound.play(0.5);
                bonusKIncrease();
                
                
           }
            while(iteratorw.hasNext()){
            Sprite melon = iteratorw.next();
            if(knife.intersects(melon)){
                iteratorw.remove();
                melon.setImage(new Image(getClass().getResource("halfWatermelon.png").toExternalForm()));
                melon.setPositionX(melon.getPositionX());
                melon.setPositionY(melon.getPositionY());
                watermelon.add(melon);
                 sliceSound =  new AudioClip(this.getClass().getResource("Ninja Samurai Sword.mp3").toExternalForm());
                sliceSound.play(0.5);
               increaseScore();
            }
           
        }
        while(iteratorBomb.hasNext()){
            Sprite bomb = iteratorBomb.next();
            if(knife.intersects(bomb)){
                iteratorBomb.remove();
                bomb.setImage(new Image(getClass().getResource("boom.png").toExternalForm()));
                bomb.setPositionX(0);
                bomb.setPositionY(0);
                Bomb.add(bomb);
              decreaselife();  
              
               
                
            } 
               while(iteratorFatal.hasNext()){
            Sprite fb = iteratorFatal.next();
            if(knife.intersects(fb)){
                primaryStage.close();
                iteratorFatal.remove();
                fb.setImage(new Image(getClass().getResource("gameover.jpg").toExternalForm()));
                fb.setPositionX(0);
                fb.setPositionY(0);
                FatalBomb.add(fb);
                endGame();
                
               
            }
               while(iteratora.hasNext()){
            Sprite ap = iteratora.next();
            if(knife.intersects(ap)){
                iteratora.remove();
                ap.setImage(new Image(getClass().getResource("applee.png").toExternalForm()));
                ap.setPositionX(ap.getPositionX());
                ap.setPositionY(ap.getPositionY());
                Apple.add(ap);
                 sliceSound =  new AudioClip(this.getClass().getResource("Ninja Samurai Sword.mp3").toExternalForm());
                sliceSound.play(0.5);
                increaseScore();
            } 
               while(iteratorp.hasNext()){
            Sprite pa = iteratorp.next();
            if(knife.intersects(pa)){
                iteratorp.remove();
                pa.setImage(new Image(getClass().getResource("halfpineapple.png").toExternalForm()));
                pa.setPositionX(pa.getPositionX());
                pa.setPositionY(pa.getPositionY());
                PineApple.add(pa);
                 sliceSound =  new AudioClip(this.getClass().getResource("Ninja Samurai Sword.mp3").toExternalForm());
                sliceSound.play(0.5);
                bonusPAIncrease();
            }
           
        
        while(iteratoro.hasNext()){
            Sprite orange = iteratoro.next();
            if(knife.intersects(orange)){
                iteratoro.remove();
                orange.setImage(new Image(getClass().getResource("HalfOrange.png").toExternalForm()));
                orange.setPositionX(orange.getPositionX());
                orange.setPositionY(orange.getPositionY());
                Orange.add(orange); 
                 sliceSound =  new AudioClip(this.getClass().getResource("Ninja Samurai Sword.mp3").toExternalForm());
                sliceSound.play(0.5);
                increaseScore();
                
              
                }  
              }   
            }
          }
         }
       } 
     }  
        gc.clearRect(0, 0, 800, 600);
        knife.render(gc);
        for(Sprite kiwi : Kiwi){
            
            kiwi.render(gc);
        }
        for(Sprite melon : watermelon){
            melon.render(gc);
        }
         for(Sprite apples : Apple){
            apples.render(gc);
        } 
          for(Sprite pineapples : PineApple){
            pineapples.render(gc);
        }
        for(Sprite bomb : Bomb){
            bomb.render(gc);
        }
        for(Sprite fatalbomb : FatalBomb){
            fatalbomb.render(gc);
        }
        for(Sprite orange : Orange){
            orange.render(gc);
        }
        
        }

            
        
        };
        timer.start();
        
        
        
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void saveScore() throws IOException
    {
       
        File scoreFile = new File("C:\\Scores.txt");
        FileWriter scoreFileWriter = new FileWriter(scoreFile, true);
        if (Integer.parseInt(txtScore.getText()) == 0)
            return;
        scoreFileWriter.write(" " + txtScore.getText());
        scoreFileWriter.close();
    }
    public static int getHighestScore() throws FileNotFoundException
    {
        File scoresFile = new File("C:\\Scores.txt");
        Scanner scanScoreFile = new Scanner(scoresFile);
        ArrayList<Integer> scores = new ArrayList();
        while(scanScoreFile.hasNext())
        {
            scores.add(scanScoreFile.nextInt());
        }
        for (int i = 0; i < scores.size(); i++)
        {
            for (int j = i + 1; j < scores.size(); j++)
            {
                if (scores.get(i) < scores.get(j))
                {
                    int temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        if (scores.size() == 0)
        {
            return 0;
        }
        else
        {
            return scores.get(0);
        }
       
    }
public void increaseScore()
    {
       
        //txtScore.setText(Integer.toString(currentScore + 10));
        txtScore.setText("SCORE: " + String.valueOf(currentScore + 10));
    } 
public void bonusPAIncrease()
    {
        //int currentScore = Integer.parseInt(txtScore.getText());
        //txtScore.setText(Integer.toString(currentScore + 100));
       txtScore.setText("SCORE: " + String.valueOf(currentScore + 100));
    }
    public void bonusKIncrease()
    {
        //int currentScore = Integer.parseInt(txtScore.getText());
        //txtScore.setText(Integer.toString(currentScore + 20));
        txtScore.setText("SCORE: " + String.valueOf(currentScore + 20));
       
    } 
    public void decreaselife()
    {
        int currentlifes = Integer.parseInt(life.getText());
       
        if (currentlifes >= 0)
        {
       //life.setText(Integer.toString(currentlifes - 10));
            life.setText("LIVE: " + String.valueOf(currentlifes - 1));

        } 
    }
      public void endGame()
    {
        int currentlifes = Integer.parseInt(life.getText());
       
        if (currentlifes >= 0)
        {
       //life.setText(Integer.toString(currentlifes - currentlifes));
       life.setText("LIVE: " + String.valueOf(currentlifes - currentlifes ));

        } 
    }



}
    
            
        /*lblMissed = new Label("Score: 0");
        lblMissed.setLayoutX(10);
        lblMissed.setLayoutY(10);
        missed = 0;
        
        speed = 1;
        falling = 500;
        Image back = new Image(getClass().getResource("background.jpeg").toExternalForm());
        
        ImageView background = new ImageView(back);
        
        
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
        
        speed += falling / 4000;
        drop.add(watermelon());
        root.getChildren().add(((Node)drop.get(drop.size() -1)));
        }));
        
        timeline.setCycleCount(1000);
        timeline.play();
        
        
        
        timer = new AnimationTimer() {
        
        @Override
        public void handle(long arg0) {
        gameUpdate();
        
        }
        
        };
        timer.start();
        
        cont = knife();
        watermelon = watermelon();
        root.getChildren().add(background);
        
        root.getChildren().addAll(cont, lblMissed);
        
        Scene scene = new Scene(root, 800, 600);
        
        scene.setOnMouseMoved(e -> {
        mouseX = e.getX();
        mouseY = e.getY();
        if(cont.getX() == mouseX && cont.getY() == mouseY)
        {
        
        }
        });
        /*cont.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
        //drop.remove(watermelon);
        
        }
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public ImageView watermelon() {
        Image melon = new Image(getClass().getResource("Watermelon.png").toExternalForm());
        ImageView watermelon = new ImageView(melon);
        watermelon.setLayoutX(rand(50, 700));
        watermelon.setLayoutY(1);
        
        
        return watermelon;
    }
    
    public ImageView knife() {
        Image knife = new Image(getClass().getResource("knife.png").toExternalForm());
        ImageView Knife = new ImageView(knife);
        
        Knife.setLayoutX(200);
        Knife.setLayoutY(550);
        return Knife;
        
    }
    
    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
    public void gameUpdate(){
        
        cont.setLayoutX(mouseX);
        cont.setLayoutY(mouseY);
        
        
        for(int i = 0; i < drop.size(); i++) {
            ((ImageView) drop.get(i)).setLayoutY(((ImageView) drop.get(i)).getLayoutY() + speed + ((ImageView) drop.get(i)).getLayoutY() / 150 );
            //if get droped into square
            if((((ImageView) drop.get(i)).getLayoutX() > cont.getLayoutX() && ((ImageView) drop.get(i)).getLayoutX() < cont.getLayoutX() + 70) &&
                    ((ImageView) drop.get(i)).getLayoutY() >= 600  ) {
                root.getChildren().remove(((ImageView) drop.get(i)));
                drop.remove(i);
            }
            
            //if missed remove
            else if(((ImageView) drop.get(i)).getLayoutY() >= 590) {
                root.getChildren().remove(((ImageView) drop.get(i)));
                drop.remove(i);
                missed += 1;
                lblMissed.setText("SCORE: " + String.valueOf(missed));
            }
        }
    }*/

