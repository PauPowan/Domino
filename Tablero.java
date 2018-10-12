
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
        AñadirPieza(a,"izq");
        AñadirPieza(b,"izq");
        AñadirPieza(c,"izq");
        AñadirPieza(a,"derecha");
        AñadirPieza(b,"izq");
        AñadirPieza(c,"izq");
        AñadirPieza(a,"izq");
        AñadirPieza(b,"derecha");
        AñadirPieza(c,"derecha");
    }

    public void AñadirPieza(Pieza pieza,String direccion){
        if(direccion.equalsIgnoreCase("izq")){
            for(int i=piezasEnTablero;i>=0;i--){
                tablero[i+1]=tablero[i];
            }
            tablero[0]=pieza;
        }else{
            tablero[piezasEnTablero+1]=pieza;
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
