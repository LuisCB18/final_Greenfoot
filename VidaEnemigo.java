import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VidaEnemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VidaEnemigo extends Actor
{
    /**
     * Act - do whatever the VidaEnemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage imagen;
    int cont;
    String mensaje;
    int x,y;
    int height;
    int contenedor;
    public VidaEnemigo(int c,int x, int y, int height)
    {
        cont=c;
        contenedor=c;
        imagen=new GreenfootImage(250,150);
        imagen.setColor(new Color(200,200,0,255));
        imagen.setFont(new Font("Verdana",24));
        this.x=x;
        this.y=y;
        this.height=height;
        dibuja();
    }
    public void dibuja()
    {
        imagen.clear();
        imagen.setColor(new Color(200,200,0,255));
        imagen.drawRect(x,y,contenedor,height);
        imagen.fillRect(x,y,cont,height);
        imagen.setColor(new Color(255,255,255,255));
        imagen.drawString(String.valueOf(cont),25,19);
        setImage(imagen);
    }
    
    public void incrementar ()
    {
        cont++;
        dibuja();
    }
    public void decrementar()
    {
        cont--;
        dibuja();
    }
    public int obtenerValor()
    {
        return cont;
    }
    public void act()
    {
        //Add yout action code here
        
    }
}
