import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class flamingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamingo extends Actor
{
    /**
     * Act - do whatever the flamingo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int ySpeed;
    
   GreenfootImage[] images = new GreenfootImage[36];
   int imageNumber;
   
 //comment
   public Flamingo()
    {
        for( int i=0; i<images.length; i++ ) {
        images[i] = new GreenfootImage( "images/flamingo/Flamingo" + (i+1) + ".png" );
        images[i].scale(90,145);
        setImage( images[imageNumber] );
    }
    }

   public void Animation(){
        imageNumber = ( imageNumber + 1 ) % images.length;
        setImage( images[imageNumber] );
     }
    
    boolean cheatKeyPressed = true;
    boolean cheatMode = false;
    
    boolean jumpPressed = false;
    int jumpCount = 0;
    static final int MAX_JUMP = 2;
    
    public void Jump(){
        // Add your action code here.
        int groundLevel = 420;
        boolean onGround = (getY() == groundLevel);
        if (!onGround) // in middle of jump
        {
            ySpeed++; // adds gravity effect
            setLocation(getX(), getY()+ySpeed); // fall (rising slower or falling faster)
            if (getY()>=groundLevel) // has landed (reached ground level)
            {
            setLocation(getX(), groundLevel); // set on ground
            // clears any key pressed during jump
           }
        }
        else // on ground
        {
            jumpCount = 0;
        }
        
        if (Greenfoot.isKeyDown("c")) {
            if (cheatKeyPressed == false) {
                cheatMode = !cheatMode;
                cheatKeyPressed = true;
            }
        }
        else
            cheatKeyPressed = false;
        
        if (Greenfoot.isKeyDown("space")) // jump key detected
            {
                if (jumpPressed == false && (cheatMode || jumpCount < MAX_JUMP)) {
                    jumpPressed = true;
                    jumpCount++;
                    ySpeed = -18; // add jump speed
                    setLocation(getX(), getY()+ySpeed); // leave ground
                }
            }
            else {
                jumpPressed = false;
            }
    }
    
     
    public void act() 
    {
       Jump();
       Animation();
      
    }  
    
}
