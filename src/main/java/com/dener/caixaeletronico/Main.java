/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dener.caixaeletronico;

import com.dener.caixaeletronico.business.CaixaEletronico;

/**
 *
 * @author dener
 */
public class Main {
    public static void main(String[] args) {
        
        CaixaEletronico saque = new CaixaEletronico();
        saque.sacar(999999.69D);
        saque.sacar(384.71D);
        saque.sacar(38432.71D);
        saque.sacar(-38.70D);
        saque.sacar(34289232397.27D);
        saque.sacar(0D);
    }
}
