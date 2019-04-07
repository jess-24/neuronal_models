package General;

import java.util.Scanner;
import perceptron.*;
public class Main {
    entrada entrada;
    entrenamiento entrenamiento;
    Main(){
        System.out.println("****Elije un modelo***");
        System.out.println("1.Perceptron");
        System.out.println("2.Hopfield");
        Scanner s = new Scanner(System.in);
        switch (s.nextInt()){
            case 1:
                modelo_Perceptron(s);
                break;
        }
    }
    public void modelo_Perceptron(Scanner s){
        entrada=new entrada(s);
        entrada.definirPatronesE_S();
        entrenamiento=new entrenamiento();
        entrenamiento.aprendizaje(entrada.getNeuronas_x());
        entrenamiento.proceso(entrada.getArrayPatrones_k());
    }
    public static void main(String[]args){
        Main obj=new Main();
    }
}
