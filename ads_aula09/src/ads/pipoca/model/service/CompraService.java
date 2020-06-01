package ads.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;

import ads.pipoca.model.dao.CompraDAO;
import ads.pipoca.model.entity.Compra;

public class CompraService {
	private CompraDAO dao;
	
	public CompraService() {
		this.dao = new CompraDAO();
	}
	public void gravarLogCompra(String path, ArrayList<Compra> compras) throws IOException {
		dao.gravarCompras(path, compras);
	}
	
	public ArrayList<Compra> lerLogCompra(String path) throws IOException {
		ArrayList<Compra> compras = dao.lerCompras(path);
		return compras;
	}
}
