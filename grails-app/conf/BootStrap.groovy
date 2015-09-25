import com.parksmart.User
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        switch (Environment?.current?.name) {
            case 'development':
            case 'qa':
                log.info("Dropping database... ")
                User.collection.getDB().dropDatabase()
                break;
        }
    }
    def destroy = {
    }
}
