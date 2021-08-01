import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int velocidad=4;
    int direccion=1;
    boolean cambia =false;
    public void act()
    {
        if(getRotation()!=180)
        setRotation(180);
        
        if(getY()>=30 && !cambia)
        {
            direccion=-1;
        }
        else
        {
            cambia=true;
        }
        if (getY()<=getWorld().getHeight()-30 && cambia)
        {
            direccion=1;
        }
        else
        {
            cambia=false;
        }
        setLocation(getX(),getY()+(velocidad*direccion));
        reglas();
        
        int x=Greenfoot.getRandomNumber(50);
        
        if(x==25)
        {
            BossAtack attack=new BossAtack(2);
            
            getWorld().addObject(attack,getX()-10,getY());
        }
        
    }
    
    public void incVelocidad()
    {
        velocidad++;
        
    }
    
    private void reglas()
    {
        nave n=(nave)getOneIntersectingObject(nave.class);
        if(n!=null)
        {
            Nivel esp=(Nivel)getWorld();
            esp.removeObject(n);
            esp.addObject(new nave(),50,300);
            esp.vidas.decrementar();
            if(esp.vidas.obtenerValor()==0){
                GameOver t=new GameOver();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
            }
        }
    }
    

}
