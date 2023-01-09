package br.com.areadigital.config.components;

import br.com.areadigital.db.model.User;
import br.com.areadigital.db.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
@Getter
public class UserAuthenticate {
    private final UserRepository repository;

    public static User authenticated(UserRepository repository) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            return repository.findByEmail((String) principal);
        } catch (Exception e) {
            return null;
        }
    }
}
