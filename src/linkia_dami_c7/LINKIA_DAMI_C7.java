/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkia_dami_c7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dmorenoar
 */
public class LINKIA_DAMI_C7 {

    /**
     Desarrollar un programa que calcule la factura de un paciente en un hospital. El usuario introducirá:
        El número de días en el hospital. 
        El coste de la consulta. 
        El precio de los medicamentos. 
        Costes diversos. 
        El precio por día. 
        La deducción por seguro.
        
        El programa tiene que calcular:

         El coste total.
        double costeTotal(int num, double coste, double precio, double diversos, double precioDia)

         El coste total menos la deducción por seguro.
        double costeTotal(int num, double coste, double precio, double diversos, double precioDia, double seg)

         El coste total menos el coste de los medicamentos y la deducción por seguro.
        double costeReducido(int num, double coste, double precio, double diversos, double precioDia, double seg)

        Los datos se tienen que pedir y mostrar desde el main. Se tiene que crear las funciones tal y como marca el enunciado.
     */
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num;
        double coste = 0.0, precio = 0.0, diversos = 0.0, precioDia = 0.0, asseg = 0.0;
        
        
        do{
            System.out.println("Introduce el número de dias en el hospital");
            num = sc.nextInt();
        }while (num < 0);
        /*
        //El BufferReader va con punto -> Ejemplo 10.5 10.8
        System.out.println("Lectura con buffer");
        double valor = Double.parseDouble(br.readLine());        
        */
        
        //El scanner va con , -> Ejemplo: 12,5 13,8
        System.out.println("Introduce el coste");
        coste = sc.nextDouble();
        
        System.out.println("Introduce el precio de los medicamentos");
        precio = sc.nextDouble();
        
        System.out.println("Introduce los gastos diversos");
        diversos = sc.nextDouble();
        
        System.out.println("Introduce el precio por dia");
        precioDia = sc.nextDouble();
        
        System.out.println("Introduce la deducción del seguro");
        asseg = sc.nextDouble();
        
        
        /*Tenemos dos formas para mostrar los datos, en primer lugar poner el resultado en una variable y luego mostrarla o utilizarla
        mucho más adelante.
        En el segundo caso, mostrar directamente el valor por el system out print y lo pierdo*/
        double costeTotal = costeTotal(num, coste, precio, diversos, precioDia);
        System.out.println("El coste total del servicio es: " + costeTotal);
        
        System.out.println("El coste total del servicio es: " + costeTotal(num, coste, precio, diversos, precioDia));
        
        System.out.println("El coste con el descuento del seguro es: " + costeTotal(num, coste, precio, diversos, precioDia, asseg));
    
        
        System.out.println("El coste total incluyendo el seguro y reduciendo el coste "
                + "de los medicamentos es: " + costeReducido(num, coste, precio, diversos, precioDia, asseg));
       
        
        //Creación de un número random
        Random intRandom = new Random();
        

        int random = intRandom.nextInt(6); //Genera un numero que va del 0 al 5 . 
        
        int random2 = intRandom.nextInt(6) + 1 ; //Genera un numero que va del 1 al 6. 
        
        System.out.println("Tu numero aleatorio es:"  + random);
        
    }
    
    /*
    Desc: Calcula el coste total del la consulta.
    Input: Recibe el numero de dias, el coste de la consulta, precio medicamentos, gastos diversos y el precio por dia.
    Output: La suma del coste total.
    */
    static double costeTotal(int num, double coste, double precio, double diversos, double precioDia){
        /*
        double total = 0.0;
        total = num + coste + precio + diversos + precioDia;
        return total;
        */
        return (num + coste + precio + diversos + precioDia);
    }
    
    /*
    //Sobrecarga de la función costeTotal
    static double costeTotal(int num, double coste, double precio, double diversos, double precioDia, double seg){
        return (num + coste + precio + diversos + precioDia) - seg;
    }*/
    
    
    /*Sobrecarga + Reciclaje de funciones*/
    static double costeTotal(int num, double coste, double precio, double diversos, double precioDia, double seg){
        return costeTotal(num, coste, precio, diversos, precioDia) - seg;
    }
    
     /*
    Desc: Calcula el coste total menos el coste de los medicamentos y la deducción por seguro.
    Input: Recibe el numero de dias, el coste de la consulta, precio medicamentos, gastos diversos, precio por dia y descuento del seguro.
    Output: El coste reducido con la resta al coste total.
    */
    static double costeReducido(int num, double coste, double precio, double diversos, double precioDia, double seg){
        double total = 0.0;
       
        total = costeTotal(num, coste, precio, diversos, precioDia, seg) - coste;

        return total;
    }
    
}
