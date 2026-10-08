package com.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ModulosEstudiantes 
{
    public static void main( String[] args )
    {
        Set<Estudiante> estudiantes = new TreeSet<>(
            Comparator.comparing(Estudiante::getDocumento));

        Map<String, Double> notas=new HashMap<>();

            Scanner sc=new Scanner(System.in);

        try {
            estudiantes.add(new Estudiante("Fabian", "123456789", NivelCurso.BASICO));
            estudiantes.add(new Estudiante("Eduard", "345678903", NivelCurso.INTERMEDIO));
            estudiantes.add(new Estudiante("Fabian", "654321459", NivelCurso.AVANZADO));

            for(Estudiante estudiante : estudiantes){
                System.out.print("ingrese la nota del estudiante "+estudiante.getNombre()+":");
                double nota=sc.nextDouble();

                if(nota<0|| nota>10){
                    throw new NotaInvalidaException("La nota debe estar entre 0 y 10");
                }
                
                notas.put(estudiante.getDocumento(), nota);
            }

            System.out.println("Lista de estudiantes");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante.toString());
            }

            System.out.println("Ingrese el numero de documento del estudiante a consultar");
                String doc=sc.next();

                if(notas.containsKey(doc)){
                    System.out.println("La nota es "+notas.get(doc));
                }else{
                    System.out.println("estudiante no encontrado.");
                }
        } catch (NotaInvalidaException e) {
            System.out.println("Error general: "+e.getMessage());

        } catch(InputMismatchException e){
            System.out.println("se esperaba un numero valido");
        } catch(Exception e){
            System.out.println("error "+e.getMessage());
        }
        finally{
            sc.close();
            System.out.println("Cerrando programa, Muchas gracias");
        }
        
    }

    
    
}
