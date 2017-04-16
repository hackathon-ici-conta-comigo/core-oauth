package org.contacomigo.core.oauth.service.util;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.util.Pair;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

public class KeyPairUtils {
	
	public static JwtAccessTokenConverter jwtAccessTokenConverter(String resource, String password) {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource(resource), password.toCharArray()).getKeyPair(password);
        converter.setKeyPair(keyPair);
        return converter;
	}
	
    public static JwtAccessTokenConverter jwtAccessTokenConverter() {
    	try {
	    	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    	Pair<RSAPublicKeySpec, RSAPrivateKeySpec> Keys = buildKeys();
	    	PublicKey publicKey = keyFactory.generatePublic(Keys.getFirst());
	    	PrivateKey privateKey = keyFactory.generatePrivate(Keys.getSecond());
			KeyPair keyPair = new KeyPair(publicKey, privateKey);
			
	    	converter.setKeyPair(keyPair);
	    	
	    	return converter;
    	} catch (Exception e) {
	    	throw new RuntimeException(e);
    	}
    }
    
    private static Pair<RSAPublicKeySpec, RSAPrivateKeySpec> buildKeys() {
    	int keySize = 512;  
        SecureRandom random = new SecureRandom("text".getBytes());
        BigInteger p = BigInteger.probablePrime(keySize/2,random);
        BigInteger q = BigInteger.probablePrime(keySize/2,random);
        BigInteger modulus = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger publicExponent = getCoprime(m,random);
        BigInteger privateExponent = publicExponent.modInverse(m);
        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(modulus, privateExponent);

        return Pair.of(publicKeySpec, privateKeySpec);
    }
    
    private static BigInteger getCoprime(BigInteger m, SecureRandom random) {
        int length = m.bitLength()-1;
        BigInteger e = BigInteger.probablePrime(length,random);
        while (! (m.gcd(e)).equals(BigInteger.ONE) ) {
            e = BigInteger.probablePrime(length,random);
        }
        return e;
    }

}
