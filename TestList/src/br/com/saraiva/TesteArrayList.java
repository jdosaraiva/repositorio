package br.com.saraiva;

import java.util.ArrayList;
import java.util.List;

public class TesteArrayList {

	public static void main(String[] args) {
		
		List<UmBean> l = new ArrayList<UmBean>();
		
		l.add(new UmBean("Um"));
		l.add(new UmBean("Dois"));
		
		for (UmBean umBean : l) {
			System.out.println(umBean.getNome());
		}
		
		l.set(1, null);
		
		System.out.println("Tamanho da Lista:[" + l.size() + "]");
		
		l.remove(1);
		
		System.out.println("Tamanho da Lista:[" + l.size() + "]");
	}
	
}
