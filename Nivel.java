import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel extends World
{

    /**
     * Constructor for objects of class Nivel.
     * 
     */
    public lifes objLife;
    Tablero puntos;
    Tablero vidas;
    Tablero poder;
    VidaEnemigo vidaenemigo;
    public Nivel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        setPaintOrder(GameOver.class,Tablero.class,roca.class,nave.class);
        nave n1= new nave();
        addObject(n1,50,300);
        crearRocas(8);
        objLife=new lifes();
        puntos=new Tablero(0,"Puntaje:");
        vidas=new Tablero(3,"Vidas:");
        poder=new Tablero(0,"Especial:");
        addObject(puntos,150,85);
        addObject(vidas,350,85);
        addObject(poder,550,85);
    }
    public void crearRocas(int numero){
        for(int i=0;i<numero;i++){
            roca r=new roca();
            int x=Greenfoot.getRandomNumber(getWidth());
            int y=Greenfoot.getRandomNumber(getHeight());
            addObject(r,x,y);
        }
    }
    
    public void ponerJefe()
    {
        List<roca>rocas=getObjects(roca.class);
        //List<Actor> actors = (List<Actor>)getObjects(Soldier.class);
        Iterator i=rocas.iterator();
        while(i.hasNext())
        {
            roca r=(roca)i.next();
            removeObject(r);
        }
        Enemigo boss=new Enemigo();
        addObject(boss,getWidth()-80, (getHeight()/2)+20);
        vidaenemigo=new VidaEnemigo(100,0,0,20);
        addObject(vidaenemigo,750,85);
    }
    
    /**
     * Prepare the world for the star of the program. That is: create the initial 
     * objects and add them to the world.
     */
    private void prepare()
    {
    }
}
