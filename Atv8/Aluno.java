package br.com.frwk.Atv8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Aluno {
    private Integer matricula;
    private String nome;
    private String turma;
    private Double notaProva1;
    private Double notaProva2;
    private Double notaProva3;
    private Double notaEx;
    private Double total;
    private StatusAluno status;

    public static Double calcularNotaTotal(Double notaEx, Double notaProva1, Double notaProva2, Double notaProva3){
        Double totalNota = (notaEx + notaProva1 + notaProva2 + notaProva3);

        if (totalNota > 100){
            totalNota = 100.0;
        }
        return totalNota;
    }

    public static StatusAluno calcularStatusAprovacao(Double total){
        if (total >= 60){
            return StatusAluno.Aprovado;
        }
        if (total >= 50 && total < 60){
            return StatusAluno.Recuparacao_1;
        }
        if (total >= 40 && total < 50){
            return StatusAluno.Recuperacao_2;
        }

        return StatusAluno.Reprovado;
    }

    @Override
    public String toString(){
        return "Matricula: " + this.matricula + "\n" +
                "Nome: " + this.nome + "\n" +
                "Turma: " + this.turma + "\n" +
                "Status: " + this.status;
    }
}
