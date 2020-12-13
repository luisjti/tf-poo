import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.FileNotFoundException;

public class ManipularArquivos {
	
	public static String Read(String Diretorio){
        String conteudo = "";
        try {
            FileReader arquivo = new FileReader(Diretorio);
            BufferedReader lerArq = new BufferedReader(arquivo);
            String linha = "";
            try {
            	linha = lerArq.readLine();
            	while(linha != null) {
            		conteudo += linha + "\r\n";
            		linha = lerArq.readLine();
            	}
                arquivo.close();
                return conteudo;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
                return "";
            }
        } catch (FileNotFoundException ex) {
        	JOptionPane.showMessageDialog(null, "Arquivo não encontrado!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
    }
	public static String ReadSub(String Diretorio){
        String conteudo = "";
        try {
            FileReader arquivo = new FileReader(Diretorio);
            BufferedReader lerArq = new BufferedReader(arquivo);
            String linha = "";
            String linha1 = "";
            try {
                linha = lerArq.readLine();
                linha1 = lerArq.readLine();
                while(linha!=null){
                	if(linha1 != null) 
                		conteudo += linha + "\r\n";
                	else 
                		conteudo += linha;
                    linha = linha1;
                    linha1 = lerArq.readLine();
                } 
                arquivo.close();
                return conteudo;
            } catch (IOException ex) {
            	JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
                return "";
            }
        } catch (FileNotFoundException ex) {
        	JOptionPane.showMessageDialog(null, "Arquivo não encontrado!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
    }

	
	public static boolean Write(String Diretorio, String Texto){
        try {
            FileWriter arquivo = new FileWriter(Diretorio);
            PrintWriter gravarArq = new PrintWriter(arquivo);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
	
	public static boolean Write_semSubs(String Diretorio, String Diretorio1, String Texto){
        try {
            FileWriter arquivo = new FileWriter(Diretorio);
            PrintWriter gravarArq = new PrintWriter(arquivo);
            String cont = ManipularArquivos.Read(Diretorio1);
            cont += Texto; 
            gravarArq.println(cont);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
	public static boolean Write_semSubs(String Diretorio, String Diretorio1){
        try {
            FileWriter arquivo = new FileWriter(Diretorio);
            PrintWriter gravarArq = new PrintWriter(arquivo);
            String cont = ManipularArquivos.ReadSub(Diretorio1); 
            gravarArq.println(cont);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
	
	public static ArrayList<String> Param(String Diretorio){
        
        ArrayList<String> conteudo = new ArrayList<String>();   
        try {
            FileReader arquivo = new FileReader(Diretorio);
            BufferedReader lerArq = new BufferedReader(arquivo);
            String linha = "";
            try {
            	linha = lerArq.readLine();
            	while(linha!=null) {
            		conteudo.add(linha);
            		linha = lerArq.readLine();
            	}
            	arquivo.close();
            } catch (IOException ex) {
            	JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
            }
        	} catch (FileNotFoundException ex) {
        		JOptionPane.showMessageDialog(null, "Arquivo não encontrado!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        	}
		return conteudo;
	}
}