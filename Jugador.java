
/**
 Jugador 
 */
public class Jugador
{
    private Pieza[] mano;
    private int puntos;
    private int piezasEnMano;
    private String estrategia;
    public Jugador(String numeroJugador)
    {
        mano= new Pieza[21];
        piezasEnMano=0;
        puntos=0;
        estrategia=numeroJugador;
    }
    public void TomarPieza(Pieza pieza){
        mano[piezasEnMano]=pieza;
        piezasEnMano++;
    }

    public Pieza DarPieza(int numeroPieza){
        Pieza piezaASacar=mano[piezasEnMano];
        mano[numeroPieza]=null;
        piezasEnMano--;
        return piezaASacar;
    }
    public void ReiniciarMano(){
        for(int i=0;i<piezasEnMano;i++){ //Aquiiiiiiiiiiiiiiiiiiiiiiii
            
        }
    }
    
    public boolean ExistePar(){
        Boolean par=false;
        for(int i=0;i<piezasEnMano;i++){
            if(mano[i].GetIzquierda()==mano[i].GetDerecha()){
                par=true;
            }
        }
        return par;
    }
}
