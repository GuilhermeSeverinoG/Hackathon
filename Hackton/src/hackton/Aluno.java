
package hackton;

/**
 *
 * @author Guilh
 */
public class Aluno {
    private int idAluno;
    private String nomeAluno;
    private int turma = 0;
    private double n1, n2, n3, media;
    private boolean situacao;

    public Aluno() {
    }

    public Aluno(int idAluno, String nomeAluno, int turma, double n1, double n2, double n3) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.turma = turma;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public double getN3() {
        return n3;
    }

    public void cadastrarNotas(double n1, double n2, double n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public double calcularMedia() {
        this.media = (n1 + n2 + n3) / 3;
        return media;
    }
    public boolean getSituacao() {
        if (((n1 + n2 + n3) / 3) >= 7) {
            situacao = true;
        } else {
            situacao = false;
        }
        return situacao;
    }

}
