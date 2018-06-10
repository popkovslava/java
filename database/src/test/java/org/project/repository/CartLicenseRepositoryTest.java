package org.project.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.config.TestConfiguration;
import org.project.entity.CartLicense;
import org.project.util.DatabaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class CartLicenseRepositoryTest {
    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private CartLicenseRepository cartLicenseRepository;

    @Before
    public void init() {
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", cartLicenseRepository);
    }

    @Test
    public void checkFindById() {
        assertNotNull("Collection is  empty", cartLicenseRepository.findById(1L));
    }

    @Test
    public void checkFindAllById() {
        List<Long> cartLicenses = new ArrayList<>();
        cartLicenses.add(1l);
        cartLicenses.add(2l);
        cartLicenses.add(3L);
        assertNotNull("Collection is  empty", cartLicenseRepository.findAllById(cartLicenses));
    }

    @Test
    public void findAll() {
        assertNotNull("Id is null", cartLicenseRepository.findAll());
    }

    @Test
    public void delete() {
        Iterable<CartLicense> lists = cartLicenseRepository.findAll();
        List<CartLicense> list1 = new ArrayList<>();
        for (CartLicense list : lists) {
            cartLicenseRepository.delete(list);
            list1.add(list);
        }
        assertTrue(list1.isEmpty());
    }
}