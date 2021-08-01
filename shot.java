import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shot extends Actor
{
    /**
     * Act - do whatever the shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int shotImage=1;
    int speedShot=6;
    int position;
    public shot(int direction){
        position=direction;
    }
    public void act()
    {
        setImage("fff.png");
        switch(position){
            case 0:
                setLocation(getX(),getY()-speedShot);
            break;
            case 1:
                setLocation(getX(),getY()+speedShot);
            break;
            case 2:
                setLocation(getX()+speedShot,getY());
            break;
            case 3:
                setLocation(getX()-speedShot,getY());
            break;
                
        }
        
        
        
        Actor roca=getOneObjectAtOffset(0,0,roca.class);
        Enemigo boss=(Enemigo)getOneIntersectingObject(Enemigo.class);
        if (roca!=null){
            Nivel esp=(Nivel)getWorld();
            esp.puntos.incrementar();
            esp.crearRocas(1);
            getWorld().removeObject(roca);
            if (esp.puntos.obtenerValor()%10==0)
            esp.ponerJefe();
            esp.removeObject(this);
        }
        else if(boss!=null)
        {
           Nivel esp=(Nivel)getWorld();
           esp.vidaenemigo.decrementar();
           if(esp.vidaenemigo.obtenerValor()==0)
           
        
        {
            esp.removeObject(boss);
            esp.crearRocas(5);
            esp.vidas.incrementar();
            esp.removeObject(esp.vidaenemigo);
        }
        esp.removeObject(this);
    }
    else
    {
        if ((getX()>=getWorld().getWidth()-5)||(getX()<=5)){
            getWorld().removeObject(this);
        }
        else{
        if ((getY()>=getWorld().getHeight()-5)||(getX()<=5)){
            getWorld().removeObject(this);
        }
        else
            if(shotImage<16)
            shotImage++;
            else
            shotImage=1;
    }
}
}}
