import java.io.File;

public abstract class AtributosPessoa {
	
	protected String nome;
	protected String cpf;
	protected String senha;
	protected String diretorio;
	
	public void gravar() {
		File file = new File("Temporario.txt");
		ManipularArquivos.Write_semSubs("Temporario.txt", diretorio, nome + "\n" + cpf + "\n" + senha );
		ManipularArquivos.Write_semSubs(diretorio, "Temporario.txt");
		file.delete();
	}
	public abstract void setSenha(String s);
	public abstract String toString();
}