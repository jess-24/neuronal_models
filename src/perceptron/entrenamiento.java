package perceptron;

import java.util.ArrayList;
//import java.util.Scanner;
import General.patron;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entrenamiento {
    double teta_umbralAct;
    double alfa_CoefAp;
    double fe;
    int fa_Sal_real,error;
    //Scanner s;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Ya tenemos el "lector"

    ArrayList<Double> pesos;
    ArrayList<Integer> errorArray;
    public entrenamiento(){
        pesos=new ArrayList<Double>();
        try {
            System.out.println("Valor de θ (Umbral de Act):");
            teta_umbralAct =Double.parseDouble(br.readLine());
            System.out.println("Valor de α (Coef. Aprendizaje):");
            alfa_CoefAp=Double.parseDouble(br.readLine());
        }catch (IOException ex){
            ex.getMessage();
        }
    }

    public void aprendizaje(int neuronasX){
        for (int i=0; i<neuronasX;i++){
            System.out.println("Valor de w"+(i+1));
            try {
                pesos.add(Double.parseDouble(br.readLine()));
            }catch (IOException ex){
            ex.getMessage();
        }

        }

    }
    public void proceso(ArrayList<patron> patronesEntrada_k){
        ArrayList<Integer> neuronas=new ArrayList<Integer>();
        double  deltaPeso;
        boolean exito;
        //double deltaPeso;
        do {
            //periodos
            exito=true;
            errorArray=new ArrayList<Integer>();
            for (int i = 0; i < patronesEntrada_k.size(); i++) {
                neuronas = patronesEntrada_k.get(i).getNeuronas();
                System.out.println(" ");fe=0;
                //sumatoria
                for (int j = 0; j < neuronas.size(); j++) {
                    fe += neuronas.get(j) * pesos.get(j);
                    System.out.print(" " + neuronas.get(j) + " ");
                }
                fe = fe - teta_umbralAct;
                if (fe < 0) {
                    fa_Sal_real = 0;
                } else {
                    fa_Sal_real = 1;
                }
                error = patronesEntrada_k.get(i).getSalidaDeseada_Yd() - fa_Sal_real;
                errorArray.add(error);
                for (int x = 0; x < neuronas.size(); x++) {
                    deltaPeso = neuronas.get(x) * alfa_CoefAp * error;
                    System.out.print(pesos.get(x) + " ");
                    pesos.add(x, (pesos.get(x) + deltaPeso));
                    //pesos.set(x, (pesos.get(x) + deltaPeso));
                }
                System.out.print(fe + "  fa:" + fa_Sal_real + "  E:" + error + " ");
            }
            //verifica que todos los errores sean 0
            for (int i=0;i<errorArray.size();i++){
                if (errorArray.get(i)!=0){
                    exito=false;
                }
            }
        }while (exito==false);
        System.out.println("Aprendizaje aprendido");
        System.out.println("Listo para probar");
        probar(neuronas);
    }
    public void probar(ArrayList<Integer> neuronas){
        ArrayList<Integer> patronPrueba;
        //int yd,aux;double fe=0;
        int resp=0;
        System.out.println("Ingresa un patron");
        do {
            int yd,aux;double fe=0;
            patronPrueba=new ArrayList<Integer>();
            for (int i=0; i<neuronas.size();i++){
                System.out.println("Ingresa el valor de X"+(i+1));
                try {aux=Integer.parseInt(br.readLine());
                    patronPrueba.add(aux);
                    fe+=aux*pesos.get(i);
                }catch (IOException ex){
                    ex.getMessage();
                }
            }
            fe-=teta_umbralAct;
            if (fe < 0) {
                fa_Sal_real = 0;
            } else {
                fa_Sal_real = 1;
            }
            System.out.println(" ");
            for (int i=0; i<neuronas.size();i++){
                System.out.print(+patronPrueba.get(i)+"  ");
            }
            System.out.print("  "+fa_Sal_real);
            System.out.println("\nProbar con otro patron? \n 1.Si\n 2.No");
            try {
                resp=Integer.parseInt(br.readLine());
            }catch (IOException ex){
                ex.getMessage(); }
        }while (resp==1);

    }
}
