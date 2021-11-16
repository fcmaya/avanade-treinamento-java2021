package com.avanade.aplicacao.servicos;

import com.avanade.aplicacao.model.PedidoModel;
import com.avanade.aplicacao.validacoes.ValidarArquivos;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class ServicoProcessarArquivos {

    private Path dirEntrada;
    private final List<String> lstArquivos;

    public ServicoProcessarArquivos(String caminhoDirEntrada){
        ValidarArquivos validacao = new ValidarArquivos();
        dirEntrada = validacao.validarDirEntrada(caminhoDirEntrada);
        lstArquivos = validacao.getLstArquivos();
    }

    public void executar(){
        if(lstArquivos.isEmpty()){
            log.info("Não há arquivos para processamento");
            return;
        }

        ServicoLerArquivo servicoLerArquivo = new ServicoLerArquivo();
        lstArquivos.forEach((arquivo) -> {
            log.info("Processando aquivo: {}", arquivo);
            String caminhoArquivo = dirEntrada.toString() + File.separator + arquivo;

            List<PedidoModel> pedidos = servicoLerArquivo.executar(caminhoArquivo);
            if(pedidos.isEmpty()){
                log.info("Não há registro no arquivo [{}]", caminhoArquivo);
                return;
            }

            log.info("Encontradas [{}] linhas no arquivo {}", pedidos.size(), caminhoArquivo);

            // TODO Gravar no banco de dados
        });
    }


}
