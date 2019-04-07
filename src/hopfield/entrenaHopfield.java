package hopfield;

public class entrenaHopfield {
    boolean buena_recuepracion;
    boolean exel_recu;
    public void fase_Recuperacion(int m_patrones,int neuronas_N){
        System.out.println("****************");
        System.out.println("FASE DE RECUPERACIÓN");
        if (m_patrones <= (0.138*neuronas_N)){
            buena_recuepracion=true;
        }else { buena_recuepracion=false}
        if (m_patrones<= (neuronas_N/(4*Math.log(neuronas_N)))){
            exel_recu=true;
        }else {exel_recu=false;}
        
    }
}
