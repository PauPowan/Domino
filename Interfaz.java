
/**
 * Write a description of class Interfaz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Interfaz
{
    private Scanner input;

    public Interfaz()
    {
        input=new Scanner(System.in);

    }

    public String imprimirMenu()
    {

        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n\n"+
            " 1. Enfretamiento Simple       \n"+
            " 2. Torneo                    \n"+
            " 3. Salir                     \n\n");
        return input.next();
    }

    public void imprimir(String mensaje)
    {

    }

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

    public void turno(String jugador,int turno,Pieza[] tablero){
        System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n\n"+
            "Turno Numero "+turno+".\n"+
            "Jugador"+jugador);
        imprimirPiezas(tablero);   
    }

    public void imprimirPiezas(Pieza[] piezas){

        for(int i=0;i<piezas.length;i++){
            if(piezas[i]!=null){
                System.out.println("["+piezas[i].getIzquierda()+"|"+piezas[i].getDerecha()+"]");
            }
        }

    }

    public void ganador(int ganador){
        System.out.print('\u000C');
        System.out.println("\n\nFELICIDADES!\nGano el jugador: "+ Integer.toString(ganador));
        esperarTecla();
    }

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

    public void partida(int part){
        System.out.println("\n\n-----------------------------------\n"+
            "            Partida :"+Integer.toString(part)); 
    }

    public void tablero(Pieza[] mano1,Pieza[] mano2,String est1,String est2,Pieza[] tablero,int turno){
        System.out.println("\n\n------------------\nTurno :"+Integer.toString(turno)); 
        //if(est1.equals("4")){
        System.out.println("\n\n    Jugador 1: ");  
        mostrarPiezas(mano1);
        //}
        //if(est2.equals("4")){
        System.out.println("\n\n    Jugador 2: ");  
        mostrarPiezas(mano2);
        ///}
        System.out.println("\n\n    Tablero: ");  
        mostrarPiezas(tablero);
    }

    public void esperarTecla(){
        System.out.println("\n**Presione Enter para continuar**\n");
        input.nextLine();
        input.nextLine();
    }

    public void noValida(){
        System.out.println("\nLa ficha no es valida con el borde escogido.\n\n");
    }

    public int[] preguntar(int piezasEnMano,int numero){
        int pos[]=new int[2];
        pos[0]=1;
        pos[1]=1;
        do{
            if(pos[0]>piezasEnMano||pos[0]<0){
                System.out.println(" Escoja una ficha válido.");
            }
            System.out.println("\n\n Que ficha desea escoger,Jugador "+Integer.toString(numero+1)+": (1-"+Integer.toString(piezasEnMano)+")\n( 0 para pasar y "+Integer.toString(piezasEnMano+1)+" para comer )\n");
            pos[0]=input.nextInt();            
        }while(pos[0]>piezasEnMano+1||pos[0]<0);
        if(pos[0]!=0){
            do{
                if(pos[1]>2||pos[1]<1){
                    System.out.println(" Escoja una direccion valido.");
                }
                System.out.println("\n\n De que lado desea ponerlo (numero):\n"+
                    "     1-Izquierda\n"+
                    "     2-Derecha\n");
                pos[1]=input.nextInt();
            }while(pos[1]>2||pos[1]<1);
        }
        return pos;
    }

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

    public void torneo(String j1,String j2){
        System.out.print('\u000C');
        System.out.println("Torneo:                   \n\n"+
            "        Ganador!          \n"+
            "           |              \n"+
            "       ____|____          \n"+
            "      |         |         \n"+
            "      "+j1+"         "+j2+"         \n");

    }

    public void ronda(String j1,String j2,String numero){
        System.out.println("Ronda: "+numero+
            "\nJugador1: estrategia "+j1+
            "\nJugador2: estrategia "+j2);
        esperarTecla();

    }

    public void ganadorTorneo(String ganador){
        System.out.print('\u000C');
        System.out.println("\n\n*********************************************************** \n\n"+
                           "                      FELICIDADES          \n\nEl torneo fue ganado por el jugador con la estrategia: "+ganador+
                           "\n\n************************************************************ ");
        esperarTecla();

    }

    public void ganadorPartida(int ganador,int puntaje){
        System.out.println("\n\nGano el jugador: "+ Integer.toString(ganador)+
            "\nPuntos: "+Integer.toString(puntaje));
        esperarTecla();
    }
}
