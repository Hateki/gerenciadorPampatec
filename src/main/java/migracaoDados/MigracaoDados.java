/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migracaoDados;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import ideiah.sisponto02.dao.PersistenciaDiretor;
import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.modelo.Ponto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peterson
 */
public class MigracaoDados {

    String table1 = "funcionario";
    String table2 = "funcionario";

    protected ConectaDB conecta;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    private DateFormat dataFormatAntiga;
    private DateFormat dataFormatNova;
    Calendar calendar = Calendar.getInstance();

    public MigracaoDados() {
        dataFormatAntiga = new SimpleDateFormat("dd/MM/yyyy");
        dataFormatNova = new SimpleDateFormat("yyyy--MM-dd");

    }

    /**
     * Busca no banco velho todos funcionario e cria Objetos Funcionarios para
     * manipulação.
     *
     * @return
     */
    private ArrayList<Funcionario> criaObjetosFuncionarioVelho() {
        ArrayList<Funcionario> funcionariosAntigos = new ArrayList<>();
        ArrayList<Object> dados;

        try {
            // busca todos funcionario do banco velho
            dados = this.buscarTodosFuncionarios();
            if (dados != null) {
                int id = 0;
                int login;
                String nome = "", senha = "", telefone = "", email = "", rg = "", orgao = "";
                String cpf = "", rua = "", bairro = "", cidade = "", uf = "", cep = "", cargo = "";
                String buscacargo = "", data_entrada = "", data_saida = "", tipo_vinculo = "", logradouro = "";
                int status;
                int numerocasa;
                for (int count = 0; count < dados.size(); count++) {
                    id = (int) dados.get(count);
                    login = (int) dados.get(count + 1);
                    senha = (String) dados.get(count + 2);
                    nome = (String) dados.get(count + 3);
                    telefone = (String) dados.get(count + 4);
                    email = (String) dados.get(count + 5);
                    status = (int) dados.get(count + 6);
                    rg = (String) dados.get(count + 7);
                    orgao = (String) dados.get(count + 8);
                    cpf = (String) dados.get(count + 9);
                    rua = (String) dados.get(count + 10);
                    numerocasa = (int) dados.get(count + 11);
                    bairro = (String) dados.get(count + 12);
                    cidade = (String) dados.get(count + 13);
                    uf = (String) dados.get(count + 14);
                    cep = (String) dados.get(count + 15);
                    buscacargo = (String) dados.get(count + 16);
                    data_entrada = (String) dados.get(count + 17);
                    data_saida = (String) dados.get(count + 18);
                    tipo_vinculo = (String) dados.get(count + 19);
                    logradouro = (String) dados.get(count + 20);
                    funcionariosAntigos.add(new Funcionario(id, login, senha, nome, telefone, email, status, rg, orgao, cpf, rua, numerocasa, bairro, cidade, uf, cep, buscacargo, data_entrada, data_saida, tipo_vinculo, logradouro));
                    count += 20;
                }
            } else {
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return funcionariosAntigos;
    }

    /**
     * Método que popula banco novo.
     */
    public void populaBancoNovosFuncionarios() {
        PersistenciaDiretor persisteDiretor = new PersistenciaDiretor();

        ArrayList<Funcionario> funcionariosAntigos = this.criaObjetosFuncionarioVelho();
        ArrayList<ideiah.sisponto02.modelo.Funcionario> funcionariosNovos = new ArrayList<>();
        for (Funcionario funcio : funcionariosAntigos) {

            ideiah.sisponto02.modelo.Funcionario novoFuncionario = new ideiah.sisponto02.modelo.Funcionario();
            ideiah.sisponto02.modelo.Endereco novoEndereco = new ideiah.sisponto02.modelo.Endereco();
            boolean status, estagioObrigatorio = false;
//configura o atributo status do funcionário
            if (funcio.getStatus() == 0) {
                status = false;
            } else {
                status = true;
            }
// configura o atributo estagio obrigatório
            if (funcio.getTipoVinculo() != null) {
                if (funcio.getTipoVinculo().equals("Estágio Obrigatório")) {
                    estagioObrigatorio = true;

                } else {
                    estagioObrigatorio = false;
                }
            }
            // configurando dados do funcionário
            novoFuncionario.setCodigoAcesso(funcio.getLogin() + "");
            String cpfSemPonto = funcio.getCPF();
            cpfSemPonto = cpfSemPonto.replace(".", "");
            cpfSemPonto = cpfSemPonto.replace("-", "");

            novoFuncionario.setCpf(cpfSemPonto);
            novoFuncionario.setCurso("Engenharia de Software");
            novoFuncionario.setEmail(funcio.getEmail());
            novoFuncionario.setEstagioObrigatorio(estagioObrigatorio);
            novoFuncionario.setAtivo(status); // atribui status do funcionario no banco velho para o novo.
            novoFuncionario.setInstituicao("UNIPAMPA");
            novoFuncionario.setMatricula(funcio.getLogin() + "");
            novoFuncionario.setRg(funcio.getRg());
            novoFuncionario.setTelefone(funcio.getTelefone());
            novoFuncionario.setNome(funcio.getNome());
            //novoFuncionario.setIdfuncionario(funcio.getId());

            // verifica se o funcionário é um Diretor, se for, é configurado como tal.
            if (!funcio.getCargo().equalsIgnoreCase("Desenvolvedor")) {
                ideiah.sisponto02.modelo.Diretor diretor = new ideiah.sisponto02.modelo.Diretor();
                if (funcio.getCargo().equalsIgnoreCase("Diretor Presidente")) {
                    diretor.setCargo("Diretor Presidente");
                } else if (funcio.getCargo().equalsIgnoreCase("Diretor Administrativo")) {
                    diretor.setCargo("Diretor Administrativo");
                } else if (funcio.getCargo().equalsIgnoreCase("Diretor de Negócio")) {
                    diretor.setCargo("Diretor de Negócio");
                } else if (funcio.getCargo().equalsIgnoreCase("Diretor de Desenvolvimento")) {
                    diretor.setCargo("Diretor Desenvolvimento");
                } else {
                    System.out.println("nao é nenhum cargo");
                }
                diretor.setSenha(funcio.getSenha());
                diretor.setDataPosse(new Date());

                persisteDiretor.salvarDiretor(diretor);
                novoFuncionario.setDiretor(diretor);
            }

            //configurando endereço;
            novoEndereco.setBairro(funcio.getBairro());
            novoEndereco.setCidade(funcio.getCidade());
            novoEndereco.setEstado(funcio.getUf());
            novoEndereco.setLogradouro(funcio.getLogradouro());
            novoEndereco.setNumero(funcio.getNumeroCasa());
            novoEndereco.setRua(funcio.getRua());

            // passando endereço para o novo funcionário;
            novoFuncionario.setEndereco(novoEndereco);

            try {
                novoFuncionario = this.procuraEConfiguraRegistrosPontosDoFuncionario(novoFuncionario, funcio.getId());
            } catch (ParseException ex) {
                Logger.getLogger(MigracaoDados.class.getName()).log(Level.SEVERE, null, ex);
            }

            // salva funcionario com seus registros.
            PersistenciaFuncionario persistefuncionario = new PersistenciaFuncionario();
            boolean salvou = persistefuncionario.salvar(novoFuncionario);

            if (salvou) {
                System.out.println("salvou");
            } else {
                System.out.println("não salvou");
            }
        }
    }

    /**
     * método que vai configurar todos pontos de um funcionário
     *
     * @param novoFuncionario
     * @param idFuncionarioVelhoBanco
     * @return
     */
    public ideiah.sisponto02.modelo.Funcionario procuraEConfiguraRegistrosPontosDoFuncionario(ideiah.sisponto02.modelo.Funcionario novoFuncionario, int idFuncionarioVelhoBanco) throws ParseException {
        ArrayList<RegistroPonto> registrosDeUmFuncionario = this.adicionarArrayRegistrosPontoDoFuncionari(this.buscarTodosRegistroIdFuncionario(idFuncionarioVelhoBanco));
        Set<Ponto> pontoNovos = new HashSet<Ponto>(0);
        for (RegistroPonto registro : registrosDeUmFuncionario) {
            Ponto pontoNovo = new Ponto();
            pontoNovo.setAtividadeRealizada(registro.getAtividade());
            pontoNovo.setFuncionario(novoFuncionario);
            pontoNovo.setData(registro.getData());
            pontoNovo.setStatus(false);
            /**
             * COnfigurando as horas de entrada e de saida;
             */
            String horaEntrou[] = registro.getHoraEntrada().split(":");

            calendar.setTime(new Date()); //colocando o objeto Date no Calendar
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horaEntrou[0])); //colocando a hora convertida de string para int
            calendar.set(Calendar.MINUTE, Integer.parseInt(horaEntrou[1]));
            calendar.set(Calendar.SECOND, 00);
            pontoNovo.setEntrada(calendar.getTime()); // adicionar horario no dateEntrada

            if (registro.getHoraSaida() != null) {

                String horaSaiu[] = registro.getHoraSaida().split(":");

                calendar.setTime(new Date()); //colocando o objeto Date no Calendar
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horaSaiu[0])); //colocando a hora convertida de string para int
                calendar.set(Calendar.MINUTE, Integer.parseInt(horaSaiu[1]));
                calendar.set(Calendar.SECOND, 00);
                pontoNovo.setSaida(calendar.getTime());
            }

