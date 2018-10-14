
/**
 * Muestra la interfaz para que el usuario interactúe con ella y usa los métodos que imprimen los menús para que funcionen.
 */
import java.util.*;
public class Interfaz{
    private Scanner input;

    public Interfaz(){
        input=new Scanner(System.in);

    }
    
    /**
     * @Funcion: Imprime el primer menu del juego. 
     * @Return: Imprime el menu. 
     */
    public String imprimirMenu(){

        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n\n"+
            " 1. Enfretamiento Simple       \n"+
            " 2. Torneo                    \n"+
            " 3. Salir                     \n\n");
        return input.next();
    }
    
   /**
     * @Funcion: Imprime los menu para escoger los jugadores.  
     * @Param: identificadorJugador, string, se usa para indicar si es el jugador 1 o el 2. 
     * @Return: retorna el jugador que se escogio. 
     */
    
    public String escogerJugador(String identificadorJugador){
        String numeroJugador="1";
        do{
            if(!(numeroJugador.matches("^[1-4]+$"))){
                System.out.print('\u000C');
                System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n\n"+

                    " Escoja un valor valido.    \n\n"+
                    " Presione ENTER para continuar.                   \n");
                input.nextLine();
                input.nextLine();
            }
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n"+
                " Escoga el jugador "+identificadorJugador+" que sera usado:    \n\n"+
                " 1. Jugador A                    \n"+
                " 2. Jugador B                    \n"+
                " 3. Jugador C                    \n"+
                " 4. Dummy                     \n\n");
            numeroJugador=input.next();
        }while(!(numeroJugador.matches("^[1-4]+$")));

        return numeroJugador;

    }
    /**
     * @Funcion: imprime un mensaje para indicarle al jugador cual turno es y de cual jugador. 
     * @Param: jugador, string,se usa para indicar de cual jugador es el turno 
     * @Param: turno, int, se usa para indicar el numero de turno 
     * @Param: tablero, vector de objetos Pieza,se usa para imprimir las piezas del tablero. 
     */
    public void turno(String jugador,int turno,Pieza[] tablero){
        System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n\n"+
            "Turno Numero "+turno+".\n"+
            "Jugador"+jugador);
        imprimirPiezas(tablero);   
    }
    /**
     * @Funcion: imprime las piezas a consola. 
     * @Param: piezas, vector de objetos del tipo Pieza, se usa para imprimir las piezas. 
     */
    public void imprimirPiezas(Pieza[] piezas){

        for(int i=0;i<piezas.length;i++){
            if(piezas[i]!=null){
                System.out.println("["+piezas[i].getIzquierda()+"|"+piezas[i].getDerecha()+"]");
            }
        }

    }
    /**
     * @Funcion: imprime el mensaje del ganador. 
     * @Param: ganador, int, usado para imprimir cual fue el jugador ganador. 
     */
    public void ganador(int ganador){
        System.out.print('\u000C');
        System.out.println("\n\nFELICIDADES!\nGano el jugador: "+ Integer.toString(ganador));
        esperarTecla();
    }
    /**
     * @Funcion: Se usa para mostrar las piezas en formato string. 
     * @Param: piezas, vector de objetos de tipo Pieza,se usa para mostrar las piezas en forma de string.  
     */
    public void mostrarPiezas(Pieza[] piezas){
        for(int i=0;i<piezas.length;i++){
            if(piezas[i]!=null){
                System.out.print(piezas[i]);
                if(i%6==0&&i!=0){
                    System.out.println();
                }
            }
        }
    }
    /**
     * @Funcion: Imprime el numero de partida. 
     * @Param: part, int, se usa para indicar el numero de partida. 
     */
    public void partida(int part){
        System.out.println("\n\n-----------------------------------\n"+
            "            Partida :"+Integer.toString(part)); 
    }
    /**
     * @Funcion: Imprime el tablero. 
     * @Param: mano1, vector de objetos de tipo Pieza, se usa para imprimir la mano del primer jugador 
     * @Param: mano2, vector de objetos de tipo Pieza, se usa para imprimir la mano del segundo jugador
     * @Param: est1, string, se usa para definir si se imprime la mano del jugador  
     * @Param: est2, string, se usa para definir si se imprime la mano del jugador
     * @Param: tablero, vector de objetos de tipo Pieza, se usa para imprimir las fichas que estan en el tablero
     * @Param: turno, int, se usa para imprimir el numero de turno
     */
    public void tablero(Pieza[] mano1,Pieza[] mano2,String est1,String est2,Pieza[] tablero,int turno){
        System.out.println("\n\n------------------\nTurno :"+Integer.toString(turno)); 
        if(est1.equals("4")){
            System.out.println("\n\n    Jugador 1: ");  
            mostrarPiezas(mano1);
        }
        if(est2.equals("4")){
            System.out.println("\n\n    Jugador 2: ");  
            mostrarPiezas(mano2);
        }
        System.out.println("\n\n    Tablero: ");  
        mostrarPiezas(tablero);
    }
    /**
     * @Funcion: Se usa para indicarle al usuario que presione enter. 
     */
    public void esperarTecla(){
        System.out.println("\n**Presione Enter para continuar**\n");
        input.nextLine();
        input.nextLine();
    }
    /**
     * @Funcion: Imprime un mensaje de error. 
     */
    public void noValida(){
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\nLa ficha no es valida con el borde escogido.\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
    /** 
     * @Funcion: le indica al jugador que la bolsa esta vacia. 
     */
    public void llena(){
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\nYa no hay mas piezas disponibles en la bolsa.\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
    /**
     * @Funcion: imprime instrucciones necesarias para jugar. 
     * @Param: piezasEnMano, int, se usa para llevar cuenta de la cantidad de piezas en la mano del jugador 
     * @Param: numero, int, se usa para idicar cual jugador esta jugando
     * @Return: retorna la posicion de la ficha y el lado del tablero que la pone
     */
    public int[] preguntar(int piezasEnMano,int numero){
        int pos[]=new int[2];
        pos[0]=1;
        pos[1]=1;
       do{
            if(pos[0]>piezasEnMano||pos[0]<0){
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n Escoja una ficha válida.\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            }
            System.out.println("\n\n Que ficha desea escoger,Jugador "+Integer.toString(numero+1)+": (1-"+Integer.toString(piezasEnMano)+")\n( 0 para pasar y "+Integer.toString(piezasEnMano+1)+" para comer )\n");
            pos[0]=input.nextInt();            
       }while(pos[0]>piezasEnMano+1||pos[0]<0);
       
       if(pos[0]!=0&&pos[0]!=piezasEnMano+1){
            do{
                if(pos[1]>2||pos[1]<1){
                    System.out.println(" Escoja una direccion valida.");
                }
                System.out.println("\n\n De que lado desea ponerlo (numero):\n"+
                    "     1-Izquierda\n"+
                    "     2-Derecha\n");
                pos[1]=input.nextInt();
            }while(pos[1]>2||pos[1]<1);
       }
        return pos;
    }
    /**
     * @Funcion: imprime las posiciones del torneo
     * @Param: j1, string, se usa para representar al jugador 1 
     * @Param: j2, string, se usa para representar al jugador 2
     * @Param: j3, string, se usa para representar al jugador 3
     * @Param: j4, string, se usa para representar al jugador 4
     */
    public void torneo(String j1,String j2,String j3,String j4){
        System.out.print('\u000C');
        System.out.println("Torneo:                   \n\n"+
            "        Ganador!          \n"+
            "           |              \n"+
            "       ____|____          \n"+
            "      |         |         \n"+
            "    __|__     __|__       \n"+
            "   |     |   |     |      \n"+
            "   |     |   |     |      \n"+
            "   "+j1+"     "+j2+"   "+j3+"     "+j4+"      ");        
    }
   /**
     * @Funcion: imprime las posiciones del torneo
     * @Param: j1, string, se usa para representar al jugador 1 
     * @Param: j2, string, se usa para representar al jugador 2
     * @Param: j3, string, se usa para representar al jugador 3
     */
    public void torneo(String j1,String j2,String j3){
       System.out.print('\u000C');
       System.out.println("Torneo:                   \n\n"+
            "        Ganador!          \n"+
            "           |              \n"+
            "       ____|____          \n"+
            "      |         |         \n"+
            "      |       __|__       \n"+
            "      "+j1+"      |     |      \n"+
            "             |     |      \n"+
            "             "+j2+"     "+j3+"      ");

    }
    /**
     *  * @Funcion: imprime las posiciones del torneo
     * @Param: j1, string, se usa para representar al jugador 1 
     * @Param: j2, string, se usa para representar al jugador 2
     */
    public void torneo(String j1,String j2){
        System.out.print('\u000C');
        System.out.println("Torneo:                   \n\n"+
            "        Ganador!          \n"+
            "           |              \n"+
            "       ____|____          \n"+
            "      |         |         \n"+
            "      "+j1+"         "+j2+"         \n");

    }
    /**
     * @Funcion: se usa para imprimir la informacion de cada ronda 
     * @Param: j1, string, se usa para representar al jugador 1 
     * @Param: j2, string, se usa para representar al jugador 2
     * @Param: numero, int, se usa para imprimir el numero de ronda
     */
    public void ronda(String j1,String j2,String numero){
        System.out.println("Ronda: "+numero+
            "\nJugador1: estrategia "+j1+
            "\nJugador2: estrategia "+j2);
        esperarTecla();

    }
    /**
     * @Funcion: imprime el mensaje para el ganador del torneo
     * @Param: ganador, string, se usa para imprimir el jugador ganador 
     */
    public void ganadorTorneo(String ganador){
        System.out.print('\u000C');
        System.out.println("\n\n*********************************************************** \n\n"+
                           "                      FELICIDADES          \n\nEl torneo fue ganado por el jugador con la estrategia: "+ganador+
                           "\n\n************************************************************ ");
        esperarTecla();

    }
    /** 
     * @Funcion: imprime el ganador de la partida y los puntos que obtuvo 
     * @Param: ganador, int, se usa para imprimir el ganador 
     * @Param: puntaje, int, se usa para imprimr el puntaje
     */
    public void ganadorPartida(int ganador,int puntaje){
        System.out.println("\n\nGano el jugador: "+ Integer.toString(ganador)+
            "\nPuntos: "+Integer.toString(puntaje));
        esperarTecla();
    }
}
