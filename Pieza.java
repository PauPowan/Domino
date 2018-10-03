
/**
  Clase para cada Pieza del juego.
 */
public class Pieza
{
    private int valorIzquierda;
    private int valorDerecha;
    public Pieza(int izq,int der)
    {
     valorIzquierda =izq;
     valorDerecha = der;
        
    }

    
    public int GetIzquierda()
    {
        return  valorIzquierda;
    }
    public int GetDerecha()
    {
        return  valorDerecha;
    }
    
   
    
}
