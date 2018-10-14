
/**
 * Brinda donde jugar al domino 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tablero
{
    private Pieza tablero[];
    private int piezasEnTablero;
    public Tablero()
    {
        tablero= new Pieza[29];
        piezasEnTablero=0;
    }
    
    /**
     * @Funcion: Indica donde poner la pieza
     * @Param: pieza, objeto de tipo Pieza, se usa para obtener las fichas que se van a agregar 
     * @Param: direccion, string, se usa para colocar la ficha a la izq o a la derecha en el tablero
     */
    public void agregarPieza(Pieza pieza,String direccion){
        int posicion=0;
        if(direccion.equalsIgnoreCase("izq")){
            for(int i=piezasEnTablero;i>0;i--){
                tablero[i]=new Pieza(-1,-1);
                tablero[i].setPieza(tablero[i-1]);
                tablero[i-1]=null;
            }          
        }else{
            posicion=piezasEnTablero;
        }
        tablero[posicion]=new Pieza(-1,-1);
        tablero[posicion].setPieza(pieza);
        piezasEnTablero++;
    }
    /**
     *@Funcion: Limpia el tablero. 
     */
    public void vaciarTablero(){
        for(int i=0;i<=piezasEnTablero;i++){
            tablero[i]=null;
        }
        piezasEnTablero=0;
    }

    public Pieza[] getPiezasDelTablero(){
        return tablero;
    }

    public int getCantidadDePiezas(){
        return piezasEnTablero;
    }

    public int getValorPiezaIzquierda(){
        int izq;
        if(tablero[0]==null){
            izq=0;
        }else{
         izq=tablero[0].getIzquierda();
        }
        return izq;
    }

    public int getValorPiezaDerecha(){
        int der;
        if(piezasEnTablero==0){
            der=0;
        }else{
         der=tablero[piezasEnTablero-1].getDerecha();
        }
        return der;
       
    }
}
