package com.ciss.crudfuncionariows.util;

import java.util.logging.Logger;

/**
 * @author Ariel L. Henz
 * 
 */
import org.apache.commons.lang.RandomStringUtils;

public class Util {

	public static void log(String className, String msg) {
		Logger log = Logger.getLogger(className);
		log.info(msg);
	}

	public static String randomize(Integer tamanho, Boolean usarLetras, Boolean usarNumeros) {
		return RandomStringUtils.random(tamanho, usarLetras, usarNumeros);
	}

	public static Boolean isEmailValido(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	
	public static Boolean isApenasNumeros(String numeroPis) {
		return numeroPis.matches("[0-9]+") && numeroPis.length() > 2;
	}

}
