package General;

import java.util.ArrayList;
import java.util.Scanner;

public class entrada {
    int neuronas_x;
    int patrones_k;
    ArrayList<patron> arrayPatrones_k;
    patron patron;

    //Definir patrones de General.entrada y salida
    Scanner s;
    public entrada(Scanner s){
        this.s=s;
    }
    public void definirPatronesE(){
        //definir neuronas x por General.patron?
        System.out.println("¿Número de neuronas por patrón?");
        neuronas_x = s.nextInt();
        arrayPatrones_k = new ArrayList<patron>();
        do {//manejo de patrones k
            patron = new patron();
            for (int i = 1; i <= neuronas_x; i++) {
                System.out.println("Valor de X" + i);
                patron.setAgregaNeurona(s.nextInt());
            }
            arrayPatrones_k.add(patron);
            System.out.println("Agregar otro patron? \n 1.Si\n 2.No");
        }while (s.nextInt()==1);
        for (int i=0; i<arrayPatrones_k.size(); i++){
            System.out.println("Patron k"+(i+1)+": ");
            for (int j = 0; j < neuronas_x; j++) {
                System.out.print(arrayPatrones_k.get(i).getNeuronas().get(j)+" ");}
        }
    }
    public void definirPatronesE_S(){
        //definir neuronas x por General.patron?
        System.out.println("¿Número de neuronas por patrón?");
        neuronas_x = s.nextInt();
        arrayPatrones_k = new ArrayList<patron>();
        do {//manejo de patrones k
            patron = new patron();
            for (int i = 1; i <= neuronas_x; i++) {
                System.out.println("Valor de X" + i);
                patron.setAgregaNeurona(s.nextInt());
            }
            System.out.println("Salida deseada de éste patron");
            patron.setSalidaDeseada_Yd(s.nextInt());
            arrayPatrones_k.add(patron);
            System.out.println("Agregar otro patro? \n 1.Si\n 2.No");
        }while (s.nextInt()==1);
        for (int i=0; i<arrayPatrones_k.size(); i++){
            System.out.println("Patron k"+(i+1));
            for (int j = 0; j < neuronas_x; j++) {
            System.out.println("X"+(j+1)+" "+arrayPatrones_k.get(i).getNeuronas().get(j));}
            System.out.println("salida de k"+(i+1)+": "+arrayPatrones_k.get(i).getSalidaDeseada_Yd());
        }
    }
    public ArrayList<patron> getArrayPatrones_k(){
        return arrayPatrones_k;
    }
    public int getNeuronas_x(){
        return neuronas_x;
    }
}
