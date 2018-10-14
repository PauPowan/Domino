
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
    /**
     * @Funcion:  Suma los puntos del jugador
     * @Param: puntosMas, int, se usa para sumar los puntos del jugador 
     */
    public void sumarPuntos(int puntosMas){
        this.puntos+=puntosMas;
    }
   
    public int getPuntos(){
        return puntos;
    }

    public int getPiezasEnMano(){
        return  piezasEnMano;
    }

    public String getEstrategia(){
        return  estrategia;
    }
    /**
     * @Función: Agarra una pieza para agregarla a la mano.
     * @Param:  pieza,tipo Pieza, es  la pieza que va a ser agregada en la mano.
     */
    public void tomarPieza(Pieza pieza){        
        mano[piezasEnMano]=new Pieza(-1,-1);
        mano[piezasEnMano].setPieza(pieza);
        piezasEnMano++;
    }
    /**
     * @Función: Saca una pieza de la mano para darla al tablero.
     * @Param:  numeroPieza,tipo int,La pieza que se le va a entregar al tablero.
     * @Return: retorna la pieza que se le va a entregar al tablero.
     */
    public Pieza darPieza(int numeroPieza){
        Pieza piezaASacar=new Pieza(0,0);
        piezaASacar.setPieza(mano[numeroPieza]);
        mano[numeroPieza]=null;
        piezasEnMano--;
        return piezaASacar;
    }
    /**
     * @Función: Deja la mano vacía
     */
    public void vaciarMano(){
        for(int i=0;i<piezasEnMano;i++){ 
            mano[i]=null; 
        }
        piezasEnMano=0;
    }

    public Pieza[] getMano(){
        return mano;
    }
    /**
     * @Funcion: Dice si el jugador posee par o no
     * @Return: Retorna si hay una ficha par o no 
     */
    public boolean existePar(){
        Boolean par=false;
        for(int i=0;i<piezasEnMano;i++){
            if(mano[i].getIzquierda()==mano[i].getDerecha()){
                par=true;
            }
        }
        return par;
    }
    /**
     * @Funcion: se usa para encontrar la pieza doble mas alta 
     * @Return: retorna la posicion de la pieza mayor y su valor 
     */
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
    /**
     * @Funcion: devolver el doble mas alto.  
     * @Return: retorna el doble mas alto.
     */
    public Pieza darParMayor(){
        Pieza piezaMayor=null;
        piezaMayor=darPieza(parMayor()[1]);
        return piezaMayor;
    }

    /**
     * @Funcion: Pone una pieza en el tablero en cada turno. 
     * @Param: tablero, objecto de tipo Tablero,se usa para saber los bordes de las fichas y para poner fichas  
     * @Param: turno, int, se usa para 
     * @Param: bolsa, objeto de tipo Bolsa,se usa para poder comer una ficha en caso de no tener
     * @Return: retorna el paso del turno  
     */
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
                    int menor=13;
                    for(int i=0;i<piezasEnMano;i++){
                        if (mano[i].getIzquierda()==izq||mano[i].getDerecha()==izq){
                            if(menor>=mano[i].getValorPieza()){
                                menor=mano[i].getValorPieza();
                                posicionPieza=i;
                                direccion="izq";
                                valorBorde=izq;
                            }
                        }
                        if((mano[i].getIzquierda()==der||mano[i].getDerecha()==der)&&posicionPieza==-1){
                            if(menor>=mano[i].getValorPieza()){
                                menor=mano[i].getValorPieza();
                                posicionPieza=i;
                                direccion="der";
                                valorBorde=der;
                            }
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
                        if((mano[i].getIzquierda()==der||mano[i].getDerecha()==der)){
                            if(mayor<=mano[i].getValorPieza()){
                                mayor=mano[i].getValorPieza();
                                posicionPieza=i;
                                direccion="der";
                                valorBorde=der;
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
    /**
     * @Funcion: Crea al jugador dummy que es controlado el humano. 
     * @Param: tablero, objeto de tipo Tablero, se usa para saber los bordes de las fichas y para poner fichas
     * @Param: bolsa, objeto de tipo Bolsa, se usa si el jugador ocupa comer una ficha 
     * @Param: interfaz, objeto de tipo Interfaz, se usa para llamar a la interfaz 
     * @Param: numero, int, se usa para saber cuantas fichas tiene el jugador  
     * @Return: retorna el paso de turno 
     */
    public boolean dummy(Tablero tablero,Bolsa bolsa,Interfaz interfaz,int numero){ 
        boolean seguir=true;
        boolean pasarTurno=false;
        Pieza pieza=new Pieza(-1,-1);
        int[] posicion= new int[2];        
        int izq=tablero.getValorPiezaIzquierda();
        int der=tablero.getValorPiezaDerecha();
        do{            

            if(!seguir){
                interfaz.noValida(); 
            }
            posicion=interfaz.preguntar(getPiezasEnMano(),numero);
            seguir=false;
            if(posicion[0]==(getPiezasEnMano()+1)){
                if(bolsa.getPiezasTotales()==0){
                    interfaz.llena();  
                }else{
                    tomarPieza(bolsa.sacarPieza());                        
                }
                seguir=true; 
            }else if(posicion[0]==0){
                seguir=true;
                pasarTurno=true;
            }else{
                if(posicion[1]==1&&(mano[posicion[0]-1].getIzquierda()==izq||mano[posicion[0]-1].getDerecha()==izq)){
                    mano[posicion[0]-1].acomodarPieza(izq,"izq");
                    pieza.setPieza(darPieza(posicion[0]-1));
                    tablero.agregarPieza(pieza,"izq");
                    acomodarMano();
                    seguir=true;
                }
                if(posicion[1]==2&&(mano[posicion[0]-1].getIzquierda()==der||mano[posicion[0]-1].getDerecha()==der)){
                    mano[posicion[0]-1].acomodarPieza(der,"der");
                    pieza.setPieza(darPieza(posicion[0]-1));
                    tablero.agregarPieza(pieza,"der");
                    acomodarMano();
                    seguir=true;
                }
            }

        }while(!seguir);
        return pasarTurno;
    }
    /**
     * @Funcion: Ordena las fichas para que no queden null entre fichas
     */
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
