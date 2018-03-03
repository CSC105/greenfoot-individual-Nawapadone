import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlaStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlaStart extends Actor
{
    /**
     * Act - do whatever the FlaStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     GreenfootImage[] images = new GreenfootImage[36];
   int imageNumber;
    /*public Actor getOneObjectAtOffset(int dx, int dy, java.lang.Class<?> cls) {
        return super.getOneObjectAtOffset(dx, dy, cls);
    }*/
    
   public void Animation(){
        imageNumber = ( imageNumber + 1) % images.length;
        setImage( images[imageNumber] );
     }
    public void act() 
    {
        // Add your action code here.
        Animation();
    }
    public FlaStart()
    {
      for( int i=0; i<images.length; i++ ) {
        images[i] = new GreenfootImage( "images/flamingo/Flamingo" + (i+1) + ".png" );
        images[i].scale(90,145);
        setImage( images[imageNumber] ); 
    }
   }
}