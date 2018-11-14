package br.com.alura.agenda.modelo;

import java.io.Serializable;
import java.util.List;

public class Prova implements Serializable {
    private String materia;
    private String data;
    private List<String> conteudo;

    public Prova(String materia, String data, List<String> conteudo) {
        this.materia = materia;
        this.data = data;
        this.conteudo = conteudo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<String> conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return this.materia;
    }
}


