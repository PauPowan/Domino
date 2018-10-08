
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

    public Pieza QuitarPieza(int numeroPieza){
        Pieza piezaASacar=mano[piezasEnMano];
        mano[numeroPieza]=null;
        piezasEnMano--;
        return piezaASacar;
    }

}
