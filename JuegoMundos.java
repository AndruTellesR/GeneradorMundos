public class JuegoMundos{
    Bicho [][] bicho;
    Bicho [][] bichoResultante;

    public JuegoMundos(){
        bicho = new Bicho[6][6];
        bichoResultante = new Bicho[6][6];

        bicho [1][0] = new Bicho();
        bicho [1][1] = new Bicho();
        bicho [1][2] = new Bicho();
        bicho [1][3] = new Bicho();
        bicho [2][5] = new Bicho();
        bicho [3][5] = new Bicho();
        bicho [4][0] = new Bicho();
        bicho [4][1] = new Bicho();
        bicho [4][4] = new Bicho();
        bicho [5][0] = new Bicho();
        bicho [5][1] = new Bicho();
    }

    public void generarMundo(){
        int cnd = 0;   
        for(int i = 0; i < bicho.length;i++){
            for(int j = 0; j < bicho.length;j++){
                cnd = bichoAbajo(i, j) + bichoAdelante(i, j) + bichoArriba(i, j) + bichoAtras(i, j);
                if(bicho[i][j] != null && cnd <= 1 && cnd >= 4){
                    muereBicho(i,j);
                }

                if(bicho[i][j] == null && cnd == 3){
                    naceBicho(i,j);
                }
                else{ 
                    if(bicho[i][j] != null && (cnd == 2 || cnd == 3)){
                        sobreViveBicho(i,j);
                    }
                }
            }
        }
    }       

    public void muereBicho(int i, int j){
        bichoResultante[i][j] = null;
    }

    public void naceBicho(int i, int j){
        bichoResultante[i][j] = new Bicho();
    }

    public void sobreViveBicho(int i, int j){
        bichoResultante[i][j] = bicho[i][j];
    }

    public int bichoArriba(int i, int j){
        int aux= 0;
        if(i > 0){
            aux += bicho[i-1][j] != null? 1 : 0;
            aux += this.bichoAdelante(i-1, j) == 1? 1 : 0;
            aux += this.bichoAtras(i-1, j) == 1? 1 : 0;
        }
        return aux;
    }
    
    public int bichoAdelante(int i, int j){
        int tmp = 0;
        if(j < bicho.length - 1){
            tmp = bicho[i][j+1] != null? 1 : 0;
        }
        return tmp;
    }

    public int bichoAtras(int i, int j){
        int tmp = 0;
        if(j > 0){
            tmp = bicho[i][j-1] != null? 1 : 0;
        }
        return tmp;
    }

    

    public int bichoAbajo(int i, int j){
        int aux = 0;
        if(i < bicho.length - 1){
            aux+= bicho[i+1][j] != null? 1:0;
            aux+= this.bichoAdelante(i+1,j)==1 ? 1:0;
            aux+= this.bichoAtras(i+1,j)==1 ? 1:0;
        }
        return aux;
    }

    public void imprimirMundo(){        
        for(int i = 0; i < bichoResultante.length;i++){
            for(int j = 0; j < bichoResultante.length;j++){
                if(bichoResultante[i][j] != null){
                    System.out.print("| 1 |");
                }
                else{
                    System.out.print("| 0 |");
                }

                if(j == bichoResultante.length-1){
                    System.out.println();
                }
            }
        }
    }
}

