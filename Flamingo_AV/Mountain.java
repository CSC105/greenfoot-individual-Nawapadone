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
    private static final String view = "images/mountain2.png";
    private static final double scrollSpeed = 1;
    private static final int picWidth = (new GreenfootImage(view)).getWidth();
    
    private GreenfootImage bgImage, bgBase;
    private double scrollPosition = 0;
    
    int counter= 0;
    
    
    // FOR GAME OVER
    public boolean gameEnded = false;
    public boolean shouldAddBox = true;
    public ArrayList<Material> boxes;
    
    GreenfootSound sound = new GreenfootSound("Far.wav");
  
    
    /**
     * Constructor for objects of class Mountain.
     * 
     */
    public Mountain()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 512, 1,false); 
        prepare();
        setBackground(view);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        
        setPaintOrder(Material.class,Flamingo.class);
        
        boxes = new ArrayList<>();
    }
    
    public void act()
    {
        //Greenfoot.playSound("theme.wav");
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint((int) scrollPosition);
        
        sound.playLoop();
        sound.setVolume(20);
        if(gameEnded == true){
          sound.stop();
        }
      
        counter++;
        //System.out.println(counter);
        if(shouldAddBox && counter == 85){
            if(Greenfoot.getRandomNumber(4)==0){
             Material material2 = new Material2();
                addObject(material2,getWidth(),427);
                counter = Greenfoot.getRandomNumber(48);
                boxes.add(material2);
            }else{
                Material material = new Material();
                addObject(material,getWidth(),455);
                counter = Greenfoot.getRandomNumber(48);
                boxes.add(material);
            }
       }
       
       /*if(ground.getX() <= -ground.getImage().getWidth() / 2 ){
           removeObject(ground);
       }
       if (ground.getX() <= ground.getImage().getWidth() / 2) {
           Ground g = new Ground();
           addObject(g, getWidth() + ground.getImage().getWidth() / 2, 258);
        }*/
        for (int i = 0; i < ground.length; i++) {
            if (ground[i].getX() <= -512) {
                int diff = Math.abs(ground[i].getX() - (-512));
                ground[i].setLocation(getWidth() + 512 - diff, ground[i].getY());
            }
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
    public Ground[] ground;
        
    public Flamingo fla;
    private void prepare()
    {
        fla = new Flamingo();
        addObject(fla,252,420);
        Counter counter = new Counter();
        addObject(counter,952,45);
        HightScore hightscore = new HightScore();
        addObject(hightscore,833,100);
        hightscore.setLocation(933,33);
        counter.setLocation(936,69);
        
        ground = new Ground[2];
        
        ground[0] = new Ground();
        addObject(ground[0], getWidth() / 2, 258);
        
        ground[1] = new Ground();
        addObject(ground[1], (int) (getWidth() * 1.5), 258);
        //addObject(ground,512,258);

    }
    
    public void stopped(){
    sound.stop();
    }
    
    public void started() {
        // reset world
        if (gameEnded)
            Greenfoot.setWorld(new Mountain());
    }
}
