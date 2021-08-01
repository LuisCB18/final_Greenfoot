import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class roca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class roca extends Actor
{
    /**
     * Act - do whatever the roca wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(2);
        World m=getWorld();
        if(getX()>=m.getWidth()-5||getX()<=5){
            turn(180);
            if (Greenfoot.getRandomNumber(100)<90){
            turn(Greenfoot.getRandomNumber(90-45));
        }
        }
        if (getY()>=m.getHeight()-5||getX()<=5){
            turn(180);
            if (Greenfoot.getRandomNumber(100)<90){
            turn(Greenfoot.getRandomNumber(90-45));
        }
        }
        Actor nave=getOneObjectAtOffset(0,0,nave.class);
        if (nave!=null){
            Nivel esp=(Nivel)getWorld();
            getWorld().removeObject(nave);
            esp.vidas.decrementar();
            getWorld().addObject(new nave(),50,300);
            if (esp.vidas.obtenerValor()==0){
                GameOver t=new GameOver();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
            }
        }
    }
}
