
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;

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

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static String[][] desafios = new String[5][9];
    static int linhaUsuario = 0;
    static int desafiosResolvidos = 0;

    static String[] comoJogar = new String[]{
        "Este jogo consiste em perguntas e respostas, onde vc decide a dificuldade dessas perguntas.",
        "",
        "A cada pergunta você tem direito a girar um dado, e dependendo do valor desse dado você podera obter dicas para as respectivas perguntas.",
        "",
        "Não se preocupe em errar!você podera tentar quantas vezes for necessário."

    };

    static String[] enredo = new String[]{
        "Toda história tem um início e a sua começa aqui...",
        "Jornal Senac 10/02/2098 - \"Nova descoberta revolucionária promete rejuvenescer pessoas\"",
        "Jornal Senac 15/06/2098 - \"A descoberta foi um sucesso e recebe o nome de 942z\"",
        "Jornal Senac 06/09/2099 - \"Teste da milagrosa 942z em humanos começa\"",
        "Como um dia qualquer você acorda um dia ensolarado, tudo ocorre normalmente a única ",
        "coisa que te incomoda é esse cheiro incessante de queimado",
        "quando você se aproxima avista ao lado leste da cidade fumaça subindo, quando passa ",
        "carros de polícia e de bombeiros.",};

    static String[] creditos = new String[]{
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

    static String[][] facil = new String[][]{
        {"Facil a", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},
        {"Facil b", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},
        {"Facil c", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},
        {"Facil d", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},};

    static String[][] medio = new String[][]{
        {"Medio e", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},
        {"Medio f", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},
        {"Medio g", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},};

    static String[][] dificil = new String[][]{
        {"Dificil h", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},
        {"Dificil i", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},
        {"Dificil j", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4", "a", "Dica 1", "Dica 2", "Dica 3"},};

    static void novoJogo() {
        //Escolha da dificuldade e escolha dos desafios
        dificuldadeJogo();

        for (int i = 0; i < enredo.length; i++) {
            System.out.println(enredo[linhaUsuario]);
            exibirDesafio();
            //System.out.println("Aparte qualquer letra:");
            //input.next();

            //Espera 3 segundos para exibir o próximo trecho da história
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            linhaUsuario++;
        }
        System.out.println("Fim");

        creditos(true);
    }

    static void exibirDesafio() {
        //TODO Controle de 3 dicas para o usuário

        //Verificando se ainda existe desafios a serem resolvidos
        if (desafiosResolvidos < desafios.length) {
            boolean acertou = false;
            //Recuperando próximo desafio
            String[] proximoDesafio = desafios[desafiosResolvidos];
            //Retornando resposta correta do desafio
            String respostaCorreta = proximoDesafio[5];
            String respostaUsuario;
            char[] opcoes = new char[]{'a', 'b', 'c', 'd'};

            //Separando as dicas em uma variável separada
            String[] dicas = new String[3];
            int indexDica = 0, desejoUsuario = 0, dicasExibidas = 0;
            //Começa do 6 pois na matrix dos desafios as dias estão a partir do indice 6
            for (int i = 6; i < proximoDesafio.length; i++) {
                dicas[indexDica] = proximoDesafio[i];
                indexDica++;
            }

            do {
                //Exibindo enunciado do desafio
                System.out.println(proximoDesafio[0]);

                //Exibindo alternativas
                for (int i = 1; i < 5; i++) {
                    System.out.println(opcoes[i - 1] + ") " + proximoDesafio[i]);
                }
                if (dicasExibidas < dicas.length) {
                    System.out.printf("O que deseja fazer? \n 1) Rolar o dado para uma dica \n 2) Reponder desafio \n");
                    desejoUsuario = input.nextInt();
                    if (desejoUsuario == 1) {
                        int dado = jogarDado1a20();
                        System.out.printf("Você tirou %s%d%s no dado\n", ANSI_CYAN, dado, ANSI_RESET);
                        if (dado == 20) {
                            System.out.println("Como você tirou 20 você tem o direito de ver todas as dicas:");
                            for (int i = 0; i < dicas.length; i++) {
                                System.out.println("Dica " + (i + 1) + "/" + dicas.length + " - " + dicas[i]);
                            }
                            dicasExibidas = dicas.length + 1;
                        } else if (dado == 1) {
                            System.out.println("Como você tirou 1 você perdeu todas as dicas.");
                            dicasExibidas = dicas.length + 1;
                        } else if (dado >= 15) {
                            System.out.println("Dica " + (dicasExibidas + 1) + "/" + dicas.length + " - " + dicas[dicasExibidas]);
                            dicasExibidas++;
                        } else {
                            System.out.println("Valor insuficiente, tente na próxima.");
                        }
                    }
                } else {
                    System.out.println("Acabou suas dicas!");
                }
                System.out.print("Resposta: ");
                respostaUsuario = input.next();
                acertou = respostaUsuario.equalsIgnoreCase(respostaCorreta);
                if (!acertou) {
                    System.out.println(ANSI_RED + "Reposta incorreta." + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + "Certa resposta." + ANSI_RESET);
                }

            } while (!acertou);

            desafiosResolvidos++;
        }
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

    static void comoJogar() {
        exibirTexto(comoJogar, false);
    }

    static void creditos(boolean fimJogo) {
        exibirTexto(creditos, fimJogo);
    }

    static void exibirTexto(String[] texto, boolean interruptor) {
        for (int i = 0; i < texto.length; i++) {
            System.out.println(texto[i]);

            if (interruptor) {
                //Espera 2 segundos para exibir o próximo trecho dos créditos
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        System.out.println("Aperte qualquer tecla para voltar...");
        input.next();
        exibirMenu();
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
        switch (escolhaUser) {
            case 1: //Fácil

                desafios = embaralhar(facil);
                desafios[desafios.length - 1] = retornarItemAleatorio(medio);

                break;
            case 2: //Médio
                desafios[0] = retornarItemAleatorio(facil);

                String[][] medioEmbaralhado = embaralhar(medio);

                for (int i = 0; i < medioEmbaralhado.length; i++) {
                    desafios[i + 1] = medioEmbaralhado[i];
                }

                desafios[desafios.length - 1] = retornarItemAleatorio(dificil);
                break;
            case 3: //Difícil                
                desafios[0] = retornarItemAleatorio(facil);
                desafios[1] = retornarItemAleatorio(medio);

                String[][] dificilEmbaralhado = embaralhar(dificil);

                for (int i = 0; i < dificilEmbaralhado.length; i++) {
                    desafios[i + 2] = dificilEmbaralhado[i];
                }
                break;
        }
    }

    static String[] retornarItemAleatorio(String[][] desafios) {
        int indiceAleatorio = random.nextInt(desafios.length) + 1;
        return desafios[indiceAleatorio - 1];
    }

    static String[][] embaralhar(String[][] matriz) {
        Collections.shuffle(Arrays.asList(matriz));
        return matriz;
    }

    public static void main(String[] args) {
        exibirMenu();
    }
}
