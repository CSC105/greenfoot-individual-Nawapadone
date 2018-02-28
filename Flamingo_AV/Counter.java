import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    double score1 = 0;
    public static double score2 = 0;
     Mountain mountain;
     public void addedToWorld(World world) {
        if (world instanceof Mountain)
            this.mountain = (Mountain) world;
    }
    public Counter(){
     setImage(new GreenfootImage("S   " + String.format("%05d", (int) score1), 32, new Color(255,255,255), new Color(0, 0, 0, 0)));
    }
    
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(mountain.gameEnded == false){
            score1= (score1+0.1);
        }
        if(score1>=score2){
            score2 = score1;
        }
        
        //System.out.println(mountain.gameEnded);
       
        setImage(new GreenfootImage("S   " + String.format("%05d", (int)score1), 32, new Color(255,255,255), new Color(0, 0, 0, 0)));
        
    }    
}
