
/**
Jugador 
 */
public class Jugador
{
    private Pieza[] mano;
    private int puntos;
    private int piezasEnMano;
    private String estrategia;
    public Jugador(String numeroJugador)
    {
        mano= new Pieza[21];
        piezasEnMano=0;
        puntos=0;
        estrategia=numeroJugador;
    }

    public void sumarPuntos(int puntosMas){
        this.puntos+=puntosMas;
    }

    public int getPuntos(){
        return puntos;
    }

    public int getPiezasEnMano(){
        return  piezasEnMano;
    }

    public void tomarPieza(Pieza pieza){        
        mano[piezasEnMano]=new Pieza(-1,-1);
        mano[piezasEnMano].setPieza(pieza);
        piezasEnMano++;
    }

    public Pieza darPieza(int numeroPieza){
        Pieza piezaASacar=new Pieza(0,0);
        piezaASacar.setPieza(mano[numeroPieza]);
        mano[numeroPieza]=null;
        piezasEnMano--;
        return piezaASacar;
    }

    public void vaciarMano(){
        for(int i=0;i<piezasEnMano;i++){ //Aquiiiiiiiiiiiiiiiiiiiiiiii
            mano[i]=null; 
        }
        piezasEnMano=0;
    }

    public Pieza[] getMano(){
        return mano;
    }

    public boolean existePar(){
        Boolean par=false;
        for(int i=0;i<piezasEnMano;i++){
            if(mano[i].getIzquierda()==mano[i].getDerecha()){
                par=true;
            }
        }
        return par;
    }

    public int[] parMayor(){
        int[] piezaMayor=new int[2];
        int valorMayor=-1;
        int posicionDelMayor=0;
        for(int i=0;i<piezasEnMano;i++){
            if(mano[i].getIzquierda()==mano[i].getDerecha()){
                if(mano[i].getIzquierda()>valorMayor){
                    valorMayor=mano[i].getIzquierda();
                    posicionDelMayor=i;
                }
            }
        }
        piezaMayor[0]=valorMayor;
        piezaMayor[1]=posicionDelMayor;
        return piezaMayor;
    }

    public Pieza darParMayor(){
        Pieza piezaMayor=null;
        piezaMayor=darPieza(parMayor()[1]);
        return piezaMayor;
    }

    public boolean ponerPieza(Tablero tablero,int turno,Bolsa bolsa){
        int posicionPieza=-1;
        boolean salir=false;
        boolean fin=false;
        int valorBorde=0;
        int pasar=-1;
        Pieza pieza=new Pieza(-1,-1);
        String direccion="izq";
        int izq=tablero.getValorPiezaIzquierda();
        int der=tablero.getValorPiezaDerecha();
        if(turno==1){
            tablero.agregarPieza(darParMayor(),direccion);
            acomodarMano();
        }else{
            do{
                switch(this.estrategia){
                    case "1":
                    for(int i=0;i<piezasEnMano;i++){
                        if (mano[i].getIzquierda()==izq||mano[i].getDerecha()==izq){
                            posicionPieza=i;
                            direccion="izq";
                            valorBorde=izq;
                        }
                        if(mano[i].getIzquierda()==der||mano[i].getDerecha()==der){
                            posicionPieza=i;
                            direccion="der";
                            valorBorde=der;
                        }

                    }
                    break;
                    case "2":
                    for(int i=piezasEnMano-1;i>=0;i--){
                        if(mano[i].getIzquierda()==der||mano[i].getDerecha()==der){
                            posicionPieza=i;
                            direccion="der";
                            valorBorde=der;
                        }
                        if (mano[i].getIzquierda()==izq||mano[i].getDerecha()==izq){
                            posicionPieza=i;
                            direccion="izq";
                            valorBorde=izq;
                        }                        
                    }
                    break;
                    case "3":
                    int mayor=0;

                    for(int i=0;i<piezasEnMano;i++){
                        if (mano[i].getIzquierda()==izq||mano[i].getDerecha()==izq){
                            if(mayor<=mano[i].getValorPieza()){
                                mayor=mano[i].getValorPieza();
                                posicionPieza=i;
                                direccion="izq";
                                valorBorde=izq;
                            }
                        }
                        if((mano[i].getIzquierda()==der||mano[i].getDerecha()==der)&&posicionPieza==-1){
                            if(mayor<=mano[i].getValorPieza()){
                                mayor=mano[i].getValorPieza();
                                posicionPieza=i;
                                direccion="izq";
                                valorBorde=izq;
                            }
                        }

                    }
                    break;                    
                    default:

                }
                if(posicionPieza==-1){
                    salir=false;
                    if(bolsa.getPiezasTotales()>0){
                        tomarPieza(bolsa.sacarPieza());
                    }else{
                        salir=true;
                    }
                }else{
                    salir=true;
                }
            }while(!salir);

        }        
        if(bolsa.getPiezasTotales()>0&&posicionPieza!=-1){
            mano[posicionPieza].acomodarPieza(valorBorde,direccion);                
            pieza.setPieza(darPieza(posicionPieza));
            acomodarMano();
            tablero.agregarPieza(pieza,direccion);
        }else{
            fin=true;
        }
        return fin;
    }

    private void acomodarMano(){
        for(int i=0;i<mano.length;i++){
            if(mano[i]==null){
                for(int j=i;j<mano.length-1;j++){                    
                    mano[j]=mano[j+1];
                    mano[j+1]=null;
                }
            }
        }
    }

    public int getPuntajeMano(){
        int puntajeTotal=0;
        for(int i=0;i<piezasEnMano;i++){
            puntajeTotal+=mano[i].getValorPieza();
        }
        return puntajeTotal;
    }

}
