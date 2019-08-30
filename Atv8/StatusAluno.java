package br.com.frwk.Atv8;

public enum StatusAluno {
    Aprovado("Aprovado"),
    Recuparacao_1("Recuperacao_1"),
    Recuperacao_2("Recuperacao_2"),
    Reprovado("Reprovado");

    StatusAluno(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
