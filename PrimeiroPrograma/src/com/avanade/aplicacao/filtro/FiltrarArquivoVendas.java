package com.avanade.aplicacao.filtro;

import java.io.File;
import java.io.FilenameFilter;

public class FiltrarArquivoVendas implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        String nomeUpper = name.toUpperCase();
        return nomeUpper.matches("(VENDAS)-([0-9]{4})-([0-9]{2})-([0-9]{2})\\.(TXT)");
    }
}
