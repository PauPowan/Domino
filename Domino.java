
/**
 * Write a description of class Domino here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Domino
{
    private Interfaz interfaz;
    //bolsa.LlenarBolsa();
    public Domino()
    {   
        interfaz=new Interfaz();

        //IniciarJuego();
    }

    private void IniciarJuego(){
        String opc;

        do{
            opc=interfaz.ImprimirMenu();
            switch(opc){
                case "1":
                String a=interfaz.EscogerJugador("A");
                String b=interfaz.EscogerJugador("B");
                EnfrentamientoSimple(a,b);
                break;
                case "2":
                break;
                case "3":
                System.exit(0);
                break;
                default:
                interfaz.Imprimir("Digite una opción válida");
            }
        }while(opc!="3");
        System.exit(0);
    }

    public int EnfrentamientoSimple(String jugA,String jugB){
        Dealer dealer=new Dealer();
        Bolsa bolsa=new Bolsa();
        bolsa.LlenarBolsa();
        bolsa.Barajar();
        Mano manoA=new Mano();
        Mano manoB=new Mano();
        Jugador jugadorA= new Jugador(jugA);
        Jugador jugadorB= new Jugador(jugB);
        dealer.Repartir(manoA,bolsa);
        dealer.Repartir(manoB,bolsa);
        //manoA.Imprimir();
        //manoB.Imprimir();
        int turno=0;
        do{
            turno++;
            //interfaz.Turno("A",turno);
        }while(false);
        return 5;
    }
}

