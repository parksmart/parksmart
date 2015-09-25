import com.parksmart.User
import grails.util.Environment

class BootStrap {


    List<String> userNames = ['rohit', 'puneet', 'farid', 'manish', 'vaibhav', 'vivek']

    def init = { servletContext ->
        switch (Environment?.current?.name) {
            case 'development':
            case 'qa':
                log.info("Dropping database... ")
                User.collection.getDB().dropDatabase()
                bootstrapDummyData()
                break;
        }
    }
    def destroy = {
    }

    private void bootstrapDummyData(){
        createUsers()
    }

    private createUsers(){
        userNames?.each {
            new User(username: it, password: "test").save(flush: true, failOnError: true)
        }
    }
}
