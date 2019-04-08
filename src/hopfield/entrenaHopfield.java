package hopfield;
import General.*;
import java.util.ArrayList;

public class entrenaHopfield {
    boolean buena_recuepracion;
    boolean exel_recu;
    double ortogonalidad;
    double[][] matriz_pesos;
    public void fase_Recuperacion(int m_patrones,int neuronas_N){
        System.out.println("****************");
        System.out.println("FASE DE RECUPERACIÓN");
        if (m_patrones <= (0.138*neuronas_N)){
            buena_recuepracion=true;
        }else { buena_recuepracion=false;}
        if (m_patrones<= (neuronas_N/(4*Math.log(neuronas_N)))){
            exel_recu=true;
        }else {exel_recu=false;}
    }
    public boolean getBuena_Recu(){
        return buena_recuepracion;
    }
    public boolean getExcelente_Recu(){
        return exel_recu;
    }
    public boolean ortogonalidad(ArrayList<patron> patrones, int neuronas){
        ortogonalidad=0;
        for (int n=0; n<neuronas; n++) {//maneja neuronas
            for (int p=0; p< patrones.size(); p++) {//maneja patrones
                ortogonalidad+=patrones.get(p).getNeuronas().get(n);
            }
        }//ortogonalidad menos al 50%
        if (ortogonalidad<=0)
            return true;
        else return false;
    }
    public void matriz_PesosW(int neuronas,ArrayList<patron> patrones){
        matriz_pesos=new double[neuronas][neuronas];
        //cada patron obtejer pkt* pk -I
        for (int p=0; p<patrones.size();p++){//por cada patron
        for (int i=0; i<neuronas;i++){//suma patrones
            for (int j=0; j<neuronas;j++){
                if (i!=j) {
                    for (int aux=0; aux<neuronas; aux++) {
                        matriz_pesos[i][j] += patrones.get(p).getNeuronas().get(j) * patrones.get(p).getNeuronas().get(aux);

                    }
                    System.out.print(matriz_pesos[i][j]+"  ");
                }else{ matriz_pesos[i][j]=0;}
            }
            System.out.print("\n");
        }}

        for (int i=0; i<neuronas;i++){//suma patrones
            for (int j=0; j<neuronas;j++){
            System.out.print(matriz_pesos[i][j]+"  ");}
            System.out.print("\n");
        }
    }
}
