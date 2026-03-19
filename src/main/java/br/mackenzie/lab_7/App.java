package br.mackenzie.lab_7;

import br.mackenzie.lab_7.dao.*;
import br.mackenzie.lab_7.model.*;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProprietarioDAO pDAO = new ProprietarioDAO();
        VeiculoDAO vDAO = new VeiculoDAO();

        int opcao = 0;

        do {
            System.out.println("\n===== SISTEMA VEICULOS =====");
            System.out.println("1 - Cadastrar proprietario");
            System.out.println("2 - Listar proprietarios");
            System.out.println("3 - Atualizar proprietario");
            System.out.println("4 - Deletar proprietario");
            System.out.println("5 - Cadastrar veiculo");
            System.out.println("6 - Listar veiculos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {

                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        Proprietario p = new Proprietario();
                        p.setNome(nome);
                        p.setCpf(cpf);

                        pDAO.create(p);

                        System.out.println("Proprietario cadastrado!");
                        break;

                    case 2:
                        List<Proprietario> listaP = pDAO.readAll();

                        for (Proprietario prop : listaP) {
                            System.out.println(prop.getId() + " - " + prop.getNome() + " - " + prop.getCpf());
                        }
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int idUpdate = sc.nextInt();
                        sc.nextLine();

                        Proprietario pUpdate = pDAO.read(idUpdate);

                        if (pUpdate != null) {
                            System.out.print("Novo nome: ");
                            pUpdate.setNome(sc.nextLine());

                            System.out.print("Novo CPF: ");
                            pUpdate.setCpf(sc.nextLine());

                            pDAO.update(pUpdate);

                            System.out.println("Atualizado!");
                        } else {
                            System.out.println("Não encontrado!");
                        }
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int idDelete = sc.nextInt();

                        pDAO.delete(idDelete);

                        System.out.println("Deletado!");
                        break;

                    case 5:
                        System.out.print("ID do proprietario: ");
                        int idProp = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Placa: ");
                        String placa = sc.nextLine();

                        Veiculo v = new Veiculo();
                        v.setProprietarioId(idProp);
                        v.setPlaca(placa);

                        vDAO.create(v);

                        System.out.println("Veiculo cadastrado!");
                        break;

                    case 6:
                        List<Veiculo> listaV = vDAO.readAll();

                        for (Veiculo vei : listaV) {
                            System.out.println(
                                    vei.getId() + " - PropID: " +
                                            vei.getProprietarioId() + " - Placa: " +
                                            vei.getPlaca()
                            );
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}