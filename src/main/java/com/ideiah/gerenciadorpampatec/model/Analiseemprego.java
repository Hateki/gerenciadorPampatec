package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Analiseemprego generated by hbm2java
 */
public class Analiseemprego implements java.io.Serializable {

    private int idAnaliseEmprego;
    private String relacoesClientes;
    private String parceriasChaves;
    private String canais;
    private String recursosPrincipais;
    private String concorrentes;
    private Set projetos = new HashSet(0);

    public Analiseemprego() {
    }

    public Analiseemprego(int idAnaliseEmprego) {
        this.idAnaliseEmprego = idAnaliseEmprego;
    }

    public Analiseemprego(int idAnaliseEmprego, String relacoesClientes, String parceriasChaves, String canais, String recursosPrincipais, String concorrentes, Set projetos) {
        this.idAnaliseEmprego = idAnaliseEmprego;
        this.relacoesClientes = relacoesClientes;
        this.parceriasChaves = parceriasChaves;
        this.canais = canais;
        this.recursosPrincipais = recursosPrincipais;
        this.concorrentes = concorrentes;
        this.projetos = projetos;
    }

    public int getIdAnaliseEmprego() {
        return this.idAnaliseEmprego;
    }

    public void setIdAnaliseEmprego(int idAnaliseEmprego) {
        this.idAnaliseEmprego = idAnaliseEmprego;
    }

    public String getRelacoesClientes() {
        return this.relacoesClientes;
    }

    public void setRelacoesClientes(String relacoesClientes) {
        this.relacoesClientes = relacoesClientes;
    }

    public String getParceriasChaves() {
        return this.parceriasChaves;
    }

    public void setParceriasChaves(String parceriasChaves) {
        this.parceriasChaves = parceriasChaves;
    }

    public String getCanais() {
        return this.canais;
    }

    public void setCanais(String canais) {
        this.canais = canais;
    }

    public String getRecursosPrincipais() {
        return this.recursosPrincipais;
    }

    public void setRecursosPrincipais(String recursosPrincipais) {
        this.recursosPrincipais = recursosPrincipais;
    }

    public String getConcorrentes() {
        return this.concorrentes;
    }

    public void setConcorrentes(String concorrentes) {
        this.concorrentes = concorrentes;
    }

    public Set getProjetos() {
        return this.projetos;
    }

    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }
}