
/**
Crea todas las piezas que seran usadas en el juego.
 */
public class Bolsa
{
    private Pieza bolsa[]= new Pieza[28];
    public Bolsa()
    {
        
    }

    public void LlenarBolsa(){
        int h=0;
        for(int i=0;i<7;i++){
            for(int j=i;j<7;j++){
                bolsa[h]=new Pieza(i,j);
                h++;
            } 

        }
    }
}

