
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
    static Random random = new Random();
    static String[] desafios = new String[5];
    static int linhaUsuario = 0;

    static String[] enredo = new String[]{
        "Toda história tem um início e a sua começa aqui...",
        "Jornal Senac 10/02/2098 - \"Nova descoberta revolucionária promete rejuvenescer pessoas\"",
        "Jornal Senac 15/06/2098 - \"A descoberta foi um sucesso e recebe o nome de 942z\"",
        "Jornal Senac 06/09/2099 - \"Teste da milagrosa 942z em humanos começa\"",
        "Como um dia qualquer você acorda um dia ensolarado, tudo ocorre normalmente a única ",
        "coisa que te incomoda é esse cheiro incessante de queimado",
        "quando você se aproxima avista ao lado leste da cidade fumaça subindo, quando passa ",
        "carros de polícia e de bombeiros.",
    };
    
    static String[] creditos = new String[] {
        "==================",
        "     CRÉDITOS     ",
        "==================",
        "Esse foi o nosso jogo, esperamos que tenham gostado e obrigado por jogar. :)",
        "     FEITO POR:   ",
        "-------------------",
        "Felipe Canejo",
        "Jardel Junior",
        "Lucas De Jesus",
        "Lucas Santiago"
    };
    
    static String[] facil = new String[]{
        "Facil a",
        "Facil b",
        "Facil c",
        "Facil d"
    };
    static String[] medio = new String[]{
        "Medio e",
        "Medio f",
        "Medio g"
    };
    static String[] dificil = new String[]{
        "Dificil h",
        "Dificil i",
        "Dificil j"
    };

    static void novoJogo() {
        dificuldadeJogo();
        for (int i = 0; i < enredo.length; i++) {
            System.out.println(enredo[linhaUsuario]);
            //System.out.println("Aparte qualquer letra:");
            //input.next();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            linhaUsuario++;
        }
        System.out.println("Fim");
        creditos(true);
    }

    static int direcaoEnredo() {

        int escolha = escolha();

        switch (escolha) {
            case 1:
                linhaUsuario = 3;
                return linhaUsuario;

            case 2:
                linhaUsuario = 5;
                return linhaUsuario;

            case 3:
                linhaUsuario = 7;
                return linhaUsuario;

        }
        return 0;
    }

    static void comoJogar() {
        System.out.println("Aperte qualquer tecla para voltar...");

        exibirMenu();
    }

    static void creditos(boolean fimJogo) {
        
        for (int i = 0; i < creditos.length; i++) {
            System.out.println(creditos[i]);
            if(fimJogo) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
            }
        }
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
                creditos(false);
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
        int num = 1 + random.nextInt(20);
        return num;
    }

    static void dificuldadeJogo() {
        System.out.println("Escolha um nível de dificuldade: \n1-Fácil\n2-Médio\n3-Dificil");
        int escolhaUser = input.nextInt();
        int perguntaEscolhida = 0;
        switch (escolhaUser) {
            case 1:
                for (int i = 0; i < facil.length; i++) {
                    desafios[i] = facil[i];
                }
                perguntaEscolhida = random.nextInt(3) + 1;
                desafios[desafios.length - 1] = medio[perguntaEscolhida - 1];
                break;
            case 2:
                for (int i = 0; i < medio.length; i++) {
                    desafios[i] = medio[i];
                }
                perguntaEscolhida = random.nextInt(4) + 1;
                desafios[desafios.length - 1] = facil[perguntaEscolhida - 1];
                perguntaEscolhida = random.nextInt(3) + 1;
                desafios[desafios.length - 1] = dificil[perguntaEscolhida - 1];
                break;
            case 3:
                for (int i = 0; i < dificil.length; i++) {
                    desafios[i] = dificil[i];
                }
                perguntaEscolhida = random.nextInt(3) + 1;
                desafios[desafios.length - 1] = medio[perguntaEscolhida - 1];
                perguntaEscolhida = random.nextInt(4) + 1;
                desafios[desafios.length - 1] = facil[perguntaEscolhida - 1];
                break;
        }
        
        for (int i = 0; i < desafios.length; i++) {
            System.out.println(desafios[i]);
        }
    }

    public static void main(String[] args) {
        exibirMenu();
    }
}
