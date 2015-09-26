import com.parksmart.Advertisement
import com.parksmart.Role
import com.parksmart.TestUtil
import com.parksmart.User
import com.parksmart.UserRole
import grails.mongodb.geo.Point
import grails.util.Environment

class BootStrap {

    List<String> userNames = ['rohit', 'puneet', 'farid', 'manish', 'vaibhav', 'vivek']
    def advertisementService

    def init = { servletContext ->
        switch (Environment?.current?.name) {
            case 'development':
            case 'qa':
                log.info("Dropping database... ")
                Advertisement.collection.getDB().dropDatabase()
                bootstrapDummyData()
                break;
        }
    }
    def destroy = {
    }

    private void bootstrapDummyData(){
        createUsers()
        TestUtil.createAdvertisements()
        Advertisement.list()?.each {
            advertisementService.createAvailabilities(it)
        }
    }

    private createUsers(){
        Role userRole = new Role('ROLE_USER').save(flush: true, failOnError: true)
        userNames?.each {
            User user = new User(username: "${it}@parksmart.com",
                    name: it,
                    password: "test",
                    mobileNumber: "9999999999"
            ).save(flush: true, failOnError: true)
            UserRole.create(user, userRole, true )
        }
    }



}
