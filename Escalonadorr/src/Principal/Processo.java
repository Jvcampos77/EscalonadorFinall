package Principal;

//isso aqui � so os get's e set's n�o preciso explicar n�?
public class Processo {

	private int id;
	private int prioridade;
	private int tempo;

	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getPrioridade() {
		return this.prioridade;
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public int getTempo() {
		return this.tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", prioridade=" + prioridade + ", tempo=" + tempo + "]";
	}
	
}
