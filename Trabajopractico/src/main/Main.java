package main;

import abonado.Abonado;
import abonado.Fisica;
import abonado.Juridica;
import decorator.Comercio;
import decorator.Decorable;
import decorator.DecoratorAbonado;
import decorator.Vivienda;

public class Main {

	public static void main(String[] args) {
		Abonado f1=new Fisica("bruno",123);
		Abonado j1=new Juridica("alan",456);
		DecoratorAbonado v1=new Vivienda((Decorable)f1);
		DecoratorAbonado v2=new Comercio((Decorable)j1);
		System.out.println(v1.toString());
		System.out.println(v2.toString());
	}

}
