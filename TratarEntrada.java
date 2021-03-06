package heimdall;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guilherme
 */
public class TratarEntrada {   
    public boolean whiteList (String entrada){
        entrada = entrada.toUpperCase();
        String permitido = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ._";
        
        if(entrada.length() == 0){
            return false;
        }
        
        for(int i=0; i<entrada.length(); i++){
            if(!permitido.contains(entrada.charAt(i)+""))
                return false;
        }
        return true;
    }
    
    public static boolean isValidCPF(String cpf) {
        cpf = cpf.replace(".", "").replace("-","");
        final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        
        if (cpf==null || !cpf.matches("\\d{11,11}")) 
            return false;

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
   }
    
    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
           digito = Integer.parseInt(str.substring(indice,indice+1));
           soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    
    public String noSQLInjection (String query){
        if(query.contains("'") || query.contains(";") || query.contains("=")){
            query = query.replaceAll("'", "");
            query = '\''+query+'\'';
        }
        
        return query;
    }
}
