import junit.framework.*;
public class ClasseTest extends TestCase {

	public void testSetSenha() {
		Cliente x = new Cliente();
		x.setSenha("senhateste");
		assertEquals("senhateste",x.senha);
	}
	
	public void testStringToString() {
		Cliente x = new Cliente();
		x.nome = "Luis";
		x.cpf = "123123123-12";
		x.senha = "senhateste";
		String retornoEsperado="NOME:Luis\nCPF:123123123-12\nSENHA:senhateste";
		String retornoFeito= x.toString();
		assertEquals(retornoEsperado,retornoFeito);
	}
	
}