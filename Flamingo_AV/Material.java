import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Material here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Material extends Actor
{
    Mountain mountain;
    static int num=8;
    static int cNum=0;
    public void addedToWorld(World world) {
        if (world instanceof Mountain)
            this.mountain = (Mountain) world;
    }
    
    public boolean Touch(){
        Actor t = getOneObjectAtOffset(0, 0, Flamingo.class);
        if (t!=null)
        {
            //do something
            //world.removeObject(); 
            mountain.removeObject(mountain.fla);
            //mountain.removeObject(this);
            mountain.gameEnded = true;
            for (int i = 0; i < mountain.boxes.size(); i++) {
                Material m = mountain.boxes.get(i); // item @ index i in ArrayList
                mountain.removeObject(m);
            }
            mountain.shouldAddBox = false;
            //Greenfoot.stop();
            mountain.addObject(new GameOver(), mountain.getWidth()/2, mountain.getHeight()/2);
            mountain.addObject(new Playagain(), mountain.getWidth()/2,mountain.getHeight()-50);
            num = 8;
            return true;
        }
        return false;
    }
        
    public void act() 
    {
        // Add your action code here.
        cNum++;
        if(cNum==500){
            num = num+1;
            cNum = 0;
        }
        //System.out.println(num);
        boolean touched = Touch();
        if (!touched) {
            MoveBox();
        }
    }
   
     public void MoveBox(){
         setLocation(getX()-num, getY());

        if (getX() <= -30)
            getWorld().removeObject(this);   
        }
 }
