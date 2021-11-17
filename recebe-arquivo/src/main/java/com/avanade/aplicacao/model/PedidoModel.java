package com.avanade.aplicacao.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data @Builder
public class PedidoModel {

    private Integer codigo;
    private ClienteModel cliente;
    private BigDecimal valorTotal;
    private String numeroCartao;
    private Date data;
    private List<ItemModel> itens;

}
