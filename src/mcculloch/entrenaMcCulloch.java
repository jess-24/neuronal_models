package mcculloch;
import General.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class entrenaMcCulloch {
    double w1,w2,teta;
    boolean exitoso;
    ArrayList<Integer> salida_real;
    ArrayList<Double> pesos;
    public void valoreWyTeta(int neuronas){
        pesos=new ArrayList<Double>();
        double peso;
        for (int i=0; i<neuronas;i++){
            peso=((double)Math.round((Math.random()*((-0.5)-0.5)+0.5)*100d)/100d);
            pesos.add(peso);
            System.out.println("w"+(i+1)+": "+peso);
        }
       teta=(double)Math.round((Math.random()*((-0.5)-0.5)+0.5)*100d)/100d;
        //teta=0;
        System.out.println("teta: "+teta+"\n\n");
    }
    public void proceso(ArrayList<patron> patrones){
        double salida=0;
        salida_real=new ArrayList<Integer>();
        for (int i=0; i<patrones.size();i++){
            salida=0;
            for (int j=0; j< patrones.get(i).getNeuronas().size();j++){
                System.out.print(patrones.get(i).getNeuronas().get(j)+" ");
                salida+=patrones.get(i).getNeuronas().get(j)*pesos.get(j);
            }
            if (salida>=teta){
                System.out.print("1");
                salida_real.add(1);
            }else{salida_real.add(0);System.out.print("0");}
        }
    }
    //comparar salidas reales con deseadas
    public boolean aprendizaje(ArrayList<patron> patrones){
        exitoso=true;
        //ArrayList<Integer> YD=´patrones.get().
        for (int i=0; i< patrones.size();i++){
            if(salida_real.get(i) != patrones.get(i).getSalidaDeseada_Yd()){
                exitoso=false;
            }
        }
        return exitoso;
    }
    public void prueba(ArrayList<patron> patronPrueba){
        double salida;
        for (int i=0; i<patronPrueba.size();i++){
            salida=0;
            for (int j=0; j< patronPrueba.get(i).getNeuronas().size();j++){
                System.out.print(patronPrueba.get(i).getNeuronas().get(j)+" ");
                salida+=patronPrueba.get(i).getNeuronas().get(j)*pesos.get(j);
            }
            if (salida>=teta){
                System.out.print("1");
            }else{System.out.print("0");}
        }
    }
}
