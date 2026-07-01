JPA is just a spec. Literally just interfaces and annotations like @Entity, @Id — a set of rules saying "this is how Java ORM should work." It doesn't actually do anything on its own. No code that talks to a database, nothing.


Hibernate is what actually does the work. It's one implementation of that JPA spec (EclipseLink is another, but almost nobody uses it these days). Hibernate is the thing generating SQL, managing sessions, doing lazy loading, all that. Fun fact — Hibernate actually existed before JPA did, so it also has its own native API (Session, SessionFactory) that has nothing to do with JPA at all.


Spring Data JPA is Spring's way of saving you from writing repetitive DAO code. Instead of manually writing EntityManager queries every time, you just write an interface like this:


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


and Spring magically implements it for you at runtime. You never see the actual implementation class — it's generated behind the scenes.


Basic way to think about it: JPA is the contract, Hibernate is the guy who actually builds the house, and Spring Data JPA is the manager who talks to the contractor so you don't have to.
