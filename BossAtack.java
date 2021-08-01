import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossAtack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossAtack extends Actor
{
    /**
     * Act - do whatever the BossAtack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int direccion;
    public BossAtack(int dir)
    {
        direccion=dir;
        if(dir==1)
        turn (0);
        else 
        turn(180);
        
    }
    public void act()
    {
        // Add your action code here.
        
        move(4);
        
        nave nav=(nave)getOneObjectAtOffset(0,0,nave.class);
        if(nav!=null)
        {
            Nivel esp=(Nivel)getWorld();
            getWorld().removeObject(nav);
            esp.vidas.decrementar();
            getWorld().addObject(new nave(),50,300);
            if(esp.vidas.obtenerValor()==0){
                GameOver t=new GameOver();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
                
            }
            getWorld().removeObject(this);
        }
        else if((getX()>=getWorld().getWidth()-5) ||(getX()<=5))
        {
            getWorld().removeObject(this);
        }
    }
}
