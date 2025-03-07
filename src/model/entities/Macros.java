package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Macros {
	private static List<Instrucao> macro;
	private Instrucao prototipo;
	
	public Macros(List<Instrucao> macro) {
		super();
		Macros.macro = macro;
		prototipo = macro.get(0);
		macro.remove(0);
	}

	public List<Instrucao> getMacro() {
		return macro;
	}

	public void setMacro(List<Instrucao> macro) {
		Macros.macro = macro;
	}

	public Instrucao getPrototipo() {
		return prototipo;
	}

	public void setPrototipo(Instrucao prototipo) {
		this.prototipo = prototipo;
	}
	
	public void modoDeDefinicao() {
		int cont = 0;
		List<String> parametros = Arrays.asList(prototipo.getRotulo());
		for(String s: prototipo.getArgs()) {
			parametros.add(s);
		}
		for(Instrucao instrucaoMacro: macro) {
			for(String parametro: parametros) {
				List<String> novosArgumentos = new ArrayList<>();
				instrucaoMacro.getArgs().forEach(x -> novosArgumentos.add(x));
				if(instrucaoMacro.getRotulo().equals(parametro)) {
					instrucaoMacro.setRotulo("#" + cont);
				}
				for(String argumentos: instrucaoMacro.getArgs()) {
					if(argumentos.contains(parametro)) {
						novosArgumentos.add("#" + cont);
					}
					else {
						novosArgumentos.add(argumentos);
					}
				}
				cont++;
				instrucaoMacro.setArgs(novosArgumentos);
			}
		}
		saidaMacro();
	}
	
	public static void saidaMacro(){
		String path = "C:\\Temp\\ws-eclipse\\PS__Trabalho\\src\\Saida\\MASMAPRG.ASM";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for(Instrucao instrucaoMacros: macro) {
				bw.write(instrucaoMacros.getRotulo() + " ");
				bw.write(instrucaoMacros.getNome() + " ");
				bw.write(instrucaoMacros.getEndereco() + "\n");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	
}
