package net.code.java;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder; // PasswordEncoder'ı burada enjekte ediyoruz

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Veritabanından alınan hashlenmiş şifre
        String encodedPasswordFromDatabase = user.getPassword(); 

        // Kullanıcının girdiği şifreyi hashleyerek veritabanındakiyle karşılaştırma
        if (!passwordEncoder.matches(user.getPassword(), encodedPasswordFromDatabase)) {
            throw new UsernameNotFoundException("Invalid password");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), encodedPasswordFromDatabase, new ArrayList<>());
    }
}
