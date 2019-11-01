
import java.util.Scanner;

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
        "",
        ""
    };

    static void novoJogo() {

    }

    static void comoJogar() {
        System.out.println("Aperte qualquer tecla para voltar...");
        input.next();
        exibirMenu();
    }

    static void creditos() {
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
            
        }while(opcao == 0);
        return opcao;
    }

    public static void main(String[] args) {
        escolha();
        
        exibirMenu();
    }
}
