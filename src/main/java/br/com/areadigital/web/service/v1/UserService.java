package br.com.areadigital.web.service.v1;

import br.com.areadigital.db.dto.imp.UserDto;
import br.com.areadigital.db.mapper.imp.UserMapper;
import br.com.areadigital.db.model.User;
import br.com.areadigital.db.repository.UserRepository;
import br.com.areadigital.web.service.ABaseService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;


@Slf4j
@Data
@Service
@Transactional
@RequiredArgsConstructor
public class UserService extends ABaseService<UserDto,User,Long> implements UserDetailsService, Serializable {

    private static final long serialVersionUID = 1L;

    private final UserRepository repository;
    private final  UserMapper entityMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByEmail(username);
    }


}
