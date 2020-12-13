
public class Cliente extends AtributosPessoa{
	
	public Cliente(String n, String Cpf, String s){
		nome = n;
		cpf = Cpf;
		senha = s;
		diretorio = "Clientes.txt";
		gravar();
	}
	public Cliente() {
		//padrão
	}
	public void setSenha(String s) {
		senha = s;
	}
	public String toString() {
		return "NOME:" + nome + "\nCPF:" + cpf + "\nSENHA:" + senha;
	}
}