package Relatorios;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atendente.Conexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;



public class HistoricoAcesso implements ActionListener{


private JTextField relatorio;

public HistoricoAcesso(JTextField relatorio) {
	this.relatorio = relatorio;
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	gererRelatorio();
}

private void gererRelatorio() {
	
	String erro = "";
	String acesso = relatorio.getText();
	String jasper = "C:\\Users\\Thiago\\JaspersoftWorkspace\\RelatórioFuncionário\\Relatorio.jasper";	
	HashMap<String, Object> param = new HashMap<String, Object>();
	param.put("Relatorio", acesso);
	
	byte[] bytes = null;
	
	try {
		
		Conexao con = new Conexao();
		
		JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(jasper);
		
		bytes = JasperRunManager.runReportToPdf(relatorio,param, con.getConexao());
		
		File arq = new File("C:\\Users\\Thiago\\JaspersoftWorkspace\\RelatórioFuncionário\\",acesso+".pdf");
		if(arq.exists()) {
			arq.delete();
		}
		FileOutputStream fos = new FileOutputStream(arq);
		fos.write(bytes);
		fos.flush();
		fos.close();
		
		Desktop desk = Desktop.getDesktop();
		desk.open(arq);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		erro = e.getMessage();
		JOptionPane.showMessageDialog(null,erro);
	}
	
}
   
	
}

