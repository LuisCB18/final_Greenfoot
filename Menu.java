import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Menú para poder acceder al juego o salir del juego.
 * 
 * Luis Gerardo Contreras Barrios
 * 
 */
public class Menu extends World
{
    Flecha flecha= new Flecha();
    private int opcion=0; // 0 = jugar y 1 = salir 
    
    public Menu()
    {
        super(800,600,1);
        prepararMundo();
        
    }
    
    private void prepararMundo(){
        addObject(new Jugar(),400,250);
        addObject(new Salir(),400,350);
        addObject(flecha,275,250);
        
    }
    public void act(){
        if (Greenfoot.isKeyDown("UP") && opcion!=0){opcion++;}
        if (Greenfoot.isKeyDown("DOWN") && opcion!=1) {opcion--;}
        
        if (opcion>=2) opcion=0;
        if (opcion<0) opcion=1;
        
        flecha.setLocation(275,250+(opcion*100));
        
        if (Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")){
            switch(opcion){
                case 0: 
                    Greenfoot.setWorld(new Nivel());
                    break;
                case 1:
                    Greenfoot.stop();
                    break;   
            }
        }
    }
}
