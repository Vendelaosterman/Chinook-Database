package a2.database.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import a2.database.access.dao.ChinookDbDAO;

@Component
public class ChinookService implements ApplicationRunner {

    private final ChinookDbDAO chDao;

    @Autowired
    public ChinookService(ChinookDbDAO chDao){
        this.chDao = chDao;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception{
        chDao.testDatabaseConnection();
        // TODO Auto-genrated method stub
    }
    
}
