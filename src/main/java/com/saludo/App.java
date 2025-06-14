package com.saludo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Falla crítica: contraseña hardcodeada
        String password = "123456";
        System.out.println("La contraseña es: " + password);

        // Falla crítica: SQL Injection
        String userInput = "admin' OR '1'='1";
        String query = "SELECT * FROM users WHERE username='" + userInput + "'";
        System.out.println("Query: " + query);

        // Falla crítica: uso de System.exit
        if (args.length > 0 && args[0].equals("exit")) {
            System.exit(1);
        }

        // Falla crítica: catch vacío
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            // Ignorado
        }
    }
}
