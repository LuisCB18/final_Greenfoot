import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nave extends Actor
{
    public static final int UP=0;
    public static final int DOWN=1;
    public static final int LEFT=2;
    public static final int RIGHT=3;
    int directionShot=2;
    boolean isShot=false;
    public void nave(){
        
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("up")){
            setDireccion(UP);
            directionShot=0;
        }
        if (Greenfoot.isKeyDown("down")){
            setDireccion(DOWN);
            directionShot=1;
        }
        if (Greenfoot.isKeyDown("left")){
            setDireccion(LEFT);
            directionShot=3;
        }
        if(Greenfoot.isKeyDown("right")){
            setDireccion(RIGHT);
            directionShot=2;
        }
        setShot(directionShot);
        
    }
    public void setShot(int direction){
        if(isShot && Greenfoot.isKeyDown("x")){
            shot s1= new shot (direction);
            getWorld().addObject(s1,getX(),getY());
            isShot=false; 

        }
        if(!isShot && !Greenfoot.isKeyDown("x")){
            isShot=true;
        }
        
    }
    public void setDireccion(int direccion){
        switch(direccion){
            case UP:
                setRotation(270);
                if (Greenfoot.isKeyDown("space")){
                setLocation(getX(),getY()-10);
        }
        else{
            setLocation(getX(),getY()-10);
        }
            break;
            case DOWN:
            setRotation(90);
            if (Greenfoot.isKeyDown("space")){
            setLocation(getX(),getY()+10);
        }
        else{
            setLocation(getX(),getY()+10);
        }
            break;
            case LEFT:
                setRotation(180);
                if (Greenfoot.isKeyDown("space")){
                setLocation(getX()-10,getY());
        }else{
            setLocation(getX()-10,getY());
        }
            break;
            case RIGHT:
            setRotation(0);
            if(Greenfoot.isKeyDown("space")){
            setLocation(getX()+1,getY());
        }else{
            setLocation(getX()+10,getY());
        }
            break;
        }
    }
}

