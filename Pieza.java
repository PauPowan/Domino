
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

    private void darVuelta(){
        int temp=this.valorIzquierda;
        this.valorIzquierda=this.valorDerecha;
        this.valorDerecha=temp;
    }
    public void setPieza(Pieza p){
        
        this.valorIzquierda=p.getIzquierda();
        this.valorDerecha=p.getDerecha();
    }
    public String toString(){
       return "["+valorIzquierda+"|"+valorDerecha+"]";
    }
}
