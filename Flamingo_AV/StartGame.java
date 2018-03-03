import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends World
{
    GreenfootImage myImage;
    GreenfootSound sound = new GreenfootSound("ThisGame.wav"); 
    /**
     * Constructor for objects of class StartGame.
     * 
     */
    public void act(){
        sound.playLoop();
        sound.setVolume(40);
        if(Greenfoot.isKeyDown("space")||Greenfoot.mouseClicked(start)
        ||Greenfoot.isKeyDown("enter")){
            sound.stop();
        }   
    }
    
    public void stopped(){
    sound.stop();
    }
    
    
    public StartGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 512, 1,false);
        prepare();
      
    }
    
    
    Start start;
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        start = new Start();
        addObject(start,523,470);
        start.setLocation(509,464);
        FlaStart flastart = new FlaStart();
        addObject(flastart,200,351);
        flastart.setLocation(252,420);
        start.setLocation(510,491);
        LogoFar logofar = new LogoFar();
        addObject(logofar,498,158);
        logofar.setLocation(490,185);
    }
}
