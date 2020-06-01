package ads.pipoca.model.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import ads.pipoca.model.entity.Compra;

public class CompraDAO {
	public static final String SEP=";";
	
	public void gravarCompras(String path, ArrayList<Compra> compras) throws IOException {
		File fPath = new File(path);
		if (!fPath.exists()) {
			fPath.mkdir();
		}
		File outFile = new File(path,"compras.log");
		//passando true como segundo parametro do construtor faz append
		FileOutputStream outFileStream = new FileOutputStream(outFile, true);
		PrintWriter writer = new PrintWriter(outFileStream);
		String linha = "";
		System.out.println(outFile);
		for(Compra compra:compras) {
			linha = compra.getDataCompra().getTime()+SEP+compra.getIdFilme()+
					SEP+compra.getTituloFilme()+SEP+compra.getUsuario();
			System.out.println(linha);
			writer.println(linha);
		}
		writer.close();
	}
	
	public ArrayList<Compra> lerCompras(String path) throws IOException{
		ArrayList<Compra> compras = new ArrayList<>();
		File inFile = new File(path,"compras.log");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
		String linha;
		String sData, sId, sTitulo, sUsuario;
		Compra compra;
		while ((linha = bufReader.readLine()) != null){
			sData = linha.substring(0,linha.indexOf(SEP));
			linha = linha.substring(sData.length()+1);
			sId = linha.substring(0,linha.indexOf(SEP));
			linha = linha.substring(sId.length()+1);
			sTitulo = linha.substring(0,linha.indexOf(SEP));
			sUsuario = linha.substring(sTitulo.length()+1);
			System.out.printf("data: %s id: %s titulo: %s usuario: %s\n",sData,
					sId, sTitulo, sUsuario);
			compra = new Compra();
			compra.setDataCompra(new Date(Long.parseLong(sData)));
			compra.setIdFilme(Integer.parseInt(sId));
			compra.setTituloFilme(sTitulo);
			compra.setUsuario(sUsuario);
			System.out.println(compra);
			compras.add(compra);
		}
		
		bufReader.close();
		return compras;
	}
}
