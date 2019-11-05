import javax.swing.JOptionPane;
import java.util.*;
public class testetrab2{
	static String nome,rico;
	static int i, j, a;
	static double saldo,maior;
	static double vetorsaldo[] = new double[9];

	//Tipo abstrato de dado (TAD)
	public class NomesContasSaldos{ 
		String nomes;
		int contas;
		double saldos;
			}
		}

	//Matriz do TAD 
	static NomesContasSaldos info[] = new NomesContasSaldos[9];

	// Erros estão acontecendo com todas as matrizes.
	// Problemas na declaração de variáveis aparentemente.
	
	public static final String A[][]=new String[3][3];
	static{
		A[0][0] = "Tibúrcio";
		A[0][1] = "Ricardo";
		A[0][2] = "João";
		A[1][0] = "Felisbino";
		A[1][1] = "Seu Zé";
		A[1][2] = "Dona Maria";
		A[2][0] = "Gedonstrôncio";
		A[2][1] = "Batman";
		A[2][2] = "Homem de Ferro";
	}
	
	static int B[][]=new int[3][3];
	static{
		B[0][0] = 111;
		B[0][1] = 222;
		B[0][2] = 333;
		B[1][0] = 444;
		B[1][1] = 555;
		B[1][2] = 666;
		B[2][0] = 777;
		B[2][1] = 888;
		B[2][2] = 999;
	}
	
	static double C[][]=new double[3][3];
	static{
		C[0][0]=0.0;
		C[0][1]=0.0;
		C[0][2]=0.0;
		C[1][0]=0.0;
		C[1][1]=0.0;
		C[1][2]=0.0;
		C[2][0]=0.0;
		C[2][1]=0.0;
		C[2][2]=0.0;
	}
	
	
	//1 – Inserir Recebimento 
	public static double Recebimento(int conta,double transacao){
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				if (conta == B[i][j]) {
					C[i][j] = C[i][j] + transacao;
					saldo = C[i][j];
					nome= A[i][j];
				}
			}
		}return saldo;
	}

	//2 – Inserir Pagamento
	public static double Pagamento(int conta,double transacao){
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				if (B[i][j] == conta) {
					C[i][j] = C[i][j] - transacao;
					saldo = C[i][j];
					nome = A[i][j];
				}
			}
		}return saldo;
	}
	//3 – Mostre em apenas uma mensagem todos os Números de Conta, Correntistas e Saldos respectivos
	public static void TodosNomesContasSaldos(){
		new info();
		a = 0;
		info[0] = new NomesContasSaldos();
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				info[a].nomes = A[i][j];
				info[a].contas = B[i][j];
				info[a].saldos = C[i][j];
				a++;
			}
		}
	}

	//4 – Mostre em apenas uma mensagem o Número da Conta, o Nome do Correntista e o saldo do correntista mais RICO.
	public static int Maisrico(){
		int contarico=0;
		maior=0;
		rico="";
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3;j++) {
				if (C[i][j]>maior) {
					maior=C[i][j];
					rico=A[i][j];
					contarico=B[i][j];
				}
			}
		}return contarico;
	}

	//5 – Mostre em apenas uma mensagem todos os saldos ordenados do menor para o maior usando BubbleSort.

	public static void OrdenadoMaisrico(){
		double aux;
		a = 0;
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				vetorsaldo[a]=C[i][j];
				a++;
			}
		}
		int troca = 1;
		int fim = a - 1;
		while(troca==1){
			troca = 0;
			for(i=0; i<fim;i++){
				if (vetorsaldo[i] > vetorsaldo[i+1]){
					aux = vetorsaldo[i];
					vetorsaldo[i] = vetorsaldo[i+1];
					vetorsaldo[i+1] = aux;
					troca = 1;
				}	
			}
		}                    
	}

	public static void main(String[] args) {
		int operacao = 0;
		
		while(operacao<=5){
			switch(operacao){
				case 0:
					operacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das operações abaixo: \n"
						+"1 - Inserir Recebimento \n"
						+"2 - Inserir Pagamento \n"
						+"3 - Todos os Números de Conta, Correntistas e Saldos respectivos \n"
						+"4 - O Número da Conta, o Nome do Correntista e o saldo do correntista mais RICO \n"
						+"5 - Os saldos ordenados do menor para o maior \n"
						+"6 - Sair"));
				break;
 
				case 1:
					int contaAReceber = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta"));
					double recebimento = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser depositado"));
					saldo=Recebimento(contaAReceber,recebimento);
					JOptionPane.showMessageDialog(null,nome + " seu saldo atual é de: " + saldo);
					operacao = 0;
				break;
			
				case 2:
					int contaAPagar = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
					double pagamento = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do pagamento"));
					saldo=Pagamento(contaAPagar,pagamento);
					JOptionPane.showMessageDialog(null, nome + " seu saldo atual é de: " + saldo);
					operacao = 0;
				break;
				
				case 3:
					TodosNomesContasSaldos();
					JOptionPane.showMessageDialog(null,"Números das contas " + Arrays.toString(info.contas)
						+"\nNomes dos correntistas " + Arrays.toString(info.nomes)
						+"\nSaldos das contas " + Arrays.toString(info.saldos));
					operacao = 0;
				break;

				case 4:
					int maisrico = Maisrico();
					JOptionPane.showMessageDialog(null," Numero da conta do correntista mais rico: "+maisrico
						+"\n Em nome de: "+rico
						+"\n Com o saldo de: "+maior);
					operacao = 0;
				break;

				case 5:                   
					OrdenadoMaisrico();
					JOptionPane.showMessageDialog(null,"Os saldos ordenados do menor para o maior são: \n"+ Arrays.toString(vetorsaldo));
					operacao = 0;
				break;

				case 6:
					operacao = 6;
				break;
			}
		}
	}
}
