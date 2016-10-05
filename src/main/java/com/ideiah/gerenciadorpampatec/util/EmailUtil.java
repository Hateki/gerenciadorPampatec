/**
 *
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.controller.RedirectManager;
import com.ideiah.gerenciadorpampatec.dao.EmailDao;
import com.ideiah.gerenciadorpampatec.model.EmailSystemConfig;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.MediaType;

/**
 * <p>
 * Classe responsável por gerenciar o envio de emails no sistema.
 * </p>
 *
 * @author Pedro
 */
public class EmailUtil {

    public EmailUtil() {
    }

    /**
     * <P>
     * Método responsável por enviar email ao empreendedor quando o projeto
     * associado a ele foi avaliado.</P>
     *
     * @param empreendedor
     * @param projetoNome
     *
     */
    public synchronized static void mandarEmailAvaliacao(Empreendedor empreendedor,
            String projetoNome) {

        if (empreendedor != null
                && projetoNome != null) {
            if (!empreendedor.getEmail().isEmpty()
                    && !empreendedor.getNome().isEmpty()
                    && !projetoNome.isEmpty()) {
                StringBuffer msg = new StringBuffer();

                // <editor-fold defaultstate="collapsed" desc="Mensagem do Email"> 
                msg.append("<!DOCTYPE html>\n"
                        + "<html lang=\"pt-br\">\n"
                        + "	<head>\n"
                        + "		<meta charset=\"utf-8\"/>\n"
                        + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                        + "    </head>\n"
                        + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                        + "			<h1>Boas notícias!</h1>\n"
                        + "			<form>\n"
                        + "				<div style=\"margin-bottom: 15px;\">\n"
                        + "					<a>Olá <strong>" + empreendedor.getNome() + "</strong>! Notificamos que o projeto <strong>" + projetoNome + "</strong> foi pré-avaliado e está a sua disposição.\n"
                        + "							<br/>\n"
                        + "							<br/>Para acessar o sistema gerenciador de projetos, clique na opção abaixo.</a>\n"
                        + "							<br/>\n"
                        + "							<br/>\n"
                        + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; "
                        + "                                                 vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; "
                        + "                                                 background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; "
                        + "                                                 line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; "
                        + "                                                 user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" "
                        + "                                                 href=\"" + RedirectManager.getBaseURL() + "\">\n"
                        + "								<strong>Acessar o sistema</strong>\n"
                        + "							</a>\n"
                        + "				</div>\n"
                        + "			</form>\n"
                        + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                        + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                        + "				\n"
                        + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                        + "			</div>\n"
                        + "		</div>\n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<!-- CSS embutido in line -->               \n"
                        + "    </body>\n"
                        + "</html>");
                // </editor-fold>
                SendSimpleMessage(empreendedor.getEmail(), msg.toString(), "Notificação");
            }
        }
    }

    /**
     * <P>
     * Método responsável por enviar email à todos os GERENTES quando um projeto
     * é submetido, ressubmetido e etc.</P>
     *
     * @param listaDeGerentes
     * @param empreendedorNome
     * @param statusProjeto
     * @param submissaoData
     * @param projetoNome
     */
    public synchronized static void enviaEmailParaGerentes(String projetoNome, String empreendedorNome,
            String submissaoData, String submissaoHora, String statusProjeto, ArrayList<GerenteRelacionamento> listaDeGerentes) {

        if (projetoNome != null && listaDeGerentes != null) {
            if (!projetoNome.isEmpty() && !listaDeGerentes.isEmpty()) {

                for (int i = 0; i < listaDeGerentes.size(); i++) {

                    StringBuffer msg = new StringBuffer();

                    // <editor-fold defaultstate="collapsed" desc="Mensagem do Email"> 
                    msg.append("<!DOCTYPE html>\n"
                            + "<html lang=\"pt-br\">\n"
                            + "	<head>\n"
                            + "		<meta charset=\"utf-8\"/>\n"
                            + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                            + "    </head>\n"
                            + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                            + "		<div style=\"width: 15%;\"></div>\n"
                            + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                            + "			<h1>Plano de negócio disponível para avaliação!</h1>\n"
                            + "			<form>\n"
                            + "				<div style=\"margin-bottom: 15px;\">\n"
                            + "					<a>Olá <strong>" + listaDeGerentes.get(i).getNome() + "</strong>! Notificamos que Plano de Negócio chamado <strong>" + projetoNome + "</strong>, do empreendedor <strong>" + empreendedorNome + "</strong>, <br/>atualizou seu status para <strong>" + statusProjeto + "</strong> em <strong>" + submissaoData + "</strong> às <strong>" + submissaoHora + "</strong>.\n"
                            + "							<br/>\n"
                            + "							<br/>Para acessar o sistema Gerenciador Pampatec, clique na opção abaixo.</a>\n"
                            + "							<br/>\n"
                            + "							<br/>\n"
                            + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; "
                            + "                                                     vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; "
                            + "                                                     background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; "
                            + "                                                     line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; "
                            + "                                                     user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" "
                            + "                                                     href=\"" + RedirectManager.getBaseURL() + "\">\n"
                            + "								<strong>Acessar o sistema</strong>\n"
                            + "							</a>\n"
                            + "				</div>\n"
                            + "			</form>\n"
                            + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                            + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                            + "				\n"
                            + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                            + "			</div>\n"
                            + "		</div>\n"
                            + "		<div style=\"width: 15%;\"></div>\n"
                            + "		<!-- CSS embutido in line -->               \n"
                            + "    </body>\n"
                            + "</html>");
                    // </editor-fold>

                    SendSimpleMessage(listaDeGerentes.get(i).getEmail(), msg.toString(), "Notificação");
                }
            }
        }
    }

