
/**
 * Contiene las opciones del juego. 
 */
public class Domino{
    private Interfaz interfaz;
    private Dealer dealer;
    
    public Domino()
    {   
        interfaz=new Interfaz();
        dealer=new Dealer();
        iniciarJuego();
    }
    /**
     * @Funcion: Brinda la interfaz para que se pueda crear la partida.
     */
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
               
            }
        }while(opc!="3");
        System.exit(0);
    }
    /**
     * @Funcion: Crea una partida entre los jugadores que se indiquen.
     * @Param: jugA, string, se usa para definir la estrategia que va a usar cada jugador. 
     * @Param: jugB, string, se usa para definir la estrategia que va a usar cada jugador. 
     * @Return: retorna el ganador del enfrentamiento. 
     */
    
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
        } while(jugador[ganador].getPuntos()<100);
        interfaz.ganador(ganador+1);
        return jugador[ganador];
    }
    /**
     *@Funcion: Agarra las estrategias y empieza a crear una forma de juego conforme a las fichas.
     *@Param: partida, int, usado para indicar el numero de partida.  
     *@Param: jugador, vector de objeto Jugador, se usa para obtener los jugadores.  
     *@Return: retorna la posicion del ganador en el vector de jugadores. 
     */
    public int duelo(int partida,Jugador[] jugador){
        int[] ganador= new int[2];
        int turno=1;
        int turnoJugador;
        int turnosPasados=-1;
        int puntaje1=0;
        int puntaje2=0;
        int piezasActualesTableros;
        boolean valido=true;
        int[] posicion=new int[2];        
        boolean pasoTurno=false;
        Tablero tablero=new Tablero();
        Bolsa bolsa=new Bolsa();
        dealer.repartirPrimerRonda(bolsa,jugador);
        turnoJugador=dealer.primerTurno(jugador);
        interfaz.partida(partida);
       do{ 
            if(jugador[turnoJugador].getEstrategia().equals("4")&&turno!=1){
                piezasActualesTableros=tablero.getCantidadDePiezas();
                do{
                    interfaz.tablero(jugador[0].getMano(),jugador[1].getMano(),jugador[0].getEstrategia(),jugador[1].getEstrategia(),tablero.getPiezasDelTablero(),turno);
                    pasoTurno=jugador[turnoJugador].dummy(tablero,bolsa,interfaz,turnoJugador);
                }while(piezasActualesTableros==tablero.getCantidadDePiezas()&&!pasoTurno);
               
                if(pasoTurno){
                    turnosPasados++;
                    valido=true;
                }else{
                    turnosPasados=0;
                }
            
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

    /**
     * @Funcion: Lleva el control de los turnos. 
     * @Return: cambia de turno. 
     */
    public int cambiarTurno(int turno){
        int nuevoTurno;
       if (turno==0){
            nuevoTurno=1;
        }else{
            nuevoTurno=0;
       }
       return nuevoTurno;
    }
    /**
     * @Funcion: Crea la modalidad de torneo en donde se crean parejas aleatorias en la primera ronda, 
     * @Funcion: el que gana pasa a la siguiente ronda y el que pierde queda fuera y esto se repite hasta que haya un ganador.  
     */
    public void torneo(){
        String[] tipos={"1","2","3","4"};
        barajar(tipos);
        String j1=tipos[3];
        String j2=tipos[1];
        String j3=tipos[2];
        String j4=tipos[0];
        interfaz.torneo(j1,j2,j3,j4);
        interfaz.ronda(j1,j2,"Uno");
        Jugador ganador1=enfrentamientoSimple(j1,j2);
        interfaz.torneo(ganador1.getEstrategia(),j3,j4);
        interfaz.ronda(j3,j4,"Dos");
        Jugador ganador2=enfrentamientoSimple(j3,j4);
        interfaz.torneo(ganador1.getEstrategia(),ganador2.getEstrategia());
        interfaz.ronda(j1,j2,"final");
        Jugador ganador=enfrentamientoSimple(ganador1.getEstrategia(),ganador2.getEstrategia());
        interfaz.ganadorTorneo(ganador.getEstrategia());
    }
    /**
     * @Funcion: Revuelve el vector de estrategias para asignaler una estrategia aleatoria a los diferentes jugadores del torneo. 
     * @Param: tipos, vector de strings,vector que contiene las distintas estrategias. 
     */
    private void barajar(String[] tipos){
        int Temp1;
        int Temp2;
        for(int i=0;i<10;i++){
            Temp1=(int)(Math.random()*tipos.length);
            Temp2=(int)(Math.random()*tipos.length);
            swap(Temp1,Temp2,tipos);
        }
    }
    /**
     * @Funcion: baraja las fichas.
     * @Param: posicion1, int, se usa para el intercambio. 
     * @Param: posicion2, int, se usa para el intercambio.
     * @Param: tipos, vector de strings, vector que contiene las estrategias, se usa para intercambiar estrategias.  
     */
    private void swap(int posicion1,int posicion2,String[] tipos){
        String temp="";
        temp=tipos[posicion1];
        tipos[posicion1]=tipos[posicion2];
        tipos[posicion2]=temp;
    }
}
