package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.RoleDao;
import org.project.entity.Role;
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
public class RoleDaoImplTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded",roleDao);
    }

    @Test
    public void checkSaveEntity() {
        Role role= new Role();
        role.setRole("Test");
        Long id = roleDao.save(role);
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<Role> roles=roleDao.findAll();
        assertThat("Employees collection is not empty",roles, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
         Role role= new Role();
        role.setRole("test");
        Long id =roleDao.save(role);
        Role menu1 =roleDao.findOne(id);
        assertNotNull("FindById does not work", menu1);
    }

}