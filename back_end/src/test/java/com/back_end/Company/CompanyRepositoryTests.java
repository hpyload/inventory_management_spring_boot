package com.back_end.Company;

import com.back_end.entity.Company;
import com.back_end.repository.CompanyRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CompanyRepositoryTests {

    @Autowired
    private CompanyRepository companyRepository;
    private Company company;

    @BeforeEach
    void setupBeforeEach() {
        company = new Company();
        company.setName("John");
        company.setDescription("description");
        company.setEmail("email");
        company.setPhone("+212643545243");
        company.setWebsite("https://www.company.com");
    }

    @Test
    @DisplayName("Test saving a Company")
    void testSaveCompany() {

        Company savedCompany = companyRepository.save(company);

        assertTrue(savedCompany.getId() > 0);

        Company retrievedCompany = companyRepository.findById(savedCompany.getId()).orElse(null);
        assertNotNull(retrievedCompany);
        assertEquals(savedCompany.getId(), retrievedCompany.getId());

        assertEquals(savedCompany.getName(), retrievedCompany.getName());
        assertEquals(savedCompany.getDescription(), retrievedCompany.getDescription());
        assertEquals(savedCompany.getEmail(), retrievedCompany.getEmail());
        assertEquals(savedCompany.getPhone(), retrievedCompany.getPhone());
        assertEquals(savedCompany.getWebsite(), retrievedCompany.getWebsite());
    }

    @Test
    @DisplayName("Test deleting a Company")
    void testDeleteCompany() {
        Company company = new Company();
        company.setName("John");
        company.setDescription("description");
        company.setEmail("email");
        company.setPhone("+212643545243");
        company.setWebsite("https://www.company.com");

        Company savedCompany = companyRepository.save(company);

        Company retrievedCompany = companyRepository.findById(savedCompany.getId()).orElse(null);
        assertNotNull(retrievedCompany);
        assertEquals(savedCompany.getId(), retrievedCompany.getId());

        companyRepository.delete(retrievedCompany);
        Company deletedCompany = companyRepository.findById(savedCompany.getId()).orElse(null);
        assertNull(deletedCompany);
    }


}
