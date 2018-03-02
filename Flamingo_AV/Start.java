import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
     boolean mouseOver = false;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        MouseInfo mouse = Greenfoot.getMouseInfo();  
         
        
         if (Greenfoot.mouseClicked(this)
         ||Greenfoot.isKeyDown("space") 
         ||Greenfoot.isKeyDown("enter"))  
      {
           Greenfoot.setWorld(new Mountain());    
      }
      
        
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("Start1.png");
            mouseOver = true;  
         }  
         if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("Start2.png");
             mouseOver = false;  
         } 
    }    
}
