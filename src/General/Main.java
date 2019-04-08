package General;

import java.util.Scanner;
import perceptron.*;
import hopfield.*;

import javax.sound.midi.Soundbank;

public class Main {
    entrada entrada;
    entrenamiento entrenamiento;
    entrenaHopfield hopfield;
    Main(){
        System.out.println("****Elije un modelo***");
        System.out.println("1.Perceptron");
        System.out.println("2.Hopfield");
        Scanner s = new Scanner(System.in);
        switch (s.nextInt()){
            case 1:
                modelo_Perceptron(s);
                break;
            case 2:modelo_Hopfield(s);
                break;
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
