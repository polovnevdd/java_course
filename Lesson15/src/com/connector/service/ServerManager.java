package com.connector.service;

public class ServerManager {
    public boolean perevirkaNaKozaka(String line){
        char[] arrOfLine = line.toLowerCase().toCharArray();
        for (char c : arrOfLine) {
            if(c == 'ы' || c == 'э' || c == 'ё' || c == 'ъ'){
                return false;
            }
        }
        return true;
    }
}
