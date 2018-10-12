
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
    public void tablero(Pieza[] mano1,Pieza[] mano2,Pieza[] tablero,int turno){
         System.out.println("\n\n------------------\nTurno :"+Integer.toString(turno)); 
        System.out.println("\n\n    Jugador 1:");  
        mostrarPiezas(mano1);
        System.out.println("\n\n    Jugador 2:");  
        mostrarPiezas(mano2);
        System.out.println("\n\n    Tablero:");  
        mostrarPiezas(tablero);
        esperarTecla();
    }

    public void esperarTecla(){
        input.next();
    }

    public void ganadorPartida(int ganador,int puntaje){
        System.out.println("\n\nGano el jugador: "+ Integer.toString(ganador)+
            "\nPuntos: "+Integer.toString(puntaje));
        esperarTecla();
    }
}
