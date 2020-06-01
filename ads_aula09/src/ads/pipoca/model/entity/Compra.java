package ads.pipoca.model.entity;

import java.util.Date;

public class Compra {
	private Date dataCompra;
	private int idFilme;
	private String tituloFilme;
	private String usuario;
	
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public String getTituloFilme() {
		return tituloFilme;
	}
	public void setTituloFilme(String tituloFilme) {
		this.tituloFilme = tituloFilme;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Compra [dataCompra=" + dataCompra + ", idFilme=" + idFilme + ", tituloFilme=" + tituloFilme
				+ ", usuario=" + usuario + "]";
	}
}
