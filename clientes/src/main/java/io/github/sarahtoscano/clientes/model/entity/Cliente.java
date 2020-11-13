package io.github.sarahtoscano.clientes.model.entity;
import org.apache.tomcat.jni.Local;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data//Sem necessidade de setar o get e set, usa o lombok p facilitar
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autp-incremento no ID automatico pelo banco de dados
    private Integer id;
    
    @Column(nullable = false, length = 255) //Torna o campo nome obrigatório
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column (nullable = false, length = 11) //Obrigatório e size maximo
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name="data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }



}
