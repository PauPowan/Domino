
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

    public int[] calcularGanadorYPuntaje(Jugador[] jugador){
        int ganador[]= new int[2];

        int punt1=jugador[0].getPuntajeMano();
        int punt2=jugador[1].getPuntajeMano();
        if(punt1<=punt2){
            ganador[0]=0;
            ganador[1]=punt2;
        }else{
            ganador[0]=1;
            ganador[1]=punt1;
        }
        jugador[ganador[0]].sumarPuntos(ganador[1]);
        return ganador;
    }
}

