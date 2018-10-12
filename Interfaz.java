
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
                " 1. Jugador 1                    \n"+
                " 2. Jugador 2                    \n"+
                " 3. Jugador 3                    \n"+
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

    public void tablero(Pieza[] mano1,Pieza[] mano2,Pieza[] tablero){
        System.out.println("\n    Jugador 1:\n");  
        mostrarPiezas(mano1);
        System.out.println("\n    Jugador 2:\n");  
        mostrarPiezas(mano2);
        System.out.println("\n    Tablero:\n");  
        mostrarPiezas(tablero);
    }

    public void esperarTecla(){
        input.next();
    }

}
