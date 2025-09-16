public class CadastroEquipamentos {
	public CadastroEquipamentos(int codigoEquipamento, String nomeEquipamento,
                                int codigoMarca, String nomeCliente, String telCliente,
                                String defeito, String data) {
		super();
		this.codigoEquipamento = codigoEquipamento;
		this.nomeEquipamento = nomeEquipamento;
		this.codigoMarca = codigoMarca;
		this.nomeCliente = nomeCliente;
		this.telCliente = telCliente;
		this.defeito = defeito;
		this.data = data;
	}

	private int codigoEquipamento;
	private String nomeEquipamento;
	private int codigoMarca;
	private String nomeCliente;
	private String telCliente;
	private String defeito;
	private String data;

	public int getCodigoEquipamento() {
		return codigoEquipamento;
	}

	public void setCodigoEquipamento(int codigoEquipamento) {
		this.codigoEquipamento = codigoEquipamento;
	}

	public String getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(String nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelCliente() {
		return telCliente;
	}

	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toString() {
		return "cadastroEquipamentos [codigoEquipamento=" + codigoEquipamento
				+ ", nomeEquipamento=" + nomeEquipamento + ", codigoMarca="
				+ codigoMarca + ", nomeCliente=" + nomeCliente
				+ ", telCliente=" + telCliente + ", defeito=" + defeito
				+ ", data=" + data + "]";
	}
}
