//package com.example.emart;
//
//
//import com.example.emart.user.User;
//import com.example.emart.user.UserRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.Optional;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//public class UserRepositoryTest {
//    @Autowired private UserRepository repo;
//
//    @Test
//    public void testAddNew(){
//        User user = new User();
//        user.setName("John Doe");
//        user.setEmail("johndoe@example.com");
//        user.setPassword("1234");
//        user.setAdmin(false);
//
//
//
//        User savedUser = repo.save(user);
//
//        Assertions.assertThat(savedUser).isNotNull();
//        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll(){
//        Iterable<User> users = repo.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);
//
//        for(User user:users){
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        Integer userId =1;
//        Optional<User> optionalUser = repo.findById(userId);
//        User user = optionalUser.get();
//        user.setName("Jane Doe");
//        repo.save(user);
//
//        User updatedUser = repo.findById(userId).get();
//        Assertions.assertThat(updatedUser.getName()).isEqualTo("Jane Doe");
//    }
//
//    @Test
//    public void testGet(){
//        Integer userId =1;
//        Optional<User> optionalUser = repo.findById(userId);
//
//        Assertions.assertThat(optionalUser).isPresent();
//        System.out.println(optionalUser.get());
//    }
//
//    @Test
//    public void testDelete(){
//        Integer userId =3;
//        repo.deleteById(userId);
//
//        Optional<User> optionalUser = repo.findById(userId);
//        Assertions.assertThat(optionalUser).isNotPresent();
//    }
//
//    @Test
//    public void testFindByEmail(){
//        String email = "dulthar@gmail.com";
//        User user = repo.findByEmail(email);
//        Assertions.assertThat(user).isNotNull();
//
//    }
//}
