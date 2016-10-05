package ideiah.sisponto02.modelo;
// Generated 14/06/2016 17:19:19 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ponto generated by hbm2java
 */
@Entity
@Table(name="ponto"
    ,schema="public"
)
public class Ponto  implements java.io.Serializable {


     private int idponto;
     private Funcionario funcionario;
     private Date data;
     private Date entrada;
     private Date saida;
     private String atividadeRealizada;
     private boolean status;

    public Ponto() {
    }

	
   
    @Id
    @Column(name="idponto", unique=true, nullable=false)
    public int getIdponto() {
        return this.idponto;
    }
    
    public void setIdponto(int idponto) {
        this.idponto = idponto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="funcionario_idfuncionario", nullable=false)
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data", nullable=false, length=13)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="entrada", nullable=false, length=15)
    public Date getEntrada() {
        return this.entrada;
    }
    
    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="saida", length=15)
    public Date getSaida() {
        return this.saida;
    }
    
    public void setSaida(Date saida) {
        this.saida = saida;
    }

    
    @Column(name="atividade_realizada", length=250)
    public String getAtividadeRealizada() {
        return this.atividadeRealizada;
    }
    
    public void setAtividadeRealizada(String atividadeRealizada) {
        this.atividadeRealizada = atividadeRealizada;
    }

    
    @Column(name="status", nullable=false)
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.data);
        hash = 37 * hash + Objects.hashCode(this.entrada);
        return hash;
    }

  


}


