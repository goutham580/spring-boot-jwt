package ezc.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import ezc.util.EzCipher;


public class EzPasswordEncoder implements PasswordEncoder {


	@Override
	public String encode(CharSequence charSequence) {
        return new EzCipher().ezEncrypt(charSequence.toString());

	}

	@Override
	public boolean matches(CharSequence charSequence, String s) {
        return new EzCipher().ezEncrypt(charSequence.toString()).equals(s);
	}

}
