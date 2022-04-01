/*
 * package com.uwu.cst18013_spring;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
 * import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
 * import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
 * import org.springframework.test.annotation.Rollback;
 * 
 * import com.uwu.cst18013_spring.doctor.entity.DoctorCategory; import
 * com.uwu.cst18013_spring.doctor.repo.DoctorCategoryRepository;
 * 
 * @DataJpaTest
 * 
 * @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
 * 
 * @Rollback(false) public class DoctorCategoryRepositoryTests {
 * 
 * @Autowired private DoctorCategoryRepository dcrepo;
 * 
 * @Autowired private TestEntityManager entityManager;
 * 
 * @Test public void testCreateDoctorCategory(){ DoctorCategory
 * savedDoctorCategory=dcrepo.save(new DoctorCategory("Ear Specialist"));
 * assertThat(savedDoctorCategory.getId()).isGreaterThan(0); } }
 */