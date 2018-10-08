
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

    public String ImprimirMenu()
    {

        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n\n"+
            " 1. Enfretamiento Simple       \n"+
            " 2. Torneo                    \n"+
            " 3. Salir                     \n\n");
        return input.next();
    }

    public void Imprimir(String mensaje)
    {

    }

    public String EscogerJugador(String identificadorJugador){
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

    public void Turno(String jugador,int turno,Pieza[] tablero){
        System.out.print("~~~~~~~~~~~~DOMINO~~~~~~~~~~~\n\n"+
            "Turno Numero "+turno+".\n"+
            "Jugador"+jugador);
        ImprimirPiezas(tablero);   
    }

    public void ImprimirPiezas(Pieza[] piezas){
        for(int i=0;i<piezas.length;i++){
            if(piezas[i]!=null){
                System.out.println("["+piezas[i].GetIzquierda()+"|"+piezas[i].GetDerecha()+"]");
            }
        }
    }
}
