
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

    public int getIzquierda()
    {
        return  valorIzquierda;
    }

    public int getDerecha()
    {
        return  valorDerecha;
    }
    /**
     * @Funcion: Ve cual lado de la pieza es el que se va a utilizar.
     * @Param: valorBorde, int, se usa para evaluar el borde de la ficha del tablero y acomodar la nueva ficha con el borde adecuado  
     * @Param: lado, string, se usa para evaluar el lado en el que se va a poner la ficha  
     */
    public void acomodarPieza(int valorBorde,String lado){
        if(lado=="izq"){
            if(this.valorIzquierda==valorBorde){
                darVuelta();
            }
        }else{
            if(this.valorDerecha==valorBorde){
                darVuelta();
            }
        }
    }
    public int getValorPieza(){
        int puntajeTotal=0;
        puntajeTotal+=this.getDerecha();
        puntajeTotal+=this.getIzquierda();
        return puntajeTotal;
    }
    /**
     * @Funcion: Gira la pieza
     */
    private void darVuelta(){
        int temp=this.valorIzquierda;
        this.valorIzquierda=this.valorDerecha;
        this.valorDerecha=temp;
    }
    public void setPieza(Pieza p){
        
        this.valorIzquierda=p.getIzquierda();
        this.valorDerecha=p.getDerecha();
    }
    
    /**
     * Funcion: Imprime el valor de la pieza.
     */
    public String toString(){
       return "["+valorIzquierda+"|"+valorDerecha+"]";
    }
}
