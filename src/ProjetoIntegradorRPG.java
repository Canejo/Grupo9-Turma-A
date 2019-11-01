
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felipe.acanejo
 */
public class ProjetoIntegradorRPG {

    static Scanner input = new Scanner(System.in);
    static String[] enredo = new String[]{
        "Toda história tem um início e a sua começa aqui...",
        "Jornal Senac 10/02/2098 - \"Nova descoberta revolucionária promete rejuvenescer pessoas\"",
        "Jornal Senac 15/06/2098 - \"A descoberta foi um sucesso e recebe o nome de 942z\""
    };
    static int linhaUsuario = 0;
    
    
    static void novoJogo() {
        for(int i = 0; i < enredo.length; i++) {
            System.out.println(enredo[linhaUsuario]);
            //System.out.println("Aparte qualquer letra:");
            //input.next();
            
            try { Thread.sleep(3000); } catch (InterruptedException ex) {
            }
            linhaUsuario++;
        }
        System.out.println("Fim");
        creditos();
    }

    static void comoJogar() {
        System.out.println("Aperte qualquer tecla para voltar...");
        
        exibirMenu();
    }

    static void creditos() {
        System.out.println("==================");
        System.out.println("     CRÉDITOS     ");
        System.out.println("==================");
        System.out.println("Esse foi o nosso jogo, esperamos que tenhan gostado e obrigado por jogar. :)");
        System.out.println("==================");
        System.out.println("     FEITO POR:   ");
        System.out.println("==================");
        System.out.println("Felipe Canejo.\nJardel Junior.\nLucas De Jesus.\nLucas Santiago.");
        System.out.println("Aperte qualquer tecla para voltar...");
        input.next();
        exibirMenu();
    }

    static void exibirMenu() {
        int opcaoMenu = 0;

        do {
            System.out.println("1) Novo jogo");
            System.out.println("2) Como jogar");
            System.out.println("3) Créditos");
            System.out.println("4) Sair");
            System.out.print("Digite uma opção para continuar: ");
            opcaoMenu = input.nextInt();
        } while (opcaoMenu <= 0 || opcaoMenu > 4);

        selecionarMenu(opcaoMenu);
    }

    static void selecionarMenu(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                novoJogo();
                break;
            case 2:
                comoJogar();
                break;
            case 3:
                creditos();
                break;
        }
    }

    static int escolha() {
        int opcao = 0;
        do {
            char escolhaDoUsuario = input.next().charAt(0);

            switch (escolhaDoUsuario) {

                case 's':
                    opcao = 1;
                    break;
                case 'n':
                    opcao = 2;
                    break;
                case 'd':
                    opcao = 3;
                    break;

            }
            System.out.println(opcao);

        } while (opcao == 0);
        return opcao;
    }

    static int jogarDado1a20() {
        Random geraNum = new Random();
        int num = 1 + geraNum.nextInt(20);
        return num;
    }

    static String[] dificuldadeJogo() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        String[] perguntas = new String[5];
        Random random = new Random();
        String facil[] = new String[]{
            "a",
            "b",
            "c",
            "d"

        };
        String medio[] = new String[]{
            "e",
            "f",
            "g"

        };
        String dificil[] = new String[]{
            "h",
            "i",
            "j"
        };

        System.out.println("Escolha um nível de dificuldade: \n1-Fácil\n2-Médio\n3-Dificil");
        int escolhaUser = sc.nextInt();
        switch (escolhaUser) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        if(escolhaUser == 1){
            for (int i = 0; i < facil.length; i++) {
                perguntas[i] = facil[i];
            }
            int perguntaEscolhida = random.nextInt(3) + 1;
            perguntas[perguntas.length -1] = medio[perguntaEscolhida-1];
            
        }

        return perguntas;
    }

    public static void main(String[] args) {
        exibirMenu();

    }
}
