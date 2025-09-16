import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Main {

    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {

        char resp = 'N';
        char opcao;
        try {
            do {
                opcao = menu();

                switch (opcao) {
                    case '1':

                        char cad = InOut.leChar("Escolha:\n"
                                + "1 - Cadastrar Marcas:\n"
                                + "2 - Cadastar Equipamentos:\n" + "3 - Voltar:\n");

                        switch (cad) {

                            case '1':
                                inserirMarcas();
                                break;
                            case '2':
                                inserirEquipamentos();
                                break;

                            default:
                                break;

                        }
                        break;

                    case '2':

                        char listar = InOut.leChar("Escolha:\n"
                                + "1 - Listar Marcas cadastradas:\n"
                                + "2 - Listar Equipamentos cadastrados:\n"
                                + "3 - Voltar:\n");
                        switch (listar) {
                            case '1':
                                mostrarMarcas();
                                break;
                            case '2':
                                mostrarEquipamentos();
                                break;

                            default:
                                break;
                        }
                        break;

                    case '3':
                        char pesq = InOut.leChar("Escolha:\n"
                                + "1 - Pesquisar pelo codigo da marca:\n"
                                + "2 - Pesquisar Equipamentos por codigo:\n"
                                + "3 - Pesquisar Equipamentos por data:\n"
                                + "4 - Pesquisar pelo nome do cliente:\n"
                                + "5 - Voltar");
                        switch (pesq) {
                            case '1':
                                pesquisarMarcas();

                                break;

                            case '2':
                                pesquisarEquipamentos();
                                break;

                            case '3':
                                pesquisarPorData();
                                break;
                            case '4':
                                pesquisarCliente();
                                break;

                            default:
                                break;
                        }

                        break;

                    case '4':
                        char esc = InOut.leChar("Escolha:\n"
                                + "1 - Alterar Marcas:\n"
                                + "2 - Alterar Equipamentos:\n" + "3 - Voltar:\n");
                        switch (esc) {
                            case '1':
                                alterarMarcas();

                                break;
                            case '2':
                                AlteraEquipamentos();
                                break;

                            default:
                                break;
                        }
                        break;

                    case '5':

                        char op = InOut.leChar("Escolha:\n"
                                + "1 - Excluir Marcas:\n"
                                + "2 - Excluir equipamentos:\n" + "3 - Voltar:\n");
                        switch (op) {
                            case '1':
                                excluirMarcas();

                                break;

                            case '2':
                                excluirEquimentos();

                            default:
                                break;
                        }

                        break;

                    case '6':
                        resp = Character.toUpperCase(InOut
                                .leChar("Deseja realmente sair do programa? S/N"));
                        break;

                    default:
                        InOut.MsgDeInformacao("", "opção invalida, tente novamente");

                }

            } while (resp != 'S');
            System.exit(0);
        } catch (Exception e) {

        }

    }

    public static String ler(int primeiro, int ultimo) {
        String dados = "";
        dados = memoria.substring(primeiro, ultimo);
        return dados;

    }

    private static void inserirMarcas() {// CADASTRO DE MARCAS
        try {

            BufferedWriter saida;
            saida = new BufferedWriter(new FileWriter("marcas.txt", true));
            int inicio;
            iniciarArquivoMarcas();
            if (memoria.length() != 0) {
                String codigoMarca = InOut
                        .leString(" Digite o código da marca");
                inicio = memoria.indexOf(codigoMarca);
                if (inicio == -1) {
                    memoria.indexOf("\n", inicio);

                    String nomeMarca = InOut
                            .leString(" Digite o nome da Marca");

                    CadastroMarcas cadastro = new CadastroMarcas(
                            Integer.parseInt(codigoMarca), nomeMarca);
                    saida.write(cadastro.getCodigoMarca() + "\t");
                    saida.write((cadastro.getNomeMarca()) + "\r\n");
                    saida.flush();
                    saida.close();
                    JOptionPane.showMessageDialog(null,
                            "Operação realizada com sucesso");
                } else {

                    InOut.MsgDeAviso("", "Codigo de Marcas já cadastrado");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de gravação");

        }

    }

    private static void inserirEquipamentos() {
        try {

            BufferedWriter saida;

            saida = new BufferedWriter(new FileWriter("equipamentos.txt", true));


            int inicio;
            iniciarArquivoMarcas();
            if (memoria.length() != 0) {
                String codigoMarca = InOut
                        .leString(" Digite o código da marca");
                inicio = memoria.indexOf(codigoMarca);

                if (inicio != -1) {
                    memoria.indexOf("\n", inicio);
                    iniciarArquivoEquipamentos();
                    String codigoEquipamento = InOut
                            .leString(" Digite o código do equipamento");
                    if (inicio > memoria.indexOf(codigoEquipamento)) {

                        String nomeEquipamento = InOut
                                .leString(" Informe o nome do equipamento");

                        String nomeCliente = InOut
                                .leString(" Informe o nome do cliente");
                        nomeCliente = nomeCliente.toUpperCase();
                        String telCliente = InOut
                                .leString(" Informe o telefone do cliente");
                        String defeito = InOut
                                .leString(" Informe defeito do equipamento");
                        String data = InOut.leString(" Informe a data de entrada do equipamento");
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(new Date());

                        CadastroEquipamentos cadE = new CadastroEquipamentos(
                                Integer.parseInt(codigoEquipamento),
                                nomeEquipamento, Integer.parseInt(codigoMarca),
                                nomeCliente, telCliente, defeito, data);
                        saida.write(cadE.getCodigoEquipamento() + "\t");
                        saida.write(cadE.getNomeEquipamento() + "\t");
                        saida.write(cadE.getCodigoMarca() + "\t");
                        saida.write(cadE.getNomeCliente() + "\t");
                        saida.write(cadE.getTelCliente() + "\t");
                        saida.write(cadE.getDefeito() + "\t");
                        saida.write((cadE.getData() + "\r\n"));
                        saida.flush();
                        saida.close();
                        JOptionPane.showMessageDialog(null,
                                "Operação realizada com sucesso");
                    } else {

                        InOut.MsgDeAviso("", "Codigo ja cadastrado");

                    }
                } else {
                    InOut.MsgDeAviso("", "Codigo de marcas não cadastrado");
                }

            }
        } catch (Exception e) {
            InOut.MsgDeErro(null, "Erro de gravação");

        }
    }

    public static void pesquisarEquipamentos() {
        try {

            String codigoEquipamento, nomeEquipamento, codigoMarca, nomeCliente, telCliente, defeito, data;
            int inicio = -1, fim, ultimo, primeiro;
            iniciarArquivoEquipamentos();


            String arquivo = "equipamentos.txt";
            BufferedReader arqentrada;
            arqentrada = new BufferedReader(new FileReader(arquivo));
            if (memoria.length() != 0) {
                codigoEquipamento = InOut
                        .leString("Digite o codigo para pesquisar:");
                String linha;

                codigoMarca = "";
                nomeCliente = "";
                telCliente = "";
                defeito = "";
                data = "";

                while ((linha = arqentrada.readLine()) != null) {
                    memoria.append(linha).append("\n");

                }
                inicio = memoria.indexOf(codigoEquipamento);

                if (inicio != -1) {

                    ultimo = memoria.indexOf("\t", inicio);                                                    // DO ARQUIVO
                    codigoEquipamento = ler(inicio, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    nomeEquipamento = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    codigoMarca = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    nomeCliente = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    telCliente = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    defeito = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    fim = memoria.indexOf("\n", primeiro);
                    data = ler(primeiro, fim);

                    CadastroEquipamentos cadE = new CadastroEquipamentos(
                            Integer.parseInt(codigoEquipamento),
                            nomeEquipamento, Integer.parseInt(codigoMarca),
                            nomeCliente, telCliente, defeito, data);

                    InOut.MsgDeInformacao(
                            "",
                            "Código do Equipamento:"
                                    + cadE.getCodigoEquipamento() + "\n"
                                    + " Nome: " + cadE.getNomeEquipamento()
                                    + "\n\t" + " Codigo da Marca: "
                                    + cadE.getCodigoMarca() + "\n\t"
                                    + " Nome do Cliente: "
                                    + cadE.getNomeCliente() + "\n\t"
                                    + " Telefone do Cliente: "
                                    + cadE.getTelCliente() + "\n\t"
                                    + " Defeito: " + cadE.getDefeito() + "\n\t"
                                    + " Data de entrada: " + cadE.getData()
                                    + "\n");

                } else {
                    JOptionPane.showMessageDialog(null, "Não cadastrado");

                }

            }
            arqentrada.close();
        } catch (Exception e) {
            InOut.MsgDeErro(null, "Erro de leitura");
        }

    }

    private static void excluirEquimentos() {
        String codigoEquipamento, nomeEquipamento, codigoMarca, nomeCliente, telCliente, defeito, data;
        char resp;
        int inicio = -1, fim, ultimo, primeiro;
        iniciarArquivoEquipamentos();
        iniciarArquivoEquipamentos();
        if (!memoria.isEmpty()) {
            codigoEquipamento = InOut.leString(" Digite o codigo para excluir");
            inicio = memoria.indexOf(codigoEquipamento);

            codigoEquipamento = "";
            nomeEquipamento = "";
            codigoMarca = "";
            nomeCliente = "";
            telCliente = "";
            defeito = "";
            data = "";

            if (inicio != -1) {
                ultimo = memoria.indexOf("\t", inicio);
                codigoEquipamento = ler(inicio, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                nomeEquipamento = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                codigoMarca = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                nomeCliente = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                telCliente = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                defeito = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                fim = memoria.indexOf("\n", primeiro);
                data = ler(primeiro, fim);

                CadastroEquipamentos cadE = new CadastroEquipamentos(
                        Integer.parseInt(codigoEquipamento), nomeEquipamento,
                        Integer.parseInt(codigoMarca), nomeCliente, telCliente,
                        defeito, data);

                resp = Character.toUpperCase(InOut
                        .leChar(" Deseja excluir? Digite S ou N \n\n"
                                + "codigo Equipamento: "
                                + cadE.getCodigoEquipamento() + "\n"
                                + " Nome do equipamento: "
                                + cadE.getNomeEquipamento() + "\n"
                                + " Codigo da Marca: " + cadE.getCodigoMarca()
                                + "\n" + " Nome do Cliente: "
                                + cadE.getNomeCliente() + "\n" + " Telefone: "
                                + cadE.getTelCliente() + "\n" + " Defeito: "
                                + cadE.getDefeito() + "\n" + " Data: "
                                + cadE.getData()));
                if (resp == 'S') {
                    memoria.delete(inicio, fim + 1);
                    JOptionPane.showInputDialog("", "Registro excluido.");
                } else {
                    InOut.MsgDeInformacao("", "Exclusão cancelada.");
                }
                gravarEquipamentos();
            } else {
                InOut.MsgDeAviso("", "Codigo não encontrado");

            }

        }
    }

    static void iniciarArquivoEquipamentos() {
        String linha;
        try {
            BufferedReader arqEntrada;
            arqEntrada = new BufferedReader(new FileReader("equipamentos.txt"));
            linha = "";
            memoria.delete(0, memoria.length());
            while ((linha = arqEntrada.readLine()) != null) {
                memoria.append(linha).append("\n");
            }
            arqEntrada.close();
        } catch (FileNotFoundException erro) {
            InOut.MsgDeAviso("", "Arquivo n�o encontrado");
        } catch (Exception e) {
            InOut.MsgDeErro("", "Erro de Leitura !");
        }
    }

    static void iniciarArquivoMarcas() {
        String linha;
        try {
            BufferedReader arqEntrada;
            arqEntrada = new BufferedReader(new FileReader("marcas.txt"));
            linha = "";
            memoria.delete(0, memoria.length());
            while ((linha = arqEntrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }
            arqEntrada.close();
        } catch (FileNotFoundException erro) {
            InOut.MsgDeAviso("", "Arquivo nãoo encontrado");
        } catch (Exception e) {
            InOut.MsgDeErro("", "Erro de Leitura !");
        }
    }

    public static void gravarEquipamentos() {
        try {
            BufferedWriter arqSaida;
            arqSaida = new BufferedWriter(new FileWriter("equipamentos.txt"));
            arqSaida.write(memoria.toString());
            arqSaida.flush();
            arqSaida.close();
        } catch (Exception erro) {
            InOut.MsgDeErro("", "Erro de gravacao!");
        }
    }

    public static void gravarMarcas() {
        try {
            BufferedWriter arqSaida;
            arqSaida = new BufferedWriter(new FileWriter("marcas.txt"));

            arqSaida.write(memoria.toString());
            arqSaida.flush();
            arqSaida.close();
        } catch (Exception erro) {
            InOut.MsgDeErro("", "Erro de gravaçãoo!");
        }
    }

    private static void mostrarMarcas() {
        String codigo, nomeMarca;
        StringBuilder resp = new StringBuilder("Marcas cadastradas\n");
        int inicio, fim, ultimo, primeiro;
        iniciarArquivoMarcas();
        inicio = 0;
        if ((memoria.length() != 0)) {

            while (inicio != memoria.length()) {
                codigo = "";
                nomeMarca = "";

                if (inicio != -1) {
                    ultimo = memoria.indexOf("\t", inicio);
                    codigo = ler(inicio, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    fim = memoria.indexOf("\n", primeiro);
                    nomeMarca = ler(primeiro, fim);
                    CadastroMarcas cadastro = new CadastroMarcas(
                            Integer.parseInt(codigo), nomeMarca);

                    resp.append(" Codigo:").append(cadastro.getCodigoMarca()).append(" Marca:").append("\t").append(cadastro.getNomeMarca()).append("\n");
                    inicio = fim + 1;
                }

            }
            InOut.MsgSemIcone(null, resp.toString());

        }
    }

    private static void alterarMarcas() {
        int inicio, fim, ultimo, primeiro;
        String codigo, nomeMarca;
        iniciarArquivoMarcas();
        if (memoria.length() != 0) {
            codigo = InOut.leString("Digite o codigo para alterar:");
            nomeMarca = "";

            inicio = memoria.indexOf(codigo);
            if (inicio != -1) {
                ultimo = memoria.indexOf("\t", inicio);
                codigo = ler(inicio, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                fim = memoria.indexOf("\n", primeiro);
                nomeMarca = ler(primeiro, fim);

                CadastroMarcas cadastro = new CadastroMarcas(
                        Integer.parseInt(codigo), nomeMarca);
                InOut.MsgDeInformacao("", "nome: " + cadastro.getNomeMarca());

                nomeMarca = InOut.leString("Entre com novo nome");
                cadastro.setNomeMarca(nomeMarca);

                memoria.replace(inicio, fim + 1, cadastro.getCodigoMarca()
                        + "\t" + cadastro.getNomeMarca() + "\r\n");

                gravarMarcas();
                JOptionPane.showMessageDialog(null,
                        " Marca Alterada com sucesso");
            } else {
                InOut.MsgDeErro("", "codigo não encontrado");
            }
        }

    }

    public static void AlteraEquipamentos() {
        String codigoEquipamento, codigoMarca, nomeEquipamento, nomeCliente, telCliente, defeito, data;// corrigido
        int inicio = -1, fim, ultimo, primeiro;
        iniciarArquivoEquipamentos();

        if (memoria.length() != 0) {
            codigoEquipamento = InOut
                    .leString(" Digite o codigo para alterar:");

            inicio = memoria.indexOf(codigoEquipamento);
            if (inicio != -1) {
                codigoEquipamento = "";
                nomeEquipamento = "";
                codigoMarca = "";
                nomeCliente = "";
                telCliente = "";
                defeito = "";
                data = "";

                ultimo = memoria.indexOf("\t", inicio);
                codigoEquipamento = ler(inicio, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                nomeEquipamento = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                codigoMarca = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                nomeCliente = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                telCliente = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                defeito = ler(primeiro, ultimo);
                primeiro = ultimo + 1;

                fim = memoria.indexOf("\n", primeiro);
                data = ler(primeiro, fim);

                CadastroEquipamentos cadE = new CadastroEquipamentos(
                        Integer.parseInt(codigoEquipamento), nomeEquipamento,
                        Integer.parseInt(codigoMarca), nomeCliente, telCliente,
                        defeito, data);

                InOut.MsgDeInformacao("", "Nome: " + cadE.getNomeEquipamento());
                nomeEquipamento = InOut
                        .leString("Digite a descriçãoo correta do equipamento");
                cadE.setNomeEquipamento(nomeEquipamento);
                InOut.MsgDeInformacao("", " Defeito:" + cadE.getDefeito());
                defeito = InOut.leString(" Digite o defeito correto");
                cadE.setDefeito(defeito);

                memoria.replace(
                        inicio,
                        fim + 1,
                        cadE.getCodigoEquipamento() + "\t"
                                + cadE.getNomeEquipamento() + "\t"
                                + cadE.getCodigoMarca() + "\t"
                                + cadE.getNomeCliente() + "\t"
                                + cadE.getTelCliente() + "\t"
                                + cadE.getDefeito() + "\t" + cadE.getData()
                                + "\r\n");
                gravarEquipamentos();
                JOptionPane.showMessageDialog(null,
                        " Equipamento Alterado com sucesso");
            }
        } else {

            InOut.MsgDeErro("", "c�digo n�o encontrado");
        }
    }

    private static void mostrarEquipamentos() {
        String codigoEquipamento, codigoMarca, nomeEquipamento, defeito, nomeCliente, telCliente, data;
        StringBuilder resp = new StringBuilder("Equipamentos cadastrados\n");
        int inicio, fim, ultimo, primeiro;
        iniciarArquivoEquipamentos();
        inicio = 0;
        if ((memoria.length() != 0)) {
            while (inicio != memoria.length()) {
                codigoMarca = "";
                codigoEquipamento = "";
                nomeEquipamento = "";
                defeito = "";
                nomeCliente = "";
                telCliente = "";
                data = "";
                if (inicio != -1) {

                    ultimo = memoria.indexOf("\t", inicio);
                    codigoEquipamento = ler(inicio, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    nomeEquipamento = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    codigoMarca = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    nomeCliente = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    telCliente = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    defeito = ler(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    fim = memoria.indexOf("\n", primeiro);
                    data = ler(primeiro, fim);

                    CadastroEquipamentos cadE = new CadastroEquipamentos(
                            Integer.parseInt(codigoEquipamento),
                            nomeEquipamento, Integer.parseInt(codigoMarca),
                            nomeCliente, telCliente, defeito, data);

                    resp.append("Codigo do equipamento:" + "\t").append(cadE.getCodigoEquipamento()).append("\t\n").append("Nome do Equipamento:").append("\t").append(cadE.getNomeEquipamento()).append("\t\n").append("Codigo da Marca: ").append("\t").append(cadE.getCodigoMarca()).append("\t\n").append("Nome do Cliente: ").append("\t").append(cadE.getNomeCliente()).append("\t\n").append("Telefone: ").append("\t").append(cadE.getTelCliente()).append("\t\n").append("Defeito: ").append("\t").append(cadE.getDefeito()).append("\t\n").append("Data de entrada:").append(cadE.getData()).append("\r\n\n");
                    inicio = fim + 1;
                }

            }
            InOut.MsgSemIcone(null, resp.toString());
        }
    }

    public static void pesquisarMarcas() {
        try {


            iniciarArquivoEquipamentos();

            String codigoEquipamento = InOut
                    .leString("Digite o código para Pesquisar:");

            StringBuilder equipamentos = new StringBuilder();

            if ((memoria.length() != 0)) {

                String[] equipamentosVet = memoria.toString().split("\n");

                for (int i = 0; i < equipamentosVet.length; i++) {

                    String[] campos = equipamentosVet[i].split("\t");

                    if (campos[2].equals(codigoEquipamento)) {

                        equipamentos.append("C�digo do Equipamento:").append(campos[0]).append("\n").append(" Nome: ").append(campos[1]).append("\n").append(" Codigo da Marca: ").append(campos[2]).append("\n").append(" Nome do Cliente: ").append(campos[3]).append("\n").append(" Telefone do Cliente: ").append(campos[4]).append("\n").append(" Defeito: ").append(campos[5]).append("\n").append(" Data de entrada: ").append(campos[6]).append("\n ******************************************* \n");

                    }

                }
                if (equipamentos.toString().equals("")) {
                    equipamentos = new StringBuilder("nao encontrado");
                }

                InOut.MsgDeInformacao("", equipamentos.toString());

            } else {
                JOptionPane.showMessageDialog(null, "N�o cadastrado");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura");
        }

    }

    private static void excluirMarcas() {
        String codigoMarca, linha;
        char resp;
        int inicio, fim;
        iniciarArquivoMarcas();
        if ((memoria.length() != 0)) {
            codigoMarca = InOut.leString(" Digite o c�digo para excluir");
            inicio = memoria.indexOf(codigoMarca);
            if (inicio != -1) {
                fim = memoria.indexOf("\n", inicio);
                linha = ler(inicio, fim);

                resp = Character.toUpperCase(InOut
                        .leChar(" Deseja excluir? Digite S ou N \n" + linha));
                if (resp == 'S') {
                    memoria.delete(inicio, fim + 1);
                    InOut.MsgDeInformacao("", "Registro excluido.");
                } else {
                    InOut.MsgDeInformacao("", "Exclusão cancelada.");
                }
                gravarMarcas();
            } else {
                InOut.MsgDeAviso("", "Codigo não encontrado");

            }

        }
    }

    public static void pesquisarPorData() {
        try {


            iniciarArquivoEquipamentos();

            String codigoEquipamento = InOut.leString(
                            "Digite a data para pesquisar:\n" + "Formato 00/00/0000")
                    .toUpperCase();

            String equipamentos = "";

            if ((memoria.length() != 0)) {

                String[] equipamentosVet = memoria.toString().split("\n");

                for (int i = 0; i < equipamentosVet.length; i++) {

                    String[] campos = equipamentosVet[i].split("\t");

                    if (campos[6].equals(codigoEquipamento)) {

                        equipamentos += "C�digo do Equipamento:"
                                + campos[0]
                                + "\n"
                                + " Nome: "
                                + campos[1]
                                + "\n"
                                + " Codigo da Marca: "
                                + campos[2]
                                + "\n"
                                + " Nome do Cliente: "
                                + campos[3]
                                + "\n"
                                + " Telefone do Cliente: "
                                + campos[4]
                                + "\n"
                                + " Defeito: "
                                + campos[5]
                                + "\n"
                                + " Data de entrada: "
                                + campos[6]
                                + "\n ******************************************* \n";

                    }

                }
                if (equipamentos.equals("")) {
                    equipamentos = "nao encontrado";
                }

                InOut.MsgDeInformacao("", equipamentos);

            } else {
                InOut.MsgDeInformacao("Aviso", "Não Cadastrado");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura");
        }

    }

    public static void pesquisarCliente() {
        try {


            iniciarArquivoEquipamentos();

            String codigoEquipamento = InOut.leString(
                    "Digite o nome do Cliente:\n").toUpperCase();

            StringBuilder equipamentos = new StringBuilder();

            if (memoria.length() != 0) {

                String[] equipamentosVet = memoria.toString().split("\n");

                for (String s : equipamentosVet) {

                    String[] campos = s.split("\t");

                    if (campos[3].equals(codigoEquipamento)) {

                        equipamentos.append("C�digo do Equipamento:").append(campos[0]).append("\n").append(" Nome: ").append(campos[1]).append("\n").append(" Codigo da Marca: ").append(campos[2]).append("\n").append(" Nome do Cliente: ").append(campos[3].toUpperCase()).append("\n").append(" Telefone do Cliente: ").append(campos[4]).append("\n").append(" Defeito: ").append(campos[5]).append("\n").append(" Data de entrada: ").append(campos[6]).append("\n ******************************************* \n");

                    }

                }
                if (equipamentos.toString().equals("")) {
                    equipamentos = new StringBuilder("nao encontrado");
                }

                InOut.MsgDeInformacao("", equipamentos.toString());

            } else {
                JOptionPane.showMessageDialog(null, "N�o cadastrado");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura");
        }

    }

    static char menu() {
        Locale localBR = new Locale("pt", "BR");
        Calendar agora = Calendar.getInstance();
        DateFormat formatoDeData = DateFormat.getDateInstance(DateFormat.FULL,
                localBR);

        return InOut.leChar(formatoDeData.format(agora.getTime())
                + "\n\nSISTEMA AUTORIZADA DE EQUIPAMENTOS "
                + "\n(Marcelo Hoffmann)"
                + "\n\n Escolha uma Opção:\n" + "1- Cadastro\n"
                + "2- Listar cadastro\n" + "3- Consultas\n"
                + "4- Ateraraçãoo de Cadastro\n" + "5- Excluir cadastro\n"
                + "6- Sair");
    }
}
