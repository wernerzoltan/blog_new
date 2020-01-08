package final_blog.final_blog.repo;


import org.springframework.data.repository.CrudRepository;

import final_blog.final_blog.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email); //email alapján ezzel megkereshető egy felhasználó, ami visszaad egy User objektumot
	//a visszaadott User objektum alapján aztán a jelszó, role visszakereshető

	User findByFullName(String fullName);

}