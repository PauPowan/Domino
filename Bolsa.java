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
        piezasTotales=bolsa.length-1;
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
    public void Barajar(){
        int Temp1;
        int Temp2;
        for(int i=0;i<30;i++){
            Temp1=(int)(Math.random()*27);
            Temp2=(int)(Math.random()*27);
            Swap(Temp1,Temp2);
        }
    }
    private void Swap(int Posicion1,int Posicion2){
        Pieza temp=new Pieza(0,0);
        temp=bolsa[Posicion1];
        bolsa[Posicion1]=bolsa[Posicion2];
        bolsa[Posicion2]=temp;
    }
    
     public Pieza SacarPieza(){
        Pieza piezaASacar=bolsa[piezasTotales];
        bolsa[piezasTotales]=null;
        piezasTotales--;
        return piezaASacar;
    }
}