    /**
     * <p>
     * Envio de email para empreendedor após avaliar plano.
     * </p>
     *
     * @param email
     * @param idUnico
     */
    public synchronized static void enviarEmailRecuperarSenha(String email, String idUnico) {
        if (email != null && idUnico != null) {
            if (!email.isEmpty() && !idUnico.isEmpty()) {

                StringBuffer msg = new StringBuffer();

                // <editor-fold defaultstate="collapsed" desc="Mensagem do Email">
                msg.append("<!DOCTYPE html>\n"
                        + "<html lang=\"pt-br\">\n"
                        + "	<head>\n"
                        + "		<meta charset=\"utf-8\"/>\n"
                        + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                        + "    </head>\n"
                        + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                        + "			<h1>Alterar Senha</h1>\n"
                        + "			<form>\n"
                        + "				<div style=\"margin-bottom: 15px;\">\n"
                        + "					<a>Verificamos que você esqueceu a sua senha.\n"
                        + "							<br/>\n"
                        + "							<br/>Por favor, <strong>clique na opção a baixo</strong> para redefinir uma nova senha e continuar.</a>\n"
                        + "							<br/>\n"
                        + "							<br/>\n"
                        + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" href=\"" + RedirectManager.getBaseURL() + "recuperarSenha.jsf?id=" + idUnico + "\">"
                        + "								<strong>Redefinir minha senha</strong>\n"
                        + "							</a>\n"
                        + "				</div>\n"
                        + "			</form>\n"
                        + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                        + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                        + "				\n"
                        + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                        + "			</div>\n"
                        + "		</div>\n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<!-- CSS embutido in line -->               \n"
                        + "    </body>\n"
                        + "</html>");
                // </editor-fold>

                SendSimpleMessage(email, msg.toString(), "Recuperação de Senha");
            }
        }
    }

    /**
     * <p>
     * Envio de email para concluir o cadastro.</p>
     *
     * @param empreendedorNome
     * @param projetoNome
     * @param email
     * @param idUnico
     */
    public synchronized static void mandarEmailConcluirCadastro(String empreendedorNome,
            String projetoNome, String email, String idUnico) {
        if (empreendedorNome != null && projetoNome != null && email != null && idUnico != null) {
            if (!empreendedorNome.isEmpty() && !projetoNome.isEmpty() && !email.isEmpty() && !idUnico.isEmpty()) {

                StringBuffer msg = new StringBuffer();

                // <editor-fold defaultstate="collapsed" desc="Mensagem do Email">
                msg.append("<!DOCTYPE html>\n"
                        + "<html lang=\"pt-br\">\n"
                        + "	<head>\n"
                        + "		<meta charset=\"utf-8\"/>\n"
                        + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                        + "    </head>\n"
                        + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                        + "			<h1>Concluir cadastro</h1>\n"
                        + "			<form>\n"
                        + "				<div style=\"margin-bottom: 15px;\">\n"
                        + "					<a>Olá!</a><br/><a>O empreendedor <strong>" + empreendedorNome + "</strong> adicionou você como sócio em seu novo projeto.\n"
                        + "                            <br/>Para que você possa utilizar o Sistema de Gerenciamento de Projetos do PampaTec é necessário confirmar o seu e-mail e realizar o seu cadastro.\n"
                        + "							<br/><br/>Para realizar o seu cadastro clique na opção abaixo.</a>\n"
                        + "							<br/>\n"
                        + "							<br/>\n"
                        + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" href=\"" + RedirectManager.getBaseURL() + "terminarCadastroEmpreendedor.jsf?id=" + idUnico + " \">\n"
                        + "								<strong>Concluir meu cadastro</strong>\n"
                        + "							</a>\n"
                        + "				</div>\n"
                        + "			</form>\n"
                        + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                        + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                        + "				\n"
                        + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                        + "			</div>\n"
                        + "		</div>\n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<!-- CSS embutido in line -->               \n"
                        + "    </body>\n"
                        + "</html>");
                // </editor-fold>
                SendSimpleMessage(email, msg.toString(), "Concluir Cadastro");
            }
        }
    }

