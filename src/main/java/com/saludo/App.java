package com.saludo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Aplicación de ejemplo con buenas prácticas
 */
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    
    public static void main(String[] args) {
        LOGGER.info("Iniciando aplicación...");
        
        // Ejemplo de manejo seguro de credenciales
        String password = System.getenv("APP_PASSWORD");
        if (password == null) {
            LOGGER.warning("No se ha configurado la contraseña en variables de entorno");
            password = "default"; // Solo para desarrollo
        }
        
        // Ejemplo de consulta SQL segura usando PreparedStatement
        String username = "admin";
        String secureSqlQuery = "SELECT * FROM users WHERE username = ?";
        LOGGER.info("Consulta preparada: " + secureSqlQuery);
        
        // Ejemplo de manejo correcto de argumentos
        if (args.length > 0) {
            processArguments(args[0]);
        }
        
        // Ejemplo de manejo correcto de excepciones
        try {
            int result = divide(10, 2);
            LOGGER.info("Resultado de la división: " + result);
        } catch (ArithmeticException e) {
            LOGGER.log(Level.SEVERE, "Error en la operación matemática", e);
            // No usar System.exit, mejor manejar el error apropiadamente
            throw new RuntimeException("Error en cálculo", e);
        }
    }
    
    private static void processArguments(String arg) {
        LOGGER.info("Procesando argumento: " + arg);
        // Procesar argumentos de forma segura
    }
    
    private static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }
}
