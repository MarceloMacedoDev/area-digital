package br.com.areadigital.db.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A class representing a person.
 *
 * @author Your Name
 */

@Data
@Builder
@Entity(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable, UserDetails, IBaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier for the person.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The person's first name.
     */
    private String firstname;

    /**
     * The person's last name.
     */
    private String lastname;

    /**
     * The person's email address.
     */
    @Column(unique = true)
    private String email;

    /**
     * The person's password.
     */
    private String password;

    /**
     * The person's contact information.
     */
//    @Embedded
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @Column(name = "id")
//    private Contato contato;

    /**
     * The person's address. e
     */
//    @Embedded
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @Column(name = "id")
//    private Endereco endereco;

    /**
     * The roles this person has.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



    /**
     * Returns the roles this person has.
     *
     * @return a collection of {@link GrantedAuthority} objects representing the roles this person has
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }

    /**
     * Returns the person's password.
     *
     * @return the person's password
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the person's email address.
     *
     * @return the person's email address
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    /**
     * Returns {@code true} if the credentials (password) has not expired.
     *
     * @return {@code true} if the credentials has not expired, {@code false} otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Returns {@code true} if the account is enabled.
     *
     * @return {@code true} if the account is enabled, {@code false} otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }


}