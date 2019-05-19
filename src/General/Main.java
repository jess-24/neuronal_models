package General;

import java.util.Scanner;
import perceptron.*;
import hopfield.*;
import mcculloch.*;

import javax.sound.midi.Soundbank;

public class Main {
    entrada entrada;
    entrenamiento entrenamiento;
    entrenaHopfield hopfield;
    entrenaMcCulloch mcculloch;
    Main(){
        System.out.println("****Elije un modelo***");
        System.out.println("1.McCulloch y Pitts");
        System.out.println("2.Perceptron");
        System.out.println("3.Hopfield");
        System.out.println("4.");
        Scanner s = new Scanner(System.in);
        switch (s.nextInt()){
            case 1: modelo_McCulochPitts(0);
                break;
            case 2:
                modelo_Perceptron(s);
                break;
            case 3:modelo_Hopfield(s);
                break;
        }
    }
    public void modelo_McCulochPitts(int aux){
        Scanner s = new Scanner(System.in);
        if (aux==0) {
            entrada = new entrada(s);
            entrada.definirPatronesE_S();
            mcculloch = new entrenaMcCulloch();
        }
        mcculloch.valoreWyTeta(entrada.getNeuronas_x());
        mcculloch.proceso(entrada.getArrayPatrones_k());
        if (mcculloch.aprendizaje(entrada.getArrayPatrones_k())){
            System.out.println("\n\nAprendizaje exitoso");
            do {
                entrada=new entrada(s);
                entrada.definirPatronesE();
                mcculloch.prueba(entrada.getArrayPatrones_k());
                System.out.println("\n\nProbar con otro patron?\n1.Si\n2.No");
            }while (s.nextInt()==1);
        }else {
            System.out.println("\nCambiando el valor de pesos y teta");
            modelo_McCulochPitts(1);
        }
    }
    public void modelo_Perceptron(Scanner s){
        entrada=new entrada(s);
        entrada.definirPatronesE_S();
        //Entrenamiento Perceptron
        entrenamiento=new entrenamiento();
        entrenamiento.aprendizaje(entrada.getNeuronas_x());
        entrenamiento.proceso(entrada.getArrayPatrones_k());
    }
    public void  modelo_Hopfield(Scanner s){
        entrada=new entrada(s);
        entrada.definirPatronesE();
        hopfield=new entrenaHopfield();
        hopfield.fase_Recuperacion(entrada.getArrayPatrones_k().size(),entrada.getNeuronas_x());
        if (hopfield.getBuena_Recu()){
            System.out.println("Buena recuperación!");
            if (hopfield.getExcelente_Recu()){
                System.out.println("Excelente recuperación");
            }else {System.out.println("No tiene Excelente Recuperación"); }
            if (hopfield.ortogonalidad(entrada.getArrayPatrones_k(),entrada.neuronas_x)){
                System.out.println("Cumple con ortogonalidad minima del 50%");
                //proceso
                hopfield.matriz_PesosW(entrada.getNeuronas_x(),entrada.getArrayPatrones_k());
                do {
                    System.out.println("Aprendizaje completado . Listo para probar");
                    entrada=new entrada(s);
                    entrada.definirPatronesE();
                    hopfield.probar(entrada.getArrayPatrones_k().get(0).getNeuronas());
                    System.out.println("¿Probar con otro patrón?\n1.Si\n2.No");
                }while (s.nextInt()==1);
            }else {
                System.out.println("No cumple con ortogonalidad minima del 50%, cambiar patrones");
                modelo_Hopfield(s);
            }
        }else {
            System.out.println("No tiene buena recuperación");
            System.out.println("Cambiar número de neuronas");
            modelo_Hopfield(s);
        }
    }
    public static void main(String[]args){
        Main obj=new Main();
    }
}
