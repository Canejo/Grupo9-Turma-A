
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
         "Jornal Senac 15/06/2098 - \"A descoberta foi um sucesso e recebe o nome de 942z\"" ,
         "Jornal Senac 06/09/2099 - \"Teste da milagrosa 942z em humanos começa\"" ,
         "Como um dia qualquer você acorda um dia ensolarado, tudo ocorre normalmente a única " ,
         "coisa que te incomoda é esse cheiro incessante de queimado" ,
         "quando você se aproxima avista ao lado leste da cidade fumaça subindo, quando passa " ,
         "carros de polícia e de bombeiros." ,
         "Dica do mestre ligue a televisão." ,
         "Ligar televisão?" ,
         "Jornal senac - eles esconderam tudo de nós os testes deram errado fujam para o posto de ajuda." ,
         "bom infelizmente a transmissão foi cortada!" ,
         "- 	Continua a História	 -" ,
         "- 	Continua a História	-" ,
         "Quando você escuta “Saiam Já de suas casas é uma ordem, estamos checando todos os" ,
         "moradores desta região, então falarei mais uma vez, SAIAM JÀ DE SUAS CASA”." ,
         "é um policial com um alto - falante." ,
         "Vai sair de casa ?" ,
         "chegando na rua o soldado passa uma especie de maquina voce não entendo muito bem" ,
         "mais parece q eles esta procurando algo. Então ele te libera e continua chamando os outros" ,
         "moradores da rua. Até que eles chegam em frente a casa de seu melhor amigo. batem e" ,
         "batem mais parece que ele não está lá. entrando no carro do policial você avista em um tipo" ,
         "de papel alguns números porém esta incompleto." ,
    };

    static int ultimaEscolha = -1;
    static int[] ultimoIndice = new int[7];

    //{ NÚMERO ÍNDICE ENREDO, EXIBIR DESAFIO, DADO DO USUÁRIO >= 15 EXIBIR HISTÓRIA }
    //0 - NÃO 1 - SIM
    static int[][] indiceEnredo = new int[][] {
        { 8, 0, 1 },
        { 9, 0, 0, 10, 14, 15, 16 },
        { 17, 0, 0, 18, 19, 20, 21 },
        { 22, 1, 0 },
    };

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

    
    static int[] retornarIndiceEnrredo() {
        int[] indice = new int[3];

        for (int i = 0; i < indiceEnredo.length; i++) {
            if(indiceEnredo[i][0] == linhaUsuario) {
                indice = indiceEnredo[i];
            }
        }
        return indice;
    }

    static boolean indiceExibirDesafio() {
        boolean exibir = false;
        int[] indice = retornarIndiceEnrredo();

        if (indice[0] > 0) {
            exibir = indice[1] == 1;
        }

        return exibir;
    }

    static boolean indiceDado() {
        int desejoUsuario;
        boolean exibir = true;
        int[] indice = retornarIndiceEnrredo();

        if (indice[0] > 0) {
            if (indice[2] == 1) {
                System.out.printf("\nVocê pode ter uma dica do mestre, deseja jogar o dado? \n");
                desejoUsuario = escolha();
                if (desejoUsuario == 1) {
                    int dado = jogarDado1a20();
                    exibir = dado >= 15;
                    if (!exibir) {
                        System.out.printf("Valor insuficiente, tente na próxima.\n\n");
                    }
                } else {
                    exibir = false;
                }
            }
        }

        return exibir;
    }

    static void novoJogo() {
        linhaUsuario = 0;
        desafiosResolvidos = 0;
        limparEscolha();
        
        //Escolha da dificuldade e escolha dos desafios
        dificuldadeJogo();
        System.out.println("");
        do {
            int[] indice = retornarIndiceEnrredo();
            boolean linhaEscolhaUsuario = indice[0] > 0 && indice.length > 3;
            if (linhaEscolhaUsuario) {
                System.out.println("");   
            }
            if (indiceDado()) {
                System.out.println(enredo[linhaUsuario]);
            }
            
            if (linhaEscolhaUsuario) {
                //Salvando info do indice para verificar onde trecho da escolha termina
                ultimoIndice = indice;
                ultimaEscolha = escolha();
                System.out.println("");
                if (ultimaEscolha == 1) { //Sim
                    linhaUsuario = indice[3];
                } else if(ultimaEscolha == 2) { //Não
                    linhaUsuario = indice[5];
                }
            } else {
                //Espera 3 segundos para continuar
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                }
                if (indiceExibirDesafio()) {
                    exibirDesafio();
                }
                
                if (ultimaEscolha == 1 && linhaUsuario == ultimoIndice[4]){
                    linhaUsuario = ultimoIndice[6] + 1;
                    limparEscolha();
                } else if(ultimaEscolha == 1  && linhaUsuario == ultimoIndice[6]) {
                    limparEscolha();
                    linhaUsuario++;
                } else {
                    linhaUsuario++;
                }
            }
        } while(linhaUsuario < enredo.length);
        System.out.println("Fim");

        creditos(true);
    }
    
    static void limparEscolha() {
        ultimaEscolha = -1;
        ultimoIndice = new int[7];
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
                System.out.printf("\n%s\n", proximoDesafio[0]);

                //Exibindo alternativas
                for (int i = 1; i < 5; i++) {
                    System.out.println(opcoes[i - 1] + ") " + proximoDesafio[i]);
                }
                if (dicasExibidas < dicas.length) {
                    System.out.printf("\nO que deseja fazer? \n<1> Rolar o dado para uma dica \n<2> Reponder desafio \n");
                    desejoUsuario = input.nextInt();
                    if (desejoUsuario == 1) {
                        int dado = jogarDado1a20();
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
                            System.out.printf("Valor insuficiente, tente na próxima.\n\n");
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

    static void exibirMenu() {
        int opcaoMenu = 0;

        do {
            System.out.println("<1> Novo jogo");
            System.out.println("<2> Como jogar");
            System.out.println("<3> Créditos");
            System.out.println("<4> Sair");
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
            System.out.println("<S> Sim");
            System.out.println("<N> Não");
            char escolhaDoUsuario = input.next().toLowerCase().charAt(0);

            switch (escolhaDoUsuario) {

                case 's':
                    opcao = 1;
                    break;
                case 'n':
                    opcao = 2;
                    break;

            }
        } while (opcao == 0);
        return opcao;
    }

    static int jogarDado1a20() {
        int dado = 1 + random.nextInt(20);
        System.out.printf("\nVocê tirou %s%d%s no dado\n", ANSI_CYAN, dado, ANSI_RESET);

        return dado;
    }

    static void dificuldadeJogo() {
        System.out.println("\nEscolha um nível de dificuldade: \n<1> Fácil\n<2> Médio\n<3> Dificil");
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
