public class Funcionario extends AtributosPessoa{
	
	public Funcionario(String n, String Cpf, String s){
		nome = n;
		cpf = Cpf;
		senha = s;
		diretorio = "Funcionarios.txt";
		gravar();
	}
	public Funcionario() {
		//padrão
	}
	public void setSenha(String s) {
		senha = s;
	}
	public String toString() {
		return "NOME:" + nome + "\nCPF:" + cpf + "\nSENHA:" + senha; 
	}
}