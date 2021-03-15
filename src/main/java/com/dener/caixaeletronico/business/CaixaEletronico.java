/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dener.caixaeletronico.business;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

/**
 *
 * @author dener
 */
public class CaixaEletronico {

    public void sacar(double saque) {
        try {

            System.out.println(calcularSaque(saque));

        } catch (InputMismatchException e) {
            System.err.println("Erro: dados informados inválidos !");
        }
    }

    public static String calcularSaque(double saque) {

        DecimalFormat formatador = new DecimalFormat("###,##0.00");

        if (saque <= 0 || saque > 1000000) {
            return ("\nSaque recusado valor inválido: R$" + formatador.format(saque) + "\n");
        } else {
            int nota[] = {100, 50, 20, 10, 5, 2, 1};
            int centavos[] = {50, 25, 10, 5, 1};
            String result;
            result = "Valor de saque= R$" + formatador.format(saque);
            result = calculaNotas(saque, nota, result);
            result = calculaCentavos(saque, centavos, result);
            return (result);
        }
    }

    private static String calculaNotas(double saque, int[] nota, String result) {
        int i;
        int valor;
        int quantidade;
        valor = (int) saque;
        i = 0;
        while (valor != 0) {
            quantidade = valor / nota[i];
            if (quantidade != 0) {
                result = result + (quantidade + "nota(s) de R$" + nota[i] + "\n");
                valor = valor % nota[i];
            }
            i++;
        }
        return result;
    }

    private static String calculaCentavos(double saque, int[] centavos, String result) {
        int i;
        int valor;
        int quantidade;
        valor = (int) Math.round((saque - (int) saque) * 100);
        i = 0;
        while (valor != 0) {
            quantidade = valor / centavos[i];
            if (quantidade != 0) {
                result = result + (quantidade + "moeda(s) de " + centavos[i] + " centavo(s)\n");
                valor = valor % centavos[i];
            }
            i++;
        }
        return result;
    }
}
