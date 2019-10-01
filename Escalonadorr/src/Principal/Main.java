package Principal;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {
	
	static ArrayList<Processo> Altaprioridade = new ArrayList<Processo>();
	static ArrayList<Processo> Mediaprioridade = new ArrayList<Processo>();
	static ArrayList<Processo> Baixaprioridade = new ArrayList<Processo>();	
	static Processo ProcessoAuxiliar;
	static ArrayList<Processo>Finalizados = new ArrayList<Processo>();
	

	public static ArrayList<Processo> preencher(int quantProcessos, int prioridade){

		Random r = new Random();
		ArrayList<Processo> processosPreenchidos = new ArrayList<Processo>();
		Processo processoTemp;		
		for(int i = 0; i < quantProcessos; i++) {
			int Tempo = r.nextInt(15) + 1;
			processoTemp = new Processo();
			processoTemp.setID(i);
			processoTemp.setPrioridade(prioridade);
			
			processoTemp.setTempo(Tempo);
			
			processosPreenchidos.add(processoTemp);
			
		}
		for(int index = 0; index < quantProcessos; index++) {
			System.out.println(processosPreenchidos.get(index).toString());
			
		}
		if(prioridade == 3) {
			Altaprioridade = processosPreenchidos;
			}
		if(prioridade == 2) {
			Mediaprioridade = processosPreenchidos;
		}
		if(prioridade == 1) {
			Baixaprioridade = processosPreenchidos;
		}
		return processosPreenchidos;
				
	}
	
	public static void pronto(){
		
		boolean alto;
		boolean medio;
		boolean baixo;
		
		while(true) {
			alto = false;
			medio = false;
			baixo = false;
			
			if(Altaprioridade.size() > 0) {
				for(int i = 0; i<4; i+=1) {
					if(Altaprioridade.size() > 0) {
						ProcessoAuxiliar = Altaprioridade.get(0);
						Altaprioridade.remove(0);
						executar();
						
					}
				}
				
			}else {
				alto = true;
			}
			if (Mediaprioridade.size() > 0) {
				for(int i = 0; i<3; i+=1) {
					if(Mediaprioridade.size() > 0) {
						ProcessoAuxiliar = Mediaprioridade.get(0);
						Mediaprioridade.remove(0);
						executar();
					}
				}
			}else {
				medio = true;
			}
			if (Baixaprioridade.size() > 0) {
				ProcessoAuxiliar = Baixaprioridade.get(0);
				Baixaprioridade.remove(0);
				executar();
			}else {
				baixo = true;
			}
			if(alto == true && medio == true && baixo == true) {
				break;
			}
		}
		finalizar();
	}
	
	public static void executar() {
		ProcessoAuxiliar.setTempo(ProcessoAuxiliar.getTempo()-1);
		if(ProcessoAuxiliar.getTempo() > 0) {
			suspender();
		}else {
			Finalizados.add(ProcessoAuxiliar);
		}
		
	}
	public static void suspender() {
		if(ProcessoAuxiliar.getPrioridade() == 3) {
			Altaprioridade.add(ProcessoAuxiliar);
		}else if(ProcessoAuxiliar.getPrioridade() == 2) {
			Mediaprioridade.add(ProcessoAuxiliar);			
		}else if(ProcessoAuxiliar.getPrioridade() == 1) {
			Baixaprioridade.add(ProcessoAuxiliar);
		}
		
	}
	public static void finalizar() {
		for(int i = 0; i<Finalizados.size();i+=1) {
			System.out.printf("\nProcessos finalizados: "+Finalizados.get(i) );
		}
	}
	

	public static void main(String[] args) {
		
		ArrayList<Processo> processoalto = new ArrayList<Processo>();
		ArrayList<Processo> processomedio = new ArrayList<Processo>();
		ArrayList<Processo> processobaixo = new ArrayList<Processo>();
		
		Main main = new Main();
		//nesta parte abaixo ira ler as quantidades de processos de cada fila e atribuir sua prioridade automaticamente
		//apos cada leitura, automaticamente o programa ira para funcao preencher onde ira construir e atribuir tempo, depois de contruir a fila o programa volta
		//e le novamente so que com outra fila de prioridade diferente e repete o mesmo processo de construção
		int quantAlto = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade processos de alta prioridade"));
		processoalto = main.preencher(quantAlto, 3);
		
		int quantMedio = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade processos de média prioridade"));
		processomedio = main.preencher(quantMedio, 2);
		
		int quantBaixo = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade processos de baixa prioridade"));
		processobaixo = main.preencher(quantBaixo, 1);
		
		//aqui ira chamar a função pronto logo apos construir as filas
		pronto();
	}

}
