import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playagain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playagain extends Actor
    {
    public void addedToWorld(World world) {
        getImage().scale(414,63);
    }
    /**
     * Act - do whatever the Playagain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
         if (Greenfoot.mouseClicked(this) )  
     {
        Greenfoot.setWorld(new Mountain());}
    }
   } 
    

