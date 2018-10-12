
/**
-Reparte Cartas
 */
public class Dealer
{
    
    public Dealer()
    {

    }
    public void Repartir(Jugador jug,Bolsa bolsa){
        Pieza piezaASacar;
        for(int i=0;i<7;i++){
            DarPieza(jug,bolsa);
        }
    }
    public void DarPieza(Jugador jug,Bolsa bolsa){
        Pieza piezaADar;
        piezaADar=bolsa.SacarPieza();
        jug.TomarPieza(piezaADar);
    }
    
    public void IniciarJuego(){
        
    }
   
}
