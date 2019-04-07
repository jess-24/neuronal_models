package General;

import java.util.ArrayList;

public class patron {
    ArrayList<Integer> neuronas;
    int salidaDeseada_Yd;
    patron(){
        neuronas=new ArrayList<Integer>();
    }
    public  void  setNeuronas(ArrayList<Integer> neuronas){
        this.neuronas=neuronas;
    }
    public void setAgregaNeurona(int x){
        neuronas.add(x);
    }
    public void setSalidaDeseada_Yd(int salidaDeseada_Yd){
        this.salidaDeseada_Yd=salidaDeseada_Yd;
    }
    public void getSalidaDeseada_Yd(int Yd){
        this.salidaDeseada_Yd=salidaDeseada_Yd;
    }
    public ArrayList<Integer> getNeuronas() {
        return neuronas;
    }

    public int getSalidaDeseada_Yd() {
        return salidaDeseada_Yd;
    }
}
