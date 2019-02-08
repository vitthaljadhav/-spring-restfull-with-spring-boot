package guru.springframework.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.user.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