            pontoNovos.add(pontoNovo);

        }
        novoFuncionario.setPontos(pontoNovos);
        System.out.println("numero de funcionarios: " + novoFuncionario.getPontos().size());
        return novoFuncionario;
    }

    public static void main(String[] args) {
        System.out.println("main");
        MigracaoDados db = new MigracaoDados();
        db.populaBancoNovosFuncionarios();
    }

    /**
     * Busca todos funcionários do banco;
     *
     * @return
     */
    public ArrayList<Object> buscarTodosFuncionarios() {
        ArrayList<Object> dados = new ArrayList<>();
        try {
            String sql = "select id_funcionario,login,senha,nome,telefone,email,status,rg,orgao_expedidor,cpf,rua,numero_casa,bairro"
                    + ",cidade,uf,cep,cargo,data_entrada,data_saida,tipo_vinculo,logradouro from " + table1 + ";";
            conecta = ConectaDB.getInstance();
            statement = (com.mysql.jdbc.Statement) conecta.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                dados.add(resultSet.getInt(1));
                dados.add(resultSet.getInt(2));
                dados.add(resultSet.getString(3));
                dados.add(resultSet.getString(4));
                dados.add(resultSet.getString(5));
                dados.add(resultSet.getString(6));
                dados.add(resultSet.getInt(7));
                dados.add(resultSet.getString(8));
                dados.add(resultSet.getString(9));
                dados.add(resultSet.getString(10));
                dados.add(resultSet.getString(11));
                dados.add(resultSet.getInt(12));
                dados.add(resultSet.getString(13));
                dados.add(resultSet.getString(14));
                dados.add(resultSet.getString(15));
                dados.add(resultSet.getString(16));
                dados.add(resultSet.getString(17));
                dados.add(resultSet.getString(18));
                dados.add(resultSet.getString(19));
                dados.add(resultSet.getString(20));
                dados.add(resultSet.getString(21));
            }
            return dados;
        } catch (SQLException ex) {
            return null;
        }

    }

    public ArrayList<Object> buscarTodosRegistroIdFuncionario(int idFuncionario) {
        ArrayList<Object> dados = new ArrayList<>();
        try {
            String sql = "select id_registroPonto,horaEntrada_registroPonto,horaSaida_registroPonto,data_registroPonto,atividade from registroponto where codigoFuncionario_registroPonto=?";
            conecta = ConectaDB.getInstance();
            preparedStatement = (PreparedStatement) conecta.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idFuncionario);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dados.add(resultSet.getInt(1));
                dados.add(resultSet.getString(2));
                dados.add(resultSet.getString(3));
                dados.add(resultSet.getString(4));
                dados.add(resultSet.getString(5));
            }
            return dados;
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Converte um Array de Object para um Array de RegistroPonto.
     *
     * @param dados
     * @return
     */
    private ArrayList<RegistroPonto> adicionarArrayRegistrosPontoDoFuncionari(ArrayList<Object> dados) {
        if (dados != null) {
            ArrayList<RegistroPonto> registro = new ArrayList<>();

            String data, horaEntrada, horaSaida;
            for (int count = 0; count < dados.size(); count++) {
                RegistroPonto regPonto = new RegistroPonto();
                regPonto.setId((int) dados.get(count));
                horaEntrada = this.converteMinutos((String) dados.get(count + 1));
                regPonto.setHoraEntrada(horaEntrada);
                horaSaida = this.converteMinutos((String) dados.get(count + 2));
                regPonto.setHoraSaida(horaSaida);
                data = (String) dados.get(count + 3);
                regPonto.setAtividade((String) dados.get(count + 4));
                try {
                    // String array[] = data.split("/");
                    // String dataNova = array[2] + "-" + array[1] + "-" + array[0]; // ano-mes-dia

                    regPonto.setData(this.dataFormatAntiga.parse(data));

                } catch (ParseException ex) {
                    // Problema na conversão de String para Date.
                }
                registro.add(regPonto);
                count += 4;
            }
            return registro;

        } else {
            return null;
        }
    }

    private String converteMinutos(String minutos) {
        if (minutos != null) {
            System.out.println("minutos entrou metodo: " + minutos);
            String array[] = minutos.split(":");
            System.out.println("depois de dividir: horas: " + array[0] + " minutos: " + array[1]);
            if (array[1].length() == 1) {
                array[1] = "0" + array[1];
                minutos = array[0] + ":" + array[1] + ":00";
                System.out.println("convertido: " + minutos);
            }
        }
        return minutos;

    }

    public class Funcionario {

        private int id = -1;

        private int login;
        private String senha;
        private String nome;
        private String telefone;
        private String email;
        private int status;
        private long totalHorasNoPeriodo;
        private String rg;
        private String orgaoExp;
        private String CPF;
        private String rua;
        private int numeroCasa;
        private String bairro;
        private String cidade;
        private String uf;
        private String cep;
        private String cargo;
        private String dataEntrada;
        private String dataSaida;
        private String tipoVinculo;
        private String logradouro;

        public Funcionario() {

        }

        public Funcionario(int id, int login, String senha, String nome, String telefone, String email,
                int status, String rg, String orgaoExp, String cpf, String rua, int numeroCasa,
                String bairro, String cidade, String uf, String cep, String cargo, String dataEntrada, String dataSaida, String tipoVinculo, String logradouro) {
            this.id = id;
            this.login = login;
            this.senha = senha;
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
            this.status = status;
            this.rg = rg;
            this.orgaoExp = orgaoExp;
            this.CPF = cpf;
            this.rua = rua;
            this.numeroCasa = numeroCasa;
            this.bairro = bairro;
            this.cidade = cidade;
            this.uf = uf;
            this.cep = cep;
            this.dataEntrada = dataEntrada;
            this.dataSaida = dataSaida;
            this.tipoVinculo = tipoVinculo;
            this.cargo = cargo;
            this.logradouro = logradouro;
        }

        public Funcionario(int id, int login, String senha, String nome, String telefone, String email,
                int status, String cargo) {
            this.id = id;
            this.login = login;
            this.senha = senha;
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
            this.status = status;
            this.cargo = cargo;
        }

        /**
         * Atualiza todos os dados de um funcionário com exceção do id.
         *
         * @param login
         * @param senha
         * @param nome
         * @param telefone
         * @param email
         * @param status
         * @param rg
         * @param orgaoExp
         * @param bairro
         * @param logradouro
         * @param numeroCasa
         * @param rua
         * @param cidade
         * @param uf
         * @param cep
         * @param dataEntrada
         * @param tipoVinculo
         */
        public void salvarDados(int login, String senha, String nome, String telefone, String email,
                int status, String rg, String orgaoExp, String cpf, String logradouro, String rua, int numeroCasa,
                String bairro, String cidade, String uf, String cep, String cargo, String tipoVinculo) {
            this.login = login;
            this.senha = senha;
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
            this.status = status;
            this.rg = rg;
            this.orgaoExp = orgaoExp;
            this.CPF = cpf;
            this.rua = rua;
            this.numeroCasa = numeroCasa;
            this.bairro = bairro;
            this.cidade = cidade;
            this.uf = uf;
            this.cep = cep;
            this.cargo = cargo;
            this.tipoVinculo = tipoVinculo;
            this.logradouro = logradouro;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getLogin() {
            return login;
        }

        public void setLogin(int login) {
            this.login = login;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(Integer id) {
            this.setId((int) id);
        }

        /**
         * @return the totalHorasNoPeriodo
         */
        public long getTotalHorasNoPeriodo() {
            return totalHorasNoPeriodo;
        }

        /**
         * @param totalHorasNoPeriodo the totalHorasNoPeriodo to set
         */
        public void setTotalHorasNoPeriodo(long totalHorasNoPeriodo) {
            this.totalHorasNoPeriodo = totalHorasNoPeriodo;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the rg
         */
        public String getRg() {
            return rg;
        }

        /**
         * @param rg the rg to set
         */
        public void setRg(String rg) {
            this.rg = rg;
        }

        /**
         * @return the orgaoExp
         */
        public String getOrgaoExp() {
            return orgaoExp;
        }

        /**
         * @param orgaoExp the orgaoExp to set
         */
        public void setOrgaoExp(String orgaoExp) {
            this.orgaoExp = orgaoExp;
        }

        /**
         * @return the CPF
         */
        public String getCPF() {
            return CPF;
        }

        /**
         * @param CPF the CPF to set
         */
        public void setCPF(String CPF) {
            this.CPF = CPF;
        }

        /**
         * @return the rua
         */
        public String getRua() {
            return rua;
        }

        /**
         * @param rua the rua to set
         */
        public void setRua(String rua) {
            this.rua = rua;
        }

        /**
         * @return the numeroCasa
         */
        public int getNumeroCasa() {
            return numeroCasa;
        }

        /**
         * @param numeroCasa the numeroCasa to set
         */
        public void setNumeroCasa(int numeroCasa) {
            this.numeroCasa = numeroCasa;
        }

        /**
         * @return the bairro
         */
        public String getBairro() {
            return bairro;
        }

        /**
         * @param bairro the bairro to set
         */
        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        /**
         * @return the cidade
         */
        public String getCidade() {
            return cidade;
        }

        /**
         * @param cidade the cidade to set
         */
        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        /**
         * @return the uf
         */
        public String getUf() {
            return uf;
        }

        /**
         * @param uf the uf to set
         */
        public void setUf(String uf) {
            this.uf = uf;
        }

        /**
         * @return the cep
         */
        public String getCep() {
            return cep;
        }

        /**
         * @param cep the cep to set
         */
        public void setCep(String cep) {
            this.cep = cep;
        }

        /**
         * @return the cargo
         */
        public String getCargo() {
            return cargo;
        }

        /**
         * @param cargo the cargo to set
         */
        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        /**
         * @return the dataEntrada
         */
        public String getDataEntrada() {
            return dataEntrada;
        }

        /**
         * @param dataEntrada the dataEntrada to set
         */
        public void setDataEntrada(String dataEntrada) {
            this.dataEntrada = dataEntrada;
        }

        /**
         * @return the dataSaida
         */
        public String getDataSaida() {
            return dataSaida;
        }

        /**
         * @param dataSaida the dataSaida to set
         */
        public void setDataSaida(String dataSaida) {
            this.dataSaida = dataSaida;
        }

        /**
         * @return the tipoVinculo
         */
        public String getTipoVinculo() {
            return tipoVinculo;
        }

        /**
         * @param tipoVinculo the tipoVinculo to set
         */
        public void setTipoVinculo(String tipoVinculo) {
            this.tipoVinculo = tipoVinculo;
        }

        /**
         * @return the logradouro
         */
        public String getLogradouro() {
            return logradouro;
        }

        /**
         * @param logradouro the logradouro to set
         */
        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }
    }

    public class RegistroPonto {

        private int id;

        public void setId(int id) {
            this.id = id;
        }

        private Date data;
        private String horaEntrada;
        private String horaSaida;
        private String atividade;
        private Funcionario funcionario;

        public RegistroPonto() {

        }

        public RegistroPonto(int id, Date data, String horaEntrada, String horaSaida, Funcionario funcionario) {
            this.id = id;
            this.data = data;
            this.horaEntrada = horaEntrada;
            this.horaSaida = horaSaida;
            this.funcionario = funcionario;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }

        public int getId() {
            return id;
        }

        public String getHoraEntrada() {

            return horaEntrada;
        }

        public void setHoraEntrada(String horaEntrada) {
            this.horaEntrada = horaEntrada;
        }

        public String getHoraSaida() {
            return horaSaida;
        }

        public void setHoraSaida(String horaSaida) {
            this.horaSaida = horaSaida;
        }

        public Funcionario getFuncionario() {
            return funcionario;
        }

        public void setFuncionario(Funcionario funcionario) {
            this.funcionario = funcionario;
        }

        public String getAtividade() {
            return atividade;
        }

        public void setAtividade(String atividade) {
            this.atividade = atividade;
        }
    }
}
