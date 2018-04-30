package org.progect.service;

import org.project.dao.DAOText;
import org.project.dao.DaoMenu;
import org.project.dao.DaoStart;
import org.project.entity.MenuEntity;
import org.project.entity.StartEntity;
import org.project.entity.TextEntity;

import java.util.ArrayList;

public class ProjectService {
       private static final ProjectService INSTANCE = new ProjectService();
       public  StartEntity StartEntity () {
            return new StartEntity (
                   DaoStart.getInstance().getDaoStartName(),
                   DaoStart.getInstance().getDaoStartMassage()
                   );
        }

        public MenuEntity MenuEntity(){
                  return new  MenuEntity(
                          DaoMenu.getInstance().getDaoMenu()
                  );
        }

        public TextEntity TextEntity(){
            return new TextEntity(
                    DAOText.getInstance().getDAOText1(),
                    DAOText.getInstance().getDAOText2()
            );
        }

        public static ProjectService getInstance() {
            return INSTANCE;
        }
}
