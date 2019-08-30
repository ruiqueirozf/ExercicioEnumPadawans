package br.com.frwk.Atv8;

//Escreva um programa que apresente as seguintes opções para o usuário:
//- Cadastrar novo aluno:
//- Consultar aluno por matricula:
//- Listar alunos aprovados:
//- Listar alunos reprovados:
//- Listar alunos de recuperação:
//- Sair
//
//Para cadastrar um aluno,
// peça que o usuário informe
// matricula, nome, turma, nota das três provas semestrais e nota de exercícios em sala.
// Com esses dados, classifique o aluno quanto a seu status de aprovação,
// de acordo com a nota a tabela abaixo.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio08 {
    public static List<Aluno> alunos = new ArrayList<Aluno>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("1 - Cadastrar Aluno");

            System.out.println("2 - Consultar aluno por matricula: ");

            System.out.println("3 - Lista alunos aprovados: ");

            System.out.println("4 - Lista alunos reprovados: ");

            System.out.println("5 - Listar alunos de recuperação: ");

            System.out.println("0 - Sair");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    System.out.println("Qual matricula do aluno: ");
                    consultarAlunoPorMatricula(Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    listarAlunosAprovados();
                    break;
                case 4:
                    listarAlunosReprovados();
                    break;
                case 5:
                    listarAlunosEmRecuperacao();
                    break;
            }
        } while (opcao != 0);
    }

    public static void cadastrarAluno() {
        Integer matricula;
        String nome;
        String turma;
        Double notaProva1;
        Double notaProva2;
        Double notaProva3;
        Double notaEx;

        System.out.println("Digite a matricula do aluno: ");
        matricula = Integer.parseInt(sc.nextLine());

        System.out.println("Digite o nome do aluno: ");
        nome = sc.nextLine();

        System.out.println("Digite a turma: ");
        turma = sc.nextLine();

        System.out.println("Digite a nota da prova 1: ");
        notaProva1 = Double.parseDouble(sc.nextLine());

        System.out.println("Digite a nota da prova 2: ");
        notaProva2 = Double.parseDouble(sc.nextLine());

        System.out.println("Digite a nota da prova 3: ");
        notaProva3 = Double.parseDouble(sc.nextLine());

        System.out.println("Digite a nota de exercicio: ");
        notaEx = Double.parseDouble(sc.nextLine());

        Double total = Aluno.calcularNotaTotal(notaEx, notaProva1, notaProva2, notaProva3);

        StatusAluno status = Aluno.calcularStatusAprovacao(total);

        //instanciar classe vendedor e adicionar vendedor a lista
        Aluno aluno = new Aluno(matricula, nome, turma, notaProva1, notaProva2, notaProva3, notaEx, total, status);

        alunos.add(aluno);
    }

    public static void listarAlunosAprovados(){
        for(Aluno aluno: alunos){
            if (aluno.getStatus().equals(StatusAluno.Aprovado))
                System.out.println(aluno);
        }
    }
    public static void listarAlunosReprovados(){
        for(Aluno aluno: alunos){
            if (aluno.getStatus().equals(StatusAluno.Reprovado))
                System.out.println(aluno);
        }
    }

    public static void listarAlunosEmRecuperacao(){
        for(Aluno aluno: alunos){
            if (aluno.getStatus().equals(StatusAluno.Recuparacao_1)
                    || aluno.getStatus().equals(StatusAluno.Recuperacao_2))
                System.out.println(aluno);
        }
    }

    public static void consultarAlunoPorMatricula(Integer matricula){
        for (Aluno aluno: alunos){
            if (aluno.getMatricula().equals(matricula)){
                System.out.println(aluno);
            }
        }
    }

}
