/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova;

/**
 *
 * @author Musilová
 */

//bude sloužit jako obecný typ
public class Bod {
    
    //kdyby byly atributy deklarovány jako statické, stávají se společné všem objektům a přísluší třídě 
    //v této chvíli nechceme, aby tyto atribudy byly statické, protože chceme, aby každý bod měl své vlastní souřadnice
    //statický atribt se hodí např. pro počítání množstív bodů - kolik existuje enistancí Bodů
    //budou nezávilsé na existenci objektu a společné pro všechny instance 
    double x;
    double y;
    //tvorba konstruktoru
    //jelikož byl třítě pčidán konstruktor, 
    //tak už nemá k dispozici implicitní konstruktor bez parametrů 
    public Bod(double xa, double ya) {
        x = xa;
        y = ya;
    }
    //určení vzdálenosti bodu od počátku 
    //musí být bez parametrů, protože metoda nepotřebuje k výpočtu nic jiného, než souřadnice daného bodu
    public double getVzd() {
        
    } 
}
