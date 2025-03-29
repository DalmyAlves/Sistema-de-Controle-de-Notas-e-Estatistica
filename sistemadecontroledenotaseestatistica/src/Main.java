import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        do {
            System.out.print("Quantos alunos deseja cadastrar? ");
            int totalalunos = sc.nextInt();
            sc.nextLine();

            String[] nomes = new String[totalalunos];
            double[][] notas = new double[totalalunos][2];
            double[] medias = new double[totalalunos];

            double somaMedia = 0;
            double maiorNota = -1;
            double menorNota = 11;

            int aprovados = 0;
            int recuperacao = 0;
            int reprovados = 0;

            for ( int i = 0; i < totalalunos; i++ ) {
                System.out.print("Nome do aluno(a) " + (i +1) + ": ");
                nomes[i] = sc.nextLine();

                for ( int j = 0; j < 2; j++ ) {
                    boolean notaValida;
                    do {
                        System.out.print ("Nota " + (j +1 ) + " de " + nomes[i] + ": ");
                        notas[i][j] = sc.nextDouble();
                        notaValida = notas[i][j] >= 0 && notas[i][j] <= 10;
                        if (!notaValida) {
                            System.out.println ("Nota inválida! Insira um valor entre 0 e 10.");
                        }
                    } while (!notaValida);

                    if (notas[i][j] > maiorNota) {
                        maiorNota = notas[i][j];
                    }
                    if (notas[i][j] < menorNota) {
                        menorNota = notas[i][j];
                    }
                }
                sc.nextLine();

                medias[i] = (notas[i][0] + notas[i][1]) / 2.0;
                somaMedia += medias[i];

                if (medias[i] >= 7){
                    aprovados++;
                } else if (medias[i] >= 5 ){
                    recuperacao++;
                } else {
                    reprovados++;
                }
            }
            System.out.println ("\nResultados:");
            for ( int i = 0; i < totalalunos; i++ ) {
                String status;
                if (medias[i] >= 7) {
                    status = "aprovado";
                } else if (medias[i] >= 5) {
                    status = "Recuperação";
                } else {
                    status = "reprovado";
                }

                System.out.printf ("%s - Média: %.2f - Status: %s%n", nomes[i], medias[i], status);
            }

            double mediaTurma = somaMedia / totalalunos;

            System.out.printf ("%nMédia da turma: %.2f%n", mediaTurma);
            System.out.println ("Maior nota registrada: " + maiorNota);
            System.out.println ("Menor nota registrada: " + menorNota);
            System.out.println ("Total de aprovados: " + aprovados);
            System.out.println ("Total em recuperação: " + recuperacao);
            System.out.println ("Total de reprovados: " + reprovados);

            System.out.print ("\nDeseja cadastrar outra turma? (S/N): ");
            continuar = sc.nextLine().trim ().toUpperCase();

        } while (continuar.equals ("S"));

        System.out.println ("Sistema encerrado.");
        sc.close();
    }
}
