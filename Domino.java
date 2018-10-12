
/**
 * Write a description of class Domino here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Domino
{
    private Interfaz interfaz;
    private Dealer dealer;
    //bolsa.LlenarBolsa();
    public Domino()
    {   
        interfaz=new Interfaz();
        dealer=new Dealer();
        iniciarJuego();
    }

    private void iniciarJuego(){
        String opc;

        do{
            opc=interfaz.imprimirMenu();
            switch(opc){
                case "1":
                String a=interfaz.escogerJugador("A");
                String b=interfaz.escogerJugador("B");
                enfrentamientoSimple(a,b);
                break;
                case "2":
                break;
                case "3":
                System.exit(0);
                break;
                default:
                interfaz.imprimir("Digite una opción válida");
            }
        }while(opc!="3");
        System.exit(0);
    }

    public int enfrentamientoSimple(String jugA,String jugB){
        Jugador[] jugador=new Jugador[2];
        jugador[0]= new Jugador(jugA);
        jugador[1]= new Jugador(jugB);   
        int partida=1;

        do{            
            duelo(partida,jugador) ; 
        }while(partida<1);
        return 5;
    }

    public  void duelo(int partida,Jugador[] jugador){
        int turno=1;
        int turnoJugador;
        int turnosPasados=0;
        int puntaje1=0;
        int puntaje2=0;
        boolean pasoTurno=false;
        Tablero tablero=new Tablero();
        Bolsa bolsa=new Bolsa();
        bolsa.llenarBolsa();
        bolsa.barajar();
        dealer.repartirPrimerRonda(bolsa,jugador);
        turnoJugador=dealer.primerTurno(jugador);        
        do{            
            pasoTurno=jugador[turnoJugador].ponerPieza(tablero,turno,bolsa);
            if(pasoTurno){
                turnosPasados++;  
            }else{
             turnosPasados=0;
            }
            turnoJugador=cambiarTurno(turnoJugador);
            interfaz.tablero(jugador[0].getMano(),jugador[1].getMano(),tablero.getPiezasDelTablero());
            interfaz.esperarTecla();
            turno++;
        }while(turnosPasados<2);
        puntaje1=jugador[0].puntajeMano();
        puntaje2=jugador[1].puntajeMano();
    }

    public int cambiarTurno(int turno){
        int nuevoTurno;
        if (turno==0){
            nuevoTurno=1;
        }else{
            nuevoTurno=0;
        }
        return nuevoTurno;
    }

}
