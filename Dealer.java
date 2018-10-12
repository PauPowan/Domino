
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
            darPieza(jug,bolsa);
        }
    }

    public void darPieza(Jugador jug,Bolsa bolsa){
        Pieza piezaADar=new Pieza(-1,-1);
        piezaADar.setPieza(bolsa.sacarPieza());
        jug.tomarPieza(piezaADar);
    }

    public void repartirPrimerRonda(Bolsa bolsa,Jugador[] jugador){
        Boolean par=false;
        do{
            bolsa.llenarBolsa();
            bolsa.barajar();
            Repartir(jugador[0],bolsa);
            Repartir(jugador[1],bolsa);
            if(jugador[0].existePar()||jugador[1].existePar()){
                par=true;
            }else{
                jugador[0].vaciarMano();
                jugador[1].vaciarMano();
            }           
        }while(!par);
    }
    
    public int primerTurno(Jugador[] jugador){
        int jugadorDePiezaMayor;
        if(jugador[0].parMayor()[0]>jugador[1].parMayor()[0]){
            jugadorDePiezaMayor=0;
        }else{
            jugadorDePiezaMayor=1;
        }
        return jugadorDePiezaMayor;
    }
    public void IniciarJuego(){

    }

}
