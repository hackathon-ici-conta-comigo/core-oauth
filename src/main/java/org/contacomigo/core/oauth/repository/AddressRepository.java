package org.contacomigo.core.oauth.repository;

import org.contacomigo.core.oauth.domain.Address;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Address entity.
 */
@SuppressWarnings("unused")
public interface AddressRepository extends JpaRepository<Address,String> {

    @Query("select address from Address address where address.user.email = ?#{principal.username}")
    List<Address> findByUserIsCurrentUser();

}
