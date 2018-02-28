import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playagain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playagain extends Actor
    {
    boolean mouseOver = false;
    public void addedToWorld(World world) {
        getImage().scale(414,63);
    }
    /**
     * Act - do whatever the Playagain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    final int WAIT_TIME = 50;
    int num = 0; 
    
    public void act() 
    {
        // Add your action code here. 
        MouseInfo mouse = Greenfoot.getMouseInfo();  
         
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("playagain1.png");
            getImage().scale(414,63);
            mouseOver = true;  
         }  
         if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("playagain2.png");
             getImage().scale(414,63);
             mouseOver = false;  
         } 
         
          //WAIT 20 frames then allow clicking
        if (num < WAIT_TIME) {
            num++;
            return;
        }
        
         if (Greenfoot.mouseClicked(this) )  
      {
        
           Greenfoot.setWorld(new Mountain());
           num = 0;
        
      }
         if (Greenfoot.isKeyDown("space") )  
      {  
           
           Greenfoot.setWorld(new Mountain());
           num = 0;
          
      } 
      
       
    }
   } 
    

