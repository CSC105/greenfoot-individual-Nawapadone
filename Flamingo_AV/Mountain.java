import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Mountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mountain extends World
{
    private static final String bgImageName = "images/mountain.png";
    private static final double scrollSpeed = 1;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    
    private GreenfootImage bgImage, bgBase;
    private double scrollPosition = 0;
    
    int counter= 0;
    
    // FOR GAME OVER
    public boolean gameEnded = false;
    public boolean shouldAddBox = true;
    public ArrayList<Material> boxes;
    
    /**
     * Constructor for objects of class Mountain.
     * 
     */
    public Mountain()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 512, 1,false); 
        prepare();
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        
        boxes = new ArrayList<>();
    }
    
    public void act()
    {
		//Greenfoot.playSound("theme.wav");
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint((int) scrollPosition);
        
        counter++;
        //System.out.println(counter);
        if(shouldAddBox && counter == 80){
        Material material = new Material();
        addObject(material,getWidth(),455);
        counter = Greenfoot.getRandomNumber(50);
        boxes.add(material);
       }
    
        //System.out.println(counter);
        
    }
    
     private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
  
    public Flamingo fla;
    private void prepare()
    {

        fla = new Flamingo();
        addObject(fla,252,420);

    }
    
    public void started() {
        // reset world
        if (gameEnded)
            Greenfoot.setWorld(new Mountain());
    }
}
