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
    public void barajar(){
        int Temp1;
        int Temp2;
        for(int i=0;i<60;i++){
            Temp1=(int)(Math.random()*piezasTotales);
            Temp2=(int)(Math.random()*piezasTotales);
            swap(Temp1,Temp2);
        }
    }

    private void swap(int posicion1,int posicion2){
        Pieza temp=new Pieza(-1,-1);
        temp.setPieza(bolsa[posicion1]);
        bolsa[posicion1].setPieza(bolsa[posicion2]);
        bolsa[posicion2].setPieza(temp);
    }

    public Pieza sacarPieza(){
        Pieza piezaASacar= new Pieza(-1,-1);
        piezaASacar.setPieza(bolsa[piezasTotales-1]);
        bolsa[piezasTotales-1]=null;
        piezasTotales--;
        return piezaASacar;
    }
    //borrar este
    public Pieza[] getMano(){
        return bolsa;
    }

    public int getPiezasTotales(){
        return piezasTotales;
    }
}

