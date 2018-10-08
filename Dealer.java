
/**
-Reparte Cartas
 */
public class Dealer
{
    
    public Dealer()
    {

    }
    public void Repartir(Mano mano,Bolsa bolsa){
        Pieza piezaASacar;
        for(int i=0;i<7;i++){
            DarPieza(mano,bolsa);
        }
    }
    public void DarPieza(Mano mano,Bolsa bolsa){
        Pieza piezaADar;
        piezaADar=bolsa.SacarPieza();
        mano.AñadirPieza(piezaADar);
    }
   
}
