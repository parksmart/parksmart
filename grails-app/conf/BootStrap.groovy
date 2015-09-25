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
            new User(username: "${it}@parksmart.com",
                    name: it,
                    password: "test",
                    mobileNumber: "9999999999"
            ).save(flush: true, failOnError: true)
        }
    }
}
