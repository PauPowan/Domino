
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
                String a=interfaz.escogerJugador("1");
                String b=interfaz.escogerJugador("2");
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
        int ganador;

        do{            
            ganador=duelo(partida,jugador) ; 
            partida++;
        }while(jugador[ganador].getPuntos()<100);
        interfaz.ganador(ganador+1);
        return ganador;
    }

    public  int duelo(int partida,Jugador[] jugador){
        int[] ganador= new int[2];
        int turno=1;
        int turnoJugador;
        int turnosPasados=0;
        int puntaje1=0;
        int puntaje2=0;
        boolean valido=true;
        int[] posicion=new int[2];        
        boolean pasoTurno=false;
        Tablero tablero=new Tablero();
        Bolsa bolsa=new Bolsa();
        bolsa.llenarBolsa();
        bolsa.barajar();
        dealer.repartirPrimerRonda(bolsa,jugador);
        turnoJugador=dealer.primerTurno(jugador);
        interfaz.partida(partida);
        do{ 

            if(jugador[turnoJugador].getEstrategia().equals("4")&&turno!=1){
                interfaz.tablero(jugador[0].getMano(),jugador[1].getMano(),jugador[0].getEstrategia(),jugador[1].getEstrategia(),tablero.getPiezasDelTablero(),turno);
                do{
                    if(!valido){
                        interfaz.noValida(); 
                    }
                    posicion=interfaz.preguntar(jugador[turnoJugador].getPiezasEnMano(),turnoJugador);
                    if(posicion[0]==0||bolsa.getPiezasTotales()>0){
                        turnosPasados++;
                        valido=true;
                    }else{
                        valido=jugador[turnoJugador].dummy(tablero,turno,bolsa,posicion);
                    }
                }while(!valido);
            }else{    
                pasoTurno=jugador[turnoJugador].ponerPieza(tablero,turno,bolsa);
                interfaz.tablero(jugador[0].getMano(),jugador[1].getMano(),jugador[0].getEstrategia(),jugador[1].getEstrategia(),tablero.getPiezasDelTablero(),turno);
                if(pasoTurno){
                    turnosPasados++;  
                }else{
                    turnosPasados=0;
                }
            }
            if(jugador[turnoJugador].getPiezasEnMano()==0){
                turnosPasados=2;
            }else{
                turnoJugador=cambiarTurno(turnoJugador);
                turno++;
            }

        }while(turnosPasados<2&&bolsa.getPiezasTotales()<28);
        ganador=dealer.calcularGanadorYPuntaje(jugador);
        interfaz.ganadorPartida(ganador[0]+1,ganador[1]);
        return ganador[0];
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
