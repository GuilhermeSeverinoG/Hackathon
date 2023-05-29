package hackton;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int opcao = 0, idAluno = 1, idTurma = 1, opcaoTurma, opcaoAluno, n1, n2, n3;
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        Turma turma = new Turma();

        while (opcao != 6) {
            System.out.println("* Sistema da secretaria - Escola Jesuitas* ");
            System.out.println("-----------------------------------------");
            System.out.println("|          1- Cadastrar Alunos          |");
            System.out.println("|          2- Cadastrar Turma           |");
            System.out.println("|          3- Preencher Turma           |");
            System.out.println("|          4- Cadastrar Notas           |");
            System.out.println("|          5- Gerar Relatorio           |");
            System.out.println("|          6- Sair                      |");
            System.out.println("-----------------------------------------");
            System.out.print("Digite uma opcao: ");
            //System.out.println("ESCOLHA OPÇÃO");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    aluno = new Aluno();
                    System.out.println("************ Cadastrar Alunos ***********");
                    aluno.setIdAluno(idAluno++);
                    System.out.print("Nome do aluno: ");
                    aluno.setNomeAluno(scan.next());
                    System.out.println("*****************************************\n");
                    alunos.add(aluno);
                    break;
                case 2:
                    turma = new Turma();
                    System.out.println("************* Cadastrar turma *************");
                    turma.setIdTurma(idTurma++);
                    System.out.print("Nome da turma: ");
                    turma.setNomeTurma(scan.next());
                    System.out.print("Quantidade de vagas: ");
                    turma.setQtdeAlunos(scan.nextInt());
                    System.out.println("*******************************************\n");
                    turmas.add(turma);
                    break;
                case 3:
                    if (turmas.isEmpty()) {
                        System.out.println("ERRO!: Nenhuma turma cadastrada\n");
                        break;
                    }
                    System.out.println("************* Preencher turmas *************");
                    System.out.println("------------ Turmas cadastradas ------------");
                    for (int i = 0; i < turmas.size(); i++) {
                        System.out.println((i + 1) + " - " + "id: " + turmas.get(i).getIdTurma() + " Nome: " + turmas.get(i).getNomeTurma() + " Vagas: " + turmas.get(i).getQtdeAlunos());
                    }
                    System.out.println("--------------------------------------------");
                    
                    System.out.print("Selecione uma turma: ");
                    opcaoTurma = scan.nextInt();
                    if (opcaoTurma > idTurma - 1 || opcaoTurma < 1) {
                        System.out.println("Erro!: Turma nao existe\n");
                        break;
                    }
                    System.out.println("------------ Alunos cadastrados ------------");        
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getTurma() == 0) {
                            System.out.println((i + 1) + " - " + "id: " + alunos.get(i).getIdAluno() + " Nome: " + alunos.get(i).getNomeAluno());
                        }
                    }
                    System.out.println("--------------------------------------------");
                    System.out.print("Selecione um aluno: ");
                    opcaoAluno = scan.nextInt();

                    if (opcaoAluno > idAluno - 1 || opcaoAluno < 1) {
                        System.out.println("Erro!: Aluno nao existe\n");
                        break;
                    }

                    if (alunos.get(opcaoAluno-1).getTurma() == 0) {
                        if (turmas.get(opcaoTurma-1).getQtdeAlunos() > 0) {
                            turmas.get(opcaoTurma-1).setAlunos(alunos.get(opcaoAluno-1));
                            turmas.get(opcaoTurma-1).setQtdeAlunos(turmas.get(opcaoTurma-1).getQtdeAlunos() - 1);
                            alunos.get(opcaoAluno-1).setTurma(turmas.get(opcaoTurma-1).getIdTurma());
                        } else {
                            System.out.println("A turma nao possui vagas");
                        }
                    } else {
                        System.out.println("O aluno selecionado ja possui turma");
                    }

                    System.out.println("----------- Alunos e suas turmas ------------");
                    for(int i = 0; i < turmas.size(); i++){
                        System.out.println("Alunos da turma "+ turmas.get(i).getNomeTurma()+":");
                        for(int j = 0; j < turmas.get(i).getAlunos().size(); j++){
                            System.out.println(turmas.get(i).getAlunos(j).getNomeAluno());
                        }
                    }
                    System.out.println("---------------------------------------------");
                    System.out.println("*********************************************\n");
                    break;                   
                case 4:
                    System.out.println("************** Cadastrar notas **************");
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum Aluno cadastrado");
                        break;
                    }
                    if (turmas.isEmpty()) {
                        System.out.println("Nenhuma Turma cadastrada");
                        break;
                    }

                    System.out.println("--------- Turmas que possuem alunos ---------");
                    for (int i = 0; i < turmas.size(); i++) {
                        if (turmas.get(i).getAlunos().size() > 0) {
                            System.out.println((i + 1) + " - " + "Nome: " + turmas.get(i).getNomeTurma());
                        }
                    }
                    System.out.print("Selecione uma turma: ");
                    opcaoTurma = scan.nextInt();
                    System.out.println("---------------------------------------------");
                    
                    if (opcaoTurma > idTurma - 1 || opcaoTurma < 1) {
                        System.out.println("Turma nao existe");
                        break;
                    }
                    
                    for(int i = 0; i < turmas.get(opcaoTurma-1).getAlunos().size(); i++){
                        System.out.println(i + 1 + " - " + turmas.get(opcaoTurma-1).getAlunos(i).getNomeAluno());
                        System.out.print("Informe a 1a nota: ");
                        n1 = scan.nextInt();
                        System.out.print("Informe a 2a nota: ");
                        n2 = scan.nextInt();
                        System.out.print("Informe a 3a nota: ");
                        n3 = scan.nextInt();
                        System.out.println("---------------------------------------------");
                        turmas.get(opcaoTurma-1).getAlunos(i).cadastrarNotas(n1, n2, n3);
                    }
                    System.out.println("*********************************************\n");
                    break;
                case 5:
                    if (alunos.isEmpty()) {
                        System.out.println("Erro!: Nenhum Aluno cadastrado");
                        break;
                    }

                    if (turmas.isEmpty()) {
                        System.out.println("Erro! Nenhuma Turma cadastrada");
                        break;
                    }
                    System.out.println("************** Gerar relatórios *************");
                    System.out.println("--------- Turmas que possuem alunos ---------");
                    for (int i = 0; i < turmas.size(); i++) {
                        if (turmas.get(i).getAlunos().size() > 0) {
                            System.out.println((i + 1) + " - " + "Nome: " + turmas.get(i).getNomeTurma());
                        }
                    }
                    System.out.print("Selecione uma turma: ");
                    opcaoTurma = scan.nextInt();
                    System.out.println("---------------------------------------------");

                    if (opcaoTurma > idTurma - 1 || opcaoTurma < 1) {
                        System.out.println("Erro: A turma nao existe");
                        break;
                    }
                    
                    System.out.println("----------------- Relatorio -----------------");
                    for(int i = 0; i < turmas.get(opcaoTurma-1).getAlunos().size(); i++){
                        System.out.println(i + 1 + " - " + turmas.get(opcaoTurma-1).getAlunos(i).getNomeAluno());
                        System.out.println("Media: " + turmas.get(opcaoTurma-1).getAlunos(i).calcularMedia());
                        if (turmas.get(opcaoTurma-1).getAlunos(i).calcularMedia() >= 7) {
                            System.out.println("APROVADO");
                        } else {
                            System.out.println("REPROVADO");
                        }
                    }
                    System.out.println("---------------------------------------------");
                    System.out.println("*********************************************");
                    break;
                case 6: 
                    break;
                default:
                    System.out.println("Erro!: Opçaoo invalida");
                    break;
            }
        }
    }
}
