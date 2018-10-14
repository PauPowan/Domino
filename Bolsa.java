import java.util.*;
/**
Crea todas las piezas que seran usadas en el juego.
 */
public class Bolsa
{
    private Pieza bolsa[];
    private int piezasTotales;
    public Bolsa()
    {
        bolsa= new Pieza[28];
        piezasTotales=bolsa.length;
    }
    /**
     * @Funcion: llena la bolsa de piezas
     */
    public void llenarBolsa(){
        int h=0;
        for(int i=0;i<7;i++){
            for(int j=i;j<7;j++){
                bolsa[h]=new Pieza(i,j);
                h++;
            } 

        }

    }
    
    public Pieza[] getBolsa(){
        return bolsa;
    }
    /**
     * @Funcion: revuelve las piezas.
     */
    public void barajar(){
        int Temp1;
        int Temp2;
        for(int i=0;i<60;i++){
            Temp1=(int)(Math.random()*piezasTotales);
            Temp2=(int)(Math.random()*piezasTotales);
            swap(Temp1,Temp2);
        }
   }
   /**
    * @Funcion: pone las piezas.
    * @Param: posicion1, int, se usan para cambiar la posicion de las cartas y poder barajar.  
    * @Param: posicion2, int, se usan para cambiar la posicion de las cartas y poder barajar. 
    */
    private void swap(int posicion1,int posicion2){
        Pieza temp=new Pieza(-1,-1);
        temp.setPieza(bolsa[posicion1]);
        bolsa[posicion1].setPieza(bolsa[posicion2]);
        bolsa[posicion2].setPieza(temp);
    }
    /**
     * @Funcion: saca una pieza del puño.
     * @Return: devuelve la pieza que se saca de la bolsa. 
     */
    public Pieza sacarPieza(){
        Pieza piezaASacar= new Pieza(-1,-1);
        piezaASacar.setPieza(bolsa[piezasTotales-1]);
        bolsa[piezasTotales-1]=null;
        piezasTotales--;
        return piezaASacar;
    }
    
    public Pieza[] getMano(){
        return bolsa;
    }

    public int getPiezasTotales(){
        return piezasTotales;
    }
}

