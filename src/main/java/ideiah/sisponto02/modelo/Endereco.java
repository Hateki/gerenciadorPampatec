package ideiah.sisponto02.modelo;
// Generated 14/06/2016 17:19:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Endereco generated by hbm2java
 */
@Entity
@Table(name="endereco"
    ,schema="public"
)
public class Endereco  implements java.io.Serializable {


     private int idendereco;
     private String bairro;
     private String logradouro;
     private Integer numero;
     private String rua;
     private String complemento;
     private String cidade;
     private String estado;
     private Set<Funcionario> funcionarios = new HashSet<Funcionario>(0);

    public Endereco() {
    }

	
   
     @Id 

    
    @Column(name="idendereco", unique=true, nullable=false)
    public int getIdendereco() {
        return this.idendereco;
    }
    
    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    
    @Column(name="bairro", nullable=false, length=30)
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    @Column(name="logradouro", nullable=false, length=30)
    public String getLogradouro() {
        return this.logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    
    @Column(name="numero", nullable=false)
    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
    @Column(name="rua", nullable=false, length=30)
    public String getRua() {
        return this.rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    
    @Column(name="complemento", length=30)
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    
    @Column(name="cidade", nullable=false, length=20)
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
    @Column(name="estado", nullable=false, length=20)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="endereco")
    public Set<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }




}


