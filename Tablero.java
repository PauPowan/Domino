
/**
 * Write a description of class Tablero here.
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
        tablero= new Pieza[28];
        piezasEnTablero=0;
    }
    public void Ej(){
        Pieza a =new Pieza(1,2);
        Pieza b =new Pieza(4,4);
        Pieza c =new Pieza(5,6);
        AñadirPieza(a,1);
        AñadirPieza(b,1);
        AñadirPieza(c,1);
        AñadirPieza(a,-1);
        AñadirPieza(b,1);
        AñadirPieza(c,1);
        AñadirPieza(a,1);
        AñadirPieza(b,-1);
        AñadirPieza(c,-1);
    }
    public void AñadirPieza(Pieza pieza,int direccion){
        if(direccion==-1){
            for(int i=piezasEnTablero;i>=0;i--){
                tablero[i+1]=tablero[i];
            }
            tablero[0]=pieza;
        }else{
            tablero[piezasEnTablero]=pieza;
        }
        piezasEnTablero++;
    }

    public void VaciarTablero(){
        for(int i=0;i<=piezasEnTablero;i++){
            tablero[i]=null;
        }
        piezasEnTablero=0;
    }

    public Pieza[] GetPiezasDelTablero(){
        return tablero;
    }

    public int GetCantidadDePiezas(){
        return piezasEnTablero;
    }
}
