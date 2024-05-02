package com.apipizzaria.models.dtos;
import com.apipizzaria.models.ClienteModel;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ClienteDTO {

    private UUID idCliente;
    private String nome;
    private String telefone;
    private String endereco;
    private String login;
    private String senha;

    public ClienteDTO(ClienteModel clienteModel) {
        this.idCliente = clienteModel.getId();
        this.nome = clienteModel.getNome();
        this.telefone = clienteModel.getTelefone();
        this.endereco = clienteModel.getEndereco();
        this.login = clienteModel.getLogin();
    }

    public static ClienteDTO fromClienteModel(ClienteModel clienteModel) {
        return new ClienteDTO(clienteModel);
    }

    public ClienteModel toClienteModel() {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(this.getIdCliente());
        clienteModel.setNome(this.getNome());
        clienteModel.setTelefone(this.getTelefone());
        clienteModel.setEndereco(this.getEndereco());
        clienteModel.setLogin(this.getLogin());
        return clienteModel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
