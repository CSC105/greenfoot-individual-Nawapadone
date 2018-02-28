import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HightScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HightScore extends Actor
{
    /**
     * Act - do whatever the HightScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HightScore(){
     setImage(new GreenfootImage("HS " + String.format("%05d", (int)Counter.score2), 32, new Color(255,255,255), new Color(0, 0, 0, 0)));
    }
    public void act() 
    {
        
    }    
}
