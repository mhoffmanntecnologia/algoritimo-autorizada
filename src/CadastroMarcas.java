public class CadastroMarcas {
	private int codigoMarca;
	private String nomeMarca;

	public CadastroMarcas(int codigoMarca, String nomeMarca) {

		this.codigoMarca = codigoMarca;
		this.nomeMarca = nomeMarca;
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String toString() {
		return "cadastroMarcas [codigoMarca=" + codigoMarca + ", nomeMarca="
				+ nomeMarca + "]";
	}

}
