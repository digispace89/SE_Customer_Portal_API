package com.se.util;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordUtil {

	private static final Integer PASSWORD_LENGTH = 8;

	public static String generatePassword() {
		char[] possibleCharacters = (new String(
				"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?"))
						.toCharArray();
		String password = RandomStringUtils.random(PASSWORD_LENGTH, 0, possibleCharacters.length - 1, false, false,
				possibleCharacters, new SecureRandom());
		System.out.println(password);
		return password;
	}

}
