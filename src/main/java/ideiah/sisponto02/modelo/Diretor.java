package ideiah.sisponto02.modelo;
// Generated 14/06/2016 17:19:19 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Diretor generated by hbm2java
 */
@Entity
@Table(name = "diretor", schema = "public"
)
public class Diretor implements java.io.Serializable {

    private int iddiretor;
    private String cargo;
    private Date dataPosse;
    private String senha;
    private Set<Funcionario> funcionarios = new HashSet<Funcionario>(0);
    public static final String DIRETORPRESIDENTE = "Diretor Presidente";
    public static final String DIRETORADMINISTRATIVO = "Diretor Administrativo";
    public static final String DIRETORNEGOCIO = "Diretor de Negócios";
    public static final String DIRETORDESENVOLVIMENTO = "Diretor de Desenvolvimento";

    public Diretor() {
    }

    public Diretor(int iddiretor, String cargo, Date dataPosse, String senha) {
        this.iddiretor = iddiretor;
        this.cargo = cargo;
        this.dataPosse = dataPosse;
        this.senha = senha;
    }

    public Diretor(int iddiretor, String cargo, Date dataPosse, String senha, Set<Funcionario> funcionarios) {
        this.iddiretor = iddiretor;
        this.cargo = cargo;
        this.dataPosse = dataPosse;
        this.senha = senha;
        this.funcionarios = funcionarios;
    }

    @Id

    @Column(name = "iddiretor", unique = true, nullable = false)
    public int getIddiretor() {
        return this.iddiretor;
    }

    public void setIddiretor(int iddiretor) {
        this.iddiretor = iddiretor;
    }

    @Column(name = "cargo", nullable = false, length = 30)
    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data_posse", nullable = false, length = 13)
    public Date getDataPosse() {
        return this.dataPosse;
    }

    public void setDataPosse(Date dataPosse) {
        this.dataPosse = dataPosse;
    }

    @Column(name = "senha", nullable = false, length = 20)
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diretor")
    public Set<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
