package com.example;

import java.util.Objects;

public class Estudiante {
    private String nombre;
    private String documento;
    private NivelCurso nivel;

    public Estudiante(String pNombre, String pDocumento, NivelCurso pNivel){
        nombre=pNombre;
        documento=pDocumento;
        nivel=pNivel;
    }

    public String getNombre(){
        return nombre;
    }
    public String getDocumento(){
        return documento;
    }

    public NivelCurso getNivel(){
        return nivel;

    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setDocumento(String documento){
        this.documento=documento;
    }

    public void setNivel(NivelCurso nivel){
        this.nivel=nivel;
    }

    @Override 
    public String toString(){
        return nombre + "("+documento+") -Nivel:"+nivel;
    }

    @Override 
    public boolean equals(Object o){
        if(this==o) return true;

        if(!(o instanceof Estudiante e)) return false;

        return Objects.equals(documento, e.getDocumento());
}

@Override 
public int hashCode(){
    return Objects.hash(documento);
}
}