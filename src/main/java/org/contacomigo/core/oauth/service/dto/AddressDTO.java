package org.contacomigo.core.oauth.service.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.contacomigo.core.oauth.domain.Address;
import org.contacomigo.core.oauth.domain.Location;

public class AddressDTO {
	private String id;
	
	@NotNull
    private String street;
    
    private String number;
    
    private String complement;

    @NotNull
    private String country;
    
    @NotNull
    private String city;

    private Location location;
    
    public AddressDTO() {}
    
    public AddressDTO(Address address) {
    	id = address.getId();
    	street = address.getStreet();
    	number = address.getNumber();
    	complement = address.getComplement();
    	country = address.getCountry();
    	city = address.getCity();
    	location = address.getLocation();
    }

    public String getStreet() {
        return street;
    }

    public AddressDTO street(String street) {
        this.street = street;
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public AddressDTO number(String number) {
        this.number = number;
        return this;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public AddressDTO complement(String complement) {
        this.complement = complement;
        return this;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCountry() {
        return country;
    }

    public AddressDTO country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public AddressDTO city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

    public AddressDTO location(Location location) {
        this.location = location;
        return this;
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Address toAddress() {
		return new Address()
			.id(id)
			.city(city)
			.complement(complement)
			.country(country)
			.location(location)
			.number(number)
			.street(street);
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddressDTO address = (AddressDTO) o;
        if (address.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), address.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Address{" +
            "id=" + getId() +
            ", street='" + street + "'" +
            ", number='" + number + "'" +
            ", complement='" + complement + "'" +
            ", country='" + country + "'" +
            ", city='" + city + "'" +
            '}';
    }
}
