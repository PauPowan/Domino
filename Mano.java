
/**
 Piezas que posee el jugador.
 */
public class Mano
{
    private int piezasEnMano;
    private Pieza mano[];
    public Mano()
    {
      piezasEnMano=0;  
      mano= new Pieza[21];
    }
    public void AñadirPieza(Pieza pieza){
        mano[piezasEnMano]=pieza;
        piezasEnMano++;
    }
    public void QuitarPieza(int numeroPieza){
        mano[numeroPieza]=null;
        piezasEnMano--;
    }
    public void Imprimir(){
       for(int i=0;i<piezasEnMano;i++){
       System.out.println("["+mano[i].GetIzquierda()+"|"+mano[i].GetDerecha()+"]");
    }
    }
}
