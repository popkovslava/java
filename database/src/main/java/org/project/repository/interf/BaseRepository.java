package org.project.repository.interf;

import java.io.Serializable;
import org.project.entity.Base;
import org.springframework.data.repository.CrudRepository;

interface BaseRepository<PK extends Serializable, T extends Base<PK>> extends CrudRepository<PK, T> {
}


