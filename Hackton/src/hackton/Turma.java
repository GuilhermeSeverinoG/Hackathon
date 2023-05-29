package hackton;

import java.util.ArrayList;

/**
 *
 * @author Guilh
 */
public class Turma {
    private int idTurma;
    private String nomeTurma;
    private int qtdeAlunos;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public Turma() {
    }

    public Turma(int idTurma, String nomeTurma, int qtdeAlunos, ArrayList<Aluno> alunos) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.qtdeAlunos = qtdeAlunos;
        this.alunos = alunos;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public int getQtdeAlunos() {
        return qtdeAlunos;
    }

    public void setQtdeAlunos(int qtdeAlunos) {
        this.qtdeAlunos = qtdeAlunos;
    }

    public Aluno getAlunos(int opcaoTurma) {
        return alunos.get(opcaoTurma);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno alunos) {
        this.alunos.add(alunos);
    }
}