    /**
     * <p>
     * Envio de email para confirmacao de email.</p>
     *
     * @param empreendedorNome
     * @param email
     * @param idUnico
     * @return
     */
    public synchronized static boolean mandarEmailConfirmacao(String empreendedorNome,
            String email, String idUnico) {

        if (empreendedorNome != null && email != null && idUnico != null) {
            if (!empreendedorNome.isEmpty() && !email.isEmpty() && !idUnico.isEmpty()) {
                StringBuffer msg = new StringBuffer();

                // <editor-fold defaultstate="collapsed" desc="Mensagem do Email">
                msg.append("<!DOCTYPE html>\n"
                        + "<html lang=\"pt-br\">\n"
                        + "	<head>\n"
                        + "		<meta charset=\"utf-8\"/>\n"
                        + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                        + "    </head>\n"
                        + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                        + "			<h1>Confirmar email</h1>\n"
                        + "			<form>\n"
                        + "				<div style=\"margin-bottom: 15px;\">\n"
                        + "					<a>\n"
                        + "                            <br/>Olá, " + empreendedorNome + "!</a><br/>\n"
                        + "                            Você se cadastrou no Sistema de gerenciamento de projetos do PampaTec, mas nós ainda precisamos verificar seu e-mail.\n"
                        + "                            <br/><br/>Para confirmar o seu email clique na opção abaixo.</a>\n"
                        + "							<br/>\n"
                        + "							<br/>\n"
                        + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" href=\"" + RedirectManager.getBaseURL() + "verificarEmail.jsf?id=" + idUnico + " \">\n"
                        + "								<strong>Confirmar meu e-mail</strong>\n"
                        + "							</a>\n"
                        + "				</div>\n"
                        + "			</form>\n"
                        + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                        + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                        + "				\n"
                        + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                        + "			</div>\n"
                        + "		</div>\n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<!-- CSS embutido in line -->               \n"
                        + "    </body>\n"
                        + "</html>");
                // </editor-fold>

                SendSimpleMessage(email, msg.toString(), "Confirmação de E-mail");
            }
        }

        return true;
    }

    /**
     * Método que realiza o envio de e-mail.
     *
     * @param email
     * @param msg
     * @param assunto
     * @return
     */
    public static ClientResponse SendSimpleMessage(String email, String msg, String assunto) {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api",
                "key-18a6549e405b5fbd9e5b8370075c039b"));
        com.sun.jersey.api.client.WebResource webResource
                = client.resource("https://api.mailgun.net/v3/ideiah.com"
                        + "/messages");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("from", "Gerenciador Pampatec <naoresponder@ideiah.com>");
        formData.add("to", email);
        formData.add("subject", "Gerenciador Pampatec - " + assunto);
        formData.add("html", msg);
        return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);
    }

    /**
     * <p>
     * Envio de email para confirmacao de email.</p>
     *
     * @param empreendedorNome
     * @param email
     * @param idUnico
     * @return
     */
    public synchronized static boolean mandarEmailConfirmacaoEdicao(String empreendedorNome,
            String email, String idUnico) {
        if (empreendedorNome != null && email != null && idUnico != null) {
            if (!empreendedorNome.isEmpty() && !email.isEmpty() && !idUnico.isEmpty()) {

                StringBuffer msg = new StringBuffer();

                // <editor-fold defaultstate="collapsed" desc="Mensagem do Email">
                msg.append("<!DOCTYPE html>\n"
                        + "<html lang=\"pt-br\">\n"
                        + "	<head>\n"
                        + "		<meta charset=\"utf-8\"/>\n"
                        + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                        + "    </head>\n"
                        + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                        + "			<h1>Confirmar email</h1>\n"
                        + "			<form>\n"
                        + "				<div style=\"margin-bottom: 15px;\">\n"
                        + "					<a>\n"
                        + "                            <br/>Olá, " + empreendedorNome + "!</a><br/>\n"
                        + "                            Você alterou o seu e-mail no Sistema de gerenciamento de projetos do PampaTec, com isso precisamos verificar seu e-mail.\n"
                        + "                            <br/><br/>Para confirmar o seu email clique na opção abaixo.</a>\n"
                        + "							<br/>\n"
                        + "							<br/>\n"
                        + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" href=\"" + RedirectManager.getBaseURL() + "verificarEmail.jsf?id=" + idUnico + " \">\n"
                        + "								<strong>Confirmar meu e-mail</strong>\n"
                        + "							</a>\n"
                        + "				</div>\n"
                        + "			</form>\n"
                        + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                        + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                        + "				\n"
                        + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                        + "			</div>\n"
                        + "		</div>\n"
                        + "		<div style=\"width: 15%;\"></div>\n"
                        + "		<!-- CSS embutido in line -->               \n"
                        + "    </body>\n"
                        + "</html>");
                // </editor-fold>
                SendSimpleMessage(email, msg.toString(), "Confirmação de E-mail");
            }

        }
        return true;
    }
}
