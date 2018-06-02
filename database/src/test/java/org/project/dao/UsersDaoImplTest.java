package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.UsersDao;
import org.project.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional
public class UsersDaoImplTest {

    @Autowired
    private UsersDao usersDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", usersDao);
    }

    @Test
    public void checkSaveEntity() {
        Users users = new Users();
        users.setName("test");
        Long id = usersDao.save(users);
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<Users> trademarks = usersDao.findAll();
        assertThat("Employees collection is not empty", trademarks, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        Users users = new Users();
        users.setName("test");
        Long id = usersDao.save(users);
        Users users1 = usersDao.findOne(id);
        assertNotNull("FindById does not work", users1);
    }
}