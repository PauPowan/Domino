
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
                torneo();
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

    public Jugador enfrentamientoSimple(String jugA,String jugB){
        Jugador[] jugador=new Jugador[2];
        jugador[0]= new Jugador(jugA);
        jugador[1]= new Jugador(jugB);   
        int partida=1;
        int ganador;

        do{            
            ganador=duelo(partida,jugador) ; 
            partida++;
            jugador[0].vaciarMano();
            jugador[1].vaciarMano();
        }while(jugador[ganador].getPuntos()<100);
        interfaz.ganador(ganador+1);
        return jugador[ganador];
    }

    public  int duelo(int partida,Jugador[] jugador){
        int[] ganador= new int[2];
        int turno=1;
        int turnoJugador;
        int turnosPasados=0;
        int puntaje1=0;
        int puntaje2=0;
        boolean pasoTurno=false;
        Tablero tablero=new Tablero();
        Bolsa bolsa=new Bolsa();
        dealer.repartirPrimerRonda(bolsa,jugador);
        turnoJugador=dealer.primerTurno(jugador);
        interfaz.partida(partida);
        do{            
            pasoTurno=jugador[turnoJugador].ponerPieza(tablero,turno,bolsa);
            if(pasoTurno){
                turnosPasados++;  
            }else{
                turnosPasados=0;
            }
            interfaz.tablero(jugador[0].getMano(),jugador[1].getMano(),tablero.getPiezasDelTablero(),turno,bolsa.getBolsa());
            
            if(jugador[turnoJugador].getPiezasEnMano()==0){
                turnosPasados=2;
            }else{
                turnoJugador=cambiarTurno(turnoJugador);
                turno++;
            }
            
        }while(turnosPasados<2);
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
    public void torneo(){
        String[] tipos={"1","2","3","3"};
        barajar(tipos);
        String j1=tipos[3];
        String j2=tipos[1];
        String j3=tipos[2];
        String j4=tipos[0];
        Jugador ganador1=enfrentamientoSimple(j1,j2);
        Jugador ganador2=enfrentamientoSimple(j3,j4);
        enfrentamientoSimple(ganador1.getEstrategia(),ganador2.getEstrategia());
    }
    private void barajar(String[] tipos){
        int Temp1;
        int Temp2;
        for(int i=0;i<10;i++){
            Temp1=(int)(Math.random()*tipos.length);
            Temp2=(int)(Math.random()*tipos.length);
            swap(Temp1,Temp2,tipos);
        }
    }

    private void swap(int posicion1,int posicion2,String[] tipos){
        String temp="";
        temp=tipos[posicion1];
        tipos[posicion1]=tipos[posicion2];
        tipos[posicion2]=temp;
    }
}
