package com.avanade.aplicacao;

import com.avanade.aplicacao.servicos.ServicoProcessarArquivos;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Locale;

public class Programa {

    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Parâmetro caminho é obrigatório");
            System.out.println("Uso: ");
            System.out.println("Java Programa [CAMINHO]");
            System.exit(-1);
            return;
        }

        System.out.println("Iniciando aplicação... ");
        Programa programa = new Programa();
        programa.iniciar(args[0]);
    }

    private void iniciar(String caminhoDirEntrada){
        ServicoProcessarArquivos servicos = new ServicoProcessarArquivos(caminhoDirEntrada);
        servicos.executar();
    }
}
